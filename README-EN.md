English | [简体中文](./README.md)

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
    A simple and friendly rapid development framework
</div>

## Instruction

- A set of rapid development framework developed using SpringBoot, MyBatis, Shiro framework, with extremely low threshold,and ready to use.
- Combined with some excellent fast frameworks, Clownmask is small and simple.
- Provides a code generator.
- gitee：[https://gitee.com/Mr_hanx/clownmask](URL 'https://gitee.com/Mr_hanx/clownmask')
- Github：[https://github.com/Mr-han/clownmask](URL 'https://github.com/Mr-han/clownmask')

## Screenshot

<div align="center">
    <img alt="clownmask" src="https://xs-img.51aogu.com/Screenshot2.png">
    <img alt="clownmask" src="https://xs-img.51aogu.com/Screenshot0.png">
    <img alt="clownmask" src="https://xs-img.51aogu.com/Screenshot1.png">
    <img alt="clownmask" src="https://xs-img.51aogu.com/Screenshot.png">
</div>

## Features
- Flexible permission control.
- Annotation mode to achieve permission control.
- xss prevention and filtering.
- Friendly code structure and comments for easy reading and secondary development.
- Introduced quartz scheduled tasks, which can dynamically complete tasks such as adding, modifying, deleting, pausing, resuming, and viewing logs.
- Developed with vue2.x.
- Using Swagger Api documentation.
- Support multiple languages


## Permission control
- In some methods with permission control turned on, the data will be filtered according to the user's dept.
- If you want to turn on permission control,You need to add the dept field(```dept_id```) to the table and entity classes,and add annotations(```DataFilter```) to methods.


## Project structure

```
clownmask
|
├─clownmask-common     
│ 
├─clownmask-admin      
│    ├─db  [sql]
│    │ 
│    ├─modules  
│    │    ├─job 
│    │    ├─oss 
│    │    └─sys 
│    │ 
│    └─resources 
│        ├─mapper   [MyBatis]
│        ├─statics  
│        ├─template 
│        │    ├─modules      
│        │    ├─index.html   
│        └─application.yml  
│       
├─clownmask-api        [api service]
│ 
├─clownmask-dynamic-datasource
│
```


## Dependencies
- Spring Boot 2.1.3
- Apache Shiro 1.4
- MyBatis 3.5
- Quartz 2.3
- Druid 1.1
- SLF4J 1.7、Log4j
- Vue2.x


## Environment
- JDK1.8
- MySQL5.5+
- Maven3.0+

## Run

> git clone https://github.com/Mr-han/clownmask.git

- edit database link information in `application.yml`.
- admin run `AdminApplication` in `clownmask-admin`。
- address ：`http://localhost:8082/admin/login.html`. username/password ：`admin/admin`

## License

[MIT](/LICENSE)