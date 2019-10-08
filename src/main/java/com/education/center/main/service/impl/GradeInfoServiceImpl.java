package com.education.center.main.service.impl;

import com.education.center.main.entity.GradeInfoDO;
import com.education.center.main.mapper.GradeInfoDOMapper;
import com.education.center.main.service.GradeInfoService;
import com.education.center.main.vo.GradeInfoVO;
import com.education.util.BeanMapUtil;
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
     * 获取全部年级信息
     *
     * @return
     */
    @Override
    public List<GradeInfoVO> getAll() {
        List<GradeInfoDO> grade = gradeInfoDOMapper.selectAll();
        return BeanMapUtil.convertList(grade, GradeInfoVO.class);
    }

}
