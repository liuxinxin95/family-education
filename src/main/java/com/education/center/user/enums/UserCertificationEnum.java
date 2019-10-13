package com.education.center.user.enums;

/**
 * @author Carl
 * @ClassName UserCredentialsEnum
 * @Description
 * @date 2019-10-09 00:13
 **/
public enum UserCertificationEnum {
    /**
     * 认证状态
     */
    UNVERIFIED(0,"未认证"),
    UNDER_REVIEW(1,"审核中"),
    AUTHENTICATION_FAILURE(2,"认证失败"),
    APPROVE_TEACHER(3,"认证成功"),
    APPROVE_ORGANIZATION(4,"认证成功"),
    ;

    private Integer type;

    private String name;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    UserCertificationEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String valueType(Integer type) {
        String name = "";
        for (UserCertificationEnum userVerifiedEnum : UserCertificationEnum.values()) {
            if (userVerifiedEnum.type.equals(type)) {
                name = userVerifiedEnum.name;
            }
        }
        return name;
    }
}
