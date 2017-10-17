package com.sinsuren.user.management.model.dao.impl;

import com.sinsuren.user.management.entity.User;
import com.sinsuren.user.management.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.inject.Provider;
import javax.persistence.EntityManager;

/**
 * Created by surender.s on 15/10/17.
 */
@Repository
public class UserDaoImpl extends AbstractDao<User,Long>  implements UserDao{

    Provider<String> userProvider;
    @Autowired
    public UserDaoImpl(EntityManager entityManager, @Qualifier("User") Provider<String> userProvider) {
        super(entityManager, User.class);
        this.userProvider = userProvider;
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
