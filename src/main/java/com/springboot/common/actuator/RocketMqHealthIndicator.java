package com.springboot.common.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author keith
 * @date 2018-08-25
 */
@Component
public class RocketMqHealthIndicator implements HealthIndicator{
    @Override
    public Health health() {
        return Health.down().withDetail("port",9876).build();
    }
}
