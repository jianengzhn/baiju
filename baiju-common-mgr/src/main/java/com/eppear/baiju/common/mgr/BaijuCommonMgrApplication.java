package com.eppear.baiju.common.mgr;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于Mymatis Generator的持久层代码自动生成执行类
 * @author zjf
 */
@SpringBootApplication
@Slf4j
public class BaijuCommonMgrApplication {

    public static void main(String[] args) throws Exception {

        // 是否覆盖原文件，如果否则生成重命名的文件
        boolean overwrite =true;
        // 生成过程中的相关信息
        List<String> warnings = new ArrayList<String>();
        // 配置文件位置
        String pathName = "baiju-common-mgr/src/main/resources/mybatis/generatorConfig.xml";

        File configFile = new File(pathName);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator =  new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        log.info("代码生成完成，过程信息有:");
        for (String warning : warnings) {
            log.info(warning);
        }
    }

}
