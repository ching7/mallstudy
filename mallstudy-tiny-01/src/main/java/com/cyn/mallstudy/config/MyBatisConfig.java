package com.cyn.mallstudy.config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
/**
 * 文件描述
 *
 * @ProjectName: mallstudy
 * @Package: com.cyn.mallstudy.config
 * @Date 2020/2/21 22:31
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: 用于配置需要动态生成的mapper接口的路径
 **/
@Configuration
@MapperScan("com.cyn.mallstudy.mbg.mapper")
public class MyBatisConfig {
}
