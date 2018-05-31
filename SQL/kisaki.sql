/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : kisaki

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-05-31 17:39:58
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
  `PUSH_DATE` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backgroundimg
-- ----------------------------
INSERT INTO `backgroundimg` VALUES ('1', '/image/BG01.jpg', 'xxx', '1', '2018-05-02');
INSERT INTO `backgroundimg` VALUES ('2', '/image/BG02.jpg', 'fff', '2', '2018-05-02');
INSERT INTO `backgroundimg` VALUES ('3', '/image/BG03.jpg', '111111111', '3', '2018-05-02');

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
-- Table structure for `t_anwser`
-- ----------------------------
DROP TABLE IF EXISTS `t_anwser`;
CREATE TABLE `t_anwser` (
  `userId` int(10) NOT NULL,
  `anwserId` int(10) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `imgId` int(10) NOT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `commentId` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_anwser
-- ----------------------------
INSERT INTO `t_anwser` VALUES ('1', '1', 'dasdasdas', '2018-05-30 00:00:00', '5', '1', '3');
INSERT INTO `t_anwser` VALUES ('1', '1', 'sdadasd', '2018-05-27 00:00:00', '5', '2', '4');
INSERT INTO `t_anwser` VALUES ('1', '1', 'afsafasfsaf', '2018-05-31 15:54:24', '5', '3', '3');
INSERT INTO `t_anwser` VALUES ('1', '1', 'asdasdzxczcagag', '2018-05-31 15:54:31', '5', '4', '3');
INSERT INTO `t_anwser` VALUES ('1', '1', 'sadasdzxczxcasdafzxc', '2018-05-31 15:54:38', '5', '5', '3');
INSERT INTO `t_anwser` VALUES ('2', '1', 'DAFSFAF', '2018-05-31 17:15:08', '5', '6', '1');
INSERT INTO `t_anwser` VALUES ('2', '1', 'fasfafsafxzc', '2018-05-31 17:15:27', '5', '7', '3');
INSERT INTO `t_anwser` VALUES ('2', '1', 'fasfszxcxzvzvx', '2018-05-31 17:24:45', '5', '8', '4');

-- ----------------------------
-- Table structure for `t_collect_img`
-- ----------------------------
DROP TABLE IF EXISTS `t_collect_img`;
CREATE TABLE `t_collect_img` (
  `user_id` int(11) NOT NULL,
  `img_id` int(11) NOT NULL,
  `img_user_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_collect_img
-- ----------------------------
INSERT INTO `t_collect_img` VALUES ('1', '5', '1', '16');
INSERT INTO `t_collect_img` VALUES ('1', '6', '1', '17');

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '1', '1', 'xxxx', '2018-04-26');
INSERT INTO `t_comment` VALUES ('2', '1', '2', 'fuck u', '2018-04-27');
INSERT INTO `t_comment` VALUES ('3', '5', '1', '撒旦撒旦', '2018-05-21');
INSERT INTO `t_comment` VALUES ('4', '5', '1', '飒沓撒爱上', '2018-05-21');
INSERT INTO `t_comment` VALUES ('5', '5', '2', 'afassafzxczxc', '2018-05-31');

-- ----------------------------
-- Table structure for `t_history`
-- ----------------------------
DROP TABLE IF EXISTS `t_history`;
CREATE TABLE `t_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `img_id` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_history
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
  `push_date` date NOT NULL,
  `img_size` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_img
-- ----------------------------
INSERT INTO `t_img` VALUES ('2', '2', 'rori', '萝莉', '2', '0', '../image/img02.jpg', '2018-05-02', '1');
INSERT INTO `t_img` VALUES ('3', '3', 'gumdamu', '高达', '2', '0', '../image/img03.jpg', '2018-04-29', '1.41176471');
INSERT INTO `t_img` VALUES ('4', '1', '图片', null, '2', null, '..//image/upload/201805141095707.jpeg', '2018-05-21', '1');
INSERT INTO `t_img` VALUES ('5', '1', '图片', null, '2', '1', '..//image/upload/201805141095708.jpeg', '2018-05-21', '1.5');
INSERT INTO `t_img` VALUES ('6', '1', 'sadasd', null, '2', '1', '..//image/upload/201805141101005.jpeg', '2018-05-21', '1');
INSERT INTO `t_img` VALUES ('7', '1', 'sdas ', null, null, null, '..//image/upload/201805142171213.jpeg', '2018-05-22', '1');
INSERT INTO `t_img` VALUES ('8', '1', 'sdas ', null, null, null, '..//image/upload/201805142171214.jpeg', '2018-05-22', '1');
INSERT INTO `t_img` VALUES ('9', '1', 'sadas', null, null, null, '..//image/upload/201805150130210.jpeg', '2018-05-30', '1.6');

-- ----------------------------
-- Table structure for `t_seen_img`
-- ----------------------------
DROP TABLE IF EXISTS `t_seen_img`;
CREATE TABLE `t_seen_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `img_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_seen_img
-- ----------------------------
INSERT INTO `t_seen_img` VALUES ('1', '2', '1');
INSERT INTO `t_seen_img` VALUES ('2', '1', '1');
INSERT INTO `t_seen_img` VALUES ('3', '1', '3');
INSERT INTO `t_seen_img` VALUES ('4', '1', '4');
INSERT INTO `t_seen_img` VALUES ('5', '1', '5');
INSERT INTO `t_seen_img` VALUES ('6', '1', '7');
INSERT INTO `t_seen_img` VALUES ('7', '2', '7');
INSERT INTO `t_seen_img` VALUES ('8', '2', '11');
INSERT INTO `t_seen_img` VALUES ('9', '1', '11');
INSERT INTO `t_seen_img` VALUES ('10', '1', '2');
INSERT INTO `t_seen_img` VALUES ('11', '1', '6');
INSERT INTO `t_seen_img` VALUES ('12', '2', '2');
INSERT INTO `t_seen_img` VALUES ('13', '2', '3');
INSERT INTO `t_seen_img` VALUES ('14', '2', '6');
INSERT INTO `t_seen_img` VALUES ('15', '2', '5');
INSERT INTO `t_seen_img` VALUES ('16', '2', '4');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USER_ID` int(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(20) NOT NULL,
  `PASS_WORD_SALT` varchar(50) NOT NULL,
  `USER_LOGO_URL` varchar(20) NOT NULL DEFAULT '../image/timg.jpg',
  `sex` int(10) DEFAULT NULL,
  `address` varchar(10) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'miness', '674833193512b702f69ed1a0e106aa67', '../image/logo01.jpg', '1', '上海,县,崇明县', '1906-02-28');
INSERT INTO `t_user` VALUES ('2', 'GGWP', '67270d5903c8facd62f49aa2461ad19d', '../image/logo02.jpg', null, null, null);
INSERT INTO `t_user` VALUES ('3', 'kisaki', '674833193512b702f69ed1a0e106aa67', '../image/logo03.jpg', null, null, null);
INSERT INTO `t_user` VALUES ('4', 'QQWW', '13bfbacc1aa9791362820af8f67d3c8a', '../image/timg.jpg', null, null, null);
INSERT INTO `t_user` VALUES ('5', 'czm', '1d9eaec6b5ef7d6afdea06dde856fced', '../image/timg.jpg', null, null, null);

-- ----------------------------
-- Table structure for `t_user_care`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_care`;
CREATE TABLE `t_user_care` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `care_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_care
-- ----------------------------
INSERT INTO `t_user_care` VALUES ('1', '2', '1');
INSERT INTO `t_user_care` VALUES ('2', '3', '1');
INSERT INTO `t_user_care` VALUES ('3', '1', '3');
INSERT INTO `t_user_care` VALUES ('9', '3', '2');
INSERT INTO `t_user_care` VALUES ('10', '1', '2');

-- ----------------------------
-- Table structure for `t_user_context`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_context`;
CREATE TABLE `t_user_context` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `context` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_context
-- ----------------------------
INSERT INTO `t_user_context` VALUES ('1', '1', '2018-05-07', 'xxxxxxxxxxxxx');
INSERT INTO `t_user_context` VALUES ('2', '2', '2018-05-07', 'sssssssssssss');
INSERT INTO `t_user_context` VALUES ('3', '2', '2018-05-10', 'XXXXXXXXX');
INSERT INTO `t_user_context` VALUES ('4', '2', '2018-05-10', 'asdasd');
INSERT INTO `t_user_context` VALUES ('5', '2', '2018-05-10', 'asdasdsad');
INSERT INTO `t_user_context` VALUES ('6', '2', '2018-05-10', 'asdasdsad');
INSERT INTO `t_user_context` VALUES ('7', '2', '2018-05-10', 'adsdaddss');
INSERT INTO `t_user_context` VALUES ('8', '3', '2018-05-11', 'dddddddddd');

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
DROP TRIGGER IF EXISTS `img_collect_tg`;
DELIMITER ;;
CREATE TRIGGER `img_collect_tg` BEFORE INSERT ON `t_collect_img` FOR EACH ROW BEGIN
  
   
   IF EXISTS (SELECT * from t_collect_img WHERE user_id = new.user_id and img_id = new.img_id and img_user_id = new.img_user_id)   then
   DELETE from t_collect_img  where id  = new.id;
   end if;
   
   
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `img_collect_tg2`;
DELIMITER ;;
CREATE TRIGGER `img_collect_tg2` AFTER INSERT ON `t_collect_img` FOR EACH ROW BEGIN
  UPDATE t_img set img_have_collected = (select count(*) from t_collect_img where img_id = new.img_id)
  where id = new.img_id;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `T_SEEN_IMG_tg`;
DELIMITER ;;
CREATE TRIGGER `T_SEEN_IMG_tg` BEFORE INSERT ON `t_seen_img` FOR EACH ROW BEGIN
  
   
   IF EXISTS (SELECT * from T_SEEN_IMG WHERE user_id = new.user_id and img_id = new.img_id )   then
   DELETE from T_SEEN_IMG  where id  = new.id;
   end if;
   
   
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `T_SEEN_IMG_tg2`;
DELIMITER ;;
CREATE TRIGGER `T_SEEN_IMG_tg2` AFTER INSERT ON `t_seen_img` FOR EACH ROW BEGIN
  UPDATE t_img set img_have_seen = (select count(*) from T_SEEN_IMG where img_id = new.img_id)
  where id = new.img_id;
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `InsteadTrigger`;
DELIMITER ;;
CREATE TRIGGER `InsteadTrigger` BEFORE INSERT ON `t_user_care` FOR EACH ROW BEGIN
  
   
   IF EXISTS (SELECT * from t_user_care WHERE user_id = new.user_id and care_id = new.care_id)   then
   DELETE from t_user_care where id  = new.id;
   end if;
   
   
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `fans_tg`;
DELIMITER ;;
CREATE TRIGGER `fans_tg` BEFORE INSERT ON `t_user_fans` FOR EACH ROW BEGIN
  
   
   IF EXISTS (SELECT * from t_user_care WHERE user_id = new.user_id and care_id = new.fans_id)   then
   DELETE from t_user_fans where id  = new.id;
   end if;
   
   
end
;;
DELIMITER ;
