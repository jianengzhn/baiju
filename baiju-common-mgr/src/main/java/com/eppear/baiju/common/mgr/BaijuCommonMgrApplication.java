package com.eppear.baiju.common.mgr;

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
    }

}
