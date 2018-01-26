package com.sinsuren.user.management.utils.logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by surender.s on 26/01/18.
 */
@Configuration
@EnableAspectJAutoProxy
public class LogExecutionTimeConfiguration {
    @Bean
    public LogExectuionTimeAspect getLogExecutionTime() {
        return new LogExectuionTimeAspect();
    }
}
