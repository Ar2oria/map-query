package edu.hrbust.mapquery.proxy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Stopwatch;
import edu.hrbust.common.dto.request.BaseRequestDTO;
import edu.hrbust.common.dto.response.BaseResponseDTO;
import edu.hrbust.common.exception.BizException;
import edu.hrbust.common.utils.HttpRequestUtils;
import edu.hrbust.mapquery.common.utils.PropertyUtils;
import edu.hrbust.mapquery.common.utils.SnCalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Ex1st
 */
@Slf4j
@Component
public class BaseProxy {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String baseUrl = "baiduMapBaseUrl";

    public static String doGet(String url) throws UnsupportedEncodingException {
        return doGet(url, new BaseRequestDTO());
    }

    public static <T extends BaseRequestDTO> String doGet(String url, T obj) throws UnsupportedEncodingException {
        log.info("DoGet方法====>请求url={},请求参数={}", url, obj.toString());
        Stopwatch stopwatch = Stopwatch.createStarted();
        String paramStr = obj.toString() + "&ak=" + PropertyUtils.getMap().get("ak");
        String sn = SnCalUtils.GetSn(paramStr, url, PropertyUtils.getMap().get("sk"));
        paramStr = paramStr + "&" + "sn=" + sn;
        log.info("DoGet方法====>请求地址={},url={}", paramStr, url);
        String result = HttpRequestUtils.doGet(PropertyUtils.getMap().get(baseUrl) + url + "?" + paramStr);
        stopwatch.stop();
        log.info("DoGet方法====>耗时={}毫秒,请求地址={},返回结果={}", stopwatch.elapsed(TimeUnit.MICROSECONDS), paramStr, result);
        return result;
    }

    public static <T extends BaseRequestDTO, F > F doGetWithAutoDeserilize(String url, T dto, TypeReference type) {
        String response = null;
        try {
            response = doGet(url, dto);
        } catch (UnsupportedEncodingException e) {
            log.error("DoGetWithAutoDeserilize方法=====>网络请求异常，请检查网络，请求url={},请求参数={}", url, dto.toString());
            throw new IllegalStateException("网络请求异常，请检查网络！");
        }
        BaseResponseDTO<F> result;
        try {
            result = mapper.readValue(response, type);
        } catch (Exception exp) {
            log.error("mapper.readValue()=====>函数异常！,检测参数是否正确，异常信息e={}，请求url={},请求参数={}", exp.getMessage(), url, dto.toString());
            throw new IllegalStateException("mapper.readValue函数异常！");
        }
        if (result == null) {
            log.error("doGetWithAutoDeserilizea方法=====>解析json异常，检测参数是否正确，请求url={},请求参数={}", url, dto.toString());
            throw new IllegalStateException("解析json异常，检测参数是否正确！");
        }
        if (result.getStatus() != 0) {
            log.error("doGetWithAutoDeserilize方法=====>解析json异常，检测ak或sn是否正确，请求url={},请求参数={}", url, dto.toString());
            throw new IllegalStateException("网络请求状态异常，检测ak或sn是否正确！");
        }
        if (result.getResults() == null) {
            log.error("doGetWithAutoDeserilize方法=====>解析json异常，json为空，请求url={},请求参数={1}", url, dto.toString());
            throw new IllegalStateException("解析json异常，json为空！");
        }
        return result.getResults();
    }

    public static <T extends BaseRequestDTO, F> F doGetWithDeserilizeManual(String url, T obj, TypeReference<F> type) {
        String response = null;
        try {
            response = doGet(url, obj);
        } catch (UnsupportedEncodingException e) {
            log.error("doGetWithDeserilizeManual方法=====>网络请求异常，请检查网络，请求url={},请求参数={}", url, obj.toString());
            throw new IllegalStateException("网络请求异常，请检查网络！");
        }
        F result = null;
        try {
            result = mapper.readValue(response, type);
        } catch (Exception exp) {
            log.error("doGetWithDeserilizeManual方法=====>函数异常！,检测参数是否正确，异常信息e={}，请求url={},请求参数={}", exp.getMessage(), url, obj.toString());
            throw new IllegalStateException("JsonConvert.DeserializeObject函数异常！");
        }
        if (result == null) {
            log.error("doGetWithDeserilizeManual方法=====>解析json异常，检测参数是否正确，请求url={},请求参数={}", url, obj.toString());
            throw new IllegalStateException("解析json异常，检测参数是否正确！");
        }
        return result;
    }
}



