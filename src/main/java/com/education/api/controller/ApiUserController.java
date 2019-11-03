package com.education.api.controller;

import com.education.api.param.QueryTeacherParam;
import com.education.api.vo.ApiTeacherVO;
import com.education.center.teacher.service.TeacherService;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName ApiUserController
 * @Description
 * @date 2019-11-02 17:43
 **/
@RestController
@RequestMapping("mng/api/user")
public class ApiUserController extends BaseController {

    @Resource
    private TeacherService teacherService;

    @ApiOperation(value = "用户老师列表")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @PostMapping("/getTeacherList")
    public ApiResponse<PageInfo<ApiTeacherVO>> getTeacherList(@RequestBody QueryTeacherParam param) {
        return success(teacherService.getTeacherList(param));
    }

}
