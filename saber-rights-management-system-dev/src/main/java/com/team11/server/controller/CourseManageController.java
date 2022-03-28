package com.team11.server.controller;
import com.team11.server.pojo.dto.RespBean;
import com.team11.server.service.CourseManageService;
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
@Api(tags = "课程管理")
public class CourseManageController {
    @Resource
    private CourseManageService courseManageService;
    @ApiOperation("查询所有课程")
    @GetMapping("/selAllCourse")
    public RespBean selAllCourse(){
        return courseManageService.SqlAllCourse();
    }

    @ApiOperation("学生选课")
    @PostMapping("/InsertStudentToCourse")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId",value = "课程id",required = true),
            @ApiImplicitParam(name = "studentId",value = "学生id",required = true)
    })
    public RespBean InsertStuDCourse( Integer courseId, Integer studentId){
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("courseId",courseId);
        hashMap.put("studentId",studentId);
        return courseManageService.InsertStuToCourse(hashMap);
    }
}
