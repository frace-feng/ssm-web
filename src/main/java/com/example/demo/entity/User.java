package com.example.demo.entity;

import java.sql.Date;

public class User {/* id,client_code,client_name,mobile */

	private Integer id;

	private String clientCode;

	private String clientName;

	private String mobile;
	
	private String driverCode;

	private Date createTime;
	
	private Integer depositSta;
	
	private Integer auditingStatus;

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

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getDriverCode() {
		return driverCode;
	}

	public void setDriverCode(String driverCode) {
		this.driverCode = driverCode;
	}
	
	public Integer getDepositSta() {
		return depositSta;
	}

	public void setDepositSta(Integer depositSta) {
		this.depositSta = depositSta;
	}

	public Integer getAuditingStatus() {
		return auditingStatus;
	}

	public void setAuditingStatus(Integer auditingStatus) {
		this.auditingStatus = auditingStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}