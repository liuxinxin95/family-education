package com.education.center.sign.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_sign_award")
public class SysSignAwardDO {
    /**
     * 奖励ID
     */
    @Id
    @Column(name = "award_id")
    private Long awardId;

    /**
     * 关联的规则ID
     */
    @Column(name = "rule_id")
    private Long ruleId;

    /**
     * 奖励类型（每日不同-10、每日相同-11、连续签-20）
     */
    @Column(name = "award_type")
    private Integer awardType;

    /**
     * 天数（0表示每日奖励相同）
     */
    @Column(name = "day_num")
    private Integer dayNum;

    /**
     * 是否存在奖励—0：存在、1：不存在（有些天数下不存在奖励）
     */
    @Column(name = "award_flag")
    private Integer awardFlag;

    /**
     * 奖励方式（1-钱包、2-积分）
     */
    @Column(name = "award_way")
    private Integer awardWay;

    /**
     * 奖励值（根据award_way来判断——钱包时，表示钱包金额；积分时显示积分）
     */
    @Column(name = "award_value")
    private Long awardValue;

    /**
     * 是否删除（0：未删除、1：删除）
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 创建时间(签到时间)
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 获取奖励ID
     *
     * @return award_id - 奖励ID
     */
    public Long getAwardId() {
        return awardId;
    }

    /**
     * 设置奖励ID
     *
     * @param awardId 奖励ID
     */
    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    /**
     * 获取关联的规则ID
     *
     * @return rule_id - 关联的规则ID
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 设置关联的规则ID
     *
     * @param ruleId 关联的规则ID
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
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
     * 获取天数（0表示每日奖励相同）
     *
     * @return day_num - 天数（0表示每日奖励相同）
     */
    public Integer getDayNum() {
        return dayNum;
    }

    /**
     * 设置天数（0表示每日奖励相同）
     *
     * @param dayNum 天数（0表示每日奖励相同）
     */
    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    /**
     * 获取是否存在奖励—0：存在、1：不存在（有些天数下不存在奖励）
     *
     * @return award_flag - 是否存在奖励—0：存在、1：不存在（有些天数下不存在奖励）
     */
    public Integer getAwardFlag() {
        return awardFlag;
    }

    /**
     * 设置是否存在奖励—0：存在、1：不存在（有些天数下不存在奖励）
     *
     * @param awardFlag 是否存在奖励—0：存在、1：不存在（有些天数下不存在奖励）
     */
    public void setAwardFlag(Integer awardFlag) {
        this.awardFlag = awardFlag;
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
     * 获取奖励值（根据award_way来判断——钱包时，表示钱包金额；积分时显示积分）
     *
     * @return award_value - 奖励值（根据award_way来判断——钱包时，表示钱包金额；积分时显示积分）
     */
    public Long getAwardValue() {
        return awardValue;
    }

    /**
     * 设置奖励值（根据award_way来判断——钱包时，表示钱包金额；积分时显示积分）
     *
     * @param awardValue 奖励值（根据award_way来判断——钱包时，表示钱包金额；积分时显示积分）
     */
    public void setAwardValue(Long awardValue) {
        this.awardValue = awardValue;
    }

    /**
     * 获取是否删除（0：未删除、1：删除）
     *
     * @return delete_flag - 是否删除（0：未删除、1：删除）
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置是否删除（0：未删除、1：删除）
     *
     * @param deleteFlag 是否删除（0：未删除、1：删除）
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取创建时间(签到时间)
     *
     * @return create_time - 创建时间(签到时间)
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间(签到时间)
     *
     * @param createTime 创建时间(签到时间)
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}