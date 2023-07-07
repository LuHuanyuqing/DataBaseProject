/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : patriarchalclan

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 07/07/2023 12:51:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `state` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'tony', '12345', '2023-07-06 18:29:58', '2023-07-06 18:30:27', 1);
INSERT INTO `t_admin` VALUES (3, 'admin', 'admin', '2023-07-06 18:33:59', NULL, 1);

-- ----------------------------
-- Table structure for t_fort
-- ----------------------------
DROP TABLE IF EXISTS `t_fort`;
CREATE TABLE `t_fort`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '家族id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `infoo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `state` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '家族' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_fort
-- ----------------------------
INSERT INTO `t_fort` VALUES (1, '葬爱', 'jerry', '123', '', NULL, '2023-07-06 18:34:52', 1);
INSERT INTO `t_fort` VALUES (2, '龙之家族', 'lone', '123', '', '2023-07-06 18:34:39', NULL, 1);

-- ----------------------------
-- Table structure for t_taste
-- ----------------------------
DROP TABLE IF EXISTS `t_taste`;
CREATE TABLE `t_taste`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '事件id',
  `waterdrop` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成员',
  `waterdropid` int NULL DEFAULT NULL COMMENT '成员id',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `fort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家族',
  `fortid` int NULL DEFAULT NULL COMMENT '家族id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `state` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '成员事件' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_taste
-- ----------------------------

-- ----------------------------
-- Table structure for t_waterdrop
-- ----------------------------
DROP TABLE IF EXISTS `t_waterdrop`;
CREATE TABLE `t_waterdrop`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '成员id',
  `imagee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `fort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家族',
  `fortid` int NULL DEFAULT NULL COMMENT '家族id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `father` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父亲',
  `fatherid` int NULL DEFAULT NULL COMMENT '父亲id',
  `mother` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '母亲',
  `motherid` int NULL DEFAULT NULL COMMENT '母亲id',
  `consort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配偶',
  `consortid` int NULL DEFAULT NULL COMMENT '配偶id',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `state` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '家庭成员' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_waterdrop
-- ----------------------------
INSERT INTO `t_waterdrop` VALUES (1, '2023/7/sliver20230707101919383.jpg', '龙之家族', 2, '李虎', '男', '1976-10-02', '', NULL, '', NULL, '', NULL, '2023-07-07 10:19:35', NULL, 1);
INSERT INTO `t_waterdrop` VALUES (2, '2023/7/sliver20230707102046802.jpg', '龙之家族', 2, '李渊', '男', '1979-12-15', '李虎', 1, '', NULL, '', NULL, '2023-07-07 10:21:12', NULL, 1);
INSERT INTO `t_waterdrop` VALUES (3, '2023/7/sliver20230707104653442.jpg', '龙之家族', 2, '李建成', '男', '1984-12-03', '李渊', 2, '', NULL, '', NULL, '2023-07-07 10:47:26', NULL, 1);
INSERT INTO `t_waterdrop` VALUES (4, '2023/7/sliver20230707104807125.jpg', '龙之家族', 2, '李世民', '男', '1986-04-26', '李渊', 2, '', NULL, '', NULL, '2023-07-07 10:48:23', NULL, 1);
INSERT INTO `t_waterdrop` VALUES (5, '2023/7/sliver20230707104844116.jpg', '龙之家族', 2, '李元吉', '男', '1988-05-04', '李渊', 2, '', NULL, '', NULL, '2023-07-07 10:49:07', NULL, 1);
INSERT INTO `t_waterdrop` VALUES (6, '2023/7/sliver20230707104927665.webp', '龙之家族', 2, '李元霸', '男', '1989-09-25', '李渊', 2, '', NULL, '', NULL, '2023-07-07 10:49:48', NULL, 1);
INSERT INTO `t_waterdrop` VALUES (7, '2023/7/sliver20230707105204736.jpg', '龙之家族', 2, '李承乾', '男', '1991-10-27', '李世民', 4, '', NULL, '', NULL, '2023-07-07 10:50:42', '2023-07-07 10:52:07', 1);
INSERT INTO `t_waterdrop` VALUES (8, '2023/7/sliver20230707105106628.jpg', '龙之家族', 2, '李泰', '男', '1994-01-09', '李世民', 4, '', NULL, '', NULL, '2023-07-07 10:51:29', NULL, 1);
INSERT INTO `t_waterdrop` VALUES (9, '2023/7/sliver20230707105217150.jpg', '龙之家族', 2, '李治', '男', '1996-08-15', '李世民', 4, '', NULL, '武曌', 11, '2023-07-07 10:52:36', '2023-07-07 11:00:46', 1);
INSERT INTO `t_waterdrop` VALUES (11, '2023/7/sliver20230707105537355.jpg', '龙之家族', 2, '武曌', '女', '1999-12-27', '', NULL, '', NULL, '李治', 9, '2023-07-07 10:56:03', NULL, 1);
INSERT INTO `t_waterdrop` VALUES (12, '2023/7/sliver20230707105623121.jpg', '龙之家族', 2, '李显', '男', '2003-04-30', '李治', 9, '武曌', 11, '', NULL, '2023-07-07 10:56:55', '2023-07-07 11:03:29', 1);
INSERT INTO `t_waterdrop` VALUES (14, '2023/7/sliver20230707110128652.jpg', '龙之家族', 2, '李隆基', '男', '2006-03-26', '李显', 12, '', NULL, '', NULL, '2023-07-07 11:01:50', NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
