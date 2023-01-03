/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80031
Source Host           : localhost:3306
Source Database       : bt_clinic_vue

Target Server Type    : MYSQL
Target Server Version : 80031
File Encoding         : 65001

Date: 2023-01-03 10:06:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员表主键ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='管理员表';

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', '123456', '管理员', '2022-12-26 11:02:38', '2022-12-26 23:17:27');

-- ----------------------------
-- Table structure for t_appoint
-- ----------------------------
DROP TABLE IF EXISTS `t_appoint`;
CREATE TABLE `t_appoint` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '预约ID',
  `user_id` int DEFAULT NULL COMMENT '用户ID',
  `source_id` int DEFAULT NULL COMMENT '号源ID',
  `status` int DEFAULT NULL COMMENT '状态：0已预约，1已就诊，2已取消',
  `create_time` datetime DEFAULT NULL COMMENT '预约时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `source_id` (`source_id`),
  CONSTRAINT `t_appoint_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_appoint_ibfk_2` FOREIGN KEY (`source_id`) REFERENCES `t_source` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3 COMMENT='预约记录表';

-- ----------------------------
-- Records of t_appoint
-- ----------------------------
INSERT INTO `t_appoint` VALUES ('1', '1', '1', '2', '2022-12-24 18:44:45', '2022-12-24 18:44:45');
INSERT INTO `t_appoint` VALUES ('2', '1', '1', '1', '2022-12-24 23:28:46', '2022-12-24 23:28:46');
INSERT INTO `t_appoint` VALUES ('3', '1', '5', '2', '2022-12-26 17:47:15', '2022-12-26 17:47:15');
INSERT INTO `t_appoint` VALUES ('4', '5', '10', '2', '2022-12-26 23:20:02', '2022-12-26 23:20:02');
INSERT INTO `t_appoint` VALUES ('5', '5', '11', '1', '2022-12-26 23:20:35', '2022-12-26 23:27:55');
INSERT INTO `t_appoint` VALUES ('6', '1', '13', '1', '2022-12-27 20:38:58', '2022-12-29 17:30:21');
INSERT INTO `t_appoint` VALUES ('7', '5', '14', '1', '2022-12-27 20:46:48', '2022-12-27 20:48:27');
INSERT INTO `t_appoint` VALUES ('8', '6', '15', '0', '2022-12-29 14:52:47', '2022-12-29 14:52:47');
INSERT INTO `t_appoint` VALUES ('9', '1', '16', '0', '2022-12-29 19:27:20', '2022-12-29 19:27:20');
INSERT INTO `t_appoint` VALUES ('10', '1', '15', '1', '2022-12-29 19:29:45', '2022-12-29 20:13:38');
INSERT INTO `t_appoint` VALUES ('11', '1', '15', '2', '2022-12-29 20:27:37', '2022-12-29 20:27:37');
INSERT INTO `t_appoint` VALUES ('12', '2', '13', '2', '2022-12-29 20:29:39', '2022-12-29 20:29:39');
INSERT INTO `t_appoint` VALUES ('13', '7', '15', '2', '2022-12-30 10:25:50', '2022-12-30 10:25:50');
INSERT INTO `t_appoint` VALUES ('14', '7', '15', '2', '2022-12-30 10:37:40', '2022-12-30 10:37:40');
INSERT INTO `t_appoint` VALUES ('15', '7', '15', '1', '2022-12-30 10:47:22', '2022-12-30 10:48:24');
INSERT INTO `t_appoint` VALUES ('16', '6', '18', '2', '2023-01-01 10:12:41', '2023-01-01 10:12:41');
INSERT INTO `t_appoint` VALUES ('17', '6', '18', '1', '2023-01-01 10:18:21', '2023-01-01 10:19:29');
INSERT INTO `t_appoint` VALUES ('18', '9', '19', '1', '2023-01-02 20:30:35', '2023-01-02 20:31:11');
INSERT INTO `t_appoint` VALUES ('19', '1', '21', '1', '2023-01-03 08:43:20', '2023-01-03 08:45:44');

