/*
 * Copyright (c) 2018-2019 杭州拼便宜网络科技有限公司
 * Date:       2019/02/18 11:17.
 */

package com.education.center.sign.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class SignAwardBaseRequest implements Serializable {

    private static final long serialVersionUID = -6784703313709796053L;
    /**
     * 奖励方式_0-无奖励、1-钱包、2-红包,
     */
    @NotNull(message = "奖励方式不能为空")
    private Integer awardWay;

    /**
     * 奖励类型（每日不同_10、每日相同_11、连续签_20）
     */
    @NotNull(message = "奖励类型不能为空")
    private Integer awardType;

    /**
     * 天数
     */
    @NotNull(message = "天数不能为空")
    private Integer dayNum;

    /**
     * 钱包金额
     */
    private BigDecimal walletAmount;

	/**
	 * 积分
	 */
	private Integer integral;
}
