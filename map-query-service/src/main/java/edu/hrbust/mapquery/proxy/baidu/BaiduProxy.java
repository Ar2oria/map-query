package edu.hrbust.mapquery.proxy.baidu;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.hrbust.common.dto.response.BaseResponseDTO;
import edu.hrbust.common.dto.response.SingleResponseDTO;
import edu.hrbust.mapquery.common.utils.PropertyUtils;
import edu.hrbust.mapquery.proxy.BaseProxy;
import edu.hrbust.mapquery.proxy.baidu.dto.*;

import java.util.List;

public class BaiduProxy {
    public static List<PlaceSearchResponseDTO> placeSearch(PlaceSearchRequestDTO placeSearchRequestDTO) {
        if (placeSearchRequestDTO.getQuery() == null) {
            throw new IllegalArgumentException("Query必须不能为空值！");
        }
        return BaseProxy.doGetWithAutoDeserilize(PropertyUtils.getMap().get("baiduMapPlaceSearch"), placeSearchRequestDTO, new TypeReference<BaseResponseDTO<List<PlaceSearchResponseDTO>>>() {});
    }

    public static List<SharpPSResponseDTO> rectanglePlaceSearch(PlaceSearchRequestDTO placeSearchRequestDTO) {
        if (placeSearchRequestDTO.getBounds() == null) {
            throw new IllegalArgumentException("Bounds必须不能为空值！");
        }
        return BaseProxy.doGetWithAutoDeserilize(PropertyUtils.getMap().get("baiduMapPlaceSearch"), placeSearchRequestDTO, new TypeReference<BaseResponseDTO<List<SharpPSResponseDTO>>>() {});
    }

    public static List<SharpPSResponseDTO> circlePlaceSearch(PlaceSearchRequestDTO placeSearchRequestDTO) {
        if (placeSearchRequestDTO.getLocation() == null) {
            throw new IllegalArgumentException("Location必须不能为空值！");
        }
        return BaseProxy.doGetWithAutoDeserilize(PropertyUtils.getMap().get("baiduMapPlaceSearch"), placeSearchRequestDTO, new TypeReference<BaseResponseDTO<List<SharpPSResponseDTO>>>() {});
    }

    public static LGeocoderResponseDTO lGeocoder(LGeocoderRequestDTO lGeocoderRequestDTO) {
        SingleResponseDTO<LGeocoderResponseDTO> obj = BaseProxy.doGetWithDeserilizeManual(PropertyUtils.getMap().get("baiduMapGeocoder"), lGeocoderRequestDTO, new TypeReference<SingleResponseDTO<LGeocoderResponseDTO>>() {
        });
        if (obj == null || obj.getResult() == null) {
            throw new IllegalStateException("LGeocoderResponseDTO函数====>解析异常！，请求参数" + lGeocoderRequestDTO.toString());
        }
        return obj.getResult();
    }

    public static RGeocoderResponseDTO rGeocoder(RGeocoderRequestDTO rGeocoderRequestDTO) {
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


}