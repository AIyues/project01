package com.team11.server.controller;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.EquipManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@Api(tags = "设备管理")
public class EquipManageController {
    @Resource
    private EquipManageService equipManageService;

    @ApiOperation("查询所有设备")
    @GetMapping("/getAllEquip")
    public RespBean getAllEquip(){
        return equipManageService.GetAllEquip();
    }

    @ApiOperation("更新设备信息")
    @PostMapping("/updateEquip")
    public RespBean updateEquip(Integer id,String equipName,String equipType,String equipModel,Integer equipNum){
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("id",id);
        hashMap.put("equipName",equipName);
        hashMap.put("equipType",equipType);
        hashMap.put("equipModel",equipModel);
        hashMap.put("equipNum",equipNum);
        return equipManageService.UpdateEquip(hashMap);
    }

    @ApiOperation("新增设备信息")
    @PostMapping("/insertEquip")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "equipName",value = "设备名称",required = true),
            @ApiImplicitParam(name = "equipType",value = "设备类型",required = true),
            @ApiImplicitParam(name = "equipModel",value = "设备型号",required = true),
            @ApiImplicitParam(name = "equipNum",value = "设备剩余数量",required = true)
    })
    public RespBean insertEquip(String equipName,String equipType,String equipModel,Integer equipNum){
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("equipName",equipName);
        hashMap.put("equipType",equipType);
        hashMap.put("equipModel",equipModel);
        hashMap.put("equipNum",equipNum);
        return equipManageService.InsertEquip(hashMap);
    }

    @ApiOperation("删除设备信息")
    @PostMapping("/deleteEquip")
    @ApiImplicitParam(name = "id",value = "设备id",required = true)
    public RespBean deleteEquip(Integer id){
        return equipManageService.DeleteEquip(id);
    }
}

