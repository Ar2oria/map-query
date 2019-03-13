package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.hrbust.common.dto.request.BaseRequestDTO;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoConvertRequestDTO extends BaseRequestDTO {
    private String coords;
    /**
     * 源坐标类型：
     * 1：GPS设备获取的角度坐标，WGS84坐标;
     * 2：GPS获取的米制坐标、sogou地图所用坐标;
     * 3：google地图、soso地图、aliyun地图、mapabc地图和amap地图所用坐标，国测局（GCJ02）坐标;
     * 4：3中列表地图坐标对应的米制坐标;
     * 5：百度地图采用的经纬度坐标;
     * 6：百度地图采用的米制坐标;
     * 7：mapbar地图坐标;
     * 8：51地图坐标
     */
    private Integer from;
    /**
     * 目标坐标类型：
     * 3：国测局（GCJ02）坐标;
     * 4：3中对应的米制坐标;
     * 5：bd09ll(百度经纬度坐标);
     * 6：bd09mc(百度米制经纬度坐标)
     */
    private Integer to;
    private String output;

    @Override
    public String toString() {
        if (StringUtils.isEmpty(output)){
            throw new IllegalArgumentException("输出类型异常！");
        }
        return super.toString();
    }
}
