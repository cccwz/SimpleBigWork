/*
 Navicat Premium Data Transfer

 Source Server         : cccwz
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : bigwork

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 11/07/2021 15:20:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键，自增id',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `type` int(0) NOT NULL DEFAULT 1 COMMENT '权限1-用户 0-管理员',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account`(`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, '1806030134', '123456', 0);
INSERT INTO `user` VALUES (4, '1806030135', '123456', 1);

SET FOREIGN_KEY_CHECKS = 1;
