package com.education.controller.main;

import java.awt.Desktop.Action;
import java.util.List;

import com.education.center.main.service.CityService;
import com.education.center.main.vo.SysDistrictVO;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Carl
 * @ClassName DistrictController
 * @Description
 * @date 2019-10-13 14:05
 **/
@RestController
@RequestMapping("api/district")
public class DistrictController extends BaseController {

    @Autowired
    private CityService cityService;

    /**
     * @param pid
     * @return
     */
    @GetMapping(value = "/getCityByPid")
    @ApiOperation(value = "根据pid获取城市信息（三级联动，初始化1）")
    @ResponseBody
    public ApiResponse<List<SysDistrictVO>> getCityByPid(@RequestParam("pid")@ApiParam(value = "夫级id，身份查询1") Integer pid) {
        return success(cityService.getCityByPid(pid));
    }
}
