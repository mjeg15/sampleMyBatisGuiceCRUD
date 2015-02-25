package tests;

import java.util.List;

import models.MUser;

public interface MUserMapperOLD {

	public MUser getUserById(Integer S_User_ID);
	
	List<MUser> getAllUsers();
	
	List<String> getAllUsernames();
	
	List<String> getAllPasswords();
	
}
