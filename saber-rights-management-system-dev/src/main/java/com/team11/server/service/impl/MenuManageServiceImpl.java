package com.team11.server.service.impl;
import com.team11.server.mapper.MenuManageMapper;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.MenuManageService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class MenuManageServiceImpl implements MenuManageService {
    @Resource
    private MenuManageMapper menuManageMapper;

    @Override
    public RespBean selAllMenu() {
        return RespBean.success("",menuManageMapper.SelAllMenu());
    }

    @Override
    public RespBean selMenuById(Integer id) {
        return RespBean.success("",menuManageMapper.SelMenuById(id));
    }

    @Override
    public RespBean SelMenuIdByRoleId(Integer id) {
        return RespBean.success("",menuManageMapper.SelMenuIdByRoleId(id));
    }

    @Override
    public RespBean DeleteMenusById(Integer id) {
        menuManageMapper.DeleteMenusById(id);
        return RespBean.success("");
    }

    @Override
    public RespBean InsertMenusById(Integer rid, Integer[] mids) {
        menuManageMapper.InsertMenusById(rid,mids);
        return RespBean.success("更新成功");
    }


}
