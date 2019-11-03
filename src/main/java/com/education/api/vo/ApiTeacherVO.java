package com.education.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Carl
 * @ClassName ApiTeacherVO
 * @Description
 * @date 2019-11-02 17:03
 **/
@Data
@ApiModel
public class ApiTeacherVO implements Serializable {

    private Integer id;

    /**
     * 微信id
     */
    private String openId;

    /**
     * 用户名称默认微信昵称
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 性别：1男2女
     */
    private Long sex;

    /**
     * 机构id
     */
    private Integer organizationId;

    /**
     * 老师类型
     */
    private String teacherType;

    /**
     * 具体地址
     */
    private String address;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 省份id
     */
    @ApiModelProperty("省份名称")
    private Integer provinceName;

    /**
     * 城市id
     */
    @ApiModelProperty("城市名称")
    private Integer cityName;

    /**
     * 区域id
     */
    @ApiModelProperty("区域名称")
    private Integer districtName;

    @ApiModelProperty(value = "认证状态")
    private Integer certificationType;

    @ApiModelProperty(value = "认证状态文本")
    private String certificationText;

    @ApiModelProperty(value = "缴费状态")
    private Integer payType;

    private String payTypeText;

    @ApiModelProperty(value = "审核人名称")
    private String examineOperatorName;
}
