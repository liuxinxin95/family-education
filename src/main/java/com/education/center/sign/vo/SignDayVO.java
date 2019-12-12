package com.education.center.sign.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Carl
 * @ClassName SignDayVO
 * @Description
 * @date 2019-12-12 10:27
 **/
@Data
public class SignDayVO implements Serializable {

    /**
     * 连续签到天数
     */
    private Integer continuousSignNum;

    /**
     * 今天是否已经签到
     */
    private Boolean signFlag;
    /**
     * 连续前几天签到记录
     */
    private List<SysUserSignRecordVO> recordVOS;

}
