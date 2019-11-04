package com.education.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Carl
 * @ClassName TeacherCertificationVO
 * @Description
 * @date 2019-11-03 20:59
 **/
@Data
@ApiModel
public class TeacherCertificationVO {

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号")
    private String phone;

    /**
     * 法人
     */
    @ApiModelProperty(value = "法人")
    private String legalPerson;

    /**
     * 身份证号码
     */
    @ApiModelProperty(value = "身份证号码")
    private String idCard;

    /**
     * 营业执照号码
     */
    @ApiModelProperty(value = "营业执照号码")
    private String businessLicenseNumber;

    /**
     * 身份证正面
     */
    @ApiModelProperty(value = "身份证正面")
    private String idCardBeforePhoto;

    /**
     * 身份证反面
     */
    @ApiModelProperty(value = "身份证反面")
    private String idCardAfterPhoto;

    /**
     * 手持身份证
     */
    @ApiModelProperty(value = "手持身份证")
    private String idCardHandPhoto;

    /**
     * 营业执照
     */
    @ApiModelProperty(value = "营业执照")
    private String businessLicensePhoto;

    /**
     * 教师资格证
     */
    @ApiModelProperty(value = "教师资格证")
    private String teacherCertificationPhoto;


}
