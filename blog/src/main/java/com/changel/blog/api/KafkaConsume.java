package com.changel.blog.api;

import com.changel.blog.dto.TestDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author Chang.Tong
 * @Date 2021/3/9 20:01
 * @Version 1.0
 */
@Component
@Slf4j
public class KafkaConsume {


    @KafkaListener(topics = "testTopic")
    public void testKafka(ConsumerRecord<?, ?> record) {
        log.info("blog的kafka监听topic:testTopic");
        System.out.println("blog的testTopic监听结果："+record.topic()+" - "+record.partition()+" - "+record.value());
    }

    @KafkaListener(topics = "testTopic-entity")
    public void testKafkaEntity(ConsumerRecord<String, TestDTO> record) {
        log.info("blog的kafka监听topic:testTopic-entity");
        System.out.println("blog的testTopic-entity监听结果："+record.topic()+" - "+record.partition()+" - "+record.value());
    }
}
