package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.hrbust.common.dto.request.BaseRequestDTO;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IPConvertRequestDTO extends BaseRequestDTO {
    private String ip;
    private String coor;
}

