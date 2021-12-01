package com.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.utils.MybatisUtils;

/**
 * 
 * 查询程序测试类
 *
 */

public class testQuery {
	@Test
	public void findByID() throws Exception
	{
//		//1.读取配置文件
//		String resource="mybatis-conf.xml";
//		InputStream resourteAstream = Resources.getResourceAsStream(resource);
//		//2.建立会话工厂
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourteAstream);
//		//3.利用工厂建立会话对象
//		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//使用工具类获取对象
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		
		//4.利用会话对象去执行mapper中的SQL语句
		User user=sqlSession.selectOne("com.mybatis.User.findByID", 10);
		//5.输出查询结果,user对象
		System.out.println(user);
		//6.关闭会话对象
		sqlSession.close();
		
	}
	
	/**
	 * 根据用户模糊查询
	 * @throws Exception
	 */
	
	@Test
	public void findByNane() throws Exception {
		//1.读取配置文件
		String resource = "mybatis-conf.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		//2.建立会话工厂
		SqlSessionFactory sqlsessionfactory  = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//3.利用工厂建立会话对象
		SqlSession sqlsession = sqlsessionfactory.openSession();
		//4.利用会话执行Mapper中的sql语句
		List<User> users=sqlsession.selectList("com.mybatis.User.findByName", "张");
		//5.输出查询结果
		for(User user:users) {
			System.out.println(user);
		}
		//6.关闭会话对象
		sqlsession.close();
	}
	
	/**
	 * 增加信息的方法
	 * @throws Exception
	 */
	
	@Test
	public void addUser() throws Exception {
		//1.读取配置文件
		String resource = "mybatis-conf.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		//2.建立会话工厂
		SqlSessionFactory sqlsessionfactory  = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//3.利用工厂建立会话对象
		SqlSession sqlsession = sqlsessionfactory.openSession();
		//4.利用会话执行Mapper中的sql语句
		//给新增加的user赋值
		User user=new User();
		user.setUsername("Ethan");
		user.setPsw("151124");
		user.setPhone("18852288");
		user.setEmail("Ethan@XXX.edu.cn");
		//5.使用sqlsession给会话对象赋值
		int row = sqlsession.insert("com.mybatis.User.AddUser",user);
		//6.判断是否执行成功
		if(row>0)
		{
			System.out.println("成功添加！");
		}else
		{
			System.out.println("操作失败！");
		}
		
		System.out.println(user.getId());
		
		//7.提交插入操作
		sqlsession.commit();
		//8.关闭会话对象
		sqlsession.close();
	}
	
	
	/**
	 * 删除信息的方法
	 * @throws Exception
	 */
	@Test
	public void deleteUser() throws Exception {	
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user=new User();
		user.setId(11);
		int de = sqlSession.delete("com.mybatis.User.deleteUser", user);
		if(de == 1) {
			System.out.println("删除成功");
		}
		else{
			System.out.println("找不不到数据哦亲");
		}
		//提交插入操作
		sqlSession.commit();
		//关闭会话对象
		sqlSession.close();
	}
	
	
	
	/**
	 * 修改信息的方法
	 * @throws Exception
	 */
	@Test
	public void updateUser() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user=new User();
		user.setId(1);
		user.setUsername("Tom");
		user.setPhone("1111111");
		int us = sqlSession.update("com.mybatis.User.updateUser", user);
		if(us>0) {
			System.out.println("更新成功");
		}else
		{
			System.out.println("更新失败");
		}
		//提交插入操作
		sqlSession.commit();
		//关闭会话对象
		sqlSession.close();
	}
	
	
}
