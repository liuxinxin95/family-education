package com.education.controller.main;
import	java.lang.ProcessBuilder.Redirect;

import com.education.center.main.service.GradeInfoService;
import com.education.center.main.vo.GradeInfoTreeVO;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Carl
 * @ClassName GradeInfoController
 * @Description
 * @date 2019-10-01 00:14
 **/
@RestController
@RequestMapping("api/grade")
public class GradeInfoController extends BaseController {

    @Autowired
    private GradeInfoService gradeInfoService;

    /**
     * 获取夫级年级信息
     * @return
     */
    @GetMapping(value ="/getParent")
    @ResponseBody
    public ApiResponse<List<GradeInfoTreeVO>> getParent(){
        return success(gradeInfoService.getParent());
    }

    /**
     * 以树状形式展示年级信息
     * @return
     */
    @GetMapping(value ="/getAllTree")
    @ResponseBody
    public ApiResponse<List<GradeInfoTreeVO>> getAllTree(){
        return success(gradeInfoService.getAll());
    }

}
