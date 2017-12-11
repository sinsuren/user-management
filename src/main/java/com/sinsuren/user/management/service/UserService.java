package com.sinsuren.user.management.service;

import com.sinsuren.user.management.api.BlockUserRequest;
import com.sinsuren.user.management.api.UserCreationRequest;
import com.sinsuren.user.management.api.UserVerificationRequest;
import org.quartz.SchedulerException;

/**
 * Created by surender.s on 15/10/17.
 */
public interface UserService {
    void createUser(UserCreationRequest userCreationRequest);

    void verifyUser(UserVerificationRequest userVerificationRequest) throws SchedulerException;

    void blockUser(BlockUserRequest blockUserRequest) throws SchedulerException;

}
