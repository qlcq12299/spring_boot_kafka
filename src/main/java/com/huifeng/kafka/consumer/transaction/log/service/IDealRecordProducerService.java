package com.huifeng.kafka.consumer.transaction.log.service;

import java.io.IOException;

public interface IDealRecordProducerService {
    void sendLog() throws IOException;
}
