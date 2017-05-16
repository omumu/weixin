/*
Navicat MySQL Data Transfer

Source Server         : mumu
Source Server Version : 50633
Source Host           : 115.159.96.173:3306
Source Database       : mt

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2017-05-16 09:16:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for schoole_doctor
-- ----------------------------
DROP TABLE IF EXISTS `schoole_doctor`;
CREATE TABLE `schoole_doctor` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `school_id` int(10) DEFAULT NULL,
  `doctor_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schoole_doctor
-- ----------------------------

-- ----------------------------
-- Table structure for tb_banner
-- ----------------------------
DROP TABLE IF EXISTS `tb_banner`;
CREATE TABLE `tb_banner` (
  `banner_id` int(10) NOT NULL AUTO_INCREMENT,
  `banner_url` varchar(50) DEFAULT NULL,
  `school_id` int(10) NOT NULL,
  PRIMARY KEY (`banner_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_banner
-- ----------------------------
INSERT INTO `tb_banner` VALUES ('2', 'http://onqqb41kz.bkt.clouddn.com/timg.jpg', '11');
INSERT INTO `tb_banner` VALUES ('3', 'http://onqqb41kz.bkt.clouddn.com/timg.jpg', '12');
INSERT INTO `tb_banner` VALUES ('4', 'http://onqqb41kz.bkt.clouddn.com/timg.jpg', '13');
INSERT INTO `tb_banner` VALUES ('5', 'http://onqqb41kz.bkt.clouddn.com/timg.jpg', '14');
INSERT INTO `tb_banner` VALUES ('6', 'http://onqqb41kz.bkt.clouddn.com/timg.jpg', '15');
INSERT INTO `tb_banner` VALUES ('7', 'http://onqqb41kz.bkt.clouddn.com/timg.jpg', '16');
INSERT INTO `tb_banner` VALUES ('8', 'http://onqqb41kz.bkt.clouddn.com/timg.jpg', '17');

-- ----------------------------
-- Table structure for tb_doctor
-- ----------------------------
DROP TABLE IF EXISTS `tb_doctor`;
CREATE TABLE `tb_doctor` (
  `doctor_id` int(10) NOT NULL AUTO_INCREMENT,
  `doctor_name` varchar(20) DEFAULT NULL,
  `doctor_level` int(10) DEFAULT NULL COMMENT '1--专家 0--普通',
  `doctor_sex` int(10) DEFAULT NULL COMMENT '1-man 0-girl',
  `doctor_price` decimal(10,0) DEFAULT NULL,
  `dacotor_data` date DEFAULT NULL,
  `doctor_photo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_doctor
-- ----------------------------
INSERT INTO `tb_doctor` VALUES ('2', '刘云', '0', '1', '10', '2017-05-10', 'http://onqqb41kz.bkt.clouddn.com/0eb30f2442a7d93389d8712ca54bd11373f00178.jpg');
INSERT INTO `tb_doctor` VALUES ('11', '朱军', '1', '1', '20', '2017-05-10', 'http://ooydrld9b.bkt.clouddn.com/3-15052Q40FN53.jpg');
INSERT INTO `tb_doctor` VALUES ('12', '刘华', '1', '0', '20', '2017-05-10', 'http://ooydrld9b.bkt.clouddn.com/d1.jpg');
INSERT INTO `tb_doctor` VALUES ('14', '范明', '1', '0', '20', '2017-05-10', 'http://ooydrld9b.bkt.clouddn.com/d3.jpg');
INSERT INTO `tb_doctor` VALUES ('15', '刘生', '0', '0', '10', '2017-05-10', 'http://ooydrld9b.bkt.clouddn.com/d4.jpg');
INSERT INTO `tb_doctor` VALUES ('16', '周文', '1', '0', '20', '2017-05-10', 'http://ooydrld9b.bkt.clouddn.com/d5.jpg');
INSERT INTO `tb_doctor` VALUES ('17', '许华', '1', '1', '20', '2017-05-10', 'http://ooydrld9b.bkt.clouddn.com/d6.jpg');

-- ----------------------------
-- Table structure for tb_question
-- ----------------------------
DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `question` varchar(1000) DEFAULT NULL,
  `answer` varchar(1000) DEFAULT NULL,
  `statusint` int(10) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_question
-- ----------------------------
INSERT INTO `tb_question` VALUES ('1', '口腔发炎了怎么办？', '议你口服葡萄糖酸锌，或者同时服用维生素b 。平常一定要多喝水。 多吃蔬菜。不要吃味精鸡精，因为这回造成锌的排除增加。因为它们有可能导致锌的排除增加。锌的缺乏几会导致这个病。', '1');
INSERT INTO `tb_question` VALUES ('2', '感冒了怎么办？', '感冒重在预防，隔离传染源有助于避免传染。加强锻炼、增强体质、生活饮食规律、改善营养。避免受凉和过度劳累，有助于降低易感性，是预防上呼吸道感染最好的方法。', '1');
INSERT INTO `tb_question` VALUES ('3', '咳嗽怎么办？', '喝水有助于新陈代谢，特别是秋天，气候干燥，喝水可以润润呼吸道。但是不要喝冷水，也不能喝太烫的水，对呼吸道都有刺激作用，温水最好。', '1');
INSERT INTO `tb_question` VALUES ('4', '鼻炎很严重怎么办？', '苍耳子30克，轻轻捣烂放入小勺内，加香油50克火煎，将苍耳子碎渣捞出，用油滴鼻子，一天3至5次。', '1');

-- ----------------------------
-- Table structure for tb_regis
-- ----------------------------
DROP TABLE IF EXISTS `tb_regis`;
CREATE TABLE `tb_regis` (
  `regis_id` int(10) NOT NULL AUTO_INCREMENT,
  `regis_name` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL,
  `regis_status` int(11) DEFAULT '0',
  PRIMARY KEY (`regis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_regis
-- ----------------------------
INSERT INTO `tb_regis` VALUES ('1', '妇科', '0');
INSERT INTO `tb_regis` VALUES ('2', '眼科', '0');
INSERT INTO `tb_regis` VALUES ('3', '消化内科', '0');
INSERT INTO `tb_regis` VALUES ('4', '耳鼻喉科', '0');
INSERT INTO `tb_regis` VALUES ('5', '神经内科', '0');
INSERT INTO `tb_regis` VALUES ('6', '骨科', '0');
INSERT INTO `tb_regis` VALUES ('7', '内分泌科', '0');
INSERT INTO `tb_regis` VALUES ('8', '小儿科', '0');
INSERT INTO `tb_regis` VALUES ('9', '乳腺科', '0');
INSERT INTO `tb_regis` VALUES ('10', '呼吸内科', '0');
INSERT INTO `tb_regis` VALUES ('11', '泌尿外科', '0');
INSERT INTO `tb_regis` VALUES ('12', '心血管内科', '0');
INSERT INTO `tb_regis` VALUES ('13', '肝胆外科', '0');
INSERT INTO `tb_regis` VALUES ('14', '中医药结合科', '0');
INSERT INTO `tb_regis` VALUES ('15', '普通外科', '0');
INSERT INTO `tb_regis` VALUES ('16', '肾脏外科', '0');
INSERT INTO `tb_regis` VALUES ('17', '口腔科', '0');
INSERT INTO `tb_regis` VALUES ('18', '神经外科', '0');
INSERT INTO `tb_regis` VALUES ('19', '心理科', '0');
INSERT INTO `tb_regis` VALUES ('20', '血液科', '0');
INSERT INTO `tb_regis` VALUES ('21', '肿瘤科', '0');
INSERT INTO `tb_regis` VALUES ('22', '整形外科', '0');
INSERT INTO `tb_regis` VALUES ('23', '烧伤科', '0');
INSERT INTO `tb_regis` VALUES ('24', '胸外科', '0');
INSERT INTO `tb_regis` VALUES ('25', '疼痛科', '0');
INSERT INTO `tb_regis` VALUES ('26', '门诊科', '0');
INSERT INTO `tb_regis` VALUES ('27', '发热门诊', '0');

-- ----------------------------
-- Table structure for tb_regis_doctor
-- ----------------------------
DROP TABLE IF EXISTS `tb_regis_doctor`;
CREATE TABLE `tb_regis_doctor` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `regis_id` int(10) DEFAULT NULL,
  `doctor_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_regis_doctor
-- ----------------------------
INSERT INTO `tb_regis_doctor` VALUES ('1', '1', '12');
INSERT INTO `tb_regis_doctor` VALUES ('2', '1', '2');
INSERT INTO `tb_regis_doctor` VALUES ('3', '2', '2');
INSERT INTO `tb_regis_doctor` VALUES ('4', '2', '13');
INSERT INTO `tb_regis_doctor` VALUES ('5', '2', '14');
INSERT INTO `tb_regis_doctor` VALUES ('6', '1', '18');
INSERT INTO `tb_regis_doctor` VALUES ('7', '3', '12');
INSERT INTO `tb_regis_doctor` VALUES ('8', '4', '16');
INSERT INTO `tb_regis_doctor` VALUES ('9', '5', '13');
INSERT INTO `tb_regis_doctor` VALUES ('10', '5', '2');
INSERT INTO `tb_regis_doctor` VALUES ('11', '6', '16');
INSERT INTO `tb_regis_doctor` VALUES ('12', '7', '17');
INSERT INTO `tb_regis_doctor` VALUES ('13', '8', '15');
INSERT INTO `tb_regis_doctor` VALUES ('14', '8', '12');
INSERT INTO `tb_regis_doctor` VALUES ('15', '9', '14');
INSERT INTO `tb_regis_doctor` VALUES ('16', '9', '16');
INSERT INTO `tb_regis_doctor` VALUES ('17', '10', '12');
INSERT INTO `tb_regis_doctor` VALUES ('18', '1', '15');
INSERT INTO `tb_regis_doctor` VALUES ('19', '1', '16');
INSERT INTO `tb_regis_doctor` VALUES ('20', '1', '13');
INSERT INTO `tb_regis_doctor` VALUES ('21', '1', '17');

-- ----------------------------
-- Table structure for tb_school
-- ----------------------------
DROP TABLE IF EXISTS `tb_school`;
CREATE TABLE `tb_school` (
  `school_id` int(10) NOT NULL AUTO_INCREMENT,
  `schoole_name` varchar(100) NOT NULL,
  `school_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_school
-- ----------------------------
INSERT INTO `tb_school` VALUES ('11', '重庆邮电大学', 'http://ooydrld9b.bkt.clouddn.com/重邮.jpg');
INSERT INTO `tb_school` VALUES ('12', '重庆工商大学', 'http://ooydrld9b.bkt.clouddn.com/u=3752518865,1145397496&fm=23&gp=0.jpg');
INSERT INTO `tb_school` VALUES ('13', '北京大学', 'http://ooydrld9b.bkt.clouddn.com/北京.jpg');
INSERT INTO `tb_school` VALUES ('14', '清华大学', 'http://ooydrld9b.bkt.clouddn.com/清华.jpg');
INSERT INTO `tb_school` VALUES ('15', '四川大学', 'http://ooydrld9b.bkt.clouddn.com/四川.jpg');
INSERT INTO `tb_school` VALUES ('16', '西南大学', 'http://ooydrld9b.bkt.clouddn.com/西南大学.jpg');
INSERT INTO `tb_school` VALUES ('17', '重庆大学', 'http://ooydrld9b.bkt.clouddn.com/重大.jpg');
INSERT INTO `tb_school` VALUES ('18', '重庆理工大学', 'http://ooydrld9b.bkt.clouddn.com/重理.jpg');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(50) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_sex` varchar(10) DEFAULT NULL,
  `user_openid` varchar(50) DEFAULT NULL,
  `user_headimgurl` varchar(1000) DEFAULT NULL,
  `user_registertime` datetime DEFAULT NULL,
  `user_money` varchar(10) DEFAULT '100',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('10', 'Book', '1', 'oQW_Xwzndd4_l1OhukU2Gw5btBkQ', 'http://wx.qlogo.cn/mmopen/aSAT3bAVvnEWzv7WWjdibdPDjJTkv8ac3HUTvJQCibYz9z3yKYIMB6n9VoTUp93myAaVGbNibEP6gv2Mf3FCqqInwkTgibJicCDa2/0', '2017-04-20 23:53:58', '100');
INSERT INTO `tb_user` VALUES ('26', 'Essential', '1', 'oQW_Xw16xlExXewh3WlWaZFvpszQ', 'http://wx.qlogo.cn/mmopen/XOYbZuibTnr3sKVC5rzq5EAkJxGrgKLX1WceibpuxhNj8diahhQtUeYfTAJurOEKtGAvvfLjFup9uJdhjSOwO7nsMrupl4UjIJb/0', '2017-04-21 15:23:14', '100');
INSERT INTO `tb_user` VALUES ('31', 'joe', '1', 'oQW_Xw_meA0cryoMIFgLqNwfB1fU', 'http://wx.qlogo.cn/mmopen/nqrmwU2urLAJTSqbibYVfeLFqcRaWB2CYwiaB4fMzBh63jAGu5mG7p2ibLhg9qwYzONA0IIialzI9rjrqvXIicjwsG7jt2eULZzsv/0', '2017-04-21 19:26:49', '100');
INSERT INTO `tb_user` VALUES ('44', '李皓轩', '1', 'oQW_Xw8ErL1Rqpqgp9X6KPK1KTrc', 'http://wx.qlogo.cn/mmopen/pZzKhjemnGPaIQFfksrwF5eibgMhSiarg7bmq5Biclh9qbBVibRbg8lqYIcQww9O8Kqrgrian0dPLKOOtvWvI1TaicDeNXbTAIUVzz/0', '2017-04-22 19:26:33', '80');
INSERT INTO `tb_user` VALUES ('73', 'stan', '1', 'oQW_Xw-UIzIBfpKeH7wcHlIoYs2Y', 'http://wx.qlogo.cn/mmopen/fFgUJknhibCzPvgd152J9RDAhcqaJcNdAqlwwJIa2Q3hebyuxQzsFib3wDxPr2yr14gyUSqfBJHmibtlshnMjgicia7fKu8HpXXGh/0', '2017-05-05 11:58:53', '90');
INSERT INTO `tb_user` VALUES ('74', '王科皓', '1', 'oQW_Xw4TQlfe3sX721zOXZBFPUGY', 'http://wx.qlogo.cn/mmopen/j2pu8LBvdI2ibzfD8DhXpHZTejEmRJCIxCVVwJ6l1xXfIhAA46XFWJWt6EAr7E5UdvAAFUcLFicKRd9kticv4J8ibTy4esNc3dAS/0', '2017-05-05 12:02:47', '100');
INSERT INTO `tb_user` VALUES ('77', '木木', '1', 'oQW_Xw7AvlkcRbZbb8AyI9C3DhVs', 'http://wx.qlogo.cn/mmopen/aSAT3bAVvnFlMA0q33V24XJNuxGrUy6UuS6ITog60RbQOvEAzch7bCIvmM7BonEKlATDCfQOUVhKV6GVtSphNjx7yyVmO5WG/0', '2017-05-05 14:07:01', '60');
INSERT INTO `tb_user` VALUES ('87', 'LAVENDER', '2', 'oQW_Xw93-Is4Lx_Mf9Jn2mQTiu7M', 'http://wx.qlogo.cn/mmopen/Q3auHgzwzM4y1yTOicAR03a7zAGyxrMibJcK4LBlDe3Mcwy1LPvBhzqpvkticPYickicICOXoemmSC3ukTYZ7SNpMmSHv33Ql0bqunD7Gpy0eDdk/0', '2017-05-07 14:43:36', '100');
INSERT INTO `tb_user` VALUES ('104', null, null, null, null, '2017-05-14 18:22:03', '100');
INSERT INTO `tb_user` VALUES ('105', null, null, null, null, '2017-05-14 20:44:25', '100');

-- ----------------------------
-- Table structure for tb_user_school
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_school`;
CREATE TABLE `tb_user_school` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `schoolid` int(10) DEFAULT NULL,
  `userid` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_school
-- ----------------------------
INSERT INTO `tb_user_school` VALUES ('21', '13', 'oQW_Xw7AvlkcRbZbb8AyI9C3DhVs');
INSERT INTO `tb_user_school` VALUES ('22', '14', 'oQW_Xw93-Is4Lx_Mf9Jn2mQTiu7M');

-- ----------------------------
-- Table structure for tb_vis
-- ----------------------------
DROP TABLE IF EXISTS `tb_vis`;
CREATE TABLE `tb_vis` (
  `vis_id` int(10) NOT NULL AUTO_INCREMENT,
  `vis_name` varchar(100) DEFAULT NULL,
  `vis_data` datetime DEFAULT NULL,
  `vis_phone` varchar(50) DEFAULT NULL,
  `regis_name` varchar(100) DEFAULT NULL,
  `vis_doctor` varchar(100) DEFAULT NULL,
  `regis_status` int(10) DEFAULT '1',
  `vis_school` int(100) DEFAULT NULL,
  PRIMARY KEY (`vis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_vis
-- ----------------------------
INSERT INTO `tb_vis` VALUES ('30', '高林', '2017-05-10 00:00:00', '15023359003', '眼科', '范明(专家)', '1', '13');
