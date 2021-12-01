package com.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.core.convert.converter.Converter;

/**
 *自定义的日期转换器 
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
			throw new IllegalArgumentException("这是一个无效的日期格式输入："+ datePattern);
		}
	}
	
	
}
