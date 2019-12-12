package com.education.api.controller;

import com.education.center.main.service.GradeInfoService;
import com.education.center.main.service.SubjectInfoService;
import com.education.center.main.vo.GradeInfoTreeVO;
import com.education.center.main.vo.SubjectInfoVO;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Carl
 * @ClassName ApiMainController
 * @Description
 * @date 2019-11-04 23:57
 **/
@RestController
@RequestMapping("mng/api/main")
public class ApiMainController extends BaseController {

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private GradeInfoService gradeInfoService;


    @ApiOperation(value = "获取全部科目")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/getSubjectAll")
    private ApiResponse<List<SubjectInfoVO>> getSubjectAll() {
        return success(subjectInfoService.getAll());
    }

    @ApiOperation(value = "根据年级获取科目")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/getByGrade")
    private ApiResponse<List<SubjectInfoVO>> getByGrade(@RequestParam("gradeId") Integer gradeId) {
        return success(subjectInfoService.getByGrade(gradeId));
    }

    @ApiOperation(value = "科目添加")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/addSubject")
    private ApiResponse<Boolean> addSubject(@RequestParam("gradeId") Integer gradeId, @RequestParam("name") String name) {
        subjectInfoService.addSubject(gradeId, name);
        return success(true);
    }


    @ApiOperation(value = "科目修改")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/updateSubject")
    private ApiResponse<Boolean> updateSubject(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        subjectInfoService.updateSubject(id, name);
        return success(true);
    }

    @ApiOperation(value = "科目删除")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/deleteSubject")
    private ApiResponse<Boolean> deletaSubject(@RequestParam("id") Integer id) {
        subjectInfoService.deleteSubject(id);
        return success(true);
    }

    @ApiOperation(value = "获取全部年级")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/getGradeAll")
    private ApiResponse<List<GradeInfoTreeVO>> getGradeAll() {
        return success(gradeInfoService.getAll());
    }

    @ApiOperation(value = "只获取夫级年级名称")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/getParent")
    private ApiResponse<List<GradeInfoTreeVO>> getParent() {
        return success(gradeInfoService.getParent());
    }

    @ApiOperation(value = "添加年级")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/addGrade")
    private ApiResponse<Boolean> addGrade(@RequestParam("name") String name, @RequestParam("pid") Integer pid) {
        gradeInfoService.addGrade(name, pid);
        return success(true);
    }

    @ApiOperation(value = "删除年级")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/deleteGrade")
    private ApiResponse<Boolean> deleteGrade(@RequestParam("id") Integer id) {
        gradeInfoService.deleteGrade(id);
        return success(true);
    }

    @ApiOperation(value = "修改年级")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @GetMapping("/updateGrade")
    private ApiResponse<Boolean> updateGrade(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        gradeInfoService.updateGrade(id, name);
        return success(true);
    }
}
