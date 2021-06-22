package cn.com.dxk.springboot.shardingsphere.jdbc.service;

import cn.com.dxk.springboot.shardingsphere.jdbc.dao.UserDao;
import cn.com.dxk.springboot.shardingsphere.jdbc.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date: 2021/6/22 18:45
 * @Author: DingXingKai
 * @Description:
 */
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int insertUser(User user) {
        int insert = userDao.inserOneUser(user);
        log.info("插入数据：{}， 状态值：{}", user.toString(),insert);
        return insert;
    }
}
