package com.education.api.param;

import com.education.common.PageRequest;
import lombok.Data;

/**
 * @author Carl
 * @ClassName QueryNeedParam
 * @Description
 * @date 2019-11-06 22:18
 **/
@Data
public class QueryNeedParam extends PageRequest {

    private Integer needType;

    private Integer userType;

    private String useName;

    private String phone;

    /**
     * 省份id
     */
    private Integer provinceId;

    /**
     * 城市id
     */
    private Integer cityId;

    /**
     * 区域id
     */
    private Integer districtId;
}
