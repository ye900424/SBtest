package RocketMQ.demo3;

import RocketMQ.TxTest.MqTranProducer;
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

        //doLocalTranaction

        return true;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    boolean doLocalTranaction(Object obj) {
        // 处理本地事务
        try{


            return true;
        }catch(Exception e){

            return false;
        }

    }
}
