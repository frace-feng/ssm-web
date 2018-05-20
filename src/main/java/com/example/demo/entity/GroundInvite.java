package com.example.demo.entity;

public class GroundInvite {
	private Integer id;

	private String client_code;

	private String invite_client_code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClient_code() {
		return client_code;
	}

	public void setClient_code(String client_code) {
		this.client_code = client_code;
	}

	public String getInvite_client_code() {
		return invite_client_code;
	}

	public void setInvite_client_code(String invite_client_code) {
		this.invite_client_code = invite_client_code;
	}

}
