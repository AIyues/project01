package com.team11.server.controller;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.MenuManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.Arrays;

@RestController
@Api(tags = "菜单管理")
public class MenuManageController {
    @Resource
    private MenuManageService menuManageService;
    @ApiOperation("查询所有菜单")
    @GetMapping("/SelAllMenu")
    public RespBean selAllMenu(){
        return menuManageService.selAllMenu();
    }

    @ApiOperation("根据用户id查询菜单")
    @PostMapping("/SelMenuById")
    public RespBean selMenuById(@RequestParam Integer id){
        return menuManageService.selMenuById(id);
    }

    @ApiOperation("根据用户id查询菜单id")
    @PostMapping("/SelMenuIdById")
    public RespBean selMenuIdById(@RequestParam Integer id){
        return menuManageService.SelMenuIdByRoleId(id);
    }

    @ApiOperation("更新角色菜单")
    @PostMapping("/UpdateMenus")
    public RespBean UpdateMenusById(Integer rid,Integer[] mids){
        System.out.println(Arrays.toString(mids));
        menuManageService.DeleteMenusById(rid);
        menuManageService.InsertMenusById(rid,mids);
        return RespBean.success("更新成功");
    }
}
