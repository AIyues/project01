package com.team11.server.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team11.server.pojo.dto.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface CourseManageMapper extends BaseMapper<Course> {
    List<Course> SelAllCourse();

    Integer SelCountCourse(HashMap<String,Object> hashMap);

    void InsertStuToCourse(HashMap<String,Object> hashMap);
}
