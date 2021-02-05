package com.liuhx.apidemo.dao.es;

import com.liuhx.apidemo.model.query.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @program apidemo
 * @description:
 * @author: liuhx
 * @create: 2018/12/03 22:19
 */
public interface StudentRepository extends ElasticsearchRepository<Student,String> {
}
