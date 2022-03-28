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
@ApiModel(value = "角色权限对象",description = "")
public class userMenuAuthority {
    @ApiModelProperty(value = "菜单id")
    @TableField("menu_id")
    private Integer menuId;
}
