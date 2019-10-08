package com.education.center.main.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import	java.io.Serializable;

/**
 * @author Carl
 * @ClassName SubjectInfoVO
 * @Description
 * @date 2019-09-30 23:59
 **/
@ApiModel
@Data
public class SubjectInfoVO implements Serializable {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 科目id
     */
    @ApiModelProperty(value = "科目名称")
    private String subjectName;

    @ApiModelProperty(value = "年级id")
    private Integer gradeId;
}
