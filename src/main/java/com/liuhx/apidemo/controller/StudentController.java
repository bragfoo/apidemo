package com.liuhx.apidemo.controller;

import com.liuhx.apidemo.model.query.Student;
import com.liuhx.apidemo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program apidemo
 * @description:
 * @author: liuhx
 * @create: 2018/12/03 22:23
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Resource
    StudentService studentService;

    @PostMapping("save")
    public Student save(Student student){
        return studentService.save(student);
    }
}
