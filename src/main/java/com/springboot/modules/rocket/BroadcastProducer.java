package com.springboot.modules.rocket;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

/**
 * @author keith
 * @date 2018-07-19
 */
public class BroadcastProducer {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
        producer.setInstanceName("producer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
// 自定义一个tag数组
        String[] tags = new String[]{"TagA" ,"TagC", "TagD"};
        for (int i = 0; i < 9; i++){
            int orderId = i % 10;
            Message msg = new Message("TopicTest",
                    tags[i % tags.length], "KEY" + i,
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            System.out.println(msg.getTags());
            SendResult sendResult = producer.send(msg);

        }
        producer.shutdown();
    }
}
