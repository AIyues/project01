package com.team11.server.mapper;
import com.team11.server.pojo.dto.menuBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface MenuManageMapper {
    List<menuBean> SelAllMenu();
    List<menuBean> SelMenuById(Integer id);
    List<Integer> SelMenuIdByRoleId(Integer id);
    Integer DeleteMenusById(Integer id);
    Integer InsertMenusById(@Param("rid") Integer rid,@Param("mids") Integer[] mids);
}
