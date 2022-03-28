package com.team11.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.pojo.dto.Role;

public interface RoleManageService extends IService<Role> {
    RespBean SelAllRole();
    RespBean TermSelRole(String roleName);
    RespBean InsertRole(String roleName);
    RespBean UpdateRole(Role role);
    RespBean DeleteRole(Integer roleId);
}
