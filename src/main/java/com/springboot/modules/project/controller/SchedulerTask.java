package com.springboot.modules.project.controller;

import com.springboot.common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author keith
 * @date 2018-06-15
 * 定时功能
 */
@RestController
public class SchedulerTask {

    /**
     * 定时器
     */
   // @RequestMapping("/scheduler")
   // @Scheduled(cron = "0 30 * * * *")
    public void reportCurrentTime() {

    }
}