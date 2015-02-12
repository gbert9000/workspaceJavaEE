package beanAction;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	/*
	ERROR is returned when the action execution fails.
	INPUT is returned when the action requires more input from the user.
	LOGIN is returned when the user is not logged into the system.
	NONE is returned when the action execution is successfull and there are no views to display.
	SUCCESS is returned when the action executed successfully and the corresponding result is displayed to the user.
	*/

	public String execute() {
		if (username.equals("admin") && password.equals("123")){
			return SUCCESS;
		}else{
			return ERROR;
		}
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
