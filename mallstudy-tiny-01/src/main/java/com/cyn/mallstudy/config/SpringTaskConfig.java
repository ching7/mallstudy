package com.cyn.mallstudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 文件描述
 *
 * @ProjectName: mallstudy-tiny-01
 * @Package: com.cyn.mallstudy.config
 * @Date 2020/3/9 19:53
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 定时任务配置、
 * 只需要在配置类中添加一个@EnableScheduling注解即可开启SpringTask的定时任务能力。
 **/
@Configuration
@EnableScheduling
public class SpringTaskConfig {
}