-- ----------------------------
-- Table structure for t_bill
-- ----------------------------
DROP TABLE IF EXISTS `t_bill`;
CREATE TABLE `t_bill` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '处方账单ID',
  `user_id` int DEFAULT NULL COMMENT '用户ID',
  `doctor_id` int DEFAULT NULL COMMENT '医生ID',
  `invoice_date` date DEFAULT NULL COMMENT '开具日期',
  `total_bill` double DEFAULT NULL COMMENT '总费用',
  `status` int DEFAULT NULL COMMENT '状态：0待缴，1已缴',
  `remark` varchar(1024) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '录入时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `t_bill_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_bill_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `t_doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COMMENT='账单信息表';

-- ----------------------------
-- Records of t_bill
-- ----------------------------
INSERT INTO `t_bill` VALUES ('1', '1', '1', '2022-12-25', '35', '1', '包含口服药和注射用药。', '2022-12-25 13:33:03', '2022-12-27 20:33:45');
INSERT INTO `t_bill` VALUES ('2', '1', '1', '2022-12-26', '35', '1', '这里是处方的注意事项，比如有哪些药，怎么吃。', '2022-12-26 17:53:06', '2022-12-26 17:53:06');
INSERT INTO `t_bill` VALUES ('3', '5', '1', '2022-12-25', '35', '1', '针对皮肤病，开一些消炎抗菌药，注意按时服用，增加注射药品。', '2022-12-25 23:22:27', '2022-12-25 23:23:37');
INSERT INTO `t_bill` VALUES ('4', '5', '4', '2022-12-27', '90', '1', '锻炼时要注意保护膝盖', '2022-12-27 20:49:01', '2022-12-27 20:49:01');
INSERT INTO `t_bill` VALUES ('5', '6', '3', '2022-12-29', '54', '1', '注意保暖', '2022-12-29 14:54:39', '2022-12-29 14:54:39');
INSERT INTO `t_bill` VALUES ('6', '1', '3', '2022-12-29', '55', '1', '清淡饮食，尽量少吃油腻', '2022-12-29 19:31:01', '2022-12-29 19:31:01');
INSERT INTO `t_bill` VALUES ('7', '1', '3', '2022-12-29', '15', '0', '多喝水', '2022-12-29 20:14:06', '2022-12-29 20:14:06');
INSERT INTO `t_bill` VALUES ('8', '7', '3', '2022-12-29', '90', '0', '注意保暖', '2022-12-30 10:48:46', '2022-12-30 10:48:46');
INSERT INTO `t_bill` VALUES ('9', '6', '1', '2023-01-01', '54', '1', '多喝水，多休息', '2023-01-01 10:21:07', '2023-01-01 10:21:07');
INSERT INTO `t_bill` VALUES ('10', '9', '6', '2023-01-02', '40', '1', '注意保暖', '2023-01-02 20:31:36', '2023-01-02 20:31:36');
INSERT INTO `t_bill` VALUES ('11', '1', '6', '2023-01-03', '45', '1', '注意保暖', '2023-01-03 08:45:58', '2023-01-03 08:45:58');
INSERT INTO `t_bill` VALUES ('12', '1', '6', '2023-01-03', '55', '1', '注意保暖', '2023-01-03 08:47:33', '2023-01-03 08:47:33');

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '科室ID',
  `dept_name` varchar(32) DEFAULT NULL COMMENT '科室名称',
  `remark` varchar(128) DEFAULT NULL COMMENT '科室备注',
  `create_time` datetime DEFAULT NULL COMMENT '录入时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='科室信息表';

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', '外科', '外科', '2022-12-24 15:55:26', '2022-12-24 15:55:30');
INSERT INTO `t_dept` VALUES ('2', '内科', '内科', '2022-12-25 17:08:33', '2022-12-25 17:08:33');
INSERT INTO `t_dept` VALUES ('3', '骨科', '骨科', '2022-12-25 23:23:01', '2022-12-25 23:25:14');
INSERT INTO `t_dept` VALUES ('4', '妇科', '妇科', '2022-12-26 23:11:50', '2022-12-26 23:11:50');
INSERT INTO `t_dept` VALUES ('5', '儿科', '测试', '2023-01-02 20:17:26', '2023-01-02 20:17:26');

