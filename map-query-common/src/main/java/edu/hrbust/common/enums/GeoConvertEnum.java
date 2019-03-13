package edu.hrbust.common.enums;

import lombok.Getter;

@Getter
public enum GeoConvertEnum {
    /**
     * 1：GPS设备获取的角度坐标，WGS84坐标;
     * 2：GPS获取的米制坐标、sogou地图所用坐标;
     * 3：google地图、soso地图、aliyun地图、mapabc地图和amap地图所用坐标，国测局（GCJ02）坐标;
     * 4：3中列表地图坐标对应的米制坐标;
     * 5：百度地图采用的经纬度坐标;
     * 6：百度地图采用的米制坐标;
     * 7：mapbar地图坐标;
     * 8：51地图坐标
     */

    wgs84(1,"1：GPS设备获取的角度坐标，WGS84坐标"),
    sogou(2,"GPS获取的米制坐标、sogou地图所用坐标"),
    gcj02ll(3,"google地图、soso地图、aliyun地图、mapabc地图和amap地图所用坐标，国测局（GCJ02）坐标"),
    gcj02mc(4,"3中列表地图坐标对应的米制坐标"),
    bd09ll(5,"百度地图采用的经纬度坐标"),
    bd09mc(6,"bd09mc"),
    mapbar(7,"mapbar地图坐标"),
    map51(8,"51地图坐标");


    GeoConvertEnum(Integer code, String describe){
        this.code = code;
        this.describe = describe;
    }

    private Integer code;
    private String describe;
}
