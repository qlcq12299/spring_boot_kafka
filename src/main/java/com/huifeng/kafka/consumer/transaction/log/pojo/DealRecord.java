package com.huifeng.kafka.consumer.transaction.log.pojo;

import lombok.Data;

/**
 * 交易记录
 * @author xiaotc
 * @version V1.0.0
 * @date 2021/6/9 18:48
 */

@Data
public class DealRecord {

    private String traderference;

    private String accountNumber;

    private String stockCode;

    private String quantity;

    private String currency;

    private String price;

    private String broker;

    private String amount;

    private String receivedTimestamp;
}
