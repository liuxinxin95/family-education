package com.education.center.need.service;

import com.education.center.need.vo.*;
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


    /**
     * 地图模式
     * @param request
     * @return
     */
    List<NeedInfoVO> getListForMap(NeedInfoRequest request);

    /**
     * 需求明细
     * @param id
     * @return
     */
    NeedDetailVO getNeedDetail(Integer id);
}
