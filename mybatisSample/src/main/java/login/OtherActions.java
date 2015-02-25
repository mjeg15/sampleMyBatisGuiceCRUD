package login;

import tests.MEmployee;
import tests.MEmployeeServiceOLD;

import com.opensymphony.xwork2.ActionSupport;

public class OtherActions extends ActionSupport{

	MEmployee employee;

	public String goToNewEmployee(){
		
		return SUCCESS;
	}
	
	public MEmployee getEmployee() {
		
		return employee;
	}

	public void setEmployee(MEmployee employee) {
		this.employee = employee;
	}
	
}
