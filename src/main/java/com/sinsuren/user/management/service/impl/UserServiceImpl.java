package com.sinsuren.user.management.service.impl;

import com.sinsuren.user.management.api.BlockUserRequest;
import com.sinsuren.user.management.api.UserCreationRequest;
import com.sinsuren.user.management.api.UserVerificationRequest;
import com.sinsuren.user.management.entity.User;
import com.sinsuren.user.management.model.dao.UserDao;
import com.sinsuren.user.management.service.UserService;
import com.sinsuren.user.management.statemachine.user.UserLifeCycle;
import com.sinsuren.user.management.statemachine.user.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by surender.s on 15/10/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    UserLifeCycle userLifeCycle;

    @Override
    public void createUser(UserCreationRequest userCreationRequest) {
        User user  = User.builder()
                .name(userCreationRequest.getName())
                .build();
        if(user.isNew()) {
            user.setStatus(UserStatus.CREATED);
            userLifeCycle.create(user);
        }
        userDao.create(user);
    }

    @Override
    public void verifyUser(UserVerificationRequest userVerificationRequest) {
        User user = userDao.fetch(userVerificationRequest.getId());
        userLifeCycle.verify(user);
        userDao.update(user);
    }

    @Override
    public void blockUser(BlockUserRequest blockUserRequest) {
        User user = userDao.fetch(blockUserRequest.getId());
        userLifeCycle.block(user);
        userDao.update(user);
    }
}
