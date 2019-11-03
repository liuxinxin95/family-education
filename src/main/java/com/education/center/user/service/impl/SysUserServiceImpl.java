package com.education.center.user.service.impl;

import com.education.center.asset.service.AssetUserPointService;
import com.education.center.asset.service.AssetUserWalletService;
import com.education.center.user.entity.SysUserDO;
import com.education.center.user.entity.UserInfoDO;
import com.education.center.user.enums.UserCertificationEnum;
import com.education.center.user.mapper.SysUserDOMapper;
import com.education.center.user.mapper.UserInfoDOMapper;
import com.education.center.user.param.UserParam;
import com.education.center.user.service.SysUserService;
import com.education.center.user.vo.LoginVO;
import com.education.center.user.vo.UserInfoVO;
import com.education.center.user.vo.UserVO;
import com.education.center.user.vo.UserCertificationVO;
import com.education.common.ShareCodeUtil;
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

    @Autowired
    private AssetUserWalletService assetUserWalletService;

    @Autowired
    private AssetUserPointService assetUserPointService;

    private static Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    /**
     * 校验用户是否存在
     *
     * @param openId
     * @return
     */
    @Override
    public Boolean checkUser(String openId) {
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(openId);
        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        if (sysUserDO1 == null) {
            return false;
        }
        return true;
    }

    /**
     * 登录成功返回session
     *
     * @param userVO
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public LoginVO login(UserParam userVO) {
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(userVO.getOpenId());
        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        if (sysUserDO1 == null) {
            if (userVO.getUserType() == null) {
                throw new RRException("请选择身份");
            }
            sysUserDO1 = BeanMapUtil.convertObject(userVO, SysUserDO.class);
            sysUserDO1.setCreateTime(new Date());
            sysUserDO1.setUpdateTime(new Date());
            sysUserDOMapper.insertOne(sysUserDO1);
            sysUserDO1.setInviteCode(getInviteCode(sysUserDO1.getId()));
            sysUserDOMapper.updateByPrimaryKey(sysUserDO1);
            //添加钱包
            assetUserWalletService.addUserWallet(sysUserDO1.getId());
            //添加积分
            assetUserPointService.addUserPoint(sysUserDO1.getId());
        }
        SysUser sysUser = BeanMapUtil.convertObject(sysUserDO1, SysUser.class);
        sysUser.setAccount(sysUserDO1.getOpenId());
        //生成权限
        String jwt = JwtUtil.generateToken(sysUser);
        LoginVO loginVO = new LoginVO();
        loginVO.setSession(jwt);
        loginVO.setUserType(sysUserDO1.getUserType());
        return loginVO;
    }

    /**
     * 修改用户信息
     *
     * @param userVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfo(UserParam userVO) {
        String openId = ((SysUser) UserContext.getContext().getCurrentUser()).getOpenId();
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(openId);

        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        if (sysUserDO1 == null) {
            throw new RRException("用户不存在，请重新登录");
        }
        SysUserDO userDO = BeanMapUtil.convertObject(userVO, SysUserDO.class);
        userDO.setId(sysUserDO1.getId());
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
        return  sysUserDOMapper.selectByOpendId(openId);
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
        userInfoVO.setUserType(user.getUserType());
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
     * 获取用户当前认证状态
     *
     * @return
     */
    @Override
    public UserCertificationVO getUserCertification() {
        UserCertificationVO userCertificationVO = new UserCertificationVO();
        SysUserDO user = getUser();
        UserInfoDO infoDO = new UserInfoDO();
        infoDO.setUserId(user.getId());
        UserInfoDO userInfoDO1 = userInfoDOMapper.selectOne(infoDO);
        userCertificationVO.setUserId(user.getId());
        if (userInfoDO1 == null) {
            userCertificationVO.setPaySingleStatus(0);
            userCertificationVO.setPaySingleStatus(UserCertificationEnum.UNVERIFIED.getType());
            userCertificationVO.setCertificationText(UserCertificationEnum.UNVERIFIED.getName());
        } else {
            userCertificationVO.setPaySingleStatus(userInfoDO1.getPayType());
            userCertificationVO.setCertificationType(userInfoDO1.getCertificationStatus());
            userCertificationVO.setCertificationText(UserCertificationEnum.valueType(userCertificationVO.getCertificationType()));
        }
        return userCertificationVO;
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

    /**
     * 邀请码获取
     *
     * @param userId
     * @return
     */
    private Integer getInviteCode(Integer userId) {
        String code = ShareCodeUtil.toSerialCode(userId);
        Integer integer = Integer.valueOf(code);
        SysUserDO userDO = new SysUserDO();
        userDO.setInviteCode(integer);
        SysUserDO userDO1 = sysUserDOMapper.selectOne(userDO);
        if (userDO1 == null) {
            return integer;
        } else {
            return getInviteCode(userId);
        }
    }
}
