package com.team11.server.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team11.server.pojo.dto.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptManageMapper extends BaseMapper<Department> {
}
