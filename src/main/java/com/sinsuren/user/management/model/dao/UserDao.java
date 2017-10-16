package com.sinsuren.user.management.model.dao;

import com.sinsuren.user.management.entity.User;

/**
 * Created by surender.s on 15/10/17.
 */
public interface UserDao{
    void create(User user);
    User fetch(Long id);
    void update(User user);
}