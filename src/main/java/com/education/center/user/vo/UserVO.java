package com.education.center.user.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Carl
 * @ClassName UserVO
 * @Description
 * @date 2019-09-08 15:37
 **/
@Data
public class UserVO implements Serializable {


    private String openId;
    private String userName;
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
}
