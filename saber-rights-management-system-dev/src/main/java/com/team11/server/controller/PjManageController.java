package com.team11.server.controller;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.PjManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
@RestController
@Api(tags = "评教管理")
public class PjManageController {
    @Resource
    private PjManageService pjManageService;
    @ApiOperation("插入评教信息")
    @PostMapping("/InsertPj")
    public RespBean InsertPj(@RequestBody HashMap<String,Object> hashMap){
        return pjManageService.InsertPj(hashMap);
    }
    @ApiOperation("教师查询自己的评教信息")
    @PostMapping("/SelPjByTid")
    public RespBean SelPjByTid(@RequestParam String rid){
        return pjManageService.SelPjByTid(rid);
    }
}
