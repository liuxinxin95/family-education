package com.education.api.param;

import lombok.Data;

/**
 * @author Carl
 * @ClassName AuditParam
 * @Description
 * @date 2019-11-04 22:46
 **/
@Data
public class AuditParam {

    /**
     * id
     */
    private Integer id;

    /**
     * 是否通过
     */
    private Boolean isPass;

    /**
     * 原因
     */
    private String remark;
}