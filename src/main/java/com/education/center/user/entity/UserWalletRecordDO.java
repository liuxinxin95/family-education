package com.education.center.user.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_wallet_record")
public class UserWalletRecordDO {
    @Id
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * 钱包id
     */
    @Column(name = "wallet_id")
    private Integer walletId;

    /**
     * 收支类型
     */
    @Column(name = "disburse_type")
    private String disburseType;

    /**
     * 收支金额
     */
    @Column(name = "disburse_amount")
    private Long disburseAmount;

    /**
     * 收支状态
     */
    @Column(name = "disburse_status")
    private Integer disburseStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取钱包id
     *
     * @return wallet_id - 钱包id
     */
    public Integer getWalletId() {
        return walletId;
    }

    /**
     * 设置钱包id
     *
     * @param walletId 钱包id
     */
    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    /**
     * 获取收支类型
     *
     * @return disburse_type - 收支类型
     */
    public String getDisburseType() {
        return disburseType;
    }

    /**
     * 设置收支类型
     *
     * @param disburseType 收支类型
     */
    public void setDisburseType(String disburseType) {
        this.disburseType = disburseType == null ? null : disburseType.trim();
    }

    /**
     * 获取收支金额
     *
     * @return disburse_amount - 收支金额
     */
    public Long getDisburseAmount() {
        return disburseAmount;
    }

    /**
     * 设置收支金额
     *
     * @param disburseAmount 收支金额
     */
    public void setDisburseAmount(Long disburseAmount) {
        this.disburseAmount = disburseAmount;
    }

    /**
     * 获取收支状态
     *
     * @return disburse_status - 收支状态
     */
    public Integer getDisburseStatus() {
        return disburseStatus;
    }

    /**
     * 设置收支状态
     *
     * @param disburseStatus 收支状态
     */
    public void setDisburseStatus(Integer disburseStatus) {
        this.disburseStatus = disburseStatus;
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
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}