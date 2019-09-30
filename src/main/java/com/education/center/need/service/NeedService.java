package com.education.center.need.service;

import com.education.center.need.vo.NeedInfoVO;

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
    void saveNeedInfo(NeedInfoVO needInfoVO);
}
