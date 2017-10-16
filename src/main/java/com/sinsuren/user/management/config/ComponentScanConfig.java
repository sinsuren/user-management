package com.sinsuren.user.management.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by surender.s on 16/10/17.
 */
@Configuration
@ComponentScan(value = {"com.sinsuren.user.management"})
@EnableJpaRepositories(value = {"com.sinsuren.user.management"})
@EntityScan(value = {"com.sinsuren.user.management"})
public class ComponentScanConfig {
}
