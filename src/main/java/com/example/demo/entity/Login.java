package com.example.demo.entity;

public class Login {
	private Integer id;
	private String userName;
	private String passWord;
	private String email;
	private Integer status;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getpassWord() {
		return passWord;
	}

	public void setpassWord(String passWord) {
		this.passWord = passWord;
	}

}
