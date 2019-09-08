package com.education.center.user.service;

import com.education.center.user.vo.UserVO;

/**
 * @author Carl
 * @ClassName SysUserService
 * @Description
 * @date 2019-09-08 15:33
 **/
public interface SysUserService {

    /**
     * 登录成功返回session
     * @param userVO
     * @return
     */
    String login(UserVO userVO);
}
