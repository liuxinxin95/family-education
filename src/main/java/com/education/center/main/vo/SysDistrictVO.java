package com.education.center.main.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class SysDistrictVO {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Integer districtId;

    /**
     * 地区名称
     */
    @ApiModelProperty(value = "地区名称")
    private String district;

    /**
     * 首字母拼音
     */
    @ApiModelProperty(value = "首字母拼音")
    private String initial;


}