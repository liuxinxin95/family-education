package com.education.center.user.service.impl;

import com.education.center.user.mapper.SysUserDOMapper;
import com.education.center.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName UserServiceImpl
 * @Description
 * @date 2019-09-08 15:34
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SysUserDOMapper sysUserDOMapper;

    public void login(){

    }
}
