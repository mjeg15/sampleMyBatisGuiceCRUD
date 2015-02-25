package mappers;

import java.util.List;

import models.MUser;

public interface MUserService {

	public List<MUser> getAllUsers();
	
	public List<String> getAllUserNames();
	
	public List<String> getAllPasswords();
	
	public List<String> getAllRoles();
}
