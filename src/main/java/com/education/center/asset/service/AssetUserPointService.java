package com.education.center.asset.service;

/**
 * @author Carl
 * @ClassName AssetUserPointService
 * @Description
 * @date 2019-10-13 15:02
 **/
public interface AssetUserPointService {

    /**
     * 添加积分信息
     *
     * @param userId
     */
    void addUserPoint(Integer userId);

    /**
     * 添加积分记录
     *
     * @param tradeCode
     * @param tradeNo
     * @param userId
     * @param point
     */
    void addRecord(String tradeCode, String tradeNo, Integer userId, Long point);
}
