package com.education.center.main.service;

import com.education.center.main.vo.SysDistrictVO;

import java.util.List;

/**
 * @author Carl
 * @ClassName CityService
 * @Description
 * @date 2019-10-13 14:04
 **/
public interface CityService {

    List<SysDistrictVO> getCityByPid(Integer parentId);
}
