package com.education.center.main.service.impl;

import com.education.center.main.entity.GradeInfoDO;
import com.education.center.main.mapper.GradeInfoDOMapper;
import com.education.center.main.service.GradeInfoService;
import com.education.center.main.vo.GradeInfoTreeVO;
import com.education.util.BeanMapUtil;
import com.education.util.TreeUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Carl
 * @ClassName GradeInfoServiceImpl
 * @Description
 * @date 2019-10-01 00:08
 **/
@Service
@Primary
public class GradeInfoServiceImpl implements GradeInfoService {

    @Resource
    private GradeInfoDOMapper gradeInfoDOMapper;


    /**
     * 只获取夫级年级名称
     *
     * @return
     */
    @Override
    public List<GradeInfoTreeVO> getParent() {
        GradeInfoDO gradeInfoDO = new GradeInfoDO();
        gradeInfoDO.setParentId(0);
        List<GradeInfoDO> grade = gradeInfoDOMapper.select(gradeInfoDO);
        return BeanMapUtil.convertList(grade, GradeInfoTreeVO.class);
    }

    /**
     * 以树状结构展示年级信息
     *
     * @return
     */
    @Override
    public List<GradeInfoTreeVO> getAll() {
        List<GradeInfoDO> gradeInfoDOS = gradeInfoDOMapper.selectAll();
        List<GradeInfoTreeVO> gradeInfoTreeVOS = BeanMapUtil.convertList(gradeInfoDOS, GradeInfoTreeVO.class);
        return TreeUtil.bulid(gradeInfoTreeVOS, 0);
    }
}
