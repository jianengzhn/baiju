/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/6/27 17:45:59                           */
/*==============================================================*/


drop table if exists t_sys_department;

drop table if exists t_sys_dictionary;

drop table if exists t_sys_dictionary_data;

drop table if exists t_sys_menu;

drop index I_SYS_PARAMS_KEY on t_sys_params;

drop table if exists t_sys_params;

drop table if exists t_sys_role;

drop table if exists t_sys_role_grant;

drop table if exists t_sys_role_spec;

drop table if exists t_sys_role_spec_bind;

drop table if exists t_sys_user;

drop table if exists t_sys_user_grant;

/*==============================================================*/
/* Table: t_sys_department                                      */
/*==============================================================*/
create table t_sys_department
(
   ID                   int not null auto_increment,
   ENT_CODE             varchar(32) comment '即营业执照上的统一社会信用代码',
   ENT_KEY              varchar(100) comment '企业的唯一标识，由系统生成，规则为：',
   ENT_NAME             varchar(40),
   CONTACT              varchar(20),
   TEL                  varchar(50),
   EMAIL                varchar(50),
   ADDRESS              varchar(200),
   UP_ENT_CODE          int,
   UNICODE              varchar(200) comment '描述部门的树结构,5位一个级别,如: 000001000010001',
   ENT_TYPE             varchar(5) comment '备用自字段,用于标识企业的个性化属性',
   ENT_FLAG             varchar(5) comment '备用自字段,用于标识企业的个性化属性',
   CREATOR_ID           int,
   CREATE_TIME          datetime,
   LAST_UP_ID           int,
   LAST_UPTIME          datetime,
   ADDS                 varchar(100) comment '企业相关的证明文件电子版',
   primary key (ID)
);

alter table t_sys_department comment '公司表（企业表）,存储企业相关信息，支持上下级关系。按照设计，业务上只允许有两级，目前库表支持多级';

alter table t_sys_department
 modify column ID int not null  AUTO_INCREMENT COMMENT '企业ID';

alter table t_sys_department
 modify column ENT_CODE varchar(32)   COMMENT '即营业执照上的统一社会信用代码';

alter table t_sys_department
 modify column ENT_KEY varchar(100)   COMMENT '企业的唯一标识，由系统生成，规则为：';

alter table t_sys_department
 modify column ENT_NAME varchar(40)   COMMENT '企业名称';

alter table t_sys_department
 modify column CONTACT varchar(20)   COMMENT '联系人';

alter table t_sys_department
 modify column TEL varchar(50)   COMMENT '联系电话';

alter table t_sys_department
 modify column EMAIL varchar(50)   COMMENT '联系邮箱';

alter table t_sys_department
 modify column ADDRESS varchar(200)   COMMENT '联系地址';

alter table t_sys_department
 modify column UP_ENT_CODE int   COMMENT '上级企业代码';

alter table t_sys_department
 modify column UNICODE varchar(200)   COMMENT '描述部门的树结构,5位一个级别,如: 000001000010001';

alter table t_sys_department
 modify column ENT_TYPE varchar(5)   COMMENT '备用自字段,用于标识企业的个性化属性';

alter table t_sys_department
 modify column ENT_FLAG varchar(5)   COMMENT '备用自字段,用于标识企业的个性化属性';

alter table t_sys_department
 modify column CREATOR_ID int   COMMENT '创建人ID';

alter table t_sys_department
 modify column CREATE_TIME datetime   COMMENT '创建时间';

alter table t_sys_department
 modify column LAST_UP_ID int   COMMENT '最后修改人ID';

alter table t_sys_department
 modify column LAST_UPTIME datetime   COMMENT '最后修改时间';

alter table t_sys_department
 modify column ADDS varchar(100)   COMMENT '企业相关的证明文件电子版';

/*==============================================================*/
/* Table: t_sys_dictionary                                      */
/*==============================================================*/
create table t_sys_dictionary
(
   ID                   int not null auto_increment,
   DIC_TYPE_FLAG        varchar(3),
   DIC_TYPE_CODE        varchar(50),
   DIC_TYPE_NAME        varchar(40),
   CREATE_TIME          datetime,
   CAN_UPDATE           char(1) default '0' comment '是否可更新,0:可维护（默认值） 1:不可维护',
   REMAIN               varchar(50),
   primary key (ID)
);

alter table t_sys_dictionary comment '系统数据字典主表';

alter table t_sys_dictionary
 modify column ID int not null  AUTO_INCREMENT COMMENT '字典ID';

alter table t_sys_dictionary
 modify column DIC_TYPE_FLAG varchar(3)   COMMENT '信息分类';

