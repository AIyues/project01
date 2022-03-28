package com.team11.server.mapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;

@Mapper
public interface InsertUserMapper{
    void insertUser(HashMap<String,Object> hashMap);
}
