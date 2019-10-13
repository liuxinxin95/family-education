package com.education.center.sign.service.impl;

import com.education.center.sign.mapper.SysSignAwardDOMapper;
import com.education.center.sign.mapper.SysSignRuleDOMapper;
import com.education.center.sign.mapper.SysUserSignLastRecordDOMapper;
import com.education.center.sign.mapper.SysUserSignRecordDOMapper;
import com.education.center.sign.service.UserSignService;
import com.education.center.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Carl
 * @ClassName UserSignServiceImpl
 * @Description
 * @date 2019-10-12 17:49
 **/
@Service
@Primary
public class UserSignServiceImpl implements UserSignService {

    @Autowired
    private SysUserService sysUserService;

    @Resource
    private SysUserSignRecordDOMapper sysUserSignRecordDOMapper;

    @Resource
    private SysUserSignLastRecordDOMapper sysUserSignLastRecordDOMapper;

    @Resource
    private SysSignRuleDOMapper sysSignRuleDOMapper;

    @Resource
    private SysSignAwardDOMapper sysSignAwardDOMapper;


//    public SignRuleResponse getSignRule() {
//        SignRuleResponse response = this.getValidSignRule();
//        if (!response.getRuleExistFlag()) {//规则不存在的时候直接返回
//            return response;
//        }
//        //为了方便前端H5页面解析，将签到奖励的列表做了合并（一天中既有「日签」又有「连续签到」，合并到一起）
//        List<SignAwardResponse> signAwardVOList = response.getSignAwardResponseList();
//        List<SignAwardResponse> daySignAwardList = signAwardVOList.stream().filter(item -> item.getAwardType() == SignAwardTypeEnum.DAY_SIGN_SAME.getCode() || item.getAwardType() == SignAwardTypeEnum.DAY_SIGN_DIFFER.getCode()).collect(Collectors.toList());
//        List<SignAwardResponse> continueSignAwardList = signAwardVOList.stream().filter(item -> item.getAwardType() == SignAwardTypeEnum.CONTINUE_SIGN.getCode()).collect(Collectors.toList());
//        Integer missesSignDays = response.getMissesSignDays();
//        Integer continueSignDays = response.getContinueSignDays();
//        Map<Integer, SignAwardResponse> resultMap = new HashMap<>();
//        for (SignAwardResponse item : daySignAwardList) {
//            if (item != null && item.getAwardType() == SignAwardTypeEnum.DAY_SIGN_SAME.getCode()) {//日签每日相同
//                for (Integer i = 1; i <= response.getRuleCycle(); i++) {
//                    SignAwardResponse award = new SignAwardResponse();
//                    award.setDayNum(i);
//                    if (response.getSignStatus() != SignStatusEnum.MISSES_SIGN.getCode()) {//不存在漏签的时候
//                        if (i <= continueSignDays) {
//                            award.setSingFlag(SignStatusEnum.SIGNED.getCode());
//                        } else {
//                            award.setSingFlag(SignStatusEnum.UN_SIGN.getCode());
//                        }
//                    } else {//存在漏签的时候
//                        if (i <= continueSignDays) {
//                            award.setSingFlag(SignStatusEnum.SIGNED.getCode());
//                        } else {
//                            if (missesSignDays-- > 0) {
//                                award.setSingFlag(SignStatusEnum.MISSES_SIGN.getCode());
//                            } else {
//                                award.setSingFlag(SignStatusEnum.UN_SIGN.getCode());
//                            }
//                        }
//                    }
//                    award.setRedPacketAmount(item.getRedPacketAmount());
//                    award.setWalletAmount(item.getWalletAmount());
//                    award.setTotalAwardAmount(item.getTotalAwardAmount());
//                    award.setAwardType(item.getAwardType());
//                    award.setAwardWay(item.getAwardWay());
//                    resultMap.put(i, award);
//                }
//            } else if (item != null && item.getAwardType() == SignAwardTypeEnum.DAY_SIGN_DIFFER.getCode()) {//日签每日不同
//
//                if (response.getSignStatus() != SignStatusEnum.MISSES_SIGN.getCode()) {//不存在漏签的时候
//                    if (item.getDayNum() <= continueSignDays) {
//                        item.setSingFlag(SignStatusEnum.SIGNED.getCode());
//                    } else {
//                        item.setSingFlag(SignStatusEnum.UN_SIGN.getCode());
//                    }
//                } else {//存在漏签的时候
//                    if (item.getDayNum() <= continueSignDays) {
//                        item.setSingFlag(SignStatusEnum.SIGNED.getCode());
//                    } else {
//                        if (missesSignDays-- > 0) {
//                            item.setSingFlag(SignStatusEnum.MISSES_SIGN.getCode());
//                        } else {
//                            item.setSingFlag(SignStatusEnum.UN_SIGN.getCode());
//                        }
//                    }
//                }
//                resultMap.put(item.getDayNum(), item);
//            }
//        }
//
//
//        continueSignAwardList.forEach(item -> {
//            SignAwardResponse award = resultMap.get(item.getDayNum());
//            if (award != null) {
//                if (!Objects.equals(award.getAwardWay(), item.getAwardWay())) {//奖励方式不一样的时候
//                    award.setAwardWay(12);//红包+钱包
//                } else if (award.getAwardWay() == SignAwardWayEnum.RED_PACKET.getCode() && item.getAwardWay() == SignAwardWayEnum.RED_PACKET.getCode()) {
//                    award.setAwardWay(22);//红包+红包
//                } else if (award.getAwardWay() == SignAwardWayEnum.WALLET.getCode() && item.getAwardWay() == SignAwardWayEnum.WALLET.getCode()) {
//                    award.setAwardWay(11);//钱包+钱包
//                }
//                award.setWalletAmount(award.getWalletAmount().add(item.getWalletAmount()));
//                award.setRedPacketAmount(award.getRedPacketAmount().add(item.getRedPacketAmount()));
//                award.setTotalAwardAmount(award.getTotalAwardAmount().add(item.getTotalAwardAmount()));
//                resultMap.put(award.getDayNum(), award);
//            }
//        });
//
//        signAwardVOList = new ArrayList<>(resultMap.values());
//        response.setSignAwardResponseList(signAwardVOList);
//        return response;
//    }
//
//
//    public SignRuleResponse getValidSignRule() {
//
//        SysUserDO user = sysUserService.getUser();
//
//        SignRuleResponse response = new SignRuleResponse();
//        //获取用户最后一次签到
//        SysUserSignLastRecordDO lastSignRecord = sysUserSignLastRecordDOMapper.getUserLastSignRecord(user.getId());
//
//        if (lastSignRecord != null) {//存在最后一次签到
//            SignRuleAwardCashModel signRuleAwardCashModel = signRuleCache.get(lastSignRecord.getRuleId());//根据规则ID获取规则+奖励信息
//            if (signRuleAwardCashModel == null) {//没有签到规则
//                return this.getCityValidSignRule(cityCode);
//            }
//            Integer lastSignDayNum = lastSignRecord.getLastSignDayNum();//最后签到天数
//            int dayDif = this.compareDayDif(lastSignRecord.getLastSignTime(), new Date());//时间差
//            /**
//             * 比较“最后签到天数”和“签到规则周期”
//             */
//            if (signRuleAwardCashModel.getRuleCycle().equals(lastSignDayNum)) {//相等
//                if (dayDif == 0) {//今日正好达到满签的情况
//                    response = this.buildUnSignAndSigned(signRuleAwardCashModel, lastSignDayNum, SignStatusEnum.SIGNED);
//                } else if (signRuleAwardCashModel.isRuleIsValid()) {//规则有效
//                    response = this.buildFirstSignResponse(signRuleAwardCashModel);
//                } else {//规则已经无效,则获取当前城市下一条有效的规则
//                    response = this.getCityValidSignRule(cityCode);
//                }
//            } else if (signRuleAwardCashModel.getRuleCycle() > lastSignDayNum) {//小于
//                if (dayDif > 1) {//存在漏签
//                    if (dayDif > signRuleAwardCashModel.getRuleCycle() - lastSignDayNum
//                            || !signRuleAwardCashModel.isRuleIsValid()
//                            || signRuleAwardCashModel.getDisable() == SignDisableEnum.DISABLE.getCode()) {//“漏签天数”大于“签到周期-已签到天数” 或者规则已经无效 或是规则已经停用
//                        response = this.getCityValidSignRule(cityCode);
//                    } else {
//                        response = this.buildMissesSignResponse(signRuleAwardCashModel, dayDif, lastSignDayNum);
//                    }
//                } else if (dayDif == 1) {//今日未签
//                    response = this.buildUnSignAndSigned(signRuleAwardCashModel, lastSignDayNum, SignStatusEnum.UN_SIGN);
//                } else if (dayDif == 0) {//今日已签
//                    response = this.buildUnSignAndSigned(signRuleAwardCashModel, lastSignDayNum, SignStatusEnum.SIGNED);
//                }
//            }
//        } else {//不存在最后签到记录
//            response = this.getValidSignRule();
//        }
//        return response;
//    }
//
//    private SignRuleResponse getValidSignRule() {
//        SysSignRuleDO sysSignRuleDO = new SysSignRuleDO();
//        sysSignRuleDO.setDisable(0);
//        sysSignRuleDO.setDeleteFlag(0);
//        SysSignRuleDO signRule = sysSignRuleDOMapper.selectOne(sysSignRuleDO);
//        //没有可用的规则
//        if (signRule == null) {
//            SignRuleResponse response = new SignRuleResponse();
//            response.setRuleExistFlag(false);
//            return response;
//        } else {
//            //存在有效的规则
//            SignRuleAwardCashModel newSignRuleAwardCashModel = signRuleCache.get(signRule.getRuleId());//根据规则ID获取规则+奖励信息
//            return this.buildFirstSignResponse(newSignRuleAwardCashModel);
//        }
//    }
//
//
//    /*
//     * Author: z.c.h 2019/2/21 11:08
//     * Desc:构建第一次签到情况返回对象
//     */
//    private SignRuleResponse buildFirstSignResponse(SignRuleAwardCashModel cashModel) {
//        SignRuleResponse response = new SignRuleResponse();
//        response.setRuleExistFlag(true);
//        response.setRuleId(cashModel.getRuleId());
//        response.setContinueSignDays(0);
//        response.setMissesSignDays(0);
//        response.setRuleDesc(cashModel.getRuleDesc());
//        response.setSignStatus(UN_SIGN.getCode());
//        response.setSignStatusText(UN_SIGN.getDesc());
//        response.setRuleCycle(cashModel.getRuleCycle());
//        List<SignAwardDO> signAwardList = cashModel.getSignAwardList();
//        response.setSignShowText("每日签到百分百获得奖励");
//        List<SignAwardResponse> signAwardVOList = new ArrayList<>();
//        signAwardList.forEach(item -> {
//            SignAwardResponse awardResponse = new SignAwardResponse();
//            awardResponse.setDayNum(item.getDayNum());
//            awardResponse.setAwardType(item.getAwardType());
//            awardResponse.setAwardWay(item.getAwardWay());
//            awardResponse.setAwardIntegral(item.getAwardIntegral());
//            /**
//             * 计算奖励
//             */
//            this.awardAmountCompute(awardResponse, item.getAwardWay(), item.getAwardValue());
//            awardResponse.setTotalAwardAmount(awardResponse.getWalletAmount().add(awardResponse.getRedPacketAmount()));
//            awardResponse.setSingFlag(UN_SIGN.getCode());
//            signAwardVOList.add(awardResponse);
//        });
//        response.setSignAwardResponseList(signAwardVOList);
//        return response;
//    }
}
