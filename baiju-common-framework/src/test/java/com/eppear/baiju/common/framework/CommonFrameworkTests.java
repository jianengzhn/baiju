package com.eppear.baiju.common.framework;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.eppear.baiju.common.framework.common.Signature;
import com.eppear.baiju.common.framework.constant.ConfigConstants;
import com.eppear.baiju.common.framework.utils.SignUtil;
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
        log.debug("isNotEmpty = {}", StrUtils.isNotEmpty("ddd"));
    }

    @Test
    public void test() {
        Signature sgt = new Signature();

        sgt.setId("22");
        sgt.setToken("bac");
        // 测试信息不全,有为空时的信息,会有异常
        //String s = createSign(sgt);
        String s = SignUtil.generateSign(sgt).getSignature();

        System.out.println(s);

    }

    @Test
    public void configTest(){
        log.debug("WEBSOCKET_SIGN_TIMEOUT==> {}", ConfigConstants.WEBSOCKET_SIGN_TIMEOUT);

        Snowflake snowflake=new Snowflake(1,1);
        log.debug("snowflake -  {}",snowflake.nextId());
        assert  ConfigConstants.WEBSOCKET_SIGN_TIMEOUT.equals("60");
    }
}
