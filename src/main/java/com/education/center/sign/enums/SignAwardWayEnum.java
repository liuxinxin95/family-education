
package com.education.center.sign.enums;


public enum SignAwardWayEnum {

    WALLET(1, "钱包"),
    POINT(2, "积分");

    private int code;

    private String desc;

    SignAwardWayEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
