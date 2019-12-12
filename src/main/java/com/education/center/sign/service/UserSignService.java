package com.education.center.sign.service;

import com.education.center.sign.vo.SignDayVO;
import com.education.center.sign.vo.SysUserSignRecordVO;
import com.education.common.PageRequest;
import com.github.pagehelper.PageInfo;

/**
 * @author Carl
 * @ClassName UserSignService
 * @Description
 * @date 2019-12-12 10:03
 **/
public interface UserSignService {

    /**
     * 签到记录
     *
     * @param request
     * @param userId
     * @return
     */
    PageInfo<SysUserSignRecordVO> queryUserSignRecord(PageRequest request, Integer userId);

    /**
     * 查询用户连续签到记录。
     *
     * @param userId
     * @return
     */
    SignDayVO getUserSign(Integer userId);

    /**
     * 提交签到
     *
     * @param userId
     */
    void saveSign(Integer userId);

}
