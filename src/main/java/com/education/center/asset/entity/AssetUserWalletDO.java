package com.education.center.asset.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "asset_user_wallet")
public class AssetUserWalletDO {
    /**
     * 主键(用户id)
     */
    @Id
    private Integer id;

    /**
     * 钱包余额
     */
    @Column(name = "current_amount")
    private Long currentAmount;

    /**
     * 可提现金额
     */
    @Column(name = "max_withdraw_amount")
    private Long maxWithdrawAmount;

    /**
     * 1--可用，0-不可用
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取主键(用户id)
     *
     * @return id - 主键(用户id)
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键(用户id)
     *
     * @param id 主键(用户id)
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取钱包余额
     *
     * @return current_amount - 钱包余额
     */
    public Long getCurrentAmount() {
        return currentAmount;
    }

    /**
     * 设置钱包余额
     *
     * @param currentAmount 钱包余额
     */
    public void setCurrentAmount(Long currentAmount) {
        this.currentAmount = currentAmount;
    }

    /**
     * 获取可提现金额
     *
     * @return max_withdraw_amount - 可提现金额
     */
    public Long getMaxWithdrawAmount() {
        return maxWithdrawAmount;
    }

    /**
     * 设置可提现金额
     *
     * @param maxWithdrawAmount 可提现金额
     */
    public void setMaxWithdrawAmount(Long maxWithdrawAmount) {
        this.maxWithdrawAmount = maxWithdrawAmount;
    }

    /**
     * 获取1--可用，0-不可用
     *
     * @return status - 1--可用，0-不可用
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置1--可用，0-不可用
     *
     * @param status 1--可用，0-不可用
     */
    public void setStatus(Byte status) {
        this.status = status;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}