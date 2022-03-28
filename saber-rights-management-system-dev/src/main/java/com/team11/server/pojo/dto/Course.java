package com.team11.server.pojo.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author gch
 * @since 2021-10-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Course对象", description="")
public class Course{

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "课程名")
    private String courseName;

    @ApiModelProperty(value = "课程类型(1：必修  0:选修)")
    private Integer courseType;


    @ApiModelProperty(value = "教师姓名")
    private String teacherName;

    @ApiModelProperty(value = "院系名")
    private String deptName;

}
