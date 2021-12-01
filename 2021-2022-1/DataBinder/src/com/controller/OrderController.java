package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Order;
import com.pojo.User;

@Controller
public class OrderController {

	/**
	 * pojo类完成数据类型的绑定
	 */
	//用来跳转到登录界面
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
		System.out.println("订单编号:"+order_id);
		System.out.println("用户名为:"+username);
		return "order";
	}
	
}
