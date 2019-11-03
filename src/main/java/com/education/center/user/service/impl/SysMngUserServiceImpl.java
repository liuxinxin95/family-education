package com.education.center.user.service.impl;

import com.education.api.param.LoginParam;
import com.education.center.user.entity.SysMngUserDO;
import com.education.center.user.mapper.SysMngUserDOMapper;
import com.education.center.user.service.SysMngUserService;
import com.education.common.SysUser;
import com.education.exception.RRException;
import com.education.util.JwtUtil;
import com.education.util.MD5;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName SysMngUserServiceImpl
 * @Description
 * @date 2019-11-02 16:44
 **/
@Validated
@Service
@Primary
public class SysMngUserServiceImpl implements SysMngUserService {

    @Resource
    private SysMngUserDOMapper sysMngUserDOMapper;

    /**
     * 后台登录
     *
     * @param account
     * @param pwsd
     * @return
     */
    @Override
    public String login(@Validated LoginParam param) {
        SysMngUserDO mngUserDO = new SysMngUserDO();
        mngUserDO.setAccount(param.getAccount());
        mngUserDO.setPwsd(MD5.encoderByMd5(param.getPasswd()));
        SysMngUserDO userDO = sysMngUserDOMapper.selectOne(mngUserDO);
        if (userDO==null){
            throw new RRException("账号或者密码错误");
        }
        SysUser sysUser = new SysUser();
        sysUser.setPhone(userDO.getPhone());
        sysUser.setUserName(userDO.getUserName());
        sysUser.setAccount(userDO.getAccount());
        sysUser.setId(userDO.getId());
        String jwt = JwtUtil.generateToken(sysUser);
        return jwt;
    }
}
