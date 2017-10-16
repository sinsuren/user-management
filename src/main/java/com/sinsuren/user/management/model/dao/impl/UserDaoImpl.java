package com.sinsuren.user.management.model.dao.impl;

import com.sinsuren.user.management.entity.User;
import com.sinsuren.user.management.model.dao.UserDao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by surender.s on 15/10/17.
 */

public class UserDaoImpl extends AbstractDao<User,Long>  implements UserDao{

    @Inject
    public UserDaoImpl(EntityManager entityManager, Class<User> entityClass) {
        super(entityManager, entityClass);
    }

    @Override
    public void create(User user) {
        insert(user);
    }

    @Override
    public User fetch(Long id) {
        return findById(id);
    }

    @Override
    public void update(User user) {
        this.getEntityManager().merge(user);
    }
}
