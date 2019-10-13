package com.education.center.asset.service.impl;
import	java.util.Optional;

import java.math.BigDecimal;
import java.util.Date;

import com.education.center.asset.entity.AssetUserWalletDO;
import com.education.center.asset.mapper.AssetUserWalletDOMapper;
import com.education.center.asset.service.AssetUserWalletService;
import com.education.center.asset.vo.UserWalletResponse;
import com.education.center.user.entity.SysUserDO;
import com.education.center.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName AssetUserWalletServiceImpl
 * @Description
 * @date 2019-10-12 18:34
 **/
@Service
@Primary
public class AssetUserWalletServiceImpl implements AssetUserWalletService {

    @Autowired
    private SysUserService sysUserService;

    @Resource
    private AssetUserWalletDOMapper assetUserWalletDOMapper;


    public UserWalletResponse getUserWallet() {
        UserWalletResponse userWalletResponse = new UserWalletResponse();
        SysUserDO user = sysUserService.getUser();
        AssetUserWalletDO assetUserWalletDO = assetUserWalletDOMapper.selectByPrimaryKey(user.getId());
        userWalletResponse.setCurrentAmount(new BigDecimal(assetUserWalletDO.getCurrentAmount()).divide(new BigDecimal(100)));
        return userWalletResponse;
    }


    /**
     * 添加用户钱包
     *
     * @param userId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUserWallet(Integer userId) {
        AssetUserWalletDO assetUserWalletDO = assetUserWalletDOMapper.selectByPrimaryKey(userId);
        if (assetUserWalletDO != null) {
            return;
        }
        AssetUserWalletDO userWalletDO = new AssetUserWalletDO();
        userWalletDO.setId(userId);
        userWalletDO.setCurrentAmount(0L);
        userWalletDO.setStatus(1);
        userWalletDO.setCreateTime(new Date());
        userWalletDO.setUpdateTime(new Date());
        userWalletDO.setMaxWithdrawAmount(0L);
        assetUserWalletDOMapper.insert(userWalletDO);
    }
}
