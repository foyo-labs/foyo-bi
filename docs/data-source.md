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

只做元数据的同步，数据库数据源连接成功即可同步元数据，非数据库，可以创建一个文件系统数据源后，导入(解析文件头，如csv/json/excel)或定义列。　

## 业务实体

### data_sources

1. name - 名称
2. dsType - 数据源类型
3. active - 是否激活
4. createdAt - 创建时间
5. createdBy - 创建人
6. updatedAt - 最后更新时间
7. updatedAt - 删除时间

### data_source_props

1. dsID - ds编号
2. name - 属性名称
3. value - 属性值
4. fieldType - 值类型
