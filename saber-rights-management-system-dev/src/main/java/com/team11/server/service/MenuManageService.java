package com.team11.server.service;
import com.team11.server.pojo.dto.RespBean;


public interface MenuManageService {
    RespBean selAllMenu();
    RespBean selMenuById(Integer id);
    RespBean SelMenuIdByRoleId(Integer id);
    RespBean DeleteMenusById(Integer id);
    RespBean InsertMenusById(Integer rid,Integer[] mids);
}
