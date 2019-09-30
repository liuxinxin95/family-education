package com.education.center.main.service.impl;

import com.education.center.main.entity.SubjectInfoDO;
import com.education.center.main.mapper.SubjectInfoDOMapper;
import com.education.center.main.service.SubjectInfoService;
import com.education.center.main.vo.SubjectInfoVO;
import com.education.util.BeanMapUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Carl
 * @ClassName SubjectInfoServiceImpl
 * @Description
 * @date 2019-10-01 00:01
 **/
@Service
@Primary
public class SubjectInfoServiceImpl implements SubjectInfoService {

    @Resource
    private SubjectInfoDOMapper subjectInfoDOMapper;

    /**
     * 获取所有科目
     * @return
     */
    @Override
    public List<SubjectInfoVO> getAll(){
        List<SubjectInfoDO> subjectInfoDOS = subjectInfoDOMapper.selectAll();
        return BeanMapUtil.convertList(subjectInfoDOS,SubjectInfoVO.class);
    }
}
