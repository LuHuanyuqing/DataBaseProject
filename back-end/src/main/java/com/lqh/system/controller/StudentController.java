package com.lqh.system.controller;

import com.lqh.system.entity.Student;
import com.lqh.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luqiheng
 * @since 2023-06-23
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudent(){
        List<Student> list = studentService.list();
        return list;
    }
}
