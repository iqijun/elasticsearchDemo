package com.fullstacker.elasticsearch.base.pojo;

/**
 * @program: elasticsearch
 * @description: 地址
 * @author: xingguishuai
 * @create: 2019-01-22 15:00
 */
public class Address {
    /**
     * 国家
     */
    private String country;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private  String city;
    /**
     * 详细地址
     */
    private  String detail;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
