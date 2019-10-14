package com.education.center.sign.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user_sign_record")
public class SysUserSignRecordDO {
    /**
     * 签到记录ID
     */
    @Id
    @Column(name = "record_id")
    private Long recordId;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 城市编码
     */
    @Column(name = "city_code")
    private String cityCode;

    /**
     * 签到规则ID
     */
    @Column(name = "rule_id")
    private Long ruleId;

    /**
     * 签到奖励ID
     */
    @Column(name = "award_id")
    private Long awardId;

    /**
     * 奖励类型（每日不同-10、每日相同-11、连续签-20）
     */
    @Column(name = "award_type")
    private Integer awardType;

    /**
     * 奖励方式（1-钱包、2-积分）
     */
    @Column(name = "award_way")
    private Integer awardWay;

    /**
     * 奖励的对象值（红包ID或是其他的关联对象的ID）
     */
    @Column(name = "award_value")
    private Long awardValue;

    /**
     * 奖励金额（单位：分）
     */
    @Column(name = "award_amount")
    private Long awardAmount;

    /**
     * 是否连续签到（0-否、1-是）
     */
    @Column(name = "continue_sign_flag")
    private Integer continueSignFlag;

    /**
     * 签到天数
     */
    @Column(name = "sign_day_num")
    private Integer signDayNum;

    /**
     * 是否删除标示（0：未删除、1：删除）
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 获取签到记录ID
     *
     * @return record_id - 签到记录ID
     */
    public Long getRecordId() {
        return recordId;
    }

    /**
     * 设置签到记录ID
     *
     * @param recordId 签到记录ID
     */
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取城市编码
     *
     * @return city_code - 城市编码
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置城市编码
     *
     * @param cityCode 城市编码
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * 获取签到规则ID
     *
     * @return rule_id - 签到规则ID
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 设置签到规则ID
     *
     * @param ruleId 签到规则ID
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 获取签到奖励ID
     *
     * @return award_id - 签到奖励ID
     */
    public Long getAwardId() {
        return awardId;
    }

    /**
     * 设置签到奖励ID
     *
     * @param awardId 签到奖励ID
     */
    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    /**
     * 获取奖励类型（每日不同-10、每日相同-11、连续签-20）
     *
     * @return award_type - 奖励类型（每日不同-10、每日相同-11、连续签-20）
     */
    public Integer getAwardType() {
        return awardType;
    }

    /**
     * 设置奖励类型（每日不同-10、每日相同-11、连续签-20）
     *
     * @param awardType 奖励类型（每日不同-10、每日相同-11、连续签-20）
     */
    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    /**
     * 获取奖励方式（1-钱包、2-积分）
     *
     * @return award_way - 奖励方式（1-钱包、2-积分）
     */
    public Integer getAwardWay() {
        return awardWay;
    }

    /**
     * 设置奖励方式（1-钱包、2-积分）
     *
     * @param awardWay 奖励方式（1-钱包、2-积分）
     */
    public void setAwardWay(Integer awardWay) {
        this.awardWay = awardWay;
    }

    /**
     * 获取奖励的对象值（红包ID或是其他的关联对象的ID）
     *
     * @return award_value - 奖励的对象值（红包ID或是其他的关联对象的ID）
     */
    public Long getAwardValue() {
        return awardValue;
    }

    /**
     * 设置奖励的对象值（红包ID或是其他的关联对象的ID）
     *
     * @param awardValue 奖励的对象值（红包ID或是其他的关联对象的ID）
     */
    public void setAwardValue(Long awardValue) {
        this.awardValue = awardValue;
    }

    /**
     * 获取奖励金额（单位：分）
     *
     * @return award_amount - 奖励金额（单位：分）
     */
    public Long getAwardAmount() {
        return awardAmount;
    }

    /**
     * 设置奖励金额（单位：分）
     *
     * @param awardAmount 奖励金额（单位：分）
     */
    public void setAwardAmount(Long awardAmount) {
        this.awardAmount = awardAmount;
    }

    /**
     * 获取是否连续签到（0-否、1-是）
     *
     * @return continue_sign_flag - 是否连续签到（0-否、1-是）
     */
    public Integer getContinueSignFlag() {
        return continueSignFlag;
    }

    /**
     * 设置是否连续签到（0-否、1-是）
     *
     * @param continueSignFlag 是否连续签到（0-否、1-是）
     */
    public void setContinueSignFlag(Integer continueSignFlag) {
        this.continueSignFlag = continueSignFlag;
    }

    /**
     * 获取签到天数
     *
     * @return sign_day_num - 签到天数
     */
    public Integer getSignDayNum() {
        return signDayNum;
    }

    /**
     * 设置签到天数
     *
     * @param signDayNum 签到天数
     */
    public void setSignDayNum(Integer signDayNum) {
        this.signDayNum = signDayNum;
    }

    /**
     * 获取是否删除标示（0：未删除、1：删除）
     *
     * @return delete_flag - 是否删除标示（0：未删除、1：删除）
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置是否删除标示（0：未删除、1：删除）
     *
     * @param deleteFlag 是否删除标示（0：未删除、1：删除）
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}