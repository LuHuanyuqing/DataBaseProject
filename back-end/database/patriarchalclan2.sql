DROP database IF EXISTS `patriarchalclan`;

 create database patriarchalclan;

 use patriarchalclan;

 SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------

-- ----------------------------

-- Table structure for patriarchalclan

-- ----------------------------

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',`username` varchar(255) DEFAULT NULL COMMENT '账号',`password` varchar(255) DEFAULT NULL COMMENT '密码',PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '管理员';-- ----------------------------

DROP TABLE IF EXISTS `t_taste`;

CREATE TABLE `t_taste` (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '事件id',`waterdrop` varchar(255) DEFAULT NULL COMMENT '成员',`waterdropid` int(11) DEFAULT NULL COMMENT '成员id',`content` varchar(500) DEFAULT NULL COMMENT '内容',`fort` varchar(255) DEFAULT NULL COMMENT '家族',`fortid` int(11) DEFAULT NULL COMMENT '家族id',  KEY `key_taste_waterdropid` (`waterdropid`),
  CONSTRAINT `key_taste_waterdropid` FOREIGN KEY (`waterdropid`) REFERENCES `t_waterdrop` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,  KEY `key_taste_fortid` (`fortid`),
  CONSTRAINT `key_taste_fortid` FOREIGN KEY (`fortid`) REFERENCES `t_fort` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '成员事件';-- ----------------------------

DROP TABLE IF EXISTS `t_fort`;

CREATE TABLE `t_fort` (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家族id',`name` varchar(255) DEFAULT NULL COMMENT '名称',`username` varchar(255) DEFAULT NULL COMMENT '账号',`password` varchar(255) DEFAULT NULL COMMENT '密码',`infoo` varchar(500) DEFAULT NULL COMMENT '描述',PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '家族';-- ----------------------------

DROP TABLE IF EXISTS `t_waterdrop`;

CREATE TABLE `t_waterdrop` (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成员id',`imagee` varchar(255) DEFAULT NULL COMMENT '头像',`fort` varchar(255) DEFAULT NULL COMMENT '家族',`fortid` int(11) DEFAULT NULL COMMENT '家族id',`name` varchar(255) DEFAULT NULL COMMENT '姓名',`gender` varchar(255) DEFAULT NULL COMMENT '性别',`birthday` varchar(255) DEFAULT NULL COMMENT '生日',`father` varchar(255) DEFAULT NULL COMMENT '父辈',`fatherid` int(11) DEFAULT NULL COMMENT '父辈id',  KEY `key_waterdrop_fortid` (`fortid`),
  CONSTRAINT `key_waterdrop_fortid` FOREIGN KEY (`fortid`) REFERENCES `t_fort` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,  KEY `key_waterdrop_fatherid` (`fatherid`),
  CONSTRAINT `key_waterdrop_fatherid` FOREIGN KEY (`fatherid`) REFERENCES `t_waterdrop` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '家庭成员';

