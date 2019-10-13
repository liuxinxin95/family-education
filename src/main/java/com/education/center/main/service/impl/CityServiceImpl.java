package com.education.center.main.service.impl;
import	java.util.Optional;

import com.education.center.main.entity.SysDistrictDO;
import com.education.center.main.mapper.SysDistrictDOMapper;
import com.education.center.main.service.CityService;
import com.education.center.main.vo.SysDistrictVO;
import com.education.util.BeanMapUtil;
import com.education.util.PinyinUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Carl
 * @ClassName CityServiceImpl
 * @Description
 * @date 2019-09-08 12:52
 **/
@Service
@Primary
public class CityServiceImpl implements CityService {

    @Resource
    private SysDistrictDOMapper sysDistrictDOMapper;


    /**
     * 根据夫级id获取城市信息
     *
     * @param parentId
     * @return
     */
    @Override
    public List<SysDistrictVO> getCityByPid(Integer parentId) {
        SysDistrictDO sysDistrictDO = new SysDistrictDO();
        sysDistrictDO.setPid(parentId);
        List<SysDistrictDO> districtDOS = sysDistrictDOMapper.select(sysDistrictDO);
        return BeanMapUtil.convertList(districtDOS, SysDistrictVO.class);
    }
}
