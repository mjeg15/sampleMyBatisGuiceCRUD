package mappers;

import java.util.List;

import tests.MUser;

public interface MUserService {

	public List<MUser> getAllUsers();
	
	public List<String> getAllUserNames();
	
	public List<String> getAllPasswords();
	
}
