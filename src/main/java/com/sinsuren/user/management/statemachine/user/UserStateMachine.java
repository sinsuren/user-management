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
        @Transit(from = "CREATED", to = "CREATED", on = "CREATE", callMethod = "create"),
        @Transit(from = "CREATED", to = "VERIFIED", on = "VERIFY", callMethod = "verify"),
        @Transit(from = "CREATED", to = "BLOCKED", on = "BLOCK", callMethod = "block"),
        @Transit(from = "VERIFIED", to = "BLOCKED", on = "BLOCK", callMethod = "block")
})
@Slf4j
public class UserStateMachine extends BasicStateMachine<UserStateMachine, UserStatus, UserEvent, UserContext, User> {

    public UserStateMachine(User entity, ApplicationContext applicationContext) {
        super(entity, applicationContext);
    }

    public void create(UserStatus from, UserStatus to, UserEvent on, UserContext context) {
        log.info(String.format("Transition from {} to {} on {}", from, to, on));
        log.info("Create Function was called");
    }

    public void block(UserStatus from, UserStatus to, UserEvent on, UserContext context) {
        log.info(String.format("Transition from {} to {} on {}", from, to, on));
        log.info("Block Function was called");
    }

    public void verify(UserStatus from, UserStatus to, UserEvent on, UserContext context) {
        log.info(String.format("Transition from {} to {} on {}", from, to, on));
        log.info("verify Function was called");
    }
}
