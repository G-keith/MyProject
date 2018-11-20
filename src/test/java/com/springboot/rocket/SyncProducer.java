package com.springboot.rocket;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 应用：可靠的同步传输用于广泛的场景，如重要的通知消息，短信通知，短信营销系统等。
 * @author keith
 * @date 2018-07-18
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //用生产者组名称实例化。
        DefaultMQProducer producer = new
                DefaultMQProducer("please_rename_unique_group_name");
        //在本地搭建好broker后,记得指定nameServer的地址
        producer.setInstanceName("producer");
        producer.setNamesrvAddr("127.0.0.1:9876");
        //启动实例
        producer.start();
        for (int i = 1; i < 4; i++) {
            //创建消息实例，指定主题、标签和消息正文。
            Message msg = new Message("TopicTest" /* 主题 */,
                    "TagA" /* 标签 */,
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* 消息正文 */
            );
            //Call send message to deliver message to one of brokers.
            System.out.println(msg);
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
