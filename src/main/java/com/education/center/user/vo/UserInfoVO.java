package com.education.center.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Carl
 * @ClassName UserInfoVo
 * @Description
 * @date 2019-09-30 11:25
 **/
@Data
@ApiModel
public class UserInfoVO implements Serializable {

    @ApiModelProperty(value ="法人/教师真实名称")
    @NotNull(message ="真实姓名不能为空")
    private String legalPerson;

    /**
     * 身份证号码
     */
    @ApiModelProperty(value ="身份证号码")
    @NotNull(message ="身份证号码不能为空")
    private String idCard;

    /**
     * 营业执照号码
     */
    @ApiModelProperty(value ="营业执照号码")
    private String businessLicenseNumber;

    /**
     * 身份证正面
     */
    @ApiModelProperty(value ="身份证正面")
    @NotNull(message ="身份证正面不能为空")
    private String idCardBeforePhoto;

    /**
     * 身份证反面
     */
    @ApiModelProperty(value ="身份证反面")
    @NotNull(message ="身份证反面不能为空")
    private String idCardAfterPhoto;

    /**
     * 手持身份证
     */
    @ApiModelProperty(value ="手持身份证")
    @NotNull(message ="手持身份证不能为空")
    private String idCardHandPhoto;

    /**
     * 营业执照
     */
    @ApiModelProperty(value ="营业执照")
    private String businessLicensePhoto;

    /**
     * 教师资格证
     */
    @ApiModelProperty(value ="教师资格证")
    private String teacherCertificationPhoto;


    /**
     * 用户类型、1老师，2机构
     */
    @ApiModelProperty(value ="用户类型、1老师，2机构")
    private Integer userType;

    /**
     * 审核状态 0未审核 1审核通过 2审核未通过
     */
    @ApiModelProperty(value ="")
    private Integer examineStatus;


}
