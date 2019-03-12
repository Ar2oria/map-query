package edu.hrbust.mapquery.controller;

import edu.hrbust.common.ResultResponse;
import edu.hrbust.mapquery.service.IBaiduApiService;
import edu.hrbust.mapquery.vo.PlaceSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/baidu")
public class BaiduApiController {

    @Autowired
    private IBaiduApiService baiduApiService;

    @GetMapping("/placeSearch")
    public ResultResponse<List<PlaceSearchVO>> placeSearch(String query, String region){
        return ResultResponse.success(baiduApiService.placeSearch(query, region));
    }
}
