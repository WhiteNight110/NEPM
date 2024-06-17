/*
 Navicat Premium Data Transfer

 Source Server         : wyb
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : nepm

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 17/06/2024 10:43:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admins
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统管理员编号',
  `admin_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统管理员登录编码',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统管理员登录密码',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统管理员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES (1, '123', '123', NULL);
INSERT INTO `admins` VALUES (2, '2', '123', NULL);
INSERT INTO `admins` VALUES (3, '3', '456', NULL);
INSERT INTO `admins` VALUES (4, '4', '456', NULL);

-- ----------------------------
-- Table structure for aqi
-- ----------------------------
DROP TABLE IF EXISTS `aqi`;
CREATE TABLE `aqi`  (
  `aqi_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '空气质量编号',
  `aqi_level` int(11) NOT NULL COMMENT '空气质量指数级别(共六级)',
  `chinese_explain` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '空气质量指数级别汉字表述',
  `aqi_explain` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '空气质量指数级别描述',
  `color` varchar(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '空气质量指数级别表示颜色',
  `health_impact` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '对健康影响情况',
  `take_steps` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '建议采取的措施',
  `so2_min` int(11) NOT NULL COMMENT '本级别二氧化硫浓度最小限值',
  `so2_max` int(11) NOT NULL COMMENT '本级别二氧化硫浓度最大限值',
  `co_min` int(11) NOT NULL COMMENT '本级别一氧化碳浓度最小限值',
  `co_max` int(11) NOT NULL COMMENT '本级别一氧化碳浓度最大限值',
  `spm_min` int(11) NOT NULL COMMENT '本级别悬浮颗粒物浓度最小限值',
  `spm_max` int(11) NOT NULL COMMENT '本级别悬浮颗粒物浓度最大限值',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`aqi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '空气质量指数级别表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of aqi
-- ----------------------------
INSERT INTO `aqi` VALUES (1, 1, 'v阿萨v阿萨', '1', '1', '1', '1', 1, 1, 1, 1, 1, 1, NULL);
INSERT INTO `aqi` VALUES (2, 1, '2', '2', '2', '2', '2', 2, 2, 2, 2, 2, 2, NULL);

-- ----------------------------
-- Table structure for aqi_feedback
-- ----------------------------
DROP TABLE IF EXISTS `aqi_feedback`;
CREATE TABLE `aqi_feedback`  (
  `af_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '空气质量公众监督反馈信息编号',
  `tel_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属公众监督员编号(即手机号码)',
  `province_id` int(11) NOT NULL COMMENT '反馈信息所在省区域编号',
  `city_id` int(11) NOT NULL COMMENT '反馈信息所在市区域编号',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈信息所在区域详细地址',
  `information` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈信息描述',
  `estimated_grade` int(11) NOT NULL COMMENT '反馈者对空气质量指数级别的预估等级',
  `af_date` date NOT NULL COMMENT '反馈日期',
  `af_time` time NOT NULL COMMENT '反馈时间',
  `gm_id` int(11) NOT NULL COMMENT '指派网格员编号',
  `assign_date` date NULL DEFAULT NULL COMMENT '指派日期',
  `assign_time` time NULL DEFAULT NULL COMMENT '指派时间',
  `state` int(11) NOT NULL DEFAULT 0 COMMENT '信息状态\r\n0：未指派\r\n1：已指派\r\n2：已确认',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`af_id`) USING BTREE,
  INDEX `aqi_feedback_ibfk_1`(`tel_id`) USING BTREE,
  INDEX `aqi_feedback_ibfk_2`(`province_id`) USING BTREE,
  INDEX `aqi_feedback_ibfk_3`(`city_id`) USING BTREE,
  INDEX `aqi_feedback_ibfk_4`(`gm_id`) USING BTREE,
  CONSTRAINT `aqi_feedback_ibfk_1` FOREIGN KEY (`tel_id`) REFERENCES `supervisor` (`tel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `aqi_feedback_ibfk_2` FOREIGN KEY (`province_id`) REFERENCES `grid_province` (`province_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `aqi_feedback_ibfk_3` FOREIGN KEY (`city_id`) REFERENCES `grid_city` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `aqi_feedback_ibfk_4` FOREIGN KEY (`gm_id`) REFERENCES `grid_member` (`gm_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '空气质量公众监督反馈表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of aqi_feedback
-- ----------------------------
INSERT INTO `aqi_feedback` VALUES (1, '1', 1, 1, '1', '1', 1, '2024-06-15', '20:02:12', 1, NULL, NULL, 0, NULL);
INSERT INTO `aqi_feedback` VALUES (2, '1', 1, 1, '1', '1', 1, '2024-06-15', '20:09:35', 1, NULL, NULL, 0, NULL);

-- ----------------------------
-- Table structure for grid_city
-- ----------------------------
DROP TABLE IF EXISTS `grid_city`;
CREATE TABLE `grid_city`  (
  `city_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统网格覆盖市区域编号',
  `city_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统网格覆盖市区域名称',
  `province_id` int(11) NOT NULL COMMENT '所属省区域编号',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`city_id`) USING BTREE,
  INDEX `province_id`(`province_id`) USING BTREE,
  CONSTRAINT `grid_city_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `grid_province` (`province_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统网格覆盖市区域表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of grid_city
-- ----------------------------
INSERT INTO `grid_city` VALUES (1, '1', 1, NULL);

-- ----------------------------
-- Table structure for grid_member
-- ----------------------------
DROP TABLE IF EXISTS `grid_member`;
CREATE TABLE `grid_member`  (
  `gm_id` int(11) NOT NULL COMMENT '网格员手机号码',
  `gm_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员名称',
  `gm_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网格员登录编码',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `province_id` int(11) NOT NULL COMMENT '网格区域：省编号',
  `city_id` int(11) NOT NULL COMMENT '网格区域：市编号',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `state` int(11) NOT NULL DEFAULT 0 COMMENT '网格员状态\r\n0：可工作状态\r\n1：临时抽调\r\n2：休假\r\n3：其他',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`gm_id`) USING BTREE,
  INDEX `province_id`(`province_id`) USING BTREE,
  INDEX `city_id`(`city_id`) USING BTREE,
  INDEX `gm_code`(`gm_code`) USING BTREE,
  CONSTRAINT `grid_member_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `grid_province` (`province_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `grid_member_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `grid_city` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '空气质量监测网格员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of grid_member
-- ----------------------------
INSERT INTO `grid_member` VALUES (1, '1', '1', '123', 1, 1, '1', 0, NULL);

-- ----------------------------
-- Table structure for grid_province
-- ----------------------------
DROP TABLE IF EXISTS `grid_province`;
CREATE TABLE `grid_province`  (
  `province_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统网格覆盖省区域编号',
  `province_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统网格覆盖省区域名称',
  `province_abbr` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统网格覆盖省区域简称',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`province_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统网格覆盖省区域表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of grid_province
-- ----------------------------
INSERT INTO `grid_province` VALUES (1, '1', '1', NULL);

-- ----------------------------
-- Table structure for statistics
-- ----------------------------
DROP TABLE IF EXISTS `statistics`;
CREATE TABLE `statistics`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '统计信息编号',
  `province_id` int(11) NOT NULL COMMENT '所属省区域编号',
  `city_id` int(11) NOT NULL COMMENT '所属市区域编号',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈信息所在区域详细地址',
  `so2_value` int(11) NOT NULL COMMENT '实测空气二氧化硫浓度值(单位：μg/m3)',
  `so2_level` int(11) NOT NULL COMMENT '空气二氧化硫指数级别',
  `co_value` int(11) NOT NULL COMMENT '实测空气一氧化碳浓度值(单位：μg/m3)',
  `co_level` int(11) NOT NULL COMMENT '空气一氧化碳指数级别',
  `spm_value` int(11) NOT NULL COMMENT '实测空气悬浮颗粒物浓度值(单位：μg/m3)',
  `spm_level` int(11) NOT NULL COMMENT '空气PM2.5指数级别',
  `aqi_level` int(11) NOT NULL COMMENT '实测空气质量指数级别',
  `confirm_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '确认日期',
  `confirm_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '确认时间',
  `gm_id` int(11) NOT NULL COMMENT '所属网格员编号',
  `fd_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈者编号(公众监督员电话号码)',
  `information` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈信息描述',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `province_id`(`province_id`) USING BTREE,
  INDEX `city_id`(`city_id`) USING BTREE,
  INDEX `aqi_id`(`aqi_level`) USING BTREE,
  INDEX `fd_id`(`fd_id`) USING BTREE,
  INDEX `statistics_ibfk_4`(`gm_id`) USING BTREE,
  CONSTRAINT `statistics_ibfk_1` FOREIGN KEY (`province_id`) REFERENCES `grid_province` (`province_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `statistics_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `grid_city` (`city_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `statistics_ibfk_3` FOREIGN KEY (`aqi_level`) REFERENCES `aqi` (`aqi_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `statistics_ibfk_4` FOREIGN KEY (`gm_id`) REFERENCES `grid_member` (`gm_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `statistics_ibfk_5` FOREIGN KEY (`fd_id`) REFERENCES `supervisor` (`tel_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '空气质量监测数据统计表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of statistics
-- ----------------------------
INSERT INTO `statistics` VALUES (1, 1, 1, '1', 1, 1, 1, 1, 1, 1, 1, '1', '1', 1, '1', '1', NULL);

-- ----------------------------
-- Table structure for supervisor
-- ----------------------------
DROP TABLE IF EXISTS `supervisor`;
CREATE TABLE `supervisor`  (
  `tel_id` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员编号(即手机号码)',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员登录密码',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员真实姓名',
  `birthday` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公众监督员出生日期',
  `sex` int(11) NOT NULL DEFAULT 1 COMMENT '公众监督员性别(1：男；0：女)',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`tel_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公众监督员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of supervisor
-- ----------------------------
INSERT INTO `supervisor` VALUES ('1', '123', '1', '1', 1, NULL);
INSERT INTO `supervisor` VALUES ('2', '111', '111', '111', 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
