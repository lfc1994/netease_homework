/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : lfc

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 17/03/2019 15:20:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(40) NULL DEFAULT NULL,
  `pid` int(40) NULL DEFAULT NULL,
  `number` int(40) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `datetime` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (51, 4, 18, 3, 111.00, '2019-03-15 22:04:52.256000');
INSERT INTO `account` VALUES (52, 4, 19, 6, 222.00, '2019-03-15 22:18:42.708000');
INSERT INTO `account` VALUES (53, 4, 20, 1, 333.00, '2019-03-15 22:21:13.896000');
INSERT INTO `account` VALUES (54, 4, 21, 1, 777.00, '2019-03-15 22:21:13.944000');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `subTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `originalPrice` decimal(10, 2) UNSIGNED NULL DEFAULT 0.00,
  `nowPrice` decimal(10, 2) UNSIGNED NULL DEFAULT 0.00,
  `stock` int(11) UNSIGNED NULL DEFAULT 0,
  `imgid` int(11) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `commentCount` int(11) UNSIGNED NULL DEFAULT 0,
  `saleCount` int(11) UNSIGNED NULL DEFAULT 0,
  `deleteAt` datetime(0) NULL DEFAULT NULL,
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_product_product_image`(`imgid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (18, 'name1', NULL, NULL, 111.00, NULL, NULL, NULL, NULL, NULL, NULL, '111111', 'file', '1.jpg', '大叔大婶多');
INSERT INTO `product` VALUES (19, 'name2', NULL, NULL, 222.00, NULL, NULL, NULL, NULL, NULL, NULL, '222222', 'file', '2.jpg', '将规划局规划');
INSERT INTO `product` VALUES (20, 'name3编', NULL, 3.00, 4.00, NULL, NULL, NULL, NULL, NULL, NULL, '3333编', 'file', '3.jpg', '阿萨德发给（）编');
INSERT INTO `product` VALUES (21, 'name7', NULL, NULL, 777.00, NULL, NULL, NULL, NULL, NULL, NULL, '大叔大婶多', 'file', '7.jpg', 'Asdasdgfhghkl');
INSERT INTO `product` VALUES (22, 'name6', NULL, NULL, 666.00, NULL, NULL, NULL, NULL, NULL, NULL, '大声道', 'file', '6.jpg', '奥术大师大所大所多');
INSERT INTO `product` VALUES (23, 'XXXX', NULL, NULL, 213.11, NULL, NULL, NULL, NULL, NULL, NULL, 'Asdasd', 'file', '4.jpg', '规划局规划局客观环境');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `group_` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'user',
  `deleteAt` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 'seller', '981c57a5cfb0f868e064904b8745766f', 'superAdmin', NULL);
INSERT INTO `user` VALUES (4, 'buyer', '37254660e226ea65ce6f1efd54233424', 'user', NULL);

SET FOREIGN_KEY_CHECKS = 1;
