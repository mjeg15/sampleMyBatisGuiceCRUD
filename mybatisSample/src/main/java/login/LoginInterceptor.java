package login;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor  extends AbstractInterceptor {

        @Override
        public String intercept(ActionInvocation invocation) throws Exception {
                Map<String, Object> session = invocation.getInvocationContext().getSession();

                String loginId = (String) session.get("username");

                if (loginId == null) 
                {
                	System.out.println("DUMAAN BA DITO");
                	return Action.LOGIN;
                        
                } 
                else 
                {
                	System.out.println("OR DITO");
                	return invocation.invoke();
                }
        }
}