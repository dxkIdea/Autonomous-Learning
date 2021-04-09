package cn.com.dxk.springboot.es.service.impl;

import cn.com.dxk.springboot.es.bean.User;
import cn.com.dxk.springboot.es.dao.UserDao;
import cn.com.dxk.springboot.es.service.UserOperationService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

/**
 * 描述:
 *
 * @author DingXingKai
 * @version 1.0
 * @date 2021/04/10 00:58:54
 */
@Service
@Slf4j
public class UserOperationServiceImpl implements UserOperationService {
    private static final String USER_INDEX = "USER_V1";
    @Autowired
    private UserDao userDao;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 增加用户
     * @param user 用户
     */
    @Override
    public void addUser(User user) {
        /*IndexResponse response = null;
        try {
            IndexRequest indexRequest = new IndexRequest(USER_INDEX).id(UUID.randomUUID().toString()).source(JSON.toJSONString(user), XContentType.JSON);
            response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("添加用户异常，{}",e.getMessage());
            e.printStackTrace();
        }
        log.info("addPlayer {}", JSONObject.toJSON(response));*/
        userDao.save(user);
    }
}
