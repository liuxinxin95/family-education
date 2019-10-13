package com.education.center.need.vo;

import com.education.common.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Carl
 * @ClassName NeedInfoRequest
 * @Description
 * @date 2019-10-02 19:39
 **/
@Data
@ApiModel
public class NeedInfoRequest extends PageRequest {


    @ApiModelProperty(value ="年级id")
    private Integer gradeId;

    @ApiModelProperty(value = "科目id")
    private Integer subjectId;

    @ApiModelProperty(value = "授课方式")
    private String teachingMode;

    @ApiModelProperty(value = "性别")
    private Integer sex;


    @ApiModelProperty(value = "教学经验")
    private String teachingAge;

    @ApiModelProperty(value = "1老师2者机构")
    private Integer userType;
    /**
     * 附近多少距离
     */
    @ApiModelProperty(value = "附近多少距离单位km")
    private double radii;
    @ApiModelProperty(value = "当前经度")
    private double lon;
    @ApiModelProperty(value = "当前维度")
    private double lat;
    /**
     * 最小经度
     */
    private Double minlng;

    /**
     * 最大经度
     */
    private Double maxlng;

    /**
     * 最小维度
     */
    private Double minlat;

    /**
     * 最大维度
     */
    private Double maxlat;


}
