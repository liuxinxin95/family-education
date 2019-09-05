package com.education.controller.user;

import com.education.framework.ApiResponse;
import com.education.framework.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carl
 * @ClassName UserController
 * @Description
 * @date 2019-09-02 21:37
 **/
@RestController
@RequestMapping("api/sysuser")
public class UserController extends BaseController {

    /**
     * 列表
     */
    @GetMapping(value ="/list")
    public ApiResponse list() {
        return success("");
    }
}
