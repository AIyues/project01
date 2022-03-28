package com.team11.server.controller;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.pojo.dto.Role;
import com.team11.server.service.RoleManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@Api(tags = "角色管理")
public class RoleManageController {
    @Resource
    private RoleManageService roleManageService;
    @ApiOperation("查询角色列表")
    @GetMapping("/selAllRole")
    public RespBean selAllRole(){
      return   roleManageService.SelAllRole();
    }

    @ApiOperation("条件查询角色")
    @PostMapping("/TermSelRole")
    public RespBean termSelRole(@RequestParam String roleName){
        return  roleManageService.TermSelRole(roleName);
    }

    @ApiOperation("新增角色")
    @PostMapping("/InsertRole")
    public RespBean insertRole(@RequestParam String roleName){
        return  roleManageService.InsertRole(roleName);
    }

    @ApiOperation("编辑角色")
    @PostMapping("/UpdateRole")
    public RespBean updateRole(@RequestBody Role role){
        return  roleManageService.UpdateRole(role);
    }

    @ApiOperation("删除角色")
    @PostMapping("/DeleteRole")
    public RespBean deleteRole(@RequestParam Integer roleId){
        return  roleManageService.DeleteRole(roleId);
    }
}
