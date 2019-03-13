package edu.hrbust.mapquery.service.impl;

import edu.hrbust.common.enums.CoordTypeEnum;
import edu.hrbust.common.enums.GeoConvertEnum;
import edu.hrbust.mapquery.proxy.baidu.BaiduProxy;
import edu.hrbust.mapquery.proxy.baidu.dto.*;
import edu.hrbust.mapquery.service.IBaiduApiService;
import edu.hrbust.mapquery.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BaiduApiServiceImpl implements IBaiduApiService {
    @Override
    public List<PlaceSearchVO> placeSearch(String query, String region) {
        PlaceSearchRequestDTO placeSearchRequestDTO = new PlaceSearchRequestDTO();

        placeSearchRequestDTO.setQuery(query);
        placeSearchRequestDTO.setRegion(region);
        placeSearchRequestDTO.setRet_coordtype(CoordTypeEnum.gcj02ll.getType());
        placeSearchRequestDTO.setOutput("json");

        return BaiduProxy.placeSearch(placeSearchRequestDTO).stream().map(x -> {
            PlaceSearchVO placeSearchVO = new PlaceSearchVO();
            BeanUtils.copyProperties(x, placeSearchVO);
            return placeSearchVO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PlaceSearchVO> rectangleSearch(String query, String bounds, Integer coordType) {
        PlaceSearchRequestDTO placeSearchRequestDTO = new PlaceSearchRequestDTO();

        if (coordType == null) {
            placeSearchRequestDTO.setCoord_type(CoordTypeEnum.gcj02ll.getCode());
        } else {
            placeSearchRequestDTO.setCoord_type(coordType);
        }

        placeSearchRequestDTO.setQuery(query);
        placeSearchRequestDTO.setBounds(bounds);
        placeSearchRequestDTO.setRet_coordtype(CoordTypeEnum.gcj02ll.getType());
        placeSearchRequestDTO.setOutput("json");

        return BaiduProxy.rectanglePlaceSearch(placeSearchRequestDTO).stream().map(x -> {
            PlaceSearchVO placeSearchVO = new PlaceSearchVO();
            BeanUtils.copyProperties(x, placeSearchVO);
            return placeSearchVO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PlaceSearchVO> circleSearch(String query, String location, String radius, Integer coordType) {
        PlaceSearchRequestDTO placeSearchRequestDTO = new PlaceSearchRequestDTO();

        if (!StringUtils.isEmpty(radius)) {
            placeSearchRequestDTO.setRadius(radius);
        }

        if (coordType == null) {
            placeSearchRequestDTO.setCoord_type(CoordTypeEnum.gcj02ll.getCode());
        } else {
            placeSearchRequestDTO.setCoord_type(coordType);
        }

        placeSearchRequestDTO.setQuery(query);
        placeSearchRequestDTO.setLocation(location);
        placeSearchRequestDTO.setRet_coordtype(CoordTypeEnum.gcj02ll.getType());
        placeSearchRequestDTO.setOutput("json");

        return BaiduProxy.circlePlaceSearch(placeSearchRequestDTO).stream().map(x -> {
            PlaceSearchVO placeSearchVO = new PlaceSearchVO();
            BeanUtils.copyProperties(x, placeSearchVO);
            return placeSearchVO;
        }).collect(Collectors.toList());
    }

    @Override
    public IPConvertVO ipConvert(String ip, String coor) {
        IPConvertRequestDTO ipConvertRequestDTO = new IPConvertRequestDTO();
        if (!StringUtils.isEmpty(ip)) {
            ipConvertRequestDTO.setIp(ip);
        }
        if (!StringUtils.isEmpty(coor)) {
            ipConvertRequestDTO.setCoor(coor);
        } else {
            ipConvertRequestDTO.setCoor(CoordTypeEnum.gcj02.getType());
        }
        IPConvertResponseDTO ipConvertResponseDTO = BaiduProxy.ipConvert(ipConvertRequestDTO);
        IPConvertVO ipConvertVO = new IPConvertVO();
        BeanUtils.copyProperties(ipConvertResponseDTO, ipConvertVO);
        return ipConvertVO;
    }

    @Override
    public LGeoCoderVO lGeoCoder(String address, String city, String retCoordtype) {
        LGeocoderRequestDTO lGeocoderRequestDTO = new LGeocoderRequestDTO();

        if (!StringUtils.isEmpty(city)) {
            lGeocoderRequestDTO.setCity(city);
        }

        if (!StringUtils.isEmpty(retCoordtype)) {
            lGeocoderRequestDTO.setRet_coordtype(retCoordtype);
        } else {
            lGeocoderRequestDTO.setRet_coordtype(CoordTypeEnum.gcj02ll.getType());
        }

        lGeocoderRequestDTO.setAddress(address);
        lGeocoderRequestDTO.setOutput("json");

        LGeocoderResponseDTO lGeocoderResponseDTO = BaiduProxy.lGeocoder(lGeocoderRequestDTO);
        LGeoCoderVO lGeoCoderVO = new LGeoCoderVO();
        BeanUtils.copyProperties(lGeocoderResponseDTO, lGeoCoderVO);
        return lGeoCoderVO;
    }

    @Override
    public RGeoCoderVO rGeoCoder(RGeoCoderRequestVO rGeoCoderRequestVO) {
        RGeocoderRequestDTO rGeocoderRequestDTO = new RGeocoderRequestDTO();
        BeanUtils.copyProperties(rGeoCoderRequestVO, rGeocoderRequestDTO);

        if (StringUtils.isEmpty(rGeocoderRequestDTO.getCoordtype())) {
            rGeocoderRequestDTO.setCoordtype(CoordTypeEnum.gcj02ll.getType());
        }

        if (StringUtils.isEmpty(rGeocoderRequestDTO.getRet_coordtype())) {
            rGeocoderRequestDTO.setRet_coordtype(CoordTypeEnum.gcj02ll.getType());
        }

        if (StringUtils.isEmpty(rGeocoderRequestDTO.getOutput())) {
            rGeocoderRequestDTO.setOutput("json");
        }

        RGeocoderResponseDTO rGeocoderResponseDTO = BaiduProxy.rGeocoder(rGeocoderRequestDTO);
        RGeoCoderVO rGeoCoderVO = new RGeoCoderVO();
        BeanUtils.copyProperties(rGeocoderResponseDTO, rGeoCoderVO);
        return rGeoCoderVO;
    }

    @Override
    public List<GeoConvertVO> geoConvert(String coords, Integer from, Integer to) {
        GeoConvertRequestDTO geoConvertRequestDTO = new GeoConvertRequestDTO();

        if (from != null) {
            geoConvertRequestDTO.setFrom(from);
        } else {
            geoConvertRequestDTO.setFrom(GeoConvertEnum.bd09ll.getCode());
        }

        if (to != null) {
            geoConvertRequestDTO.setTo(to);
        } else {
            geoConvertRequestDTO.setTo(GeoConvertEnum.gcj02ll.getCode());
        }

        geoConvertRequestDTO.setCoords(coords);
        geoConvertRequestDTO.setOutput("json");

        return BaiduProxy.geoConvert(geoConvertRequestDTO).stream().map(x -> {
            GeoConvertVO geoConvertVO = new GeoConvertVO();
            BeanUtils.copyProperties(x, geoConvertVO);
            return geoConvertVO;
        }).collect(Collectors.toList());
    }


}
