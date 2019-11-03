package com.education.api.controller;

import com.education.api.param.LoginParam;
import com.education.center.user.service.SysMngUserService;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName ApiLoginController
 * @Description
 * @date 2019-11-02 15:51
 **/
@RestController
@RequestMapping("mng/api/login")
public class ApiLoginController extends BaseController {

    @Resource
    private SysMngUserService sysMngUserService;

    @ApiOperation(value = "规则创建3.4.1（改造中,修改创建规则红包")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/login")
    private ApiResponse<String> createSignRule(@RequestBody LoginParam param) {
        return success(sysMngUserService.login(param));
    }
}
