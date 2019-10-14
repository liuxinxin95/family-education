package com.education.center.sign.mapper;

import com.education.center.sign.entity.SysSignAwardDO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysSignAwardDOMapper extends Mapper<SysSignAwardDO> {

    /**
     * 批量创建签到奖励
     *
     * @param signAwardList
     * @return
     */
    int batchCreateSignAward(List<SysSignAwardDO> signAwardList);
}