package com.messages.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.messages.pojo.SmsRequest;

@Path("/generic")
public class GenericMessageService {
	
	@POST
	@Path("/sendSms")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendSms(@QueryParam("mobileNum") String mobileNum, @QueryParam("message") String message){
		Gson gson = new Gson();
		SmsRequest smsReq = new SmsRequest();
		smsReq.setAccount(smsReq.prepareAcount());
		smsReq.setMessages(smsReq.prepareMessageList(mobileNum, message));
		String jsonReqObj = gson.toJson(smsReq);
		
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(jsonReqObj, headers);
		String URL = "https://www.smsgatewayhub.com/api/mt/SendSMS";
		ResponseEntity<String> response = template.exchange(URL, HttpMethod.POST, entity, String.class);
		return Response.status(200).entity(response.getStatusCodeValue()).build();
	}
	
	public static void main(String[] args) {
		/*Gson gson = new Gson();
		String URL = "https://www.smsgatewayhub.com/api/mt/SendSMS";
		SmsRequest smsReq = new SmsRequest();
		smsReq.setAccount(smsReq.prepareAcount());
		smsReq.setMessages(smsReq.prepareMessageList("9949026410", "hello Gunavardhan"));
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String jsonResObj = gson.toJson(smsReq);
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		HttpEntity entity = new HttpEntity(jsonResObj, headers);
		ResponseEntity<String> response = template.exchange(URL, HttpMethod.POST, entity, String.class);
		System.out.println(response.getBody());
		//return Response.status(200).entity(response.getStatusCodeValue()).build();
*/	}
}

