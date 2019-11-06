package com.education.center.need.mapper;


import com.education.api.param.QueryNeedParam;
import com.education.api.vo.ApiNeedDetailVO;
import com.education.api.vo.ApiNeedInfoVO;
import com.education.center.need.entity.NeedInfoDO;
import com.education.center.need.vo.NeedDetailVO;
import com.education.center.need.vo.NeedInfoRequest;
import com.education.center.need.vo.NeedInfoVO;
import com.education.center.need.vo.NeedOverviewVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NeedInfoDOMapper extends Mapper<NeedInfoDO> {

    /**
     * 查询自己的需求列表
     *
     * @param userId
     * @return
     */
    List<NeedOverviewVO> selectMyNeed(@Param("userId") Integer userId);


    List<NeedInfoVO> selectPageList(NeedInfoRequest request);


    /**
     * 需求明细
     *
     * @param id
     * @param longitude
     * @param latitude
     * @return
     */
    NeedDetailVO selectDetail(@Param("id") Integer id, @Param("longitude") Double longitude, @Param("latitude") Double latitude);

    /**
     * 后台需求列表
     * @param param
     * @return
     */
    List<ApiNeedInfoVO> selectByRequest(QueryNeedParam param);

    /**
     * 后台需求明细
     * @param id
     * @return
     */
    ApiNeedDetailVO selectNeedDetail(@Param("id")Integer id);
}