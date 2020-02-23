# mallstudy
整合已学习的Java技术。'https://github.com/macrozheng/mall' - 学习记录

## 1 mall-tiny-01 学习笔记

### 1.1 mall整合`SpringBoot`+`MyBatis`搭建基本骨架

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
  * pom.xml出现jar导入不到工程时，可以在项目根目录使用cmd的maven命令。观察报错
* Controller中使用Restful风格的接口形式

~~~java
//get 无入参或者少量入参，查询-删除
@RequestMapping(value = "/listAll", method = RequestMethod.GET)
@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//post 入参json格式，新增-修改
@RequestMapping(value = "/create", method = RequestMethod.POST)
@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
~~~

### 1.2 mall整合SwaggerUI

* 实现controller接口可视化以及接口测试
* 需要新增SwaggerUi配置，指定扫描包路径和注解
* 需要调整`Mybatis Generator`的`CommentGenerator`配置，使生成的Bean字段上有数据库的备注，方便调试
* 需要重新生成Bean，Mapper，Mapper.xml。
* 注意xml的生成是否存在文件内容叠加，而不是覆盖，导致启动时报