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


### 数据库
```sql
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', '登黄鹤楼', '王之涣的登黄鹤楼', '白日依山尽,黄河入海流.欲穷千里目,更上一层路.', 1);
INSERT INTO `blog` VALUES ('2', '相思', '王维的相思', '红豆生南国,春来发几枝.愿君多采撷,此物最相思.', 2);
INSERT INTO `blog` VALUES ('3', '静夜思', '李白的静夜思', '床前明月光,疑是地上霜.举头望明月,低头思故乡.', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'cn1');
INSERT INTO `user` VALUES (2, 'cn2');
INSERT INTO `user` VALUES (3, 'cn3');

SET FOREIGN_KEY_CHECKS = 1;
```