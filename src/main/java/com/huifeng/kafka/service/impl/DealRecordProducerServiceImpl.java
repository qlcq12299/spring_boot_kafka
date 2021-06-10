package com.huifeng.kafka.service.impl;

import com.alibaba.fastjson.JSON;
import com.huifeng.kafka.pojo.DealRecord;
import com.huifeng.kafka.service.IDealRecordProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.*;


/**
 * @author xiaotc
 * @version V1.0.0
 * @date 2021/6/10 9:57
 */

@Service
public class DealRecordProducerServiceImpl implements IDealRecordProducerService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void sendLog() throws IOException {
        InputStreamReader ins = null;
        DealRecord dealRecord = null;
        StringBuffer sf = null;
        try {
            //创建文件,使用本地磁盘路径
            File file = new File("D:\\test.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            ins = new InputStreamReader(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(ins);

        //读取txt
        String line = null;
        sf = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sf.append(line);
        }
        br.close();

        String json = JSON.toJSONString(sf);

        kafkaTemplate.send("user-record1", JSON.toJSONString(sf));

        kafkaTemplate.send("user-record2", JSON.toJSONString(sf));

        //创建新文件,使用本地磁盘路径
        File txtToJson = new File("D:\\test1.txt");
        txtToJson.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(txtToJson));
        out.write(json);
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件/*
    }
}
