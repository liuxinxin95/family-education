package com.education.center.organization.service;

import com.education.api.param.QueryOrganizationParam;
import com.education.api.vo.ApiOrganizationVO;
import com.education.api.vo.ApiTeacherVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Carl
 * @ClassName OrganizationService
 * @Description
 * @date 2019-11-04 23:16
 **/
public interface OrganizationService {


    PageInfo<ApiOrganizationVO> getOrganizationList(QueryOrganizationParam param);


    List<ApiTeacherVO> getOrganizationTeam(Integer id);
}
