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

 Date: 11/07/2021 15:20:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '项目id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目类型',
  `stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目阶段',
  `organization_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '施工单位（光伏区）',
  `organization_pressure` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '施工单位（升压站）',
  `date` date NULL DEFAULT NULL COMMENT 'xxxx年xx月',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '虎悦通忻州市忻府区一期5万千瓦光伏发电项目', '平地光伏', '初设', '信息产业电子第十一设计研究院科技工程股份有限公司（无锡）', '信息产业电子第十一设计研究院科技工程股份有限公司（无锡）', '2021-06-23');
INSERT INTO `project` VALUES (2, '黄龙县三岔镇10万千瓦平价上网光伏发电项目', '山地光伏', '可研', '西安隆基清洁能源有限公司', '西安隆基清洁能源有限公司', '2020-09-01');
INSERT INTO `project` VALUES (3, '阳山县阳光黎埠90MW农光互补发电项目', '山顶光伏', '可研', '河北筑能工程技术有限公司', '河北筑能工程技术有限公司', '2020-09-11');
INSERT INTO `project` VALUES (6, '阳山阳光江英50MW农光互补光伏发电项目', '待定', '待定', '', '', '2020-09-08');
INSERT INTO `project` VALUES (7, 'chenweizhen', '山顶光伏', '初设', '信息产业电子第十一设计研究院科技工程股份有限公司（无锡）', '河北筑能工程技术有限公司', '2021-07-30');

SET FOREIGN_KEY_CHECKS = 1;
