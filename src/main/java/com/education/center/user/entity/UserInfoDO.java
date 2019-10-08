package com.education.center.user.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfoDO {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 法人
     */
    @Column(name = "legal_person")
    private String legalPerson;

    /**
     * 身份证号码
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 营业执照号码
     */
    @Column(name = "business_license_number")
    private String businessLicenseNumber;

    /**
     * 身份证正面
     */
    @Column(name = "id_card_before_photo")
    private String idCardBeforePhoto;

    /**
     * 身份证反面
     */
    @Column(name = "id_card_after_photo")
    private String idCardAfterPhoto;

    /**
     * 手持身份证
     */
    @Column(name = "id_card_hand_photo")
    private String idCardHandPhoto;

    /**
     * 营业执照
     */
    @Column(name = "business_license_photo")
    private String businessLicensePhoto;

    /**
     * 教师资格证
     */
    @Column(name = "teacher_certification_photo")
    private String teacherCertificationPhoto;

    /**
     * 机构id：老师机构名称
     */
    @Column(name = "organization_id")
    private Integer organizationId;

    /**
     * 用户类型、1老师，2机构
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 审核状态 0未审核 1审核通过 2审核未通过
     */
    @Column(name = "examine_status")
    private Integer examineStatus;

    /**
     * 关联邀请人
     */
    @Column(name = "inviter_user_id")
    private Integer inviterUserId;

    /**
     * 缴费方式：0没有缴费 1个人缴费 2机构缴费
     */
    @Column(name = "pay_type")
    private Integer payType;

    /**
     * 个人缴费状态 ：0未交费 1缴费 
     */
    @Column(name = "pay_single_status")
    private Integer paySingleStatus;

    /**
     * 教师类型：0兼职1专职
     */
    @Column(name = "teacher_type")
    private Integer teacherType;

    /**
     * 认证状态：0未认证1认证中2认证失败3老师认证4机构认证
     */
    @Column(name = "certification_status")
    private Integer certificationStatus;

    /**
     * 驳回原因
     */
    @Column(name = "rejected_reason")
    private String rejectedReason;

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
     * 获取法人
     *
     * @return legal_person - 法人
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法人
     *
     * @param legalPerson 法人
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    /**
     * 获取身份证号码
     *
     * @return id_card - 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号码
     *
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 获取营业执照号码
     *
     * @return business_license_number - 营业执照号码
     */
    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    /**
     * 设置营业执照号码
     *
     * @param businessLicenseNumber 营业执照号码
     */
    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber == null ? null : businessLicenseNumber.trim();
    }

    /**
     * 获取身份证正面
     *
     * @return id_card_before_photo - 身份证正面
     */
    public String getIdCardBeforePhoto() {
        return idCardBeforePhoto;
    }

    /**
     * 设置身份证正面
     *
     * @param idCardBeforePhoto 身份证正面
     */
    public void setIdCardBeforePhoto(String idCardBeforePhoto) {
        this.idCardBeforePhoto = idCardBeforePhoto == null ? null : idCardBeforePhoto.trim();
    }

    /**
     * 获取身份证反面
     *
     * @return id_card_after_photo - 身份证反面
     */
    public String getIdCardAfterPhoto() {
        return idCardAfterPhoto;
    }

    /**
     * 设置身份证反面
     *
     * @param idCardAfterPhoto 身份证反面
     */
    public void setIdCardAfterPhoto(String idCardAfterPhoto) {
        this.idCardAfterPhoto = idCardAfterPhoto == null ? null : idCardAfterPhoto.trim();
    }

    /**
     * 获取手持身份证
     *
     * @return id_card_hand_photo - 手持身份证
     */
    public String getIdCardHandPhoto() {
        return idCardHandPhoto;
    }

    /**
     * 设置手持身份证
     *
     * @param idCardHandPhoto 手持身份证
     */
    public void setIdCardHandPhoto(String idCardHandPhoto) {
        this.idCardHandPhoto = idCardHandPhoto == null ? null : idCardHandPhoto.trim();
    }

    /**
     * 获取营业执照
     *
     * @return business_license_photo - 营业执照
     */
    public String getBusinessLicensePhoto() {
        return businessLicensePhoto;
    }

    /**
     * 设置营业执照
     *
     * @param businessLicensePhoto 营业执照
     */
    public void setBusinessLicensePhoto(String businessLicensePhoto) {
        this.businessLicensePhoto = businessLicensePhoto == null ? null : businessLicensePhoto.trim();
    }

    /**
     * 获取教师资格证
     *
     * @return teacher_certification_photo - 教师资格证
     */
    public String getTeacherCertificationPhoto() {
        return teacherCertificationPhoto;
    }

    /**
     * 设置教师资格证
     *
     * @param teacherCertificationPhoto 教师资格证
     */
    public void setTeacherCertificationPhoto(String teacherCertificationPhoto) {
        this.teacherCertificationPhoto = teacherCertificationPhoto == null ? null : teacherCertificationPhoto.trim();
    }

    /**
     * 获取机构id：老师机构名称
     *
     * @return organization_id - 机构id：老师机构名称
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置机构id：老师机构名称
     *
     * @param organizationId 机构id：老师机构名称
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
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
     * 获取审核状态 0未审核 1审核通过 2审核未通过
     *
     * @return examine_status - 审核状态 0未审核 1审核通过 2审核未通过
     */
    public Integer getExamineStatus() {
        return examineStatus;
    }

    /**
     * 设置审核状态 0未审核 1审核通过 2审核未通过
     *
     * @param examineStatus 审核状态 0未审核 1审核通过 2审核未通过
     */
    public void setExamineStatus(Integer examineStatus) {
        this.examineStatus = examineStatus;
    }

    /**
     * 获取关联邀请人
     *
     * @return inviter_user_id - 关联邀请人
     */
    public Integer getInviterUserId() {
        return inviterUserId;
    }

    /**
     * 设置关联邀请人
     *
     * @param inviterUserId 关联邀请人
     */
    public void setInviterUserId(Integer inviterUserId) {
        this.inviterUserId = inviterUserId;
    }

    /**
     * 获取缴费方式：0没有缴费 1个人缴费 2机构缴费
     *
     * @return pay_type - 缴费方式：0没有缴费 1个人缴费 2机构缴费
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 设置缴费方式：0没有缴费 1个人缴费 2机构缴费
     *
     * @param payType 缴费方式：0没有缴费 1个人缴费 2机构缴费
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 获取个人缴费状态 ：0未交费 1缴费 
     *
     * @return pay_single_status - 个人缴费状态 ：0未交费 1缴费 
     */
    public Integer getPaySingleStatus() {
        return paySingleStatus;
    }

    /**
     * 设置个人缴费状态 ：0未交费 1缴费 
     *
     * @param paySingleStatus 个人缴费状态 ：0未交费 1缴费 
     */
    public void setPaySingleStatus(Integer paySingleStatus) {
        this.paySingleStatus = paySingleStatus;
    }

    /**
     * 获取教师类型：0兼职1专职
     *
     * @return teacher_type - 教师类型：0兼职1专职
     */
    public Integer getTeacherType() {
        return teacherType;
    }

    /**
     * 设置教师类型：0兼职1专职
     *
     * @param teacherType 教师类型：0兼职1专职
     */
    public void setTeacherType(Integer teacherType) {
        this.teacherType = teacherType;
    }

    /**
     * 获取认证状态：0未认证1认证中2认证失败3老师认证4机构认证
     *
     * @return certification_status - 认证状态：0未认证1认证中2认证失败3老师认证4机构认证
     */
    public Integer getCertificationStatus() {
        return certificationStatus;
    }

    /**
     * 设置认证状态：0未认证1认证中2认证失败3老师认证4机构认证
     *
     * @param certificationStatus 认证状态：0未认证1认证中2认证失败3老师认证4机构认证
     */
    public void setCertificationStatus(Integer certificationStatus) {
        this.certificationStatus = certificationStatus;
    }

    /**
     * 获取驳回原因
     *
     * @return rejected_reason - 驳回原因
     */
    public String getRejectedReason() {
        return rejectedReason;
    }

    /**
     * 设置驳回原因
     *
     * @param rejectedReason 驳回原因
     */
    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason == null ? null : rejectedReason.trim();
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