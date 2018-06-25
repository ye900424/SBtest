package RocketMQ.demo4;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by C.A.O on 2018/5/19.
 */
public class OiOrderManager extends AbstractTransactExecuter {

//    @Autowired
//    MqTranProducer mqTranProducer ;

    boolean doUpdateOrder(Object obj) {

        //1、组装消息数据
        String message = "";
//        mqTranProducer.sendTMsg(message,this);
//        mqTranProducer.sendTMsg(message,new LocalTransactionExecuter(){
//            @Override
//            public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
//
//
//
//                return null;
//            }
//        });
        //doLocalTranaction

        return true;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    boolean doLocalTranaction(Object obj) {
        return false;
    }
}
