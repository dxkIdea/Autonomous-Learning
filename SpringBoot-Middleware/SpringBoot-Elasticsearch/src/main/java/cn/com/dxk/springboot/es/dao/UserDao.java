package cn.com.dxk.springboot.es.dao;

import cn.com.dxk.springboot.es.bean.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author DingXingKai
 * @version 1.0
 * @date 2021/04/10 01:42:09
 */
@Repository
public interface UserDao extends ElasticsearchRepository<User, String> {
}
