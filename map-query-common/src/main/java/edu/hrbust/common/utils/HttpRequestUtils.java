package edu.hrbust.common.utils;

import com.squareup.okhttp.*;

import java.io.IOException;


public class HttpRequestUtils {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType FORM = MediaType.parse("application/x-www-form-urlencoded");
    private static OkHttpClient okHttpClient = new OkHttpClient();

    public static String doGet(String url) {
        Request request = new Request.Builder().url(url).build();
        String responseStr = null;
        try {
            Response response = okHttpClient.newCall(request).execute();
            responseStr = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    public static String doPostWithForm(String url, String postBody){
        RequestBody body = RequestBody.create(FORM, postBody);
        return doPostWithRequestBody(url, body);
    }

    public static String doPostWithJson(String url, String postBody){
        RequestBody body = RequestBody.create(JSON, postBody);
        return doPostWithRequestBody(url, body);
    }

    private static String doPostWithRequestBody(String url, RequestBody body){
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        String responseStr = null;
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response!=null && response.isSuccessful()) {
                responseStr = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseStr;
    }

}
