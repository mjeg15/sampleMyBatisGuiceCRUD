package guice;

import implementations.MEmployeeImpl;
import implementations.MUserImpl;

import java.util.Properties;

import mappers.MEmployeeMapper;
import mappers.MEmployeeService;
import mappers.MUserMapper;
import mappers.MUserService;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

public class AppInjector {

	
	public static Injector getInjector(){
		Injector injector = Guice.createInjector(new MyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.Oracle_Thin);

                bindDataSourceProviderType(PooledDataSourceProvider.class);
                bindTransactionFactoryType(JdbcTransactionFactory.class);
                //mappers
                addMapperClass(MUserMapper.class);
                addMapperClass(MEmployeeMapper.class);

                //binds
                Names.bindProperties(binder(), createTestProperties());
                bind(MUserService.class).to(MUserImpl.class);
                bind(MEmployeeService.class).to(MEmployeeImpl.class);
            	}

        	}
		);
		
		return injector;
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
