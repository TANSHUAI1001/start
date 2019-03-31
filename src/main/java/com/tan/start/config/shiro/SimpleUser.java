package com.tan.start.config.shiro;

import java.io.Serializable;

public class SimpleUser implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String password;

	public SimpleUser(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
