# 数据源模块

数据源主是BI数据的基础来源，供元数据定义以及建模。

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

## 问题？

* 若是一个csv或excel如何做?压缩包?远程?
