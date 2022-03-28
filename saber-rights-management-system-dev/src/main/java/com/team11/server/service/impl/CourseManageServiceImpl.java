package com.team11.server.service.impl;
import com.team11.server.mapper.CourseManageMapper;
import com.team11.server.pojo.dto.Course;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.CourseManageService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class CourseManageServiceImpl implements CourseManageService {
    @Resource
    private CourseManageMapper courseManageMapper;


    @Override
    public RespBean SqlAllCourse() {
            List<Course> courses=courseManageMapper.SelAllCourse();
            return RespBean.success("ok",courses);

    }

    @Override
    public RespBean InsertStuToCourse(HashMap<String, Object> hashMap) {
        if (courseManageMapper.SelCountCourse(hashMap)>0){
            return RespBean.error("该课已选");
        }
        else {
            courseManageMapper.InsertStuToCourse(hashMap);
            return RespBean.success("选课成功");
        }
    }
}
