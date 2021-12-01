package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Order;
import com.pojo.User;

@Controller
public class OrderController {

	/**
	 * pojo������������͵İ�
	 */
	//������ת����¼����
	@RequestMapping(value="/toorder")
	public String toOrder()
	{
		return "success";
	}
	
	//
	@RequestMapping(value="/orderUser")
	public String LoginUser(Order order)
	{
		Integer order_id = order.getOrder_id();
		User user = order.getUser();
		String username = user.getUsername();
		System.out.println("�������:"+order_id);
		System.out.println("�û���Ϊ:"+username);
		return "order";
	}
	
}
