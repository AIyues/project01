package com.team11.server.service.impl;
import com.team11.server.mapper.EquipManageMapper;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.EquipManageService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class EquipManageServiceImpl implements EquipManageService {
    @Resource
    private EquipManageMapper equipManageMapper;

    //查询所有设备信息
    @Override
    public RespBean GetAllEquip() {
        return  RespBean.success("",equipManageMapper.GetAllEquip());
    }
    //更新设备信息
    @Override
    public RespBean UpdateEquip(HashMap<String,Object> hashMap) {
        equipManageMapper.UpdateEquip(hashMap);
        return RespBean.success("");
    }

    //新增设备信息
    @Override
    public RespBean InsertEquip(HashMap<String, Object> hashMap) {
        equipManageMapper.InsertEquip(hashMap);
        return RespBean.success("");
    }

    //删除设备信息
    @Override
    public RespBean DeleteEquip(Integer id) {
        equipManageMapper.DeleteEquip(id);
        return RespBean.success("");
    }
}
