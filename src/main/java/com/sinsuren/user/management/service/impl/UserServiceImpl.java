package com.sinsuren.user.management.service.impl;

import com.sinsuren.user.management.api.UserCreationRequest;
import com.sinsuren.user.management.entity.User;
import com.sinsuren.user.management.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by surender.s on 15/10/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void createUser(UserCreationRequest userCreationRequest) {
        User user  = User.builder()
                .name(userCreationRequest.getName())
                .build();
        //userDao.create(user);
    }

    @Override
    public void verifyUser() {

    }

    @Override
    public void blockUser() {

    }
}
