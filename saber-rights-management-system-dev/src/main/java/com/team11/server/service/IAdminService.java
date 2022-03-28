package com.team11.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.pojo.dto.Users;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author pjc
 * @since 2021-06-13
 */
public interface IAdminService extends IService<Users> {

    /**
     * 登录之后返回token
     * @param rId
     * @param rPassword
     * @param request
     * @return
     */
    RespBean login(String rId, String rPassword,String code, HttpServletRequest request);
    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Users getAdminByRId(String username);
    /**
     * 根据id修改密码
     * @param id
     * @param newPassword
     * @param request
     * @return
     */
    RespBean changPasswordById(Integer id, String newPassword, HttpServletRequest request);
}
