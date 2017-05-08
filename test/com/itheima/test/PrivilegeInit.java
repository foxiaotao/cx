package com.itheima.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.domain.Privilege;

public class PrivilegeInit {
	/**
	 * 插入两个类型的数据
	 *   1、菜单类型的数据
	 *   2、功能类型的数据
	 */
	
	//TODO test1
	@Test
	public void testSavePrivilege_Menuitem(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
/***********************************************************************************/
		/*
		 * 个人办公
		 */
		Privilege Privilegeitem1 = new Privilege();
		Privilegeitem1.setId(1L);
		Privilegeitem1.setIcon("css/images/MenuIcon/FUNC241000.gif");
		Privilegeitem1.setName("个人设置");
		Privilegeitem1.setPid(0L);
		Privilegeitem1.setFlag("1");
		Privilegeitem1.setIsParent(true);
		
		Privilege Privilege2 = new Privilege();
		Privilege2.setId(012L);
		Privilege2.setIcon("css/images/MenuIcon/FUNC261000.gif");
		Privilege2.setName("修改密码");
		//Privilege2.setChecked(false);
		Privilege2.setPid(1L);
		Privilege2.setFlag("1");
		Privilege2.setIsParent(false);
		
		Privilege Privilege21 = new Privilege();
		Privilege21.setId(13L);
		Privilege21.setIcon("css/images/MenuIcon/address.gif");
		Privilege21.setName("个人信息");
		//Privilege21.setChecked(false);
		Privilege21.setPid(1L);
		Privilege21.setFlag("1");
		Privilege21.setIsParent(false);
		
		
		Privilege Privilege22 = new Privilege();
		Privilege22.setId(14L);
		Privilege22.setIcon("css/images/MenuIcon/address.gif");
		Privilege22.setName("个人信息修改");
		//Privilege22.setChecked(false);
		Privilege22.setPid(1L);
		Privilege22.setFlag("1");
		Privilege22.setIsParent(false);
		
		Privilege Privilege23 = new Privilege();
		Privilege23.setId(2L);
		Privilege23.setIcon("css/images/MenuIcon/FUNC20007.gif");
		Privilege23.setName("中心共享资料");
		//Privilege23.setChecked(false);
		Privilege23.setPid(0L);
		Privilege23.setFlag("1");
		Privilege23.setIsParent(true);
		
		Privilege Privilege24 = new Privilege();
		Privilege24.setId(21L);
		Privilege24.setIcon("css/images/MenuIcon/FUNC23700.gif");
		Privilege24.setName("公共资料");
		//Privilege24.setChecked(false);
		Privilege24.setPid(2L);
		Privilege24.setFlag("1");
		Privilege24.setIsParent(false);
		
		Privilege Privilege25 = new Privilege();
		Privilege25.setId(22L);
		Privilege25.setIcon("css/images/MenuIcon/FUNC261000.gif");
		Privilege25.setName("个人资料");
		//Privilege25.setChecked(false);
		Privilege25.setPid(2L);
		Privilege25.setFlag("1");
		Privilege25.setIsParent(false);
/*********************************************************************************/	
		/*
		 * 审批流转
		 */
		Privilege Privilege3 = new Privilege();
		Privilege3.setId(3L);
		///Privilege3.setChecked(false);
		Privilege3.setIsParent(false);
		Privilege3.setPid(0L);
		Privilege3.setName("审批流转");
		Privilege3.setFlag("1");
		Privilege3.setIcon("css/images/MenuIcon/FUNC235000.gif");
		
		Privilege Privilege31 = new Privilege();
		Privilege31.setId(4L);
		//Privilege31.setChecked(false);
		Privilege31.setIsParent(false);
		Privilege31.setPid(0L);
		Privilege31.setFlag("1");
		Privilege31.setName("中心新闻");
		Privilege31.setIcon("css/images/MenuIcon/ie.gif");
		
		Privilege Privilege32 = new Privilege();
		Privilege32.setId(5L);
		//Privilege32.setChecked(false);
		Privilege32.setIsParent(false);
		Privilege32.setPid(0L);
		Privilege32.setFlag("1");
		Privilege32.setName("组织结构");
		Privilege32.setIcon("css/images/MenuIcon/FUNC241000.gif");
		
		Privilege Privilege33 = new Privilege();
		Privilege33.setId(6L);
		Privilege33.setIsParent(false);
		//Privilege33.setChecked(false);
		Privilege33.setPid(0L);
		Privilege33.setFlag("1");
		Privilege33.setName("优秀成果及个人");
		Privilege33.setIcon("css/images/MenuIcon/FUNC20054.gif");
		
		Privilege Privilege34 = new Privilege();
		Privilege34.setId(7L);
		Privilege34.setIsParent(true);
		//Privilege34.setChecked(false);
		Privilege34.setPid(0L);
		Privilege34.setFlag("1");
		Privilege34.setName("文件资源维护");
		Privilege34.setIcon("css/images/MenuIcon/FUNC20069.gif");
		
		Privilege Privilege35 = new Privilege();
		Privilege35.setId(71L);
		Privilege35.setIsParent(false);
		//Privilege35.setChecked(false);
		Privilege35.setPid(7L);
		Privilege35.setName("文件上传");
		Privilege35.setFlag("1");
		Privilege35.setIcon("css/images/MenuIcon/FUNC20057.gif");
/************************************************************************************/
		/*
		 * 知识管理
		 */
		Privilege Privilege4 = new Privilege();
		Privilege4.setId(72L);
		Privilege4.setIsParent(false);
		//Privilege4.setChecked(false);
		Privilege4.setPid(7L);
		Privilege4.setFlag("1");
		Privilege4.setName("文件维护");
		Privilege4.setIcon("css/images/MenuIcon/FUNC20076.gif");
/*******************************************************************************/
		/*
		 * 综合行政
		 */
		Privilege Privilege5 = new Privilege();
		Privilege5.setId(73L);
		Privilege5.setIsParent(false);
		//Privilege5.setChecked(false);
		Privilege5.setPid(7L);
		Privilege5.setFlag("1");
		Privilege5.setName("文件审核");
		Privilege5.setIcon("css/images/MenuIcon/manager.gif");
		
		Privilege Privilege51 = new Privilege();
		Privilege51.setId(74L);
		Privilege51.setIsParent(false);
		//Privilege51.setChecked(false);
		Privilege51.setPid(7L);
		Privilege51.setName("个人文件批量删除");
		Privilege51.setFlag("1");
		Privilege51.setIcon("css/images/MenuIcon/shoutCut.gif");
		
		Privilege Privilege52 = new Privilege();
		Privilege52.setId(75L);
		Privilege52.setIsParent(false);
		//Privilege52.setChecked(false);
		Privilege52.setPid(7L);
		Privilege52.setFlag("1");
		Privilege52.setName("共享文件批量删除");
		Privilege52.setIcon("css/images/MenuIcon/waitThing.gif");
		
		Privilege Privilege53 = new Privilege();
		Privilege53.setId(8L);
		Privilege53.setIsParent(true);
		//Privilege53.setChecked(false);
		Privilege53.setPid(0L);
		Privilege53.setFlag("1");
		Privilege53.setName("成员维护");
		Privilege53.setIcon("css/images/MenuIcon/FUNC20001.gif");
/**************************************************************************************/
		/*
		 * 人力资源管理
		 * 	档案管理
		 * 	培训记录
		 * 	奖金记录
		 * 	职位变更
		 * 	人事合同
		 * 	薪酬制度
		 */
		Privilege Privilege6 = new Privilege();
		Privilege6.setId(81L);
		Privilege6.setIsParent(false);
		//Privilege6.setChecked(false);
		Privilege6.setPid(8L);
		Privilege6.setFlag("1");
		Privilege6.setName("查看成员");
		Privilege6.setIcon("css/images/MenuIcon/search.gif");
		
//		Privilege Privilege61 = new Privilege();
//		Privilege61.setId(82L);
//		Privilege61.setIsParent(false);
//		//Privilege61.setChecked(false);
//		Privilege61.setPid(8L);
//		Privilege61.setFlag("1");
//		Privilege61.setName("添加成员");
//		Privilege61.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		
		Privilege Privilege84 = new Privilege();
		Privilege84.setId(84L);
		Privilege84.setIsParent(false);
		//Privilege61.setChecked(false);
		Privilege84.setPid(8L);
		Privilege84.setFlag("1");
		Privilege84.setName("修改成员");
		Privilege84.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		Privilege Privilege62 = new Privilege();
		Privilege62.setId(83L);
		Privilege62.setFlag("1");
		Privilege62.setIsParent(false);
		//Privilege62.setChecked(false);
		Privilege62.setPid(8L);
		Privilege62.setName("批量删除成员");
		Privilege62.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		Privilege Privilege63 = new Privilege();
		Privilege63.setId(9L);
		Privilege63.setFlag("1");
		Privilege63.setIsParent(true);
		//Privilege63.setChecked(false);
		Privilege63.setPid(0L);
		Privilege63.setName("系统维护");
		Privilege63.setIcon("css/images/MenuIcon/system.gif");
		
		Privilege Privilege64 = new Privilege();
		Privilege64.setId(91L);
		Privilege64.setIsParent(false);
		Privilege64.setFlag("1");
		//Privilege64.setChecked(false);
		Privilege64.setPid(9L);
		Privilege64.setName("角色权限");
		Privilege64.setIcon("css/images/MenuIcon/FUNC20001.gif");
		
		Privilege Privilege65 = new Privilege();
		Privilege65.setId(92L);
		Privilege65.setIsParent(false);
		//Privilege65.setChecked(false);
		Privilege65.setPid(9L);
		Privilege65.setFlag("1");
		Privilege65.setName("部门管理");
		Privilege65.setIcon("css/images/MenuIcon/department.gif");
		
		Privilege Privilege606 = new Privilege();
		Privilege606.setId(1011L);
		Privilege606.setIsParent(true);
		//Privilege66.setChecked(false);
		Privilege606.setPid(0L);
		Privilege606.setFlag("1");
		Privilege606.setName("图书管理");
		Privilege606.setIcon("css/images/MenuIcon/FUNC20056.gif");
/*****************************************************************************************/
		/*
		 * 电子邮件
		 */
		Privilege Privilege7 = new Privilege();
		Privilege7.setId(101L);
		Privilege7.setIsParent(false);
		//Privilege7.setChecked(false);
		Privilege7.setPid(1011L);
		Privilege7.setFlag("1");
		Privilege7.setName("查看全部图书");
		Privilege7.setIcon("css/images/MenuIcon/FUNC251000.gif");

/*******************************************************************/
		/*
		 * 实用工具
		 * 	车票预定
		 * 	GIS查询
		 * 	邮政编码
		 */
		Privilege Privilege8 = new Privilege();
		Privilege8.setId(102L);
		Privilege8.setIsParent(false);
		//Privilege8.setChecked(false);
		Privilege8.setPid(1011L);
		Privilege8.setFlag("1");
		Privilege8.setName("查看已借图书");
		Privilege8.setIcon("css/images/MenuIcon/FUNC55000.gif");
		
		

		
		Privilege Privilege81 = new Privilege();
		Privilege81.setId(11L);
		Privilege81.setIsParent(true);
		//Privilege81.setChecked(false);
		Privilege81.setPid(0L);
		Privilege81.setFlag("1");
		Privilege81.setName("项目管理");
		Privilege81.setIcon("css/images/MenuIcon/formmodel.gif");
		
		
		Privilege Privilege82 = new Privilege();
		Privilege82.setId(111L);
		Privilege82.setIsParent(false);
		//Privilege82.setChecked(false);
		Privilege82.setPid(11L);
		Privilege82.setFlag("1");
		Privilege82.setName("项目申报");
		Privilege82.setIcon("css/images/MenuIcon/FUNC20029.gif");
		
		
		Privilege Privilege83 = new Privilege();
		Privilege83.setId(112L);
		Privilege83.setIsParent(false);
		//Privilege83.setChecked(false);
		Privilege83.setFlag("1");
		Privilege83.setPid(11L);
		Privilege83.setName("项目阶段进度");
		Privilege83.setIcon("css/images/MenuIcon/menu_line_3.gif");
/**************************************************************************/
		/*
		 * 个人设置
		 * 		个人信息
		 * 		密码修改
		 */
		Privilege Privilege9 = new Privilege();
		Privilege9.setId(12L);
		Privilege9.setIsParent(true);
		//Privilege9.setChecked(false);
		Privilege9.setPid(0L);
		Privilege9.setFlag("1");
		Privilege9.setName("招新工作");
		Privilege9.setIcon("css/images/MenuIcon/FUNC261000.gif");
		
		
		Privilege Privilege91 = new Privilege();
		Privilege91.setId(121L);
		Privilege91.setIsParent(false);
		//Privilege91.setChecked(false);
		Privilege91.setPid(12L);
		Privilege91.setFlag("1");
		Privilege91.setName("审批流程管理");
		Privilege91.setIcon("css/images/MenuIcon/FUNC20057.gif");
		
		
		Privilege Privilege92 = new Privilege();
		Privilege92.setId(122L);
		Privilege92.setIsParent(false);
		//Privilege92.setChecked(false);
		Privilege92.setFlag("1");
		Privilege92.setPid(12L);
		Privilege92.setName("表单模板管理");
		Privilege92.setIcon("css/images/MenuIcon/time_date.gif");
/***********************************************************************************/
		/*
		 * 系统管理
		 * 	岗位管理
		 * 	部门管理
		 * 	用户管理
		 */
		Privilege Privilege10 = new Privilege();
		Privilege10.setId(123L);
		Privilege10.setIsParent(false);
		//Privilege10.setChecked(false);
		Privilege10.setPid(12L);
		Privilege10.setFlag("1");
		Privilege10.setName("发起申请");
		Privilege10.setIcon("css/images/MenuIcon/FUNC241000.gif");
		
		
		Privilege Privilege101 = new Privilege();
		Privilege101.setId(124L);
		Privilege101.setIsParent(false);
		//Privilege101.setChecked(false);
		Privilege101.setPid(12L);
		Privilege101.setFlag("1");
		Privilege101.setName("审批处理");
		Privilege101.setIcon("css/images/MenuIcon/FUNC20029.gif");
		
		
		Privilege Privilege102 = new Privilege();
		Privilege102.setId(125L);
		Privilege102.setIsParent(false);
		//Privilege102.setChecked(false);
		Privilege102.setPid(12L);
		Privilege102.setName("面试安排");
		Privilege102.setFlag("1");
		Privilege102.setIcon("css/images/MenuIcon/address.gif");
		
		
		Privilege Privilege103 = new Privilege();
		Privilege103.setId(126L);
		Privilege103.setIsParent(false);
		//Privilege103.setChecked(false);
		Privilege103.setPid(12L);
		Privilege103.setFlag("1");
		Privilege103.setName("试用期表现");
		Privilege103.setIcon("css/images/MenuIcon/FUNC261000.gif");
		
		
		Privilege Privilege127 = new Privilege();
		Privilege127.setId(127L);
		Privilege127.setIsParent(false);
		//Privilege127.setChecked(false);
		Privilege127.setPid(12L);
		Privilege127.setFlag("1");
		Privilege127.setName("我的申请");
		Privilege127.setIcon("css/images/MenuIcon/FUNC261000.gif");
		
		
		Privilege Privilege128 = new Privilege();
		Privilege128.setId(128L);
		Privilege128.setIsParent(false);
		//Privilege128.setChecked(false);
		Privilege128.setPid(12L);
		Privilege128.setFlag("1");
		Privilege128.setName("我的审核任务");
		Privilege128.setIcon("css/images/MenuIcon/FUNC261000.gif");
		
		
		Privilege Privilege601 = new Privilege();
		Privilege601.setId(61L);
		Privilege601.setIsParent(false);
		//Privilege128.setChecked(false);
		Privilege601.setPid(6L);
		Privilege601.setFlag("1");
		Privilege601.setName("专利");
		Privilege601.setIcon("css/images/MenuIcon/formmodel.gif");
		
		
		Privilege Privilege602 = new Privilege();
		Privilege602.setId(62L);
		Privilege602.setIsParent(false);
		//Privilege128.setChecked(false);
		Privilege602.setPid(6L);
		Privilege602.setFlag("1");
		Privilege602.setName("论文");
		Privilege602.setIcon("css/images/MenuIcon/formmodel.gif");
		
		
		Privilege Privilege603 = new Privilege();
		Privilege603.setId(63L);
		Privilege603.setIsParent(false);
		//Privilege128.setChecked(false);
		Privilege603.setPid(6L);
		Privilege603.setFlag("1");
		Privilege603.setName("竞赛");
		Privilege603.setIcon("css/images/MenuIcon/formmodel.gif");
		
		
		Privilege Privilege604 = new Privilege();
		Privilege604.setId(64L);
		Privilege604.setIsParent(false);
		//Privilege128.setChecked(false);
		Privilege604.setPid(6L);
		Privilege604.setFlag("1");
		Privilege604.setName("软件");
		Privilege604.setIcon("css/images/MenuIcon/formmodel.gif");
		
		
/**********************************************************************/
		/*
		 * {
		 * 	1,1
		 * 	2,5
		 * 	3,5
		 * 	4,1
		 * 	5,3
		 * 	6,6
		 * 	7,1
		 * 	8,3
		 * 	9,2
		 * 	10,3
		 * }
		 */
		
//		session.save(Privilegeitem1);
//		
//		session.save(Privilege2);
//		session.save(Privilege21);
//		session.save(Privilege22);
//		session.save(Privilege23);
//		session.save(Privilege24);
//		session.save(Privilege25);
//		
//		
//		session.save(Privilege3);
//		session.save(Privilege31);
//		session.save(Privilege32);
//		session.save(Privilege33);
//		session.save(Privilege34);
//		session.save(Privilege35);
//		
//		session.save(Privilege4);
//		
//		session.save(Privilege5);
//		session.save(Privilege51);
//		session.save(Privilege52);
//		session.save(Privilege53);
//		
//		session.save(Privilege6);
//		
//		session.save(Privilege61);
//		session.save(Privilege62);
//		session.save(Privilege63);
//		session.save(Privilege64);
//		session.save(Privilege65);
//		session.save(Privilege606);
//		
//		session.save(Privilege7);
//		
//		session.save(Privilege8);
//		session.save(Privilege81);
//		session.save(Privilege82);
//		session.save(Privilege83);
//		session.save(Privilege84);
//		
//		session.save(Privilege9);
//		session.save(Privilege91);
//		session.save(Privilege92);
//		
//		session.save(Privilege10);
//		session.save(Privilege101);
//		session.save(Privilege102);
//		session.save(Privilege103);
//		session.save(Privilege127);
//		session.save(Privilege128);
		
//		session.save(Privilege601);
//		session.save(Privilege602);
//		session.save(Privilege603);
//		session.save(Privilege604);
		
		transaction.commit();
		session.close();
	}
	
