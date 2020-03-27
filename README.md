# README

## 作业进度

- [x] 清空web.xml配置，改成java配置类
- [x] 优化控制层的loginCheck方法，并且添加数据校验功能（@Valid），用户名3-6个字符，口令6个字符，并有错误提示
- [x] 数据库由原来的mysql改成H2内嵌数据库，不要有外部数据库访问依赖，exampledb.sql数据脚本同步修改
- [x] DAO层实现由现在的jdbc改成JpaRepository自动实现，方法名可以改变
- [x] DAO层的findUserByUserName添加缓存功能，缓存用EhCache实现
- [x] 测试改进：service层的测试将现在直连数据库改成使用mock取代dao层

## 简要说明

1. 使用的是jetty 9.x。
2. `com.example.config`里是全部的Java配置类，包括：
   1. Web配置
   2. H2内嵌数据库配置
   3. JPA配置
   4. EhCache配置
3. 表单验证、为了验证cache的show_sql配置、EhCache的xml在`resources`目录下。
4. 其他基本上是在原文件上进行的改动。

