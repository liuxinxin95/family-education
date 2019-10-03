package com.education.center.need.mapper;


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
     * @param userId
     * @return
     */
    List<NeedOverviewVO> selectMyNeed(@Param("userId") Integer userId);


    List<NeedInfoVO> selectPageList(NeedInfoRequest request);


    /**
     * 需求明细
     * @param id
     * @return
     */
    NeedDetailVO selectDetail(@Param("id")Integer id);
}