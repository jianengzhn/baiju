# 入门指南


### 使用指南

此项目为DAO层自动生成源码项目。具体配置详见配置文件，请按如下步骤使用:
 
 1. 检查并更新配置文件application.properties，配置数据库连接信息，配置源码生成的位置。
 
 2. 检查并配置generatorConfig.xml，重点检查table元素，确定需要生成的表，其它属性如无特殊需要则不必修改。

 3. 检查并修改BaijuCommonMgrApplication#main()方法，默认配置为覆盖上次生成的源码，如果不允许直接覆盖，
 则修改为：boolean overwrite =false;
 
 4. 运行BaijuCommonMgrApplication.main()方法，即可生成；如有异常，请注意控制台信息提示。

### 参考文档
有关进一步的参考，请查阅以下文档：

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.7.RELEASE/gradle-plugin/reference/html/)
* [Spring Data JDBC](https://docs.spring.io/spring-data/jdbc/docs/current/reference/html/)

### 附加链接

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

