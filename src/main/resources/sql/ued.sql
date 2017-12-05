/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
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
   id                   bigint(64) not null comment '��������',
   picture_url          varchar(128) not null default 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' comment 'ͼƬurl',
   type                 tinyint not null default 1 comment '����ѡ��1--Ʒ��Ԫ�أ�2--pptģ�壻3--���ģ�壻',
   download_times       int(11) not null default 0 comment '���ش���',
   creator              varchar(50) not null default 'unknown' comment '������',
   updater              varchar(50) not null default 'unknown' comment '�޸���',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          timestamp not null default CURRENT_TIMESTAMP comment '�޸�ʱ��',
   sequence             int(11) not null default 0 comment '���к�',
   delete_flag          tinyint not null default 0 comment '�Ƿ�ɾ����0--δɾ����1--��ɾ����',
   primary key (id)
);

alter table tb_banner_manage comment 'banner����';

/*==============================================================*/
/* Table: tb_download_message                                   */
/*==============================================================*/
create table tb_download_message
(
   id                   bigint(64) not null comment '��������',
   picture_url          varchar(128) not null default 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' comment 'ͼƬurl',
   title                varchar(100) not null default 'δ�������' comment '������Ϣ--����',
   attachment_url       varchar(128) not null default 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' comment '����url',
   type                 tinyint not null default 1 comment '����ѡ��1--Ʒ��Ԫ�أ�2--pptģ�壻3--���ģ�壻',
   download_times       int(11) not null default 0 comment '���ش���',
   creator              varchar(50) not null default 'unknown' comment '������',
   updater              varchar(50) not null default 'unknown' comment '�޸���',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          timestamp not null default CURRENT_TIMESTAMP comment '�޸�ʱ��',
   sequence             int(11) not null default 0 comment '���к�',
   delete_flag          tinyint not null default 0 comment '�Ƿ�ɾ����0--δɾ����1--��ɾ����',
   primary key (id)
);

alter table tb_download_message comment '������Ϣ��';

/*==============================================================*/
/* Table: tb_login_history                                      */
/*==============================================================*/
create table tb_login_history
(
   id                   bigint(64) not null comment '��������',
   picture_url          varchar(128) not null default 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' comment '�û�ͷ��url',
   name                 varchar(128) not null default '1' comment '����ѡ��1--Ʒ��Ԫ�أ�2--pptģ�壻3--���ģ�壻',
   email                varchar(128) not null default '0' comment '���ش���',
   login_time           timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   delete_flag          tinyint not null default 0 comment '�Ƿ�ɾ����0--δɾ����1--��ɾ����',
   primary key (id)
);

alter table tb_login_history comment '�û���¼��Ϣ';

/*==============================================================*/
/* Table: tb_picutre_word                                       */
/*==============================================================*/
create table tb_picutre_word
(
   id                   bigint(64) not null comment '��������',
   picture_url          varchar(128) not null default 'http://m.sunlands.com/16/BJ/pc/ec2tG7/index.html' comment 'ͼƬurl',
   title                varchar(100) not null default 'δ�������' comment '������Ϣ--����',
   artical              varchar(2000) not null default 'test' comment '��������',
   type                 tinyint not null default 1 comment '����ѡ��1--Ʒ��Ԫ�أ�2--pptģ�壻3--���ģ�壻',
   download_times       int(11) not null default 0 comment '���ش���',
   creator              varchar(50) not null default 'unknown' comment '������',
   updater              varchar(50) not null default 'unknown' comment '�޸���',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '����ʱ��',
   update_time          timestamp not null default CURRENT_TIMESTAMP comment '�޸�ʱ��',
   sequence             int(11) not null default 0 comment '���к�',
   delete_flag          tinyint not null default 0 comment '�Ƿ�ɾ����0--δɾ����1--��ɾ����',
   primary key (id)
);

alter table tb_picutre_word comment '����ͼ�ı�';

