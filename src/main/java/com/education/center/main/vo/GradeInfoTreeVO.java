package com.education.center.main.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Carl
 * @ClassName GradeInfoTreeVO
 * @Description
 * @date 2019-10-01 00:10
 **/
@Data
@ApiModel
public class GradeInfoTreeVO extends TreeNode {

    /**
     * 年级名称
     */
    @ApiModelProperty(value = "年级名称")
    private String gradeName;
}
