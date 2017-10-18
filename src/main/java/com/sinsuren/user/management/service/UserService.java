package com.sinsuren.user.management.service;

import com.sinsuren.user.management.api.BlockUserRequest;
import com.sinsuren.user.management.api.UserCreationRequest;
import com.sinsuren.user.management.api.UserVerificationRequest;

/**
 * Created by surender.s on 15/10/17.
 */
public interface UserService {
    void createUser(UserCreationRequest userCreationRequest);

    void verifyUser(UserVerificationRequest userVerificationRequest);

    void blockUser(BlockUserRequest blockUserRequest);

}
