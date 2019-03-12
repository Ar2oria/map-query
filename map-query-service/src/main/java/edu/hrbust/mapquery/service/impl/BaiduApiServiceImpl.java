package edu.hrbust.mapquery.service.impl;

import edu.hrbust.mapquery.proxy.baidu.BaiduProxy;
import edu.hrbust.mapquery.proxy.baidu.dto.PlaceSearchRequestDTO;
import edu.hrbust.mapquery.service.IBaiduApiService;
import edu.hrbust.mapquery.vo.PlaceSearchVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaiduApiServiceImpl implements IBaiduApiService {
    @Override
    public List<PlaceSearchVO> placeSearch(String query, String region) {
        PlaceSearchRequestDTO placeSearchRequestDTO = new PlaceSearchRequestDTO();
        placeSearchRequestDTO.setQuery(query);
        placeSearchRequestDTO.setRegion(region);
        placeSearchRequestDTO.setOutput("json");
        return BaiduProxy.placeSearch(placeSearchRequestDTO).stream().map(x -> {
            PlaceSearchVO placeSearchVO = new PlaceSearchVO();
            BeanUtils.copyProperties(x,placeSearchVO);
            return placeSearchVO;
        }).collect(Collectors.toList());
    }
}
