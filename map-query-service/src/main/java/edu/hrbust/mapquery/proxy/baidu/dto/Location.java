package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Location {
    private double lat;
    private double lng;

}
