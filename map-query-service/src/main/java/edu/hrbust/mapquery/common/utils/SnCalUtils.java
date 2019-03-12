package edu.hrbust.mapquery.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

/**
 * java版计算signature签名
 */
public class SnCalUtils {
    public static String GetSn(String paramsStr, String requestUrl, String sk) throws UnsupportedEncodingException {
        String wholeStr = requestUrl + "?" + paramsStr + sk;
        String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
        return MD5(tempStr);
    }
    public static String GetSn(Map paramsMap, String requestUrl, String sk) throws UnsupportedEncodingException {
        String paramsStr = toQueryString(paramsMap);
        return GetSn(paramsStr, requestUrl, sk);
    }

    // 对Map内所有value作utf8编码，拼接返回结果
    public static String toQueryString(Map<?, ?> data)
            throws UnsupportedEncodingException {
        StringBuilder queryString = new StringBuilder();
        for (Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey() + "=");
            queryString.append(URLEncoder.encode((String) pair.getValue(),
                    "UTF-8") + "&");
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    // 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}