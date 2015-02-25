package implementations;

import java.util.List;

import com.google.inject.Inject;

import tests.MUser;
import mappers.MUserMapper;
import mappers.MUserService;

public class MUserImpl implements MUserService{

	MUserMapper userMapper;
	
	@Inject
	MUserImpl(MUserMapper userMapper){
		this.userMapper = userMapper;
	}
	
	@Override
	public List<MUser> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllUserNames() {
		return userMapper.selectAllUsernames();
	}

	@Override
	public List<String> getAllPasswords() {
		return userMapper.selectAllPasswords();
	}

}
