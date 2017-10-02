package org.metasee.database.action.interceptor;

import java.util.*;

import org.metasee.database.action.SuperClass;

import com.opensymphony.xwork2.*;

import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		Integer userid = (Integer)session.get("userid");
		if(null == userid || 0 == userid){
			ctx.put("message",(new SuperClass()).getPleaseLogin());
			return Action.LOGIN;
		}
		return invocation.invoke();
	}
}
