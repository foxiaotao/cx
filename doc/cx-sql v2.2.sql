/*
SQLyog v10.2 
MySQL - 5.0.18-nt : Database - cx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cx` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `cx`;

/*Table structure for table `achievement` */

DROP TABLE IF EXISTS `achievement`;

CREATE TABLE `achievement` (
  `aid` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) collate utf8_bin default NULL,
  `members` varchar(50) collate utf8_bin default NULL,
  `url` varchar(255) collate utf8_bin default NULL,
  `year` varchar(5) collate utf8_bin default NULL,
  `type` varchar(1) collate utf8_bin default NULL,
  `contextPath` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `achievement` */

insert  into `achievement`(`aid`,`name`,`members`,`url`,`year`,`type`,`contextPath`) values (1,'一种多功能辅助手杖的设计','孙涛，周炯，陈云浩','E:/filePath/2014/05/20/f261dcdc-d613-432f-85c2-2816ab06184b_孙涛手杖.bmp','2013','1','_pic/2014/05/20/96df0a3c-0bf7-4347-aa07-17c75b2bf164_孙涛手杖.bmp'),(2,'2013全国大学生数学建模三等奖','周洪建，杨娟娟，张雪松','E:/filePath/2014/05/20/28aac4c0-07a0-4ee9-8c86-e2127f5723bb_img318.jpg','2013','2','_pic/2014/05/20/9d3bafc0-7419-4f24-b5fa-543f46293123_img318.jpg'),(3,'国家新型实用专利','徐世涛','E:/filePath/2014/05/20/6cc0300c-7e9a-41b3-a3ba-79fc4a7b2aa6_徐世涛专利证书2012左安友.jpg','2012','0','_pic/2014/05/20/c0aa2aef-e269-4fb3-8aa6-75d57a122857_徐世涛专利证书2012左安友.jpg'),(4,'理学院科技实践创新中心共享系统','孙涛','E:/filePath/2014/05/20/cd6c4d4a-eff8-470c-a131-68232434f2f2_孙涛手杖.bmp','2014','3','_pic/2014/05/20/dd934f4b-bbc7-4167-a8cf-22cd9809f08d_孙涛手杖.bmp'),(5,'创新中心签到系统','张进','E:/filePath/2014/05/20/f1db0a02-a84c-43cb-94ec-dd504ceb0827_孙涛手杖.bmp','2014','3','_pic/2014/05/20/01075f7b-1965-467d-8f5a-edcd0c1c7043_孙涛手杖.bmp'),(6,'武陵山数字化物种管理','汪竟，向长城','E:/filePath/2014/05/20/0709cb2f-c1b8-4115-9c18-81300900a6ef_汪竟.bmp','2013','3','_pic/2014/05/20/bea7adf5-2bbe-4f20-939e-f0db1dac0f79_汪竟.bmp');

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bid` bigint(20) NOT NULL auto_increment,
  `name` varchar(20) collate utf8_bin default NULL,
  `price` double default NULL,
  `statue` varchar(1) collate utf8_bin default NULL,
  `start` date default NULL,
  `end` date default NULL,
  `uid` bigint(20) default NULL,
  `No` varchar(20) collate utf8_bin default NULL,
  PRIMARY KEY  (`bid`),
  KEY `FK1FAF09FD62021F` (`uid`),
  CONSTRAINT `FK1FAF09FD62021F` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `book` */

insert  into `book`(`bid`,`name`,`price`,`statue`,`start`,`end`,`uid`,`No`) values (4,'数学建模',56,'1','2014-05-22',NULL,71,'C201201'),(5,'数学建模与论文写作指导',46,'1','2014-05-24',NULL,2,'C201202'),(6,'3D在现在社会中的应用',58,'0',NULL,NULL,NULL,'rrrrgzdgf'),(8,'C++',58,'0',NULL,NULL,NULL,'C201205'),(9,'JAVA核心',100,'1','2014-05-22',NULL,62,'C201206'),(10,'10天学会51单片机',56,'1','2014-05-24',NULL,2,'c201401');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `did` bigint(20) NOT NULL auto_increment,
  `name` varchar(30) collate utf8_bin default NULL,
  `description` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `department` */

insert  into `department`(`did`,`name`,`description`) values (2,'物理实验与论文部','物理实验与论文部，单片机研究'),(3,'程序设计部','c，java等高级语言研究'),(4,'数学建模与论文部','主要参加全国大学生数学建模比赛 '),(5,'机械设计工程部','3D模型与机械设计'),(6,'单片机开发部','单片机，电子研究'),(7,'师范技能部','主要参加讲课类的比赛'),(8,'数学竞赛','参加全国数学竞赛');

/*Table structure for table `files` */

DROP TABLE IF EXISTS `files`;

CREATE TABLE `files` (
  `fid` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) collate utf8_bin default NULL,
  `url` varchar(255) collate utf8_bin default NULL,
  `approve` varchar(1) collate utf8_bin default NULL,
  `desctiption` varchar(255) collate utf8_bin default NULL,
  `type` varchar(1) collate utf8_bin default NULL,
  `uploadtime` date default NULL,
  `length` bigint(20) default NULL,
  `uid` bigint(20) default NULL,
  `did` bigint(20) default NULL,
  `md5` varchar(40) collate utf8_bin default NULL,
  `description` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`fid`),
  KEY `FK40BCA57FD62021F` (`uid`),
  KEY `FK40BCA577F8C86D5` (`did`),
  CONSTRAINT `FK40BCA577F8C86D5` FOREIGN KEY (`did`) REFERENCES `department` (`did`),
  CONSTRAINT `FK40BCA57FD62021F` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `files` */

insert  into `files`(`fid`,`name`,`url`,`approve`,`desctiption`,`type`,`uploadtime`,`length`,`uid`,`did`,`md5`,`description`) values (35,'智能优化作业.rar','E:/filePath/2014/05/09/null_智能优化作业.rar','0',NULL,'0','2014-05-09',16896094,2,3,NULL,'1478'),(36,'word公式编辑器绿色版.rar','E:/filePath/2014/05/09/null_word公式编辑器绿色版.rar','1',NULL,'0','2014-05-09',1905197,2,3,NULL,'1478'),(37,'myeclipse-pro-2013-offline-installer-windows.exe','E:/filePath/2014/05/09/null_myeclipse-pro-2013-offline-installer-windows.exe','0',NULL,'0','2014-05-09',1076061568,2,3,NULL,'1478'),(38,'cx0507.rar','E:/filePath/2014/05/09/null_cx0507.rar','0',NULL,'1','2014-05-09',27750013,3,3,NULL,'1596'),(39,'理学院科技创新中心共享系统的设计-1稿1.doc','E:/filePath/2014/05/10/null_理学院科技创新中心共享系统的设计-1稿1.doc','0',NULL,'1','2014-05-10',1418861,2,3,NULL,'我的毕业论文'),(40,'学生综合评价管理系统的设计与实现一稿.doc','E:/filePath/2014/05/10/null_学生综合评价管理系统的设计与实现一稿.doc','0',NULL,'1','2014-05-10',2324638,2,3,NULL,'我的毕业论文'),(41,'环境变量的配置.txt','E:/filePath/2014/05/10/null_环境变量的配置.txt','0',NULL,'1','2014-05-10',514,2,3,NULL,'我的毕业论文'),(42,'MySQL安装图解.doc','E:/filePath/2014/05/10/null_MySQL安装图解.doc','0',NULL,'1','2014-05-10',2205184,2,3,NULL,'我的毕业论文'),(43,'T_014_统计.doc','E:/filePath/2014/05/11/null_T_014_统计.doc','0',NULL,'1','2014-05-11',1239040,3,6,NULL,'电风扇方法'),(44,'T_010_微分方程.doc','E:/filePath/2014/05/11/null_T_010_微分方程.doc','0',NULL,'1','2014-05-11',859648,3,3,NULL,'二二俺认为'),(45,'firebug-fx.xpi','E:/filePath/2014/05/12/null_firebug-fx.xpi','0',NULL,'0','2014-05-12',2298147,2,7,NULL,'生生世世是'),(47,'day38_Oracle.zip','E:/filePath/2014/05/21/null_day38_Oracle.zip','0',NULL,'0','2014-05-21',6816,2,3,NULL,'oracle'),(50,'Firefox-setup.exe','E:/filePath/2014/05/21/null_Firefox-setup.exe','0',NULL,'0','2014-05-21',681128,3,3,NULL,'发生的发生地'),(53,'Javascript权威指南.chm','E:/filePath/2014/05/21/null_Javascript权威指南.chm','0',NULL,'0','2014-05-21',1421188,2,3,NULL,'api   是'),(54,'spring课程.doc','E:/filePath/2014/05/21/null_spring课程.doc','0',NULL,'0','2014-05-21',1670144,2,3,NULL,'api   是'),(55,'CSS.CHM','E:/filePath/2014/05/21/null_CSS.CHM','0',NULL,'0','2014-05-21',264762,2,3,NULL,'api   是'),(56,'jquery-1.8.3.min.js','E:/filePath/2014/05/21/null_jquery-1.8.3.min.js','0',NULL,'0','2014-05-21',93637,2,3,NULL,'api   是'),(57,'W3CSchool中文版.chm','E:/filePath/2014/05/21/null_W3CSchool中文版.chm','0',NULL,'0','2014-05-21',11818410,2,3,NULL,'api   是'),(58,'JavaScript对象与数组参考大全 .chm','E:/filePath/2014/05/22/null_JavaScript对象与数组参考大全 .chm','0',NULL,'1','2014-05-22',17990,16,3,NULL,'1234'),(59,'JDK_API_1_6_zh_CN.chw','E:/filePath/2014/05/22/null_JDK_API_1_6_zh_CN.chw','0',NULL,'1','2014-05-22',360647,16,3,NULL,'1234'),(60,'JDK_API_1_6_zh_CN.chw','E:/filePath/2014/05/22/null_JDK_API_1_6_zh_CN.chw','0',NULL,'1','2014-05-22',360647,16,3,NULL,'1234'),(61,'JavaEE笔记.chm','E:/filePath/2014/05/22/null_JavaEE笔记.chm','0',NULL,'1','2014-05-22',6383515,16,3,NULL,'1234'),(62,'zTreeAPI v2.5.chm','E:/filePath/2014/05/22/null_zTreeAPI v2.5.chm','0',NULL,'1','2014-05-22',113972,16,3,NULL,'1234'),(63,'赛事方向 03版.doc','E:/filePath/2014/05/22/null_赛事方向 03版.doc','0',NULL,'0','2014-05-22',39936,16,5,NULL,'赛事方向'),(64,'关于举办湖北民族学院第三届三维数字化创新设计大赛的.doc','E:/filePath/2014/05/22/null_关于举办湖北民族学院第三届三维数字化创新设计大赛的.doc','0',NULL,'1','2014-05-22',41472,16,5,NULL,'关于举办第七届三维数字化创新设计大赛的通知');

/*Table structure for table `privilege` */

DROP TABLE IF EXISTS `privilege`;

CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL,
  `pid` bigint(20) default NULL,
  `name` varchar(30) collate utf8_bin default NULL,
  `url` varchar(255) collate utf8_bin default NULL,
  `checked` bit(1) default NULL,
  `open` bit(1) default NULL,
  `flag` varchar(1) collate utf8_bin default NULL,
  `icon` varchar(100) collate utf8_bin default NULL,
  `target` varchar(10) collate utf8_bin default NULL,
  `isParent` bit(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `privilege` */

insert  into `privilege`(`id`,`pid`,`name`,`url`,`checked`,`open`,`flag`,`icon`,`target`,`isParent`) values (1,0,'个人设置',NULL,NULL,NULL,'1','css/images/MenuIcon/FUNC241000.gif',NULL,''),(2,0,'中心共享资料',NULL,NULL,'','1','css/images/MenuIcon/FUNC20007.gif',NULL,''),(3,0,'竞赛信息','http://lxykc.hbmy.edu.cn/cxzx/index.php?m=content&c=index&a=lists&catid=12',NULL,NULL,'1','css/images/MenuIcon/FUNC235000.gif',NULL,'\0'),(4,0,'中心新闻','http://lxykc.hbmy.edu.cn/cxzx/index.php?m=content&c=index&a=lists&catid=42',NULL,NULL,'1','css/images/MenuIcon/ie.gif',NULL,'\0'),(5,0,'组织结构',NULL,NULL,NULL,'1','css/images/MenuIcon/FUNC241000.gif',NULL,'\0'),(6,0,'优秀成果',NULL,NULL,'','1','css/images/MenuIcon/FUNC20054.gif',NULL,''),(7,0,'文件资源维护',NULL,NULL,'','1','css/images/MenuIcon/FUNC20069.gif',NULL,''),(8,0,'成员维护',NULL,NULL,'','1','css/images/MenuIcon/FUNC20001.gif',NULL,''),(9,0,'系统维护',NULL,NULL,'','1','css/images/MenuIcon/system.gif',NULL,''),(10,1,'修改密码','userAction_updatePasswordUI.action',NULL,NULL,'1','css/images/MenuIcon/FUNC261000.gif','right','\0'),(11,0,'项目管理',NULL,NULL,'','1','css/images/MenuIcon/formmodel.gif',NULL,''),(12,0,'招新工作',NULL,NULL,NULL,'1','css/images/MenuIcon/FUNC261000.gif',NULL,''),(13,1,'个人信息','userAction_personalInformation.action',NULL,NULL,'1','css/images/MenuIcon/address.gif','right','\0'),(14,1,'个人信息修改','userAction_updateInfoUI.action',NULL,NULL,'1','css/images/MenuIcon/address.gif','right','\0'),(21,2,'公共资料','filesAction_showFilesByConditionshare.action',NULL,NULL,'1','css/images/MenuIcon/FUNC23700.gif','right','\0'),(22,2,'个人资料','filesAction_showFilesByConditionByMyself.action',NULL,NULL,'1','css/images/MenuIcon/FUNC261000.gif','right','\0'),(61,6,'专利','achievementAction_showAchievementByPage.action?achievementQuery.type=0',NULL,NULL,'1','css/images/MenuIcon/formmodel.gif','right','\0'),(62,6,'论文','achievementAction_showAchievementByPage.action?achievementQuery.type=1',NULL,NULL,'1','css/images/MenuIcon/formmodel.gif','right','\0'),(63,6,'竞赛','achievementAction_showAchievementByPage.action?achievementQuery.type=2',NULL,NULL,'1','css/images/MenuIcon/formmodel.gif','right','\0'),(64,6,'软件','achievementAction_showAchievementByPage.action?achievementQuery.type=3',NULL,NULL,'1','css/images/MenuIcon/formmodel.gif','right','\0'),(71,7,'文件维护','filesAction_showFilesByCondition.action',NULL,NULL,'1','css/images/MenuIcon/FUNC20076.gif','right','\0'),(72,7,'文件上传','filesAction_addUI.action',NULL,NULL,'1','css/images/MenuIcon/FUNC20057.gif','right','\0'),(73,7,'文件审核','filesAction_approveUI.action',NULL,NULL,'1','css/images/MenuIcon/manager.gif','right','\0'),(76,7,'删除本人文件',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(81,8,'查看成员','userAction_showUserByCondition.action',NULL,NULL,'1','css/images/MenuIcon/search.gif','right','\0'),(82,8,'添加成员','userAction_addUI.action',NULL,NULL,'1','css/images/MenuIcon/FUNC20001.gif','right','\0'),(83,8,'批量删除成员',NULL,NULL,NULL,'2','css/images/MenuIcon/FUNC20001.gif',NULL,'\0'),(84,8,'修改成员',NULL,NULL,NULL,'2','css/images/MenuIcon/FUNC20001.gif',NULL,'\0'),(91,9,'角色管理','roleAction_showAllRole.action',NULL,NULL,'1','css/images/MenuIcon/FUNC20001.gif','right','\0'),(93,9,'部门管理','departmentAction_showAllDepartment.action',NULL,NULL,'1','css/images/MenuIcon/department.gif','right','\0'),(101,1011,'查看全部图书','bookAction_showBookByCondition.action',NULL,NULL,'1','css/images/MenuIcon/FUNC251000.gif','right','\0'),(102,1011,'查看已借图书','bookAction_showBookByConditionBorrowed.action',NULL,NULL,'1','css/images/MenuIcon/FUNC55000.gif','right','\0'),(111,11,'项目文件','projectFileAction_showAllProjectFile.action',NULL,NULL,'1','css/images/MenuIcon/FUNC20029.gif','right','\0'),(112,11,'项目管理','projectAction_showProjectByPage.action',NULL,NULL,'1','css/images/MenuIcon/menu_line_3.gif','right','\0'),(121,12,'审批流程管理',NULL,NULL,NULL,'1','css/images/MenuIcon/FUNC20057.gif',NULL,'\0'),(122,12,'表单模板管理',NULL,NULL,NULL,'1','css/images/MenuIcon/time_date.gif',NULL,'\0'),(123,12,'发起申请',NULL,NULL,NULL,'1','css/images/MenuIcon/FUNC241000.gif',NULL,'\0'),(124,12,'审批处理',NULL,NULL,NULL,'1','css/images/MenuIcon/FUNC20029.gif',NULL,'\0'),(125,12,'面试安排',NULL,NULL,NULL,'1','css/images/MenuIcon/address.gif',NULL,'\0'),(126,12,'试用期表现',NULL,NULL,NULL,'1','css/images/MenuIcon/FUNC261000.gif',NULL,'\0'),(127,12,'我的申请',NULL,NULL,NULL,'1','css/images/MenuIcon/FUNC261000.gif',NULL,'\0'),(128,12,'我的审核任务',NULL,NULL,NULL,'1','css/images/MenuIcon/FUNC261000.gif',NULL,'\0'),(601,6,'成果浏览',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(602,6,'成果添加',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(603,6,'成果修改',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(604,6,'成果删除',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(1001,3,'添加比赛信息',NULL,NULL,NULL,'2',NULL,NULL,NULL),(1002,3,'删除比赛信息',NULL,NULL,NULL,'2',NULL,NULL,NULL),(1011,0,'图书管理',NULL,NULL,NULL,'1','css/images/MenuIcon/FUNC20056.gif',NULL,''),(1111,111,'项目文件上传',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(1112,111,'项目文件删除',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(1113,111,'项目文件下载',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(1121,112,'项目浏览',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(1122,112,'项目添加',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(1123,112,'项目修改',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(1124,112,'项目删除',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(2001,4,'添加新闻',NULL,NULL,NULL,'2',NULL,NULL,NULL),(2002,4,'删除新闻',NULL,NULL,NULL,'2',NULL,NULL,NULL),(3001,5,'添加组织结构',NULL,NULL,NULL,'2',NULL,NULL,NULL),(3002,5,'修改组织结构',NULL,NULL,NULL,'2',NULL,NULL,NULL),(3003,5,'删除组织结构',NULL,NULL,NULL,'2',NULL,NULL,NULL),(5002,8,'成员添加',NULL,NULL,NULL,'2',NULL,NULL,NULL),(5003,8,'成员删除',NULL,NULL,NULL,'2',NULL,NULL,NULL),(5004,8,'添加管理员',NULL,NULL,NULL,'2',NULL,NULL,NULL),(5005,8,'查看他所有上传',NULL,NULL,NULL,'2',NULL,NULL,NULL),(6001,9,'角色权限设置',NULL,NULL,NULL,'2',NULL,NULL,NULL),(6002,91,'角色删除',NULL,NULL,NULL,'2',NULL,NULL,NULL),(6003,91,'角色添加',NULL,NULL,NULL,'2',NULL,NULL,NULL),(6004,91,'角色修改',NULL,NULL,NULL,'2',NULL,NULL,NULL),(7001,93,'部门添加',NULL,NULL,NULL,'2',NULL,NULL,NULL),(7002,93,'部门修改',NULL,NULL,NULL,'2',NULL,NULL,NULL),(7003,93,'部门删除',NULL,NULL,NULL,'2',NULL,NULL,NULL),(7004,93,'部门查看',NULL,NULL,NULL,'2',NULL,NULL,NULL),(8001,7,'文件下载',NULL,NULL,NULL,'2',NULL,NULL,NULL),(8002,7,'文件上传',NULL,NULL,NULL,'2',NULL,NULL,NULL),(8003,7,'文件修改',NULL,NULL,NULL,'2',NULL,NULL,NULL),(8004,7,'文件删除',NULL,NULL,NULL,'2',NULL,NULL,NULL),(10111,1011,'添加图书',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(10112,1011,'修改图书',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(10113,1011,'删除图书',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(10114,1011,'借书',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(10115,1011,'还书',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(10116,8,'发送邮件',NULL,NULL,NULL,'2',NULL,NULL,'\0'),(10117,1011,'导出借阅excel',NULL,NULL,NULL,'2',NULL,NULL,'\0');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `pid` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) collate utf8_bin default NULL,
  `No` varchar(20) collate utf8_bin default NULL,
  `members` varchar(30) collate utf8_bin default NULL,
  `start` date default NULL,
  `year` varchar(5) collate utf8_bin default NULL,
  `statue` varchar(1) collate utf8_bin default NULL,
  `type` varchar(1) collate utf8_bin default NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `project` */

insert  into `project`(`pid`,`name`,`No`,`members`,`start`,`year`,`statue`,`type`) values (1,'理学院科技创新中心共享系统','X201409','周洪建，孙涛，胡越','2014-04-10','2014','0','0'),(2,'武陵山区物种数字化管理平台','x201308','汪竟，孙涛，刘海鹏，张进','2013-04-03','2013','0','1');

/*Table structure for table `projectfile` */

DROP TABLE IF EXISTS `projectfile`;

CREATE TABLE `projectfile` (
  `pfid` bigint(20) NOT NULL auto_increment,
  `name` varchar(100) collate utf8_bin default NULL,
  `url` varchar(255) collate utf8_bin default NULL,
  PRIMARY KEY  (`pfid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `projectfile` */

