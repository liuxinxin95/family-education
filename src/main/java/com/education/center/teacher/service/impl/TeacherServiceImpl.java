package com.education.center.teacher.service.impl;

import com.education.api.param.QueryTeacherParam;
import com.education.api.vo.ApiTeacherVO;
import com.education.center.need.vo.NeedInfoVO;
import com.education.center.teacher.service.TeacherService;
import com.education.center.user.enums.UserCertificationEnum;
import com.education.center.user.mapper.SysUserDOMapper;
import com.education.center.user.mapper.UserInfoDOMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName TeacherServiceImpl
 * @Description
 * @date 2019-11-02 17:02
 **/
@Service
@Primary
public class TeacherServiceImpl implements TeacherService {

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
    public PageInfo<ApiTeacherVO> getTeacherList(QueryTeacherParam param) {
        PageInfo<ApiTeacherVO> pageInfo = PageHelper.startPage(param.getPageNum(), param.getPageSize()).doSelectPageInfo(() -> sysUserDOMapper.selectTeacher(param));
        pageInfo.getList().stream().forEach(x -> {
            if (x.getOrganizationId() != null) {
                x.setTeacherType("机构老师");
            }
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
        });
        return pageInfo;
    }
}
