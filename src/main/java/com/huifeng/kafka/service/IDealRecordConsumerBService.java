package com.huifeng.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;

public interface IDealRecordConsumerBService {
     void consumer(ConsumerRecord<?,?> consumerRecord) throws IOException;
}
