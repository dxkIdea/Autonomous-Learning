package cn.com.dxk.springboot.es.service;

import cn.com.dxk.springboot.es.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 描述: 用户操作接口
 *
 * @author DingXingKai
 * @version 1.0
 * @date 2021/04/10 00:57:39
 */
public interface UserOperationService {
    /**
     * 添加用户
     * @param user 用户
     */
    void addUser(User user);
}
