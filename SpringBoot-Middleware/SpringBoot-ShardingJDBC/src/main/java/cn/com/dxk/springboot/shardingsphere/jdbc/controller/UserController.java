package cn.com.dxk.springboot.shardingsphere.jdbc.controller;

import cn.com.dxk.springboot.shardingsphere.jdbc.domain.User;
import cn.com.dxk.springboot.shardingsphere.jdbc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/6/22 18:48
 * @Author: DingXingKai
 * @Description:
 */
@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 新增用户
     */
    @RequestMapping(value = "insertOne")
    public void insertOneUser() {
        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .id(Long.valueOf(i))
                    .userName("user:" + i)
                    .passWord(String.valueOf(i))
                    .build();
            userService.insertUser(user);
        }
    }

    /**
     * 通过ID查询user
     * @param id
     * @return
     */
    @RequestMapping(value = "selectUserById/{id}")
    public String selectUserById(@PathVariable(value = "id") Long id) {
        return userService.selectUserById(id);
    }

    /**
     * 删除所有数据
     * @return
     */
    @RequestMapping(value = "delete")
    public int deleteAllUser() {
        int i = userService.deleteAllData();
        return i;
    }
}
