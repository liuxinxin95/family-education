package com.education.api.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Data
@ApiModel
public class UserInvitationRecordVO {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户
     */
    private Integer userId;

    /**
     * 我的邀请人id
     */
    private Integer invitationId;

    /**
     * 我的邀请人名称
     */
    private Integer invitationName;

    /**
     * 收入标准1积分 2金钱
     */
    private Integer type;

    /**
     * 积分
     */
    private Long point;

    /**
     * 现金
     */
    private Long amount;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}