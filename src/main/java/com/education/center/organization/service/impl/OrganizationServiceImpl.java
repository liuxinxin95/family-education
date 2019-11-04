package com.education.center.organization.service.impl;

import com.education.api.param.QueryOrganizationParam;
import com.education.api.vo.ApiOrganizationVO;
import com.education.api.vo.ApiTeacherVO;
import com.education.center.organization.service.OrganizationService;
import com.education.center.user.entity.UserInfoDO;
import com.education.center.user.enums.UserCertificationEnum;
import com.education.center.user.mapper.SysUserDOMapper;
import com.education.center.user.mapper.UserInfoDOMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Carl
 * @ClassName OrganizationServiceImpl
 * @Description
 * @date 2019-11-04 23:16
 **/
@Service
@Primary
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    private SysUserDOMapper sysUserDOMapper;

    @Resource
    private UserInfoDOMapper userInfoDOMapper;

    /**
     * 老师列表
     *
     * @param param
     * @return
     */
    @Override
    public PageInfo<ApiOrganizationVO> getOrganizationList(QueryOrganizationParam param) {
        PageInfo<ApiOrganizationVO> pageInfo = PageHelper.startPage(param.getPageNum(), param.getPageSize()).doSelectPageInfo(() -> sysUserDOMapper.selectOrganization(param));
        List<ApiOrganizationVO> apiOrganizationVOS = userInfoDOMapper.selectOrganizationTeacherNum(pageInfo.getList().stream().map(ApiOrganizationVO::getId).collect(Collectors.toList()));
        Map<Integer, ApiOrganizationVO> map = apiOrganizationVOS.stream().collect(Collectors.toMap(ApiOrganizationVO::getId, p -> p));

        pageInfo.getList().stream().forEach(x -> {
            if (x.getCertificationType() != null) {
                x.setCertificationText(UserCertificationEnum.valueType(x.getCertificationType()));
            } else {
                x.setCertificationText(UserCertificationEnum.UNVERIFIED.getName());
            }
            if (x.getPayType() != null) {
                x.setPayTypeText(x.getPayType() == 0 ? "未缴费" : "已缴费");
            } else {
                x.setPayTypeText("未缴费");
            }
            if (map.get(x.getId()) != null) {
                x.setTeacherNum(map.get(x.getId()).getTeacherNum());
            } else {
                x.setTeacherNum(0);
            }
        });
        return pageInfo;
    }

    /**
     * 机构成员信息
     * @param id
     * @return
     */
    @Override
    public List<ApiTeacherVO> getOrganizationTeam(Integer id){
        UserInfoDO infoDO = new UserInfoDO();
        infoDO.setOrganizationId(id);
        List<UserInfoDO> infoDOS = userInfoDOMapper.select(infoDO);
        if (CollectionUtils.isNotEmpty(infoDOS)){
            return sysUserDOMapper.selectTeacherByList(infoDOS.stream().map(UserInfoDO::getId).collect(Collectors.toList()));
        }
        return new ArrayList<>();
    }

}
