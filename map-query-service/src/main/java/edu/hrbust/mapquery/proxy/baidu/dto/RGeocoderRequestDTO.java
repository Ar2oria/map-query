package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.hrbust.common.dto.request.BaseRequestDTO;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RGeocoderRequestDTO extends BaseRequestDTO {

    private String location;
    private String coordtype;
    private String ret_coordtype;
    /**
     * 是否召回传入坐标周边的poi，0为不召回，1为召回。当值为1时，默认显示周边1000米内的poi。
     */
    private Integer pois = 0;
    private Integer radius = 1000;
    private String output;


    @Override
    public String toString() {
        if (output == null) {
            throw new IllegalArgumentException("参数错误，请指定一种输出类型");
        }
        if (location == null) {
            throw new IllegalArgumentException("参数错误，location必须不能为空值！");
        }
        return super.toString();
    }
}

