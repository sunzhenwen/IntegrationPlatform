package com.tj.jst.outside.corpinto.otherProvince.project.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.project.condition.OtherProjectCondition;
import com.tj.jst.outside.corpinto.otherProvince.project.service.IOtherProjectService;
import com.tj.jst.outside.corpinto.otherProvince.project.service.OtherProjectServiceImpl;

/**
 * ��ʡ��Ŀ����
 * @author Administrator
 *
 */
public class OtherProjectAction extends BaseAction {
	
	//��Ŀ����ʵ����
	private Construction construction;
	//����
	private String otherPrjId;
	//��ҵ��֯��������
	private String corpCode;
	//��ҵ����
	private String corpName;
	//��ҵ����
	private String corpId;
	
	
	
	private OtherProjectCondition condition = new OtherProjectCondition();
	
	public void setCondition(OtherProjectCondition condition) {
		this.condition = condition;
	}

	public OtherProjectCondition getCondition() {
		OtherProjectCondition sessionCondition = (OtherProjectCondition) get(getActionName());
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
		//��ȡ�û�����
		String corpId = (String)this.get("userId");
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		this.getCondition().setCorpId(corpId);
		//��ҳ��ѯ
		currentPage = ocs.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "otherProjectSuccess";
	}
	
	/**
	 * ��ת���ҳ��
	 * @return
	 */
	public String addPage()
	{
		corpName = (String)this.get("userName");
		corpCode = (String)this.get("cropCode");
		corpId = (String)this.get("userId");
		//this.queryDictionaryClass();
		return "addPage";
	}
	
	/**
	 * ���
	 * @return
	 */
	public String add()
	{
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		otherPrjId = ocs.add(construction);
		return "queryAdd";
	}
	
	/**
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public String modifyPage()
	{
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		construction = ocs.queryById(otherPrjId);
		return "modifyPage";
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public String modify()
	{
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		ocs.modify(construction);
		return "queryPage";
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public String delete()
	{
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		ocs.delete(otherPrjId);
		return "queryPage";
	}
	
	/**
	 * ����
	 * @return
	 */
	public String goBack()
	{
		return "goBusiness";
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
	 * ��ϸ
	 * @return
	 */
	public String detailed()
	{
		IOtherProjectService ocs = new OtherProjectServiceImpl();
		//constructor = ocs.queryDetailed(idCard,corpCode);
		return "detailed";
	}

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
	}

	public String getOtherPrjId() {
		return otherPrjId;
	}

	public void setOtherPrjId(String otherPrjId) {
		this.otherPrjId = otherPrjId;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}
	
}
