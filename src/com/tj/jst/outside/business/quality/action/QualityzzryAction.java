package com.tj.jst.outside.business.quality.action;

import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.UtilDecode;
import com.tj.jst.outside.business.contractFiling.service.ContractFilingServiceImpl;
import com.tj.jst.outside.business.contractFiling.service.IContractFilingService;
import com.tj.jst.outside.business.quality.condition.QualityzzryCondition;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDao;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDaoImpl;

/**
 * �ֳ�רְ��ȫ������Ա
 * @author Administrator
 *
 */
public class QualityzzryAction extends BaseAction {
	
	private String corpname;
	private String i;
	


	public String getCorpname() {
		return corpname;
	}

	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}

	private String result;
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String getI() {
		return i;
	}

	public void setI(String i) {
		this.i = i;
	}

	/*----------------------------------------------------------------------------------------------------------*/	
	private QualityzzryCondition condition = new QualityzzryCondition();
	public void setCondition(QualityzzryCondition condition) {
		this.condition = condition;
	}

	public QualityzzryCondition getCondition() {
		QualityzzryCondition sessionCondition = (QualityzzryCondition)get(getActionName());
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
	public String queryPagezzry() throws UnsupportedEncodingException
	{   
		
		if("".equals(corpname) || corpname ==null)
		{
			return "queryPrjPagezzry";
		}else
		{
			corpname = UtilDecode.getDecode(corpname);
			IContractFilingService service = new ContractFilingServiceImpl();
			//��̬�ж��±�
			ServletActionContext.getRequest().getSession().setAttribute("user",i);
			//��ҳ��ѯ
			PositionAndThreePersonDao dao = new PositionAndThreePersonDaoImpl();
			if(dao.queryCorpBasicIndfo(corpname, ""))
			{
				currentPage = service.pagedQueryzzry(this.getCondition());
			}
			else
			{
				//��ѯ��ʡ��ҵ
				currentPage = service.pagedQueryzzryNoLocal(this.getCondition());
			}
			
			
			this.set(getActionName(), condition);
	        return "queryPrjPagezzry";
		}
		
	}
	
	
}
