package com.education.center.sign.service;

import com.education.center.sign.vo.SignRuleAddRequest;
import com.education.center.sign.vo.SignRuleQueryRequest;
import com.education.center.sign.vo.SignRuleQueryResponse;
import com.github.pagehelper.PageInfo;

import javax.validation.Valid;

/**
 * @author Carl
 * @ClassName signService
 * @Description
 * @date 2019-10-12 16:41
 **/
public interface SignService {

    /**
     * 创建签到规则
     * @param request
     */
    void createSignRule(@Valid SignRuleAddRequest request);

    /**
     * 规则列表
     * @param request
     * @return
     */
    PageInfo<SignRuleQueryResponse> signRulePageList(SignRuleQueryRequest request);
}
