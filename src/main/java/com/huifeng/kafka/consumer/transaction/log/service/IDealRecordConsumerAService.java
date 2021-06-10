package com.huifeng.kafka.consumer.transaction.log.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface IDealRecordConsumerAService {
     void consumer(ConsumerRecord<?,?> consumerRecord);
}
