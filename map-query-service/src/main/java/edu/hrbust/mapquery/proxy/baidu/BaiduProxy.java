package edu.hrbust.mapquery.proxy.baidu;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.hrbust.common.dto.response.BaseResponseDTO;
import edu.hrbust.common.dto.response.SingleResponseDTO;
import edu.hrbust.mapquery.common.utils.PropertyUtils;
import edu.hrbust.mapquery.proxy.BaseProxy;
import edu.hrbust.mapquery.proxy.baidu.dto.*;
import org.springframework.util.StringUtils;

import java.util.List;

public class BaiduProxy {
    public static List<PlaceSearchResponseDTO> placeSearch(PlaceSearchRequestDTO placeSearchRequestDTO) {
        if (StringUtils.isEmpty(placeSearchRequestDTO.getQuery())) {
            throw new IllegalArgumentException("Query必须不能为空值！");
        }
        return BaseProxy.doGetWithAutoDeserilize(PropertyUtils.getMap().get("baiduMapPlaceSearch"), placeSearchRequestDTO, new TypeReference<BaseResponseDTO<List<PlaceSearchResponseDTO>>>() {});
    }

    public static List<SharpPSResponseDTO> rectanglePlaceSearch(PlaceSearchRequestDTO placeSearchRequestDTO) {
        if (StringUtils.isEmpty(placeSearchRequestDTO.getBounds())) {
            throw new IllegalArgumentException("Bounds必须不能为空值！");
        }
        return BaseProxy.doGetWithAutoDeserilize(PropertyUtils.getMap().get("baiduMapPlaceSearch"), placeSearchRequestDTO, new TypeReference<BaseResponseDTO<List<SharpPSResponseDTO>>>() {});
    }

    public static List<SharpPSResponseDTO> circlePlaceSearch(PlaceSearchRequestDTO placeSearchRequestDTO) {
        if (StringUtils.isEmpty(placeSearchRequestDTO.getLocation())) {
            throw new IllegalArgumentException("Location必须不能为空值！");
        }
        return BaseProxy.doGetWithAutoDeserilize(PropertyUtils.getMap().get("baiduMapPlaceSearch"), placeSearchRequestDTO, new TypeReference<BaseResponseDTO<List<SharpPSResponseDTO>>>() {});
    }

    public static LGeocoderResponseDTO lGeocoder(LGeocoderRequestDTO lGeocoderRequestDTO) {
        if (StringUtils.isEmpty(lGeocoderRequestDTO.getAddress())) {
            throw new IllegalArgumentException("地址信息不能为空！");
        }
        SingleResponseDTO<LGeocoderResponseDTO> obj = BaseProxy.doGetWithDeserilizeManual(PropertyUtils.getMap().get("baiduMapGeocoder"), lGeocoderRequestDTO, new TypeReference<SingleResponseDTO<LGeocoderResponseDTO>>() {
        });
        if (obj == null || obj.getResult() == null) {
            throw new IllegalStateException("LGeocoderResponseDTO函数====>解析异常！，请求参数" + lGeocoderRequestDTO.toString());
        }
        return obj.getResult();
    }

    public static RGeocoderResponseDTO rGeocoder(RGeocoderRequestDTO rGeocoderRequestDTO) {
        if (StringUtils.isEmpty(rGeocoderRequestDTO.getLocation())) {
            throw new IllegalArgumentException("参数错误，location必须不能为空值！");
        }
        SingleResponseDTO<RGeocoderResponseDTO> obj = BaseProxy.doGetWithDeserilizeManual(PropertyUtils.getMap().get("baiduMapGeocoder"), rGeocoderRequestDTO, new TypeReference<SingleResponseDTO<RGeocoderResponseDTO>>() {
        });
        if (obj == null || obj.getResult() == null) {
            throw new IllegalStateException("RGeocoderResponseDTO函数====>解析异常！，请求参数" + rGeocoderRequestDTO.toString());
        }
        return obj.getResult();
    }

    public static IPConvertResponseDTO ipConvert(IPConvertRequestDTO iPConvertRequestDTO) {
        IPConvertResponseDTO obj = BaseProxy.doGetWithDeserilizeManual(PropertyUtils.getMap().get("baiduMapIPConvert"), iPConvertRequestDTO, new TypeReference<IPConvertResponseDTO>() {
        });
        if (obj == null) {
            throw new IllegalStateException("IPConvertResponseDTO函数异常====>解析异常！，请求参数" + iPConvertRequestDTO.toString());
        }
        return obj;
    }

    public static List<GeoConvertResponseDTO> geoConvert(GeoConvertRequestDTO geoConvertRequestDTO){
        if (StringUtils.isEmpty(geoConvertRequestDTO.getCoords())){
            throw new IllegalArgumentException("参数错误，coords必须不能为空值！");
        }
        SingleResponseDTO<List<GeoConvertResponseDTO>> baiduMapGeoConvert = BaseProxy.doGetWithDeserilizeManual(PropertyUtils.getMap().get("baiduMapGeoConvert"), geoConvertRequestDTO, new TypeReference<SingleResponseDTO<List<GeoConvertResponseDTO>>>() {
        });
        if (baiduMapGeoConvert == null){
            throw new IllegalStateException("geoConvert====>解析异常！，请求参数" + baiduMapGeoConvert.toString());
        }
        return baiduMapGeoConvert.getResult();
    }


}