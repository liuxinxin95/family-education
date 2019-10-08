package com.education.center.need.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel
@Data
public class NeedInfoParam {


    /**
     * 姓名或昵称
     */
    private String nickName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private Integer sax;

    /**
     * 最高学历
     */
    private String tallestDiploma;

    /**
     * 毕业院校
     */
    private String graduateInstitutions;

    /**
     * 所选专业
     */
    private String specialized;

    /**
     * 任教学校
     */
    private String teachingSchool;

    /**
     * 教学年龄
     */
    private String teachingAge;

    /**
     * 授课科目id
     */
    private Integer teachingSubjectId;

    /**
     * 授课年级id
     */
    private Integer teachingGradeId;

    /**
     * 授课地址
     */
    private String teachingAddress;

    /**
     * 教学方式
     */
    private String teachingMode;

    /**
     * 教学时间
     */
    private String teachingTime;

    /**
     * 酬金
     */
    private Integer remuneration;

    /**
     * 教学特点
     */
    private String teachingFeature;

    /**
     * 经度
     */
    private String lon;

    /**
     * 维度
     */
    private String lat;

    /**
     * 需求类型：0老师1学生
     */
    private Integer needType;

    /**
     * 老师照片
     */
    private String teacherPhoto;

}