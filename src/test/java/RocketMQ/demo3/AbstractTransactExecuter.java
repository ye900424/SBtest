package RocketMQ.demo3;

import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;
import com.alibaba.rocketmq.client.producer.LocalTransactionState;
import com.alibaba.rocketmq.common.message.Message;

/**
 * 本地事务执行器-模版
 * Created by C.A.O on 2018/5/19.
 */
public abstract class AbstractTransactExecuter implements LocalTransactionExecuter{
    @Override
    public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
        if(doLocalTranaction(null)){
            return LocalTransactionState.COMMIT_MESSAGE;
        }else{
            return LocalTransactionState.ROLLBACK_MESSAGE;

        }
    }

    /**
     * 需要执行的事务操作
     * @param obj
     * @return
     */
    abstract boolean doLocalTranaction(Object obj);
}
