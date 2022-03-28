package com.team11.server.service;
import com.team11.server.pojo.dto.RespBean;

import java.util.HashMap;

public interface CourseManageService {
    RespBean SqlAllCourse();
    RespBean InsertStuToCourse(HashMap<String,Object> hashMap);
}
