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
 * ��ѯ���������
 *
 */

public class testQuery {
	@Test
	public void findByID() throws Exception
	{
//		//1.��ȡ�����ļ�
//		String resource="mybatis-conf.xml";
//		InputStream resourteAstream = Resources.getResourceAsStream(resource);
//		//2.�����Ự����
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourteAstream);
//		//3.���ù��������Ự����
//		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ʹ�ù������ȡ����
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		
		//4.���ûỰ����ȥִ��mapper�е�SQL���
		User user=sqlSession.selectOne("com.mybatis.User.findByID", 10);
		//5.�����ѯ���,user����
		System.out.println(user);
		//6.�رջỰ����
		sqlSession.close();
		
	}
	
	/**
	 * �����û�ģ����ѯ
	 * @throws Exception
	 */
	
	@Test
	public void findByNane() throws Exception {
		//1.��ȡ�����ļ�
		String resource = "mybatis-conf.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		//2.�����Ự����
		SqlSessionFactory sqlsessionfactory  = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//3.���ù��������Ự����
		SqlSession sqlsession = sqlsessionfactory.openSession();
		//4.���ûỰִ��Mapper�е�sql���
		List<User> users=sqlsession.selectList("com.mybatis.User.findByName", "��");
		//5.�����ѯ���
		for(User user:users) {
			System.out.println(user);
		}
		//6.�رջỰ����
		sqlsession.close();
	}
	
	/**
	 * ������Ϣ�ķ���
	 * @throws Exception
	 */
	
	@Test
	public void addUser() throws Exception {
		//1.��ȡ�����ļ�
		String resource = "mybatis-conf.xml";
		InputStream resourceAsStream = Resources.getResourceAsStream(resource);
		//2.�����Ự����
		SqlSessionFactory sqlsessionfactory  = new SqlSessionFactoryBuilder().build(resourceAsStream);
		//3.���ù��������Ự����
		SqlSession sqlsession = sqlsessionfactory.openSession();
		//4.���ûỰִ��Mapper�е�sql���
		//�������ӵ�user��ֵ
		User user=new User();
		user.setUsername("Ethan");
		user.setPsw("151124");
		user.setPhone("18852288");
		user.setEmail("Ethan@XXX.edu.cn");
		//5.ʹ��sqlsession���Ự����ֵ
		int row = sqlsession.insert("com.mybatis.User.AddUser",user);
		//6.�ж��Ƿ�ִ�гɹ�
		if(row>0)
		{
			System.out.println("�ɹ���ӣ�");
		}else
		{
			System.out.println("����ʧ�ܣ�");
		}
		
		System.out.println(user.getId());
		
		//7.�ύ�������
		sqlsession.commit();
		//8.�رջỰ����
		sqlsession.close();
	}
	
	
	/**
	 * ɾ����Ϣ�ķ���
	 * @throws Exception
	 */
	@Test
	public void deleteUser() throws Exception {	
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user=new User();
		user.setId(11);
		int de = sqlSession.delete("com.mybatis.User.deleteUser", user);
		if(de == 1) {
			System.out.println("ɾ���ɹ�");
		}
		else{
			System.out.println("�Ҳ���������Ŷ��");
		}
		//�ύ�������
		sqlSession.commit();
		//�رջỰ����
		sqlSession.close();
	}
	
	
	
	/**
	 * �޸���Ϣ�ķ���
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
			System.out.println("���³ɹ�");
		}else
		{
			System.out.println("����ʧ��");
		}
		//�ύ�������
		sqlSession.commit();
		//�رջỰ����
		sqlSession.close();
	}
	
	
}
