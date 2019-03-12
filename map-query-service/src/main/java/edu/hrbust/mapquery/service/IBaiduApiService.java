package edu.hrbust.mapquery.service;

import edu.hrbust.mapquery.vo.PlaceSearchVO;

import java.util.List;

public interface IBaiduApiService {
    List<PlaceSearchVO> placeSearch(String query, String region);
}
