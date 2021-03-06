package mappers;

import java.util.List;

import models.MEmployee;

public interface MEmployeeService {

	public MEmployee getUserByID(Integer Employee_ID);
	
	public List<MEmployee> getAllActiveEmployee();
	
	public List<MEmployee> getAllEmployee();
	
	public void updateEmployee(MEmployee employee);
	
	public void insertEmployee(MEmployee employee);
	
	public void disableEmployee(Integer Employee_ID);
	
	public Integer getLatestID();
	
}
