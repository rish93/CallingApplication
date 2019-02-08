package com.twilio.CallingApplication;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twilio.Twilio;
import com.twilio.exception.AuthenticationException;
import com.twilio.http.HttpMethod;
//Token generate Imports
import com.twilio.jwt.Jwt;
import com.twilio.jwt.client.ClientCapability;
import com.twilio.jwt.client.IncomingClientScope;
import com.twilio.jwt.client.OutgoingClientScope;
import com.twilio.jwt.client.Scope;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioUtil {

	static Logger logger = LoggerFactory.getLogger(TwilioUtil.class);
	public static String sid;
	public static String accSid;
	public static void main(String args[]) throws Throwable{
	}
	
	
	//automated call
	public static void makeAutomatedCall(String toNumber, String twimlURL){
		logger.debug("initializing twilio");

		Twilio.init("AC5bff3f75a5f6a257265172ac3eddfabb", "64736522e03417e6ca155fd4745e2c15");
		
		URI uri = null;
			try {
				uri = new URI(twimlURL);
			} catch (URISyntaxException e) {
				logger.error("Unexptected Error",e);
			}
		
		Call call = Call.creator(new PhoneNumber(toNumber), new PhoneNumber("918867620765"),uri).create();
		sid=call.getSid();
		accSid=call.getAccountSid();
		System.out.println(call.getStatus()+"\n Sid: "+call.getSid()+"\n AccSid: "+ call.getAccountSid());
		logger.debug("Calling"+toNumber+" from"+"+12248033135"+"twiml:"+twimlURL);
	    
	}
	
	public static String getProcUrl() {
		return	Constants.procUrl;
	}

}