alter table t_sys_dictionary
 modify column DIC_TYPE_CODE varchar(50)   COMMENT '代码标识';

alter table t_sys_dictionary
 modify column DIC_TYPE_NAME varchar(40)   COMMENT '代码名称';

alter table t_sys_dictionary
 modify column CREATE_TIME datetime   COMMENT '创建时间';

alter table t_sys_dictionary
 modify column CAN_UPDATE char(1)  default '0' COMMENT '是否可更新,0:可维护（默认值） 1:不可维护';

alter table t_sys_dictionary
 modify column REMAIN varchar(50)   COMMENT '说明';

/*==============================================================*/
/* Table: t_sys_dictionary_data                                 */
/*==============================================================*/
create table t_sys_dictionary_data
(
   ID                   int not null auto_increment,
   DIC_TYPE_ID          int comment '对应字典ID',
   DIC_VALUE            varchar(50),
   DIC_NAME             varchar(100),
   DIC_ORDER            int,
   REMARK               varchar(100),
   primary key (ID)
);

alter table t_sys_dictionary_data comment '系统数据字典明细表';

alter table t_sys_dictionary_data
 modify column ID int not null  AUTO_INCREMENT COMMENT '信息ID';

alter table t_sys_dictionary_data
 modify column DIC_TYPE_ID int   COMMENT '对应字典ID';

alter table t_sys_dictionary_data
 modify column DIC_VALUE varchar(50)   COMMENT '信息值';

alter table t_sys_dictionary_data
 modify column DIC_NAME varchar(100)   COMMENT '信息名称';

alter table t_sys_dictionary_data
 modify column DIC_ORDER int   COMMENT '排序列';

alter table t_sys_dictionary_data
 modify column REMARK varchar(100)   COMMENT '备注';

/*==============================================================*/
/* Table: t_sys_menu                                            */
/*==============================================================*/
create table t_sys_menu
(
   ID                   int not null auto_increment,
   UP_ID                int,
   NAME                 varchar(40),
   ICON                 varchar(60),
   URL                  varchar(100),
   IS_LEAF              char(1) comment 'Y-是叶子结点，其它-不是叶子结点',
   ORDER_COL            int comment '到排序，即此列值越大，排序越靠前,同级别之间的排序',
   DEL_FLAG             char(1) default 'N' comment '删除标志,Y:已删除，N（默认值）或其它:正常未删除',
   PRE_COL1             varchar(100),
   PRE_COL2             varchar(200),
   primary key (ID)
);

alter table t_sys_menu comment '系统菜单表';

alter table t_sys_menu
 modify column ID int not null  AUTO_INCREMENT COMMENT '菜单ID';

alter table t_sys_menu
 modify column UP_ID int   COMMENT '上级ID';

alter table t_sys_menu
 modify column NAME varchar(40)   COMMENT '菜单名称';

alter table t_sys_menu
 modify column ICON varchar(60)   COMMENT '菜单图标';

alter table t_sys_menu
 modify column URL varchar(100)   COMMENT '菜单资源';

alter table t_sys_menu
 modify column IS_LEAF char(1)   COMMENT 'Y-是叶子结点，其它-不是叶子结点';

alter table t_sys_menu
 modify column ORDER_COL int   COMMENT '到排序，即此列值越大，排序越靠前,同级别之间的排序';

alter table t_sys_menu
 modify column DEL_FLAG char(1)  default 'N' COMMENT '删除标志,Y:已删除，N（默认值）或其它:正常未删除';

alter table t_sys_menu
 modify column PRE_COL1 varchar(100)   COMMENT '预留字段1';

alter table t_sys_menu
 modify column PRE_COL2 varchar(200)   COMMENT '预留字段2';

/*==============================================================*/
/* Table: t_sys_params                                          */
/*==============================================================*/
create table t_sys_params
(
   ID                   int not null auto_increment,
   PARM_TYPE            varchar(3) comment '备用，做为参数类别的标识',
   PARM_ORDER           int(10) comment '排序字段，数据越大越靠前，倒序排列',
   PARM_KEY             varchar(20) not null comment '此标识为逻辑主键，在此表中不可重复',
   PARM_NAME            varchar(40) comment '中文名称',
   PARM_VALUE           varchar(50),
   PARM_DICR            varchar(50),
   REMARK               varchar(240),
   primary key (ID)
);

alter table t_sys_params comment '保存全局性的系统参数，供系统及各子系统使用';

alter table t_sys_params
 modify column ID int not null  AUTO_INCREMENT COMMENT '参数ID';

alter table t_sys_params
 modify column PARM_TYPE varchar(3)   COMMENT '备用，做为参数类别的标识';

