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

 Date: 11/07/2021 15:20:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for location
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '场址id',
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该场址上的项目名称',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市',
  `county` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置',
  `feature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '特征',
  `capcity` double(10, 5) NULL DEFAULT NULL COMMENT '安装容量',
  `area` double(10, 5) NULL DEFAULT NULL COMMENT '用地面积',
  `height` int(0) NULL DEFAULT NULL COMMENT '海拔高度',
  `longitude` double(10, 5) NULL DEFAULT NULL COMMENT '经度',
  `latitude` double(10, 5) NULL DEFAULT NULL COMMENT '纬度',
  `radiation` double(10, 5) NULL DEFAULT NULL COMMENT '水平太阳辐射',
  `angle` int(0) NULL DEFAULT NULL COMMENT '最佳辐射量倾角',
  `avg_t` double(10, 5) NULL DEFAULT NULL COMMENT '平均温度',
  `max_t` double(10, 5) NULL DEFAULT NULL COMMENT '最高温度',
  `min_t` double(10, 5) NULL DEFAULT NULL COMMENT '最低温度',
  `depth` double(10, 5) NULL DEFAULT NULL COMMENT '多年最大冻土深度',
  `avg_windspeed` double(10, 5) NULL DEFAULT NULL COMMENT '多年平均风速',
  `max_windspeed` double(10, 5) NULL DEFAULT NULL COMMENT '多年极大风速',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `project_name`(`project_name`) USING BTREE,
  INDEX `p_c_c`(`province`, `city`, `county`) USING BTREE,
  CONSTRAINT `project_name` FOREIGN KEY (`project_name`) REFERENCES `project` (`name`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of location
-- ----------------------------
INSERT INTO `location` VALUES (1, '虎悦通忻州市忻府区一期5万千瓦光伏发电项目', '山西', '忻州市', '忻府区', '山西省忻州市忻府区豆罗镇', NULL, 55.01925, 1645.90000, 1100, 112.64000, 38.32000, 5394.96000, 33, 8.70000, 42.20000, -30.00000, 109.00000, 2.70000, 31.00000);
INSERT INTO `location` VALUES (3, '黄龙县三岔镇10万千瓦平价上网光伏发电项目', '陕西', '延安市', '黄龙县', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `location` VALUES (9, '阳山阳光江英50MW农光互补光伏发电项目', '广东', '清远市', '阳山县', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `location` VALUES (10, 'chenweizhen', '重庆', '市辖区', '万州区', 'sss', '', 111.00000, 111.00000, 1111, 111.00000, 11.00000, NULL, NULL, 11.00000, 111.00000, 1.00000, 11.00000, 11.00000, 1111.00000);

SET FOREIGN_KEY_CHECKS = 1;
