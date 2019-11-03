package com.education.api.controller;

import com.education.center.sign.service.SignService;
import com.education.center.sign.vo.SignRuleAddRequest;
import com.education.center.sign.vo.SignRuleQueryRequest;
import com.education.center.sign.vo.SignRuleQueryResponse;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Carl
 * @ClassName ApiSignController
 * @Description
 * @date 2019-10-12 17:33
 **/
@RestController
@RequestMapping("mng/api/sign")
public class ApiSignController extends BaseController {

    @Autowired
    private SignService signService;

    @ApiOperation(value = "规则创建3.4.1（改造中,修改创建规则红包")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @PostMapping("/create")
    private ApiResponse<Boolean> createSignRule(@Valid @RequestBody SignRuleAddRequest request) {
        signService.createSignRule(request);
        return success(true);
    }

    @ApiOperation(value = "规则列表")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @PostMapping("/list")
    private ApiResponse<PageInfo<SignRuleQueryResponse>> signRulePageList(@Valid @RequestBody SignRuleQueryRequest request) {
        return success(signService.signRulePageList(request));
    }
}
