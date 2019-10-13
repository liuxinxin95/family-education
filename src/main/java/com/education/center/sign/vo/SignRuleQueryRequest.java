

package com.education.center.sign.vo;

import com.education.common.PageRequest;
import lombok.Getter;
import lombok.Setter;


/**
 * @author lxx
 */
@Setter
@Getter
public class SignRuleQueryRequest extends PageRequest {
    private static final long serialVersionUID = -3494866796859723723L;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 规则状态：全部-0、待生效-1、生效中-2、已删除-3、已停用-4、已过期-5
     */
    private Integer ruleStatus;

}
