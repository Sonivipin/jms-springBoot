package com.example.jms.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Identity {

	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("provider")
	private String provider;
	@JsonProperty("connection")
	private String connection;
	@JsonProperty("isSocial")
	private Boolean isSocial;

	@JsonProperty("user_id")
	public String getUserId() {
	return userId;
	}

	@JsonProperty("user_id")
	public void setUserId(String userId) {
	this.userId = userId;
	}

	@JsonProperty("provider")
	public String getProvider() {
	return provider;
	}

	@JsonProperty("provider")
	public void setProvider(String provider) {
	this.provider = provider;
	}

	@JsonProperty("connection")
	public String getConnection() {
	return connection;
	}

	@JsonProperty("connection")
	public void setConnection(String connection) {
	this.connection = connection;
	}

	@JsonProperty("isSocial")
	public Boolean getIsSocial() {
	return isSocial;
	}

	@JsonProperty("isSocial")
	public void setIsSocial(Boolean isSocial) {
	this.isSocial = isSocial;
	}

}
