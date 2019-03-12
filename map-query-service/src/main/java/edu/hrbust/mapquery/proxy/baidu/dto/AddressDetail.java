package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDetail {
    private String city;
    private Integer city_code;
    private String district;
    private String province;
    private String street;
    private String street_number;
}