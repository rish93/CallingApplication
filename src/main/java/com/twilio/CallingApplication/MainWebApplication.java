package com.twilio.CallingApplication;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class MainWebApplication extends WebApplication {

	
private void initFriendlyUrls() {
		
	
	//	mountPage("/home", Login.class);
		//mountPage("/login", Login.class);
	
	}

		@Override
		public Class<? extends Page> getHomePage() {
			// TODO Auto-generated method stub
			return Login.class;
		}
}
