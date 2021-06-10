package com.huifeng.kafka.service.impl;

import com.alibaba.fastjson.JSON;
import com.huifeng.kafka.service.IDealRecordConsumerAService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public void consumer(ConsumerRecord<?, ?> consumerRecord) throws IOException {
        //判断是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        if(kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            //创建新文件,使用本地磁盘路径
            File txtToJson = new File("D:\\test1.txt");
            txtToJson.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(txtToJson));
            out.write((String) message);
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件/*
            System.err.println("消费消息1:"+message);
        }
    }
}
