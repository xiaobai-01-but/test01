package com.huawei.service.impl;

import com.huawei.dao.RedisDao;
import com.huawei.pojo.Content;
import com.huawei.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import java.util.List;

/**
 * @Description:
 * @author: sun
 * @date: 2020年12月11日 20:36
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void setRedis() {
        List<Content> contentList=redisDao.setRedis();
        stringRedisTemplate.boundValueOps("content_" + 1).set(JSON.toJSONString(contentList));
    }
}
