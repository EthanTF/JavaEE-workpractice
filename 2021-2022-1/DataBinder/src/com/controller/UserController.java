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
	 * Ĭ���������͵İ�
	 */
	@RequestMapping(value="/select")
	public String selectUser(HttpServletRequest request)
	{
		String id = request.getParameter("id");
		System.out.println("��ѯ�û���id"+ id);
		return "success";
	}
	
	/**
	 * ���������͵İ�
	 */
	@RequestMapping(value="/select2")
	//required���defaultValueĬ��ֵ
	//public String selectUser2(@RequestParam(value="iid",required=true,defaultValue="1") Integer id,Model m)
	public String selectUser2(Integer id,Model m)
	{
		m.addAttribute("id",id);
		System.out.println("��ѯ�û���id"+ id);
		return "success";
	}
	
	/**
	 * pojo������������͵İ�
	 */
	//������ת����¼����
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
		
		System.out.println("�û���Ϊ"+username);
		System.out.println("����Ϊ"+psw);
		return "success";
	}
	
	//������ת����¼����
	@RequestMapping(value="/toUser")
	public String selectUsers()
	{
		return "user";
	}
	/**
	 * ��������ɾ���û��ķ���	
	 */
	@RequestMapping(value="/deleteUsers")
	public String deleteUsers(Integer[] ids) {
		if(ids !=null) {
			for (Integer id : ids) {
				System.out.println("ɾ����idΪ"+id+"���û�!");
			}
		}else {
			System.out.println("ids=null");
		}
		return "success";
}
	
	/**
	 * ���û������޸�ҳ����ת
	 */
	@RequestMapping(value="/toUserEdit")
	public String totUsersEdit()
	{
		return "user_edit";
	}
	
	/**
	 * ���������޸��û��ķ���
	 */
	@RequestMapping("/editUsers")
	   public String editUsers(UserVO userList)
	   {
	       List<User> users = userList.getUsers();
	       for(User user:users)
	       {
	           if(user.getId()!=null)
	           {
	               System.out.println("�޸��� IDΪ = "+user.getId()+"���û���Ϊ��"+user.getUsername());
	           }
	       }
	       return "success";
	   }
	
}
