package com.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	static SqlSessionFactory ssf=null;
	//初始化工厂对象
	static {
		//1.读取配置文件
		String resource="mybatis-conf.xml";
		InputStream resourteAstream;
		try {
			resourteAstream = Resources.getResourceAsStream(resource);
		//2.建立会话工厂
		ssf = new SqlSessionFactoryBuilder().build(resourteAstream);
		
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	//获取会话对象方法
	public static SqlSession getSqlSession() 
	{
		return ssf.openSession();
		
	}
	
}
