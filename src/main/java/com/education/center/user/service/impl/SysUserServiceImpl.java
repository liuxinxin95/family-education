package com.education.center.user.service.impl;

import com.education.center.user.entity.SysUserDO;
import com.education.center.user.mapper.SysUserDOMapper;
import com.education.center.user.service.SysUserService;
import com.education.center.user.vo.UserInfoVO;
import com.education.center.user.vo.UserVO;
import com.education.common.SysUser;
import com.education.common.UserContext;
import com.education.exception.RRException;
import com.education.util.BeanMapUtil;
import com.education.util.JwtUtil;
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
        userDO.setOpenId(openId);
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
    public UserInfoVO getUserInfo() {
        String openId = ((SysUser) UserContext.getContext().getCurrentUser()).getOpenId();
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(openId);
        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        return BeanMapUtil.convertObject(sysUserDO1, UserInfoVO.class);
    }

    /**
     * 修改手机号
     * @param phone
     * @param smsCaptcha
     */
    public void updatePhone(String phone, String smsCaptcha) {
        //TODO 校验验证码



        //TODO 修改手机号
        String openId = ((SysUser) UserContext.getContext().getCurrentUser()).getOpenId();
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(openId);
        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        sysUserDO1.setPhone(phone);
        sysUserDOMapper.updateByPrimaryKey(sysUserDO1);
    }

}
