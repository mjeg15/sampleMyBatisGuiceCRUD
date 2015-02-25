package mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import tests.MUser;

public interface MUserMapper {

	public MUser getUserById(Integer S_User_ID);
	
	@Select("SELECT * FROM S_Users")
	List<MUser> selectAllUsers();
	
	@Select("SELECT Username FROM S_USER ORDER BY S_User_ID")
	List<String> selectAllUsernames();
	
	@Select("SELECT Password FROM S_USER ORDER BY S_User_ID")
	List<String> selectAllPasswords();
	
}
