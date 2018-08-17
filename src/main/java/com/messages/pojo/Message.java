package com.messages.pojo;

import com.google.gson.annotations.SerializedName;

public class Message {

	@SerializedName("Number")
	private String number;
	@SerializedName("Text")
	private String textMessage;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

}
