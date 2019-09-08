package com.education.center.user.service.impl;

import com.education.center.user.entity.SysUserDO;
import com.education.center.user.mapper.SysUserDOMapper;
import com.education.center.user.service.SysUserService;
import com.education.center.user.vo.UserVO;
import com.education.util.BeanMapUtil;
import com.education.util.JwtUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Carl
 * @ClassName SysUserServiceImpl
 * @Description
 * @date 2019-09-08 15:34
 **/
@Service
@Primary
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDOMapper sysUserDOMapper;

    /**
     * 登录成功返回session
     * @param userVO
     * @return
     */
    @Override
    public String login(UserVO userVO){
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(userVO.getOpenId());
        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        if (sysUserDO1!=null){

        }else {
            sysUserDO1 = BeanMapUtil.convertObject(userVO,SysUserDO.class);
            sysUserDO1.setCreateTime(new Date());
            sysUserDO1.setUpdateTime(new Date());
            sysUserDO1.setInviteCode(1111);
            sysUserDOMapper.insert(sysUserDO1);
        }
        //生成权限
        String jwt = JwtUtil.generateToken(sysUserDO1);
        return jwt;
    }
}
