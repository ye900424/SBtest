package RocketMQ.demo1;

/**
 * Created by caoyang on 2017/7/7.
 */
import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import model.Person;

public class Producer {
    public static void main(String[] args){
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
//        producer.setNamesrvAddr("121.42.253.157:9876");
        producer.setNamesrvAddr("10.100.1.143:9876");
        try {
            producer.start();

            Message msg = new Message("PushTopic",
                    "push",
                    "1",
                    "Just for test.".getBytes());

            SendResult result = producer.send(msg);
            System.out.println("id:" + result.getMsgId() +
                    " result:" + result.getSendStatus());

            msg = new Message("PushTopic",
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
