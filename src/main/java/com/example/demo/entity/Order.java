package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Order {
	private Integer id;

	private String orderCode;

	private String orderStatus;

	private Date endTime;

	private BigDecimal allKm;

	private Integer allTime;

	private BigDecimal orderPayAmount;

	private BigDecimal amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public BigDecimal getOrderPayAmount() {
		return orderPayAmount;
	}

	public void setOrderPayAmount(BigDecimal orderPayAmount) {
		this.orderPayAmount = orderPayAmount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
