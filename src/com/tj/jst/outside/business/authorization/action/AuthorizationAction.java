package com.tj.jst.outside.business.authorization.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.authorization.condition.AuthorizationCondition;
import com.tj.jst.outside.business.authorization.model.Authorization;
import com.tj.jst.outside.business.authorization.service.AuthorizationServiceImpl;
import com.tj.jst.outside.business.authorization.service.IAuthorizationService;

/**
 * ��Ȩ
 * @author hhc
 *
 */
public class AuthorizationAction extends BaseAction {
	
	private String id;
	private Authorization authorization;
	//��ҵ����
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IAuthorizationService service = new AuthorizationServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת��Ȩҳ��
	 * @return
	 */
	public String addPage()
	{
		IAuthorizationService service = new AuthorizationServiceImpl();
		//��ѯ��ҵ����
		enterpriseTypes = service.queryEnterpriseTypes();
		return "addPage";
	}
	
	/**
	 * ��Ȩ
	 * @return
	 */
	public String add()
	{
		IAuthorizationService service = new AuthorizationServiceImpl();
		service.add(authorization);
		return "query";
	}
	
	/**
	 * ȡ����Ȩ
	 * @return
	 */
	public String delete()
	{
		IAuthorizationService service = new AuthorizationServiceImpl();
		service.delete(id);
		return "query";
	}
	
	/**
	 * ������Ŀ�����б�Ŀ¼
	 * @return
	 */
	public String goList()
	{
		return "query";
	}
	
	/**
	 * ����ҵ�����Ŀ¼
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
