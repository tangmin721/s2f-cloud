package com.gasq.cloud.message;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * @author tangmin
 * @version V1.0
 * @Title: KafkaProducerTest.java
 * @Package com.gasq.cloud.message
 * @Description:
 * @date 2017-04-18 14:33:53
 */
public class KafkaProducerTest {
    public static final String topic = "test";

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka01:9092,kafka02:9092,kafka03:9092");
        props.put("acks", "all");//“所有”设置将导致记录的完整提交阻塞，最慢的，但最持久的设置。
        props.put("retries", 0);
        props.put("batch.size", 16384);//如果请求失败，生产者也会自动重试，即使设置成０
        props.put("linger.ms", 1);//延时毫秒数
        props.put("buffer.memory", 33554432);//生产者缓冲大小，当缓冲区耗尽后，额外的发送调用将被阻塞。时间超过max.block.ms将抛出TimeoutException
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            //生产者的主要方法
            // 1、close();//Close this producer.
            // 2、close(long timeout, TimeUnit timeUnit); //This method waits up to timeout for the producer to complete the sending of all incomplete requests.
            // 3、flush() ;所有缓存记录被立刻发送
            String key = "key:" + i;
            String value = "value:" + i;
            //这里平均写入3个分区 i%3
            producer.send(new ProducerRecord<String, String>("my-topic",i%2, key, value),
                    new Callback() {
                        public void onCompletion(RecordMetadata metadata, Exception e) {
                            if (e != null) {
                                e.printStackTrace();
                            } else {
                                System.out.println("The offset of the record we just sent is: " + metadata.offset()
                                        + ",metadata.topic:" + metadata.topic());
                            }
                        }
                    });
            System.out.println(key + "," + value);
        }
        producer.close();
    }

}
