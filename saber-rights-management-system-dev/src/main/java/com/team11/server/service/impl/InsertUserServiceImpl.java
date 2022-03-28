package com.team11.server.service.impl;
import com.team11.server.mapper.InsertUserMapper;
import com.team11.server.pojo.dto.InsertUserBean;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.InsertUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class InsertUserServiceImpl  implements InsertUserService {
    @Resource
    private InsertUserMapper insertUserMapper;
    @Override
    public RespBean insertUser(HashMap<String,Object> hashMap) {
        insertUserMapper.insertUser(hashMap);
        return RespBean.success("新增成功");
    }

}
