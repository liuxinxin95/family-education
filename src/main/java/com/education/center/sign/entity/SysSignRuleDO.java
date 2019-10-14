package com.education.center.sign.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_sign_rule")
public class SysSignRuleDO {
    /**
     * 签到规则主键ID
     */
    @Id
    @Column(name = "rule_id")
    private Long ruleId;

    /**
     * 规则名称
     */
    @Column(name = "rule_name")
    private String ruleName;

    /**
     * 规则结束时间
     */
    @Column(name = "rule_start_time")
    private Date ruleStartTime;

    /**
     * 规则开始时间
     */
    @Column(name = "rule_end_time")
    private Date ruleEndTime;

    /**
     * 签到规则周期（7天、14天）
     */
    @Column(name = "rule_cycle")
    private Integer ruleCycle;

    /**
     * 签到类型(日签10、连续签到20、日签+连续签到30）
     */
    @Column(name = "sign_type")
    private Integer signType;

    /**
     * 是否停用（启用-0、停用-1）默认值0-启用
     */
    private Integer disable;

    /**
     * 是否删除（未删除-0、已删除-1）默认值0-未删除
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 规则文案
     */
    @Column(name = "rule_desc")
    private String ruleDesc;

    /**
     * 创建人UID
     */
    @Column(name = "creator_uid")
    private Long creatorUid;

    /**
     * 创建人名称
     */
    @Column(name = "creator_name")
    private String creatorName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改人UID
     */
    @Column(name = "modifier_uid")
    private Long modifierUid;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 获取签到规则主键ID
     *
     * @return rule_id - 签到规则主键ID
     */
    public Long getRuleId() {
        return ruleId;
    }

    /**
     * 设置签到规则主键ID
     *
     * @param ruleId 签到规则主键ID
     */
    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    /**
     * 获取规则名称
     *
     * @return rule_name - 规则名称
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * 设置规则名称
     *
     * @param ruleName 规则名称
     */
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    /**
     * 获取规则结束时间
     *
     * @return rule_start_time - 规则结束时间
     */
    public Date getRuleStartTime() {
        return ruleStartTime;
    }

    /**
     * 设置规则结束时间
     *
     * @param ruleStartTime 规则结束时间
     */
    public void setRuleStartTime(Date ruleStartTime) {
        this.ruleStartTime = ruleStartTime;
    }

    /**
     * 获取规则开始时间
     *
     * @return rule_end_time - 规则开始时间
     */
    public Date getRuleEndTime() {
        return ruleEndTime;
    }

    /**
     * 设置规则开始时间
     *
     * @param ruleEndTime 规则开始时间
     */
    public void setRuleEndTime(Date ruleEndTime) {
        this.ruleEndTime = ruleEndTime;
    }

    /**
     * 获取签到规则周期（7天、14天）
     *
     * @return rule_cycle - 签到规则周期（7天、14天）
     */
    public Integer getRuleCycle() {
        return ruleCycle;
    }

    /**
     * 设置签到规则周期（7天、14天）
     *
     * @param ruleCycle 签到规则周期（7天、14天）
     */
    public void setRuleCycle(Integer ruleCycle) {
        this.ruleCycle = ruleCycle;
    }

    /**
     * 获取签到类型(日签10、连续签到20、日签+连续签到30）
     *
     * @return sign_type - 签到类型(日签10、连续签到20、日签+连续签到30）
     */
    public Integer getSignType() {
        return signType;
    }

    /**
     * 设置签到类型(日签10、连续签到20、日签+连续签到30）
     *
     * @param signType 签到类型(日签10、连续签到20、日签+连续签到30）
     */
    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    /**
     * 获取是否停用（启用-0、停用-1）默认值0-启用
     *
     * @return disable - 是否停用（启用-0、停用-1）默认值0-启用
     */
    public Integer getDisable() {
        return disable;
    }

    /**
     * 设置是否停用（启用-0、停用-1）默认值0-启用
     *
     * @param disable 是否停用（启用-0、停用-1）默认值0-启用
     */
    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    /**
     * 获取是否删除（未删除-0、已删除-1）默认值0-未删除
     *
     * @return delete_flag - 是否删除（未删除-0、已删除-1）默认值0-未删除
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置是否删除（未删除-0、已删除-1）默认值0-未删除
     *
     * @param deleteFlag 是否删除（未删除-0、已删除-1）默认值0-未删除
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取规则文案
     *
     * @return rule_desc - 规则文案
     */
    public String getRuleDesc() {
        return ruleDesc;
    }

    /**
     * 设置规则文案
     *
     * @param ruleDesc 规则文案
     */
    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc == null ? null : ruleDesc.trim();
    }

    /**
     * 获取创建人UID
     *
     * @return creator_uid - 创建人UID
     */
    public Long getCreatorUid() {
        return creatorUid;
    }

    /**
     * 设置创建人UID
     *
     * @param creatorUid 创建人UID
     */
    public void setCreatorUid(Long creatorUid) {
        this.creatorUid = creatorUid;
    }

    /**
     * 获取创建人名称
     *
     * @return creator_name - 创建人名称
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * 设置创建人名称
     *
     * @param creatorName 创建人名称
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
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
     * 获取修改人UID
     *
     * @return modifier_uid - 修改人UID
     */
    public Long getModifierUid() {
        return modifierUid;
    }

    /**
     * 设置修改人UID
     *
     * @param modifierUid 修改人UID
     */
    public void setModifierUid(Long modifierUid) {
        this.modifierUid = modifierUid;
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