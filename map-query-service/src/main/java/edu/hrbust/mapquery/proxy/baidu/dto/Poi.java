package edu.hrbust.mapquery.proxy.baidu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Poi {

    private String addr;
    private String cp;
    private String direction;
    private String distance;
    private String name;
    private String tag;
    private Point point;
    private String poiType;
    private String tel;
    private String uid;
    private String zip;
    private Poi parent_poi;
}
