package com.education.center.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Carl
 * @ClassName LoginVO
 * @Description
 * @date 2019-10-11 00:00
 **/
@ApiModel
@Data
public class LoginVO {

    @ApiModelProperty(value = "session")
    private String session;

    @ApiModelProperty(value = "用户类型 1老师，2机构")
    private Integer userType;

}
