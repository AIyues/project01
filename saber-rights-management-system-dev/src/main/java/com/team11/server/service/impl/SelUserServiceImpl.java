package com.team11.server.service.impl;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.team11.server.mapper.SelAllUser;
import com.team11.server.mapper.UserManageMapper;
import com.team11.server.pojo.dto.ExcelUsers;
import com.team11.server.pojo.dto.RespPageBean;
import com.team11.server.pojo.dto.Users;
import com.team11.server.service.SelUserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Service
public class SelUserServiceImpl implements SelUserService {
    @Resource
    private SelAllUser selAllUser;

    @Resource
    private UserManageMapper userManageMapper;

    @Override
    public RespPageBean SelUser(Integer currentPage, Integer size) {
        QueryWrapper<Users> wrapper= new QueryWrapper<>();
        wrapper.eq("is_delete",1);
        Page<Users> page=new Page<>(currentPage,size);
        IPage<Users> usersByPage=selAllUser.selectPage(page,wrapper);
        return new RespPageBean(usersByPage.getTotal(),usersByPage.getRecords());
    }


    @Override
    public void SelUserToExcel(HttpServletResponse response) throws IOException {
        //获取数据
        List<ExcelUsers> users=userManageMapper.SelUsersToExcel();
        //导出excel
        //参数1：exportParams 导出配置对象  参数2：导出类型  参数3：导出的数据集合
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户列表", "用户信息",ExcelType.HSSF),  ExcelUsers.class, users);
        //设置响应头
        response.setHeader("Content-Type","application/octet-stream");
        response.setHeader("Content-Disposition","attachment;fileName="+URLEncoder.encode("用户表.xls","UTF-8"));

        //response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode("用户列表.xls","utf-8"));
        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
    }
}
