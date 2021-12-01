package com.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.core.convert.converter.Converter;

/**
 *�Զ��������ת���� 
 * @author DELL
 *
 */

public class DateConvert implements Converter<String,Date>{
	
	String datePattern="yyyy-MM-dd HH:mm:ss" ;
	@Override
	public Date convert(String s) {
	
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		
		try {
		return sdf.parse(s);
		}catch(ParseException e) {
			throw new IllegalArgumentException("����һ����Ч�����ڸ�ʽ���룺"+ datePattern);
		}
	}
	
	
}
