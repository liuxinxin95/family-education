package com.education.controller.need;

import com.education.center.need.service.NeedService;
import com.education.center.need.vo.NeedInfoVO;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping(value ="/saveNeedInfo")
    public ApiResponse saveNeedInfo(@RequestBody NeedInfoVO needInfoVO){
        needService.saveNeedInfo(needInfoVO);
        return success(true);
    }
}
