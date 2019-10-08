package com.education.center.need.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "need_info")
public class NeedInfoDO {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 姓名或昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别
     */
    private Integer sax;

    /**
     * 最高学历
     */
    @Column(name = "tallest_diploma")
    private String tallestDiploma;

    /**
     * 毕业院校
     */
    @Column(name = "graduate_institutions")
    private String graduateInstitutions;

    /**
     * 所选专业
     */
    private String specialized;

    /**
     * 任教学校
     */
    @Column(name = "teaching_school")
    private String teachingSchool;

    /**
     * 教学年龄
     */
    @Column(name = "teaching_age")
    private String teachingAge;

    /**
     * 授课科目id
     */
    @Column(name = "teaching_subject_id")
    private Integer teachingSubjectId;

    /**
     * 授课年级id
     */
    @Column(name = "teaching_grade_id")
    private Integer teachingGradeId;

    /**
     * 授课地址
     */
    @Column(name = "teaching_address")
    private String teachingAddress;

    /**
     * 教学方式
     */
    @Column(name = "teaching_mode")
    private String teachingMode;

    /**
     * 教学时间
     */
    @Column(name = "teaching_time")
    private String teachingTime;

    /**
     * 酬金
     */
    private Integer remuneration;

    /**
     * 教学特点
     */
    @Column(name = "teaching_feature")
    private String teachingFeature;

    /**
     * 经度
     */
    private String lon;

    /**
     * 维度
     */
    private String lat;

    /**
     * 需求类型：0老师1学生
     */
    @Column(name = "need_type")
    private Integer needType;

    /**
     * 老师照片
     */
    @Column(name = "teacher_photo")
    private String teacherPhoto;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取姓名或昵称
     *
     * @return nick_name - 姓名或昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置姓名或昵称
     *
     * @param nickName 姓名或昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取性别
     *
     * @return sax - 性别
     */
    public Integer getSax() {
        return sax;
    }

    /**
     * 设置性别
     *
     * @param sax 性别
     */
    public void setSax(Integer sax) {
        this.sax = sax;
    }

    /**
     * 获取最高学历
     *
     * @return tallest_diploma - 最高学历
     */
    public String getTallestDiploma() {
        return tallestDiploma;
    }

    /**
     * 设置最高学历
     *
     * @param tallestDiploma 最高学历
     */
    public void setTallestDiploma(String tallestDiploma) {
        this.tallestDiploma = tallestDiploma == null ? null : tallestDiploma.trim();
    }

    /**
     * 获取毕业院校
     *
     * @return graduate_institutions - 毕业院校
     */
    public String getGraduateInstitutions() {
        return graduateInstitutions;
    }

    /**
     * 设置毕业院校
     *
     * @param graduateInstitutions 毕业院校
     */
    public void setGraduateInstitutions(String graduateInstitutions) {
        this.graduateInstitutions = graduateInstitutions == null ? null : graduateInstitutions.trim();
    }

    /**
     * 获取所选专业
     *
     * @return specialized - 所选专业
     */
    public String getSpecialized() {
        return specialized;
    }

    /**
     * 设置所选专业
     *
     * @param specialized 所选专业
     */
    public void setSpecialized(String specialized) {
        this.specialized = specialized == null ? null : specialized.trim();
    }

    /**
     * 获取任教学校
     *
     * @return teaching_school - 任教学校
     */
    public String getTeachingSchool() {
        return teachingSchool;
    }

    /**
     * 设置任教学校
     *
     * @param teachingSchool 任教学校
     */
    public void setTeachingSchool(String teachingSchool) {
        this.teachingSchool = teachingSchool == null ? null : teachingSchool.trim();
    }

    /**
     * 获取教学年龄
     *
     * @return teaching_age - 教学年龄
     */
    public String getTeachingAge() {
        return teachingAge;
    }

    /**
     * 设置教学年龄
     *
     * @param teachingAge 教学年龄
     */
    public void setTeachingAge(String teachingAge) {
        this.teachingAge = teachingAge == null ? null : teachingAge.trim();
    }

