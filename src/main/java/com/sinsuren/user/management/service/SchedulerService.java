package com.sinsuren.user.management.service;

import com.sinsuren.user.management.entity.User;
import org.quartz.SchedulerException;

/**
 * Created by surender.s on 10/12/17.
 */
public interface SchedulerService {

    void clearAllJob() throws SchedulerException;

    void registerNewJob(User user) throws SchedulerException;

    void stopTriggerForJob(User user) throws SchedulerException;
}