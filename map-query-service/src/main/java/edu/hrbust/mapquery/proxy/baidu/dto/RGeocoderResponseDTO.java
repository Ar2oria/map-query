package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RGeocoderResponseDTO {
    /**
     * location : {"lng":126.64155369834256,"lat":45.71782808682565}
     * formatted_address : 黑龙江省哈尔滨市香坊区哈平六道街15号
     * business : 安乐,哈平路,哈西
     * addressComponent : {"country":"中国","country_code":0,"country_code_iso":"CHN","country_code_iso2":"CN","province":"黑龙江省","city":"哈尔滨市","city_level":2,"district":"香坊区","town":"","adcode":"230110","street":"哈平六道街","street_number":"15号","direction":"东北","distance":"64"}
     * pois : []
     * roads : []
     * poiRegions : [{"direction_desc":"内","name":"林大小区","tag":"房地产;住宅区","uid":"6ab10fd298dba4b6fea77848"}]
     * sematic_description : 林大小区内,书香园双拼饭南93米
     * cityCode : 48
     */

    private LocationBean location;
    private String formatted_address;
    private String business;
    private AddressComponentBean addressComponent;
    private String sematic_description;
    private int cityCode;
    private List<?> pois;
    private List<?> roads;
    private List<PoiRegionsBean> poiRegions;

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LocationBean {
        /**
         * lng : 126.64155369834256
         * lat : 45.71782808682565
         */

        private double lng;
        private double lat;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AddressComponentBean {
        /**
         * country : 中国
         * country_code : 0
         * country_code_iso : CHN
         * country_code_iso2 : CN
         * province : 黑龙江省
         * city : 哈尔滨市
         * city_level : 2
         * district : 香坊区
         * town :
         * adcode : 230110
         * street : 哈平六道街
         * street_number : 15号
         * direction : 东北
         * distance : 64
         */

        private String country;
        private int country_code;
        private String country_code_iso;
        private String country_code_iso2;
        private String province;
        private String city;
        private int city_level;
        private String district;
        private String town;
        private String adcode;
        private String street;
        private String street_number;
        private String direction;
        private String distance;
    }

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PoiRegionsBean {
        /**
         * direction_desc : 内
         * name : 林大小区
         * tag : 房地产;住宅区
         * uid : 6ab10fd298dba4b6fea77848
         */

        private String direction_desc;
        private String name;
        private String tag;
        private String uid;
    }
}
