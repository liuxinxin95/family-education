package com.education.center.user.service;

import com.education.api.param.LoginParam;

/**
 * @author Carl
 * @ClassName SysMngUserService
 * @Description
 * @date 2019-11-02 16:43
 **/
public interface SysMngUserService {

    /**
     * 登录
     *
     * @param account
     * @param pwsd
     */
    String login(LoginParam param);
}
