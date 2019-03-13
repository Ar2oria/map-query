package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceSearchResponseDTO {
    private String name;
    private Location location;
    private String address;
    private String province;
    private String city;
    private String area;
    private String street_id;
    private Integer detail;
    private String uid;

}

