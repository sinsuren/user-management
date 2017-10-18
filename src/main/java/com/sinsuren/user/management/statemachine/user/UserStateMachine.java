package com.sinsuren.user.management.statemachine.user;

import com.sinsuren.user.management.core.statemachine.BasicStateMachine;
import com.sinsuren.user.management.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.squirrelframework.foundation.fsm.annotation.Transit;
import org.squirrelframework.foundation.fsm.annotation.Transitions;

/**
 * Created by surender.s on 17/10/17.
 */

@Transitions(value = {
        @Transit(from = "CREATED", to = "CREATED", on = "CREATE"),
        @Transit(from = "CREATED", to = "VERIFIED", on = "VERIFY"),
        @Transit(from = "CREATED", to = "BLOCKED", on = "BLOCK"),
        @Transit(from = "VERIFIED", to = "BLOCKED", on = "BLOCK")
})
@Slf4j
public class UserStateMachine extends BasicStateMachine<UserStateMachine, UserStatus, UserEvent, UserContext, User> {

    public UserStateMachine(User entity, ApplicationContext applicationContext) {
        super(entity, applicationContext);
    }

    public void created(UserStatus from, UserStatus to, UserEvent on, UserContext context) {
        log.info(String.format("Transition from {} to {} on {}", from, to, on));
    }

    public void blocked(UserStatus from, UserStatus to, UserEvent on, UserContext context) {
        log.info(String.format("Transition from {} to {} on {}", from, to, on));
    }

    public void verified(UserStatus from, UserStatus to, UserEvent on, UserContext context) {
        log.info(String.format("Transition from {} to {} on {}", from, to, on));
    }
}
