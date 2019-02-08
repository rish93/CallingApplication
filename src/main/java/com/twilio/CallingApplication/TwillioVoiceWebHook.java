package com.twilio.CallingApplication;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;

import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

@SuppressWarnings("serial")
//@WebServlet("/voice")
public class TwillioVoiceWebHook extends HttpServlet {
  // Handle HTTP POST to /voice
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		    // Create a TwiML builder object
		  
			String accuracy=  (String) request.getParameter("Confidence");
			String completeResult=  (String) request.getParameter("SpeechResult");
			System.out.println(accuracy);
			System.out.println(completeResult);

			 PrintWriter writer = response.getWriter();
			 writer.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
			 writer.append("<Response/>"); 
			 response.setStatus(HttpStatus.SC_OK);
			 response.setContentType("text/xml");



		  }
		  
		  
		  protected void doPost(HttpServletRequest request, HttpServletResponse response)
			      throws ServletException, IOException {
			    // Create a TwiML builder object
			  
				String accuracy=  (String) request.getParameter("Confidence");
				String completeResult=  (String) request.getParameter("SpeechResult");
				System.out.println(accuracy);
				System.out.println(completeResult);

				 PrintWriter writer = response.getWriter();
				 writer.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
				 writer.append("<Response/>"); 
				 response.setStatus(HttpStatus.SC_OK);
				 response.setContentType("text/xml");
		  }
		  
}
