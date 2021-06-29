package cn.com.dxk.springboot.shardingsphere.jdbc.controller;

import cn.com.dxk.springboot.shardingsphere.jdbc.domain.ProvWorkOrder;
import cn.com.dxk.springboot.shardingsphere.jdbc.service.ProvWorkOrderService;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Date: 2021/6/28 16:54
 * @Author: DingXingKai
 * @Description:
 */
@Slf4j
@RestController
public class ProvWorkOrderController {
    @Autowired
    private ProvWorkOrderService provWorkOrderService;

    @Transactional(rollbackFor = Exception.class)
    @RequestMapping(value = "insertOneProvWorkOrder")
    public void insertOne() {
        ProvWorkOrder provWorkOrder;
        for (int i = 0; i < 10; i++) {
            provWorkOrder = ProvWorkOrder.builder()
                    .workOrderId(Long.valueOf(this.getOrderNo()))
                    .status(1)
                    .createTime(DateUtil.formatDateTime(new Date()))
                    .taskId("task_id")
                    .platformInterface("interface" + i)
                    .origDomain("bboss")
                    .homeDomain("bboss")
                    .transType(i)
                    .updateSource("1")
                    .workOrderKey(this.getOrderNo())
                    .province("100")
                    .completeTime(DateUtil.formatDateTime(new Date()))
                    .remarks("remarks")
                    .productOrdernumber("productOrderNumber")
                    .transIdo("transIdo")
                    .crmMsgFilename("fileName")
                    .businessLevelNum(1)
                    .build();
            int result = provWorkOrderService.insertOne(provWorkOrder);
            log.info("当前索引：{}, 插入数据result:{}", i, result);
        }
    }

    @RequestMapping(value = "selectOneByWorkOrderId/{workOrderId}")
    public String selectProvWorkOrderByWorkOrderId(@PathVariable(name = "workOrderId") Long workOrderId) {
        return provWorkOrderService.selectProvWorkOrderByWorkOrderId(workOrderId);
    }

    //生成19随机单号 纯数字
    public  String getOrderNo(){
        String orderNo = "" ;
        String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
        String sdf = new SimpleDateFormat("yyyyMMddHHMMSS").format(new Date());
        orderNo = trandNo.substring(0, 4);
        orderNo = orderNo + sdf ;
        return orderNo ;
    }

}
