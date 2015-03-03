package tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mappers.MUserMapper;
import models.MEmployee;
import models.MUser;

public class MainApp {

	public static void main(String args[]){
		/*MUserServiceOLD usermap = new MUserServiceOLD();
		MEmployeeServiceOLD employeemap = new MEmployeeServiceOLD();
		
		List<MUser> users = usermap.getAllUsers();
		
		for(MUser user : users){
			System.out.println(user.getUsername());
		}
		
		List<MEmployee> employees = employeemap.getAllEmployees();
		
		for(MEmployee employee : employees){
			System.out.println(employee.getName());
		}*/
		
		SqlSession session = MyBatisSqlSessionFactory.openSession();
		
		MUserMapper mapper = session.getMapper(MUserMapper.class);
		
		List<MUser> users = mapper.getAllUsers();
		
		for(MUser user:users){
			System.out.println(user.getUsername());
		}
	}
	
}
