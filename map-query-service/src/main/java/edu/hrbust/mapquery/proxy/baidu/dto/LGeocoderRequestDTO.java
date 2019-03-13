package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.hrbust.common.dto.request.BaseRequestDTO;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LGeocoderRequestDTO extends BaseRequestDTO {

    /**
     * 待解析的地址。最多支持84个字节。
     * 可以输入两种样式的值，分别是：
     * 1、标准的结构化地址信息，如北京市海淀区上地十街十号 【推荐，地址结构越完整，解析精度越高】
     * 2、支持“*路与*路交叉口”描述方式，如北一环路和阜阳路的交叉路口
     * 第二种方式并不总是有返回结果，只有当地址库中存在该地址描述时才有返回。
     *
     * 北京市海淀区上地十街10号
     */
    private String address;
    /**
     * 	地址所在的城市名。用于指定上述地址所在的城市，当多个城市都有上述地址时，该参数起到过滤作用，但不限制坐标召回城市。
     * 	北京市
     */
    private String city;
    /**
     * 可选参数，添加后返回国测局经纬度坐标或百度米制坐标 坐标系说明	string	gcj02ll（国测局坐标）、bd09mc（百度墨卡托坐标）	bd09ll（百度经纬度坐标）
     */
    private String ret_coordtype;
    private String output;

    @Override
    public String toString() {
        if (output == null) {
            throw new IllegalArgumentException("参数错误，请指定一种输出类型");
        }
        return super.toString();
    }
}
