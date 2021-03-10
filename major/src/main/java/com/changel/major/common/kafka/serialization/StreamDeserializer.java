package com.changel.major.common.kafka.serialization;

import com.changel.major.utils.BeanUtils;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * @Author Chang.Tong
 * @Date 2021/3/9 19:30
 * @Version 1.0
 */
public class StreamDeserializer implements Deserializer<Object> {

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return BeanUtils.byte2Obj(bytes);
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, Headers headers, byte[] data) {
        return BeanUtils.byte2Obj(data);
    }

    @Override
    public void close() {

    }
}
