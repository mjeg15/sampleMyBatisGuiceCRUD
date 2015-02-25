package guice;

public class MEmployee {

	private Integer Employee_ID;
	private String Name;
	private String Email;
	private String Phone;
	private String Job_Title;
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getJob_Title() {
		return Job_Title;
	}
	public void setJob_Title(String job_Title) {
		Job_Title = job_Title;
	}
	private char IsActive;
	
	
	public Integer getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(Integer employee_ID) {
		Employee_ID = employee_ID;
	}
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public char getIsActive() {
		return IsActive;
	}
	public void setIsActive(char isActive) {
		IsActive = isActive;
	}
	
	
	
}
