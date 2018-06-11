package com.example.demo.entity;

import java.util.Date;

public class Client {
	/**
	 * frace
	 */
	private Integer id;
	private String username;
	private String passwd;
	private String loginname;
	private Integer status;
	private Date createDate;

	// 公共构造器
	public Client() {
		super();
	}

	public Client(int i, String string, String string2, int j, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

}
