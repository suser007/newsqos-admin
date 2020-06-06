package com.suser;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.suser.mapper")
public class MySpringBootApplication {
    private static Logger logger = LoggerFactory.getLogger(MySpringBootApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class,args);
        logger.info("SpringBoot加载完毕");
    }
}
