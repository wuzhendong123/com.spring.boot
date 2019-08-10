package com.spring.boot.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-20 17:02
 **/
public class JSONUtil {
    static ObjectMapper mapper = new ObjectMapper();
    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

    }

    public  static String writeValueAsString(Object obj) throws JsonProcessingException {
      return  mapper.writeValueAsString(obj);
    }
    public  static <T> T readValue(String  json, Class<T> var) throws IOException {
        return   mapper.readValue(json,var);

    }
}
