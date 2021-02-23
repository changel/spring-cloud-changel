# spring-cloud-changel
微服务学习
## 主要jar版本说明
- Spring Cloud Version         :  Spring Cloud Hoxton.SR8
- Spring Cloud Alibaba Version :  2.2.5.RELEASE 
- Spring Boot Version          :  2.3.2.RELEASE
- Nacos Version                :  1.4.1
- RocketMQ Version	           :  4.4.0      (待用)   
- MySQL	                       :  5.7.33   
[版本依赖推荐](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E')  

##Mysql 
- nacos数据库创建
 ```
    CREATE USER 'nacos_config'@'%' IDENTIFIED BY 'nacos_config';
    create database nacos_config;
    use nacos_config;
    GRANT ALL PRIVILEGES  ON nacos_config.* TO 'nacos_config'@'%';
    GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON nacos_config.* TO nacos_config@'%' identified by 'nacos_config';
    FLUSH   PRIVILEGES; 
 ```

- nacos配置(application.properties)
 ```
#*************** Config Module Related Configurations ***************#
### If use MySQL as datasource:
spring.datasource.platform=mysql

### Count of DB:
db.num=1

### Connect URL of DB:
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user.0=nacos_config
db.password.0=nacos_config
 ```