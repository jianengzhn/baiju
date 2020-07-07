package com.eppear.baiju.backstage.dao.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 通用Mapper集成配置类。<p>
 *
 * <ol>注意:
 * <li>这里@MapperScan是使用
 * tk.mybatis.spring.annotation.MapperScan
 * <li>注解方式配置的优先级高于配置文件，如果配置文件中也做了配置而不生效时，请注意检查此处。</li>
 * </ol>
 * @author zhangjf
 * @date 2020-06-03 21:22:55
 */
@Configuration
@MapperScan(value = "com.eppear.baiju.backstage.dao.mapper")
public class MapperConfig {
}
