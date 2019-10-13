package com.education.center.need.enums;

/**
 * @author Carl
 * @ClassName TeachingModeEnum
 * @Description 枚举类
 * @date 2019-10-02 07:05
 **/
public enum TeachingModeEnum {
    /**
     *
     */
    THEDOOR_STUDENTS("THEDOOR_STUDENTS","学生上门"),
    THEDOOR_TEACHER("THEDOOR_TEACHER","老师上门"),
    WILL("WILL","均可"),
    ;
    private String code;

    private String name;

    TeachingModeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
