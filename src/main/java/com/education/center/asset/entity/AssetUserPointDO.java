package com.education.center.asset.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "asset_user_point")
public class AssetUserPointDO {
    @Id
    private Integer id;


    /**
     * 积分余额
     */
    @Column(name = "amount_point")
    private Long amountPoint;

    /**
     * 1--可用，0-不可用
     */
    private Integer status;

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
     * 获取积分月
     *
     * @return amount_ point - 积分月
     */
    public Long getAmountPoint() {
        return amountPoint;
    }

    /**
     * 设置积分月
     *
     * @param amountPoint 积分月
     */
    public void setAmountPoint(Long amountPoint) {
        this.amountPoint = amountPoint;
    }

    /**
     * 获取1--可用，0-不可用
     *
     * @return status - 1--可用，0-不可用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1--可用，0-不可用
     *
     * @param status 1--可用，0-不可用
     */
    public void setStatus(Integer status) {
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