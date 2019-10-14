package com.education.center.sign.mapper;

import com.education.center.sign.entity.SysSignRuleDO;
import com.education.center.sign.vo.SignRuleQueryRequest;
import com.education.center.sign.vo.SignRuleQueryResponse;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SysSignRuleDOMapper extends Mapper<SysSignRuleDO> {

    /**
     * 根据名称查询签到规则
     *
     * @param ruleName
     * @return
     */
    List<SysSignRuleDO> selectByName(@Param("ruleName") String ruleName);


//    List<SysSignRuleDO> selectByParam(@Param("param") );

    List<SysSignRuleDO> selectByTime(@Param("ruleStartTime") Date ruleStartTime, @Param("ruleEndTime") Date ruleEndTime);

    /**
     * 签到规则列表查询
     *
     * @param request
     * @return
     */
    List<SignRuleQueryResponse> signRulePageList(SignRuleQueryRequest request);
}