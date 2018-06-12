package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Order {
	private Integer id;
	
	private String clientCode;

	private String orderCode;

	private String orderStatus;

	private Date createTime;

	private BigDecimal allKm;

	private Integer allTime;

	private BigDecimal totalMoney;

	private BigDecimal amount;

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

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public BigDecimal getAllKm() {
		return allKm;
	}

	public void setAllKm(BigDecimal allKm) {
		this.allKm = allKm;
	}

	public Integer getAllTime() {
		return allTime;
	}

	public void setAllTime(Integer allTime) {
		this.allTime = allTime;
	}



	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
