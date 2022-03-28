package com.team11.server.service.impl;
import com.team11.server.mapper.PjManageMapper;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.PjManageService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class PjManageServiceImpl implements PjManageService {
    @Resource
    private PjManageMapper pjManageMapper;

    @Override
    public RespBean InsertPj(HashMap<String, Object> hashMap) {
        if(pjManageMapper.SelPj(hashMap)==0) {
            pjManageMapper.InsertPj(hashMap);
            return RespBean.success("执行成功！");
        }
        else {
            return RespBean.error("你已经评教过了");
        }

    }

    @Override
    public RespBean SelPjByTid(String rid) {
        return RespBean.success("",pjManageMapper.SelPjByTid(rid));
    }
}
