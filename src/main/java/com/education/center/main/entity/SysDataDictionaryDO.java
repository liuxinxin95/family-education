package com.education.center.main.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_data_dictionary")
public class SysDataDictionaryDO {
    /**
     * 唯一标识
     */
    @Id
    private Long id;

    /**
     * 数据类别
     */
    @Column(name = "data_type")
    private String dataType;

    /**
     * 数据编码
     */
    @Column(name = "data_code")
    private String dataCode;

    /**
     * 数据值
     */
    @Column(name = "data_value")
    private String dataValue;

    /**
     * 参数值编码扩展
     */
    @Column(name = "data_value_code")
    private String dataValueCode;

    /**
     * 顺序
     */
    @Column(name = "sort_no")
    private Integer sortNo;

    /**
     * 0有效,1无效
     */
    private Byte status;

    /**
     * 数据描述
     */
    @Column(name = "data_desc")
    private String dataDesc;

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
     * 获取唯一标识
     *
     * @return id - 唯一标识
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置唯一标识
     *
     * @param id 唯一标识
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取数据类别
     *
     * @return data_type - 数据类别
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * 设置数据类别
     *
     * @param dataType 数据类别
     */
    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    /**
     * 获取数据编码
     *
     * @return data_code - 数据编码
     */
    public String getDataCode() {
        return dataCode;
    }

    /**
     * 设置数据编码
     *
     * @param dataCode 数据编码
     */
    public void setDataCode(String dataCode) {
        this.dataCode = dataCode == null ? null : dataCode.trim();
    }

    /**
     * 获取数据值
     *
     * @return data_value - 数据值
     */
    public String getDataValue() {
        return dataValue;
    }

    /**
     * 设置数据值
     *
     * @param dataValue 数据值
     */
    public void setDataValue(String dataValue) {
        this.dataValue = dataValue == null ? null : dataValue.trim();
    }

    /**
     * 获取参数值编码扩展
     *
     * @return data_value_code - 参数值编码扩展
     */
    public String getDataValueCode() {
        return dataValueCode;
    }

    /**
     * 设置参数值编码扩展
     *
     * @param dataValueCode 参数值编码扩展
     */
    public void setDataValueCode(String dataValueCode) {
        this.dataValueCode = dataValueCode == null ? null : dataValueCode.trim();
    }

    /**
     * 获取顺序
     *
     * @return sort_no - 顺序
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * 设置顺序
     *
     * @param sortNo 顺序
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * 获取0有效,1无效
     *
     * @return status - 0有效,1无效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置0有效,1无效
     *
     * @param status 0有效,1无效
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取数据描述
     *
     * @return data_desc - 数据描述
     */
    public String getDataDesc() {
        return dataDesc;
    }

    /**
     * 设置数据描述
     *
     * @param dataDesc 数据描述
     */
    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc == null ? null : dataDesc.trim();
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