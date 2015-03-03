package tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;

public class MyBatisSqlSessionFactory
{
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory==null) {
			InputStream inputStream;
			try {
				inputStream = Resources.
						getResourceAsStream("mybatis-config.xml");
				sqlSessionFactory = new
						SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				throw new RuntimeException(e.getCause());
			}
		}
		return sqlSessionFactory;
	}
	
	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
	
	//===========================================================
	// GUICE - MYBATIS CODES
	//===========================================================
	
	public static Injector injector = Guice.createInjector(createMyBatisModule());
	
	 protected static List<Module> createMyBatisModule() {
	        List<Module> modules = new ArrayList<Module>();
	        modules.add(JdbcHelper.Oracle_Thin);
	        /*modules.add(new MyBatisModule() {

	            @Override
	            protected void initialize() {
	                bindDataSourceProviderType(PooledDataSourceProvider.class);
	                bindTransactionFactoryType(JdbcTransactionFactory.class);
	                addMapperClass(MEmployeeMapper.class);
	            }

	        });*/
	         modules.add(new XMLMyBatisModule() {

	            @Override
	            protected void initialize() {
	                setEnvironmentId("development");
	                setClassPathResource("mybatis-config.xml");
	            }

	        }); 
	        modules.add(new Module() {
	            public void configure(Binder binder) {
	                //Names.bindProperties(binder, createTestProperties());
	                //binder.bind(MEmployeeMapper.class).to(MEmployeeService.class);
	            }
	        });

	        return modules;
	    }
	 
	 protected static Properties createTestProperties() {
	        final Properties myBatisProperties = new Properties();
	        myBatisProperties.setProperty("mybatis.environment.id", "test");
	        myBatisProperties.setProperty("JDBC.username", "alphaalpine");
	        myBatisProperties.setProperty("JDBC.password", "alphaalpine");
	        myBatisProperties.setProperty("oracle.sid", "xe");
	        myBatisProperties.setProperty("JDBC.autoCommit", "false");
	        return myBatisProperties;
	    }
}