alter table t_sys_params
 modify column PARM_ORDER int(10)   COMMENT '排序字段，数据越大越靠前，倒序排列';

alter table t_sys_params
 modify column PARM_KEY varchar(20) not null  COMMENT '此标识为逻辑主键，在此表中不可重复';

alter table t_sys_params
 modify column PARM_NAME varchar(40)   COMMENT '中文名称';

alter table t_sys_params
 modify column PARM_VALUE varchar(50)   COMMENT '参数值';

alter table t_sys_params
 modify column PARM_DICR varchar(50)   COMMENT '参数说明';

alter table t_sys_params
 modify column REMARK varchar(240)   COMMENT '备注';

/*==============================================================*/
/* Index: I_SYS_PARAMS_KEY                                      */
/*==============================================================*/
create unique index I_SYS_PARAMS_KEY on t_sys_params
(
   PARM_KEY
);

/*==============================================================*/
/* Table: t_sys_role                                            */
/*==============================================================*/
create table t_sys_role
(
   ID                   int not null auto_increment,
   ROLE_NAME            varchar(40),
   ROLE_DESCRIPTION     varchar(100),
   REMARK               varchar(100),
   primary key (ID)
);

alter table t_sys_role comment '用于保存用户角色';

alter table t_sys_role
 modify column ID int not null  AUTO_INCREMENT COMMENT '角色ID';

alter table t_sys_role
 modify column ROLE_NAME varchar(40)   COMMENT '角色名称';

alter table t_sys_role
 modify column ROLE_DESCRIPTION varchar(100)   COMMENT '角色描述';

alter table t_sys_role
 modify column REMARK varchar(100)   COMMENT '备注';

/*==============================================================*/
/* Table: t_sys_role_grant                                      */
/*==============================================================*/
create table t_sys_role_grant
(
   ID                   int not null auto_increment,
   ROLE_ID              int,
   MENU_ID              int,
   GRANT_TYPE           char(1) comment 'M-菜单授权，B-按钮授权',
   GRANT_FLAG           int(4) comment '1查，2增，4改，8删，16审，AND关系',
   BUTTON_ID            int comment '备用，暂时用不到 ',
   BTN_CODE             varchar(40) comment '存这个按钮在页面上的组件ID，在一个页面下应该保持唯一。',
   OPER_ID              int,
   OPER_TIME            datetime,
   primary key (ID)
);

alter table t_sys_role_grant comment '对角色的授权表，主要是菜单授权';

alter table t_sys_role_grant
 modify column ID int not null  AUTO_INCREMENT COMMENT '权限ID';

alter table t_sys_role_grant
 modify column ROLE_ID int   COMMENT '角色ID';

alter table t_sys_role_grant
 modify column MENU_ID int   COMMENT '菜单ID';

alter table t_sys_role_grant
 modify column GRANT_TYPE char(1)   COMMENT 'M-菜单授权，B-按钮授权';

alter table t_sys_role_grant
 modify column GRANT_FLAG int(4)   COMMENT '1查，2增，4改，8删，16审，AND关系';

alter table t_sys_role_grant
 modify column BUTTON_ID int   COMMENT '备用，暂时用不到 ';

alter table t_sys_role_grant
 modify column BTN_CODE varchar(40)   COMMENT '存这个按钮在页面上的组件ID，在一个页面下应该保持唯一。';

alter table t_sys_role_grant
 modify column OPER_ID int   COMMENT '授权者ID';

alter table t_sys_role_grant
 modify column OPER_TIME datetime   COMMENT '授权时间';

/*==============================================================*/
/* Table: t_sys_role_spec                                       */
/*==============================================================*/
create table t_sys_role_spec
(
   ID                   int not null auto_increment,
   ROLE_CODE            varchar(10),
   ROLE_NAME            varchar(40),
   REMARK               varchar(100),
   primary key (ID)
);

alter table t_sys_role_spec comment '用于保存系统内置角色,有特殊的业务含义,一般不允许维护';

alter table t_sys_role_spec
 modify column ID int not null  AUTO_INCREMENT COMMENT '角色ID';

alter table t_sys_role_spec
 modify column ROLE_CODE varchar(10)   COMMENT '角色标识';

alter table t_sys_role_spec
 modify column ROLE_NAME varchar(40)   COMMENT '角色名称';

alter table t_sys_role_spec
 modify column REMARK varchar(100)   COMMENT '备注';

/*==============================================================*/
/* Table: t_sys_role_spec_bind                                  */
/*==============================================================*/
create table t_sys_role_spec_bind
(
   ID                   int not null auto_increment,
   ROLE_ID              int,
   SPEC_ID              int,
   EXT1                 varchar(20),
   primary key (ID)
);

