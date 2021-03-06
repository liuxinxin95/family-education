package com.education.center.main.service;

import com.education.center.main.vo.SubjectInfoVO;

import java.util.List;

/**
 * @author Carl
 * @ClassName SubjectInfoService
 * @Description
 * @date 2019-10-01 00:00
 **/
public interface SubjectInfoService {

    /**
     * 获取所有科目
     *
     * @return
     */
    List<SubjectInfoVO> getAll();

    /**
     * 根据年级获取科目
     *
     * @param gradeId
     * @return
     */
    List<SubjectInfoVO> getByGrade(Integer gradeId);

    /**
     * 科目添加
     * @param gradeId
     * @param name
     */
    void addSubject(Integer gradeId, String name);

    void updateSubject(Integer id, String name);

    void deleteSubject(Integer id);
}
