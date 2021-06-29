package cn.com.dxk.springboot.shardingsphere.jdbc.domain;

import lombok.*;

/**
 * @Date: 2021/6/28 16:45
 * @Author: DingXingKai
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
//@TableName(autoResultMap = true)
public class ProvWorkOrder {
    //@TableId(value = "WORK_ORDER_ID",type = IdType.INPUT)
    private Long workOrderId;

    private Integer status;

    private String createTime;

    private String taskId;

    private String platformInterface;

    private String origDomain;

    private String homeDomain;

    private Integer transType;

    private String updateSource;

    private String workOrderKey;

    private String province;

    private String completeTime;

    private String remarks;

    private String productOrdernumber;

    private String transIdo;

    private String crmMsgFilename;

    private Integer businessLevelNum;
}
