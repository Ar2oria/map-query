package edu.hrbust.mapquery.controller;

import edu.hrbust.common.ResultResponse;
import edu.hrbust.mapquery.service.IBaiduApiService;
import edu.hrbust.mapquery.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/baidu")
public class BaiduApiController {

    @Autowired
    private IBaiduApiService baiduApiService;

    @GetMapping("/placeSearch")
    public ResultResponse<List<PlaceSearchVO>> placeSearch(String query, String region) {
        return ResultResponse.success(baiduApiService.placeSearch(query, region));
    }

    @GetMapping("/rectangleSearch")
    public ResultResponse<List<PlaceSearchVO>> rectangleSearch(
            String query, String bounds,
            @RequestParam(required = false) Integer coordType) {
        return ResultResponse.success(baiduApiService.rectangleSearch(query, bounds, coordType));
    }

    @GetMapping("/circleSearch")
    public ResultResponse<List<PlaceSearchVO>> circleSearch(
            String query, String location,
            @RequestParam(required = false) String radius,
            @RequestParam(required = false) Integer coordType) {
        return ResultResponse.success(baiduApiService.circleSearch(query, location, radius, coordType));
    }

    @GetMapping("/ip")
    public ResultResponse<IPConvertVO> ipConvert(
            @RequestParam(required = false) String ip,
            @RequestParam(required = false) String coor) {
        return ResultResponse.success(baiduApiService.ipConvert(ip, coor));
    }

    @GetMapping("/lGeoCoder")
    public ResultResponse<LGeoCoderVO> lGeoCoder(
            String address,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String retCoordtype) {
        return ResultResponse.success(baiduApiService.lGeoCoder(address, city, retCoordtype));
    }

    @GetMapping("/rGeoCoder")
    public ResultResponse<RGeoCoderVO> rGeoCoder(RGeoCoderRequestVO rGeoCoderRequestVO) {
        return ResultResponse.success(baiduApiService.rGeoCoder(rGeoCoderRequestVO));
    }

    @GetMapping("/geoConvert")
    public ResultResponse<List<GeoConvertVO>> geoConvert(
            String coords,
            @RequestParam(required = false) Integer from,
            @RequestParam(required = false) Integer to){
        return ResultResponse.success(baiduApiService.geoConvert(coords, from, to));
    }
}
