package com.team11.server.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team11.server.pojo.dto.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pjc
 * @since 2021-06-13
 */
@Mapper
public interface AdminMapper extends BaseMapper<Users> {
}
