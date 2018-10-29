package com.example.jms.security;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Auth0User {

	@JsonProperty("email_verified")
	private Boolean emailVerified;
	@JsonProperty("email")
	private String email;
	@JsonProperty("clientID")
	private String clientID;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("name")
	private String name;
	@JsonProperty("picture")
	private String picture;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("nickname")
	private String nickname;
	@JsonProperty("identities")
	private List<Identity> identities = null;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("global_client_id")
	private String globalClientId;
	@JsonProperty("sessionIndex")
	private String sessionIndex;
	@JsonProperty("EmailAddress")
	private String EmailAddress;
	@JsonProperty("nameIdAttributes")
	private NameIdAttributes nameIdAttributes;
	@JsonProperty("authenticationmethod")
	private String authenticationmethod;
	@JsonProperty("issuer")
	private String issuer;

	@JsonProperty("email_verified")
	public Boolean getEmailVerified() {
	return emailVerified;
	}

	@JsonProperty("email_verified")
	public void setEmailVerified(Boolean emailVerified) {
	this.emailVerified = emailVerified;
	}

	@JsonProperty("email")
	public String getEmail() {
	return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
	this.email = email;
	}

	@JsonProperty("clientID")
	public String getClientID() {
	return clientID;
	}

	@JsonProperty("clientID")
	public void setClientID(String clientID) {
	this.clientID = clientID;
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt() {
	return updatedAt;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt) {
	this.updatedAt = updatedAt;
	}

	@JsonProperty("name")
	public String getName() {
	return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
	this.name = name;
	}

	@JsonProperty("picture")
	public String getPicture() {
	return picture;
	}

	@JsonProperty("picture")
	public void setPicture(String picture) {
	this.picture = picture;
	}

	@JsonProperty("user_id")
	public String getUserId() {
	return userId;
	}

	@JsonProperty("user_id")
	public void setUserId(String userId) {
	this.userId = userId;
	}

	@JsonProperty("nickname")
	public String getNickname() {
	return nickname;
	}

	@JsonProperty("nickname")
	public void setNickname(String nickname) {
	this.nickname = nickname;
	}

	@JsonProperty("identities")
	public List<Identity> getIdentities() {
	return identities;
	}

	@JsonProperty("identities")
	public void setIdentities(List<Identity> identities) {
	this.identities = identities;
	}

	@JsonProperty("created_at")
	public String getCreatedAt() {
	return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
	}

	@JsonProperty("global_client_id")
	public String getGlobalClientId() {
	return globalClientId;
	}
		
	@JsonProperty("EmailAddress")
	public String getEmailAddress() {
		return EmailAddress;
	}

	@JsonProperty("EmailAddress")
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	@JsonProperty("global_client_id")
	public void setGlobalClientId(String globalClientId) {
	this.globalClientId = globalClientId;
	}

	@JsonProperty("sessionIndex")
	public String getSessionIndex() {
		return sessionIndex;
	}

	@JsonProperty("sessionIndex")
	public void setSessionIndex(String sessionIndex) {
		this.sessionIndex = sessionIndex;
	}

	@JsonProperty("nameIdAttributes")
	public NameIdAttributes getNameIdAttributes() {
		return nameIdAttributes;
	}

	@JsonProperty("nameIdAttributes")
	public void setNameIdAttributes(NameIdAttributes nameIdAttributes) {
		this.nameIdAttributes = nameIdAttributes;
	}

	@JsonProperty("authenticationmethod")
	public String getAuthenticationmethod() {
		return authenticationmethod;
	}

	@JsonProperty("authenticationmethod")
	public void setAuthenticationmethod(String authenticationmethod) {
		this.authenticationmethod = authenticationmethod;
	}

	@JsonProperty("issuer")
	public String getIssuer() {
		return issuer;
	}

	@JsonProperty("issuer")
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}	
}

class NameIdAttributes
{
  @JsonProperty("value")	
  private String value;
  
  @JsonProperty("NameQualifier")	
  private String NameQualifier;

  @JsonProperty("value")
  public String getValue() { return this.value; }

  @JsonProperty("value")
  public void setValue(String value) { this.value = value; }
  
  @JsonProperty("NameQualifier")
  public String getNameQualifier() { return this.NameQualifier; }

  @JsonProperty("NameQualifier")
  public void setNameQualifier(String NameQualifier) { this.NameQualifier = NameQualifier; }

  @JsonProperty("Format")
  private String Format;

  @JsonProperty("Format")
  public String getFormat() { return this.Format; }

  @JsonProperty("Format")
  public void setFormat(String Format) { this.Format = Format; }
}
