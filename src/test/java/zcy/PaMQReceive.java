package zcy;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by caoyang on 2017/8/24.
 * 接受业务模块申请信息
 */
@Data
public class PaMQReceive implements Serializable{

    private static final long serialVersionUID = -8497503326918532360L;
    /**
     * 本次只执行mq事件id，各业务自行定义，callback时原封返回
     */
    private Long eventId;

    /**
     * 审批类型
     */
    private String approveType;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 关联的业务id
     */
    private String businessId;

    /**
     * 申请事项
     */
    private String applyTitle;

    /**
     * 申请原因
     */
    private String applyReason;

    /**
     * 申请人id
     */
    private Long applyUserId;

    /**
     * 申请方单位id
     */
    private Long applyOrgId;

    /**
     * 申请方单位名称
     */
    private String applyOrdName;

    /**
     * 回复人
     */
    private Long replyUserId;

    /**
     * 回复人单位id
     */
    private Long replyOrgId;

    /**
     * 回复人单位
     */
    private String replyOrgName;

    /**
     * 审批前的源状态
     */
    private Integer sourceState;

    /**
     * 审批后的目标状态
     */
    private Integer targetState;

    /**
     * 申请方区划code
     */
    private String applyDistrictCode;

    /**
     * 回复方区划code
     */
    private String replyDistrictCode;

    /**
     * 附件(可能有多个)
     */
    private List attachments;
}
