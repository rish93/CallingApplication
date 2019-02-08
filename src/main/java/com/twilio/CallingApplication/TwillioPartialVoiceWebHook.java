package com.twilio.CallingApplication;

import java.io.IOException;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.params.HttpParams;

import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;

  
@SuppressWarnings("serial")
//@WebServlet("/partialVoice")
public class TwillioPartialVoiceWebHook  extends HttpServlet{

	
	 protected void doPost(HttpRequest request, HttpResponse response)
		      throws ServletException, IOException {
	
			HttpParams output1=request.getParams();
			String output= (String) output1.getParameter("UnstableSpeechResult");
			System.out.println("Greeting Response:");
			System.out.println(output);	    
			 if(output.toLowerCase().contains("yes") || output.toLowerCase().contains("yeah") || output.toLowerCase().contains("carry on") ||  output.toLowerCase().contains("shoot"))
			{
				output="";
				Call call = Call.updater(TwilioUtil.sid)
			               .setMethod(HttpMethod.POST)
			               .setUrl(URI.create(TwilioUtil.getProcUrl().endsWith("/")?"":"/")+"twiml/positive-response.xml")
			               .update();
			}
			else if(output.toLowerCase().contains("maybe") || output.toLowerCase().contains("later") || output.toLowerCase().equals("not now"))
			{
				output="";
				Call call = Call.updater(TwilioUtil.sid)
			               .setMethod(HttpMethod.POST)
			               .setUrl(URI.create(TwilioUtil.getProcUrl().endsWith("/")?"":"/")+"twiml/average-response.xml")
			               .update();
			}
			else if(output.toLowerCase().contains("no") || output.toLowerCase().contains("not")) {
					output="";
					Call call = Call.updater(TwilioUtil.sid)
				               .setMethod(HttpMethod.POST)
				               .setUrl(URI.create(TwilioUtil.getProcUrl().endsWith("/")?"":"/")+"twiml/negative-response.xml")
				               .update();
				
			}
			else {
				
				Call call = Call.updater(TwilioUtil.sid)
			               .setMethod(HttpMethod.POST)
			               .setUrl(URI.create(TwilioUtil.getProcUrl().endsWith("/")?"":"/")+"twiml/unidentified-response.xml")
			               .update();
			}
		
	 }
}
