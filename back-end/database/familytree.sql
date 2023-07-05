/*
Navicat MySQL Data Transfer

Source Server         : 123456
Source Server Version : 80033
Source Host           : localhost:3306
Source Database       : familytree

Target Server Type    : MYSQL
Target Server Version : 80033
File Encoding         : 65001

Date: 2023-07-05 01:48:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='管理员';

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('3', '1', '4', '2023-07-05 01:45:01', '2023-07-05 01:44:48');

-- ----------------------------
-- Table structure for t_family
-- ----------------------------
DROP TABLE IF EXISTS `t_family`;
CREATE TABLE `t_family` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '家族id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `username` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `intro` varchar(500) DEFAULT NULL COMMENT '描述',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='家族';

-- ----------------------------
-- Records of t_family
-- ----------------------------

-- ----------------------------
-- Table structure for t_incident
-- ----------------------------
DROP TABLE IF EXISTS `t_incident`;
CREATE TABLE `t_incident` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '事件id',
  `memberr` varchar(255) DEFAULT NULL COMMENT '成员',
  `memberrid` int DEFAULT NULL COMMENT '成员id',
  `eventdescription` varchar(500) DEFAULT NULL COMMENT '描述',
  `family` varchar(255) DEFAULT NULL COMMENT '家族',
  `familyid` int DEFAULT NULL COMMENT '家族id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='人员事件';

-- ----------------------------
-- Records of t_incident
-- ----------------------------

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '成员id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `family` varchar(255) DEFAULT NULL COMMENT '家族',
  `familyid` int DEFAULT NULL COMMENT '家族id',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `birthday` varchar(255) DEFAULT NULL COMMENT '生日',
  `father` varchar(255) DEFAULT NULL COMMENT '父亲',
  `fatherid` int DEFAULT NULL COMMENT '父亲id',
  `mother` varchar(255) DEFAULT NULL COMMENT '母亲',
  `motherid` int DEFAULT NULL COMMENT '母亲id',
  `spouses` varchar(255) DEFAULT NULL COMMENT '配偶',
  `spousesid` int DEFAULT NULL COMMENT '配偶id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='家庭成员';

-- ----------------------------
-- Records of t_member
-- ----------------------------
