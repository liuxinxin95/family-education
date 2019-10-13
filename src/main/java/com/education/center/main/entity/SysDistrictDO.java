package com.education.center.main.entity;

import javax.persistence.*;

@Table(name = "sys_district")
public class SysDistrictDO {
    /**
     * 自增id
     */
    @Id
    @Column(name = "district_id")
    private Integer districtId;

    /**
     * 父及关系
     */
    private Integer pid;

    /**
     * 地区名称
     */
    private String district;

    /**
     * 子属关系
     */
    private Boolean level;

    /**
     * 首字母拼音
     */
    private String initial;

    /**
     * 获取自增id
     *
     * @return district_id - 自增id
     */
    public Integer getDistrictId() {
        return districtId;
    }

    /**
     * 设置自增id
     *
     * @param districtId 自增id
     */
    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    /**
     * 获取父及关系
     *
     * @return pid - 父及关系
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父及关系
     *
     * @param pid 父及关系
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取地区名称
     *
     * @return district - 地区名称
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置地区名称
     *
     * @param district 地区名称
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * 获取子属关系
     *
     * @return level - 子属关系
     */
    public Boolean getLevel() {
        return level;
    }

    /**
     * 设置子属关系
     *
     * @param level 子属关系
     */
    public void setLevel(Boolean level) {
        this.level = level;
    }

    /**
     * 获取首字母拼音
     *
     * @return initial - 首字母拼音
     */
    public String getInitial() {
        return initial;
    }

    /**
     * 设置首字母拼音
     *
     * @param initial 首字母拼音
     */
    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }
}