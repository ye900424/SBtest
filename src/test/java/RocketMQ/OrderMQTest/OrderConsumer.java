package RocketMQ.OrderMQTest;

/**
 * Created by caoyang on 2017/7/7.
 */

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class OrderConsumer {
    public static void main(String[] args) {
        DefaultMQPushConsumer consumer =
                new DefaultMQPushConsumer("OrderConsumer");
//        consumer.setNamesrvAddr("39.105.17.168:9876");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        try {
            //订阅PushTopic下Tag为push的消息
//            consumer.subscribe("PushTopic", "push");
            consumer.subscribe("OrderTopic", "TagA||TagB||TagC||TagD||TagE");

            //程序第一次启动从消息队列头取数据
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.registerMessageListener(
                    new MessageListenerOrderly() {
                        AtomicLong consumeTimes = new AtomicLong(0);

                        @Override
                        public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                            context.setAutoCommit(false);
//                            System.out.println(Thread.currentThread().getName() + " Receive New Messages: " + msgs);
                            this.consumeTimes.incrementAndGet();
//                            if ((this.consumeTimes.get() % 2) == 0) {
//                                return ConsumeOrderlyStatus.SUCCESS;
//                            } else if ((this.consumeTimes.get() % 3) == 0) {
//                                return ConsumeOrderlyStatus.ROLLBACK;
//                            } else if ((this.consumeTimes.get() % 4) == 0) {
//                                return ConsumeOrderlyStatus.COMMIT;
//                            } else if ((this.consumeTimes.get() % 5) == 0) {
//                                context.setSuspendCurrentQueueTimeMillis(3000);
//                                return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
//                            }
                            Message msg = msgs.get(0);

                            System.out.println( new String(msg.getBody()));

                            return ConsumeOrderlyStatus.SUCCESS;
                        }
                    }


//                    new MessageListenerConcurrently() {
//                        public ConsumeConcurrentlyStatus consumeMessage(
//                                List<MessageExt> list,
//                                ConsumeConcurrentlyContext Context) {
//                            Message msg = list.get(0);
//                            System.out.println( new String(msg.getBody()));
//                            try{
//                                System.out.println("laocao——"+msg.toString());
//                                if("999".equals(msg.getKeys())){
//                                    Person person = (Person) JSONObject.parse(new String(msg.getBody()));
//                                    System.out.println(person.getName());
//                                }
//                            }catch(Exception e){
//                                System.out.println(e.getMessage());
//                            }
//
//                            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                        }
//                    }
            );
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
