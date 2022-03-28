package com.team11.server.pojo.dto;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "新增用户对象",description = "")
public class InsertUserBean {
    @ApiModelProperty(value = "账号",required = true)
    @TableField("r_id")
    private String rId;
    @ApiModelProperty(value = "用户名",required = true)
    private String name;
    @ApiModelProperty(value = "密码",required = true)
    @TableField("r_password")
    private String rPassword;
    @ApiModelProperty(value = "性别:0男 1女",required = true)
    private String sex;
    @ApiModelProperty(value = "身份证",required = true)
    @TableField("id_card")
    private String idCard;
    @ApiModelProperty(value = "邮箱",required = true)
    private String email;
    @ApiModelProperty(value = "电话",required = true)
    private String phone;
    @ApiModelProperty(value = "身份类型")
    @TableField("t_type")
    private String tType;
    @ApiModelProperty(value = "状态")
    private Boolean state;
}
