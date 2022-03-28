package com.team11.server.service.impl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.team11.server.mapper.RoleManageMapper;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.pojo.dto.Role;
import com.team11.server.service.RoleManageService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class RoleManageServiceImpl extends ServiceImpl<RoleManageMapper, Role> implements RoleManageService {
    @Resource
    private RoleManageMapper roleManageMapper;

    @Override
    public RespBean SelAllRole() {
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("isdelete",1);
        List<Role> roleList =roleManageMapper.selectByMap(hashMap);
        return RespBean.success("", roleList);
    }

    @Override
    public RespBean TermSelRole(String roleName) {
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("isdelete",1);
        hashMap.put("role_name",roleName);
        return RespBean.success("",roleManageMapper.selectByMap(hashMap));
    }

    @Override
    public RespBean InsertRole(String roleName) {
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("isdelete",1);
        hashMap.put("role_name",roleName);
        Role role=new Role();
        role.setRoleName(roleName);
        if (roleManageMapper.selectByMap(hashMap).size()==0){
            roleManageMapper.insert(role);
            return RespBean.success("新增成功");
        }
        else {
            return RespBean.error("该角色已存在");
        }
    }

    @Override
    public RespBean UpdateRole(Role role) {
        UpdateWrapper<Role> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("role_id",role.getRoleId()).set("role_name",role.getRoleName());
        roleManageMapper.update(null,updateWrapper);
        return RespBean.success("修改成功");
    }

    @Override
    public RespBean DeleteRole(Integer roleId) {
        UpdateWrapper<Role> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("role_id",roleId).set("isdelete",0);
        roleManageMapper.update(null,updateWrapper);
        return RespBean.success("删除成功");
    }
}
