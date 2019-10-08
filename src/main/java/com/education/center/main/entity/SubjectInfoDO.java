package com.education.center.main.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "subject_info")
public class SubjectInfoDO {
    @Id
    private Integer id;

    /**
     * 科目名称
     */
    @Column(name = "subject_name")
    private String subjectName;

    /**
     * 年级id
     */
    @Column(name = "grade_id")
    private Integer gradeId;

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
     * 获取科目名称
     *
     * @return subject_name - 科目名称
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * 设置科目名称
     *
     * @param subjectName 科目名称
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    /**
     * 获取年级id
     *
     * @return grade_id - 年级id
     */
    public Integer getGradeId() {
        return gradeId;
    }

    /**
     * 设置年级id
     *
     * @param gradeId 年级id
     */
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
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