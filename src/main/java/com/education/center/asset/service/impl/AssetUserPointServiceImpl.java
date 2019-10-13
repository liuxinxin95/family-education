package com.education.center.asset.service.impl;

import com.education.center.asset.entity.AssetUserPointDO;
import com.education.center.asset.mapper.AssetUserPointDOMapper;
import com.education.center.asset.service.AssetUserPointService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Carl
 * @ClassName AssetUserPointServiceImpl
 * @Description
 * @date 2019-10-13 15:02
 **/
@Service
@Primary
public class AssetUserPointServiceImpl implements AssetUserPointService {

    @Resource
    private AssetUserPointDOMapper assetUserPointDOMapper;

    /**
     * 添加用户积分
     * @param userId
     */
    @Override
    public void addUserPoint(Integer userId){
        AssetUserPointDO assetUserPointDO = assetUserPointDOMapper.selectByPrimaryKey(userId);
        if (assetUserPointDO != null){
            return;
        }
        AssetUserPointDO userPointDO = new AssetUserPointDO();
        userPointDO.setId(userId);
        userPointDO.setAmountPoint(0L);
        userPointDO.setStatus(1);
        userPointDO.setCreateTime(new Date());
        userPointDO.setUpdateTime(new Date());
        assetUserPointDOMapper.insertSelective(userPointDO);
    }
}
