package com.team11.server.mapper;
import com.team11.server.pojo.dto.EquipBean;
import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface EquipManageMapper {
   //查询所有设备信息
   List<EquipBean> GetAllEquip();
   //更新设备信息
   void UpdateEquip(HashMap<String,Object> hashMap);
   //新增设备信息
   void InsertEquip(HashMap<String,Object> hashMap);
   //删除设备信息
   void DeleteEquip(Integer id);
}
