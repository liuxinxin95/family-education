package com.education.center.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Carl
 * @ClassName UserVO
 * @Description
 * @date 2019-09-08 15:37
 **/
@Data
@ApiModel
public class UserVO implements Serializable {

    /**
     * 微信id
     */
    @ApiModelProperty("微信id")
    private String openId;
    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String userName;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;
    /**
     * 性别：0女1男
     */
    @ApiModelProperty("性别：0女1男")
    private Long sex;

    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private Date birthday;

    /**
     * 职业
     */
    @ApiModelProperty("职业")
    private String professional;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 用户类型：1老师，2机构
     */
    @ApiModelProperty("用户类型：1老师，2机构")
    private Integer userType;
}
