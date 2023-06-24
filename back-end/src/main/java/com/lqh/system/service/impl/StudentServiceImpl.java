package com.lqh.system.service.impl;

import com.lqh.system.entity.Student;
import com.lqh.system.mapper.StudentMapper;
import com.lqh.system.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luqiheng
 * @since 2023-06-23
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
