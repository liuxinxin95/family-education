package com.education.api.controller;

import com.education.api.param.QueryNeedParam;
import com.education.api.vo.ApiNeedDetailVO;
import com.education.api.vo.ApiNeedInfoVO;
import com.education.center.need.service.NeedService;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author Carl
 * @ClassName ApiNeedController
 * @Description
 * @date 2019-11-06 22:57
 **/
@RestController
@RequestMapping("mng/api/need")
public class ApiNeedController extends BaseController {

    @Resource
    private NeedService needService;

    @ApiOperation(value = "需求列表查询")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @PostMapping("/selectNeedByRequest")
    private ApiResponse<PageInfo<ApiNeedInfoVO>> selectNeedByRequest(@Valid @RequestBody QueryNeedParam request) {
        return success(needService.selectNeedByRequest(request));
    }


    @ApiOperation(value = "需求详情")
    @ApiImplicitParam(paramType = "header", name = "sessionId", required = true, value = "SESSION信息", dataType = "String")
    @PostMapping("/selectNeedDetail")
    private ApiResponse<ApiNeedDetailVO> selectNeedByRequest(@RequestParam("id") Integer id) {
        return success(needService.selectNeedDetail(id));
    }
}
