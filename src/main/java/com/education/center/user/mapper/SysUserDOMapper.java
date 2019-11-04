package com.education.center.user.mapper;

import com.education.api.param.QueryOrganizationParam;
import com.education.api.param.QueryTeacherParam;
import com.education.api.vo.ApiOrganizationVO;
import com.education.api.vo.ApiTeacherVO;
import com.education.center.user.entity.SysUserDO;
import com.education.center.user.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserDOMapper extends Mapper<SysUserDO> {

    int insertOne(SysUserDO sysUserDO);

    /**
     * 用户查询
     *
     * @return
     */
    UserVO selectByOpendId(@Param("openId") String openId);

    /**
     * 老师查询
     *
     * @return
     */
    List<ApiTeacherVO> selectTeacher(QueryTeacherParam param);


    /**
     * 机构查询
     *
     * @param param
     * @return
     */
    List<ApiOrganizationVO> selectOrganization(QueryOrganizationParam param);


    List<ApiTeacherVO> selectTeacherByList(@Param("userIds") List<Integer> userIds);
}