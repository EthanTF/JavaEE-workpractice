package com.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.utils.MybatisUtils;

public class testSql {
	@Test
	public void findByif() throws Exception{
		
		SqlSession sqlsession = MybatisUtils.getSqlSession();
		User user=new User();
		user.setUsername("许");
		//user.setArea("上海");
		List<User> users=sqlsession.selectList("com.mybatis.User.findByif",user);
		for(User user1:users)
		{
			System.out.println(user1);
		}
	
		sqlsession.close();
	}
	
	@Test
	public void findUserByNameOrArea() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user = new User();
//		user.setUsername("小许");
		user.setArea("成都");
		List<User> users = sqlSession.selectList("com.mybatis.User.findUserByNameOrArea", user);
		// 输出查询结果
		for (User user2 : users) {
			System.out.println(user2);
		}
		// 关闭会话对象
		sqlSession.close();
	}

	@Test
	public void UpdateSetUser() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user = new User();
		user.setId(11);
		user.setPhone("被修改的电话号码");
		// 执行sqlsession的更新方法，返回的是sql语句影响的行数
		int rows = sqlSession.update("com.mybatis.User.UpdateSetUser", user);
		// 通过返回来判断更新操作是否执行成功
		if (rows > 0) {
			System.out.println("您成功修改了" + rows + "条数据");
		} else {
			System.out.println("执行失败！！");
		}
		// 提交插入操作
		sqlSession.commit();
		// 关闭会话对象
		sqlSession.close();
	}

	@Test
	public void  findUserById() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		// 执行sqlsession的查询方法，返回结果集
		List<User> users = sqlSession.selectList("com.mybatis.User.findUserById", ids);
		// 输出查询结果
		for (User user : users) {
			// 打印输出结果
			System.out.println(user);
		}
		// 关闭会话对象
		sqlSession.close();
	}
	
	
}