package com.sinsuren.user.management.core.statemachine;

/**
 * Created by surender.s on 17/10/17.
 */
public interface StatefulEntity<S, ID> {
    S getStatus();
    void setStatus(S status);
    ID getId();
}
