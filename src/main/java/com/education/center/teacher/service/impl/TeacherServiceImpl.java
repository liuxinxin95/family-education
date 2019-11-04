package com.education.center.teacher.service.impl;

import com.education.api.param.AuditParam;
import com.education.api.param.QueryTeacherParam;
import com.education.api.vo.ApiTeacherVO;
import com.education.api.vo.TeacherCertificationVO;
import com.education.center.teacher.service.TeacherService;
import com.education.center.user.entity.SysUserDO;
import com.education.center.user.entity.UserInfoDO;
import com.education.center.user.enums.UserCertificationEnum;
import com.education.center.user.mapper.SysUserDOMapper;
import com.education.center.user.mapper.UserInfoDOMapper;
import com.education.exception.RRException;
import com.education.util.BeanMapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

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

    /**
     * 获取老师的认证信息
     *
     * @param id
     * @return
     */
    @Override
    public TeacherCertificationVO getTeacherCer(Integer id) {
        SysUserDO userDO = sysUserDOMapper.selectByPrimaryKey(id);
        if (userDO == null) {
            throw new RRException("该用户不存在");
        }
        UserInfoDO infoDO = new UserInfoDO();
        infoDO.setUserId(id);
        UserInfoDO userInfoDO = userInfoDOMapper.selectOne(infoDO);
        if (userInfoDO == null) {
            throw new RRException("该用户不存在认证信息");
        }
        TeacherCertificationVO teacherCertificationVO = BeanMapUtil.convertObject(userInfoDO, TeacherCertificationVO.class);
        teacherCertificationVO.setUserName(userDO.getUserName());
        teacherCertificationVO.setPhone(userDO.getPhone());
        return teacherCertificationVO;
    }

    /**
     * 审核
     *
     * @param param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void teacherAudit(AuditParam param) {
        UserInfoDO infoDO = userInfoDOMapper.selectByPrimaryKey(param.getId());
        if (infoDO == null) {
            throw new RRException("该老师不存在认证信息");
        }
        if (param.getIsPass()) {
            infoDO.setCertificationStatus(3);
        } else {
            infoDO.setCertificationStatus(2);
        }
        infoDO.setRejectedReason(param.getRemark());
        infoDO.setUpdateTime(new Date());
        userInfoDOMapper.updateByPrimaryKeySelective(infoDO);
    }
}
