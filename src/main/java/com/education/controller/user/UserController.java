package com.education.controller.user;

import com.education.api.vo.UserInvitationRecordVO;
import com.education.center.user.param.UserParam;
import com.education.center.user.service.SysUserService;
import com.education.center.user.vo.ApiMyInvitationVO;
import com.education.center.user.vo.UserCertificationVO;
import com.education.center.user.vo.UserInfoVO;
import com.education.center.user.vo.UserVO;
import com.education.common.SmsBiz;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Carl
 * @ClassName UserController
 * @Description
 * @date 2019-09-02 21:37
 **/
@RestController
@RequestMapping("api/sysuser")
public class UserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SmsBiz smsBiz;

    /**
     * 修改用户信息
     *
     * @param userVO
     * @return
     */
    @ApiOperation(value = "修改用户信息")
    @PostMapping(value = "/updateUserInfo")
    public ApiResponse updateUserInfo(@RequestBody UserParam userVO) {
        sysUserService.updateUserInfo(userVO);
        return success(true);
    }

    /**
     * 获取用户信息
     */
    @GetMapping(value = "/getUserInfo")
    @ResponseBody
    @ApiOperation(value = "获取用户信息")
    public ApiResponse<UserVO> getUserInfo() {
        UserVO userInfo = sysUserService.getUserInfo();
        return success(userInfo);
    }

    /**
     * 修改手机号
     *
     * @param phone
     * @param smsCaptcha
     * @return
     */
    @ApiOperation(value = "修改手机号")
    @GetMapping(value = "/updatePhone")
    public ApiResponse updatePhone(@RequestParam("phone") @ApiParam(value = "电话号码") String phone, @ApiParam(value = "验证码") @RequestParam("smsCaptcha") String smsCaptcha) {
        sysUserService.updatePhone(phone, smsCaptcha);
        return success(true);
    }


    /**
     * 申请认证
     *
     * @param userVO
     * @return
     */
    @ApiOperation(value = "申请认证")
    @PostMapping(value = "/certification")
    public ApiResponse certification(@RequestBody UserInfoVO userInfoVO) {
        sysUserService.certification(userInfoVO);
        return success(true);
    }

    /**
     * 获取用户当前认证状态
     *
     * @return
     */
    @ApiOperation(value = "获取用户当前认证状态")
    @GetMapping(value = "/getUserCertification")
    public ApiResponse<UserCertificationVO> getUserCertification() {
        return success(sysUserService.getUserCertification());
    }

    @ApiOperation(value = "获取验证码")
    @GetMapping(value = "/SmsBiz")
    public ApiResponse<Boolean> SmsBiz(@RequestParam("phone") String phone) {
        smsBiz.sendSms(phone);
        return success(true);
    }


    @ApiOperation(value = "设置我的邀请人")
    @GetMapping(value = "/setInviteUser")
    public ApiResponse<Boolean> setInviteUser(@RequestParam("inviteCode") Integer inviteCode) {
        sysUserService.setInviteUser(inviteCode);
        return success(true);
    }

    @ApiOperation(value = "获取邀请记录")
    @GetMapping(value = "/getUserInvitationRecord")
    public ApiResponse<List<UserInvitationRecordVO>> getUserInvitationRecord() {
        return success(sysUserService.getUserInvitationRecord());
    }

    @ApiOperation(value = "获取我的邀请码、邀请人信息")
    @GetMapping(value = "/getMyInvitation")
    public ApiResponse<ApiMyInvitationVO> getMyInvitation() {
        return success(sysUserService.getMyInvitation());
    }


}
