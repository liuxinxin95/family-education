package com.education.center.need.service.impl;

import com.education.center.need.entity.NeedInfoDO;
import com.education.center.need.mapper.NeedInfoDOMapper;
import com.education.center.need.service.NeedService;
import com.education.center.need.vo.NeedInfoVO;
import com.education.center.user.entity.SysUserDO;
import com.education.center.user.mapper.SysUserDOMapper;
import com.education.common.SysUser;
import com.education.common.UserContext;
import com.education.exception.RRException;
import com.education.util.BeanMapUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName NeedServiceImpl
 * @Description 需求类
 * @date 2019-09-09 22:45
 **/
@Service
@Primary
@Log4j
public class NeedServiceImpl implements NeedService {

    @Resource
    private NeedInfoDOMapper needInfoDOMapper;

    @Resource
    private SysUserDOMapper sysUserDOMapper;

    /**
     * 发布需求
     *
     * @param needInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveNeedInfo(NeedInfoVO needInfoVO) {
        String openId = ((SysUser) UserContext.getContext().getCurrentUser()).getOpenId();
        SysUserDO sysUserDO = new SysUserDO();
        sysUserDO.setOpenId(openId);
        SysUserDO sysUserDO1 = sysUserDOMapper.selectOne(sysUserDO);
        if (sysUserDO1 == null) {
            throw new RRException("用户信息查询错误");
        }
        NeedInfoDO needInfoDO = BeanMapUtil.convertObject(needInfoVO, NeedInfoDO.class);
        needInfoDO.setUserId(sysUserDO1.getId());
        int insert = needInfoDOMapper.insert(needInfoDO);
        if (insert <= 0) {
            throw new RRException("需求发布失败，请稍后重试");
        }
    }
}
