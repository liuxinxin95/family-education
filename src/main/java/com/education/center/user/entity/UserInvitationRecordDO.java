package com.education.center.user.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_invitation_record")
public class UserInvitationRecordDO {
    @Id
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    /**
     * 钱包id
     */
    @Column(name = "invitation_id")
    private Integer invitationId;

    /**
     * 收入标准1积分 2金钱
     */
    private Integer type;

    /**
     * 积分
     */
    private Long point;

    /**
     * 现金
     */
    private Long amount;

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
     * @return invitation_id - 钱包id
     */
    public Integer getInvitationId() {
        return invitationId;
    }

    /**
     * 设置钱包id
     *
     * @param invitationId 钱包id
     */
    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    /**
     * 获取收入标准1积分 2金钱
     *
     * @return type - 收入标准1积分 2金钱
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置收入标准1积分 2金钱
     *
     * @param type 收入标准1积分 2金钱
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取积分
     *
     * @return point - 积分
     */
    public Long getPoint() {
        return point;
    }

    /**
     * 设置积分
     *
     * @param point 积分
     */
    public void setPoint(Long point) {
        this.point = point;
    }

    /**
     * 获取现金
     *
     * @return amount - 现金
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 设置现金
     *
     * @param amount 现金
     */
    public void setAmount(Long amount) {
        this.amount = amount;
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