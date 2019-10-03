package com.education.center.need.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Carl
 * @ClassName NeedDetailVO
 * @Description
 * @date 2019-10-03 17:01
 **/
@ApiModel
@Data
@ToString
public class NeedDetailVO implements Serializable {


    @ApiModelProperty(value ="")
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty(value ="用户id")
    private Integer userId;

    /**
     * 姓名或昵称
     */
    @ApiModelProperty(value ="姓名或昵称")
    private String nickName;

    /**
     * 手机号
     */
    @ApiModelProperty(value ="手机号")
    private String phone;

    /**
     * 性别
     */
    @ApiModelProperty(value ="性别")
    private Integer sax;

    /**
     * 最高学历
     */
    @ApiModelProperty(value ="最高学历")
    private String tallestDiploma;

    /**
     * 毕业院校
     */
    @ApiModelProperty(value ="毕业院校")
    private String graduateInstitutions;

    /**
     * 所选专业
     */
    @ApiModelProperty(value ="所选专业")
    private String specialized;

    /**
     * 任教学校
     */
    @ApiModelProperty(value ="任教学校")
    private String teachingSchool;

    /**
     * 教学年龄
     */
    @ApiModelProperty(value ="教学年龄")
    private String teachingAge;


    /**
     * 授课科目名称
     */
    @ApiModelProperty(value ="授课科目名称")
    private String subjectName;

    /**
     * 授课年级名称
     */
    @ApiModelProperty(value ="授课年级名称")
    private String gradeName;

    /**
     * 授课地址
     */
    @ApiModelProperty(value ="授课地址")
    private String teachingAddress;

    /**
     * 教学方式
     */
    @ApiModelProperty(value ="教学方式")
    private String teachingMode;

    /**
     * 教学时间
     */
    @ApiModelProperty(value ="教学时间")
    private String teachingTime;

    /**
     * 酬金
     */
    @ApiModelProperty(value ="酬金")
    private Integer remuneration;

    /**
     * 教学特点
     */
    @ApiModelProperty(value ="教学特点")
    private String teachingFeature;

    /**
     * 经度
     */
    @ApiModelProperty(value ="经度")
    private String lon;

    /**
     * 维度
     */
    @ApiModelProperty(value ="维度")
    private String lat;

    /**
     * 需求类型：0老师1学生
     */
    @ApiModelProperty(value ="需求类型：0老师1学生")
    private Integer needType;

    /**
     * 老师照片
     */
    @ApiModelProperty(value ="老师照片")
    private String teacherPhoto;

    /**
     * 距离
     */
    @ApiModelProperty(value ="距离")
    private Long distance;


    private Integer certificationStatus;

    /**
     * 认证文本
     */
    @ApiModelProperty(value ="")
    private String certificationStatusText;
}
