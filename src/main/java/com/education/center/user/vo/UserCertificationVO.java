package com.education.center.user.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import	java.io.Serializable;

/**
 * @author Carl
 * @ClassName UserCredentialsVO
 * @Description
 * @date 2019-10-09 00:11
 **/
@Data
@ApiModel
public class UserCertificationVO implements Serializable{

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "认证状态")
    private Integer certificationType;

    @ApiModelProperty(value = "认证状态文本")
    private String certificationText;

    @ApiModelProperty(value = "缴费状态")
    private Integer paySingleStatus;
}
