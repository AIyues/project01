package com.team11.server.mapper;
import com.team11.server.pojo.dto.Course;
import com.team11.server.pojo.dto.ExcelUsers;
import com.team11.server.pojo.dto.Users;
import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;
import java.util.List;
@Mapper
public interface UserManageMapper {
   List<Users> TermSelUser (HashMap<String,Object> hashMap);
   List<ExcelUsers> SelUsersToExcel();
   // 导入用户信息
   void importUser(ExcelUsers excelUsers);
   //查询导入的用户是否已存在
   Integer SelUser(String userId);
   //若用户已存在则删除该用户再插入
   void DeleteUser(String userId);

   List<Course> SelAllCourse();
}
