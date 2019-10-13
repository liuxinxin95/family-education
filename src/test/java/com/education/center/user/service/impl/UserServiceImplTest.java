package com.education.center.user.service.impl;

import com.education.FamilyEducationApplication;
import com.education.center.user.service.SysUserService;
import com.education.center.user.vo.LoginVO;
import com.education.center.user.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FamilyEducationApplication.class)
public class UserServiceImplTest {

    @Autowired
    private SysUserService userService;
    @Test
    public void login() {
        UserVO userVO = new UserVO();
        userVO.setOpenId("123");
        userVO.setUserName("233");
        userVO.setAvatar("222");
        LoginVO login = userService.login(userVO);
        System.out.println(login);
    }
}