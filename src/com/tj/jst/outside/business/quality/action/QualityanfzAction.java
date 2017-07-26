package com.tj.jst.outside.business.quality.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import ws.client.tenderinfo.InfoClient;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.UtilDecode;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDao;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDaoImpl;

/**
 * ��ȫ��������
 * @author Administrator
 *
 */
public class QualityanfzAction extends BaseAction {
	
	//��˾����
	private String personaqfz;
	//��Ա����
	private String fname;
	//���֤��
	private String cardNum;
	
	private List list;
	
	public String getPersonaqfz() {
		return personaqfz;
	}
	public void setPersonaqfz(String personaqfz) {
		this.personaqfz = personaqfz;
	}
	
	public String getFname() {
		return fname;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	/**
	 * ��ѯ��ȫ��������Ϣ
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String queryPageanfz() throws UnsupportedEncodingException
	{
		
		personaqfz = UtilDecode.getDecode(personaqfz);
		
		if("".equals(personaqfz) || personaqfz ==null)
		{
			return "queryPrjPageanfz";
		}else
		{
			InfoClient infoclient=new InfoClient();
			//��֯�������롢��λ����
			//list = infoclient.getPERSON_SLRYList("","�ں������ǽ����������޹�˾","1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			PositionAndThreePersonDao dao = new PositionAndThreePersonDaoImpl();
			if(dao.queryCorpBasicIndfo(personaqfz, ""))
			{
				list=infoclient.getPERSON_SLRYList("",personaqfz,"1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			}
			else
			{
				list=dao.queryPERSON_SLRYList("", personaqfz);
			}
			return "queryPrjPageanfz";
		}
		
		
	}
	//�����֤�Ų�ѯ
	public String queryPageanfzc()
	{
		
		InfoClient infoclient=new InfoClient();
		
		//list=infoclient.getPERSON_SLRYList(cardNum,"�ں������ǽ����������޹�˾","1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
		
		PositionAndThreePersonDao dao = new PositionAndThreePersonDaoImpl();
		if(dao.queryCorpBasicIndfo(personaqfz, ""))
		{
			list=infoclient.getPERSON_SLRYList(cardNum,personaqfz,"1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
		}
		else
		{
			list=dao.queryPERSON_SLRYList("", personaqfz);
		}
		
		Page page=new Page();
		page.getData().addAll(list);
		currentPage=page;
        return "queryPrjPageanfz";
	}

}
