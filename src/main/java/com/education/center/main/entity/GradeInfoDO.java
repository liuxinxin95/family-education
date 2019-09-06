package com.education.center.main.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "grade_info")
public class GradeInfoDO {
    @Id
    private Integer id;

    /**
     * 年级名称
     */
    @Column(name = "grade_name")
    private String gradeName;

    /**
     * 夫级id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "create_time")
    private Date createTime;

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
     * 获取年级名称
     *
     * @return grade_name - 年级名称
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * 设置年级名称
     *
     * @param gradeName 年级名称
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    /**
     * 获取夫级id
     *
     * @return parent_id - 夫级id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置夫级id
     *
     * @param parentId 夫级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}