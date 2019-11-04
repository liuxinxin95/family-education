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

    private Integer id;

    private Boolean isPass;

    private String remark;
}