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
    private Integer userId;

    /**
     * 城市编码
     */
    @Column(name = "city_code")
    private String cityCode;

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
     * 奖励金额（单位：分）
     */
    @Column(name = "award_point")
    private Long awardPoint;

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

    @Column(name = "update_time")
    private Date updateTime;

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
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
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
     * 获取奖励金额（单位：分）
     *
     * @return award_point - 奖励金额（单位：分）
     */
    public Long getAwardPoint() {
        return awardPoint;
    }

    /**
     * 设置奖励积分（单位：分）
     *
     * @param awardPoint 奖励积分（单位：分）
     */
    public void setAwardPoint(Long awardPoint) {
        this.awardPoint = awardPoint;
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
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}