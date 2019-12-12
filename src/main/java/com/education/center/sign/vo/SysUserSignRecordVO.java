package com.education.center.sign.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Carl
 * @ClassName SysUserSignRecordVO
 * @Description
 * @date 2019-12-12 10:14
 **/
@Data
public class SysUserSignRecordVO implements Serializable {
    /**
     * 签到记录ID
     */
    private Long recordId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 奖励方式（1-钱包、2-积分）
     */
    private Integer awardWay;


    /**
     * 奖励金额（单位：分）
     */
    private Long awardAmount;

    /**
     * 奖励积分（单位：分）
     */
    private Long awardPoint;


    /**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;
}
