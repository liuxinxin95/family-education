package com.education.center.user.service.impl;

import com.education.FamilyEducationApplication;
import com.education.center.sign.service.UserSignService;
import com.education.center.user.param.UserParam;
import com.education.center.user.service.SysUserService;
import com.education.center.user.vo.LoginVO;
import com.education.center.user.vo.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FamilyEducationApplication.class)
public class UserServiceImplTest {

    @Autowired
    private SysUserService userService;
    @Autowired
    private UserSignService userSignService;
    @Test
    public void login() {
        UserParam userVO = new UserParam();
        userVO.setOpenId("123");
        userVO.setUserName("233");
        userVO.setAvatar("222");
        LoginVO login = userService.login(userVO);
        System.out.println(login);
    }

    @Test
    public void saveSign(){
        userSignService.saveSign(12);
    }
}