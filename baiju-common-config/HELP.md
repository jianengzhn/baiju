# 子项目说明
### 项目基本信息

* 子项目名称：公用配置文件子模块
* 作用：该子模块为整个项目的公共依赖部分，配置与保存整个项目的公共配置项，并启用了nacos配置中心功能。

### 项目配置结构说明

以照阿里开发规范，在二方库或依赖模块里不增加配置项的原则，而在最终可执行项目包中进行配置。本项目只做了公共配置到其它项目中，详见下图：

![项目模块依赖图](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/jianengzhn/baiju/featuer-e0a1562-0413-frameowrk-develop/doc/modle-structure.puml)

1. 项目支持二级打包组合方式。即子、父二级。
2. 现假设这两级项目均可单独打包独立运行。
3. 图中公用配置件模块即为本子模块，为各子模块所依赖。并已通过Gradles构建脚本进行了设置。
4. 各可执行包中负责配置运行参数。

### 项目配置文件约定

依照Spring Boot中配置文件的优先级和互补关系，现具体约定如下，需要**强制执行**：

1. 所有配置文件都保存于classpath根目录下。
   
2. 文件名称遵循框架规范，即：application-{profile}.yml
   
3. 配置文件类型统一为.yml。

4. 所有配置文件，以{profile}来区分不同运行环境，分别配置。
   
### 参考文档
有关进一步的参考，请考虑以下部分：

* [Gradle官方文档](https://docs.gradle.org)
* [Spring Boot Gradle插件参考指南](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/gradle-plugin/reference/html/)

### 附加链接

这些附加参考资料还应帮助您：

* [Gradle构建扫描–洞察项目构建](https://scans.gradle.com#gradle)
