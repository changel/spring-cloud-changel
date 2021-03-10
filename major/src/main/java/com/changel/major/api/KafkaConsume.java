package com.changel.major.api;

import com.changel.major.dto.TestDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author Chang.Tong
 * @Date 2021/3/9 18:42
 * @Version 1.0
 */
@Component
@Slf4j
public class KafkaConsume {

    @KafkaListener(topics = "testTopic")
    public void testKafka(ConsumerRecord<?, ?> record) {
        log.info("主应用的kafka监听程序...");
        System.out.println("主应用的kafka监听程序："+record.topic()+" - "+record.partition()+" - "+record.value());
    }

    @KafkaListener(topics = "testTopic-entity")
    public void testKafkaEntity(ConsumerRecord<String, TestDTO> record) {
        log.info("major的kafka监听topic:testTopic-entity");
        System.out.println("major的testTopic-entity监听结果："+record.topic()+" - "+record.partition()+" - "+record.value());
    }
}
