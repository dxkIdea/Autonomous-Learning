package cn.com.dxk.springboot.es.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
@Document(indexName = "user",createIndex = true)
public class User implements Serializable {
    /**
     * 姓名
     */
    @Id
    @Field(type = FieldType.Text)
    private String name;

    /**
     * 年龄
     */
    private Integer age;
}
