package com.education.center.main.service.impl;

import com.education.center.main.entity.GradeInfoDO;
import com.education.center.main.mapper.GradeInfoDOMapper;
import com.education.center.main.service.GradeInfoService;
import com.education.center.main.vo.GradeInfoTreeVO;
import com.education.exception.RRException;
import com.education.util.BeanMapUtil;
import com.education.util.TreeUtil;
import lombok.extern.log4j.Log4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    /**
     * 年级添加
     * @param name
     * @param pid
     */
    @Override
    public void addGrade(String name,Integer pid){
        GradeInfoDO gradeInfoDO = new GradeInfoDO();
        gradeInfoDO.setGradeName(name);
        List<GradeInfoDO> infoDOS = gradeInfoDOMapper.select(gradeInfoDO);
        if (CollectionUtils.isNotEmpty(infoDOS)){
            throw new RRException("年级名称重复请勿重新添加");
        }
        gradeInfoDO.setParentId(pid);
        gradeInfoDO.setCreateTime(new Date());
        gradeInfoDO.setUpdateTime(new Date());
        gradeInfoDOMapper.insert(gradeInfoDO);
    }

    /**
     * 年级删除
     * @param id
     */
    @Override
    public void deleteGrade(Integer id){
        gradeInfoDOMapper.deleteByPrimaryKey(id);
    }


    /**
     * 年级修改
     * @param id
     * @param name
     */
    @Override
    public void updateGrade(Integer id,String name){
        GradeInfoDO gradeInfoDO = gradeInfoDOMapper.selectByPrimaryKey(id);
        gradeInfoDO.setGradeName(name);
        gradeInfoDOMapper.updateByPrimaryKeySelective(gradeInfoDO);
    }

}
