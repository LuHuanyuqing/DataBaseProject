package com.lqh.system.controller;

import com.lqh.common.vo.Result;
import com.lqh.system.entity.Student;
import com.lqh.system.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

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
    public Result<List<Student>> getAllStudent(){
        List<Student> list = studentService.list();
        return Result.success(list, "查询成功");
    }


    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody Student student){
        Map<String, Object> data = studentService.login(student);
        if (data != null){
            return  Result.success(data);
        }
        return  Result.fail(20002, "用户名或密码错误");
    }

    @GetMapping("/info")
    public Result<Map<String, Object>> getStudentInfo(@RequestParam("token") String token){
        //根据token获取用户信息,redis
        Map<String, Object> data = studentService.geStudentInfo(token);
        if (data != null){
            return  Result.success(data);
        }
        return  Result.fail(20003, "登录信息无效，请重新登录");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token){
        studentService.logout(token);

        return Result.success();
    }

}
