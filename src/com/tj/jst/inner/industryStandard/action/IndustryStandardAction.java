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
 * ��ҵ��׼
 * 
 * @author DarkFlameMaster
 *
 */
public class IndustryStandardAction extends BaseAction {
	
	private String isId;
	private IndustryStandard industryStandard;
	private List<DictionaryClass> isTypes;//��������
	private List<DictionaryClass> isPublishs;//�Ƿ񷢲�

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
	 * ��ѯ��ҳ
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
	 * ���ӷ�����Ϣҳ��
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
	 * ���ӷ�����Ϣ����
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
	 * �޸���Ϣҳ��
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
	 * �޸���Ϣ����
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
	 * ɾ��
	 */
	public String delete()
	{
		IIndustryStandardService service = new IndustryStandardServiceImpl();
		service.delete(isId);
		return "query";
	}
	
	/**
	 * ���ط���
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
