package cn.com.dxk.springboot.shardingsphere.jdbc.dao;

import cn.com.dxk.springboot.shardingsphere.jdbc.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Date: 2021/6/22 18:43
 * @Author: DingXingKai
 * @Description:
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
