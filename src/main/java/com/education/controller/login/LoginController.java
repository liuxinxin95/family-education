package com.education.controller.login;

import com.education.center.user.param.UserParam;
import com.education.center.user.service.SysUserService;
import com.education.center.user.vo.LoginVO;
import com.education.center.user.vo.UserVO;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Carl
 * @ClassName LoginController
 * @Description
 * @date 2019-09-08 17:56
 **/
@RestController
@RequestMapping("api/login")
public class LoginController extends BaseController {

    @Autowired
    private SysUserService userService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "获取用户信息")
    @ResponseBody
    public ApiResponse<LoginVO> login(@RequestBody UserParam userVO) {
        return success(userService.login(userVO));
    }

    @PostMapping(value = "/checkUser")
    @ApiOperation(value = "校验用户是否存在")
    @ResponseBody
    public ApiResponse<Boolean> checkUser(@RequestParam("openId") String openId) {
        return success(userService.checkUser(openId));
    }
}
