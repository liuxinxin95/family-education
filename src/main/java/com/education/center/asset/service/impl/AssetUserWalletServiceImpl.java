package com.education.center.asset.service.impl;
import	java.math.BigDecimal;

import com.education.center.asset.entity.AssetUserWalletDO;
import com.education.center.asset.mapper.AssetUserWalletDOMapper;
import com.education.center.asset.service.AssetUserWalletService;
import com.education.center.asset.vo.UserWalletResponse;
import com.education.center.user.entity.SysUserDO;
import com.education.center.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

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

    public UserWalletResponse getUserWallet(){
        SysUserDO user = sysUserService.getUser();
        AssetUserWalletDO assetUserWalletDO = assetUserWalletDOMapper.selectByPrimaryKey(user.getId());

    }
}
