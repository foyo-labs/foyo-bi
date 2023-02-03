# Foyo-BI

Foyo-BI 是一个面向业务、可视化、轻量的免费开源BI系统，目标是使用可视化工具完成数据图表与报表工作，适用于中小型企业应用。

### ***这个项目还属于早期开发阶段!***

功能:
1. **基于Web浏览器**: 在任何现代浏览器中运行
2. **易于使用**:
3. **图表设计器**:
4. **支持众多数据源**:
5. **可视化操作**:
6. **老板模式**:
7. **无需要解SQL语法**:


## 使用的关键技术

* [JDK11](http://#)
* [Kotlin](https://kotlinlang.org)
* [Spring](https://spring.io)
* [Ignite3](https://ignite.apache.org/docs/3.0.0-beta/index)
* [Postgresql](https://www.postgresql.org)
* [Nextjs](https://nextjs.org/)
* [ECharts](https://echarts.apache.org/zh/index.html)

## 功能模块

为了能更清晰了解本系统，以下说明各模块的设计与功能:

1. [用户、组、权限](./docs/user.md)
2. [数据源](./docs/data-source.md)
3. [元数据](./docs/meta-data.md)
4. [建模工作流](./docs/workflow.md)
5. [数据模型](./docs/data-model.md)
6. [图表设计器](./docs/chart-design.md)


## 项目结构

## 如何运行?

### Ignite3 beta

#### 开发环境

系统依赖Apache Ignite 3,　目前暂无Docker版本，按以下脚本安装启动。

```shell
curl -L "https://www.apache.org/dyn/mirrors/mirrors.cgi?action=download&filename=ignite/3.0.0-beta1/ignite3-3.0.0-beta1.zip" -o ignite3-3.0.0-beta1.zip
unzip ignite3-3.0.0-beta1.zip && cd ignite3-3.0.0-beta1
export IGNITE_HOME=$(pwd)
```

#### 生产应用

## License

Apache License 2.0