insert  into `projectfile`(`pfid`,`name`,`url`) values (3,'2014年项目结题报告.doc','E:/filePath/2014/05/18/0b529dc3-eaec-402a-a791-02e11e642c9b_2014年项目结题报告.doc'),(8,'进度报告.doc','E:/filePath/2014/05/18/69d93f3b-9e2a-4dfd-aa66-e8e9797f2f53_进度报告.doc'),(9,'项目汇总表公示.doc','E:/filePath/2014/05/18/2c5c52d0-911e-46d4-96a6-d110ad520b3c_项目汇总表公示.doc'),(10,'理学院2013年省级项目汇总表.xls','E:/filePath/2014/05/18/8226a83f-0106-4222-8e27-1d244c9f910a_理学院2013年省级项目汇总表.xls');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `rid` bigint(20) NOT NULL auto_increment,
  `name` varchar(20) collate utf8_bin default NULL,
  `description` varchar(30) collate utf8_bin default NULL,
  `checked` bit(1) default NULL,
  PRIMARY KEY  (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `role` */

insert  into `role`(`rid`,`name`,`description`,`checked`) values (2,'成员','没有添加功能',NULL),(3,'管理员','可添加成员，文件上传，文件审批，删除成员，添加信息',NULL),(4,'超级管理员','可添加管理员和成员，文件上传，文件审批，删除成员，添加信息',NULL),(5,'测试组数据，请勿选择','测试组数据，请勿选择',NULL);

/*Table structure for table `role_privilege` */

DROP TABLE IF EXISTS `role_privilege`;

CREATE TABLE `role_privilege` (
  `id` bigint(20) NOT NULL,
  `rid` bigint(20) NOT NULL,
  PRIMARY KEY  (`rid`,`id`),
  KEY `FK45FBD6286AA85448` (`id`),
  KEY `FK45FBD628FD608B87` (`rid`),
  CONSTRAINT `FK45FBD6286AA85448` FOREIGN KEY (`id`) REFERENCES `privilege` (`id`),
  CONSTRAINT `FK45FBD628FD608B87` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `role_privilege` */

insert  into `role_privilege`(`id`,`rid`) values (1,2),(1,3),(1,4),(2,2),(2,3),(2,4),(3,2),(3,3),(3,4),(4,2),(4,3),(4,4),(5,2),(5,3),(5,4),(6,2),(6,3),(6,4),(7,2),(7,3),(7,4),(8,3),(8,4),(9,2),(9,3),(9,4),(10,2),(10,3),(10,4),(11,2),(11,3),(11,4),(12,3),(12,4),(13,2),(13,3),(13,4),(14,2),(14,3),(14,4),(21,2),(21,3),(21,4),(22,2),(22,3),(22,4),(61,2),(61,3),(61,4),(62,2),(62,3),(62,4),(63,2),(63,3),(63,4),(64,2),(64,3),(64,4),(71,3),(71,4),(72,3),(72,4),(73,3),(73,4),(76,3),(76,4),(81,3),(81,4),(82,3),(82,4),(83,3),(83,4),(84,3),(84,4),(91,3),(91,4),(93,2),(93,3),(93,4),(101,2),(101,3),(101,4),(102,2),(102,3),(102,4),(111,2),(111,3),(111,4),(112,2),(112,3),(112,4),(121,3),(121,4),(122,3),(122,4),(123,3),(123,4),(124,3),(124,4),(125,3),(125,4),(126,3),(126,4),(127,3),(127,4),(128,3),(128,4),(601,2),(601,3),(601,4),(602,3),(602,4),(603,3),(603,4),(604,4),(1001,2),(1001,3),(1001,4),(1002,2),(1002,3),(1002,4),(1011,2),(1011,3),(1011,4),(1111,3),(1111,4),(1112,3),(1112,4),(1113,2),(1113,3),(1113,4),(1121,2),(1121,3),(1121,4),(1122,3),(1122,4),(1123,3),(1123,4),(1124,4),(2001,2),(2001,3),(2001,4),(2002,2),(2002,3),(2002,4),(3001,2),(3001,3),(3001,4),(3002,2),(3002,3),(3002,4),(3003,2),(3003,3),(3003,4),(5002,3),(5002,4),(5003,3),(5003,4),(5004,4),(5005,3),(5005,4),(6001,4),(6002,4),(6003,4),(6004,3),(6004,4),(7001,4),(7002,3),(7002,4),(7003,4),(7004,2),(7004,3),(7004,4),(8001,2),(8001,3),(8001,4),(8002,2),(8002,3),(8002,4),(8003,3),(8003,4),(8004,3),(8004,4),(10111,3),(10111,4),(10112,4),(10113,4),(10114,4),(10115,4),(10116,4),(10117,4);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` bigint(20) NOT NULL auto_increment,
  `username` varchar(20) collate utf8_bin default NULL,
  `number` varchar(12) collate utf8_bin default NULL,
  `password` varchar(20) collate utf8_bin default NULL,
  `phone` varchar(11) collate utf8_bin default NULL,
  `email` varchar(30) collate utf8_bin default NULL,
  `sex` varchar(2) collate utf8_bin default NULL,
  `address` varchar(100) collate utf8_bin default NULL,
  `age` bigint(20) default NULL,
  `joindate` date default NULL,
  `year` bigint(20) default NULL,
  `did` bigint(20) default NULL,
  `rid` bigint(20) default NULL,
  PRIMARY KEY  (`uid`),
  KEY `FK285FEB7F8C86D5` (`did`),
  KEY `FK285FEBFD608B87` (`rid`),
  CONSTRAINT `FK285FEB7F8C86D5` FOREIGN KEY (`did`) REFERENCES `department` (`did`),
  CONSTRAINT `FK285FEBFD608B87` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`number`,`password`,`phone`,`email`,`sex`,`address`,`age`,`joindate`,`year`,`did`,`rid`) values (2,'admin','admin','administrator','13597778033','384631173@qq.com','男','湖北利川',100,'2014-06-09',2014,2,4),(3,'涛哥','123','123','12345678909','260689116@qq.com','男','湖北利川',34,'2014-06-09',2014,2,2),(4,'孙涛','021040317','384631173','13597778033','384631173@qq.com','男','湖北利川',34,'2014-06-09',2014,2,3),(5,'张进','k021141510','123','12345678909','164257204@qq.com','男','湖北利川',34,'2014-06-09',2014,3,4),(16,'测试账号','a','aaa','12345678909','384631173@qq.com','男','湖北利川',34,'2014-06-09',2014,2,2),(21,'哥','d','d','12345678909','384631173@qq.com','男','湖北利川',34,'2014-06-09',2014,2,3),(62,'刘泉','021240214','421023','18372500061','1084524793@qq.com','男','湖北荆州',25,'2014-05-18',2012,6,3),(63,'张乾坤','021240618','diankun','18372500182','455835999@qq.com','男','湖北孝感',21,'2014-05-22',2012,4,3),(64,'胡越','021240505','021624','18372500143','1241305825@qq.com','男','湖北襄阳',20,'2014-05-22',2012,3,3),(65,'周棚','021140110','931479666','18727710019','931479666@qq.com','男','湖北利川',21,'2014-05-22',2011,6,3),(66,'李谦','021141207','123456','13669059467','419845955@qq.com','男','湖北荆州',21,'2014-05-22',2011,5,3),(67,'周炯','021141230','920528','18727710356','854490050@qq.com','男','湖北省恩施州鹤峰县',20,'2014-05-22',2011,6,4),(69,'周磊','021240230','000000','18372500080','274571483@qq.com','男','湖北恩施',22,'2014-05-22',2012,2,3),(71,'王晓宇','021241220','1220wxy','18372500355','1120664687@qq.com','男','山西吕梁',21,'2014-05-22',2012,5,3),(73,'瞿珊','021240710','123456','18372500197','745552716@qq.com','女','湖北荆州',20,'2014-05-22',2012,6,3),(75,'罗忠文','021241402','562059484','18372500386','644615651@qq.com','男','贵州黔南',20,'2014-05-22',2012,5,3),(76,'付元','021240810','123456','15171088674','2455383845@qq.com','女','湖北荆州',19,'2014-05-22',2012,4,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
