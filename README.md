# SimpleBigWork
# 基于springboot+thymeleaf

河海大学HHU软工与数据库课设。用了两天不到的时间写出来的，差不多算是个原型吧。。

管理员能对项目信息，场址信息进行增删改查，以及查看所有用户列表

普通用户只能查看项目信息和场址信息。


## 项目使用方法

（1）运行user.sql,project.sql,location.sql,在数据库中创建这三张表

（2） 修改src/main/resources/application.properties文件

spring.datasource.url=jdbc:mysql://localhost:3306/bigwork?characterEncoding=utf-8&useSSL=false&serverTimezone=Hongkong

spring.datasource.username=root

spring.datasource.password=123456

bigwork修改为你所创建的数据库的名称

root修改为你的数据库用户名

123456修改为你的数据库密码

管理员

account：1806030134 

password：123456

普通用户

account：1806030135 

password：123456


