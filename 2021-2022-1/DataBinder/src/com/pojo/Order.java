package com.pojo;

public class Order {
	Integer order_id;
	User user;
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user=" + user + "]";
	}


	
	
}
