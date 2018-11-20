package com.springboot.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author keith
 * @date 2018-06-14
 * //maxInactiveIntervalInSeconds
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
public class SessionConfig {
}
