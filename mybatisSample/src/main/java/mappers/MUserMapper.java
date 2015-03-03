package mappers;

import java.util.List;

import models.MUser;

import org.apache.ibatis.annotations.Select;

public interface MUserMapper {

	public MUser getUserById(Integer S_User_ID);
	
	//@Select("SELECT * FROM S_Users")
	List<MUser> getAllUsers();
	
	//@Select("SELECT Username FROM S_USER ORDER BY S_User_ID")
	List<String> getAllUsernames();
	
	//@Select("SELECT Password FROM S_USER ORDER BY S_User_ID")
	List<String> getAllPasswords();
	
	//@Select("SELECT Role FROM S_USER ORDER BY S_User_ID")
	List<String> getAllRoles();
	
}
