package com.sinsuren.user.management.utils.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by surender.s on 26/01/18.
 * Advice(what to do) and pointcut(Where to apply advice)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface LogExecutionTime {
    String value() default "";
}
