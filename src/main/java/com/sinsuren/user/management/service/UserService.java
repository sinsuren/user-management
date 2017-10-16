package com.sinsuren.user.management.service;

import com.sinsuren.user.management.api.UserCreationRequest;

/**
 * Created by surender.s on 15/10/17.
 */
public interface UserService {
    void createUser(UserCreationRequest userCreationRequest);

    void verifyUser();

    void blockUser();

}
