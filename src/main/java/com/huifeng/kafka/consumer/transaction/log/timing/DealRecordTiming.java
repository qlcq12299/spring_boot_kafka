package com.huifeng.kafka.consumer.transaction.log.timing;

import com.huifeng.kafka.consumer.transaction.log.service.IDealRecordProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * @author xiaotuchi
 * 定时任务
 * Date: 2021/4/15 10:35 <br/>
 * @version 1.0.0
 * @since JDK 1.8
 */

@Component
public class DealRecordTiming {

    @Autowired
    private IDealRecordProducerService dealRecordProducerService;

    /**
     * 生产者每5分钟发送Kafka数据
     *
     * @param
     */
    @Scheduled(cron = "${jobs.schedule.taskA}")
    public void dealReCordAScheduled() throws IOException {
        dealRecordProducerService.sendLog();
    }

    /**
     * 生产者每1分钟发送Kafka数据
     *
     * @param
     */
    @Scheduled(cron = "${jobs.schedule.taskB}")
    public void dealReCordBScheduled() throws IOException {
        dealRecordProducerService.sendLog();
    }

}
