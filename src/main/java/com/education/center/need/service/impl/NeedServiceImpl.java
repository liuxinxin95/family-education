package com.education.center.need.service.impl;

import com.education.center.need.entity.NeedInfoDO;
import com.education.center.need.mapper.NeedInfoDOMapper;
import com.education.center.need.service.NeedService;
import com.education.center.need.vo.*;
import com.education.center.user.entity.SysUserDO;
import com.education.center.user.entity.UserInfoDO;
import com.education.center.user.mapper.UserInfoDOMapper;
import com.education.center.user.service.SysUserService;
import com.education.exception.RRException;
import com.education.util.BeanMapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Carl
 * @ClassName NeedServiceImpl
 * @Description 需求类
 * @date 2019-09-09 22:45
 **/
@Service
@Primary
public class NeedServiceImpl implements NeedService {

    @Resource
    private NeedInfoDOMapper needInfoDOMapper;

    @Autowired
    private SysUserService sysUserService;

    @Resource
    private UserInfoDOMapper userInfoDOMapper;

    /**
     * 发布需求
     *
     * @param needInfoVO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveNeedInfo(NeedInfoParam needInfoVO) {
        SysUserDO sysUserDO1 = sysUserService.getUser();

        if (needInfoVO.getNeedType() != null) {
            if (needInfoVO.getNeedType() == 0) {
                UserInfoDO userInfoDO = new UserInfoDO();
                userInfoDO.setUserId(sysUserDO1.getId());
                UserInfoDO userInfoDO1 = userInfoDOMapper.selectOne(userInfoDO);
                if (userInfoDO1 == null || userInfoDO1.getUserType() == 1) {
                    List<NeedOverviewVO> needOverviewVOS = needInfoDOMapper.selectMyNeed(sysUserDO1.getId());
                    if (needOverviewVOS.size() > 3) {
                        throw new RRException("已超出需求不发上限");
                    }
                } else {
                    if (userInfoDO1.getPaySingleStatus() == null || userInfoDO1.getPaySingleStatus() == 0) {
                        throw new RRException("请先缴纳企业认证费用再不发需求");
                    }
                }
            }
        } else {
            throw new RRException("请指定需求类型");
        }
        NeedInfoDO needInfoDO = BeanMapUtil.convertObject(needInfoVO, NeedInfoDO.class);
        needInfoDO.setUserId(sysUserDO1.getId());
        int insert = needInfoDOMapper.insert(needInfoDO);
        if (insert <= 0) {
            throw new RRException("需求发布失败，请稍后重试");
        }
    }


    /**
     * 获取自己需求列表
     *
     * @return
     */
    @Override
    public List<NeedOverviewVO> getMyNeedList() {
        SysUserDO sysUserDO1 = sysUserService.getUser();
        List<NeedOverviewVO> needOverviewVOS = needInfoDOMapper.selectMyNeed(sysUserDO1.getId());
        return BeanMapUtil.convertList(needOverviewVOS, NeedOverviewVO.class);
    }


    /**
     * 获取需求列表
     *
     * @param request
     * @return
     */
    @Override
    public PageInfo<NeedInfoVO> getPageList(NeedInfoRequest request) {
        //设置经纬度查询
        setMaxLon(request);
        PageInfo<NeedInfoVO> objectPageInfo = PageHelper.startPage(request.getPageNum(), request.getPageNum()).doSelectPageInfo(() -> needInfoDOMapper.selectPageList(request));
        objectPageInfo.getList().parallelStream().forEach(x -> {
            if (x.getCertificationStatus() > 2) {
                x.setCertificationStatusText("已认证");
            } else {
                x.setCertificationStatusText("未认证");
            }
        });
        return objectPageInfo;
    }

    /**
     * 地图模式
     *
     * @return
     */
    @Override
    public List<NeedInfoVO> getListForMap(NeedInfoRequest request) {
        setMaxLon(request);
        return needInfoDOMapper.selectPageList(request);
    }


    /**
     * 需求明细
     *
     * @param id
     * @return
     */
    @Override
    public NeedDetailVO getNeedDetail(Integer id, Double longitude, Double latitude) {
        NeedDetailVO needDetailVO = needInfoDOMapper.selectDetail(id, longitude, latitude);
        if (needDetailVO != null) {
            if (needDetailVO.getCertificationStatus() > 2) {
                needDetailVO.setCertificationStatusText("已认证");
            } else {
                needDetailVO.setCertificationStatusText("未认证");
            }

        } else {
            throw new RRException("需求信息查询错误，请稍后重试");
        }
        return needDetailVO;
    }

    /**
     * 查找附近的人
     *
     * @return
     */
    public static void setMaxLon(NeedInfoRequest request) {
        //地球半径千米
        double r = 6371;
        double dis = request.getRadii();
        double dlng = 2 * Math.asin(Math.sin(dis / (2 * r)) / Math.cos(request.getLat() * Math.PI / 180));
        //角度转为弧度
        dlng = dlng * 180 / Math.PI;
        double dlat = dis / r;
        dlat = dlat * 180 / Math.PI;
        double minlat = request.getLat() - dlat;
        double maxlat = request.getLat() + dlat;
        double minlng = request.getLon() - dlng;
        double maxlng = request.getLon() + dlng;
        request.setMaxlat(maxlat);
        request.setMinlat(minlat);
        request.setMaxlng(maxlng);
        request.setMinlng(minlng);
    }
}
