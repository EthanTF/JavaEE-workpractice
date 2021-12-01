package com.controller;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itheima.vo.UserVO;
import com.pojo.User;

@Controller
public class UserController {
	
	/**
	 * 默认数据类型的绑定
	 */
	@RequestMapping(value="/select")
	public String selectUser(HttpServletRequest request)
	{
		String id = request.getParameter("id");
		System.out.println("查询用户的id"+ id);
		return "success";
	}
	
	/**
	 * 简单数据类型的绑定
	 */
	@RequestMapping(value="/select2")
	//required必填、defaultValue默认值
	//public String selectUser2(@RequestParam(value="iid",required=true,defaultValue="1") Integer id,Model m)
	public String selectUser2(Integer id,Model m)
	{
		m.addAttribute("id",id);
		System.out.println("查询用户的id"+ id);
		return "success";
	}
	
	/**
	 * pojo类完成数据类型的绑定
	 */
	//用来跳转到登录界面
	@RequestMapping(value="/tologin")
	public String tologin()
	{
		return "login";
	}
	
	//
	@RequestMapping(value="/LoginUser")
	public String LoginUser(User user)
	{
		String username = user.getUsername();
		String psw = user.getPsw();
		
		System.out.println("用户名为"+username);
		System.out.println("密码为"+psw);
		return "success";
	}
	
	//用来跳转到登录界面
	@RequestMapping(value="/toUser")
	public String selectUsers()
	{
		return "user";
	}
	/**
	 * 接收批量删除用户的方法	
	 */
	@RequestMapping(value="/deleteUsers")
	public String deleteUsers(Integer[] ids) {
		if(ids !=null) {
			for (Integer id : ids) {
				System.out.println("删除了id为"+id+"的用户!");
			}
		}else {
			System.out.println("ids=null");
		}
		return "success";
}
	
	/**
	 * 向用户批量修改页面跳转
	 */
	@RequestMapping(value="/toUserEdit")
	public String totUsersEdit()
	{
		return "user_edit";
	}
	
	/**
	 * 接收批量修改用户的方法
	 */
	@RequestMapping("/editUsers")
	   public String editUsers(UserVO userList)
	   {
	       List<User> users = userList.getUsers();
	       for(User user:users)
	       {
	           if(user.getId()!=null)
	           {
	               System.out.println("修改了 ID为 = "+user.getId()+"的用户名为："+user.getUsername());
	           }
	       }
	       return "success";
	   }
	
}
