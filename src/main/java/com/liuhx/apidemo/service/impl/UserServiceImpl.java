package com.liuhx.apidemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuhx.apidemo.dao.mapper.UserMapper;
import com.liuhx.apidemo.model.po.User;
import com.liuhx.apidemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @program apidemo
 * @description: 用户表基础操作
 * @author: liuhx
 * @create: 2018/11/15 17:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
