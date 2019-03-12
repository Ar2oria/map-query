package edu.hrbust.mapquery.proxy.baidu.dto;

import java.util.List;

public class RGeocoderResponseDTO {

    /**
     * （注意，国外行政区划，字段仅代表层级）
     */
    private AddressComponent addressComponent;
    /**
     * 经纬度坐标
     */
    private Location location;
    /**
     * 坐标所在商圈信息，如 "人民大学,中关村,苏州街"。最多返回3个。
     */
    private String  business;
    /**
     * 百度定义的城市id
     */
    private Integer cityCode;
    /**
     * 结构化地址信息
     */
    private String formatted_address;

    private String sematic_description;

    private List<Poi> pois;

    private List<PoiRegion> poiRegions;
}






