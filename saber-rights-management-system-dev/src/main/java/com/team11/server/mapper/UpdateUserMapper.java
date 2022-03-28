package com.team11.server.mapper;
import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;
@Mapper
public interface UpdateUserMapper {
    void updateUser(HashMap<String,Object> hashMap);
}
