package com.education.center.teacher.service;

import com.education.api.param.AuditParam;
import com.education.api.param.QueryTeacherParam;
import com.education.api.vo.ApiTeacherVO;
import com.education.api.vo.TeacherCertificationVO;
import com.github.pagehelper.PageInfo;

/**
 * @author Carl
 * @ClassName TeacherService
 * @Description
 * @date 2019-11-02 17:02
 **/
public interface TeacherService {

    /**
     * 老师列表
     *
     * @param param
     * @return
     */
    PageInfo<ApiTeacherVO> getTeacherList(QueryTeacherParam param);


    /**
     * 获取老师的认证信息
     *
     * @param id
     * @return
     */
    TeacherCertificationVO getTeacherCer(Integer id);

    /**
     * 审核
     *
     * @param param
     */
    void teacherAudit(AuditParam param);
}