-- ----------------------------
-- Table structure for t_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE `t_doctor` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(32) DEFAULT NULL COMMENT '账号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `sex` int DEFAULT NULL COMMENT '性别：0男，1女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `education` int DEFAULT NULL COMMENT '学历',
  `entry_time` date DEFAULT NULL COMMENT '入职日期',
  `dept_id` int DEFAULT NULL COMMENT '科室ID',
  `address` varchar(256) DEFAULT NULL COMMENT '居住地址',
  `status` int DEFAULT NULL COMMENT '状态：0启用，1冻结',
  `create_time` datetime DEFAULT NULL COMMENT '录入时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `t_doctor_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `t_dept` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='医生信息表';

-- ----------------------------
-- Records of t_doctor
-- ----------------------------
INSERT INTO `t_doctor` VALUES ('1', 'D0001', '123456', '张医生', '11111111111', '1111@qq.com', '0', '1999-07-08', '1', '2020-06-01', '1', '上海市', '0', '2022-12-27 16:29:16', '2022-12-27 20:18:36');
INSERT INTO `t_doctor` VALUES ('2', 'D0002', '123456', '李医生', '11111111112', '1112@qq.com', '1', '1997-11-05', '1', '2020-07-01', '1', '上海市', '0', '2022-12-27 18:21:16', '2022-12-27 20:18:32');
INSERT INTO `t_doctor` VALUES ('3', 'D0003', '123456', '宋医生', '11111111113', '1113@qq.com', '0', '1985-06-12', '1', '2020-10-08', '2', '上海市', '0', '2022-12-27 11:14:15', '2022-12-27 20:18:28');
INSERT INTO `t_doctor` VALUES ('4', 'D0004', '123456', '王医生', '11111111114', '1114@qq.com', '0', '1984-06-06', '1', '2020-12-16', '3', '上海市', '0', '2022-12-26 23:11:19', '2022-12-27 20:18:24');
INSERT INTO `t_doctor` VALUES ('5', 'D0005', '123456', '陈医生', '11111111115', '1115@qq.com', '0', '1993-07-02', '2', '2020-08-20', '4', '上海市', '0', '2022-12-27 20:14:50', '2022-12-27 20:18:20');
INSERT INTO `t_doctor` VALUES ('6', 'D0006', '123456', '测试医生', '12345678901', '123456@qq.com', '0', '1992-03-03', '2', '2022-02-02', '2', '上海市', '0', '2023-01-02 20:21:31', '2023-01-03 08:37:39');

-- ----------------------------
-- Table structure for t_drug
-- ----------------------------
DROP TABLE IF EXISTS `t_drug`;
CREATE TABLE `t_drug` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '药品ID',
  `drug_no` varchar(32) DEFAULT NULL COMMENT '药品编号',
  `drug_name` varchar(64) DEFAULT NULL COMMENT '药品名称',
  `stock` int DEFAULT NULL COMMENT '库存',
  `price` double DEFAULT NULL COMMENT '单价',
  `unit` varchar(32) DEFAULT NULL COMMENT '包装单位',
  `useway` int DEFAULT NULL COMMENT '用法：0口服，1注射',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '录入时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='药品信息表';

-- ----------------------------
-- Records of t_drug
-- ----------------------------
INSERT INTO `t_drug` VALUES ('1', 'P0001', '阿莫西林', '9', '15', '盒', '0', '口服消炎抗菌药', '2022-12-23 15:27:55', '2022-12-25 15:08:59');
INSERT INTO `t_drug` VALUES ('2', 'P0002', '诺氟沙星', '12', '20', '盒', '1', '抗生素针剂', '2022-12-25 15:08:48', '2022-12-26 00:15:06');
INSERT INTO `t_drug` VALUES ('3', 'P0003', '双黄连口服液', '18', '20', '盒', '0', '感冒药，抗病毒。', '2022-12-26 11:18:03', '2022-12-26 11:18:03');
INSERT INTO `t_drug` VALUES ('4', 'P0004', '连花清瘟胶囊', '14', '18', '盒', '0', '感冒药。', '2022-12-26 23:15:13', '2022-12-26 23:15:25');
INSERT INTO `t_drug` VALUES ('5', 'P0005', '活血止痛膏', '20', '30', '盒', '0', '治疗跌打损伤', '2022-12-27 20:52:50', '2022-12-27 20:54:12');
INSERT INTO `t_drug` VALUES ('6', 'P0006', '布洛芬缓释胶囊（测试）', '18', '20', '盒', '0', '退烧药', '2023-01-02 20:23:10', '2023-01-02 20:23:10');

