package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressComponent {
    /**
     * 国家
     */
    private String country;
    /**
     * 省名
     */
    private String province;
    /**
     * 城市名
     */
    private String city;
    /**
     * 区县名
     */
    private String district;
    /**
     * 乡镇名
     */
    private String town;
    /**
     * 街道名（行政区划中的街道层级）
     */
    private String street;
    /**
     * 街道门牌号
     */
    private String street_number;
    /**
     * 行政区划代码 adcode映射表
     */
    private String adcode;
    /**
     * 国家代码
     */
    private Integer country_code;
    /**
     * 相对当前坐标点的方向，当有门牌号的时候返回数据
     */
    private String direction;
    /**
     * 相对当前坐标点的距离，当有门牌号的时候返回数据
     */
    private String distance;

    private Integer city_level;
    private String country_code_iso;
    private String country_code_iso2;
}