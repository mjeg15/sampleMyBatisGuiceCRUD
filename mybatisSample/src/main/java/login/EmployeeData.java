package login;

import guice.AppInjector;

import java.util.List;
import java.util.Map;

import com.google.inject.Injector;
import com.opensymphony.xwork2.ActionSupport;

import mappers.MEmployeeService;
import models.MEmployee;

public class EmployeeData extends ActionSupport{
	
	public List<MEmployee> employees;

	private Injector injector = AppInjector.getInjector();
	
	private Map<String, Object> sessionMap = LoginAuthAction.getSession();
	
	public String testing(){
		
		MEmployeeService employeeService = injector.getInstance(MEmployeeService.class);
				
		if(!sessionMap.get("role").equals("ADMIN"))
			employees = employeeService.getAllActiveEmployee();
		else
			employees = employeeService.getAllEmployee();
		
		return ActionSupport.SUCCESS;
	}
	

	public List<MEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<MEmployee> employees) {
		this.employees = employees;
	}
	
}
