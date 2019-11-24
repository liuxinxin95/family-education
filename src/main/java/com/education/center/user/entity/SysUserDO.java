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
     * 具体地址
     */
    private String address;

    /**
     * 邀请码
     */
    @Column(name = "invite_code")
    private Integer inviteCode;

    /**
     * 职业
     */
    private String professional;

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
     * 用户类型、1老师，2机构
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 省份id
     */
    @Column(name = "province_id")
    private Integer provinceId;

    /**
     * 城市id
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 区域id
     */
    @Column(name = "district_id")
    private Integer districtId;

    /**
     * 头像
     */
    private String avatar;


    /**
     * 关联邀请人
     */
    @Column(name = "inviter_user_id")
    private Integer inviterUserId;

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
     * @return open_id - 微信id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信id
     *
     * @param openId 微信id
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
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
     * @return invite_code - 邀请码
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
     * 获取职业
     *
     * @return professional - 职业
     */
    public String getProfessional() {
        return professional;
    }

    /**
     * 设置职业
     *
     * @param professional 职业
     */
    public void setProfessional(String professional) {
        this.professional = professional == null ? null : professional.trim();
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

    /**
     * 获取用户类型、1老师，2机构
     *
     * @return user_type - 用户类型、1老师，2机构
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置用户类型、1老师，2机构
     *
     * @param userType 用户类型、1老师，2机构
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取省份id
     *
     * @return province_id - 省份id
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     * 设置省份id
     *
     * @param provinceId 省份id
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * 获取城市id
     *
     * @return city_id - 城市id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置城市id
     *
     * @param cityId 城市id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取区域id
     *
     * @return district_id - 区域id
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * 设置区域id
     *
     * @param districtId 区域id
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
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

    public Integer getInviterUserId() {
        return inviterUserId;
    }

    public void setInviterUserId(Integer inviterUserId) {
        this.inviterUserId = inviterUserId;
    }
}