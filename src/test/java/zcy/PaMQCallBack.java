package zcy;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by caoyang on 2017/8/24.
 * 给业务模块回传信息
 */
@Data
public class PaMQCallBack implements Serializable {

    private static final long serialVersionUID = -2596186999232852834L;

    /**
     * 本次只执行mq事件id，各业务自行定义，callback时原封返回
     */
    private Long eventId;

    /**
     * 关联的业务id
     */
    private String businessId;

    /**
     * 审批前的源状态
     */
    private Integer sourceState;

    /**
     * 审批后的目标状态
     */
    private Integer targetState;

    /**
     * 是否受理 "Y"-成功，"N"-失败
     */
    private String receiveSuccess;



    /**
     * 是否审批通过 "Y"-通过，"N"-不通过
     */
    private String approvePass;

    /**
     * 审批人id
     */
    private Long approveUserId;

    /**
     * 审批人名称
     */
    private Long approveUserName;

    /**
     * 审批理由
     */
    private String approveReason;
}
