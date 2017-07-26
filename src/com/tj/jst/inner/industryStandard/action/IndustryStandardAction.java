package com.tj.jst.inner.industryStandard.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.industryStandard.condition.IndustryStandardCondition;
import com.tj.jst.inner.industryStandard.model.IndustryStandard;
import com.tj.jst.inner.industryStandard.service.IIndustryStandardService;
import com.tj.jst.inner.industryStandard.service.IndustryStandardServiceImpl;
import com.tj.jst.login.model.Login;

/**
 * 行业标准
 * 
 * @author DarkFlameMaster
 *
 */
public class IndustryStandardAction extends BaseAction {
	
	private String isId;
	private IndustryStandard industryStandard;
	private List<DictionaryClass> isTypes;//发布种类
	private List<DictionaryClass> isPublishs;//是否发布

	private IndustryStandardCondition condition = new IndustryStandardCondition();

	public void setCondition(IndustryStandardCondition condition) {
		this.condition = condition;
	}

	public IndustryStandardCondition getCondition() {
		IndustryStandardCondition sessionCondition = (IndustryStandardCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * 查询分页
	 * 
	 * @return
	 */
	public String queryPage() {
		IIndustryStandardService service = new IndustryStandardServiceImpl();
		isTypes = service.queryIsTypes();
		isPublishs = service.queryIsPublishs();
		currentPage = service.queryPage(condition);
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * 增加发布信息页面
	 * 
	 * @return
	 */
	public String addPage() {
		IIndustryStandardService service = new IndustryStandardServiceImpl();
		isTypes = service.queryIsTypes();
		isPublishs = service.queryIsPublishs();
		return "addPage";
	}

	/**
	 * 增加发布信息方法
	 * 
	 * @return
	 */
	public String add() {
		IIndustryStandardService service = new IndustryStandardServiceImpl();
		Login login = (Login)this.get("login");
		industryStandard.setInputStaff(login.getName());
		industryStandard.setPublishStaff(login.getName());
		service.add(industryStandard);
		return "query";
	}

	/**
	 * 修改信息页面
	 * 
	 * @return
	 */
	public String modifyPage() {
		IIndustryStandardService service = new IndustryStandardServiceImpl();
		industryStandard = service.queryById(isId);
		isTypes = service.queryIsTypes();
		isPublishs = service.queryIsPublishs();
		return "modifyPage";
	}

	/**
	 * 修改信息方法
	 * 
	 * @return
	 */
	public String modify() {
		IIndustryStandardService service = new IndustryStandardServiceImpl();
		Login login = (Login)this.get("login");
		industryStandard.setModifyStaff(login.getName());
		industryStandard.setPublishStaff(login.getName());
		service.modify(industryStandard);
		return "query";
	}

	/**
	 * 删除
	 */
	public String delete()
	{
		IIndustryStandardService service = new IndustryStandardServiceImpl();
		service.delete(isId);
		return "query";
	}
	
	/**
	 * 返回方法
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getIsId() {
		return isId;
	}

	public void setIsId(String isId) {
		this.isId = isId;
	}

	public IndustryStandard getIndustryStandard() {
		return industryStandard;
	}

	public void setIndustryStandard(IndustryStandard industryStandard) {
		this.industryStandard = industryStandard;
	}

	public List<DictionaryClass> getIsTypes() {
		return isTypes;
	}

	public void setIsTypes(List<DictionaryClass> isTypes) {
		this.isTypes = isTypes;
	}

	public List<DictionaryClass> getIsPublishs() {
		return isPublishs;
	}

	public void setIsPublishs(List<DictionaryClass> isPublishs) {
		this.isPublishs = isPublishs;
	}

}
