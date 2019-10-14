package com.education.center.sign.mapper;

import com.education.center.sign.entity.SysUserSignLastRecordDO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserSignLastRecordDOMapper extends Mapper<SysUserSignLastRecordDO> {

    /**
     * 获取用户最后一次签到记录
     * @param id
     * @return
     */
    SysUserSignLastRecordDO getUserLastSignRecord(@Param("userId") Integer id);
}