	/**
	 * 保存功能
	 */
	
	//TODO test2
	@Test
	public void testSavePrivilege_Function(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory)applicationContext.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		/*Privilege Privilege1 = new Privilege();
		Privilege1.setId(1001L);
		Privilege1.setFlag("2");
		Privilege1.setPid(0L);
		Privilege1.setName("添加比赛信息");
		
		
		Privilege Privilege2 = new Privilege();
		Privilege2.setId(1002L);
		Privilege2.setFlag("2");
		Privilege2.setPid(0L);
		Privilege2.setName("删除比赛信息");
		
		Privilege Privilege3 = new Privilege();
		Privilege3.setId(2001L);
		Privilege3.setFlag("2");
		Privilege3.setPid(0L);
		Privilege3.setName("添加新闻");
		
		Privilege Privilege32 = new Privilege();
		Privilege32.setId(2002L);
		Privilege32.setFlag("2");
		Privilege32.setPid(0L);
		Privilege32.setName("删除新闻");
		
		Privilege Privilege4 = new Privilege();
		Privilege4.setId(3001L);
		Privilege4.setFlag("2");
		Privilege4.setPid(0L);
		Privilege4.setName("添加组织结构");
		
		
		Privilege Privilege5 = new Privilege();
		Privilege5.setId(3002L);
		Privilege5.setFlag("2");
		Privilege5.setPid(0L);
		Privilege5.setName("修改组织结构");
		
		Privilege Privilege6 = new Privilege();
		Privilege6.setId(3003L);
		Privilege6.setFlag("2");
		Privilege6.setPid(0L);
		Privilege6.setName("删除组织结构");
		
		Privilege Privilege66 = new Privilege();
		Privilege66.setId(4001L);
		Privilege66.setFlag("2");
		Privilege66.setPid(0L);
		Privilege66.setName("添加优秀成果");
		
		Privilege Privilege7 = new Privilege();
		Privilege7.setId(4002L);
		Privilege7.setFlag("2");
		Privilege7.setPid(0L);
		Privilege7.setName("删除优秀成果");
		
		
		Privilege Privilege8 = new Privilege();
		Privilege8.setId(5001L);
		Privilege8.setFlag("2");
		Privilege8.setPid(0L);
		Privilege8.setName("成员查看");
		
		Privilege Privilege9 = new Privilege();
		Privilege9.setId(5002L);
		Privilege9.setFlag("2");
		Privilege9.setPid(0L);
		Privilege9.setName("成员添加");
		
		Privilege Privilege99 = new Privilege();
		Privilege99.setId(5003L);
		Privilege99.setFlag("2");
		Privilege99.setPid(0L);
		Privilege99.setName("成员删除");
		
		//-----------------------
		Privilege Privilege5004 = new Privilege();
		Privilege5004.setId(5004L);
		Privilege5004.setFlag("2");
		Privilege5004.setPid(0L);
		Privilege5004.setName("添加管理员");
		
		Privilege Privilege5005 = new Privilege();
		Privilege5005.setId(5005L);
		Privilege5005.setFlag("2");
		Privilege5005.setPid(0L);
		Privilege5005.setName("查看他所有上传");
		
		Privilege Privilege6001 = new Privilege();
		Privilege6001.setId(6001L);
		Privilege6001.setFlag("2");
		Privilege6001.setPid(0L);
		Privilege6001.setName("角色权限设置");
		
		
		Privilege Privilege6002 = new Privilege();
		Privilege6002.setId(6002L);
		Privilege6002.setFlag("2");
		Privilege6002.setPid(0L);
		Privilege6002.setName("角色删除");
		
		Privilege Privilege6003 = new Privilege();
		Privilege6003.setId(6003L);
		Privilege6003.setFlag("2");
		Privilege6003.setPid(0L);
		Privilege6003.setName("角色添加");
		
		Privilege Privilege6004 = new Privilege();
		Privilege6004.setId(6004L);
		Privilege6004.setFlag("2");
		Privilege6004.setPid(0L);
		Privilege6004.setName("角色修改");
		
		
		Privilege Privilege7001 = new Privilege();
		Privilege7001.setId(7001L);
		Privilege7001.setFlag("2");
		Privilege7001.setPid(0L);
		Privilege7001.setName("部门添加");
		
		Privilege Privilege7002 = new Privilege();
		Privilege7002.setId(7002L);
		Privilege7002.setFlag("2");
		Privilege7002.setPid(0L);
		Privilege7002.setName("部门修改");
		
		Privilege Privilege7003 = new Privilege();
		Privilege7003.setId(7003L);
		Privilege7003.setFlag("2");
		Privilege7003.setPid(0L);
		Privilege7003.setName("部门删除");
		
		Privilege Privilege7004 = new Privilege();
		Privilege7004.setId(7004L);
		Privilege7004.setFlag("2");
		Privilege7004.setPid(0L);
		Privilege7004.setName("部门查看");
		
		Privilege Privilege8001 = new Privilege();
		Privilege8001.setId(8001L);
		Privilege8001.setFlag("2");
		Privilege8001.setPid(0L);
		Privilege8001.setName("文件下载");
		
		
		Privilege Privilege8002 = new Privilege();
		Privilege8002.setId(8002L);
		Privilege8002.setFlag("2");
		Privilege8002.setPid(0L);
		Privilege8002.setName("文件上传");
		
		
		Privilege Privilege8003 = new Privilege();
		Privilege8003.setId(8003L);
		Privilege8003.setFlag("2");
		Privilege8003.setPid(0L);
		Privilege8003.setName("文件修改");
		
		
		Privilege Privilege8004 = new Privilege();
		Privilege8004.setId(8004L);
		Privilege8004.setFlag("2");
		Privilege8004.setPid(0L);
		Privilege8004.setName("文件删除");
		
		
		Privilege Privilege10111 = new Privilege();
		Privilege10111.setId(10111L);
		Privilege10111.setIsParent(false);
		Privilege10111.setPid(1011L);
		Privilege10111.setFlag("2");
		Privilege10111.setName("添加图书");
		
		
		Privilege Privilege10112 = new Privilege();
		Privilege10112.setId(10112L);
		Privilege10112.setIsParent(false);
		Privilege10112.setPid(1011L);
		Privilege10112.setFlag("2");
		Privilege10112.setName("修改图书");
		
		Privilege Privilege10113 = new Privilege();
		Privilege10113.setId(10113L);
		Privilege10113.setIsParent(false);
		Privilege10113.setPid(1011L);
		Privilege10113.setFlag("2");
		Privilege10113.setName("删除图书");
		
		Privilege Privilege10114 = new Privilege();
		Privilege10114.setId(10114L);
		Privilege10114.setIsParent(false);
		Privilege10114.setPid(1011L);
		Privilege10114.setFlag("2");
		Privilege10114.setName("借书");
		
		Privilege Privilege10115 = new Privilege();
		Privilege10115.setId(10115L);
		Privilege10115.setIsParent(false);
		Privilege10115.setPid(1011L);
		Privilege10115.setFlag("2");
		Privilege10115.setName("还书");
		
		Privilege Privilege10116 = new Privilege();
		Privilege10116.setId(10116L);
		Privilege10116.setIsParent(false);
		Privilege10116.setPid(8L);
		Privilege10116.setFlag("2");
		Privilege10116.setName("发送邮件");
		
		
		Privilege Privilege1111 = new Privilege();
		Privilege1111.setId(1111L);
		Privilege1111.setIsParent(false);
		Privilege1111.setPid(111L);
		Privilege1111.setFlag("2");
		Privilege1111.setName("项目文件上传");
		
		Privilege Privilege1112 = new Privilege();
		Privilege1112.setId(1112L);
		Privilege1112.setIsParent(false);
		Privilege1112.setPid(111L);
		Privilege1112.setFlag("2");
		Privilege1112.setName("项目文件删除");
		
		Privilege Privilege1113 = new Privilege();
		Privilege1113.setId(1113L);
		Privilege1113.setIsParent(false);
		Privilege1113.setPid(111L);
		Privilege1113.setFlag("2");
		Privilege1113.setName("项目文件下载");
		
		
		Privilege Privilege1121 = new Privilege();
		Privilege1121.setId(1121L);
		Privilege1121.setIsParent(false);
		Privilege1121.setPid(112L);
		Privilege1121.setFlag("2");
		Privilege1121.setName("项目浏览");
		
		
		Privilege Privilege1122 = new Privilege();
		Privilege1122.setId(1122L);
		Privilege1122.setIsParent(false);
		Privilege1122.setPid(112L);
		Privilege1122.setFlag("2");
		Privilege1122.setName("项目添加");
		
		
		Privilege Privilege1123 = new Privilege();
		Privilege1123.setId(1123L);
		Privilege1123.setIsParent(false);
		Privilege1123.setPid(112L);
		Privilege1123.setFlag("2");
		Privilege1123.setName("项目修改");
		
		
		Privilege Privilege1124 = new Privilege();
		Privilege1124.setId(1124L);
		Privilege1124.setIsParent(false);
		Privilege1124.setPid(112L);
		Privilege1124.setFlag("2");
		Privilege1124.setName("项目删除");
		
		*/
		//
		Privilege Privilege6001 = new Privilege();
		Privilege6001.setId(601L);
		Privilege6001.setIsParent(false);
		Privilege6001.setPid(6L);
		Privilege6001.setFlag("2");
		Privilege6001.setName("成果浏览");
		
