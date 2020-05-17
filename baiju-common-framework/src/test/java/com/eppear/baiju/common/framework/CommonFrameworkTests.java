package com.eppear.baiju.common.framework;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.eppear.baiju.common.framework.utils.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommonFrameworkTests {
    Log log = LogFactory.get();

    @Test
    void contextLoads() {
    }

    @Test
    void StringUtilesTest(){
        log.debug(" === StringUtils测试结果！");
        log.debug("randomNum = {}",StringUtils.randomNum(3));
        log.debug("randomStr = {}",StringUtils.randomStr(5));
    }
}
