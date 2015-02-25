package implementations;

import java.util.List;

import tests.MEmployee;

import com.google.inject.Inject;

import mappers.MEmployeeMapper;
import mappers.MEmployeeService;

public class MEmployeeImpl implements MEmployeeService{

	MEmployeeMapper employeeMapper;
	
	@Inject
	MEmployeeImpl (MEmployeeMapper employeeMapper){
		this.employeeMapper = employeeMapper;
	}
	
	@Override
	public MEmployee getUserByID(Integer Employee_ID) {
		return employeeMapper.getUserById(Employee_ID);
	}

	@Override
	public List<MEmployee> getAllEmployee() {
		return employeeMapper.getAllEmployees();
	}

	@Override
	public void updateEmployee(MEmployee employee) {
		employeeMapper.UpdateEmployee(employee);
	}

	@Override
	public void insertEmployee(MEmployee employee) {
		employeeMapper.InsertEmployee(employee);
	}

	@Override
	public Integer getLatestID() {
		return employeeMapper.selectLatestID();
	}

	@Override
	public void disableEmployee(Integer Employee_ID) {
		employeeMapper.DisableEmployee(Employee_ID);
	}

	
	

}