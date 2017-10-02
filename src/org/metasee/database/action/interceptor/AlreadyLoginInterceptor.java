package org.metasee.database.action.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AlreadyLoginInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map attibutes = ActionContext.getContext().getSession();
		if(attibutes.containsKey("userid")){
			//Integer userid = (Integer)attibutes.get("userid");
			//if(0 != userid && null != userid){
				return "logedon";
			//}
		}
		return invocation.invoke();
	}
}
