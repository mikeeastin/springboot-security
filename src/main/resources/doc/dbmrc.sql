/*
MySQL Data Transfer
Source Host: localhost
Source Database: dbgril
Target Host: localhost
Target Database: dbgril
Date: 2017-09-03 0:14:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for book
-- ----------------------------
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) DEFAULT NULL,
  `reader` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for city
-- ----------------------------
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for reader
-- ----------------------------
CREATE TABLE `reader` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for spitter
-- ----------------------------
CREATE TABLE `spitter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `city` VALUES ('1', '1', '温岭市', 'BYSocket 的家在温岭。');
INSERT INTO `reader` VALUES ('1', '1');
INSERT INTO `reader` VALUES ('aaa', 'aaa');
INSERT INTO `reader` VALUES ('bbb', 'bbb');
INSERT INTO `reader` VALUES ('xiaomai', 'xxx');
INSERT INTO `spitter` VALUES ('1', null, null);
INSERT INTO `spitter` VALUES ('2', null, null);
INSERT INTO `spitter` VALUES ('3', null, null);
INSERT INTO `spitter` VALUES ('4', null, null);
INSERT INTO `spitter` VALUES ('5', null, null);
INSERT INTO `spitter` VALUES ('6', null, null);
INSERT INTO `spitter` VALUES ('7', null, null);
INSERT INTO `spitter` VALUES ('8', null, null);
INSERT INTO `spitter` VALUES ('9', null, null);
INSERT INTO `spitter` VALUES ('10', null, null);
INSERT INTO `spitter` VALUES ('11', null, null);
INSERT INTO `spitter` VALUES ('12', '33', '55');
