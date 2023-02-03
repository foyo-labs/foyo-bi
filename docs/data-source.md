# 数据源模块

数据源主是BI数据的基础来源，供元数据定义以及建模，原则上不影响业务数据库使用，所以数据源接入后计算以备份数据为基础

## OWNER
* sassali@163.com

## OWNER
* sassali@163.com

## 数据源属性

不同数据源拥有不等的属性。

### mysql/postgresql

* Name
* DbName
* Host
* Port
* User
* Password
* SSL-Mode

### Elasticsearch

* Name
* URL
* User
* Password

### Microsoft SQL Server

* Name
* Server
* User
* Password
* Port
* CharacterSet
* TdsVersion

### Mongodb

* Name
* ConnectionString
* DbName
* RsName

## 流程

* 选择数据库类型
* 配置属性
* 测试连接成功
* 保存

## 目的

只做元数据的同步。　
