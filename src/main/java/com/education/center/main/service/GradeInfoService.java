package com.education.center.main.service;

import com.education.center.main.vo.GradeInfoTreeVO;

import java.util.List;

/**
 * @author Carl
 * @ClassName GradeInfoService
 * @Description
 * @date 2019-10-01 00:08
 **/
public interface GradeInfoService {


    /**
     * 只获取夫级年级名称
     * @return
     */
    List<GradeInfoTreeVO> getParent();

    /**
     * 以树状形式展示年级信息
     * @return
     */
    List<GradeInfoTreeVO> getAll();
}
