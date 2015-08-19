
-- 创建数据库
create database yike default character set utf8;
drop database yike;

-- 创建数据库管理用户
grant all privileges  on yike.*  to 'yike'@'&' identified by'123456';
-- 刷新权限
flush privileges;

use yike;



-- 创建表
create table user(
  id int PRIMARY KEY AUTO_INCREMENT,
  username varchar(20),
  sex varchar(2),
  birthday date ,
  address varchar(100),
  detail varchar(255),
  score float
);

-- 插入数据
insert into user(username, sex, birthday, address, detail, score) values('李四','女','1999-08-01','广州市天河区体育东路','detial...',100);
insert into user(username, sex, birthday, address, detail, score) values('张三','男','1989-09-01','广州市海珠区体磨碟沙','detial...',99);

-- 查询数据
select * from user;