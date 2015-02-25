package tests;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface MEmployeeMapperOLD {
	
	public MEmployee getUserById(Integer Employee_ID);
	
	public List<MEmployee> getAllEmployees();
	
	public void DisableEmployee(Integer Employee_ID);
	
	public void UpdateEmployee(MEmployee employee);
	
	public void InsertEmployee(MEmployee employee);
	
	public Integer getLatestID();
	

}
