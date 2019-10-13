package com.education.center.sign.service.impl;

import com.education.center.sign.entity.SysSignAwardDO;
import com.education.center.sign.entity.SysSignRuleDO;
import com.education.center.sign.enums.SignAwardWayEnum;
import com.education.center.sign.mapper.SysSignAwardDOMapper;
import com.education.center.sign.mapper.SysSignRuleDOMapper;
import com.education.center.sign.service.SignService;
import com.education.center.sign.vo.*;
import com.education.exception.RRException;
import com.education.util.BeanMapUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Carl
 * @ClassName signServiceImpl
 * @Description
 * @date 2019-10-12 16:41
 **/
@Service
@Primary
public class SignServiceImpl implements SignService {

    @Resource
    private SysSignRuleDOMapper sysSignRuleDOMapper;

    @Resource
    private SysSignAwardDOMapper sysSignAwardDOMapper;

    /**
     * 创建签到规则
     *
     * @param request
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createSignRule(@Valid SignRuleAddRequest request) {
        //1、校验规则名称是否已经存在
        if (this.checkRuleNameIsExist(request.getRuleName())) {
            throw new RRException(String.format("规则名称「%s」已经存在，请核实！", request.getRuleName()));
        }

        List<SysSignRuleDO> citySignRuleList = sysSignRuleDOMapper.selectByTime(request.getRuleStartTime(), request.getRuleEndTime());
        if (CollectionUtils.isNotEmpty(citySignRuleList)) {
            throw new RRException("该时间段内已经存在「生效中」的签到规则，请勿重复添加！");
        }
        //2、保存规则
        SysSignRuleDO mallCitySignRule = BeanMapUtil.convertObject(request, SysSignRuleDO.class);
        mallCitySignRule.setCreateTime(new Date());
        mallCitySignRule.setDeleteFlag(0);
        mallCitySignRule.setDisable(0);
        int saveSignResult = sysSignRuleDOMapper.insertSelective(mallCitySignRule);
        if (saveSignResult > 0) {
            Long ruleId = mallCitySignRule.getRuleId();
            List<SignDayAwardRequest> dayAwardList = request.getDayAwardRequestList();
            //2.1、构建并保存日签签到奖励
            this.buildAndCreateSignAward(dayAwardList, ruleId, request.getCreatorUid(), request.getCreatorName());
            //2.2、构建并保存连续签到奖励
            List<SignContinueAwardRequest> continueAwardList = request.getContinueAwardRequestList();
            this.buildAndCreateSignAward(continueAwardList, ruleId, request.getCreatorUid(), request.getCreatorName());
        }
    }


    /**
     * 规则列表
     *
     * @param request
     * @return
     */
    @Override
    public PageInfo<SignRuleQueryResponse> signRulePageList(SignRuleQueryRequest request) {
        //分页获取签到规则
        PageInfo<SignRuleQueryResponse> pageResponse = PageHelper.startPage(request.getPageNum(), request.getPageNum()).doSelectPageInfo(() -> sysSignRuleDOMapper.signRulePageList(request));
        return pageResponse;
    }


    /**
     * 构建并创建签到奖励
     *
     * @param awardBaseList
     * @param ruleId
     * @param creatorUid
     * @param creatorName
     */
    private void buildAndCreateSignAward(List<? extends SignAwardBaseRequest> awardBaseList, Long ruleId, Long creatorUid, String creatorName) {
        List<SysSignAwardDO> signAwardList = new ArrayList<>(awardBaseList.size());
        awardBaseList.forEach(item -> {
            //日签
            if (item instanceof SignDayAwardRequest) {
                SysSignAwardDO signAward = buildSignAwardList(item, ruleId, creatorUid, creatorName);
                signAwardList.add(signAward);
                //连续签到
            } else if (item instanceof SignContinueAwardRequest) {
                SysSignAwardDO signAward = buildSignAwardList(item, ruleId, creatorUid, creatorName);
                signAwardList.add(signAward);
            }
        });
        sysSignAwardDOMapper.batchCreateSignAward(signAwardList);
    }



    /**
     * 规则名称校验
     *
     * @param ruleName
     * @return
     */
    private Boolean checkRuleNameIsExist(@NotBlank(message = "规则名称不能为空") String ruleName) {
        List<SysSignRuleDO> citySignRuleList = sysSignRuleDOMapper.selectByName(ruleName);
        return CollectionUtils.isNotEmpty(citySignRuleList);
    }

    /**
     * 构建签到奖励
     *
     * @param awardBase
     * @param ruleId
     * @param creatorUid
     * @param creatorName
     * @return
     */
    private SysSignAwardDO buildSignAwardList(SignAwardBaseRequest awardBase, Long ruleId, Long creatorUid, String creatorName) {
        SysSignAwardDO signAward = new SysSignAwardDO();
        if (awardBase.getAwardWay() == SignAwardWayEnum.POINT.getCode()) {
            signAward.setAwardValue(awardBase.getIntegral().longValue());
        } else if (awardBase.getAwardWay() == SignAwardWayEnum.WALLET.getCode()) {
            signAward.setAwardValue(awardBase.getWalletAmount().multiply(new BigDecimal(100)).setScale(0, 4).longValue());
        }
        signAward.setRuleId(ruleId);
        signAward.setAwardType(awardBase.getAwardType());
        signAward.setDayNum(awardBase.getDayNum());
        signAward.setAwardWay(awardBase.getAwardWay());

        signAward.setDeleteFlag(0);
        signAward.setCreateTime(new Date());
        //0：存在、1：不存在
        signAward.setAwardFlag(0);
        return signAward;

    }
}
