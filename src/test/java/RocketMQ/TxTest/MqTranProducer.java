package RocketMQ.TxTest;

import RocketMQ.demo3.TransactionCheckListenerImpl;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.TransactionCheckListener;
import com.alibaba.rocketmq.client.producer.TransactionMQProducer;
import com.alibaba.rocketmq.common.message.Message;
import com.google.gson.Gson;

import javax.annotation.PostConstruct;

/**
 * Created by C.A.O on 2018/5/17.
 */
public class MqTranProducer {
    public static void main(String[] args) {
        TransactionCheckListener transactionCheckListener = new TransactionCheckListenerImpl();


        TransactionMQProducer producer = new TransactionMQProducer("groupName");

    }

    private TransactionMQProducer producer;
    private String TAG = "TAG_LAOCAO";
    private String TOPIC = "TOPIC_LAOCAO";

    /**
     * 事务消息Producer初始化
     */
    @PostConstruct
    public void initTransactionProducer(){
        TransactionCheckListener transactionCheckListener = new TransactionCheckListenerImpl();
        this.producer = new TransactionMQProducer("laocao");
        // 事务回查最小并发数
        producer.setCheckThreadPoolMinSize(2);
        // 事务回查最大并发数
        producer.setCheckThreadPoolMaxSize(2);
        // 队列数
        producer.setCheckRequestHoldMax(2000);
        producer.setTransactionCheckListener(transactionCheckListener);
//        producer.setNamesrvAddr("39.105.17.168:9876");
        producer.setNamesrvAddr("127.0.0.1:9876");
        try {
            producer.start();
        } catch (MQClientException e) {
            System.out.printf("MQ-Producer初始化失败");
            e.printStackTrace();
        }
    }

    /**
     * 发送事务消息
     * @param messageObj
     * @param tranExecuter
     */
    public void sendTMsg(Object messageObj, LocalTransactionExecuter tranExecuter){
        String body = null;
        if (messageObj instanceof String) {
            body = (String) messageObj;
        } else {
            Gson gson = new Gson();
            body = gson.toJson(messageObj);
        }
        Message msg = new Message(TOPIC, TAG, "KEY" , body.getBytes());
        SendResult sendResult = null;
        try {
            sendResult = producer.sendMessageInTransaction(msg, tranExecuter, null);
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        System.out.println(sendResult);
    }
}
