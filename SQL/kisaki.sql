/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : kisaki

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-04-20 17:06:21
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
-- Table structure for `t_img`
-- ----------------------------
DROP TABLE IF EXISTS `t_img`;
CREATE TABLE `t_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `img_name` varchar(50) NOT NULL,
  `img_context` varchar(255) DEFAULT NULL,
  `img_have_seen` int(11) DEFAULT NULL,
  `img_have_collected` int(11) DEFAULT NULL,
  `img_url` varchar(50) NOT NULL,
  `img_push_date` date DEFAULT NULL,
  `img_size` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_img
-- ----------------------------
INSERT INTO `t_img` VALUES ('1', '1', 'wusaki', '鐧惧悎鍏?, '2', '2', '../image/img01.jpg', null, '0.6866667');
INSERT INTO `t_img` VALUES ('2', '2', 'rori', '钀濊帀', null, '5', '../image/img02.jpg', null, '1');
INSERT INTO `t_img` VALUES ('3', '3', 'gumdamu', '楂樿揪', null, '4', '../image/img03.jpg', null, '1.41176471');
INSERT INTO `t_img` VALUES ('4', '1', 'guojiadui', '濂充富', '5', '3', '../image/img04.jpg', null, '1.61290323');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USER_ID` int(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(20) DEFAULT NULL,
  `PASS_WORD_SALT` varchar(50) DEFAULT NULL,
  `USER_LOGO_URL` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'miness', '674833193512b702f69ed1a0e106aa67', '../image/logo01.jpg');
INSERT INTO `t_user` VALUES ('2', 'GGWP', '674833193512b702f69ed1a0e106aa67', '../image/logo02.jpg');
INSERT INTO `t_user` VALUES ('3', 'kisaki', '674833193512b702f69ed1a0e106aa67', '../image/logo03.jpg');

-- ----------------------------
-- Table structure for `t_user_care`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_care`;
CREATE TABLE `t_user_care` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `care_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_care
-- ----------------------------
INSERT INTO `t_user_care` VALUES ('1', '2', '1');
INSERT INTO `t_user_care` VALUES ('2', '3', '1');
INSERT INTO `t_user_care` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for `t_user_fans`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_fans`;
CREATE TABLE `t_user_fans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `fans_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_fans
-- ----------------------------
INSERT INTO `t_user_fans` VALUES ('1', '1', '2');
INSERT INTO `t_user_fans` VALUES ('2', '1', '3');
INSERT INTO `t_user_fans` VALUES ('3', '3', '1');
