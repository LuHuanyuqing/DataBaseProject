package com.lqh.system.mapper;

import com.lqh.system.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luqiheng
 * @since 2023-06-23
 */
public interface StudentMapper extends BaseMapper<Student> {
    public List<String> getCourseCnameByStudentSno(String studentSno);
}
