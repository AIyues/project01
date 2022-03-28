package com.team11.server.mapper;

import com.team11.server.pojo.dto.PjTeacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PjManageMapper {
    void InsertPj(HashMap<String,Object> hashMap);
    Integer SelPj(HashMap<String,Object> hashMap);
    List<PjTeacher> SelPjByTid(String rid);
}
