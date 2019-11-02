package com.education.center.user.mapper;

import com.education.center.user.entity.SysUserDO;
import com.education.center.user.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserDOMapper extends Mapper<SysUserDO> {

    int insertOne(SysUserDO sysUserDO);

    /**
     * 用户查询
     *
     * @return
     */
    UserVO selectByOpendId(@Param("openId")String openId);
}