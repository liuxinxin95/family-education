package com.education.center.main.entity;

import javax.persistence.*;

@Table(name = "sys_city")
public class SysCityDO {
    @Id
    private Integer id;

    private Integer citycode;

    private String city;

    private String initial;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return citycode
     */
    public Integer getCitycode() {
        return citycode;
    }

    /**
     * @param citycode
     */
    public void setCitycode(Integer citycode) {
        this.citycode = citycode;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return initial
     */
    public String getInitial() {
        return initial;
    }

    /**
     * @param initial
     */
    public void setInitial(String initial) {
        this.initial = initial == null ? null : initial.trim();
    }
}