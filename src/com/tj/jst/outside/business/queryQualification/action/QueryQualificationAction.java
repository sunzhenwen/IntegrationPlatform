package com.tj.jst.outside.business.queryQualification.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.queryQualification.model.Qualification;
import com.tj.jst.outside.business.queryQualification.service.IQueryQualificationService;
import com.tj.jst.outside.business.queryQualification.service.QueryQualificationServiceImpl;

/**
 * 业务查询
 * 
 * @author Administrator
 *
 */
public class QueryQualificationAction extends BaseAction {
	
	private String corpCode ;
	private List<Qualification> qualifications ;
	
	public String queryCorpCode(){
		return "queryCorpCode";
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public String queryQualifications() {
		IQueryQualificationService service = new QueryQualificationServiceImpl();
		qualifications = service.queryPage(corpCode);
		return "queryPage";
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

}