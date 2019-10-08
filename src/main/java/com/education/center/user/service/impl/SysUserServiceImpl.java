package com.education.center.user.service.impl;

import com.education.center.user.entity.SysUserDO;
import com.education.center.user.entity.UserInfoDO;
import com.education.center.user.mapper.SysUserDOMapper;
import com.education.center.user.mapper.UserInfoDOMapper;
import com.education.center.user.service.SysUserService;
import com.education.center.user.vo.UserInfoVO;
import com.education.center.user.vo.UserVO;
import com.education.common.SmsBiz;
import com.education.common.SysUser;
import com.education.common.UserContext;
import com.education.exception.RRException;
import com.education.util.BeanMapUtil;
import com.education.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;


/**
 * @author Carl
 * @ClassName SysUserServiceImpl
 * @Description
 * @date 2019-09-08 15:34
 **/
@Service
@Primary
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDOMapper sysUserDOMapper;

    @Resource
    private UserInfoDOMapper userInfoDOMapper;

    @Autowired
    private SmsBiz smsBiz;

    private static Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    /**
     * 登录成功返回session
     *
     * @param userVO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String login(UserVO userVO) {
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(userVO.getOpenId());
        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        if (sysUserDO1 == null) {
            sysUserDO1 = BeanMapUtil.convertObject(userVO, SysUserDO.class);
            sysUserDO1.setCreateTime(new Date());
            sysUserDO1.setUpdateTime(new Date());
            sysUserDO1.setInviteCode(1111);
            sysUserDOMapper.insert(sysUserDO1);
        }
        //生成权限
        String jwt = JwtUtil.generateToken(sysUserDO1);
        return jwt;
    }

    /**
     * 修改用户信息
     *
     * @param userVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfo(UserVO userVO) {
        String openId = ((SysUser) UserContext.getContext().getCurrentUser()).getOpenId();
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(openId);
        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        if (sysUserDO1 == null) {
            throw new RRException("用户不存在，请重新登录");
        }
        SysUserDO userDO = BeanMapUtil.convertObject(userVO, SysUserDO.class);
        userDO.setId(sysUserDO1.getId());
//        userDO.setOpenId(openId);
        int i = sysUserDOMapper.updateByPrimaryKeySelective(userDO);
        if (i <= 0) {
            throw new RRException("用户信息修改失败,请重试");
        }
    }

    /**
     * 获得用户信息
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserVO getUserInfo() {
        String openId = ((SysUser) UserContext.getContext().getCurrentUser()).getOpenId();
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(openId);
        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        return BeanMapUtil.convertObject(sysUserDO1, UserVO.class);
    }

    /**
     * 修改手机号
     *
     * @param phone
     * @param smsCaptcha
     */
    @Override
    public void updatePhone(String phone, String smsCaptcha) {
        //TODO 校验验证码
        smsBiz.checkCode(phone, smsCaptcha);

        //TODO 修改手机号
        SysUserDO sysUserDO = getUser();
        sysUserDO.setPhone(phone);
        sysUserDOMapper.updateByPrimaryKey(sysUserDO);
    }


    /**
     * 提交认证申请
     *
     * @param userInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void certification(UserInfoVO userInfoVO) {
        SysUserDO user = getUser();
        if (userInfoVO.getUserType() == null) {
            throw new RRException("请指定审核类型");
        }
        UserInfoDO userInfoDO = BeanMapUtil.convertObject(userInfoVO, UserInfoDO.class);
        Integer inviteUser = null;
        //是否是机构
        boolean isInstitutions = false;
        if (userInfoVO.getInviteCode() != null) {
            SysUserDO sysUserDO = new SysUserDO();
            sysUserDO.setInviteCode(userInfoVO.getInviteCode());
            SysUserDO sysUserDO2 = sysUserDOMapper.selectOne(sysUserDO);
            if (sysUserDO2 != null) {
                UserInfoDO userInfoDO1 = new UserInfoDO();
                userInfoDO1.setUserId(sysUserDO2.getId());
                UserInfoDO userInfoDO2 = userInfoDOMapper.selectOne(userInfoDO1);
                log.info("邀请人{}", sysUserDO2.getUserName());
                if (userInfoDO2 != null) {
                    inviteUser = userInfoDO2.getUserId();
                    userInfoDO.setInviterUserId(userInfoDO2.getUserId());
                }
            }
        }
        //统一未审核、机构邀请需要后面机构补缴后开通、其他正常流程
        userInfoVO.setExamineStatus(0);
        userInfoDO.setCertificationStatus(0);
        userInfoDO.setPaySingleStatus(0);
        userInfoDO.setPayType(0);
        switch (userInfoVO.getUserType()) {
            //老师
            case 1:
                //图片校验
                if (StringUtils.isBlank(userInfoVO.getTeacherCertificationPhoto())) {
                    throw new RRException("请上传有效的教师资格证");
                }
                userInfoDO.setCertificationStatus(1);
                break;
            //结构
            case 2:
                if (StringUtils.isBlank(userInfoVO.getBusinessLicensePhoto())) {
                    throw new RRException("请上传有效的营业执照");
                }
                if (StringUtils.isBlank(userInfoVO.getBusinessLicenseNumber())) {
                    throw new RRException("请输入有效的营业执照号码");
                }
                userInfoDO.setCertificationStatus(1);
                break;
            default:

        }
        //TODO 如果有邀请做返利和记录;
        UserInfoDO infoDO = new UserInfoDO();
        infoDO.setUserId(user.getId());
        UserInfoDO userInfoDO1 = userInfoDOMapper.selectOne(infoDO);
        if (userInfoDO1 == null) {
            userInfoDOMapper.insert(userInfoDO);
        } else {
            if (userInfoDO1.getCertificationStatus() > 2) {
                throw new RRException("已认证通过请勿重复提交");
            }
            userInfoDO.setId(userInfoDO1.getId());
            userInfoDOMapper.updateByPrimaryKey(userInfoDO);
        }
    }


    /**
     * 获取用户信息
     *
     * @return
     */
    @Override
    public SysUserDO getUser() {
        String openId = ((SysUser) UserContext.getContext().getCurrentUser()).getOpenId();
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(openId);
        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        if (sysUserDO1 == null) {
            throw new RRException("用户信息查询错误");
        }
        return sysUserDO1;
    }
}
