package com.team11.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team11.server.pojo.dto.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleManageMapper extends BaseMapper<Role> {
}
