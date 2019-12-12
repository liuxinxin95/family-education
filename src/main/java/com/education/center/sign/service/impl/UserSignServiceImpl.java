package com.education.center.sign.service.impl;

import com.education.center.asset.service.AssetUserPointService;
import com.education.center.sign.entity.SysUserSignLastRecordDO;
import com.education.center.sign.entity.SysUserSignRecordDO;
import com.education.center.sign.enums.SignAwardWayEnum;
import com.education.center.sign.mapper.SysUserSignLastRecordDOMapper;
import com.education.center.sign.mapper.SysUserSignRecordDOMapper;
import com.education.center.sign.service.UserSignService;
import com.education.center.sign.vo.SignDayVO;
import com.education.center.sign.vo.SysUserSignRecordVO;
import com.education.common.PageRequest;
import com.education.exception.RRException;
import com.education.util.BeanMapUtil;
import com.education.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Carl
 * @ClassName UserSignServiceImpl
 * @Description
 * @date 2019-12-12 10:03
 **/
@Service
@Primary
public class UserSignServiceImpl implements UserSignService {

    @Resource
    private SysUserSignRecordDOMapper sysUserSignRecordDOMapper;

    @Resource
    private SysUserSignLastRecordDOMapper sysUserSignLastRecordDOMapper;

    @Autowired
    private AssetUserPointService assetUserPointService;

    /**
     * 签到记录
     *
     * @param request
     * @param userId
     * @return
     */
    @Override
    public PageInfo<SysUserSignRecordVO> queryUserSignRecord(PageRequest request, Integer userId) {
        SysUserSignRecordDO recordDO = new SysUserSignRecordDO();
        recordDO.setDeleteFlag(0);
        recordDO.setUserId(userId);
        PageInfo<SysUserSignRecordDO> pageInfo = PageHelper.startPage(request.getPageNum(), request.getPageSize()).doSelectPageInfo(() -> sysUserSignRecordDOMapper.select(recordDO));
        PageInfo<SysUserSignRecordVO> voPageInfo = BeanMapUtil.convertObject(pageInfo, PageInfo.class);
        voPageInfo.setList(BeanMapUtil.convertList(pageInfo.getList(), SysUserSignRecordVO.class));
        return voPageInfo;
    }

    /**
     * 查询用户连续签到记录。
     *
     * @param userId
     * @return
     */
    @Override
    public SignDayVO getUserSign(Integer userId) {
        SignDayVO dayVO = new SignDayVO();
        SysUserSignLastRecordDO recordDO = new SysUserSignLastRecordDO();
        recordDO.setUserId(userId);
        recordDO.setState(1);
        SysUserSignLastRecordDO lastRecordDO = sysUserSignLastRecordDOMapper.selectOne(recordDO);
        if (lastRecordDO == null) {
            dayVO.setSignFlag(false);
            dayVO.setContinuousSignNum(0);
            return dayVO;
        }
        if (lastRecordDO.getLastSignTime().getTime() < DateUtil.addDay(DateUtil.getStartDateByDate(new Date()), -1).getTime()) {
            dayVO.setContinuousSignNum(0);
        } else {
            dayVO.setContinuousSignNum(lastRecordDO.getLastSignDayNum());
        }
        //如果有连续的查询连续的签到记录
        if (dayVO.getContinuousSignNum() > 0) {
            List<SysUserSignRecordDO> recordDOS = sysUserSignRecordDOMapper.selectRecordFewDay(userId, dayVO.getContinuousSignNum());
            dayVO.setRecordVOS(BeanMapUtil.convertList(recordDOS, SysUserSignRecordVO.class));
        }
        if (lastRecordDO.getLastSignTime().getTime() > DateUtil.getStartDateByDate(new Date()).getTime()) {
            dayVO.setSignFlag(true);
        } else {
            dayVO.setSignFlag(false);
        }
        return dayVO;
    }

    /**
     * 提交签到
     *
     * @param userId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSign(Integer userId) {
        SysUserSignLastRecordDO recordDO = new SysUserSignLastRecordDO();
        recordDO.setUserId(userId);
        recordDO.setState(1);
        SysUserSignLastRecordDO lastRecordDO = sysUserSignLastRecordDOMapper.selectOne(recordDO);
        SysUserSignRecordDO signRecordDO = new SysUserSignRecordDO();
        signRecordDO.setUserId(userId);
        signRecordDO.setDeleteFlag(0);
        signRecordDO.setAwardWay(SignAwardWayEnum.POINT.getCode());
        signRecordDO.setCreateTime(new Date());
        signRecordDO.setUpdateTime(new Date());
        Integer dayNum = 1;
        Boolean insertFlag = false;
        if (lastRecordDO==null){
            insertFlag = true;
            lastRecordDO = new SysUserSignLastRecordDO();
            lastRecordDO.setLastSignTime(new Date());
            lastRecordDO.setLastSignDayNum(dayNum);
            lastRecordDO.setUserId(userId);
            lastRecordDO.setState(1);
            lastRecordDO.setCreateTime(new Date());
            signRecordDO.setAwardPoint(1L);
        }else {
            if (lastRecordDO.getLastSignTime().getTime() > DateUtil.getStartDateByDate(new Date()).getTime()) {
                throw new RRException("今日已经签到，请勿重复签到");
            }
            if (lastRecordDO.getLastSignTime().getTime() < DateUtil.addDay(DateUtil.getStartDateByDate(new Date()), -1).getTime()) {
                //1积分
                signRecordDO.setAwardPoint(1L);
            } else {
                if (lastRecordDO.getLastSignDayNum() >= 6) {
                    //7积分
                    signRecordDO.setAwardPoint(7L);

                } else {
                    //几天是就是多少积分
                    signRecordDO.setAwardPoint(lastRecordDO.getLastSignDayNum().longValue() + 1);
                }
                dayNum = (lastRecordDO.getLastSignDayNum() + 1);
            }
            lastRecordDO.setLastSignDayNum(dayNum);
            lastRecordDO.setLastSignTime(new Date());
        }
        signRecordDO.setCreateTime(new Date());
        signRecordDO.setUpdateTime(new Date());
        sysUserSignRecordDOMapper.insertOne(signRecordDO);
        lastRecordDO.setLastRecordId(signRecordDO.getRecordId());
        lastRecordDO.setUpdateTime(new Date());
        if (insertFlag){
            sysUserSignLastRecordDOMapper.insert(lastRecordDO);
        }else {
            //修改最后签到记录
            sysUserSignLastRecordDOMapper.updateByPrimaryKeySelective(lastRecordDO);
        }
        assetUserPointService.addRecord("sign", "", userId, signRecordDO.getAwardPoint());
    }

}
