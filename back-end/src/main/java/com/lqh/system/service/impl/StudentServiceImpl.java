package com.lqh.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lqh.system.entity.Student;
import com.lqh.system.mapper.StudentMapper;
import com.lqh.system.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, Object> login(Student student) {
        //根据学号进行查询
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getSno, student.getSno());
        wrapper.eq(Student::getSname, student.getSname());
        Student loginStudent = this.baseMapper.selectOne(wrapper);
        //结果不为空, 则生成token, 并将用户信息存入redis
        if(loginStudent != null){
          //暂时用UUID, 终极方案是jwt
            String key = "student:" + UUID.randomUUID();

            //存入redis
            loginStudent.setSno(null);
            redisTemplate.opsForValue().set(key, loginStudent, 30, TimeUnit.MINUTES);

            //返回数据
            Map<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> geStudentInfo(String token) {
        //根据token获取用户信息,redis
        Object obj = redisTemplate.opsForValue().get(token);
        if (obj != null){
            Student loginStudent = JSON.parseObject(JSON.toJSONString(obj), Student.class);
            Map<String, Object> data = new HashMap<>();
            data.put("name", loginStudent.getSname());
            data.put("avatar", loginStudent.getSno()); //头像对应学号

            //角色 //角色对应选课
            List<String> courseList = this.baseMapper.getCourseCnameByStudentSno(loginStudent.getSno());
            data.put("courses", courseList);

            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }
}
