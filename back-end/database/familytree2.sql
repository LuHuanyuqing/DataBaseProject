DROP database IF EXISTS `familytree`;

 create database familytree;

 use familytree;

 SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------

-- ----------------------------

-- Table structure for familytree

-- ----------------------------

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',`username` varchar(255) DEFAULT NULL COMMENT '账号',`password` varchar(255) DEFAULT NULL COMMENT '密码',PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '管理员';-- ----------------------------

DROP TABLE IF EXISTS `t_incident`;

CREATE TABLE `t_incident` (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '事件id',`memberr` varchar(255) DEFAULT NULL COMMENT '成员',`memberrid` int(11) DEFAULT NULL COMMENT '成员id',`eventdescription` varchar(500) DEFAULT NULL COMMENT '描述',`family` varchar(255) DEFAULT NULL COMMENT '家族',`familyid` int(11) DEFAULT NULL COMMENT '家族id',  KEY `key_incident_memberrid` (`memberrid`),
  CONSTRAINT `key_incident_memberrid` FOREIGN KEY (`memberrid`) REFERENCES `t_member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,  KEY `key_incident_familyid` (`familyid`),
  CONSTRAINT `key_incident_familyid` FOREIGN KEY (`familyid`) REFERENCES `t_family` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '人员事件';-- ----------------------------

DROP TABLE IF EXISTS `t_family`;

CREATE TABLE `t_family` (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家族id',`name` varchar(255) DEFAULT NULL COMMENT '名称',`username` varchar(255) DEFAULT NULL COMMENT '账号',`password` varchar(255) DEFAULT NULL COMMENT '密码',`intro` varchar(500) DEFAULT NULL COMMENT '描述',`createtime` varchar(255) DEFAULT NULL COMMENT '创建时间',PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '家族';-- ----------------------------

DROP TABLE IF EXISTS `t_member`;

CREATE TABLE `t_member` (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成员id',`avatar` varchar(255) DEFAULT NULL COMMENT '头像',`family` varchar(255) DEFAULT NULL COMMENT '家族',`familyid` int(11) DEFAULT NULL COMMENT '家族id',`name` varchar(255) DEFAULT NULL COMMENT '姓名',`gender` varchar(255) DEFAULT NULL COMMENT '性别',`birthday` varchar(255) DEFAULT NULL COMMENT '生日',`father` varchar(255) DEFAULT NULL COMMENT '父亲',`fatherid` int(11) DEFAULT NULL COMMENT '父亲id',`mother` varchar(255) DEFAULT NULL COMMENT '母亲',`motherid` int(11) DEFAULT NULL COMMENT '母亲id',`spouses` varchar(255) DEFAULT NULL COMMENT '配偶',`spousesid` int(11) DEFAULT NULL COMMENT '配偶id',  KEY `key_member_familyid` (`familyid`),
  CONSTRAINT `key_member_familyid` FOREIGN KEY (`familyid`) REFERENCES `t_family` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,  KEY `key_member_fatherid` (`fatherid`),
  CONSTRAINT `key_member_fatherid` FOREIGN KEY (`fatherid`) REFERENCES `t_member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,  KEY `key_member_motherid` (`motherid`),
  CONSTRAINT `key_member_motherid` FOREIGN KEY (`motherid`) REFERENCES `t_member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,  KEY `key_member_spousesid` (`spousesid`),
  CONSTRAINT `key_member_spousesid` FOREIGN KEY (`spousesid`) REFERENCES `t_member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '家庭成员';

