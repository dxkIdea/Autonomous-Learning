package cn.com.dxk.springboot.shardingsphere.jdbc.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @Date: 2021/6/22 18:44
 * @Author: DingXingKai
 * @Description:
 */
@Data
@Builder
@ToString
public class User {
    private Long id;

    private String userName;

    private String passWord;
}
