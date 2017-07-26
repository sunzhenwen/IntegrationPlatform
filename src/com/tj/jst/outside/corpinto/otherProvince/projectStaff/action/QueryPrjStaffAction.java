package com.tj.jst.outside.corpinto.otherProvince.projectStaff.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.condition.QueryPrjStaffCondition;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.service.IQueryPrjStaff;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.service.QueryPrjStaffServiceImpl;

/**
 * ��ѯ��ҵ��Ա
 * @author Administrator
 *
 */
public class QueryPrjStaffAction extends BaseAction {
	
	//������ҵ��֯��������
	private String corpCode;
	//��Ŀ��Ա����
	private List<DictionaryClass> staffTypeList;
	//��ʡ������Ŀ����
	private String otherPrjId;
	private Construction construction;
	
	private QueryPrjStaffCondition condition = new QueryPrjStaffCondition();
	
	public void setCondition(QueryPrjStaffCondition condition) {
		this.condition = condition;
	}

	public QueryPrjStaffCondition getCondition() {
		QueryPrjStaffCondition sessionCondition = (QueryPrjStaffCondition) get(getActionName());
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
		String corpCode = (String)this.get("cropCode");
		//������ʡע����Ա����
		IQueryPrjStaff staffService = new QueryPrjStaffServiceImpl();
		//������֯���������ѯ
		this.getCondition().setCorpCode(corpCode);
		//��ҳ��ѯ
		currentPage = staffService.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		//��Ա����
		staffTypeList = staffService.queryStaffType();
		this.setOtherPrjId(otherPrjId);
		return "queryPrjStaff";
		
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public List<DictionaryClass> getStaffTypeList() {
		return staffTypeList;
	}

	public void setStaffTypeList(List<DictionaryClass> staffTypeList) {
		this.staffTypeList = staffTypeList;
	}

	public String getOtherPrjId() {
		return otherPrjId;
	}

	public void setOtherPrjId(String otherPrjId) {
		this.otherPrjId = otherPrjId;
	}

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
	}
	
}
