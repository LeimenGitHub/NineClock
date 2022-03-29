package com.nineclock.system.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.nineclock.common.swagger","com.nineclock.common.exception"})
public class ImportConfig {
}
