package com.huifeng.kafka.service.impl;

import com.huifeng.kafka.service.IDealRecordConsumerAService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author xiaotc
 * @version V1.0.0
 * @date 2021/6/10 10:50
 */

@Service
@Slf4j
public class DealRecordConsumerAServiceImpl implements IDealRecordConsumerAService {

    @KafkaListener(topics ="user-record1")

    @Override
    public void consumer(ConsumerRecord<?, ?> consumerRecord) {
        //判断是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            System.err.println("消费消息1:"+message);
        }
    }
}
