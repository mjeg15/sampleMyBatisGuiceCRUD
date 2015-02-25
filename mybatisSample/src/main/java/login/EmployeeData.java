package login;

import guice.AppInjector;

import java.util.List;

import com.google.inject.Injector;
import com.opensymphony.xwork2.ActionSupport;

import tests.MEmployee;
import mappers.MEmployeeService;

public class EmployeeData extends ActionSupport{
	
	public List<MEmployee> employees;

	private Injector injector = AppInjector.getInjector();
	
	public String testing(){
		
		MEmployeeService employeeService = injector.getInstance(MEmployeeService.class);
		
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
