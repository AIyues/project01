package com.team11.server.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author gch
 * @since 2021-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pj_t_s")
@ApiModel(value="PjTS对象", description="")
public class PjTS implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @ApiModelProperty(value = "评教分数")
    @TableField("pj_core")
    private Integer pjCore;

    @ApiModelProperty(value = "评教老师")
    @TableField("pj_teacher")
    private String pjTeacher;

    @ApiModelProperty(value = "评教学生")
    @TableField("pj_student")
    private String pjStudent;


}
