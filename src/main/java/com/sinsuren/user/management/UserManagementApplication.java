package com.sinsuren.user.management;

import com.sinsuren.user.management.core.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

/**
 * Created by surender.s on 15/10/17.
 */
@SpringBootApplication
@Slf4j
public class UserManagementApplication {
    @Autowired
    private Environment environment;

    public static void main(String args[]) {
        SpringApplication app = new SpringApplication(UserManagementApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }


    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        if(!source.containsProperty("spring.profiles.active") && !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
            app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
        }
    }
}
