package login;

import guice.AppInjector;
import mappers.MEmployeeMapper;
import mappers.MEmployeeService;
import models.MEmployee;
import tests.MyBatisSqlSessionFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.opensymphony.xwork2.ActionSupport;

public class CreateEmployee extends ActionSupport{

	//Injector injector = Guice.createInjector(new MyBatisSampleModule());
	
	Injector injector = AppInjector.getInjector();
	
	MEmployee employee;
	
	MEmployeeService emp = injector.getInstance(MEmployeeService.class);
	
	public String createNewEmployee(){
		Integer emp_ID = employee.getEmployee_ID();
		if(emp_ID == null || emp_ID == 0){
			Integer latest_ID = emp.getLatestID() > 0 ? emp.getLatestID() + 1 : 1;
			employee.setEmployee_ID(latest_ID);
			employee.setIsActive('Y');
			
			emp.insertEmployee(employee);
		}else{
			updateEmployee();
		}
		
		return SUCCESS;
	}
	
	public String goToUpdateEmployee(){
		employee = emp.getUserByID(employee.getEmployee_ID());
		
		return SUCCESS;
	}
	
	public void updateEmployee(){
		
		emp.updateEmployee(employee);
		
	}
	
	public String disableEmployee(){
		
		emp.disableEmployee(employee.getEmployee_ID());
		
		return SUCCESS;
	}
	
	//getters and setters

	public MEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(MEmployee employee) {
		this.employee = employee;
	}
	
}
