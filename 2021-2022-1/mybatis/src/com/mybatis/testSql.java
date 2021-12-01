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
		user.setUsername("��");
		//user.setArea("�Ϻ�");
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
//		user.setUsername("С��");
		user.setArea("�ɶ�");
		List<User> users = sqlSession.selectList("com.mybatis.User.findUserByNameOrArea", user);
		// �����ѯ���
		for (User user2 : users) {
			System.out.println(user2);
		}
		// �رջỰ����
		sqlSession.close();
	}

	@Test
	public void UpdateSetUser() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user = new User();
		user.setId(11);
		user.setPhone("���޸ĵĵ绰����");
		// ִ��sqlsession�ĸ��·��������ص���sql���Ӱ�������
		int rows = sqlSession.update("com.mybatis.User.UpdateSetUser", user);
		// ͨ���������жϸ��²����Ƿ�ִ�гɹ�
		if (rows > 0) {
			System.out.println("���ɹ��޸���" + rows + "������");
		} else {
			System.out.println("ִ��ʧ�ܣ���");
		}
		// �ύ�������
		sqlSession.commit();
		// �رջỰ����
		sqlSession.close();
	}

	@Test
	public void  findUserById() throws Exception {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		// ִ��sqlsession�Ĳ�ѯ���������ؽ����
		List<User> users = sqlSession.selectList("com.mybatis.User.findUserById", ids);
		// �����ѯ���
		for (User user : users) {
			// ��ӡ������
			System.out.println(user);
		}
		// �رջỰ����
		sqlSession.close();
	}
	
	
}