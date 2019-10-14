package com.education.center.sign.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user_sign_last_record")
public class SysUserSignLastRecordDO {
    /**
     * 最后签到记录ID
     */
    @Id
    @Column(name = "last_record_id")
    private Long lastRecordId;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 规则ID
     */
    @Column(name = "rule_id")
    private Long ruleId;

    /**
     * 最后签到时间
     */
    @Column(name = "last_sign_time")
    private Date lastSignTime;

    /**
     * 最后一次签到天数
     */
    @Column(name = "last_sign_day_num")
    private Integer lastSignDayNum;

    /**
     * 最后签到规则（日签规则ID_连续签到规则ID）
     */
    @Column(name = "last_sign_award_id")
    private String lastSignAwardId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 数据状态值(1:有效、-1:无效)
     */
    private Integer state;

    /**
     * 获取最后签到记录ID
     *
     * @return last_record_id - 最后签到记录ID
     */
    public Long getLastRecordId() {
        return lastRecordId;
    }

    /**
     * 设置最后签到记录ID
     *
     * @param lastRecordId 最后签到记录ID
     */
    public void setLastRecordId(Long lastRecordId) {
        this.lastRecordId = lastRecordId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取规则ID
     *
     * @return rule_id - 规则ID
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 设置规则ID
     *
     * @param ruleId 规则ID
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 获取最后签到时间
     *
     * @return last_sign_time - 最后签到时间
     */
    public Date getLastSignTime() {
        return lastSignTime;
    }

    /**
     * 设置最后签到时间
     *
     * @param lastSignTime 最后签到时间
     */
    public void setLastSignTime(Date lastSignTime) {
        this.lastSignTime = lastSignTime;
    }

    /**
     * 获取最后一次签到天数
     *
     * @return last_sign_day_num - 最后一次签到天数
     */
    public Integer getLastSignDayNum() {
        return lastSignDayNum;
    }

    /**
     * 设置最后一次签到天数
     *
     * @param lastSignDayNum 最后一次签到天数
     */
    public void setLastSignDayNum(Integer lastSignDayNum) {
        this.lastSignDayNum = lastSignDayNum;
    }

    /**
     * 获取最后签到规则（日签规则ID_连续签到规则ID）
     *
     * @return last_sign_award_id - 最后签到规则（日签规则ID_连续签到规则ID）
     */
    public String getLastSignAwardId() {
        return lastSignAwardId;
    }

    /**
     * 设置最后签到规则（日签规则ID_连续签到规则ID）
     *
     * @param lastSignAwardId 最后签到规则（日签规则ID_连续签到规则ID）
     */
    public void setLastSignAwardId(String lastSignAwardId) {
        this.lastSignAwardId = lastSignAwardId == null ? null : lastSignAwardId.trim();
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

    /**
     * 获取数据状态值(1:有效、-1:无效)
     *
     * @return state - 数据状态值(1:有效、-1:无效)
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置数据状态值(1:有效、-1:无效)
     *
     * @param state 数据状态值(1:有效、-1:无效)
     */
    public void setState(Integer state) {
        this.state = state;
    }
}