package org.spring.springboot;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Spring Boot 应用启动类
 * <p>
 * Created by github on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        MybatisAutoConfiguration.class})
// mapper 接口类扫描包配置
//@MapperScan("org.spring.springboot.dao")
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class, args);
    }
}
