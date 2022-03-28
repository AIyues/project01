package com.team11.server.pojo.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiOperation("获取老师检查作业列表")
public class CheckWork {

    @NotEmpty(message = "分数不能为空")
    @ApiModelProperty(value = "分数")
    private Float score;

    @NotEmpty(message = "id不能为空")
    @ApiModelProperty(value = "作业提交表")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer homeworkId;

    @ApiModelProperty(value = "附件地址")
    @TableField("c_file")
    private String cFile;

    @ApiModelProperty(value = "附件名称")
    @TableField("c_f_name")
    private String cFName;

    @ApiModelProperty(value = "批复内容")
    @TableField("reply")
    private String reply;

    @ApiModelProperty(value = "作业状态")
    @TableField("status")
    private Integer status;
}
