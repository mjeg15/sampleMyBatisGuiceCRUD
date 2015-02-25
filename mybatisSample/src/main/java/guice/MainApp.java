package guice;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import mappers.MEmployeeMapper;

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

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Injector injector = Guice.createInjector(new MyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.Oracle_Thin);

                bindDataSourceProviderType(PooledDataSourceProvider.class);
                bindTransactionFactoryType(JdbcTransactionFactory.class);
                addMapperClass(MEmployeeMapper.class);

                Names.bindProperties(binder(), createTestProperties());
                //bind(MEmployeeService.class).to(MEmployeeMapperImpl.class);
            	}

        	}
				
		/*new XMLMyBatisModule() {

		            @Override
		            protected void initialize() {
		                setEnvironmentId("test");
		                setClassPathResource("mybatis-config.xml");
		            }
			}*/
		);
		
		/*//MEmployeeService service = injector.getInstance(MEmployeeService.class);
		service.getLatestID();
	
		List<MEmployee> emps = service.getAllEmployees();
		for(MEmployee emp : emps){
			System.out.println(emp.getName());
		}*/
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
