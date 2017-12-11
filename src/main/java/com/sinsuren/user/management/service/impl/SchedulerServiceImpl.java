package com.sinsuren.user.management.service.impl;

import com.sinsuren.user.management.entity.User;
import com.sinsuren.user.management.scheduler.UpdateUserStatus;
import com.sinsuren.user.management.service.SchedulerService;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by surender.s on 10/12/17.
 */
@Service
public class SchedulerServiceImpl implements SchedulerService {
    @Autowired
    SchedulerFactoryBean scheduler;

    @Override
    public void clearAllJob() throws SchedulerException {
        scheduler.getScheduler().clear();
    }

    @Override
    public void registerNewJob(User user) throws SchedulerException {
        scheduler.getScheduler().scheduleJob(getJobDetail(user), Collections.singleton(getTrigger(user)), true);
    }

    @Override
    public void stopTriggerForJob(User user) throws SchedulerException {
        scheduler.getScheduler().rescheduleJob(new TriggerKey(getName(user, "TRIGGER"), UpdateUserStatus.UPDATE_USER_STATUS), getDeadTrigger());
    }

    private JobDetail getJobDetail(User user) throws SchedulerException {
        return newJob(UpdateUserStatus.class)
                .withIdentity(getName(user, "JOB"), UpdateUserStatus.UPDATE_USER_STATUS)
                .usingJobData(UpdateUserStatus.USER_ID, String.valueOf(user.getId()))
                .storeDurably().build();
    }


    private String getName(User user, String prefix) {
        return String.format("%s_%s",user.getId(), prefix);
    }

    private Trigger getTrigger(User user) {
        return newTrigger()
                .withIdentity(getName(user, "TRIGGER"), UpdateUserStatus.UPDATE_USER_STATUS)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .startNow()
                .build();
    }

    private Trigger getDeadTrigger() {
        return newTrigger()
                .build();
    }
}
