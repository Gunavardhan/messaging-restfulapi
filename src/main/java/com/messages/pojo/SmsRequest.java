package com.messages.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SmsRequest {

	@SerializedName("Account")
	private Account account;
	@SerializedName("Messages")
	private List<Message> messages;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public Account prepareAcount(){
		Account account = new Account();
		account.setUser("Gunavardhan");
		account.setPassword("9949026410");
		account.setSenderid("TESTIN");
		account.setChannel("2");
		account.setDcs("0");
		return account;
	}
	
	public List<Message> prepareMessageList(String numbers, String text) {
		//number = 95457,98745
		String[] mobileNumbers = numbers.split(",");
		List<Message> messageList = new ArrayList<Message>();
		
		for (String num : mobileNumbers) {
			Message message = new Message();
			message.setNumber(num);
			message.setTextMessage(text);
			
			messageList.add(message);			
		}
		
		return messageList;
	}
	
}
