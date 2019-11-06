package com.education.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Carl
 * @ClassName ApiNeedDetailVO
 * @Description
 * @date 2019-11-06 23:06
 **/
@Data
public class ApiNeedDetailVO {

    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

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
    private Integer sex;

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
     * 授课科目名称
     */
    private String subjectName;

    /**
     * 授课年级名称
     */
    private String gradeName;

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
     * 需求类型：0老师1学生
     */
    private Integer needType;

    /**
     * 老师照片
     */
    private String teacherPhoto;


    /**
     * 省份id
     */
    private Integer provinceId;


    /**
     * 城市id
     */
    private Integer cityId;
    /**
     * 区域id
     */
    private Integer districtId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Date updateTime;

    @ApiModelProperty(value = "身份")
    private String provinceName;
    @ApiModelProperty(value = "城市")
    private String cityName;
    @ApiModelProperty(value = "街道")
    private String districtName;
}
