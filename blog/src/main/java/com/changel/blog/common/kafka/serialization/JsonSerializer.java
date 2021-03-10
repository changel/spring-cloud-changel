package com.changel.blog.common.kafka.serialization;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @Author Chang.Tong
 * @Date 2021/3/10 9:28
 * @Version 1.0
 */
public class JsonSerializer implements Serializer<Object> {

    @Override
    public byte[] serialize(String s, Object o) {
        return JSON.toJSONBytes(o);
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Headers headers, Object data) {
        return JSON.toJSONBytes(data);
    }

    @Override
    public void close() {

    }
}
