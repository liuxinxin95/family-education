package com.education.api.param;

import com.education.common.PageRequest;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Carl
 * @ClassName QueryTeacherParam
 * @Description
 * @date 2019-11-02 17:14
 **/
@Data
@ApiModel
public class QueryOrganizationParam extends PageRequest {

    private String userName;

    private String phone;

    /**
     * 身份id
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


    /**
     * 认证状态
     */
    private Integer certification;

    /**
     * 缴费状态
     */
    private Boolean payType;
}
