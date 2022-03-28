package com.team11.server.service.impl;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.team11.server.mapper.UserManageMapper;
import com.team11.server.pojo.dto.ExcelUsers;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.UserManageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserManageServiceImpl implements UserManageService {
    @Resource
    private UserManageMapper userManageMapper;

    @Override
    public RespBean termSelUser(HashMap<String, Object> hashMap) {
        return RespBean.success("查询成功",userManageMapper.TermSelUser(hashMap));
    }

    // 导入用户信息
    @Override
    public void importUser(ExcelUsers excelUsers) {
        userManageMapper.importUser(excelUsers);
    }

    //查询导入的用户是否已存在
    @Override
    public Integer SelUser(String userId) {
        return userManageMapper.SelUser(userId);
    }

    //若用户已存在则删除该用户再插入
    @Override
    public void DeleteUser(String userId) {
        userManageMapper.DeleteUser(userId);
    }


    public RespBean excelInUser(MultipartFile excelFile) throws Exception {
        int t=0;
        //excel导入
        ImportParams params=new ImportParams();
        params.setHeadRows(1);
        params.setTitleRows(1);
        //获取excel上的信息
        List<ExcelUsers> users= ExcelImportUtil.importExcel(excelFile.getInputStream(),ExcelUsers.class,params);
        for (ExcelUsers excelUsers:users){
            if (SelUser(excelUsers.getUserId())>0){
                DeleteUser(excelUsers.getUserId());
            }
            importUser(excelUsers);
            t++;
        }
        return RespBean.success("插入了"+t+"条数据");
    }

}
