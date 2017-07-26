package com.tj.jst.outside.business.quality.action;

import java.io.UnsupportedEncodingException;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualityanxmfzCondition;

/**
 * ��Ŀ������
 * @author Administrator
 *
 */
public class QualityanxmfzAction extends BaseAction {
	
	private String corpname;
	
	//��˾����
	private String contractorCorpNamezb;

	
	public String getContractorCorpNamezb() {
		return contractorCorpNamezb;
	}

	public void setContractorCorpNamezb(String contractorCorpNamezb) {
		this.contractorCorpNamezb = contractorCorpNamezb;
	}

	private QualityanxmfzCondition condition = new QualityanxmfzCondition();
	public void setCondition(QualityanxmfzCondition condition) {
		this.condition = condition;
	}

	public QualityanxmfzCondition getCondition() {
		QualityanxmfzCondition sessionCondition = (QualityanxmfzCondition)get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	/**
	 * ��ѯ��Ŀ������
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String queryPageanxmfz() throws UnsupportedEncodingException
	{
		if("".equals(corpname) || corpname ==null)
		{
			return "queryPrjPageanxmfz";
		}else
		{
			IContractFilingService service = new ContractFilingServiceImpl();
			//��ҳ��ѯ
			currentPage = service.pagedQueryxmfz(this.getCondition());
			this.set(getActionName(), condition);
	        return "queryPrjPageanxmfz";
		}
		
	}

	public String getCorpname() {
		return corpname;
	}

	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}
	
}
