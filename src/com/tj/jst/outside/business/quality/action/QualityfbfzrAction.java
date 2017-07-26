package com.tj.jst.outside.business.quality.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import ws.client.tenderinfo.InfoClient;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.UtilDecode;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDao;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDaoImpl;

/**
 * 专业分包项目负责人 
 * @author Administrator
 *
 */
public class QualityfbfzrAction extends BaseAction {
	
	//企业名称
	private String contractorCorpNamefb;
	//身份证
	private String cardNum;
	private String fname;
	private String l;
	private List list;
		
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getContractorCorpNamefb() {
		return contractorCorpNamefb;
	}

	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public void setContractorCorpNamefb(String contractorCorpNamefb) {
		this.contractorCorpNamefb = contractorCorpNamefb;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	/*----------------------------------------------------------------------------------------------------------*/	
//	private QualityanfzCondition condition = new QualityanfzCondition();	
//	public void setCondition(QualityanfzCondition condition) {
//		this.condition = condition;
//	}
//	public QualityanfzCondition getCondition() {
//		QualityanfzCondition sessionCondition = (QualityanfzCondition)get(getActionName());
//		if (sessionCondition != null)
//		{
//			condition = sessionCondition;
//		}
//		return condition;
//	}
	/**
	 * 专业分包项目负责人 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String queryPagefbfzr() throws UnsupportedEncodingException
	{
		if("".equals(contractorCorpNamefb))
		{
			return "queryPrjPagefbfzr";
		}else
		{
			contractorCorpNamefb = UtilDecode.getDecode(contractorCorpNamefb.trim());
			InfoClient infoclient=new InfoClient();
			
			//list=infoclient.getPERSON_SLRYList("","黑河市欣亚建筑劳务有限公司","1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			PositionAndThreePersonDao dao = new PositionAndThreePersonDaoImpl();
			if(dao.queryCorpBasicIndfo(contractorCorpNamefb, "")){
				list=infoclient.getPERSON_SLRYList("",contractorCorpNamefb,"1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			}else
			{
			    list=dao.queryPERSON_SLRYList("", contractorCorpNamefb);
			}
			
			ServletActionContext.getRequest().getSession().setAttribute("userrrr",l);
			return "queryPrjPagefbfzr";
		}
		
	}
	
	//按姓名查询
	public String queryPageanfzc()
	{
		if("".equals(contractorCorpNamefb))
		{
			return "queryPrjPagefbfzr";
		}else
		{
			contractorCorpNamefb = UtilDecode.getDecode(contractorCorpNamefb.trim());
			InfoClient infoclient=new InfoClient();
			//list=infoclient.getPERSON_SLRYList(cardNum,"黑河市欣亚建筑劳务有限公司","1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			PositionAndThreePersonDao dao = new PositionAndThreePersonDaoImpl();
			if(dao.queryCorpBasicIndfo(contractorCorpNamefb, ""))
			{
				list=infoclient.getPERSON_SLRYList(cardNum,contractorCorpNamefb,"1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			}
			else
			{
				list=dao.queryPERSON_SLRYList(cardNum, contractorCorpNamefb);
			}
			
			return "queryPrjPagefbfzr";
		}
		
	}
	
	
}