		Privilege Privilege6002 = new Privilege();
		Privilege6002.setId(602L);
		Privilege6002.setIsParent(false);
		Privilege6002.setPid(6L);
		Privilege6002.setFlag("2");
		Privilege6002.setName("成果添加");
		
		Privilege Privilege6003 = new Privilege();
		Privilege6003.setId(603L);
		Privilege6003.setIsParent(false);
		Privilege6003.setPid(6L);
		Privilege6003.setFlag("2");
		Privilege6003.setName("成果修改");
		
		Privilege Privilege6004 = new Privilege();
		Privilege6004.setId(604L);
		Privilege6004.setIsParent(false);
		Privilege6004.setPid(6L);
		Privilege6004.setFlag("2");
		Privilege6004.setName("成果删除");
		
		
		Privilege Privilege76 = new Privilege();
		Privilege76.setId(76L);
		Privilege76.setIsParent(false);
		Privilege76.setFlag("2");
		Privilege76.setPid(7L);
		Privilege76.setName("删除本人文件");
		
		
		
		Privilege Privilege10117 = new Privilege();
		Privilege10117.setId(10117L);
		Privilege10117.setIsParent(false);
		Privilege10117.setPid(1011L);
		Privilege10117.setFlag("2");
		Privilege10117.setName("导出借阅excel");
//		session.save(Privilege1);
//		session.save(Privilege2);
//		session.save(Privilege3);
//		session.save(Privilege32);
//		session.save(Privilege66);
//		session.save(Privilege99);
//		session.save(Privilege4);
//		session.save(Privilege5);
//		
//		session.save(Privilege6);
//		session.save(Privilege7);
//		session.save(Privilege8);
//		session.save(Privilege9);
//		//-----------
//		session.save(Privilege5004);
//		session.save(Privilege5005);
//		session.save(Privilege6001);
//		session.save(Privilege6002);
//		session.save(Privilege6003);
//		session.save(Privilege6004);
//		session.save(Privilege7001);
//		session.save(Privilege7002);
//		session.save(Privilege7003);
//		session.save(Privilege7004);
//		session.save(Privilege8001);
//		session.save(Privilege8002);
//		session.save(Privilege8003);
//		session.save(Privilege8004);
//		session.save(Privilege10111);
//		session.save(Privilege10112);
//		session.save(Privilege10113);
//		session.save(Privilege10114);
//		session.save(Privilege10115);
//		session.save(Privilege10116);
//		session.save(Privilege1111);
//		session.save(Privilege1112);
//		session.save(Privilege1113);
		
//		session.save(Privilege1121);
//		session.save(Privilege1122);
//		session.save(Privilege1123);
//		session.save(Privilege1124);
//		
		session.save(Privilege10117);
		
		transaction.commit();
		session.close();
	}
}
