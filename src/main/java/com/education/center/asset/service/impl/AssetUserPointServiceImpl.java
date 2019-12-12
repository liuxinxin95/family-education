package com.education.center.asset.service.impl;

import com.education.center.asset.entity.AssetUserPointDO;
import com.education.center.asset.entity.AssetUserPointRecordDO;
import com.education.center.asset.mapper.AssetUserPointDOMapper;
import com.education.center.asset.mapper.AssetUserPointRecordDOMapper;
import com.education.center.asset.service.AssetUserPointService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    private AssetUserPointRecordDOMapper assetUserPointRecordDOMapper;

    /**
     * 添加用户积分
     *
     * @param userId
     */
    @Override
    public void addUserPoint(Integer userId) {
        AssetUserPointDO assetUserPointDO = assetUserPointDOMapper.selectByPrimaryKey(userId);
        if (assetUserPointDO != null) {
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

    /**
     * 添加积分记录
     *
     * @param tradeCode
     * @param tradeNo
     * @param userId
     * @param point
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRecord(String tradeCode, String tradeNo, Integer userId, Long point) {
        AssetUserPointDO assetUserPointDO = assetUserPointDOMapper.selectByPrimaryKey(userId);
        AssetUserPointRecordDO pointRecordDO = new AssetUserPointRecordDO();
        if (assetUserPointDO != null){
            pointRecordDO.setPostTradeAmount(assetUserPointDO.getAmountPoint() + point);
            pointRecordDO.setPreTradeAmount(assetUserPointDO.getAmountPoint());
            pointRecordDO.setTradeAmount(point);
            pointRecordDO.setTradeCode(tradeCode);
            pointRecordDO.setTradeDate(new Date());
            pointRecordDO.setTradeNo(tradeNo);
            pointRecordDO.setTradeTime(new Date());
            pointRecordDO.setUserId(userId);
        }else {
            addUserPoint(userId);
            addRecord(tradeCode,tradeNo,userId,point);
        }

        assetUserPointRecordDOMapper.insert(pointRecordDO);
        assetUserPointDO.setAmountPoint(assetUserPointDO.getAmountPoint() + point);
        assetUserPointDO.setUpdateTime(new Date());
        assetUserPointDOMapper.updateByPrimaryKeySelective(assetUserPointDO);

    }
}
