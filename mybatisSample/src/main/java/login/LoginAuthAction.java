package login;

import guice.AppInjector;

import java.util.Arrays;
import java.util.List;

import mappers.MUserService;
import tests.MEmployee;
import tests.MUser;

import com.google.inject.Injector;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAuthAction extends ActionSupport {
	
    //private static final longserialVersionUID = 1L;
	private String username;
	private String password;

	private Injector injector = AppInjector.getInjector();

	public String authenticate() {
		
		if (/*this.username.equals("admin")
				&& this.password.equals("admin")*/userAccountCheck()) {
			return "success";
		} else {
			addActionError(getText("error.login"));
                        //a function from ActionSupport, to get properties values from properties file
                        //we will explore this below.
			return "error";
		}
	}
	
	/**
	 * Account validation code
	 * @return
	 */
	private boolean userAccountCheck(){

		MUserService usermap = injector.getInstance(MUserService.class);
		
		List<String> userNames = usermap.getAllUserNames();
		List<String> passwords = usermap.getAllPasswords();
		
		int index = userNames.indexOf(this.username);
		
		if(index == -1)
			return false;
		
		String correctUsername = userNames.get(index) == null ? "" : userNames.get(index);
		String correctPassword = passwords.get(index) == null ? "" :  passwords.get(index);
		
		if(this.username.equals(correctUsername) && this.password.equals(correctPassword))
			return true;
		else
			return false;
		
	}
	
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
	
}