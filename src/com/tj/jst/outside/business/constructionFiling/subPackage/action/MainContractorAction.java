package com.tj.jst.outside.business.constructionFiling.subPackage.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.constructionFiling.subPackage.condition.MainContractorCondition;
import com.tj.jst.outside.business.constructionFiling.subPackage.service.ISubPackageService;
import com.tj.jst.outside.business.constructionFiling.subPackage.service.SubPackageServiceImpl;

/**
 * ��ѯʩ���ܰ���ͬ
 * @author Administrator
 *
 */
public class MainContractorAction extends BaseAction {
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		ISubPackageService service = new SubPackageServiceImpl();
		String cropCode = (String)this.get("cropCode");
		//��ҳ��ѯ
		this.getCondition().setCorpCode(cropCode);
		currentPage = service.pagedMainContractor(this.getCondition());
		this.set(getActionName(), condition);
		return "mainContractor";
	}

	private MainContractorCondition condition = new MainContractorCondition();
	
	public void setCondition(MainContractorCondition condition) {
		this.condition = condition;
	}

	public MainContractorCondition getCondition() {
		MainContractorCondition sessionCondition = (MainContractorCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
}
