package RocketMQ.OrderMQTest;

import RocketMQ.BaseProfucer;
import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.MessageQueueSelector;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageQueue;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * Created by C.A.O on 2018/6/3.
 * rocketMq发送顺序消息
 */
public class OrderProducer extends BaseProfucer{

    public static void main(String[] args) {
        OrderProducer orderProducer = new OrderProducer();

        String[] tags = new String[] { "TagA", "TagB", "TagC", "TagD", "TagE", "TagF" };

        try {
            for (int i = 0; i < 50; i++) {
                int orderId = i % 6;
                try {
                    Message msg = new Message("OrderTopic", tags[i % tags.length], "KEY" + i,
                                    ("orderId" + orderId+":" + "Hello RocketMQ " + i).getBytes());
                    SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                        @Override
                        public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                            Integer id = (Integer)arg;
                            int index = id % mqs.size();
                            return mqs.get(index);
                        }
                    }, orderId);
                    System.out.println(sendResult);

                    Thread.sleep(100);
                }
                catch (MQClientException e) {
                    e.printStackTrace();
                }
            }
            producer.shutdown();
        }  catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
