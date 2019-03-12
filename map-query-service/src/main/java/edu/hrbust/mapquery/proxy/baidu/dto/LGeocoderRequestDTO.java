package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.hrbust.common.dto.request.BaseRequestDTO;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LGeocoderRequestDTO extends BaseRequestDTO {

    private String address;
    private String city;
    private String ret_coordtype;
    private String output;

    @Override
    public String toString() {
        if (output == null) {
            throw new IllegalArgumentException("参数错误，请指定一种输出类型");
        }
        if (address == null) {
            throw new IllegalArgumentException("地址信息不能为空！");
        }
        return super.toString();
    }
}
