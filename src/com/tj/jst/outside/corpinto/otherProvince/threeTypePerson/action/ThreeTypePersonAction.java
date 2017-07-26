package com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.condition.ThreeTypePersonCondition;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.model.ThreeTypePerson;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.service.IThreeTypePersonService;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.service.ThreeTypePersonServiceImpl;

/**
 * ��ʡ������Ա
 * @author Administrator
 *
 */
public class ThreeTypePersonAction extends BaseAction {
	
	//����
	private String threeTypePersonId;
	//��ʡ������Ա
	private ThreeTypePerson threeTypePerson;
	//��ʾ��Ϣ
	private String message;
	
	private ThreeTypePersonCondition condition = new ThreeTypePersonCondition();
	
	public void setCondition(ThreeTypePersonCondition condition) {
		this.condition = condition;
	}

	public ThreeTypePersonCondition getCondition() {
		ThreeTypePersonCondition sessionCondition = (ThreeTypePersonCondition) get(getActionName());
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
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		this.getThreeTypePerson().setCorpId((String)this.get("userId"));
		String userName = (String)this.get("userName");
		this.getThreeTypePerson().setFEntName(userName);
		this.getThreeTypePerson().setFEntName1(userName);
		message = staffService.add(threeTypePerson);
		return "queryPage";
	}
	
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		threeTypePerson = staffService.queryById(threeTypePersonId);
		return "modifyPage";
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public String modify()
	{
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		message = staffService.modify(threeTypePerson);
		return "queryPage";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		IThreeTypePersonService staffService = new ThreeTypePersonServiceImpl();
		message = staffService.delete(threeTypePersonId);
		return "queryPage";
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
