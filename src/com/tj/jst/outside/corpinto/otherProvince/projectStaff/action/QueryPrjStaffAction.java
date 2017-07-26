package com.tj.jst.outside.corpinto.otherProvince.projectStaff.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.condition.QueryPrjStaffCondition;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.service.IQueryPrjStaff;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.service.QueryPrjStaffServiceImpl;

/**
 * 查询企业人员
 * @author Administrator
 *
 */
public class QueryPrjStaffAction extends BaseAction {
	
	//所在企业组织机构代码
	private String corpCode;
	//项目人员类型
	private List<DictionaryClass> staffTypeList;
	//外省备案项目主键
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
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		String corpCode = (String)this.get("cropCode");
		//调用外省注册人员方法
		IQueryPrjStaff staffService = new QueryPrjStaffServiceImpl();
		//根据组织机构代码查询
		this.getCondition().setCorpCode(corpCode);
		//分页查询
		currentPage = staffService.pagedQuery(this.getCondition());
		this.set(getActionName(), condition);
		//人员类型
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
