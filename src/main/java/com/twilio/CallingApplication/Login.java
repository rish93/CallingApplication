package com.twilio.CallingApplication;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class Login  extends WebPage{

	
	public Login() {

		Form<?> form = new Form<Void>("userForm");	
		add(form);
		form.add( new Button("call")
		 {
			@Override
			  public void onSubmit() {
				 String number ="918867620765";   
					//Call only first number and if voice notification is enabled.
				System.out.println("calling "+number);
				 TwilioUtil.makeAutomatedCall(number,TwilioUtil.getProcUrl()+"/twiml/avatar-greeting.xml");
				 
			}
			  
		

		public MarkupContainer setDefaultModel(IModel model) {
			// TODO Auto-generated method stub
			return null;
		}
		 } );
	
	
		
		
		add(form);

	}
	
}


