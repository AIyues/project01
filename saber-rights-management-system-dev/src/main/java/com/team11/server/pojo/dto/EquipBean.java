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
public class EquipBean {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "设备名称")
    private String equipName;
    @ApiModelProperty(value = "设备类型")
    private String equipType;
    @ApiModelProperty(value = "设备型号")
    private String equipModel;
    @ApiModelProperty(value = "设备剩余数量")
    private String equipNum;
    @ApiModelProperty(value = "设备图片")
    private String equipImg;
}
