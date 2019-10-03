package com.education.center.need.service;

import com.education.center.need.vo.NeedInfoParam;
import com.education.center.need.vo.NeedInfoRequest;
import com.education.center.need.vo.NeedInfoVO;
import com.education.center.need.vo.NeedOverviewVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Carl
 * @ClassName NeedService
 * @Description
 * @date 2019-09-09 22:45
 **/
public interface NeedService {

    /**
     * 需求发布
     * @param needInfoVO
     */
    void saveNeedInfo(NeedInfoParam needInfoVO);

    /**
     * 获取自己的需求列表
     * @return
     */
    List<NeedOverviewVO> getMyNeedList();


    /**
     * 列表查询
     * @param request
     * @return
     */
    PageInfo<NeedInfoVO> getPageList(NeedInfoRequest request);
}
