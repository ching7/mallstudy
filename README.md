# mallstudy
整合已学习的Java技术。'https://github.com/macrozheng/mall' - 学习记录

## 1 mall-tiny-01 学习笔记

* mall整合`SpringBoot`+`MyBatis`搭建基本骨架
  * 涉及知识点
    * `SpringBoot` `MyBatis` - 待深入
    * `PagerHelper` - 待学习
    * `Druid` - 待深入
    * `Mybatis generator`- 待学习

* 平常的数据库账号密码测试阶段最好设置成root，root，上线阶段在做修改
* 项目数据库脚本可以导出以作备份
* 连接数据库时，注意连接的数据库名称合代码的编写

~~~properties
## port之后的为数据库名
jdbc:mysql://localhost:3306/mall_study?serverTimezone=UTC
## mysql8的包位置变化
jdbc.driverClass=com.mysql.cj.jdbc.Driver

~~~

* `MyBatisGenerator`使用时，注意配置文件的修改

~~~properties
<!--可以自定义生成model的代码注释-->
<!--配置数据库连接-->
<!--解决mysql驱动升级到8.0后不生成指定数据库代码的问题-->
<!--指定生成model的路径-->
<!--指定生成mapper.xml的路径-->
<!--指定生成mapper接口的的路径-->
<!--生成全部表tableName设为%-->

以上位置需要根据实际情况调整xml文件
~~~

* `Generator`类在使用的时候可能会出现xml文件加载不到的情况，如果确定路径正确。可以重新建一个空的web项目，添加maven支持后。赋值代码过去重新运行