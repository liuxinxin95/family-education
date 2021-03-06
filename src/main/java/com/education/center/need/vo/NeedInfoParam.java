package com.education.center.need.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel
@Data
public class NeedInfoParam {


    /**
     * 姓名或昵称
     */
    @ApiModelProperty(value = "姓名或昵称")
    @NotNull(message = "姓名或昵称不能为空")
    private String nickName;

    /**
     * 手机号
     */
    @NotNull(message = "姓名或昵称不能为空")
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    @ApiModelProperty(value = "性别")
    private Integer sex;

    /**
     * 最高学历
     */
    @ApiModelProperty(value = "最高学历")
    private String tallestDiploma;

    /**
     * 毕业院校
     */
    @ApiModelProperty(value = "毕业院校")
    private String graduateInstitutions;

    /**
     * 所选专业
     */
    @ApiModelProperty(value = "所选专业")
    private String specialized;

    /**
     * 任教学校
     */
    @ApiModelProperty(value = "任教学校")
    private String teachingSchool;

    /**
     * 教学年龄
     */
    @ApiModelProperty(value = "教学年龄")
    private String teachingAge;

    /**
     * 授课科目id
     */
    @ApiModelProperty(value = "授课科目id")
    @NotNull(message = "授课科目不能为空")
    private Integer teachingSubjectId;

    /**
     * 授课年级id
     */
    @ApiModelProperty(value = "授课年级id")
    @NotNull(message = "授课年级不能为空")
    private Integer teachingGradeId;

    /**
     * 授课地址
     */
    @NotNull(message = "授课地址不能为空")
    @ApiModelProperty(value = "授课地址")
    private String teachingAddress;

    /**
     * 教学方式
     */
    @NotNull(message = "教学方式不能为空")
    @ApiModelProperty(value = "教学方式")
    private String teachingMode;

    /**
     * 教学时间
     */
    @NotNull(message = "教学时间不能为空")
    @ApiModelProperty(value = "教学时间")
    private String teachingTime;

    /**
     * 酬金
     */
    @NotNull(message = "酬金不能为空")
    @ApiModelProperty(value = "酬金")
    private Integer remuneration;

    /**
     * 教学特点
     */
    @ApiModelProperty(value = "教学特点")
    private String teachingFeature;


    /**
     * 经度
     */
    @NotNull(message = "经纬度不能为空")
    @ApiModelProperty(value = "经度")
    private String lon;

    /**
     * 维度
     */
    @NotNull(message = "经纬度不能为空")
    @ApiModelProperty(value = "维度")
    private String lat;

    /**
     * 需求类型：0老师1学生
     */
    @NotNull(message = "需求类型不能为空")
    @ApiModelProperty(value = "需求类型：0老师1学生")
    private Integer needType;

    /**
     * 老师照片
     */
    @ApiModelProperty(value = "老师照片")
    private String teacherPhoto;

    /**
     * 省份id
     */
    @NotNull(message = "省份不能为空")
    @ApiModelProperty(value = "省份id")
    private Integer provinceId;


    /**
     * 城市id
     */
    @NotNull(message = "城市不能为空")
    @ApiModelProperty(value = "城市id")
    private Integer cityId;
    /**
     * 区域id
     */
    @NotNull(message = "区域不能为空")
    @ApiModelProperty(value = "区域id")
    private Integer districtId;

}