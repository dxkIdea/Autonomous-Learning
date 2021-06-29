package cn.com.dxk.springboot.shardingsphere.jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Date: 2021/6/22 18:03
 * @Author: DingXingKai
 * @Description:
 */
@EnableSwagger2
@MapperScan(basePackages = "cn.com.dxk.springboot.shardingsphere.jdbc.dao")
@SpringBootApplication
public class ShardingJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class,args);
    }
}
