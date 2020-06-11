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
 *
 * @author zjf
 */
@SpringBootApplication
@Slf4j
public class BaijuCommonMgrApplication {

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<String>();

        boolean overwrite = true;
        File configFile = new File("baiju-common-mgr/src/main/resources/mybatis/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator =  new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        log.info("代码生成完成，过程信息有:");
        for(int i=0;i<warnings.size();i++){
            log.info(warnings.get(i));
        }
    }

}
