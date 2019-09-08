package com.education.center.main.service.impl;

import com.education.center.main.entity.SysDistrictDO;
import com.education.center.main.mapper.SysDistrictDOMapper;
import com.education.util.PinyinUtils;
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
public class CityServiceImpl {

    @Resource
    private SysDistrictDOMapper sysDistrictDOMapper;

    public void convertForPinYin() {
        List<SysDistrictDO> sysDistrictDOS = sysDistrictDOMapper.selectAll();
//        sysDistrictDOS.parallelStream().forEach(x -> {
//            String alpha = PinyinUtils.getAlpha(x.getDistrict());
//            x.setInitial(alpha.substring(0, 1));
//        });
//        sysDistrictDOMapper.updateList(sysDistrictDOS);
    }
}
