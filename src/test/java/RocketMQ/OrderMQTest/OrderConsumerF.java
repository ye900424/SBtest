package RocketMQ.OrderMQTest;

/**
 * Created by caoyang on 2017/7/7.
 */
import com.alibaba.fastjson.JSONObject;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.model.Person;

import java.util.List;

public class OrderConsumerF {
    public static void main(String[] args){
        DefaultMQPushConsumer consumer =
                new DefaultMQPushConsumer("OrderConsumerF");
//        consumer.setNamesrvAddr("39.105.17.168:9876");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        try {
            //订阅PushTopic下Tag为push的消息
//            consumer.subscribe("PushTopic", "push");
            consumer.subscribe("OrderTopic", "TagA||TagB||TagC");

            //程序第一次启动从消息队列头取数据
            consumer.setConsumeFromWhere(
                    ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.registerMessageListener(
                    new MessageListenerConcurrently() {
                        public ConsumeConcurrentlyStatus consumeMessage(
                                List<MessageExt> list,
                                ConsumeConcurrentlyContext Context) {
                            Message msg = list.get(0);
                            System.out.println( new String(msg.getBody()));
                            try{
                                System.out.println("laocao——"+msg.toString());
                                if("999".equals(msg.getKeys())){
                                    Person person = (Person) JSONObject.parse(new String(msg.getBody()));
                                    System.out.println(person.getName());
                                }
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }

                            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                        }
                    }
            );
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
