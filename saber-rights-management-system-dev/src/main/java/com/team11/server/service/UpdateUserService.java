package com.team11.server.service;

import com.team11.server.pojo.dto.RespBean;

import java.util.HashMap;

public interface UpdateUserService {
    RespBean updateUser(HashMap<String,Object> hashMap);
}
