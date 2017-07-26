package com.tj.jst.outside.business.authorization.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.authorization.condition.AuthorizationCondition;
import com.tj.jst.outside.business.authorization.model.Authorization;
import com.tj.jst.outside.business.authorization.service.AuthorizationServiceImpl;
import com.tj.jst.outside.business.authorization.service.IAuthorizationService;

/**
 * 授权
 * @author hhc
 *
 */
public class AuthorizationAction extends BaseAction {
	
	private String id;
	private Authorization authorization;
	//企业类型
	private List<DictionaryClass> enterpriseTypes;
	
	private AuthorizationCondition condition = new AuthorizationCondition();
	
	public void setCondition(AuthorizationCondition condition) {
		this.condition = condition;
	}

	public AuthorizationCondition getCondition() {
		AuthorizationCondition sessionCondition = (AuthorizationCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IAuthorizationService service = new AuthorizationServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转授权页面
	 * @return
	 */
	public String addPage()
	{
		IAuthorizationService service = new AuthorizationServiceImpl();
		//查询企业类型
		enterpriseTypes = service.queryEnterpriseTypes();
		return "addPage";
	}
	
	/**
	 * 授权
	 * @return
	 */
	public String add()
	{
		IAuthorizationService service = new AuthorizationServiceImpl();
		service.add(authorization);
		return "query";
	}
	
	/**
	 * 取消授权
	 * @return
	 */
	public String delete()
	{
		IAuthorizationService service = new AuthorizationServiceImpl();
		service.delete(id);
		return "query";
	}
	
	/**
	 * 返回项目报建列表目录
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * 返回业务办理目录
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DictionaryClass> getEnterpriseTypes() {
		return enterpriseTypes;
	}

	public void setEnterpriseTypes(List<DictionaryClass> enterpriseTypes) {
		this.enterpriseTypes = enterpriseTypes;
	}
	
}
