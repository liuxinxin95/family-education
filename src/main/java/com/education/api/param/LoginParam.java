package com.education.api.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel
@Data
public class LoginParam {
    @ApiModelProperty(value = "账号" )
    @NotBlank(message = "账号不能为空")
    private String account;
    @ApiModelProperty(value = "密码不能为空" )
    private String passwd;

}
