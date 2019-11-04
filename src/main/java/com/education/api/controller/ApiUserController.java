package com.education.api.controller;

import com.education.api.param.AuditParam;
import com.education.api.param.QueryOrganizationParam;
import com.education.api.param.QueryTeacherParam;
import com.education.api.vo.ApiOrganizationVO;
import com.education.api.vo.ApiTeacherVO;
import com.education.api.vo.TeacherCertificationVO;
import com.education.center.organization.service.OrganizationService;
import com.education.center.teacher.service.TeacherService;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private OrganizationService organizationService;

    @ApiOperation(value = "用户老师列表")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @PostMapping("/getTeacherList")
    public ApiResponse<PageInfo<ApiTeacherVO>> getTeacherList(@RequestBody QueryTeacherParam param) {
        return success(teacherService.getTeacherList(param));
    }

    @ApiOperation(value = "获取老师的认证信息")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/getTeacherCer")
    public ApiResponse<TeacherCertificationVO> getTeacherCer(@RequestParam("id") Integer id) {
        return success(teacherService.getTeacherCer(id));
    }

    @ApiOperation(value = "认证")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @PostMapping("/teacherAudit")
    public ApiResponse teacherAudit(@RequestBody AuditParam param) {
        teacherService.teacherAudit(param);
        return success(true);
    }

    @ApiOperation(value = "机构列表列表")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @PostMapping("/getOrganizationList")
    public ApiResponse<PageInfo<ApiOrganizationVO>> getOrganizationList(@RequestBody QueryOrganizationParam param) {
        return success(organizationService.getOrganizationList(param));
    }

    @ApiOperation(value = "机构成员")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/getOrganizationTeam")
    public ApiResponse<List<ApiTeacherVO>> getOrganizationList(@RequestParam("id") Integer id) {
        return success(organizationService.getOrganizationTeam(id));
    }
}