alter table t_sys_role_spec_bind comment '特定角色与角色绑定表';

alter table t_sys_role_spec_bind
 modify column ID int not null  AUTO_INCREMENT COMMENT '绑定ID';

alter table t_sys_role_spec_bind
 modify column ROLE_ID int   COMMENT '角色ID';

alter table t_sys_role_spec_bind
 modify column SPEC_ID int   COMMENT '特定角色ID';

alter table t_sys_role_spec_bind
 modify column EXT1 varchar(20)   COMMENT '备用';

/*==============================================================*/
/* Table: t_sys_user                                            */
/*==============================================================*/
create table t_sys_user
(
   ID                   int not null auto_increment,
   ENT_ID               int,
   ACCOUNT              varchar(50),
   NAME                 varchar(20),
   TEL                  varchar(50),
   EMAIL                varchar(50),
   PASSWORD             varchar(128),
   STATUS               char(1) default '1' comment '状态，1：正常（默认值）；2：删除；3：冻结',
   ENABLED              int(1),
   ACCT_NON_EXP         int(1),
   PWD__NON_EXP         int(1),
   ACCT_NON_LOCKED      int(1),
   ROLE                 int(1) comment '系统特定角，色管理员：1，普通用户：2',
   CREATOR_ID           int,
   CREATE_TIME          datetime,
   LAST_UP_ID           int,
   LAST_UPTIME          datetime,
   primary key (ID)
);

alter table t_sys_user comment '系统用户表，保存用户基本信息';

alter table t_sys_user
 modify column ID int not null  AUTO_INCREMENT COMMENT '用户ID';

alter table t_sys_user
 modify column ENT_ID int   COMMENT '所属企业ID';

alter table t_sys_user
 modify column ACCOUNT varchar(50)   COMMENT '登录账号';

alter table t_sys_user
 modify column NAME varchar(20)   COMMENT '用户名称';

alter table t_sys_user
 modify column TEL varchar(50)   COMMENT '联系电话';

alter table t_sys_user
 modify column EMAIL varchar(50)   COMMENT '个人邮箱';

alter table t_sys_user
 modify column PASSWORD varchar(128)   COMMENT '密码';

alter table t_sys_user
 modify column STATUS char(1)  default '1' COMMENT '状态，1：正常（默认值）；2：删除；3：冻结';

alter table t_sys_user
 modify column ENABLED int(1)   COMMENT '账号是否可用';

alter table t_sys_user
 modify column ACCT_NON_EXP int(1)   COMMENT '账号是否过期';

alter table t_sys_user
 modify column PWD__NON_EXP int(1)   COMMENT '密码是否过期';

alter table t_sys_user
 modify column ACCT_NON_LOCKED int(1)   COMMENT '账号是否锁定';

alter table t_sys_user
 modify column ROLE int(1)   COMMENT '系统特定角，色管理员：1，普通用户：2';

alter table t_sys_user
 modify column CREATOR_ID int   COMMENT '创建人ID';

alter table t_sys_user
 modify column CREATE_TIME datetime   COMMENT '创建时间';

alter table t_sys_user
 modify column LAST_UP_ID int   COMMENT '最后修改人ID';

alter table t_sys_user
 modify column LAST_UPTIME datetime   COMMENT '最后修改时间';

/*==============================================================*/
/* Table: t_sys_user_grant                                      */
/*==============================================================*/
create table t_sys_user_grant
(
   ID                   int not null auto_increment,
   USER_ID              int,
   ROLE_ID              int,
   PROXY_FLAG           char(1),
   PROXY_ID             int,
   FLAG                 varchar(4),
   OPER_ID              int,
   OPER_TIME            datetime,
   primary key (ID)
);

alter table t_sys_user_grant comment '系统用户授权表';

alter table t_sys_user_grant
 modify column ID int not null  AUTO_INCREMENT COMMENT '权限ID';

alter table t_sys_user_grant
 modify column USER_ID int   COMMENT '用户ID';

alter table t_sys_user_grant
 modify column ROLE_ID int   COMMENT '角色ID';

alter table t_sys_user_grant
 modify column PROXY_FLAG char(1)   COMMENT '代理标志';

alter table t_sys_user_grant
 modify column PROXY_ID int   COMMENT '代理人ID';

alter table t_sys_user_grant
 modify column FLAG varchar(4)   COMMENT '备用标志';

alter table t_sys_user_grant
 modify column OPER_ID int   COMMENT '授权者ID';

alter table t_sys_user_grant
 modify column OPER_TIME datetime   COMMENT '授权时间';

