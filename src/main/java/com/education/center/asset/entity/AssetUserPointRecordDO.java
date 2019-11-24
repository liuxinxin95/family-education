package com.education.center.asset.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "asset_user_point_record")
public class AssetUserPointRecordDO {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 交易编号（订单号）
     */
    @Column(name = "trade_no")
    private String tradeNo;

    /**
     * 业务类型分类
     */
    @Column(name = "trade_code")
    private String tradeCode;

    /**
     * 交易金额
     */
    @Column(name = "trade_amount")
    private Long tradeAmount;

    /**
     * 交易前余额
     */
    @Column(name = "pre_trade_amount")
    private Long preTradeAmount;

    /**
     * 交易后余额
     */
    @Column(name = "post_trade_amount")
    private Long postTradeAmount;

    /**
     * 交易时间
     */
    @Column(name = "trade_time")
    private Date tradeTime;

    /**
     * 交易日期
     */
    @Column(name = "trade_date")
    private Date tradeDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取交易编号（订单号）
     *
     * @return trade_no - 交易编号（订单号）
     */
    public String getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易编号（订单号）
     *
     * @param tradeNo 交易编号（订单号）
     */
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    /**
     * 获取业务类型分类
     *
     * @return trade_code - 业务类型分类
     */
    public String getTradeCode() {
        return tradeCode;
    }

    /**
     * 设置业务类型分类
     *
     * @param tradeCode 业务类型分类
     */
    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode == null ? null : tradeCode.trim();
    }

    /**
     * 获取交易金额
     *
     * @return trade_amount - 交易金额
     */
    public Long getTradeAmount() {
        return tradeAmount;
    }

    /**
     * 设置交易金额
     *
     * @param tradeAmount 交易金额
     */
    public void setTradeAmount(Long tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    /**
     * 获取交易前余额
     *
     * @return pre_trade_amount - 交易前余额
     */
    public Long getPreTradeAmount() {
        return preTradeAmount;
    }

    /**
     * 设置交易前余额
     *
     * @param preTradeAmount 交易前余额
     */
    public void setPreTradeAmount(Long preTradeAmount) {
        this.preTradeAmount = preTradeAmount;
    }

    /**
     * 获取交易后余额
     *
     * @return post_trade_amount - 交易后余额
     */
    public Long getPostTradeAmount() {
        return postTradeAmount;
    }

    /**
     * 设置交易后余额
     *
     * @param postTradeAmount 交易后余额
     */
    public void setPostTradeAmount(Long postTradeAmount) {
        this.postTradeAmount = postTradeAmount;
    }

    /**
     * 获取交易时间
     *
     * @return trade_time - 交易时间
     */
    public Date getTradeTime() {
        return tradeTime;
    }

    /**
     * 设置交易时间
     *
     * @param tradeTime 交易时间
     */
    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    /**
     * 获取交易日期
     *
     * @return trade_date - 交易日期
     */
    public Date getTradeDate() {
        return tradeDate;
    }

    /**
     * 设置交易日期
     *
     * @param tradeDate 交易日期
     */
    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}