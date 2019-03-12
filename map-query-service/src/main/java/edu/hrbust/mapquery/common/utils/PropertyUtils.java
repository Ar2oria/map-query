package edu.hrbust.mapquery.common.utils;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "request.baidu")
public class PropertyUtils {
    @Getter
    private static Map<String,String> map = Maps.newHashMapWithExpectedSize(10);

    private String ak;
    private String sk;
    private Map<String, String> host;

    @PostConstruct
    public void init(){
        map.put("ak",ak);
        map.put("sk",sk);
        map.putAll(host);
    }
}
