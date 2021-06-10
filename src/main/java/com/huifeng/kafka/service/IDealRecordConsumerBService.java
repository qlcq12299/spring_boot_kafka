package com.huifeng.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface IDealRecordConsumerBService {
     void consumer(ConsumerRecord<?,?> consumerRecord);
}
