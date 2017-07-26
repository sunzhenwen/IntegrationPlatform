package com.tj.jst.base.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.tj.jst.base.action.CodeCertificateAction;
import com.tj.jst.login.action.LoginAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.queryQualification.action.QueryQualificationAction;
import com.tj.jst.outside.corpinto.notforeign.action.CorpAction;
import com.tj.jst.outside.corpinto.otherProvince.corp.action.OtherProvinceAction;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
    public String intercept(ActionInvocation invocation) throws Exception {
 
		if(QueryQualificationAction.class.equals(invocation.getAction().getClass())){
        	return invocation.invoke();
        }else if(CorpAction.class.equals(invocation.getAction().getClass())){
            return invocation.invoke();
        }else{
        	//取得请求的URL
    		//String url = ServletActionContext.getRequest().getRequestURL().toString();
    		//验证Session是否过期
    		if(!ServletActionContext.getRequest().isRequestedSessionIdValid()){
    			//session过期,转向session过期提示页,最终跳转至登录页面
    			return "login";
    		}else
    		{
    			
    			/**
    	         * 过滤掉登录所用的action，此action将不被拦截
    	         */
    	        if(LoginAction.class.equals(invocation.getAction().getClass())){
    	            return invocation.invoke();
    	        }
    	        if(CodeCertificateAction.class.equals(invocation.getAction().getClass())){
    	        	return invocation.invoke();
    	        }

    	        if(OtherProvinceAction.class.equals(invocation.getAction().getClass())){
    	            return invocation.invoke();
    	        }
    	        
    	        
    	        /**
    	         * invocation通过getInvocationContext方法可获取session
    	         */
    	        Login login = (Login)ServletActionContext.getRequest().getSession().getAttribute("login");
    	        if(null == login){
    	 
    	            /**
    	             * 返回登录页面
    	             */
    	            return "login";
    	        }
    	 
    	        /**
    	         * 如果不为空继续先下执行
    	         */
    	        return invocation.invoke();
    		}
        }
		
	}
}
