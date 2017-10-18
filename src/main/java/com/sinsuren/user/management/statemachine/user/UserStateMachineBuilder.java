package com.sinsuren.user.management.statemachine.user;

import com.sinsuren.user.management.core.statemachine.AbstractStateMachineBuilder;
import com.sinsuren.user.management.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;

/**
 * Created by surender.s on 17/10/17.
 */
@Component
public class UserStateMachineBuilder extends AbstractStateMachineBuilder<UserStateMachine, UserStatus, UserEvent, UserContext, User> {
    @Override
    protected StateMachineBuilder<UserStateMachine, UserStatus, UserEvent, UserContext> createBasicStateMachine() {
        return StateMachineBuilderFactory.create(UserStateMachine.class,
                UserStatus.class, UserEvent.class, UserContext.class, User.class,
                ApplicationContext.class);
    }
}
