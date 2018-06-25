package RocketMQ.demo1;

/**
 * Created by caoyang on 2017/7/7.
 */

import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import model.Person;

import java.util.List;

public class Producer {
    public static void main(String[] args){
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
//        producer.setNamesrvAddr("39.105.17.168:9876");
        producer.setNamesrvAddr("127.0.0.1:9876");
        try {
            producer.start();

            Message msg = new Message("PushTopic1",
                    "push",
                    "1",
                    "Just for test.".getBytes());


            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer id = (Integer) arg;
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            }, 1234);

            SendResult result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());

            msg = new Message("PushTopic2",
                    "push",
                    "2",
                    "11111.".getBytes());

            result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());

            Person person = new Person(1l,"私发");
            String personStr = JSONObject.toJSONString(person);
            msg = new Message("PushTopic",
                    "push",
                    "999",
                    personStr.getBytes());

            result = producer.send(msg);


            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());

            msg = new Message("PullTopic",
                    "pull",
                    "1",
                    "Just for test.".getBytes());

            result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());



        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            producer.shutdown();
        }
    }
}
