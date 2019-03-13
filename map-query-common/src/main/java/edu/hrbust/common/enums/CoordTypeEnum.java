package edu.hrbust.common.enums;

import lombok.Getter;

/**
 * 1（wgs84ll即GPS经纬度），2（gcj02ll即国测局经纬度坐标），3（bd09ll即百度经纬度坐标），4（bd09mc即百度米制坐标）
 */
@Getter
public enum CoordTypeEnum {
    wgs84("wgs84",1),
    wgs84ll("wgs84ll",1),
    gcj02("gcj02",2),
    gcj02ll("gcj02ll",2),
    bd09("bd09",3),
    bd09ll("bd09ll",3),
    bd09mc("bd09mc",4);

    CoordTypeEnum(String type,Integer code){
        this.type = type;
        this.code = code;
    }
    private String type;
    private Integer code;

}
