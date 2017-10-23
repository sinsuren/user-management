package com.sinsuren.user.management.statemachine.user;

import com.sinsuren.user.management.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by surender.s on 18/10/17.
 */
@Service
public class UserLifeCycle {
    @Autowired
    UserStateMachineBuilder stateMachineBuilder;

    public User create(User user) {
        return stateMachineBuilder.trigger(user, UserEvent.CREATE, null);
    }

    public User verify(User user) {
        return stateMachineBuilder.trigger(user, UserEvent.VERIFY, null);
    }

    public User block(User user) {
        return stateMachineBuilder.trigger(user, UserEvent.BLOCK, null);
    }
}
