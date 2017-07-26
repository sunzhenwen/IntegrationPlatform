package com.tj.jst.inner.codeChange.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.codeChange.condition.CodeChangeCondition;
import com.tj.jst.inner.codeChange.model.CodeChange;
import com.tj.jst.inner.codeChange.service.CodeChangeServiceImpl;
import com.tj.jst.inner.codeChange.service.ICodeChangeService;
import com.tj.jst.login.model.Login;

/**
 * ��֯����������
 * @author hhc 2016-04-21
 *
 */
public class CodeChangeAction extends BaseAction {
	
	private CodeChange codeChange;//��֯��������ʵ����
	private String message;//������ʾ��Ϣ
	private CodeChangeCondition condition = new CodeChangeCondition(((Login)this.get("login")).getCorpCode());
	
	public void setCondition(CodeChangeCondition condition) {
		this.condition = condition;
	}

	public CodeChangeCondition getCondition() {
		CodeChangeCondition sessionCondition = (CodeChangeCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯȫ�������¼
	 * @return
	 */
	public String queryPage()
	{
		ICodeChangeService service = new CodeChangeServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ��ת���ҳ��
	 * @return
	 */
	public String addPage()
	{
		return "addPage";
	}
	
	/**
	 * ���
	 * @return
	 */
	public String add()
	{
		ICodeChangeService service = new CodeChangeServiceImpl();
		message = service.add(codeChange);
		return "query";
	}

	/**
	 * ����
	 * @return
	 */
	public String goBack()
	{
		return "query";
	}
	
	public CodeChange getCodeChange() {
		return codeChange;
	}

	public void setCodeChange(CodeChange codeChange) {
		this.codeChange = codeChange;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
