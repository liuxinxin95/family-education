package com.education.center.need.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Carl
 * @ClassName NeedOverviewVO
 * @Description
 * @date 2019-10-02 06:58
 **/
@ApiModel
@Data
public class NeedOverviewVO implements Serializable {

    private Integer id;
    /**
     * 姓名或昵称
     */
    private String nickName;

    /**
     * 授课科目id
     */
    private Integer teachingSubjectId;

    /**
     * 授课年级id
     */
    private Integer teachingGradeId;

    /**
     * 年级名称
     */
    private Integer teachingGradeNameText;
    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 教学时间
     */
    private String teachingTime;
    /**
     * 教学方式
     */
    private String teachingModeText;
    /**
     * 毕业院校
     */
    private String graduateInstitutions;

}
