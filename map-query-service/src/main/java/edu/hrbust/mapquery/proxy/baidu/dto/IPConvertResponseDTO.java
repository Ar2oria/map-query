package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class IPConvertResponseDTO {
    private String address;
    private Integer status;
    private Content content;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Content{
        private String address;
        private CPoint point;
        private AddressDetail address_detail;


    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class CPoint{
        private String x;
        private String y;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class AddressDetail {
        private String city;
        private Integer city_code;
        private String district;
        private String province;
        private String street;
        private String street_number;
    }
}