    /**
     * 获取授课科目id
     *
     * @return teaching_subject_id - 授课科目id
     */
    public Integer getTeachingSubjectId() {
        return teachingSubjectId;
    }

    /**
     * 设置授课科目id
     *
     * @param teachingSubjectId 授课科目id
     */
    public void setTeachingSubjectId(Integer teachingSubjectId) {
        this.teachingSubjectId = teachingSubjectId;
    }

    /**
     * 获取授课年级id
     *
     * @return teaching_grade_id - 授课年级id
     */
    public Integer getTeachingGradeId() {
        return teachingGradeId;
    }

    /**
     * 设置授课年级id
     *
     * @param teachingGradeId 授课年级id
     */
    public void setTeachingGradeId(Integer teachingGradeId) {
        this.teachingGradeId = teachingGradeId;
    }

    /**
     * 获取授课地址
     *
     * @return teaching_address - 授课地址
     */
    public String getTeachingAddress() {
        return teachingAddress;
    }

    /**
     * 设置授课地址
     *
     * @param teachingAddress 授课地址
     */
    public void setTeachingAddress(String teachingAddress) {
        this.teachingAddress = teachingAddress == null ? null : teachingAddress.trim();
    }

    /**
     * 获取教学方式
     *
     * @return teaching_mode - 教学方式
     */
    public String getTeachingMode() {
        return teachingMode;
    }

    /**
     * 设置教学方式
     *
     * @param teachingMode 教学方式
     */
    public void setTeachingMode(String teachingMode) {
        this.teachingMode = teachingMode == null ? null : teachingMode.trim();
    }

    /**
     * 获取教学时间
     *
     * @return teaching_time - 教学时间
     */
    public String getTeachingTime() {
        return teachingTime;
    }

    /**
     * 设置教学时间
     *
     * @param teachingTime 教学时间
     */
    public void setTeachingTime(String teachingTime) {
        this.teachingTime = teachingTime;
    }

    /**
     * 获取酬金
     *
     * @return remuneration - 酬金
     */
    public Integer getRemuneration() {
        return remuneration;
    }

    /**
     * 设置酬金
     *
     * @param remuneration 酬金
     */
    public void setRemuneration(Integer remuneration) {
        this.remuneration = remuneration;
    }

    /**
     * 获取教学特点
     *
     * @return teaching_feature - 教学特点
     */
    public String getTeachingFeature() {
        return teachingFeature;
    }

    /**
     * 设置教学特点
     *
     * @param teachingFeature 教学特点
     */
    public void setTeachingFeature(String teachingFeature) {
        this.teachingFeature = teachingFeature == null ? null : teachingFeature.trim();
    }

    /**
     * 获取经度
     *
     * @return lon - 经度
     */
    public String getLon() {
        return lon;
    }

    /**
     * 设置经度
     *
     * @param lon 经度
     */
    public void setLon(String lon) {
        this.lon = lon == null ? null : lon.trim();
    }

    /**
     * 获取维度
     *
     * @return lat - 维度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置维度
     *
     * @param lat 维度
     */
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    /**
     * 获取需求类型：0老师1学生
     *
     * @return need_type - 需求类型：0老师1学生
     */
    public Integer getNeedType() {
        return needType;
    }

    /**
     * 设置需求类型：0老师1学生
     *
     * @param needType 需求类型：0老师1学生
     */
    public void setNeedType(Integer needType) {
        this.needType = needType;
    }

    /**
     * 获取老师照片
     *
     * @return teacher_photo - 老师照片
     */
    public String getTeacherPhoto() {
        return teacherPhoto;
    }

    /**
     * 设置老师照片
     *
     * @param teacherPhoto 老师照片
     */
    public void setTeacherPhoto(String teacherPhoto) {
        this.teacherPhoto = teacherPhoto == null ? null : teacherPhoto.trim();
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