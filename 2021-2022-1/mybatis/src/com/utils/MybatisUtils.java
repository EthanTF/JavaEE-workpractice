package com.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	static SqlSessionFactory ssf=null;
	//��ʼ����������
	static {
		//1.��ȡ�����ļ�
		String resource="mybatis-conf.xml";
		InputStream resourteAstream;
		try {
			resourteAstream = Resources.getResourceAsStream(resource);
		//2.�����Ự����
		ssf = new SqlSessionFactoryBuilder().build(resourteAstream);
		
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	//��ȡ�Ự���󷽷�
	public static SqlSession getSqlSession() 
	{
		return ssf.openSession();
		
	}
	
}
