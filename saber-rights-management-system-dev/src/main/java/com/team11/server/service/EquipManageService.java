package com.team11.server.service;
import com.team11.server.pojo.dto.RespBean;

import java.util.HashMap;

public interface EquipManageService {
    //查询所有设备信息
    RespBean GetAllEquip();
    //更新设备信息
    RespBean UpdateEquip(HashMap<String,Object> hashMap);
    //新增设备信息
    RespBean InsertEquip(HashMap<String,Object> hashMap);
    //删除设备信息
    RespBean DeleteEquip(Integer id);

}
