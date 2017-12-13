/*
Navicat MySQL Data Transfer

Source Server         : exercise
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : ued

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-12-13 18:14:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_banner_manage
-- ----------------------------
DROP TABLE IF EXISTS `tb_banner_manage`;
CREATE TABLE `tb_banner_manage` (
  `id` bigint(64) NOT NULL COMMENT '自增主键',
  `picture_url` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' COMMENT '图片url',
  `title` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT 'unknow' COMMENT '下载信息--标题',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '分类选择：1--品牌元素；2--ppt模板；3--广告模板；4--可爱元素；5--精彩分享；',
  `creator` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'unknown' COMMENT '创建者',
  `updater` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'unknown' COMMENT '修改者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '序列号',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除：0--未删除；1--已删除。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='banner管理';

-- ----------------------------
-- Records of tb_banner_manage
-- ----------------------------
INSERT INTO `tb_banner_manage` VALUES ('388372108775784448', 'www.baidu.com', 'ces', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:52:06', '2017-12-07 16:53:38', '1', '1');
INSERT INTO `tb_banner_manage` VALUES ('388372666815348736', 'www.baidu.com', 'ces', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:19', '2017-12-11 14:54:21', '1', '1');
INSERT INTO `tb_banner_manage` VALUES ('388372670539890688', 'www.baidu.com', 'ces', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:20', '2017-12-07 16:54:20', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388372674360901632', 'www.baidu.com', 'ces', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:21', '2017-12-07 16:54:21', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388372678534234112', 'www.baidu.com', 'ces', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:22', '2017-12-07 16:54:22', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388372683131191296', 'www.baidu.com', 'ces', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:23', '2017-12-07 16:54:23', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373071762817024', 'baidu.com', 'www', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:55', '2017-12-07 16:55:55', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373072974970880', 'baidu.com', 'www', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:56', '2017-12-07 16:55:56', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373074677858304', 'baidu.com', 'www', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:56', '2017-12-07 16:55:56', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373076116504576', 'baidu.com', 'www', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:56', '2017-12-07 16:55:56', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373077815197696', 'baidu.com', 'www', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:57', '2017-12-07 16:55:57', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373079681662976', 'baidu.com', 'www', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:57', '2017-12-07 16:55:57', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373081233555456', 'baidu.com', 'www', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:58', '2017-12-07 16:55:58', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373082542178304', 'baidu.com', 'www', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:58', '2017-12-07 16:55:58', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373083871772672', 'baidu.com', 'www', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:58', '2017-12-07 16:55:58', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373085352361984', 'baidu.com', 'www', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:59', '2017-12-07 16:55:59', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373114376945664', 'baidu.com', 'www', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:06', '2017-12-07 16:56:06', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373115635236864', 'baidu.com', 'www', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:06', '2017-12-07 16:56:06', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373116776087552', 'baidu.com', 'www', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:06', '2017-12-07 16:56:06', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373118806130688', 'baidu.com', 'www', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:07', '2017-12-07 16:56:07', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373120509018112', 'baidu.com', 'www', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:07', '2017-12-07 16:56:07', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373122035744768', 'baidu.com', 'www', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:07', '2017-12-07 16:56:07', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373123793158144', 'baidu.com', 'www', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:08', '2017-12-07 16:56:08', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373125135335424', 'baidu.com', 'www', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:08', '2017-12-07 16:56:08', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373331700613120', 'www.baidu.com', 'test', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:57', '2017-12-07 16:56:57', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373334770843648', 'www.baidu.com', 'test', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:58', '2017-12-07 16:56:58', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373335882334208', 'www.baidu.com', 'test', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:58', '2017-12-07 16:56:58', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373337782353920', 'www.baidu.com', 'test', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:59', '2017-12-07 16:56:59', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('388373339065810944', 'www.baidu.com', 'test', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:56:59', '2017-12-07 17:01:49', '1', '1');
INSERT INTO `tb_banner_manage` VALUES ('388373340680617984', 'www.baidu.com', 'test', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:00', '2017-12-07 17:01:07', '1', '1');
INSERT INTO `tb_banner_manage` VALUES ('389739802938834944', 'www.tencent.com', 'ceshibiaoti', '1', 'lvpenghui', 'lvpenghui', '2017-12-11 11:26:50', '2017-12-11 11:26:50', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('389752427047288832', 'www.tencent.com', 'ceshibiaoti', '1', 'lvpenghui', 'lvpenghui', '2017-12-11 12:16:59', '2017-12-11 12:16:59', '1', '0');
INSERT INTO `tb_banner_manage` VALUES ('390557007263825920', 'www.test.com', '标题', '1', 'lvpenghui', 'lvpenghui', '2017-12-13 17:34:06', '2017-12-13 17:34:06', '0', '0');
INSERT INTO `tb_banner_manage` VALUES ('390560203352834048', 'www.test.com', '标题', '1', 'lvpenghui', 'lvpenghui', '2017-12-13 17:46:48', '2017-12-13 17:46:48', '0', '0');
INSERT INTO `tb_banner_manage` VALUES ('390561974687105024', 'www.test.com', '标题', '1', 'lvpenghui', 'lvpenghui', '2017-12-13 17:53:51', '2017-12-13 17:53:51', '0', '0');

-- ----------------------------
-- Table structure for tb_download_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_download_message`;
CREATE TABLE `tb_download_message` (
  `id` bigint(64) NOT NULL COMMENT '自增主键',
  `picture_url` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' COMMENT '图片url',
  `title` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT 'unknow' COMMENT '下载信息--标题',
  `attachment_url` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' COMMENT '附件url',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '分类选择：1--品牌元素；2--ppt模板；3--广告模板；4--可爱元素；5--精彩分享；',
  `creator` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'unknown' COMMENT '创建者',
  `updater` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'unknown' COMMENT '修改者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '序列号',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除：0--未删除；1--已删除。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='下载信息表';

-- ----------------------------
-- Records of tb_download_message
-- ----------------------------
INSERT INTO `tb_download_message` VALUES ('388372046305820672', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:51:51', '2017-12-07 16:53:28', '1', '1');
INSERT INTO `tb_download_message` VALUES ('388372742254100480', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:37', '2017-12-11 14:52:47', '1', '1');
INSERT INTO `tb_download_message` VALUES ('388372744317698048', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:37', '2017-12-07 16:54:37', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372746788143104', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:38', '2017-12-07 16:54:38', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372749082427392', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:38', '2017-12-07 16:54:38', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372751687090176', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:39', '2017-12-07 16:54:39', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372801511227392', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:51', '2017-12-07 16:54:51', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372802605940736', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:51', '2017-12-07 16:54:51', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372803553853440', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:51', '2017-12-07 16:54:51', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372805101551616', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:52', '2017-12-07 16:54:52', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372806334676992', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:52', '2017-12-07 16:54:52', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372808201142272', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:53', '2017-12-07 16:54:53', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372809534930944', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:53', '2017-12-07 16:54:53', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372810860331008', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:53', '2017-12-07 16:54:53', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372812215091200', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:54', '2017-12-07 16:54:54', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372813741817856', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:54', '2017-12-07 16:54:54', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372815193047040', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:54', '2017-12-07 16:54:54', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372816426172416', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:55', '2017-12-07 16:54:55', '1', '0');
INSERT INTO `tb_download_message` VALUES ('388372818468798464', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:55', '2017-12-07 17:01:22', '1', '1');
INSERT INTO `tb_download_message` VALUES ('388372976162045952', 'www.baidu.com', 'hello world', 'www.sina.com', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:55:33', '2017-12-07 17:01:37', '1', '1');
INSERT INTO `tb_download_message` VALUES ('388706791065649152', 'www.baidu.com', 'lvpenghui', 'www.sina.com', '1', 'lvpenghui', 'lvpenghui', '2017-12-08 15:02:01', '2017-12-08 15:02:01', '2', '0');
INSERT INTO `tb_download_message` VALUES ('388716408319508480', 'www.baidu.com', 'lvpenghui', 'www.sina.com', '1', 'lvpenghui', 'lvpenghui', '2017-12-08 15:40:13', '2017-12-08 15:40:13', '2', '0');
INSERT INTO `tb_download_message` VALUES ('389756712388657152', 'www.pic.com', 'ceshititle', 'www.attach', '1', 'lvpenghui', 'lvpenghui', '2017-12-11 12:34:01', '2017-12-11 12:34:01', '1', '0');
INSERT INTO `tb_download_message` VALUES ('390562215633092608', 'www.test.com', '标题', 'url', '1', 'lvpenghui', 'lvpenghui', '2017-12-13 17:54:48', '2017-12-13 17:54:48', '0', '0');

-- ----------------------------
-- Table structure for tb_login_history
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_history`;
CREATE TABLE `tb_login_history` (
  `id` bigint(64) NOT NULL COMMENT '自增主键',
  `picture_url` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' COMMENT '用户头像url',
  `name` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT '1' COMMENT '分类选择：1--品牌元素；2--ppt模板；3--广告模板；',
  `email` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT '0' COMMENT '下载次数',
  `login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除：0--未删除；1--已删除。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='用户登录信息';

-- ----------------------------
-- Records of tb_login_history
-- ----------------------------

-- ----------------------------
-- Table structure for tb_picture_word
-- ----------------------------
DROP TABLE IF EXISTS `tb_picture_word`;
CREATE TABLE `tb_picture_word` (
  `id` bigint(64) NOT NULL COMMENT '自增主键',
  `picture_url` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' COMMENT '图片url',
  `title` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT 'unknown' COMMENT '下载信息--标题',
  `article` varchar(2000) CHARACTER SET utf8 NOT NULL DEFAULT 'test' COMMENT '暂无文章',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '分类选择：1--品牌元素；2--ppt模板；3--广告模板；4--可爱元素；5--精彩分享；',
  `creator` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'unknown' COMMENT '创建者',
  `updater` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'unknown' COMMENT '修改者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '序列号',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除：0--未删除；1--已删除。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='发布图文表';

-- ----------------------------
-- Records of tb_picture_word
-- ----------------------------
INSERT INTO `tb_picture_word` VALUES ('388372205190250496', 'www.baidu.com', 'hello world', 'www.sina.comsdadasdasdasdasdasdasdaasdsda', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:52:29', '2017-12-07 16:53:04', '1', '1');
INSERT INTO `tb_picture_word` VALUES ('388372635970437120', 'www.baidu.com', 'hello world', 'www.sina.comsdadasdasdasdasdasdasdaasdsda', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:12', '2017-12-11 14:45:49', '1', '1');
INSERT INTO `tb_picture_word` VALUES ('388372638008868864', 'www.baidu.com', 'hello world', 'www.sina.comsdadasdasdasdasdasdasdaasdsda', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:12', '2017-12-07 16:54:12', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388372640596754432', 'www.baidu.com', 'hello world', 'www.sina.comsdadasdasdasdasdasdasdaasdsda', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:13', '2017-12-07 16:54:13', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388372643193028608', 'www.baidu.com', 'hello world', 'www.sina.comsdadasdasdasdasdasdasdaasdsda', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:13', '2017-12-07 16:54:13', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388372646254870528', 'www.baidu.com', 'hello world', 'www.sina.comsdadasdasdasdasdasdasdaasdsda', '3', 'lvpenghui', 'lvpenghui', '2017-12-07 16:54:14', '2017-12-07 16:54:14', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373410926821376', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:16', '2017-12-07 16:57:16', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373415397949440', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:17', '2017-12-07 16:57:17', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373417834840064', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:18', '2017-12-07 16:57:18', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373420808601600', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:19', '2017-12-07 16:57:19', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373423790751744', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:19', '2017-12-07 16:57:19', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373425527193600', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:20', '2017-12-07 16:57:20', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373426638684160', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:20', '2017-12-07 16:57:20', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373428089913344', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:20', '2017-12-07 16:57:20', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373430069624832', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:21', '2017-12-07 16:57:21', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373431223058432', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:21', '2017-12-07 16:57:21', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373432649121792', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:21', '2017-12-07 16:57:21', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373433706086400', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:22', '2017-12-07 16:57:22', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373435044069376', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:22', '2017-12-07 16:57:22', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373436587573248', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:22', '2017-12-07 16:57:22', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373438764417024', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:23', '2017-12-07 16:57:23', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373440375029760', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:23', '2017-12-07 16:57:23', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373441666875392', 'www.baidu.com', 'hello world', 'www.sina.2', '1', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:24', '2017-12-07 16:57:24', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('388373505541931008', 'qwe.baidu.com', 'hello world', 'www.sina.2', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:39', '2017-12-07 16:57:39', '3', '0');
INSERT INTO `tb_picture_word` VALUES ('388373530317684736', 'qwe.baidu.com', 'hello world', 'www.sina.2', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:45', '2017-12-07 17:14:26', '3', '1');
INSERT INTO `tb_picture_word` VALUES ('388373531437563904', 'qwe.baidu.com', 'hello world', 'www.sina.2', '2', 'lvpenghui', 'lvpenghui', '2017-12-07 16:57:45', '2017-12-07 17:00:40', '3', '1');
INSERT INTO `tb_picture_word` VALUES ('389771116450676736', 'netease.com', 'ceshititle', 'topic', '1', 'lvpenghui', 'lvpenghui', '2017-12-11 13:31:15', '2017-12-11 13:31:15', '1', '0');
INSERT INTO `tb_picture_word` VALUES ('390562466091761664', 'www.test.com', '标题', 'url', '1', 'lvpenghui', 'lvpenghui', '2017-12-13 17:55:48', '2017-12-13 17:55:48', '0', '0');

-- ----------------------------
-- Table structure for tb_publish_history
-- ----------------------------
DROP TABLE IF EXISTS `tb_publish_history`;
CREATE TABLE `tb_publish_history` (
  `id` bigint(64) NOT NULL COMMENT '历史主键',
  `picture_url` varchar(128) CHARACTER SET utf8 NOT NULL DEFAULT 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' COMMENT '图片url',
  `title` varchar(100) CHARACTER SET utf8 NOT NULL DEFAULT 'unknow' COMMENT '标题',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '分类选择：1--品牌元素；2--ppt模板；3--广告模板；4--可爱元素；5--精彩分享；',
  `table_choose` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'tb_download_message' COMMENT '对应表',
  `delete_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除：0--未删除；1--已删除。',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='发布历史表';

-- ----------------------------
-- Records of tb_publish_history
-- ----------------------------
INSERT INTO `tb_publish_history` VALUES ('388372046305820672', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '1');
INSERT INTO `tb_publish_history` VALUES ('388372108775784448', 'www.baidu.com', 'ces', '1', 'tb_banner_manage', '1');
INSERT INTO `tb_publish_history` VALUES ('388372205190250496', 'www.baidu.com', 'hello world', '3', 'tb_picture_word', '1');
INSERT INTO `tb_publish_history` VALUES ('388372635970437120', 'www.baidu.com', 'hello world', '3', 'tb_picture_word', '1');
INSERT INTO `tb_publish_history` VALUES ('388372638008868864', 'www.baidu.com', 'hello world', '3', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388372640596754432', 'www.baidu.com', 'hello world', '3', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388372643193028608', 'www.baidu.com', 'hello world', '3', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388372646254870528', 'www.baidu.com', 'hello world', '3', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388372666815348736', 'www.baidu.com', 'ces', '1', 'tb_banner_manage', '1');
INSERT INTO `tb_publish_history` VALUES ('388372670539890688', 'www.baidu.com', 'ces', '1', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388372674360901632', 'www.baidu.com', 'ces', '1', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388372678534234112', 'www.baidu.com', 'ces', '1', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388372683131191296', 'www.baidu.com', 'ces', '1', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388372742254100480', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '1');
INSERT INTO `tb_publish_history` VALUES ('388372744317698048', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372746788143104', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372749082427392', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372751687090176', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372801511227392', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372802605940736', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372803553853440', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372805101551616', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372806334676992', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372808201142272', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372809534930944', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372810860331008', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372812215091200', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372813741817856', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372815193047040', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372816426172416', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388372818468798464', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '1');
INSERT INTO `tb_publish_history` VALUES ('388372976162045952', 'www.baidu.com', 'hello world', '2', 'tb_download_message', '1');
INSERT INTO `tb_publish_history` VALUES ('388373071762817024', 'baidu.com', 'www', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373072974970880', 'baidu.com', 'www', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373074677858304', 'baidu.com', 'www', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373076116504576', 'baidu.com', 'www', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373077815197696', 'baidu.com', 'www', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373079681662976', 'baidu.com', 'www', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373081233555456', 'baidu.com', 'www', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373082542178304', 'baidu.com', 'www', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373083871772672', 'baidu.com', 'www', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373085352361984', 'baidu.com', 'www', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373114376945664', 'baidu.com', 'www', '3', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373115635236864', 'baidu.com', 'www', '3', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373116776087552', 'baidu.com', 'www', '3', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373118806130688', 'baidu.com', 'www', '3', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373120509018112', 'baidu.com', 'www', '3', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373122035744768', 'baidu.com', 'www', '3', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373123793158144', 'baidu.com', 'www', '3', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373125135335424', 'baidu.com', 'www', '3', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373331700613120', 'www.baidu.com', 'test', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373334770843648', 'www.baidu.com', 'test', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373335882334208', 'www.baidu.com', 'test', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373337782353920', 'www.baidu.com', 'test', '2', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('388373339065810944', 'www.baidu.com', 'test', '2', 'tb_banner_manage', '1');
INSERT INTO `tb_publish_history` VALUES ('388373340680617984', 'www.baidu.com', 'test', '2', 'tb_banner_manage', '1');
INSERT INTO `tb_publish_history` VALUES ('388373410926821376', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373415397949440', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373417834840064', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373420808601600', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373423790751744', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373425527193600', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373426638684160', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373428089913344', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373430069624832', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373431223058432', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373432649121792', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373433706086400', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373435044069376', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373436587573248', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373438764417024', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373440375029760', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373441666875392', 'www.baidu.com', 'hello world', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373505541931008', 'qwe.baidu.com', 'hello world', '2', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('388373530317684736', 'qwe.baidu.com', 'hello world', '2', 'tb_picture_word', '1');
INSERT INTO `tb_publish_history` VALUES ('388373531437563904', 'qwe.baidu.com', 'hello world', '2', 'tb_picture_word', '1');
INSERT INTO `tb_publish_history` VALUES ('388706791065649152', 'www.baidu.com', 'lvpenghui', '1', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('388716408319508480', 'www.baidu.com', 'lvpenghui', '1', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('389739802938834944', 'www.tencent.com', 'ceshibiaoti', '1', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('389752427047288832', 'www.tencent.com', 'ceshibiaoti', '1', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('389756712388657152', 'www.pic.com', 'ceshititle', '1', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('389771116450676736', 'netease.com', 'ceshititle', '1', 'tb_picture_word', '0');
INSERT INTO `tb_publish_history` VALUES ('390560203352834048', 'www.test.com', '标题', '1', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('390561974687105024', 'www.test.com', '标题', '1', 'tb_banner_manage', '0');
INSERT INTO `tb_publish_history` VALUES ('390562215633092608', 'www.test.com', '标题', '1', 'tb_download_message', '0');
INSERT INTO `tb_publish_history` VALUES ('390562466091761664', 'www.test.com', '标题', '1', 'tb_picture_word', '0');
