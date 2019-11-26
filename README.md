## ES
SpringBoot es与mybaits的整合测试

### ES
使用的2.4.4版本 30M
下载地址: https://download.elastic.co/elasticsearch/release/org/elasticsearch/distribution/tar/elasticsearch/2.4.4/elasticsearch-2.4.4.tar.gz

es使用的jpa, 写好方法名, 语句自动生成

### pom
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
</dependency>
<dependency>
    <groupId>net.java.dev.jna</groupId>
    <artifactId>jna</artifactId>
    <version>4.5.1</version>
</dependency>
```

### 仓库继承
继承ElasticsearchRepository<对象类型, 主键类型>
方法名遵循jpa格式
```java
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String>{}
```

## 扩展
### 如何查看ES中数据
https://my.oschina.net/weiweiblog/blog/3018519

### 可视化ES数据
1.4节 https://blog.csdn.net/chen_2890/article/details/83757022
(本人没成功 因为是linux系统, node安装不上去, 就不弄了)

### 额外
https://blog.csdn.net/chen_2890/article/details/83895646