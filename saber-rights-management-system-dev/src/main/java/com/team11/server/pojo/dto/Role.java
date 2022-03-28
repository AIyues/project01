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
@ApiModel(value = "角色对象",description = "")
public class Role {
    @ApiModelProperty(value = "角色id",required = true)
    @TableField("role_id")
    private Integer roleId;
    @ApiModelProperty(value = "角色名",required = true)
    @TableField("role_name")
    private String roleName;
    @ApiModelProperty(value = "角色状态")
    @TableField("state")
    private Integer state;

}
