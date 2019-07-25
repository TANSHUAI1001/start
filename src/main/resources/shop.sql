/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-07-20 11:32:20
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
-- Table structure for fund_data
-- ----------------------------
DROP TABLE IF EXISTS `fund_data`;
CREATE TABLE `fund_data` (
  `ts_code` varchar(255) NOT NULL COMMENT '基金代码',
  `name` varchar(255) DEFAULT NULL COMMENT '简称',
  `management` varchar(255) DEFAULT NULL COMMENT '管理人',
  `custodian` varchar(255) DEFAULT NULL COMMENT '托管人',
  `fund_type` varchar(255) DEFAULT NULL COMMENT '投资类型',
  `found_date` varchar(255) DEFAULT NULL COMMENT '成立日期',
  `due_date` varchar(255) DEFAULT NULL COMMENT '到期日期',
  `list_date` varchar(255) DEFAULT NULL COMMENT '上市时间',
  `issue_date` varchar(255) DEFAULT NULL COMMENT '发行日期',
  `delist_date` varchar(255) DEFAULT NULL COMMENT '退市日期',
  `issue_amount` double DEFAULT NULL COMMENT '发行份额(亿)',
  `m_fee` double DEFAULT NULL COMMENT '管理费',
  `c_fee` double DEFAULT NULL COMMENT '托管费',
  `duration_year` double DEFAULT NULL COMMENT '存续期',
  `p_value` double DEFAULT NULL COMMENT '面值',
  `min_amount` double DEFAULT NULL COMMENT '起点金额(万元)',
  `exp_return` varchar(255) DEFAULT NULL COMMENT '预期收益率',
  `benchmark` text COMMENT '业绩比较基准',
  `status` varchar(255) DEFAULT NULL COMMENT '存续状态D摘牌 I发行 L已上市',
  `invest_type` varchar(255) DEFAULT NULL COMMENT '投资风格',
  `type` varchar(255) DEFAULT NULL COMMENT '基金类型',
  `trustee` varchar(255) DEFAULT NULL COMMENT '受托人',
  `purc_startdate` varchar(255) DEFAULT NULL COMMENT '日常申购起始日',
  `redm_startdate` varchar(255) DEFAULT NULL COMMENT '日常赎回起始日',
  `market` varchar(255) DEFAULT NULL COMMENT 'E场内O场外',
  PRIMARY KEY (`ts_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `name` varchar(255) DEFAULT NULL COMMENT '中文描述',
  `permission` varchar(255) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL COMMENT '资源类型',
  `level` varchar(100) DEFAULT NULL COMMENT '级别',
  `parent` varchar(100) DEFAULT NULL COMMENT '上级',
  `classes` varchar(100) DEFAULT NULL COMMENT '菜单样式类',
  `priority` int(11) DEFAULT NULL COMMENT '显示顺序',
  `state` int(11) DEFAULT '1' COMMENT '状态，默认1正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `role_id` int(11) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`role_id`,`resource_id`),
  KEY `sys_role_resource_role_id` (`role_id`) USING BTREE,
  KEY `sys_role_resource_resource_id` (`resource_id`),
  CONSTRAINT `sys_role_resource_resource_id` FOREIGN KEY (`resource_id`) REFERENCES `sys_resource` (`id`),
  CONSTRAINT `sys_role_resource_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '编号，主键',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像图片',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',
  `single_role` int(11) DEFAULT NULL,
  `message` int(11) DEFAULT '0' COMMENT '消息数量',
  ` notification` int(11) DEFAULT '0' COMMENT '通知数量',
  `task` int(11) DEFAULT '0' COMMENT '任务数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `state` int(10) DEFAULT '1' COMMENT '状态，默认1正常,0删除，-1锁定',
  PRIMARY KEY (`id`),
  KEY `fk_sys_user_single_role` (`single_role`),
  CONSTRAINT `fk_sys_user_single_role` FOREIGN KEY (`single_role`) REFERENCES `sys_role` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