-- ----------------------------
-- Table structure for t_feedback
-- ----------------------------
DROP TABLE IF EXISTS `t_feedback`;
CREATE TABLE `t_feedback` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '留言反馈ID',
  `user_id` int DEFAULT NULL COMMENT '学生ID',
  `title` varchar(64) DEFAULT NULL COMMENT '留言主题',
  `content` varchar(1024) DEFAULT NULL COMMENT '留言内容',
  `status` int DEFAULT NULL COMMENT '状态：0待回复，1已回复',
  `reply` varchar(1024) DEFAULT NULL COMMENT '回复',
  `create_time` datetime DEFAULT NULL COMMENT '提交时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COMMENT='留言反馈表';

-- ----------------------------
-- Records of t_feedback
-- ----------------------------
INSERT INTO `t_feedback` VALUES ('1', '1', '密码忘记了，可以修改吗？', '密码忘记了，可以修改吗？', '1', '可以的', '2022-12-26 22:34:30', '2022-12-26 22:35:40');
INSERT INTO `t_feedback` VALUES ('2', '2', '可以按时段预约号源吗？', '可以按时段预约号源吗？', '1', '作为一个好的医院管理系统，必须得。', '2022-12-26 22:35:17', '2022-12-26 23:17:02');
INSERT INTO `t_feedback` VALUES ('3', '5', '我已经挂过号了', '我已经挂过号了，并且完成了就诊，特此感谢。', '0', null, '2022-12-26 23:26:07', '2022-12-26 23:26:07');
INSERT INTO `t_feedback` VALUES ('4', '6', '新冠防治', '怎么防治新冠？', '1', '注意保暖', '2022-12-29 14:58:04', '2022-12-29 14:59:08');
INSERT INTO `t_feedback` VALUES ('5', '7', '感冒咳嗽', '感冒咳嗽一般多久能好？', '0', null, '2022-12-30 10:54:19', '2022-12-30 10:54:19');
INSERT INTO `t_feedback` VALUES ('6', '6', '新冠相关问题咨询', '得新冠一定会发烧吗？', '1', '可能会（测试）', '2023-01-01 10:17:15', '2023-01-02 20:24:47');
INSERT INTO `t_feedback` VALUES ('7', '9', '测试留言功能', '我只是测试一下留言功能', '1', '好的，收到你的测试', '2023-01-02 20:33:51', '2023-01-02 20:34:08');

