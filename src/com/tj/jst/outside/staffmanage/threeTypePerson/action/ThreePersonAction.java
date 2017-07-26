package com.tj.jst.outside.staffmanage.threeTypePerson.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.model.ThreeTypePerson;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.service.IThreeTypePersonService;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.service.ThreeTypePersonServiceImpl;
import com.tj.jst.outside.staffmanage.threeTypePerson.condition.ThreePersonCondition;

/**
 * ��ʡ������Ա
 * @author Administrator
 *
 */
public class ThreePersonAction extends BaseAction {
	
	//����
	private String threeTypePersonId;
	//��ʡ������Ա
	private ThreeTypePerson threeTypePerson;
	//��ʾ��Ϣ
	private String message;
	
	private ThreePersonCondition condition = new ThreePersonCondition();
	
	public void setCondition(ThreePersonCondition condition) {
		this.condition = condition;
	}

	public ThreePersonCondition getCondition() {
		ThreePersonCondition sessionCondition = (ThreePersonCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * ��ѯ��ʡ������Ա
	 * @return
	 */
	public String queryPage()
	{
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		String corpId = (String)this.get("userId");
		this.getCondition().setCorpId(corpId);
		//��ҳ��ѯ
		currentPage = staffService.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "threeTypePersonSuccess";
	}
	
	/**
	 * ��ѯ��ϸ
	 * @return
	 */
	public String detailed()
	{
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		threeTypePerson = staffService.queryById(threeTypePersonId);
		return "detailed";
	}
	
	/**
	 * ����
	 * @return
	 */
	public String goList()
	{
		return "queryPage";
	}
	
	/**
	 * ����ҵ�����Ŀ¼
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ThreeTypePerson getThreeTypePerson() {
		return threeTypePerson;
	}

	public void setThreeTypePerson(ThreeTypePerson threeTypePerson) {
		this.threeTypePerson = threeTypePerson;
	}

	public String getThreeTypePersonId() {
		return threeTypePersonId;
	}

	public void setThreeTypePersonId(String threeTypePersonId) {
		this.threeTypePersonId = threeTypePersonId;
	}

}
