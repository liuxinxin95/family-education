package com.education.controller.need;

import com.education.center.need.service.NeedService;
import com.education.center.need.vo.*;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping(value = "/saveNeedInfo")
    public ApiResponse saveNeedInfo(@RequestBody NeedInfoParam needInfoVO) {
        needService.saveNeedInfo(needInfoVO);
        return success(true);
    }

    @GetMapping(value = "/getMyNeedList")
    @ResponseBody
    public ApiResponse<List<NeedOverviewVO>> getMyNeedList() {
        return success(needService.getMyNeedList());
    }

    @PostMapping(value = "/getPageList")
    @ResponseBody
    public ApiResponse<PageInfo<NeedInfoVO>> getPageList(@RequestBody NeedInfoRequest request) {
        return success(needService.getPageList(request));
    }

    @PostMapping(value = "/getListForMap")
    @ResponseBody
    public ApiResponse<List<NeedInfoVO>> getListForMap(@RequestBody NeedInfoRequest request) {
        return success(needService.getListForMap(request));
    }

    @GetMapping(value = "/getNeedDetail")
    @ResponseBody
    public ApiResponse<NeedDetailVO> getNeedDetail(@RequestParam("id") Integer id) {
        return success(needService.getNeedDetail(id));
    }
}
