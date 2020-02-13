[English](./README-EN.md) | 简体中文

<p align="center">
  <a>
    <img alt="clownmask" src="http://xs-img.51aogu.com/_cms_/d387f1edac05d3a07219d66c57f2bfea.jpg" width="100">
  </a>
</p>
<p align="center">
    <img alt="clownmask" src="https://xs-img.51aogu.com/TIM-20200208150745.png">
</p>
<h1 align="center">clownmask</h1>
<p align="center">
    <a href="/LICENSE"><img src="https://img.shields.io/badge/license-MIT-blue.svg" alt="GitHub license" /></a>
    <a href="https://spring.io/projects/spring-boot"><img src="https://img.shields.io/badge/springboot-2.1.3.RELEASE-green" alt="springboot-2.1.3.RELEASE" /></a>
    <a href="https://adminlte.io/themes/AdminLTE/index2.html"><img src="https://img.shields.io/badge/adminlte-2.4.0-red" alt="adminlte-2.4.0" /></a>
    <a href="https://github.com/baomidou/mybatis-plus"><img src="https://img.shields.io/badge/mybatisplus-3.0.7.1-orange" alt="mybatisplus-3.0.7.1" /></a>
</p>
<div align="center">
    简单友好的快速开发框架
</div>

## 项目说明

- 采用SpringBoot、MyBatis、Shiro框架，开发的一套快速开发框架，极低门槛，拿来即用。
- 结合优秀的快速框架,clownmask小且简单。
- 提供了代码生成器。
- 码云地址：[https://gitee.com/Mr_hanx/clownmask](URL 'https://gitee.com/Mr_hanx/clownmask')
- Github地址：[https://github.com/Mr-han/clownmask](URL 'https://github.com/Mr-han/clownmask')

## 截图
<div align="center">
    <img alt="clownmask" src="https://xs-img.51aogu.com/Screenshot2.png">
    <img alt="clownmask" src="https://xs-img.51aogu.com/Screenshot0.png">
    <img alt="clownmask" src="https://xs-img.51aogu.com/Screenshot1.png">
    <img alt="clownmask" src="https://xs-img.51aogu.com/Screenshot.png">
</div>

## 特点 
- 灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
- 完善的部门管理及数据权限，通过注解实现数据权限的控制
- 完善的XSS防范及脚本过滤，彻底杜绝XSS攻击
- 友好的代码结构及注释，便于阅读及二次开发
- 引入quartz定时任务，可动态完成任务的添加、修改、删除、暂停、恢复及日志查看等功能
- 页面交互使用Vue2.x，极大的提高了开发效率
- 引入swagger文档支持，方便编写API接口文档
- 支持多语言


## 数据权限设计思想
- 管理员管理、角色管理、部门管理，可操作本部门及子部门数据
- 菜单管理、定时任务、参数管理、字典管理、系统日志，没有数据权限
- 业务功能，按照用户数据权限，查询、操作数据【没有本部门数据权限，也能查询本人数据】
- 如果需要增加数据权限，需要在表字段和类属性上面增加部门字段（```dept_id```）,然后再方法上面加```DataFilter```注解


## 项目结构

```
clownmask
|
├─clownmask-common     公共模块（代码生成）
│ 
├─clownmask-admin      管理后台
│    ├─db  数据库SQL脚本
│    │ 
│    ├─modules  模块
│    │    ├─job 定时任务
│    │    ├─oss 文件存储
│    │    └─sys 系统管理(核心)
│    │ 
│    └─resources 
│        ├─mapper   MyBatis文件
│        ├─statics  静态资源
│        ├─template 系统页面
│        │    ├─modules      模块页面
│        │    ├─index.html   主页
│        └─application.yml   全局配置文件
│       
├─clownmask-api        API服务
│ 
├─clownmask-dynamic-datasource  动态数据库
│
```


## 技术选型
- 核心框架：Spring Boot 2.1.3
- 安全框架：Apache Shiro 1.4
- 持久层框架：MyBatis 3.5
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.1
- 日志管理：SLF4J 1.7、Log4j
- 页面交互：Vue2.x

## 软件需求
- JDK1.8
- MySQL5.5+
- Maven3.0+

## 运行

> git clone https://github.com/Mr-han/clownmask.git

- 修改 `application.yml` 中的数据库链接

- 后台管理 运行 `clownmask-admin` 中的 `AdminApplication`。

- 访问 ：`http://localhost:8082/admin/login.html`. 登陆名/密码：`admin/admin`

## License

[MIT](/LICENSE)