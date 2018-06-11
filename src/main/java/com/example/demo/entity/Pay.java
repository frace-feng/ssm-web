package com.example.demo.entity;

import java.sql.Date;

public class Pay {
	private Integer id; //id
	private String clientCode; //用户code
	private Integer payBalance; //金额
	private Integer payType; //交易方式：微信，支付宝
	private Date payTime;
	
	public Integer getId() {
		return id;
	}	

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	
	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	





	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}




	public Integer getPayBalance() {
		return payBalance;
	}

	public void setPayBalance(Integer payBalance) {
		this.payBalance = payBalance;
	}

}
