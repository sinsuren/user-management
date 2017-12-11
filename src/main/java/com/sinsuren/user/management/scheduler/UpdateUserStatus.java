package com.sinsuren.user.management.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * Created by surender.s on 10/12/17.
 */
@Slf4j
@DisallowConcurrentExecution
public class UpdateUserStatus extends QuartzJobBean {
    public static final String UPDATE_USER_STATUS = "UPDATE_USER_STATUS";
    public static final String USER_ID = "USER_ID";

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("I was triggered at time: " + new Date());
    }
}
