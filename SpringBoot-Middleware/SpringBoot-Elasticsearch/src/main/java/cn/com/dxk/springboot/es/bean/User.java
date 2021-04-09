package cn.com.dxk.springboot.es.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * 描述: 用户实体类
 *
 * @author DingXingKai
 * @version 1.0
 * @date 2021/04/10 00:54:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "USER_INDEX")
public class User implements Serializable {
    /**
     * 姓名
     */
    @Id
    private String name;

    /**
     * 年龄
     */
    private Integer age;
}
