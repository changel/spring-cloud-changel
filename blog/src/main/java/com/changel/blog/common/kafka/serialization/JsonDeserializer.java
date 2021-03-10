package com.changel.blog.common.kafka.serialization;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * @Author Chang.Tong
 * @Date 2021/3/10 9:21
 * @Version 1.0
 */
public class JsonDeserializer implements Deserializer<Object> {

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return JSON.parse(bytes);
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, Headers headers, byte[] data) {
        return JSON.parse(data);
    }

    @Override
    public void close() {

    }
}
