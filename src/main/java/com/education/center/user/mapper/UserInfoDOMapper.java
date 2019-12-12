package com.education.center.user.mapper;

import com.education.api.vo.ApiOrganizationVO;
import com.education.center.user.entity.UserInfoDO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserInfoDOMapper extends Mapper<UserInfoDO> {
    /**
     * 机构老师数
     *
     * @param ids
     * @return
     */
    List<ApiOrganizationVO> selectOrganizationTeacherNum(@Param("organizationIds") List<Integer> ids);
}