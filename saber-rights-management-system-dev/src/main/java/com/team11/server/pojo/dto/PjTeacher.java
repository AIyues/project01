package com.team11.server.pojo.dto;
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
@ApiModel(value="PjTeacher对象", description="")
public class PjTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评教分数")
    private String pjCore;

    @ApiModelProperty(value = "评教学生")
    private String name;

}
