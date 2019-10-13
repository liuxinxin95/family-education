/*
 * Copyright (c) 2018-2019 杭州拼便宜网络科技有限公司
 * Date:       2019/02/20 14:24.
 */

package com.education.center.sign.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Z.C.H on 2019/02/20 14:24.
 */
public class SignRuleResponse implements Serializable {

    private static final long serialVersionUID = -4644936121521090307L;

    /**
     * 规则是否存在标识
     * true：规则存在
     * false：规则不存在
     */
    private boolean ruleExistFlag;
    /**
     * 规则ID
     */
    private Long ruleId;

    /**
     * 规则描述
     */
    private String ruleDesc;

    /**
     * 签到周期
     */
    private Integer ruleCycle;


    /**
     * 连续签到天数
     */
    private Integer continueSignDays;

    /**
     * 漏签天数
     */
    private Integer missesSignDays;

    /**
     * 签到状态-0:未签到、1:已签到、-1:漏签
     */
    private Integer signStatus;

    /**
     * 签到状态
     */
    private String signStatusText;

    /**
     * 签到显示文案
     */
    private String signShowText;

    /**
     * 日签奖励类型
     */
    private Integer daySignType;

    /**
     * 签到奖励
     */
    private List<SignAwardResponse> signAwardResponseList;


    public boolean getRuleExistFlag() {
        return ruleExistFlag;
    }

    public void setRuleExistFlag(boolean ruleExistFlag) {
        this.ruleExistFlag = ruleExistFlag;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public Integer getContinueSignDays() {
        return continueSignDays;
    }

    public void setContinueSignDays(Integer continueSignDays) {
        this.continueSignDays = continueSignDays;
    }

    public Integer getMissesSignDays() {
        return missesSignDays;
    }

    public void setMissesSignDays(Integer missesSignDays) {
        this.missesSignDays = missesSignDays;
    }

    public Integer getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(Integer signStatus) {
        this.signStatus = signStatus;
    }

    public String getSignStatusText() {
        return signStatusText;
    }

    public void setSignStatusText(String signStatusText) {
        this.signStatusText = signStatusText;
    }

    public String getSignShowText() {
        return signShowText;
    }

    public void setSignShowText(String signShowText) {
        this.signShowText = signShowText;
    }

    public List<SignAwardResponse> getSignAwardResponseList() {
        return signAwardResponseList;
    }

    public void setSignAwardResponseList(List<SignAwardResponse> signAwardResponseList) {
        this.signAwardResponseList = signAwardResponseList;
    }

    public Integer getDaySignType() {
        return daySignType;
    }

    public void setDaySignType(Integer daySignType) {
        this.daySignType = daySignType;
    }

    public Integer getRuleCycle() {
        return ruleCycle;
    }

    public void setRuleCycle(Integer ruleCycle) {
        this.ruleCycle = ruleCycle;
    }
}
