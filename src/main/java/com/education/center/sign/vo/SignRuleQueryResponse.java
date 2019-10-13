
package com.education.center.sign.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
public class SignRuleQueryResponse implements Serializable {

    private static final long serialVersionUID = -2034281224751242420L;
    /**
     * 规则ID
     */
    private Long ruleId;

    /**
     * 规则名称
     */
    private String ruleName;



    /**
     * 规则开始时间
     */
    private Date ruleStartTime;
    /**
     * 规则周期
     */
    private Integer ruleCycle;

    /**
     * 规则结束时间
     */
    private Date ruleEndTime;

    /**
     * 规则状态值
     */
    private Integer status;
    /**
     * 规则状态
     */
    private String statusText;

    /**
     * 规则状态文案
     */
    private String ruleDesc;

    /**
     * 创建用户UID
     */
    private Long creatorUid;

    /**
     * 创建用户名称
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private Date createTime;


}
