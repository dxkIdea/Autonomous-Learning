package cn.com.dxk.springboot.shardingsphere.jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Date: 2021/6/22 18:03
 * @Author: DingXingKai
 * @Description:
 */
@MapperScan(basePackages = "cn.com.dxk.springboot.shardingsphere.jdbc.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ShardingJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class,args);
    }
}
