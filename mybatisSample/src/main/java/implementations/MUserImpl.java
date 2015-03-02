package implementations;

import java.util.List;

import com.google.inject.Inject;

import mappers.MUserMapper;
import mappers.MUserService;
import models.MUser;

public class MUserImpl implements MUserService{

	@Inject
	MUserMapper userMapper;
	
	/*@Inject
	MUserImpl(MUserMapper userMapper){
		this.userMapper = userMapper;
	}*/
	
	@Override
	public List<MUser> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllUserNames() {
		return userMapper.getAllUsernames();
	}

	@Override
	public List<String> getAllPasswords() {
		return userMapper.getAllPasswords();
	}
	
	@Override
	public List<String> getAllRoles(){
		return userMapper.getAllRoles();
	}

}
