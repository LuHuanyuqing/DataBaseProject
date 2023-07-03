package com.lqh.sys.service.impl;

import com.lqh.sys.entity.Event;
import com.lqh.sys.mapper.EventMapper;
import com.lqh.sys.service.IEventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luqiheng
 * @since 2023-07-03
 */
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements IEventService {

}
