package com.messages.pojo;

import com.google.gson.annotations.SerializedName;

public class Account {

	@SerializedName("User")
	private String user;
	@SerializedName("Password")
	private String password;
	@SerializedName("SenderId")
	private String senderid;
	@SerializedName("Channel")
	private String channel;
	@SerializedName("DCS")
	private String dcs;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSenderid() {
		return senderid;
	}

	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getDcs() {
		return dcs;
	}

	public void setDcs(String dcs) {
		this.dcs = dcs;
	}

}
