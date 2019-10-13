package com.education.center.main.service;

import com.education.center.main.vo.GradeInfoTreeVO;
import com.education.center.main.vo.GradeInfoVO;

import java.util.List;

/**
 * @author Carl
 * @ClassName GradeInfoService
 * @Description 年级信息
 * @date 2019-10-01 00:08
 **/
public interface GradeInfoService {


    /**
     * 获取所有年纪
     * @return
     */
    List<GradeInfoTreeVO> getAll();

    /**
     * 只获取夫级年级名称
     * @return
     */
    List<GradeInfoTreeVO> getParent();
}
