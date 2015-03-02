package mappers;

import java.util.List;

import models.MEmployee;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

public interface MEmployeeMapper {
	
	public static final String SQL_UPDATE = "UPDATE Employee SET"
			+ " Name = #{Name}, "
			+ " Email = #{Email},"
			+ " Phone = #{Phone},"
			+ " Job_Title = #{Job_Title}"
			+ " WHERE Employee_ID = #{Employee_ID}";
	
	public static final String SQL_SELECT_EMPLOYEE_WITH_ID = "SELECT * FROM Employee WHERE Employee_ID = #{Employee_ID}";
	
	public static final String SQL_SELECT_ALL_ACTIVE_EMPLOYEE = "SELECT * FROM Employee WHERE IsActive = 'Y' ORDER BY Employee_ID";
	
	public static final String SQL_SELECT_ALL_EMPLOYEE = "SELECT * FROM Employee ORDER BY Employee_ID";
	
	public static final String SQL_DEACTIVATE_EMPLOYEE = "UPDATE Employee SET "
			+ " IsActive='N' WHERE Employee_ID = #{Employee_ID}";
	
	public static final String SQL_INSERT = "INSERT INTO Employee(Employee_ID, Name, Email, Phone, Job_Title, IsActive) "
			+ "VALUES (#{Employee_ID}, #{Name}, #{Email}, #{Phone}, #{Job_Title}, #{IsActive})";
	
	public static final String SQL_GET_LATEST_ID = "SELECT MAX(Employee_ID) FROM Employee";
	
	@Select(SQL_SELECT_EMPLOYEE_WITH_ID)
	public MEmployee getUserById(Integer Employee_ID);
	
	@Select(SQL_SELECT_ALL_ACTIVE_EMPLOYEE)
	public List<MEmployee> getAllActiveEmployee();
	
	@Select(SQL_SELECT_ALL_EMPLOYEE)
	public List<MEmployee> getAllEmployee();
	
	@Update(SQL_DEACTIVATE_EMPLOYEE)
	public void disableEmployee(Integer Employee_ID);
	
	@Update(SQL_UPDATE)
	public void updateEmployee(MEmployee employee);
	
	@Insert(SQL_INSERT)
	public void insertEmployee(MEmployee employee);
	
	@Select(SQL_GET_LATEST_ID)
	public Integer getLatestID();

}
