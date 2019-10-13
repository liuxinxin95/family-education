package com.education.center.need.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Carl
 * @ClassName NeedInfoVO
 * @Description
 * @date 2019-10-02 08:30
 **/
@ApiModel
@Data
public class NeedInfoVO implements Serializable{

    @ApiModelProperty(value = "id")
    private Integer id;
    /**
     * 机构id
     */
    @ApiModelProperty(value = "机构id")
    private Integer organizationId;

    /**
     * 姓名或昵称
     */
    @ApiModelProperty(value = "姓名或昵称")
    private String nickName;

    /**
     * 用户类型、1老师，2机构
     */
    @ApiModelProperty(value ="用户类型、1老师，2机构")
    private Integer userType;

    /**
     * 教师类型：0兼职1专职
     */
    @ApiModelProperty(value = "教师类型：0兼职1专职")
    private Integer teacherType;

    /**
     * 教学年龄
     */
    @ApiModelProperty(value = "教学年龄")
    private String teachingAge;

    /**
     * 教学年龄文本
     */
    @ApiModelProperty(value = "id")
    private String teachingAgeText;

    /**
     * 年级名称
     */
    @ApiModelProperty(value = "年级名称")
    private String gradeName;
    /**
     * 科目名称
     */
    @ApiModelProperty(value = "科目名称")
    private String subjectName;

    /**
     * 距离
     */
    @ApiModelProperty(value = "距离")
    private Long distance;


    @ApiModelProperty(value = "认证状态")
    private Integer certificationStatus;

    /**
     * 认证文本
     */
    @ApiModelProperty(value = "认证状态文本")
    private String certificationStatusText;
}
