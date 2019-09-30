package com.education.controller.main;

import com.education.center.main.service.SubjectInfoService;
import com.education.center.main.vo.SubjectInfoVO;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Carl
 * @ClassName SubjectInfoController
 * @Description
 * @date 2019-10-01 00:04
 **/
@RestController
@RequestMapping("api/subject")
public class SubjectInfoController extends BaseController {

    @Autowired
    private SubjectInfoService subjectInfoService;

    /**
     * 获取所有课程
     * @return
     */
    @GetMapping(value ="/getAll")
    @ApiOperation(value = "获取所有课程")
    @ResponseBody
    public ApiResponse<List<SubjectInfoVO>> getAll(){
        return success(subjectInfoService.getAll());
    }



}
