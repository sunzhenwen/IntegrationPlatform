package com.tj.jst.inner.codeChange.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.codeChange.condition.CodeChangeCondition;
import com.tj.jst.inner.codeChange.model.CodeChange;
import com.tj.jst.inner.codeChange.service.CodeChangeServiceImpl;
import com.tj.jst.inner.codeChange.service.ICodeChangeService;
import com.tj.jst.login.model.Login;

/**
 * 组织机构代码变更
 * @author hhc 2016-04-21
 *
 */
public class CodeChangeAction extends BaseAction {
	
	private CodeChange codeChange;//组织机构代码实体类
	private String message;//返回提示信息
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
	 * 查询全部变更记录
	 * @return
	 */
	public String queryPage()
	{
		ICodeChangeService service = new CodeChangeServiceImpl();
		//分页查询
		currentPage = service.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 跳转添加页面
	 * @return
	 */
	public String addPage()
	{
		return "addPage";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String add()
	{
		ICodeChangeService service = new CodeChangeServiceImpl();
		message = service.add(codeChange);
		return "query";
	}

	/**
	 * 返回
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