-- ----------------------------
-- Table structure for t_history
-- ----------------------------
DROP TABLE IF EXISTS `t_history`;
CREATE TABLE `t_history` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '就诊记录（病历）ID',
  `user_id` int DEFAULT NULL COMMENT '用户ID',
  `doctor_id` int DEFAULT NULL COMMENT '医生ID',
  `visit_date` date DEFAULT NULL COMMENT '就诊日期',
  `content` varchar(255) DEFAULT NULL COMMENT '病情记录',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `t_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_history_ibfk_2` FOREIGN KEY (`doctor_id`) REFERENCES `t_doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COMMENT='就诊记录（病历）';

-- ----------------------------
-- Records of t_history
-- ----------------------------
INSERT INTO `t_history` VALUES ('1', '1', '1', '2022-12-25', '皮肤发炎，红肿，建议抗菌治疗。', '2022-12-25 13:06:28', '2022-12-25 13:06:28');
INSERT INTO `t_history` VALUES ('2', '1', '1', '2022-12-26', '皮肤红肿溃烂。', '2022-12-26 17:52:27', '2022-12-26 17:52:27');
INSERT INTO `t_history` VALUES ('3', '5', '1', '2022-12-27', '皮肤肿痛，化脓，感染面积扩大。', '2022-12-26 23:21:47', '2022-12-26 23:21:47');
INSERT INTO `t_history` VALUES ('4', '5', '4', '2022-12-27', '骨质疏松', '2022-12-27 20:48:13', '2022-12-27 20:48:13');
INSERT INTO `t_history` VALUES ('5', '6', '3', '2022-12-29', '感染新冠，发烧', '2022-12-29 14:54:17', '2022-12-29 14:54:17');
INSERT INTO `t_history` VALUES ('6', '1', '3', '2022-12-29', '感冒', '2022-12-29 19:30:41', '2022-12-29 19:30:41');
INSERT INTO `t_history` VALUES ('7', '1', '3', '2022-12-29', '头昏脑涨，晕眩，判定为季节性流感', '2022-12-29 20:13:34', '2022-12-29 20:13:34');
INSERT INTO `t_history` VALUES ('8', '7', '3', '2022-12-29', '感冒咳嗽，喉咙发炎', '2022-12-30 10:48:02', '2022-12-30 10:48:02');
INSERT INTO `t_history` VALUES ('9', '6', '1', '2023-01-01', '感冒发烧', '2023-01-01 10:19:26', '2023-01-01 10:19:26');
INSERT INTO `t_history` VALUES ('10', '9', '6', '2023-01-02', '感冒发烧', '2023-01-02 20:31:08', '2023-01-02 20:31:08');
INSERT INTO `t_history` VALUES ('11', '1', '6', '2023-01-03', '发烧', '2023-01-03 08:45:42', '2023-01-03 08:45:42');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `title` varchar(128) DEFAULT NULL COMMENT '主题',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COMMENT='公告信息表';

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('1', '医院预约挂号管理系统上线啦', '<p>医院预约挂号管理系统上线啦</p><p>医院预约挂号管理系统上线啦</p><p>医院预约挂号管理系统上线啦</p><p>医院预约挂号管理系统上线啦</p>', '2022-12-26 22:12:52', '2022-12-29 15:00:42');
INSERT INTO `t_notice` VALUES ('2', '系统升级维护通知', '<p>系统升级维护通知</p><p>系统升级维护通知</p><p>系统升级维护通知，提高用户体验。</p>', '2022-12-27 22:28:31', '2022-12-29 15:00:36');
INSERT INTO `t_notice` VALUES ('3', '系统第二次升级', '<p>系统第二次升级啦！</p><p>系统第二次升级啦！<br/></p><p>系统第二次升级啦！<br/></p>', '2022-12-29 21:21:08', '2022-12-30 09:27:52');
INSERT INTO `t_notice` VALUES ('4', '发布公告1', '<p>公告1内容</p>', '2023-01-01 10:05:18', '2023-01-01 10:05:18');
INSERT INTO `t_notice` VALUES ('5', '测试发布公告', '<p>测试公告内容</p>', '2023-01-02 20:25:09', '2023-01-02 20:25:09');

-- ----------------------------
-- Table structure for t_plan
-- ----------------------------
DROP TABLE IF EXISTS `t_plan`;
CREATE TABLE `t_plan` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '号源ID',
  `doctor_id` int DEFAULT NULL COMMENT '医生ID',
  `plan_date` date DEFAULT NULL COMMENT '号源日期',
  `total_num` int DEFAULT NULL COMMENT '总号源数量',
  `rest_num` int DEFAULT NULL COMMENT '剩余号源数量',
  `status` int DEFAULT NULL COMMENT '状态：0待发布，1已发布',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `doctor_id` (`doctor_id`),
  CONSTRAINT `t_plan_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `t_doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COMMENT='号源计划表';

-- ----------------------------
-- Records of t_plan
-- ----------------------------
INSERT INTO `t_plan` VALUES ('1', '1', '2022-12-25', '80', '79', '1', '2022-12-23 18:12:10', '2022-12-23 23:12:36');
INSERT INTO `t_plan` VALUES ('2', '1', '2022-12-26', '60', '60', '1', '2022-12-24 14:56:42', '2022-12-24 14:56:42');
INSERT INTO `t_plan` VALUES ('3', '1', '2022-12-27', '60', '59', '1', '2022-12-24 15:23:20', '2022-12-24 15:23:20');
INSERT INTO `t_plan` VALUES ('4', '1', '2022-12-28', '0', '0', '0', '2022-12-24 15:23:27', '2022-12-24 15:23:27');
INSERT INTO `t_plan` VALUES ('5', '1', '2022-12-29', '30', '29', '1', '2022-12-26 23:12:37', '2022-12-26 23:12:37');
INSERT INTO `t_plan` VALUES ('6', '5', '2022-12-27', '10', '9', '1', '2022-12-27 20:26:53', '2022-12-27 20:26:53');
INSERT INTO `t_plan` VALUES ('7', '4', '2022-12-27', '10', '9', '1', '2022-12-27 20:45:13', '2022-12-27 20:45:13');
INSERT INTO `t_plan` VALUES ('8', '3', '2022-12-29', '20', '17', '1', '2022-12-29 14:51:55', '2022-12-29 14:51:55');
INSERT INTO `t_plan` VALUES ('9', '3', '2022-12-30', '20', '20', '0', '2022-12-30 16:27:14', '2022-12-30 16:27:14');
INSERT INTO `t_plan` VALUES ('10', '3', '2023-01-01', '20', '19', '1', '2023-01-01 10:08:21', '2023-01-01 10:08:21');
INSERT INTO `t_plan` VALUES ('11', '6', '2023-01-02', '20', '19', '1', '2023-01-02 20:27:19', '2023-01-02 20:27:19');
INSERT INTO `t_plan` VALUES ('12', '6', '2023-01-03', '20', '19', '1', '2023-01-03 08:41:03', '2023-01-03 08:41:03');

-- ----------------------------
-- Table structure for t_recipe
-- ----------------------------
DROP TABLE IF EXISTS `t_recipe`;
CREATE TABLE `t_recipe` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '处方ID',
  `bill_id` int DEFAULT NULL COMMENT '账单ID',
  `drug_id` int DEFAULT NULL COMMENT '药品ID',
  `drug_num` int DEFAULT NULL COMMENT '药品数量',
  `subtotal` double DEFAULT NULL COMMENT '小计',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `bill_id` (`bill_id`),
  KEY `drug_id` (`drug_id`),
  CONSTRAINT `t_recipe_ibfk_1` FOREIGN KEY (`bill_id`) REFERENCES `t_bill` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `t_recipe_ibfk_2` FOREIGN KEY (`drug_id`) REFERENCES `t_drug` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COMMENT='处方信息表';

-- ----------------------------
-- Records of t_recipe
-- ----------------------------
INSERT INTO `t_recipe` VALUES ('1', '1', '1', '1', '15', '2022-12-25 14:58:57', '2022-12-27 20:33:41');
INSERT INTO `t_recipe` VALUES ('2', '1', '2', '1', '20', '2022-12-25 15:14:55', '2022-12-27 20:33:48');
INSERT INTO `t_recipe` VALUES ('3', '2', '1', '1', '15', '2022-12-26 17:55:47', '2022-12-26 17:55:47');
INSERT INTO `t_recipe` VALUES ('4', '2', '2', '1', '20', '2022-12-26 17:56:00', '2022-12-26 17:56:00');
INSERT INTO `t_recipe` VALUES ('5', '3', '1', '1', '15', '2022-12-26 23:23:04', '2022-12-26 23:23:04');
INSERT INTO `t_recipe` VALUES ('6', '3', '2', '1', '20', '2022-12-26 23:23:19', '2022-12-26 23:23:19');
INSERT INTO `t_recipe` VALUES ('7', '4', '5', '3', '90', '2022-12-27 20:53:16', '2022-12-27 20:53:16');
INSERT INTO `t_recipe` VALUES ('8', '5', '4', '3', '54', '2022-12-29 14:54:59', '2022-12-29 14:54:59');
INSERT INTO `t_recipe` VALUES ('9', '6', '1', '1', '15', '2022-12-29 19:31:21', '2022-12-29 19:31:21');
INSERT INTO `t_recipe` VALUES ('10', '6', '3', '2', '40', '2022-12-29 19:31:30', '2022-12-29 19:31:30');
INSERT INTO `t_recipe` VALUES ('11', '7', '1', '1', '15', '2022-12-29 20:14:17', '2022-12-29 20:14:17');
INSERT INTO `t_recipe` VALUES ('12', '8', '1', '2', '30', '2022-12-30 10:49:07', '2022-12-30 10:49:07');
INSERT INTO `t_recipe` VALUES ('13', '8', '2', '3', '60', '2022-12-30 15:09:32', '2022-12-30 15:09:32');
INSERT INTO `t_recipe` VALUES ('14', '9', '4', '3', '54', '2023-01-01 10:22:48', '2023-01-01 10:22:48');
INSERT INTO `t_recipe` VALUES ('15', '10', '6', '2', '40', '2023-01-02 20:32:06', '2023-01-02 20:32:06');
INSERT INTO `t_recipe` VALUES ('16', '11', '1', '3', '45', '2023-01-03 08:46:19', '2023-01-03 08:46:19');
INSERT INTO `t_recipe` VALUES ('17', '12', '1', '1', '15', '2023-01-03 08:47:54', '2023-01-03 08:47:54');
INSERT INTO `t_recipe` VALUES ('18', '12', '2', '2', '40', '2023-01-03 08:47:58', '2023-01-03 08:47:58');

-- ----------------------------
-- Table structure for t_source
-- ----------------------------
DROP TABLE IF EXISTS `t_source`;
CREATE TABLE `t_source` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '号源ID',
  `plan_id` int DEFAULT NULL COMMENT '计划ID',
  `begin_time` varchar(32) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(32) DEFAULT NULL COMMENT '结束时间',
  `total` int DEFAULT NULL COMMENT '时间段内号源',
  `rest` int DEFAULT NULL COMMENT '剩余号源',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `plan_id` (`plan_id`),
  CONSTRAINT `t_source_ibfk_1` FOREIGN KEY (`plan_id`) REFERENCES `t_plan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 COMMENT='号源信息表（某一时间段内号源）';

