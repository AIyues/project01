package com.team11.server.service;
import com.team11.server.pojo.dto.RespPageBean;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface SelUserService  {

    RespPageBean SelUser(Integer currentPage, Integer size);
    void SelUserToExcel(HttpServletResponse response) throws IOException;

}
