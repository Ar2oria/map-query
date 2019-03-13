package edu.hrbust.mapquery.proxy;


import com.fasterxml.jackson.core.type.TypeReference;
import edu.hrbust.AppRun;
import edu.hrbust.mapquery.common.utils.PropertyUtils;
import edu.hrbust.mapquery.proxy.baidu.dto.GeoConvertRequestDTO;
import edu.hrbust.mapquery.proxy.baidu.dto.PlaceSearchRequestDTO;
import edu.hrbust.mapquery.proxy.baidu.dto.PlaceSearchResponseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;
import java.util.List;

@SpringBootTest(classes = AppRun.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseProxyTest {
    @Test
    public void doGet() throws UnsupportedEncodingException {
        String baiduMapIPConvert = BaseProxy.doGet(PropertyUtils.getMap().get("baiduMapIPConvert"));
        System.out.println(baiduMapIPConvert);
    }

    @Test
    public void doGet1() {
    }

    @Test
    public void doGetWithAutoDeserilize() throws Exception {
        PlaceSearchRequestDTO placeSearchRequestDTO = new PlaceSearchRequestDTO();
        placeSearchRequestDTO.setQuery("atm机");
        placeSearchRequestDTO.setRegion("北京");
        placeSearchRequestDTO.setOutput("json");
        List<PlaceSearchResponseDTO> baiduMapPlaceSearch = BaseProxy.doGetWithAutoDeserilize(PropertyUtils.getMap().get("baiduMapPlaceSearch"), placeSearchRequestDTO, new TypeReference<List<PlaceSearchResponseDTO>>() {
        });
        System.out.println(baiduMapPlaceSearch);
    }

    @Test
    public void doGet2() throws UnsupportedEncodingException {
        GeoConvertRequestDTO geoConvertRequestDTO = new GeoConvertRequestDTO();
        geoConvertRequestDTO.setOutput("json");
        geoConvertRequestDTO.setCoords("126.626564,45.721832");
        geoConvertRequestDTO.setFrom(5);
        geoConvertRequestDTO.setTo(3);
        String baiduMapGeoConvert = BaseProxy.doGet(PropertyUtils.getMap().get("baiduMapGeoConvert"), geoConvertRequestDTO);
        System.out.println(baiduMapGeoConvert);
    }
}
