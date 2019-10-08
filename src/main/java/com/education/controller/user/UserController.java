package com.education.controller.user;

import com.education.center.user.service.SysUserService;
import com.education.center.user.vo.UserCertificationVO;
import com.education.center.user.vo.UserInfoVO;
import com.education.center.user.vo.UserVO;
import com.education.common.SysUser;
import com.education.common.UserContext;
import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 列表
     */
    @GetMapping(value = "/list")
    public ApiResponse list() {
        UserContext<SysUser> context = UserContext.getContext();
        SysUser currentUser = context.getCurrentUser();
        return success("");
    }

    /**
     * 修改用户信息
     *
     * @param userVO
     * @return
     */
    @PostMapping(value = "/updateUserInfo")
    public ApiResponse updateUserInfo(@RequestBody UserVO userVO) {
        sysUserService.updateUserInfo(userVO);
        return success(true);
    }

    /**
     * 获取用户信息
     */
    @GetMapping(value = "/getUserInfo")
    @ResponseBody
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
    @GetMapping(value = "/updatePhone")
    public ApiResponse updatePhone(@RequestParam("phone") String phone, @RequestParam("smsCaptcha") String smsCaptcha) {
        sysUserService.updatePhone(phone, smsCaptcha);
        return success(true);
    }


    /**
     * 申请认证
     *
     * @param userVO
     * @return
     */
    @PostMapping(value = "/certification")
    public ApiResponse certification(@RequestBody UserInfoVO userInfoVO) {
        sysUserService.certification(userInfoVO);
        return success(true);
    }

    /**
     * 获取用户当前认证状态
     * @return
     */
    @GetMapping(value = "/getUserCertification")
    public ApiResponse<UserCertificationVO> getUserCertification() {
        return success(sysUserService.getUserCertification());
    }
}
