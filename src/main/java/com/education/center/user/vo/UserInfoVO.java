package com.education.center.user.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Carl
 * @ClassName UserInfoVo
 * @Description
 * @date 2019-09-30 11:25
 **/
@Data
public class UserInfoVO implements Serializable {
    /**
     * 微信id
     */
    private String openId;
    /**
     * 名称
     */
    private String userName;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 性别：0女1男
     */
    private Long sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 职业
     */
    private String professional;

    /**
     * 手机号
     */
    private String phone;

}
