package com.eppear.baiju;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zjf
 */
@Slf4j
@SpringBootApplication
public class BaijuBoostrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaijuBoostrapApplication.class, args);
        log.debug("主程序启动完成");
    }
}