package com.team11.server.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "菜单对象",description = "")
public class menuBean {
    @ApiModelProperty(value = "菜单id",required = true)
    @TableField("menu_id")
    private String menuId;
    @ApiModelProperty(value = "菜单名",required = true)
    @TableField("menu_name")
    private String menuName;
    @ApiModelProperty(value = "url",required = true)
    @TableField("url")
    private String url;
    @ApiModelProperty(value = "path",required = true)
    @TableField("path")
    private String path;
    @ApiModelProperty(value = "对象名",required = true)
    @TableField("component")
    private String component;
    @ApiModelProperty(value = "父id",required = true)
    @TableField("parentId")
    private Integer parentId;
    private List<menuBean> children;
}
