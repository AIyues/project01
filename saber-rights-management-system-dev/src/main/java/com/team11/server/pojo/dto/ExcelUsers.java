package com.team11.server.pojo.dto;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ExcelTarget("userExcel")
@ApiModel(value = "用户列表对象",description = "")
public class ExcelUsers {

    @ApiModelProperty(value = "id",required = true)
    @TableField("id")
    private Integer id;

    @ApiModelProperty(value = "用户名",required = true)
    @Excel(name = "用户名")
    private String username;

    @ApiModelProperty(value = "账号",required = true)
    @Excel(name = "账号")
    private String userId;

    @ApiModelProperty(value = "密码",required = true)
    @Excel(name = "密码")
    private String password;

    @ApiModelProperty(value = "性别:0男 1女",required = true)
    @Excel(name = "性别:0男 1女")
    private Integer sex;

    @ApiModelProperty(value = "身份证",required = true)
    @Excel(name = "身份证")
    private String idCard;

    @ApiModelProperty(value = "邮箱",required = true)
    @Excel(name = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话",required = true)
    @Excel(name = "电话")
    private String phone;

    @ApiModelProperty(value = "身份类型",required = true)
    @Excel(name = "身份类型")
    private Integer type;


    @ApiModelProperty(value = "状态",required = true)
    @Excel(name = "状态")
    private Integer state;
}
