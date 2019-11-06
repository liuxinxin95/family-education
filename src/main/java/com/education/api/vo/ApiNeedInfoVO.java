package com.education.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Carl
 * @ClassName ApiNeedInfoVO
 * @Description
 * @date 2019-11-06 22:12
 **/
@Data
public class ApiNeedInfoVO implements Serializable {

    @ApiModelProperty(value = "需求类型")
    private Integer needType;

    @ApiModelProperty(value = "用户类型")
    private Integer userType;
    @ApiModelProperty(value = "微信id")
    private String openId;
    @ApiModelProperty(value = "用户名称")
    private String userName;
    @ApiModelProperty(value = "电话号码")
    private String phone;
    @ApiModelProperty(value = "省份")
    private String provinceName;
    @ApiModelProperty(value = "城市")
    private String cityName;
    @ApiModelProperty(value = "街道")
    private String districtName;

    @ApiModelProperty(value = "发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
