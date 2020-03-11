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
* 注意xml的生成是否存在文件内容叠加，而不是覆盖，导致启动时报错

### 1.3 mall整合redis实现缓存功能

* 以模拟手机验证码为例，注意redis没启动时，项目启动会报错但是不影响其他功能使用

### 1.4 mall整合Springsecurity和jwt实现认证和授权

* `jwt（JSON WEB TOKEN）`实现登陆用户认证

~~~properties
## 注意application.properties中的jwt配置。配置中切勿加 空格，可能会导致认证失败
##jwt配置
#JWT存储的请求头
jwt.tokenHeader: Authorization
#JWT加解密使用的密钥
jwt.secret: mySecret
#JWT的超期限时间(60*60*24)
jwt.expiration: 604800
#JWT负载中拿到开头
jwt.tokenHead: Bearer

# 注意
~~~

* `Springsecurity`实现授权权限控制，对应`controller`添加注解 @PreAuthorize("hasAuthority('pms:brand:update')")`

~~~properties
hasAuthority 会从已经登陆用户的token取出用户信息，对比权限

用户权限在登陆时，通过实现UserDetails接口的getAuthorities方法，将当前用户的权限放入token中
~~~

* 测试时可以调整`SecurityConfig`类的编写，使接口无需权限校验

~~~properties
.permitAll()
//测试时，下面两行调整
.antMatchers("/**")//测试时全部运行访问

注意，接口的controller上，不能有权限校验的注解，类似@PreAuthorize("hasAuthority('pms:brand:delete')")
否则依然会校验权限
~~~



### 1.5 mall整合SpringTask实现定时任务

* 注意配置类的增加，用于初始化
* 了解注解的使用方法，尤其是 `@Scheduled(cron = "1/5 * * ? * ?")`的汉语，[参考](https://blog.csdn.net/m0_37179470/article/details/81271607)

### 1.6 mall整合Elasticsearch实现表数据搜索

* 注意对应Dao的编写。Elasticsearch用于大数据查找效率高

### 1.7 mall整合RabbitMQ实现延时消息

* 注意理解`RabbitMqConfig`配置文件的含义，队列交换机的绑定策略，交换机类型的选择
* 延时消息的处理