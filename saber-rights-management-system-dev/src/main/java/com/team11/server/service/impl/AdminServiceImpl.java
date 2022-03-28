package com.team11.server.service.impl;
import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team11.server.config.security.JwtTokenUtil;
import com.team11.server.mapper.AdminMapper;
import com.team11.server.pojo.dto.Users;
import com.team11.server.service.IAdminService;
import com.team11.server.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.team11.server.pojo.dto.RespBean;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author pjc
 * @since 2021-06-13
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper,Users> implements IAdminService {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public RespBean login(String username, String password, String code,HttpServletRequest request) {
        String captcha= (String) request.getSession().getAttribute("verifyCode");
        if (StringUtils.isEmpty(captcha)||!captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码输入错误");
        }
        //登录
        System.out.println(passwordEncoder.encode(password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails == null || !passwordEncoder.matches(password, userDetails.getPassword())) {
            return RespBean.error("用户名或密码不正确！");
        }
        if (!userDetails.isEnabled()) {
            return RespBean.error("账号被禁用，请联系管理员！");
        }

        Integer type = adminMapper.selectOne(new QueryWrapper<Users>().eq("r_id", username)).getTType();

        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);  // 把token放在全局

        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        tokenMap.put("type",type.toString());
        return RespBean.success("登陆成功！", tokenMap);
    }

    @Override
    public Users getAdminByRId(String username) {
        return adminMapper.selectOne(new QueryWrapper<Users>().eq("r_id", username));
    }

    @Override
    public RespBean changPasswordById(Integer id, String newPassword, HttpServletRequest request) {
        if(passwordEncoder.matches(newPassword,
                (adminMapper.selectOne(new QueryWrapper<Users>().eq("id", id))).getPassword())){
            return RespBean.error("新密码与原密码输入一致，请重新输入");
        }
        Users user =  new Users();
        user.setRPassword(passwordEncoder.encode(newPassword));
        user.setId(id);
        adminMapper.updateById(user);
        return RespBean.success("修改成功!");
    }

}
