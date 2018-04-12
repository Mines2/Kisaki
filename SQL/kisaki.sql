/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : kisaki

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-04-12 16:46:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `backgroundimg`
-- ----------------------------
DROP TABLE IF EXISTS `backgroundimg`;
CREATE TABLE `backgroundimg` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `IMG_URL` varchar(50) NOT NULL,
  `IMG_NAME` varchar(20) NOT NULL,
  `USER_ID` int(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backgroundimg
-- ----------------------------
INSERT INTO `backgroundimg` VALUES ('1', '/image/BG01.jpg', 'xxx', '1');
INSERT INTO `backgroundimg` VALUES ('2', '/image/BG02.jpg', 'fff', '2');
INSERT INTO `backgroundimg` VALUES ('3', '/image/BG03.jpg', '111111111', '3');

-- ----------------------------
-- Table structure for `people`
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `reg_time` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sw73blrfiqs1etfk8qecdieyx` (`email`),
  UNIQUE KEY `UK_ljcbqfi9caelw9nrlgalu06cv` (`password`),
  UNIQUE KEY `UK_t8viugbnk0oph90rxmmdjlcsi` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USER_ID` int(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(20) DEFAULT NULL,
  `PASS_WARD_SALT` varchar(20) DEFAULT NULL,
  `USER_LOGO_URL` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'miness', null, '../image/logo01.jpg');
INSERT INTO `t_user` VALUES ('2', 'GGWP', null, '../image/logo02.jpg');
INSERT INTO `t_user` VALUES ('3', 'kisaki', null, '../image/logo03.jpg');
