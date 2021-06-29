package cn.com.dxk.springboot.shardingsphere.jdbc.service;

import cn.com.dxk.springboot.shardingsphere.jdbc.dao.ProvWorkOrderDao;
import cn.com.dxk.springboot.shardingsphere.jdbc.domain.ProvWorkOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Date: 2021/6/28 16:52
 * @Author: DingXingKai
 * @Description:
 */
@Slf4j
@Service
public class ProvWorkOrderService {
    @Autowired
    private ProvWorkOrderDao provWorkOrderDao;

    public int insertOne(ProvWorkOrder provWorkOrder) {
        int insert = provWorkOrderDao.insert(provWorkOrder);
        log.info("插入数据：{}, result: {}", provWorkOrder.toString(), insert);
        return insert;
    }

    public String selectProvWorkOrderByWorkOrderId(Long workOrderId) {
        Map<String,Object> param = new HashMap<>(1);
        param.put("work_order_id",workOrderId);
        List<ProvWorkOrder> provWorkOrder = provWorkOrderDao.selectByMap(param);
        log.info("根据workOrderId：{}，查询到信息为：{}", workOrderId, provWorkOrder.toString());
        return provWorkOrder.toString();
    }

}
