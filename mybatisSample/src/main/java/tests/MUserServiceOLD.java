package tests;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class MUserServiceOLD implements MUserMapperOLD {

			private Logger logger =
			 LoggerFactory.getLogger(getClass());
			
			
			 @Override	
			 public List<MUser> getAllUsers()
			 {
			 SqlSession sqlSession =
			 MyBatisSqlSessionFactory.openSession();
			 try {
				 MUserMapperOLD MUserMapper =
						 sqlSession.getMapper(MUserMapperOLD.class);
				 return MUserMapper.getAllUsers();
			 } finally {
			//If sqlSession is not closed
			//then database Connection associated this sqlSession will not be returned to pool
			//and application may run out of connections.
			 sqlSession.close();
			 	}
			 }
			 
			 @Override
			 public MUser getUserById(Integer studId)
			 {
				 //logger.debug("Select MUser By ID :{}", studId);
				 SqlSession sqlSession =
				 MyBatisSqlSessionFactory.openSession();
				 try {
					 MUserMapperOLD MUserMapper =
							 sqlSession.getMapper(MUserMapperOLD.class);
					 return MUserMapper.getUserById(studId);
				 } finally {
					 sqlSession.close();
				 }
			 }
			 
			 @Override	
			 public List<String> getAllUsernames()
			 {
				 SqlSession sqlSession =
						 MyBatisSqlSessionFactory.openSession();
				 try {
					 MUserMapperOLD MUserMapper =
							 sqlSession.getMapper(MUserMapperOLD.class);
					 return MUserMapper.getAllUsernames();
				 } finally {
					 sqlSession.close();
			 	 }
			 }
			 
			 
			 @Override	
			 public List<String> getAllPasswords()
			 {
				 SqlSession sqlSession =
						 MyBatisSqlSessionFactory.openSession();
				 try {
					 MUserMapperOLD MUserMapper =
							 sqlSession.getMapper(MUserMapperOLD.class);
					 return MUserMapper.getAllPasswords();
				 } finally {
					 sqlSession.close();
			 	 }
			 }

			/* public void createMUser(MUser MUser)
			 {
			 SqlSession sqlSession =
			 MyBatisSqlSessionFactory.openSession();
			 try {
			 MUserMapper MUserMapper =
			 sqlSession.getMapper(MUserMapper.class);
			 MUserMapper.insertMUser(MUser);
			 sqlSession.commit();
			 } finally {
			 sqlSession.close();}
			 }*/
	
}
