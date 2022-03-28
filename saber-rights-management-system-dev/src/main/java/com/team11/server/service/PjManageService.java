package com.team11.server.service;

import com.team11.server.pojo.dto.RespBean;

import java.util.HashMap;


public interface PjManageService {
    RespBean InsertPj(HashMap<String,Object> hashMap);
    RespBean SelPjByTid(String rid);
}
