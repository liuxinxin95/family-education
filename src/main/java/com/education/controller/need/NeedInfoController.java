package com.education.controller.need;

import com.education.center.need.service.NeedService;
import com.education.center.need.vo.*;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Carl
 * @ClassName NeedInfoController
 * @Description
 * @date 2019-10-01 00:28
 **/
@RestController
@RequestMapping("api/needInfo")
public class NeedInfoController extends BaseController {

    @Autowired
    private NeedService needService;


    @ApiOperation(value = "发布需求")
    @PostMapping(value = "/saveNeedInfo")
    public ApiResponse saveNeedInfo(@RequestBody @Valid NeedInfoParam needInfoVO) {
        needService.saveNeedInfo(needInfoVO);
        return success(true);
    }

    @ApiOperation(value = "获取我的需求列表")
    @GetMapping(value = "/getMyNeedList")
    @ResponseBody
    public ApiResponse<List<NeedOverviewVO>> getMyNeedList() {
        return success(needService.getMyNeedList());
    }

    @ApiOperation(value = "分类查询需求")
    @PostMapping(value = "/getPageList")
    @ResponseBody
    public ApiResponse<PageInfo<NeedInfoVO>> getPageList(@RequestBody NeedInfoRequest request) {
        return success(needService.getPageList(request));
    }

    @ApiOperation(value = "需求地图模式")
    @PostMapping(value = "/getListForMap")
    @ResponseBody
    public ApiResponse<List<NeedInfoVO>> getListForMap(@RequestBody NeedInfoRequest request) {
        return success(needService.getListForMap(request));
    }

    @ApiOperation(value = "获取需求详情")
    @GetMapping(value = "/getNeedDetail")
    @ResponseBody
    public ApiResponse<NeedDetailVO> getNeedDetail(@RequestParam("id") @ApiParam(value = "需求id") Integer id,@ApiParam(value = "需求id") @RequestParam("经度") Double longitude,@ApiParam(value = "维度") @RequestParam("latitude") Double latitude) {
        return success(needService.getNeedDetail(id,longitude,latitude));
    }
}
