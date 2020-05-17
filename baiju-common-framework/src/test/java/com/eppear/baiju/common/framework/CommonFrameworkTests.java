package com.eppear.baiju.common.framework;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.eppear.baiju.common.framework.utils.StrUtils;
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
        log.debug("randomNum = {}", StrUtils.randomNum(3));
        log.debug("randomStr = {}", StrUtils.randomStr(5));
    }
}
