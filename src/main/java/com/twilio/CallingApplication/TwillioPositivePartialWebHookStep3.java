package com.twilio.CallingApplication;

import java.io.IOException;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;

//@WebServlet("/partialPositiveStep3")
public class TwillioPositivePartialWebHookStep3 extends HttpServlet{

	
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
	
			String output=	 	request.getParameter("UnstableSpeechResult");
			System.out.println("What is your current job title?");
			System.out.println(output);	    
				
				Call call = Call.updater(TwilioUtil.sid)
			               .setMethod(HttpMethod.POST)
			               .setUrl(URI.create(TwilioUtil.getProcUrl().endsWith("/")?"":"/")+"twiml/positive-response-step3.xml")
			               .update();
			
	 }
}
