package com.tj.jst.outside.business.credibility.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.credibility.condition.QueryCredCondition;
import com.tj.jst.outside.business.credibility.condition.QueryCredConditionn;
import com.tj.jst.outside.business.credibility.model.CrediBillity;
import com.tj.jst.outside.business.quality.condition.QualityPrjsCondition;
import com.tj.jst.outside.business.quality.condition.QualityjlCondition;
import com.tj.jst.outside.business.quality.condition.QualitykcsCondition;
import com.tj.jst.outside.business.quality.condition.QualitysjCondition;
import com.tj.jst.outside.business.quality.condition.QualityzbCondition;

/**
 * 项目信息查询
 * @author Administrator
 *
 */
public class queryCredAction extends BaseAction {
	private String result;
    private String corpCode;
	private String corpbadcreditid;
	CrediBillity credibillity=new CrediBillity();
	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
public String getCorpbadcreditid() {
		return corpbadcreditid;
	}

	public void setCorpbadcreditid(String corpbadcreditid) {
		this.corpbadcreditid = corpbadcreditid;
	}

	public CrediBillity getCredibillity() {
		return credibillity;
	}

	public void setCredibillity(CrediBillity credibillity) {
		this.credibillity = credibillity;
	}

	/*----------------------------------------------------------------------------------------------------------*/	
	private QueryCredCondition condition = new QueryCredCondition();
	public QueryCredCondition getCondition() {
		QueryCredCondition sessionCondition = (QueryCredCondition)get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		
		return condition;
		}
	public void setCondition(QueryCredCondition condition) {
		this.condition = condition;
	}
	/**
	 * 查询企业诚信信息
	 * @return 
	 */
	public String queryPage()
	{
		IContractFilingService service = new ContractFilingServiceImpl();
		String corpCode = (String)this.get("cropCode");
		this.getCondition().setCorpCode(corpCode);
	    //分页查询
		currentPage = service.pagedQueryQycred(this.getCondition());		
		this.set(getActionName(), condition);
        return "queryPage";
	}
	
	/**
	 * 企业信息明细查询
	 * @return 
	 */
	public String queryPagee()
	{   
		IContractFilingService service = new ContractFilingServiceImpl();
		String corpCode = (String)this.get("cropCode");
	    //分页查询
		 credibillity = service.querycred(corpbadcreditid);		
		this.set(getActionName(), condition);
        return "queryPagee";
	}
	/**
	 * 页面跳转
	 * @return 
	 */
	public String query(){
        return "query";
	}
	
	
}
