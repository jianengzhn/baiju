package com.eppear.baiju;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zjf
 */
@Slf4j
@SpringBootApplication
public class BaijuBoostrapApplication {


    private static BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(BaijuBoostrapApplication.class, args);
        log.debug("主程序启动完成");
        log.debug("12345的密文为：[{}]",passwordEncoder.encode("12345"));
    }

    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder a){
        passwordEncoder =a;
    }
}