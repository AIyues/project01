package com.team11.server.controller;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.pojo.dto.RespPageBean;
import com.team11.server.pojo.dto.Users;
import com.team11.server.service.InsertUserService;
import com.team11.server.service.SelUserService;
import com.team11.server.service.UpdateUserService;
import com.team11.server.service.UserManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@RestController
@Api(tags = "用户管理")
public class UserController {
    @Resource
    private UserManageService userManageService;
    @Resource
    private SelUserService selUserService;
    @Resource
    private InsertUserService insertUserService;
    @Resource
    private UpdateUserService updateUserService;
    @ApiOperation("获取用户列表")
    @GetMapping("/selUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPage",value = "当前页",required = true,defaultValue = "1"),
            @ApiImplicitParam(name = "size",value = "每页数量",required = true,defaultValue ="5")
    })
    public RespPageBean SelUser(Integer currentPage, Integer size){
        return selUserService.SelUser(currentPage,size);
    }

    @ApiOperation("新增用户")
    @PostMapping("/insertUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rId",value = "账户",required = true),
            @ApiImplicitParam(name = "name",value = "姓名",required = true),
            @ApiImplicitParam(name = "rPassword",value = "密码",required = true),
            @ApiImplicitParam(name = "tType",value = "用户类型(0:普通用户,1:管理员)",required = true)

    })
    public RespBean InsertUser(@RequestBody HashMap<String,Object> map){
        return insertUserService.insertUser(map);
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/updateUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户id",required = true),
            @ApiImplicitParam(name = "name",value = "姓名"),
            @ApiImplicitParam(name = "tType",value = "用户类型(0:普通用户,1:管理员)"),
            @ApiImplicitParam(name = "state",value = "是否启用(1:启用,0:封禁)"),
            @ApiImplicitParam(name = "idCard",value = "身份证"),
            @ApiImplicitParam(name = "email",value = "邮箱"),
            @ApiImplicitParam(name = "phone",value = "电话号码"),
            @ApiImplicitParam(name = "sex",value = "性别(0:男,1:女)")
    })
    public RespBean updateUser( @RequestBody HashMap<String,Object> hashMap){

//        hashMap.put("userId",userId);
//        hashMap.put("name",name);
//        hashMap.put("tType",tType);
//        hashMap.put("state",state);
//        hashMap.put("idCard",idCard);
//        hashMap.put("email",email);
//        hashMap.put("phone",phone);
//        hashMap.put("sex",sex);
        return  updateUserService.updateUser(hashMap);
    }
    @ApiOperation("删除用户(逻辑删除)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true)
    })
    @PostMapping("/deleteUser")
    public RespBean deleteUser( @RequestParam Integer id){
        Integer deleteNum=0;
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("deleteNum",deleteNum);
        hashMap.put("id",id);
        return  updateUserService.updateUser(hashMap);
    }

    @ApiOperation("条件查询用户")
    @PostMapping("/TermSelUser")
    public RespBean termSelUser( @RequestBody HashMap<String,Object> hashMap){
        return  userManageService.termSelUser(hashMap);
    }

    @ApiOperation(value = "导出用户信息",produces = "application/octet-stream")
    @GetMapping("/ExportUsers")
    public void selToExcel(HttpServletResponse response) throws IOException {
        selUserService.SelUserToExcel(response);
    }

    @ApiOperation("导入用户信息")
    @PostMapping("/ImportUsers")
    public RespBean importToUser(@RequestPart(value = "file")MultipartFile excelFile) throws Exception {
        return  userManageService.excelInUser(excelFile);
    }

}
