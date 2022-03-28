package com.team11.server.service;
import com.team11.server.pojo.dto.ExcelUsers;
import com.team11.server.pojo.dto.RespBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

public interface UserManageService {
    RespBean termSelUser(HashMap<String,Object> hashMap);
    // 导入用户信息
    void importUser(ExcelUsers excelUsers);
    //查询导入的用户是否已存在
    Integer SelUser(String userId);
    //若用户已存在则删除该用户再插入
    void DeleteUser(String userId);

    RespBean excelInUser(MultipartFile excelFile) throws Exception;
}
