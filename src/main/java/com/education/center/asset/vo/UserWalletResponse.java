package com.education.center.asset.vo;
import lombok.Data;

import	java.math.BigDecimal;
import	java.io.Serializable;

/**
 * @author Carl
 * @ClassName UserWalletResponse
 * @Description
 * @date 2019-10-12 18:40
 **/
@Data
public class UserWalletResponse implements Serializable {

    /**
     * 钱包金额
     */
    private BigDecimal currentAmount;


}
