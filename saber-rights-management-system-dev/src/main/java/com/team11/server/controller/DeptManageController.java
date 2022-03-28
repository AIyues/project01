package com.team11.server.controller;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.DeptManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@Api(tags = "院系管理")
public class DeptManageController {
    @Resource
    private DeptManageService deptManageService;
    @ApiOperation("获取院系列表")
    @GetMapping("/selAllDept")
    public RespBean selAllDept(){
        return deptManageService.selAllDept();
    }
}
