package com.team11.server.service.impl;
import com.team11.server.mapper.DeptManageMapper;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.DeptManageService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class DeptManageServiceImpl implements DeptManageService {
    @Resource
    private DeptManageMapper deptManageMapper;
    @Override
    public RespBean selAllDept() {
        return RespBean.success("",deptManageMapper.selectList(null));
    }
}
