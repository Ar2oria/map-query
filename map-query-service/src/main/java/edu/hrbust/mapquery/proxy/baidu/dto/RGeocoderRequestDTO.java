package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.hrbust.common.dto.request.BaseRequestDTO;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RGeocoderRequestDTO extends BaseRequestDTO {

    private String location;
    /**
     * 坐标的类型，目前支持的坐标类型包括：bd09ll（百度经纬度坐标）、bd09mc（百度米制坐标）、gcj02ll（国测局经纬度坐标，仅限中国）、wgs84ll（ GPS经纬度） 坐标系说明	string	bd09ll、gcj02ll	bd09ll
     */
    private String coordtype;
    /**
     * 可选参数，添加后返回国测局经纬度坐标或百度米制坐标 坐标系说明	string	gcj02ll（国测局坐标，仅限中国）、bd09mc（百度墨卡托坐标）	bd09ll（百度经纬度坐标）
     */
    private String ret_coordtype;
    /**
     * 是否召回传入坐标周边的poi，0为不召回，1为召回。当值为1时，默认显示周边1000米内的poi。
     */
    private Integer pois;
    private Integer radius;
    private String output;


    @Override
    public String toString() {
        if (output == null) {
            throw new IllegalArgumentException("参数错误，请指定一种输出类型");
        }
        return super.toString();
    }
}

