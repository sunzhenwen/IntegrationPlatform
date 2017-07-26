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
        	//ȡ�������URL
    		//String url = ServletActionContext.getRequest().getRequestURL().toString();
    		//��֤Session�Ƿ����
    		if(!ServletActionContext.getRequest().isRequestedSessionIdValid()){
    			//session����,ת��session������ʾҳ,������ת����¼ҳ��
    			return "login";
    		}else
    		{
    			
    			/**
    	         * ���˵���¼���õ�action����action����������
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
    	         * invocationͨ��getInvocationContext�����ɻ�ȡsession
    	         */
    	        Login login = (Login)ServletActionContext.getRequest().getSession().getAttribute("login");
    	        if(null == login){
    	 
    	            /**
    	             * ���ص�¼ҳ��
    	             */
    	            return "login";
    	        }
    	 
    	        /**
    	         * �����Ϊ�ռ�������ִ��
    	         */
    	        return invocation.invoke();
    		}
        }
		
	}
}
