package com.education.center.sign.mapper;

import com.education.center.sign.entity.SysUserSignRecordDO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserSignRecordDOMapper extends Mapper<SysUserSignRecordDO> {

    /**
     * 查询用户前几天的签到记录
     *
     * @param userId
     * @param day
     * @return
     */
    List<SysUserSignRecordDO> selectRecordFewDay(@Param("userId") Integer userId, @Param("day") Integer day);

    /**
     * 添加
     *
     * @param recordDO
     * @return
     */
    int insertOne(SysUserSignRecordDO recordDO);
}