import cn.com.dxk.springboot.es.EsApplication;
import cn.com.dxk.springboot.es.bean.User;
import cn.com.dxk.springboot.es.service.UserOperationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

/**
 * 描述:
 *
 * @author DingXingKai
 * @version 1.0
 * @date 2021/04/10 01:05:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApplication.class)
public class Testing {
    @Autowired
    private UserOperationService userOperationService;

    /**
     * 测试新增用户功能
     */
    @Test
    public void addUser() {
        User user = User.builder().name("测试").age(18).build();
        userOperationService.addUser(user);
    }

}
