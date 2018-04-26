package RocketMQ.demo3;

/**
 * Created by C.A.O on 2018/4/21.
 */

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;
import com.alibaba.rocketmq.common.message.Message;

/**
 * 发送事务消息例子
 *
 */
public class TransactionProducer {
    public static void main(String[] args) throws MQClientException, InterruptedException {

        TransactionCheckListener transactionCheckListener = new TransactionCheckListenerImpl();
        TransactionMQProducer producer = new TransactionMQProducer("laocao");
        // 事务回查最小并发数
        producer.setCheckThreadPoolMinSize(2);
        // 事务回查最大并发数
        producer.setCheckThreadPoolMaxSize(2);
        // 队列数
        producer.setCheckRequestHoldMax(2000);
        producer.setTransactionCheckListener(transactionCheckListener);
        producer.setNamesrvAddr("39.105.17.168:9876");
        producer.start();

        String[] tags = new String[] { "TagA", "TagB", "TagC", "TagD", "TagE" };
        TransactionExecuterImpl tranExecuter = new TransactionExecuterImpl();
        for (int i = 0; i < 1; i++) {
            try {
                Message msg =
                        new Message("TopicTest", tags[i % tags.length], "KEY" + i,
                                ("Hello RocketMQ " + i).getBytes());
                SendResult sendResult = producer.sendMessageInTransaction(msg, tranExecuter, null);
                System.out.println(sendResult);

                Thread.sleep(10);
            }
            catch (MQClientException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 100000; i++) {
            Thread.sleep(1000);
        }

        producer.shutdown();

    }
}
