/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-04-10 22:38:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '库存数量',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开启时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`activity_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8 COMMENT='库存';

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1005', '1000元秒杀iPad', '100', '2018-12-31 00:00:00', '2019-01-01 00:00:00', '2018-05-12 16:03:57');
INSERT INTO `activity` VALUES ('1006', '1000元秒杀iPhone7', '200', '2018-12-31 00:00:00', '2019-01-01 00:00:00', '2018-05-12 16:03:57');
INSERT INTO `activity` VALUES ('1007', '1000元秒杀红米note', '300', '2018-12-31 00:00:00', '2019-01-01 00:00:00', '2018-05-12 16:03:57');
INSERT INTO `activity` VALUES ('1008', '1000元秒杀macbook pro', '10', '2018-12-31 00:00:00', '2019-01-01 00:00:00', '2018-05-12 16:03:57');
INSERT INTO `activity` VALUES ('1009', '1000元秒杀小米5', '400', '2018-12-31 00:00:00', '2019-01-01 00:00:00', '2018-05-12 16:03:57');

-- ----------------------------
-- Table structure for success_record
-- ----------------------------
DROP TABLE IF EXISTS `success_record`;
CREATE TABLE `success_record` (
  `activity_id` bigint(20) NOT NULL COMMENT '商品id',
  `user_phone` bigint(20) NOT NULL COMMENT '用户手机号',
  `state` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '状态标示：-1 无效；0 成功；1 已付款',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`activity_id`,`user_phone`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀明细表';

-- ----------------------------
-- Records of success_record
-- ----------------------------
INSERT INTO `success_record` VALUES ('1000', '1234567890', '-1', '2017-01-03 09:26:18');
INSERT INTO `success_record` VALUES ('1004', '1234567891', '-1', '2017-01-03 10:33:51');
INSERT INTO `success_record` VALUES ('1004', '1234567892', '-1', '2017-01-03 10:35:10');

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` int(11) NOT NULL COMMENT '编号，主键',
  `name` varchar(255) DEFAULT NULL COMMENT '组织结构名称',
  `priority` int(11) DEFAULT '0' COMMENT '显示顺序',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父编号',
  `state` int(11) DEFAULT '1' COMMENT '状态，默认1正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL COMMENT '主键，权限总数较小（int）',
  `value` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `groups` int(11) DEFAULT NULL COMMENT '权限组',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `type` enum('RESOURCE','SPECIAL','DEFAULT') DEFAULT 'DEFAULT' COMMENT '权限类型，默认DEFAULT，特殊SPECIAL，资源RESOURCE',
  `state` int(11) DEFAULT '1' COMMENT '状态，默认1正常',
  PRIMARY KEY (`id`),
  KEY `fk_sys_permission_groups_id` (`groups`),
  CONSTRAINT `fk_sys_permission_groups_id` FOREIGN KEY (`groups`) REFERENCES `sys_permission_groups` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', 'queryall', null, '查询全部', 'DEFAULT', '1');
INSERT INTO `sys_permission` VALUES ('2', 'queryone', null, '查询单个', 'DEFAULT', '1');

-- ----------------------------
-- Table structure for sys_permission_groups
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_groups`;
CREATE TABLE `sys_permission_groups` (
  `id` int(11) NOT NULL,
  `value` varchar(50) DEFAULT NULL,
  `descrpition` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限分组';

-- ----------------------------
-- Records of sys_permission_groups
-- ----------------------------

-- ----------------------------
-- Table structure for sys_permission_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission_resources`;
CREATE TABLE `sys_permission_resources` (
  `permission_id` int(20) NOT NULL COMMENT '权限id',
  `resources_id` bigint(20) NOT NULL COMMENT '资源id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`permission_id`,`resources_id`),
  KEY `fk_sys_permission_resouces_resources` (`resources_id`),
  CONSTRAINT `fk_sys_permission_resouces_permission` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sys_permission_resouces_resources` FOREIGN KEY (`resources_id`) REFERENCES `sys_resources` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission_resources
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE `sys_resources` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `type` varchar(100) DEFAULT NULL COMMENT '资源类型',
  `priority` int(11) DEFAULT NULL COMMENT '显示顺序',
  `state` int(11) DEFAULT '1' COMMENT '状态，默认1正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resources
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `organization_id` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `state` int(11) DEFAULT '1' COMMENT '状态，默认1正常',
  PRIMARY KEY (`id`),
  KEY `fk_sys_role_organization` (`organization_id`),
  CONSTRAINT `fk_sys_role_organization` FOREIGN KEY (`organization_id`) REFERENCES `sys_organization` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', null, null, '1');
INSERT INTO `sys_role` VALUES ('2', 'user', null, null, '1');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `permission_id` int(11) NOT NULL COMMENT '权限Id',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `fk_sys_role_permission_permission` (`permission_id`),
  CONSTRAINT `fk_sys_role_permission_permission` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sys_role_permission_role` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', null);
INSERT INTO `sys_role_permission` VALUES ('1', '2', null);
INSERT INTO `sys_role_permission` VALUES ('2', '2', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '编号，主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `telphone` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',
  `single_role` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `state` int(10) DEFAULT '1' COMMENT '状态，默认1正常,0删除，-1锁定',
  PRIMARY KEY (`id`),
  KEY `fk_sys_user_single_role` (`single_role`),
  CONSTRAINT `fk_sys_user_single_role` FOREIGN KEY (`single_role`) REFERENCES `sys_role` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'joe', 'password', null, null, '', '1', '2019-03-31 23:06:31', '1');
INSERT INTO `sys_user` VALUES ('2', 'jill', 'password1', null, null, null, '2', '2019-04-09 15:44:38', '1');

-- ----------------------------
-- Table structure for sys_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_permission`;
CREATE TABLE `sys_user_permission` (
  `user_id` bigint(20) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`permission_id`),
  KEY `fk_sys_user_permission_permission` (`permission_id`),
  CONSTRAINT `fk_sys_user_permission_permission` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sys_user_permission_user` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='user特殊权限，对应permission建议创建不是default类型的权限\r\n一般情况下，使用role对应permission';

-- ----------------------------
-- Records of sys_user_permission
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_sys_user_role_role` (`role_id`),
  CONSTRAINT `fk_sys_user_role_role` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sys_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='一个用户对应多个角色时使用';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', null, '2019-03-31 23:00:17', '1');
