package com.lqh.system.service;

import com.lqh.system.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author luqiheng
 * @since 2023-06-23
 */
public interface IStudentService extends IService<Student> {

    Map<String, Object> login(Student student);

    Map<String, Object> geStudentInfo(String token);

    void logout(String token);
}
