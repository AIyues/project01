package com.team11.server.controller;
import com.team11.server.pojo.dto.AdminLoginParam;
import com.team11.server.pojo.dto.ChangePwd;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.pojo.dto.Users;
import com.team11.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
/**
 * <p>
 *  前端控制器
 * </p>
 * @author pjc
 * @since 2021-06-13
 */

@RestController
@Api(tags = "用户登录")
public class AdminController {
    @Resource
    private IAdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginPram, HttpServletRequest request){
        return adminService.login(adminLoginPram.getUsername(),adminLoginPram.getPassword(),adminLoginPram.getCode(),request);
    }

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/admin/info")
    public Users getAdminInfo(Principal principal){
        if(null==principal){
            return null;
        }
        String username = principal.getName();
        Users user =adminService.getAdminByRId(username);
        user.setRPassword(null);
        user.setRPassword(null);
        return user;
    }
    @ApiOperation(value = "退出登录" )
    @PostMapping("/logout")
    public RespBean logout(){
        return RespBean.success("注销成功!");
    }
    @ApiOperation(value = "更新登录密码")
    @PostMapping("/changePassword")
    public RespBean ChangePassword( ChangePwd changePwd, HttpServletRequest request) {
        return adminService.changPasswordById(changePwd.getId(), changePwd.getNewPassword(), request);
    }
}
