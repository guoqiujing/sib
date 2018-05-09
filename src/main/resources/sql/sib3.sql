/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : sib

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-05-09 16:54:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `answer_sheet`
-- ----------------------------
DROP TABLE IF EXISTS `answer_sheet`;
CREATE TABLE `answer_sheet` (
  `id` varchar(64) NOT NULL COMMENT '答题id',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `question_id` varchar(64) DEFAULT NULL COMMENT '题目id',
  `bank_id` int(11) DEFAULT NULL COMMENT '题目所属题库id',
  `answer` varchar(64) DEFAULT NULL COMMENT '用户的答案',
  `istrue` tinyint(1) NOT NULL COMMENT '用户答案正确性，1正确，0错误',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer_sheet
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `name` varchar(10) DEFAULT NULL COMMENT '类目名称',
  `ord` int(2) DEFAULT NULL COMMENT '设置优先级数字，值越小越优先',
  `parent_id` int(11) DEFAULT '-1' COMMENT '父类目编号，本身为顶级类目，则为-1',
  `parent_ids` varchar(128) DEFAULT NULL COMMENT '父类目编号列表，以/分割',
  `available` tinyint(1) DEFAULT NULL COMMENT '是否可用，0可用，1不可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `choice_question`
-- ----------------------------
DROP TABLE IF EXISTS `choice_question`;
CREATE TABLE `choice_question` (
  `id` varchar(64) NOT NULL COMMENT '题目编号',
  `question` varchar(256) NOT NULL COMMENT '题目',
  `choice_a` varchar(128) NOT NULL COMMENT '选项A',
  `choice_b` varchar(128) NOT NULL COMMENT '选项B',
  `choice_c` varchar(128) DEFAULT NULL COMMENT '选项C',
  `choice_d` varchar(128) DEFAULT NULL COMMENT '选项D',
  `answer` varchar(2) NOT NULL COMMENT '正确答案',
  `analysis` varchar(512) DEFAULT NULL COMMENT '答案解析',
  `star_level` double(6,2) DEFAULT '3.00' COMMENT '星级评价（5分制，默认3分）',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `bank_id` varchar(32) DEFAULT NULL COMMENT '所属题库',
  `status` int(2) DEFAULT '1' COMMENT '题目状态（0：已通过，1：待审核，2：未通过）',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否可用，0可用，1不可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of choice_question
-- ----------------------------

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '资源名称',
  `type` varchar(50) NOT NULL COMMENT '资源类型',
  `url` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '访问url地址',
  `percode` varchar(100) DEFAULT NULL COMMENT '权限代码字符串',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父编号',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '父编号列表',
  `sortstring` int(11) DEFAULT NULL COMMENT '排序顺序',
  `available` tinyint(1) DEFAULT NULL COMMENT '是否可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for `question_bank`
-- ----------------------------
DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE `question_bank` (
  `id` varchar(32) NOT NULL COMMENT '题库编号',
  `title` varchar(32) DEFAULT NULL COMMENT '题库标题',
  `intro` varchar(256) DEFAULT NULL COMMENT '题库介绍',
  `img` varchar(256) DEFAULT NULL COMMENT '题库图片',
  `value` int(11) DEFAULT '0' COMMENT '使用题库所需积分',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户编号',
  `category_name` varchar(50) DEFAULT NULL COMMENT '题库所属类目',
  `frequency` int(11) DEFAULT '0' COMMENT '练习人次',
  `difficulty` double DEFAULT NULL COMMENT '困难程度',
  `star_level` double(6,2) DEFAULT '3.00' COMMENT '星级评价（5分制，默认3分）',
  `status` int(2) DEFAULT '0' COMMENT '题库状态(待用）（0：已通过，1：待审核，2：未通过）',
  `available` tinyint(1) DEFAULT '0' COMMENT '是否可用，0可用，1不可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_bank
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(16) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(128) DEFAULT NULL COMMENT '角色描述',
  `available` tinyint(1) DEFAULT NULL COMMENT '是否可用，0可用，1不可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) NOT NULL COMMENT '用户编号',
  `nickname` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `icon` varchar(256) DEFAULT NULL COMMENT '用户头像',
  `phone` varchar(16) DEFAULT NULL COMMENT '用户手机号码',
  `email` varchar(64) DEFAULT NULL COMMENT '用户电子邮箱',
  `password` varchar(128) NOT NULL COMMENT '用户密码',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',
  `wxid` varchar(128) DEFAULT NULL COMMENT '绑定微信',
  `value` int(11) DEFAULT '100' COMMENT '用户积分',
  `locked` tinyint(1) DEFAULT '0' COMMENT '用户是否被锁定，锁定后则不能登录(1:被锁定，0：不被锁定）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(128) COLLATE utf8_bin NOT NULL,
  `user_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `role_name` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user_role
-- ----------------------------
