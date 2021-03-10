package com.changel.blog.common.kafka.serialization;

import com.changel.blog.utils.BeanUtils;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @Author Chang.Tong
 * @Date 2021/3/9 19:35
 * @Version 1.0
 */
public class StreamSerializer implements Serializer<Object> {

    @Override
    public byte[] serialize(String s, Object o) {
        return BeanUtils.bean2Byte(o);
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Headers headers, Object data) {
        return BeanUtils.bean2Byte(data);
    }

    @Override
    public void close() {

    }
}
