package com.gasq.cloud.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author tangmin
 * @version V1.0
 * @Title: KafkaConsumerTest.java
 * @Package com.gasq.cloud.message
 * @Description: 
 * @date 2017-04-18 16:32:03
 */
public class KafkaConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka01:9092,kafka02:9092,kafka03:9092");
        props.put("group.id", "GroupA");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        //从poll(拉)的回话处理时长
        props.put("session.timeout.ms", "30000");
        //poll的数量限制
        //props.put("max.poll.records", "100");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = null;
        try {
            consumer = new KafkaConsumer<>(props);
            consumer.subscribe(Arrays.asList("my-topic"));
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records){
                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                    Thread.sleep(1000);//模拟处理延时
                }
            }
        } finally {
            consumer.close();
        }
    }
}
