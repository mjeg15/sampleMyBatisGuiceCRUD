package tests;

import java.util.List;

import models.MEmployee;

import org.apache.ibatis.session.SqlSession;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class MEmployeeServiceOLD implements MEmployeeMapperOLD {

	private Logger logger =
			 LoggerFactory.getLogger(getClass());
	
	@Override
	public MEmployee getUserById(Integer Employee_ID) {
		// TODO Auto-generated method stub
		 SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		 
		 try {
				 MEmployeeMapperOLD MEmployeeMapper = sqlSession.getMapper(MEmployeeMapperOLD.class);
				 return MEmployeeMapper.getUserById(Employee_ID);
			} finally {
				sqlSession.close();
			}
		
		
	}

	@Override
	public List<MEmployee> getAllEmployees() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			 MEmployeeMapperOLD MEmployeeMapper = sqlSession.getMapper(MEmployeeMapperOLD.class);
			 return MEmployeeMapper.getAllEmployees();
		} finally {
			sqlSession.close();
		}
		 
	}

	
	@Override
	public void DisableEmployee(Integer Employee_ID) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		 
		 try {
				 MEmployeeMapperOLD MEmployeeMapper = sqlSession.getMapper(MEmployeeMapperOLD.class);
				 MEmployeeMapper.DisableEmployee(Employee_ID);
				 sqlSession.commit();
			} finally {
				sqlSession.close();
			}
	}

	@Override
	public void UpdateEmployee(MEmployee employee) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		 
		 try {
				 MEmployeeMapperOLD MEmployeeMapper = sqlSession.getMapper(MEmployeeMapperOLD.class);
				 MEmployeeMapper.UpdateEmployee(employee);
				 sqlSession.commit();
			} finally {
				sqlSession.close();
			}
		
	}

	@Override
	public void InsertEmployee(MEmployee employee) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		 
		 try {
				 MEmployeeMapperOLD MEmployeeMapper = sqlSession.getMapper(MEmployeeMapperOLD.class);
				 MEmployeeMapper.InsertEmployee(employee);
				 sqlSession.commit();
			} finally {
				sqlSession.close();
			}
		
	}

	@Override
	public Integer getLatestID() {
		// TODO Auto-generated method stub
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		 
		 try {
				 MEmployeeMapperOLD MEmployeeMapper = sqlSession.getMapper(MEmployeeMapperOLD.class);
				 return MEmployeeMapper.getLatestID();
			} finally {
				sqlSession.close();
			}
		
		}

	
}
