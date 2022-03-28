package com.team11.server.service.impl;

import com.team11.server.mapper.UpdateUserMapper;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.UpdateUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
@Service
public class UpdateUserServiceImpl implements UpdateUserService {
    @Resource
    private UpdateUserMapper updateUserMapper;
    @Override
    public RespBean updateUser(HashMap<String, Object> hashMap) {
        updateUserMapper.updateUser(hashMap);
        return RespBean.success("修改成功");
    }
}
