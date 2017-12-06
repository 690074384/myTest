/*==============================================================*/
/* DBMS name:      MySQL 5.5                                    */
/* Created on:     2017/12/5 18:08:49                           */
/*==============================================================*/


drop table if exists tb_banner_manage;

drop table if exists tb_download_message;

drop table if exists tb_login_history;

drop table if exists tb_picutre_word;

/*==============================================================*/
/* Table: tb_banner_manage                                      */
/*==============================================================*/
create table tb_banner_manage
(
   id                   bigint(64) not null comment '自增主键',
   picture_url          varchar(128) not null default 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' comment '图片url',
   type                 tinyint not null default 1 comment '分类选择：1--品牌元素；2--ppt模板；3--广告模板；',
   download_times       int(11) not null default 0 comment '下载次数',
   creator              varchar(50) not null default 'unknown' comment '创建者',
   updater              varchar(50) not null default 'unknown' comment '修改者',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   sequence             int(11) not null default 0 comment '序列号',
   delete_flag          tinyint not null default 0 comment '是否删除：0--未删除；1--已删除。',
   primary key (id)
);

alter table tb_banner_manage comment 'banner管理';

/*==============================================================*/
/* Table: tb_download_message                                   */
/*==============================================================*/
create table tb_download_message
(
   id                   bigint(64) not null comment '自增主键',
   picture_url          varchar(128) not null default 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' comment '图片url',
   title                varchar(100) not null default '未定义标题' comment '下载信息--标题',
   attachment_url       varchar(128) not null default 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' comment '附件url',
   type                 tinyint not null default 1 comment '分类选择：1--品牌元素；2--ppt模板；3--广告模板；',
   download_times       int(11) not null default 0 comment '下载次数',
   creator              varchar(50) not null default 'unknown' comment '创建者',
   updater              varchar(50) not null default 'unknown' comment '修改者',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   sequence             int(11) not null default 0 comment '序列号',
   delete_flag          tinyint not null default 0 comment '是否删除：0--未删除；1--已删除。',
   primary key (id)
);

alter table tb_download_message comment '下载信息表';

/*==============================================================*/
/* Table: tb_login_history                                      */
/*==============================================================*/
create table tb_login_history
(
   id                   bigint(64) not null comment '自增主键',
   picture_url          varchar(128) not null default 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' comment '用户头像url',
   name                 varchar(128) not null default '1' comment '分类选择：1--品牌元素；2--ppt模板；3--广告模板；',
   email                varchar(128) not null default '0' comment '下载次数',
   login_time           `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '创建时间',
   delete_flag          tinyint not null default 0 comment '是否删除：0--未删除；1--已删除。',
   primary key (id)
);

alter table tb_login_history comment '用户登录信息';

/*==============================================================*/
/* Table: tb_picutre_word                                       */
/*==============================================================*/
create table tb_picutre_word
(
   id                   bigint(64) not null comment '自增主键',
   picture_url          varchar(128) not null default 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' comment '图片url',
   title                varchar(100) not null default '未定义标题' comment '下载信息--标题',
   artical              varchar(2000) not null default 'test' comment '暂无文章',
   type                 tinyint not null default 1 comment '分类选择：1--品牌元素；2--ppt模板；3--广告模板；',
   download_times       int(11) not null default 0 comment '下载次数',
   creator              varchar(50) not null default 'unknown' comment '创建者',
   updater              varchar(50) not null default 'unknown' comment '修改者',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   sequence             int(11) not null default 0 comment '序列号',
   delete_flag          tinyint not null default 0 comment '是否删除：0--未删除；1--已删除。',
   primary key (id)
);

alter table tb_picutre_word comment '发布图文表';

