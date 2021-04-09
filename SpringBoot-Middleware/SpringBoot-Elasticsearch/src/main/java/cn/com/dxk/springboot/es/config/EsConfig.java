package cn.com.dxk.springboot.es.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import java.time.Duration;

/**
 * 描述:
 *
 * @author DingXingKai
 * @version 1.0
 * @date 2021/04/10 00:45:54
 */
@Data
@Configuration
public class EsConfig extends AbstractElasticsearchConfiguration {
    /**
     * IP地址
     */
    @Value("${spring.elasticsearch.rest.uris}")
    private String uris;

    /**
     * 用户名
     */
    @Value("${spring.elasticsearch.rest.username}")
    private String userName;

    /**
     * 密码
     */
    @Value("${spring.elasticsearch.rest.password}")
    private String passWord;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(uris)
                .withConnectTimeout(Duration.ofSeconds(5))
                .withSocketTimeout(Duration.ofSeconds(3))
                .withBasicAuth(userName,passWord)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
