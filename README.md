# 白驹

一个基于Spring Boot开发、Spring Cloud部署的分布式、以中后台管理为主的信息系统。

### 项目介绍

白驹，出自诗经《小雅·白驹》，作者希望此系统能如白驹，志行高洁，驰骋云上，帮更多小伙伴们快速开发，成为易用好用爱用的项目。

本项目采用分布式的框架，基于项目模块化、服务化、热插拔的思想，实现对修改封闭，对扩展开放的原则。

#### 特点与特色

1. 使用Gradle做项目依赖与相建管理，把项目模块化拆分，构建脚本配置更简练、更方便；项目更易开发、易扩展。

2. 以[Spring Boot](https://spring.io/projects/spring-boot#overview) 最新稳定版(2.2.6)为基础开发，[MyBatis](https://mybatis.io/) 为数据访问层，Spring Security Kerberos为权限授权层，Redis对常用数据进行缓存。

3. 前端页面，使用angular，主题使用[Ant Design of Angular](https://ng.ant.design/docs/introduce/zh)

4. RestFul风格，独立提供标准Rest服务API，可以快速实现自己的业务，提供需要的服务。

5. 代码开发规范遵循阿里巴巴Java开发手册([最新版下载](https://github.com/alibaba/p3c))

6. 定位于互联网企业架构，已内置企业信息化系统的基础功能和高效的代码生成工具，包括：系统权限组件、数据权限组件、数据字典组件、核心工具组件、代码生成等。

#### 技术选型和文档

- Gradle，构建工具([官方文档](https://docs.gradle.org))
- Spring Boot（[官方文档](https://spring.io/projects/spring-boot#learn))
- Druid Spring Boot Starter,数据库连接池([官方中文文档](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter/)）,([Druid其它文档](https://github.com/alibaba/druid/wiki/%E9%A6%96%E9%A1%B5))
- MyBatis，数据库访问([官方中文文档](https://mybatis.org/mybatis-3/zh/index.html)) 
- MyBatisb通用Mapper插件（[官方中文文档](https://mybatis.io/))
- Saturn，定时任务 ([官方中文文档](https://vipshop.github.io/Saturn/#/))

- Ant Design of Angular，后台的管理界面([官方文档](https://ng.ant.design/docs/introduce/zh))

### 软件架构

参照阿里在开发规范，项目结构图如下：

![项目结构图](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/jianengzhn/baiju/featuer-e0a1562-0413-frameowrk-develop/doc/project-framework.puml)

说明：
 1. 应用分层：

    图中默认上层依赖于下层，如：开放接口层可以依赖于Web 层，也可以直接依赖于Service层，依此类推；箭头表示各层间传输的数据对像。

    * 开放接口层：可直接封装Service接口暴露成RPC接口； 通过 Web 封装成 http 接口；网关控制层等。
   
    * 终端显示层：各个端的模板渲染并执行显示层。 当前主要是 velocity 渲染，JS 渲染，JSP 渲染，移动端展示层等。
   
    * Web 层：主要是对访问控制进行转发，各类基本参数校验，或者不复用的业务简单处理等。
   
    * Service 层：相对具体的业务逻辑服务层 
   
    * Manager 层：通用业务处理层，它有如下特征：    
      1） 对第三方平台封装的层，预处理返回结果及转化异常信息。    
      2） 对 Service 层通用能力的下沉，如缓存方案、中间件通用处理。    
      3） 与 DAO层交互，对多个DAO的组合复用。 
      
    * DAO层：数据访问层，与底层 MySQL、Oracle、Hbase 等进行数据交互。
    
    * 外部接口或第三方平台：包括其它部门 RPC开放接口，基础平台，其它公司的 HTTP 接口。 
   
2. 分层领域模型说明
   * DO（Data Object）：此对象与数据库表结构一一对应，通过 DAO层向上传输数据源对象。 
   
   * DTO（Data Transfer Object）：数据传输对象，Service 或Manager 向外传输的对象。 
   
   * BO（Business Object）：业务对象，由Service 层输出的封装业务逻辑的对象。 
   
   * AO（Application Object）：应用对象，在Web 层与Service 层之间抽象的复用对象模型，极为贴 近展示层，复用度不高。 
   
   * VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。 
   
   * Query：数据查询对象，各层接收上层的查询请求。注意超过2 个参数的查询封装，禁止使用 Map 类 来传输。 

3. 子项目（子模块）规划说明(名称及含义)
   
   1) 主业务功能部分
      1) 业务通用处理子模块：baiju-menager
      
      2) 业务逻辑处理子模块，包括持久层：baiju-service
      
      3) 系统启动模块，包括请求处理层：baiju-boostrap
      
      4) 开放接口子模块，用于二方服务调用接口分享：baiju-openapi
      
      5) 开放接口业务实现子模块，包括启动配置：baiju-openapi-bootstrap
   
   2) 项目通用子模块
      1) 通用配置子模块：common-config
      
      2) 通用框架子模块，主要存放工具类，通用处理逻辑（与业务无直接关系部分）等：common-framework
      
   3) 云服务管理子模块
      
      1) nacos配置中心子项目，启动配置中心：baiju-cloud-nacos-config
      
      2) zuul网关代理子项目：baiju-cloud-zuul
      
      3) Hystrix 断路器子项目：baiju-cloud-hystrix
 
4. 应用包名规划说明
 
  xxxx
      
### 安装教程

1. xxxx
2. xxxx
3. xxxx

### 使用说明

1. xxxx
2. xxxx
3. xxxx

### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

### 码云特技

1.

## 标星统计

[![标星统计](https://starchart.cc/jianengzhn/baiju.svg)](https://starchart.cc/jianengzhn/baiju)