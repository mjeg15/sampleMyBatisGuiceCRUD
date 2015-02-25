package login;

import tests.MEmployeeMapperOLD;
import tests.MEmployeeServiceOLD;
import tests.MUserMapperOLD;
import tests.MUserServiceOLD;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;

public class MyBatisSampleModule extends AbstractModule{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(MEmployeeMapperOLD.class).to(MEmployeeServiceOLD.class);
		bind(MUserMapperOLD.class).to(MUserServiceOLD.class);
	}
	
}
