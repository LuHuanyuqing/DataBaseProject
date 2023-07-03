package com.lqh.sys.mapper;

import com.lqh.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author luqiheng
 * @since 2023-07-03
 */
public interface UserMapper extends BaseMapper<User> {
    public List<String> getRelationByUserId(Integer userId);
}
