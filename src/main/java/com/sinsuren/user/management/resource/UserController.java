package com.sinsuren.user.management.resource;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.sinsuren.user.management.api.BlockUserRequest;
import com.sinsuren.user.management.api.UserCreationRequest;
import com.sinsuren.user.management.api.UserVerificationRequest;
import com.sinsuren.user.management.service.UserService;
import com.sinsuren.user.management.utils.logging.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by surender.s on 15/10/17.
 */
@Slf4j
@RestController
@Component
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @Transactional
    @Timed
    @LogExecutionTime
    @ExceptionMetered
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserCreationRequest userCreationRequest) {
        userService.createUser(userCreationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Transactional
    @Timed
    @ExceptionMetered
    @LogExecutionTime
    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestBody UserVerificationRequest userVerificationRequest) throws SchedulerException {
        userService.verifyUser(userVerificationRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Transactional
    @Timed
    @ExceptionMetered
    @LogExecutionTime
    @PostMapping("/block")
    public ResponseEntity<?> blockUser(@RequestBody BlockUserRequest blockUserRequest) throws SchedulerException {
        userService.blockUser(blockUserRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
