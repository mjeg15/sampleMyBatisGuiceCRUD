package tests;

import java.util.List;

import models.MEmployee;
import models.MUser;

public class MainApp {

	public static void main(String args[]){
		MUserServiceOLD usermap = new MUserServiceOLD();
		MEmployeeServiceOLD employeemap = new MEmployeeServiceOLD();
		
		List<MUser> users = usermap.getAllUsers();
		
		for(MUser user : users){
			System.out.println(user.getUsername());
		}
		
		List<MEmployee> employees = employeemap.getAllEmployees();
		
		for(MEmployee employee : employees){
			System.out.println(employee.getName());
		}
		
	}
	
}
