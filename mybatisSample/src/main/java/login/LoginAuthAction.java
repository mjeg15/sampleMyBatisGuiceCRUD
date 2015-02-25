package login;

import guice.AppInjector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import mappers.MUserService;
import models.MEmployee;
import models.MUser;

import com.google.inject.Injector;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAuthAction extends ActionSupport implements SessionAware{
	
    //private static final longserialVersionUID = 1L;
	private static Map<String, Object> sessionMap;
	private String username;
	private String password;
	private String role;
	
	private Injector injector = AppInjector.getInjector();

	public String authenticate() {
		
		if (/*this.username.equals("admin")
				&& this.password.equals("admin")*/userAccountCheck()) {
			sessionMap.put("username", username);
			sessionMap.put("role", role);
			return "success";
		} else {
			addActionError(getText("error.login"));
                        //a function from ActionSupport, to get properties values from properties file
                        //we will explore this below.
			return "error";
		}
	}
	
	public String logout(){
		
		if(sessionMap.containsKey("username")){
			sessionMap.remove("username");
		}
		if(sessionMap.containsKey("role")){
			sessionMap.remove("role");
		}
		
		return SUCCESS;
	}
	
	/**
	 * Account validation code
	 * @return
	 */
	private boolean userAccountCheck(){

		MUserService usermap = injector.getInstance(MUserService.class);
		
		List<String> userNames = usermap.getAllUserNames();
		List<String> passwords = usermap.getAllPasswords();
		List<String> roles = usermap.getAllRoles();
		
		int index = userNames.indexOf(this.username);
		
		if(index == -1)
			return false;
		
		String correctUsername = userNames.get(index) == null ? "" : userNames.get(index);
		String correctPassword = passwords.get(index) == null ? "" :  passwords.get(index);
		
		if(this.username.equals(correctUsername) && this.password.equals(correctPassword)){
			setRole(roles.get(index));
			return true;
		}
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
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}
	
	public static Map<String, Object> getSession(){
		return sessionMap;
	}
	
}