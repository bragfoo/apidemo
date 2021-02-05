package com.liuhx.apidemo.model.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @program apidemo
 * @description:
 * @author: liuhx
 * @create: 2018/12/03 22:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "school",type = "class")
public class Student {
    @Id
    private String id;
    private String studentName;
}
