package guice;

import java.util.Properties;

import implementations.MEmployeeImpl;
import implementations.MUserImpl;
import mappers.MEmployeeMapper;
import mappers.MEmployeeService;
import mappers.MUserMapper;
import mappers.MUserService;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.struts2.Struts2GuicePluginModule;

public class AppListener extends GuiceServletContextListener{
	
	@Override
	public Injector getInjector() {
		Struts2GuicePluginModule SGM =  new Struts2GuicePluginModule();//-----------------------1)
		//JpaPersistModule Jpm =new JpaPersistModule("St2Gui3JpaPU" );
		/*MyBatisModule mbm = new MyBatisModule() {
			
			@Override
			protected void initialize() {
				// TODO Auto-generated method stub

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
		};*/
		
		
		XMLMyBatisModule xmlmbm = new XMLMyBatisModule() {
			
			@Override
			protected void initialize() {
				 setClassPathResource("mybatis-config.xml");
			}
		};
		
		ServletModule SM = new ServletModuleImpl(){
			
			@Override
			protected void configureServlets() {
			      bind(StrutsPrepareAndExecuteFilter.class).in(
			        Singleton.class);
			      filter("/*").through(
			        StrutsPrepareAndExecuteFilter.class);
			     }
			    
		}; 
		
		/*Injector injector = Guice.createInjector(
			    new Struts2GuicePluginModule(), new ServletModule() {

			     @Override
			     protected void configureServlets() {
			      bind(StrutsPrepareAndExecuteFilter.class).in(
			        Singleton.class);
			      filter("/*").through(
			        StrutsPrepareAndExecuteFilter.class);
			     }
			    }, new XMLMyBatisModule() {

			     @Override
			     protected void initialize() {
			      setEnvironmentId("development");
			      setClassPathResource("mybatis-config.xml");
			     }
			   });*/
		
		return Guice.createInjector (SGM,xmlmbm,SM);   
	}

	private class ServletModuleImpl extends ServletModule

	 {
		@Override
		protected void configureServlets() {

			//filter("/*").through(PersistFilter.class); 
			// Struts 2 setup
			bind(StrutsPrepareAndExecuteFilter.class).in(Singleton.class); //-----2)
			filter("/*").through(StrutsPrepareAndExecuteFilter.class); //-------2)

			//bind(BookDAO.class).to (BookDAOImpl.class);

	        }

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
