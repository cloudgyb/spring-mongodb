/*
Navicat MySQL Data Transfer

Source Server         : MariaDB
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-02-07 11:47:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `system_log`
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log` (
  `log_id` int(11) NOT NULL,
  `log_level` enum('error','warning','info') DEFAULT NULL,
  `log_content` mediumtext DEFAULT NULL,
  `log_create_time` timestamp NULL DEFAULT NULL ON UPDATE current_timestamp(),
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1fdfsdfd', '1sdffsdfsdffffffffffffff');
INSERT INTO `t_user` VALUES ('2', 'gyb', '3123123243');
INSERT INTO `t_user` VALUES ('3', '4', '4');
INSERT INTO `t_user` VALUES ('5', '5', '5');
INSERT INTO `t_user` VALUES ('6', '6', '6');
INSERT INTO `t_user` VALUES ('7', '耿远博', '2342342424');
INSERT INTO `t_user` VALUES ('8', '8', '8');
INSERT INTO `t_user` VALUES ('9', '9', '9');
INSERT INTO `t_user` VALUES ('10', '10', '10');
INSERT INTO `t_user` VALUES ('11', '11', '11');
INSERT INTO `t_user` VALUES ('12', '12', '12');
