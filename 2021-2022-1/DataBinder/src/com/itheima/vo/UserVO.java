package com.itheima.vo;

import java.util.List;

import com.pojo.User;

/**
 * �û���װ��
 * @author DELL
 *
 */
public class UserVO {
	private List<User> users;
	public List<User> getUsers(){
		return users;
		
	}
		public void setUsers(List<User> users) {
			this.users = users;
		}
}
