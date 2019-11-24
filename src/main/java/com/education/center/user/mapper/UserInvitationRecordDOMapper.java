package com.education.center.user.mapper;

import com.education.api.vo.UserInvitationRecordVO;
import com.education.center.user.entity.UserInvitationRecordDO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserInvitationRecordDOMapper extends Mapper<UserInvitationRecordDO> {


    /**
     * 邀请记录
     * @param userId
     * @return
     */
    List<UserInvitationRecordVO> getInvitationRecord(@Param("userId") Integer userId);
}