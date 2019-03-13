package edu.hrbust.mapquery.service;

import edu.hrbust.mapquery.vo.*;

import java.util.List;

public interface IBaiduApiService {
    List<PlaceSearchVO> placeSearch(String query, String region);
    List<PlaceSearchVO> rectangleSearch(String query, String bounds, Integer coordType);
    List<PlaceSearchVO> circleSearch(String query, String location, String radius, Integer coordType);
    IPConvertVO ipConvert(String ip, String coor);
    LGeoCoderVO lGeoCoder(String address, String city, String retCoordtype);
    RGeoCoderVO rGeoCoder(RGeoCoderRequestVO rGeoCoderRequestVO);
    List<GeoConvertVO> geoConvert(String coords, Integer from, Integer to);
}
