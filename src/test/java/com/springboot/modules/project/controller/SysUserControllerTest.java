package com.springboot.modules.project.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SysUserControllerTest {
    @Value("${domainName}")
    private String domainName;
    @Test
    public void insertUserInfo() {
        System.out.println(domainName);
    }
}