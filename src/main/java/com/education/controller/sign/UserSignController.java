package com.education.controller.sign;

import com.education.center.sign.service.UserSignService;
import com.education.center.sign.vo.SignDayVO;
import com.education.center.sign.vo.SysUserSignRecordVO;
import com.education.common.PageRequest;
import com.education.common.SysUser;
import com.education.common.UserContext;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Carl
 * @ClassName UserSignController
 * @Description
 * @date 2019-12-12 15:17
 **/
@RestController
@RequestMapping(value = "/api/sign")
@Api(tags = "UserSignController", description = "签到")
public class UserSignController extends BaseController {

    @Autowired
    private UserSignService userSignService;

    /**
     * 查看签到记录
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "查看用户的签到记录")
    @PostMapping(value = "/queryUserSignRecord")
    public ApiResponse<PageInfo<SysUserSignRecordVO>> queryUserSignRecord(@RequestBody PageRequest request) {
        return success(userSignService.queryUserSignRecord(request, UserContext.<SysUser>getContext().getCurrentUser().getId()));
    }

    @ApiOperation(value = "查询用户连续签到记录(供页面展示那几天签到了)")
    @GetMapping(value = "/queryUserSignRecord")
    public ApiResponse<SignDayVO> getUserSign() {
        return success(userSignService.getUserSign(UserContext.<SysUser>getContext().getCurrentUser().getId()));
    }


    @ApiOperation(value = "本日签到提交")
    @GetMapping(value = "/saveSign")
    public ApiResponse<Boolean> saveSign() {
        userSignService.saveSign(UserContext.<SysUser>getContext().getCurrentUser().getId());
        return success(true);
    }

}
