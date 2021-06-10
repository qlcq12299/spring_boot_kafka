package com.huifeng.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface IDealRecordConsumerAService {
     void consumer(ConsumerRecord<?,?> consumerRecord);
}
