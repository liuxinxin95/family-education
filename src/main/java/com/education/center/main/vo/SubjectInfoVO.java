package com.education.center.main.vo;
import lombok.Data;

import	java.io.Serializable;

/**
 * @author Carl
 * @ClassName SubjectInfoVO
 * @Description
 * @date 2019-09-30 23:59
 **/
@Data
public class SubjectInfoVO implements Serializable {

    /**
     * id
     */
    private Integer id;

    /**
     * 科目id
     */
    private String subjectName;
}
