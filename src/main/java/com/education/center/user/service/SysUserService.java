package com.education.center.user.service;

import com.education.center.user.entity.SysUserDO;
import com.education.center.user.vo.UserInfoVO;
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
     *
     * @param userVO
     * @return
     */
    String login(UserVO userVO);

    /**
     * 修改用户信息
     *
     * @param userVO
     */
    void updateUserInfo(UserVO userVO);

    /**
     * 获得用户信息
     *
     * @return
     */
    UserVO getUserInfo();

    /**
     * 修改手机号
     * @param phone
     * @param smsCaptcha
     */
    void updatePhone(String phone, String smsCaptcha);

    /**
     * 申请认证
     * @param userInfoVO
     */
    void certification(UserInfoVO userInfoVO);


    SysUserDO getUser();
}
