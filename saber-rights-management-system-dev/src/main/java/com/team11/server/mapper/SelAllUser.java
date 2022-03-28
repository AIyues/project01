package com.team11.server.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team11.server.pojo.dto.ExcelUsers;
import com.team11.server.pojo.dto.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelAllUser extends BaseMapper<Users> {
}
