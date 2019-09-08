package com.education.center.user.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUserDO {
    @Id
    private Integer id;

    /**
     * 微信id
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 用户名称默认微信昵称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 性别：0女1男
     */
    private Long sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 职业
     */
    private String professional;

    /**
     * 城市编码
     */
    @Column(name = "city_code")
    private String cityCode;

    /**
     * 区域编码
     */
    @Column(name = "street_code")
    private String streetCode;

    /**
     * 具体地址
     */
    private String address;

    /**
     * 邀请码
     */
    @Column(name = "Invite_code")
    private Integer inviteCode;

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
     * 获取微信id
     *
     * @return openId - 微信id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信id
     *
     * @param openid 微信id
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取用户名称默认微信昵称
     *
     * @return user_name - 用户名称默认微信昵称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称默认微信昵称
     *
     * @param userName 用户名称默认微信昵称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取用户手机号
     *
     * @return phone - 用户手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置用户手机号
     *
     * @param phone 用户手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取性别：0女1男
     *
     * @return sex - 性别：0女1男
     */
    public Long getSex() {
        return sex;
    }

    /**
     * 设置性别：0女1男
     *
     * @param sex 性别：0女1男
     */
    public void setSex(Long sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
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
     * 获取区域编码
     *
     * @return street_code - 区域编码
     */
    public String getStreetCode() {
        return streetCode;
    }

    /**
     * 设置区域编码
     *
     * @param streetCode 区域编码
     */
    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode == null ? null : streetCode.trim();
    }

    /**
     * 获取具体地址
     *
     * @return address - 具体地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置具体地址
     *
     * @param address 具体地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取邀请码
     *
     * @return Invite_code - 邀请码
     */
    public Integer getInviteCode() {
        return inviteCode;
    }

    /**
     * 设置邀请码
     *
     * @param inviteCode 邀请码
     */
    public void setInviteCode(Integer inviteCode) {
        this.inviteCode = inviteCode;
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

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }
}