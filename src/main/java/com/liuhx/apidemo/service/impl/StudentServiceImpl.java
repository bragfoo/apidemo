package com.liuhx.apidemo.service.impl;

import com.liuhx.apidemo.dao.es.StudentRepository;
import com.liuhx.apidemo.model.query.Student;
import com.liuhx.apidemo.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program apidemo
 * @description:
 * @author: liuhx
 * @create: 2018/12/03 22:35
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentRepository studentRepository;
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
