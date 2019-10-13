/*
 * Copyright (c) 2018-2019 杭州拼便宜网络科技有限公司
 * Date:       2019/02/20 14:25.
 */

package com.education.center.sign.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Z.C.H on 2019/02/20 14:25.
 */
public class SignAwardResponse implements Serializable {
    private static final long serialVersionUID = 8188586409100312261L;

    /**
     * 奖励类型_日签-1、连续签-2
     */
    private Integer awardType;

    /**
     * 天数
     */
    private Integer dayNum;

    /**
     * 签到标示:0_未签到、1_已签到、-1_漏签
     */
    private Integer singFlag;

    /**
     * 奖励方式_1-钱包、2-积分,
     */
    private Integer awardWay;

    /**
     * 钱包金额
     */
    private BigDecimal walletAmount;

    /**
     * 红包金额
     */
    private BigDecimal redPacketAmount;

    /**
     * 总金额
     */
    private BigDecimal totalAwardAmount;

	/**
	 * 积分奖励值
	 */
	private Integer awardIntegral;

	public Integer getAwardIntegral() {
		return awardIntegral;
	}

	public void setAwardIntegral(Integer awardIntegral) {
		this.awardIntegral = awardIntegral;
	}

	public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public Integer getSingFlag() {
        return singFlag;
    }

    public void setSingFlag(Integer singFlag) {
        this.singFlag = singFlag;
    }

    public Integer getAwardWay() {
        return awardWay;
    }

    public void setAwardWay(Integer awardWay) {
        this.awardWay = awardWay;
    }

    public BigDecimal getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(BigDecimal walletAmount) {
        this.walletAmount = walletAmount;
    }

    public BigDecimal getRedPacketAmount() {
        return redPacketAmount;
    }

    public void setRedPacketAmount(BigDecimal redPacketAmount) {
        this.redPacketAmount = redPacketAmount;
    }

    public BigDecimal getTotalAwardAmount() {
        return totalAwardAmount;
    }

    public void setTotalAwardAmount(BigDecimal totalAwardAmount) {
        this.totalAwardAmount = totalAwardAmount;
    }
}