-- ----------------------------
-- Records of t_source
-- ----------------------------
INSERT INTO `t_source` VALUES ('1', '1', '08:00', '10:00', '20', '19', '2022-12-23 19:08:06', '2022-12-23 21:56:33');
INSERT INTO `t_source` VALUES ('2', '1', '10:00', '12:00', '20', '20', '2022-12-23 21:57:12', '2022-12-23 21:57:12');
INSERT INTO `t_source` VALUES ('3', '1', '14:00', '16:00', '20', '20', '2022-12-23 21:57:42', '2022-12-23 21:57:42');
INSERT INTO `t_source` VALUES ('4', '1', '16:00', '18:00', '20', '20', '2022-12-23 21:57:59', '2022-12-24 14:30:54');
INSERT INTO `t_source` VALUES ('5', '2', '08:00', '10:00', '15', '15', '2022-12-24 15:05:53', '2022-12-24 15:05:53');
INSERT INTO `t_source` VALUES ('6', '2', '10:00', '12:00', '15', '15', '2022-12-24 15:06:09', '2022-12-24 15:06:09');
INSERT INTO `t_source` VALUES ('7', '2', '14:00', '16:00', '15', '15', '2022-12-24 15:19:28', '2022-12-24 15:19:52');
INSERT INTO `t_source` VALUES ('8', '2', '16:00', '18:00', '15', '15', '2022-12-24 15:20:19', '2022-12-24 15:20:19');
INSERT INTO `t_source` VALUES ('9', '3', '08:00', '10:00', '15', '15', '2022-12-24 15:24:51', '2022-12-26 00:12:27');
INSERT INTO `t_source` VALUES ('10', '3', '10:00', '12:00', '15', '15', '2022-12-26 00:12:51', '2022-12-26 00:12:51');
INSERT INTO `t_source` VALUES ('11', '3', '14:00', '16:00', '15', '14', '2022-12-26 23:13:11', '2022-12-26 23:13:11');
INSERT INTO `t_source` VALUES ('12', '3', '16:00', '18:00', '15', '15', '2022-12-26 23:13:32', '2022-12-26 23:13:41');
INSERT INTO `t_source` VALUES ('13', '6', '08:00', '10:00', '10', '9', '2022-12-27 20:27:35', '2022-12-27 20:27:35');
INSERT INTO `t_source` VALUES ('14', '7', '14:00', '16:00', '10', '9', '2022-12-27 20:46:17', '2022-12-27 20:46:17');
INSERT INTO `t_source` VALUES ('15', '8', '13:30', '15:30', '20', '17', '2022-12-29 14:52:22', '2022-12-29 14:52:22');
INSERT INTO `t_source` VALUES ('16', '5', '18:00', '21:00', '30', '29', '2022-12-29 19:25:50', '2022-12-29 19:25:50');
INSERT INTO `t_source` VALUES ('17', '9', '19:00', '21:00', '20', '20', '2022-12-30 16:29:44', '2022-12-30 16:29:44');
INSERT INTO `t_source` VALUES ('18', '10', '10:00', '12:00', '20', '19', '2023-01-01 10:08:45', '2023-01-01 10:08:45');
INSERT INTO `t_source` VALUES ('19', '11', '20:00', '22:00', '20', '19', '2023-01-02 20:27:33', '2023-01-02 20:27:33');
INSERT INTO `t_source` VALUES ('21', '12', '08:00', '10:00', '20', '19', '2023-01-03 08:41:20', '2023-01-03 08:41:20');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(32) DEFAULT NULL COMMENT '账号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '姓名',
  `telephone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `sex` int DEFAULT NULL COMMENT '性别：0男，1女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `profession` varchar(64) DEFAULT NULL COMMENT '行业工作',
  `address` varchar(256) DEFAULT NULL COMMENT '居住地址',
  `amount` double DEFAULT NULL COMMENT '余额',
  `status` int DEFAULT NULL COMMENT '状态：0启用，1冻结',
  `create_time` datetime DEFAULT NULL COMMENT '录入时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '2022001', '123456', '俞振辉', '11111111111', '1111@qq.com', '0', '2002-04-22', '学生', '上海市', '1740', '0', '2022-12-27 16:29:16', '2023-01-03 08:42:49');
INSERT INTO `t_user` VALUES ('2', '2022002', '123456', '刘小露', '11111111112', '1112@qq.com', '1', '2000-06-13', '服务员', '上海市', '500', '0', '2022-12-27 16:53:01', '2022-12-29 20:44:25');
INSERT INTO `t_user` VALUES ('3', '2022003', '123456', '宋小文', '11111111113', '1113@qq.com', '0', '2000-05-31', '销售员', '上海市', '1000', '0', '2022-12-27 18:13:09', '2022-12-27 20:19:02');
INSERT INTO `t_user` VALUES ('4', '2022004', '123456', '张晓霞', '11111111114', '1114@qq.com', '0', '2000-02-01', '客服', '上海市', '0', '0', '2022-12-27 17:14:25', '2022-12-27 20:19:13');
INSERT INTO `t_user` VALUES ('5', '2022005', '123456', '王小二', '11111111115', '1115@qq.com', '0', '1988-06-12', '软件开发', '上海市\n', '875', '0', '2022-12-27 23:09:41', '2022-12-28 20:18:48');
INSERT INTO `t_user` VALUES ('6', '2022006', '123456', '张小明', '11111111116', '1116@qq.com', '0', '1992-03-05', '软件工程师', '上海市', '892', '0', '2022-12-29 14:45:36', '2023-01-02 20:14:21');
INSERT INTO `t_user` VALUES ('7', '2022010', '1234567', '梅西', '11111111120', 'messi@gmail.com', '0', '1987-06-24', '足球运动员', '阿根廷圣菲省罗萨里奥', '500', '0', '2022-12-30 09:07:55', '2023-01-02 20:14:17');
INSERT INTO `t_user` VALUES ('9', '2023001', '1234567', '测试添加用户', '11111111111', '111111@qq.com', '0', '2002-01-01', '打工仔', '上海市', '0', '0', '2023-01-02 20:19:32', '2023-01-03 08:37:17');
