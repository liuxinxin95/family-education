
package com.education.center.sign.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Z.C.H on 2019/02/18 10:46.
 * Desc:签到规则新增参数
 */
@Getter
@Setter
public class SignRuleAddRequest implements Serializable {


    private static final long serialVersionUID = -1733164538715883211L;

    /**
     * 创建用户UID
     */
    @NotNull(message = "创建用户UID不能为空")
    private Long creatorUid;

    /**
     * 创建用户名称
     */
    @NotBlank(message = "创建用户名称不能为空")
    private String creatorName;

    /**
     * 城市编码
     */
    @NotBlank(message = "规则名称不能为空")
    private String cityCode;


    /**
     * 规则名称
     */
    @NotBlank(message = "规则名称不能为空")
    private String ruleName;


    /**
     * 规则开始时间
     */
    @NotNull(message = "规则开始时间不能为空")
    private Date ruleStartTime;


    /**
     * 规则结束时间
     */
    @NotNull(message = "规则结束时间名称不能为空")
    private Date ruleEndTime;


    /**
     * 规则周期
     */
    @NotNull(message = "规则周期不能为空")
    private Integer ruleCycle;

    /**
     * 规则说明
     */
    private String ruleDesc;

    /**
     * 签到类型
     */
    @NotNull(message = "签到类型不能为空")
    private Integer signType;

    /**
     * 日签奖励
     */
    private List<SignDayAwardRequest> dayAwardRequestList;

    /**
     * 连续签奖励
     */
    private List<SignContinueAwardRequest> continueAwardRequestList;

}
