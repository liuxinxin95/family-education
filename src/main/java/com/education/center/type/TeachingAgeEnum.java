package com.education.center.type;

/**
 * @author Carl
 * @ClassName TeachingAgeEnum
 * @Description
 * @date 2019-10-02 07:48
 **/
public enum TeachingAgeEnum {

    /**
     *
     */
    LESS_FIVE("LESS_FIVE","五年以下"),
    FIVE_TO_TEN("FIVE_TO_TEN","五到十年"),
    MORE_THAN("MORE_THAN","十年以上"),
    ;


    private String code;

    private String name;

    TeachingAgeEnum(String code, String name) {
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
