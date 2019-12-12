package com.education.center.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Carl
 * @ClassName ApiMyInvitationVO
 * @Description
 * @date 2019-11-24 23:46
 **/
@ApiModel
@Data
public class ApiMyInvitationVO {

    @ApiModelProperty(value = "我的邀请码")
    private Integer inviteCode;

    @ApiModelProperty(value = "我的邀请人名称")
    private String inviteName;

    @ApiModelProperty(value = "我的邀请人电话")
    private String invitePhone;

    @ApiModelProperty(value = "我的邀请人id")
    private Integer inviteUserId;
}
