package RocketMQ.demo3;

import RocketMQ.TxTest.MqTranProducer;
import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by C.A.O on 2018/5/19.
 */
public class OiOrderManager extends AbstractTransactExecuter{

    @Autowired
    MqTranProducer mqTranProducer ;

    boolean doUpdateOrder(Object obj) {

        //1、组装消息数据
        String message = "";
        mqTranProducer.sendTMsg(message,this);
        mqTranProducer.sendTMsg(message,new LocalTransactionExecuter(){
            @Override
            public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {



                return null;
            }
        });
        //doLocalTranaction

        return true;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    boolean doLocalTranaction(Object obj) {
        return false;
    }
}
