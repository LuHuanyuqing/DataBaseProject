package com.lqh;

import com.lqh.system.entity.Student;
import com.lqh.system.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class BackEndApplicationTests {

    @Resource
    private StudentMapper studentMapper;

    @Test
    void testMapper() {
        List<Student> students = studentMapper.selectList(null);
        students.forEach(System.out::println);
    }

}