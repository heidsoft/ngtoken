# 用户创建
CREATE USER 'springuser'@'%' IDENTIFIED BY 'The@Passw0rd';
GRANT ALL ON mybatis.* TO 'springuser'@'%';

# spring use
```
spring.jpa.hibernate.ddl-auto=create-drop
Spring Boot 应用在启动过程中，就能根据实体，来自动映射成为数据库的表结构。create-drop 意味着，创建表结构前，会把之前已经存在的表结构先 drop掉。好处在于，每次的表结构都是全新的。

当然，也有学员产生了困扰。好不容易在表结构中创建了一堆的数据，结果重启了应用之后，就都drop掉，不见了。非常着急。

其实，很简单，只需设置 spring.jpa.hibernate.ddl-auto 配置即可。spring.jpa.hibernate.ddl-auto 的配置与 Hibernate 相似，除了 create-drop 外，还有 none, validate, update, create 等几个配置项。每个项含义如下：

validate 加载 Hibernate 时，验证创建数据库表结构
create 每次加载 Hibernate ，重新创建数据库表结构，这就是导致数据库表数据丢失的原因。
create-drop 加载 Hibernate 时创建，退出是删除表结构
update 加载 Hibernate 自动更新数据库结构
```