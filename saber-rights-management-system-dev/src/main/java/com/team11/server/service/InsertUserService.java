package com.team11.server.service;
import com.team11.server.pojo.dto.RespBean;

import java.util.HashMap;

public interface InsertUserService{
    RespBean insertUser(HashMap<String,Object> hashMap);

}
