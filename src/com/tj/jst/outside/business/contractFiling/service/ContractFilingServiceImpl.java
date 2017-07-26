package com.tj.jst.outside.business.contractFiling.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import pojo.CORP_AQSCXKZ;
import pojo.PERSON_SLRY;
import ws.client.tenderinfo.InfoClient;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.dao.ContractFilingDaoImpl;
import com.tj.jst.outside.business.contractFiling.dao.IContractFilingDao;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.credibility.model.CrediBillity;
import com.tj.jst.outside.business.credibility.model.CrediBillityGood;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDao;
import com.tj.jst.outside.business.quality.dao.PositionAndThreePersonDaoImpl;


/**
 * ��ͬ����
 * @author hhc
 *
 */
public class ContractFilingServiceImpl implements IContractFilingService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.pagedQuery(condition);
	}	
	
	/**
	 * ��ͬ��������
	 * @return
	 */
	public String add(ContractFiling contractFiling)
	{
		IContractFilingDao dao = new ContractFilingDaoImpl();
		String type = contractFiling.getContractTypeNum();
			switch (type) {
			case "100":
				type = "-HB-";
				break;
			case "200":
				type = "-HA-";
				break;
			case "301":
				type = "-HZ-";
				break;
			case "302":
				type = "-HF-";
				break;
			case "303":
				type = "-HL-";
				break;
			case "400":
				type = "-HE-";
				break;
			case "500":
				type = "-HC-";
				break;
			case "600":
				type = "-HG-";
				break;
			case "700":
				type = "-HM-";
				break;

			}
			Calendar c = Calendar.getInstance();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
			String fDate = simpleDateFormat.format(c.getTime());
			String serNum = PrjCode.querySerNuma(new Date(new java.util.Date().getTime()), 3);
			String recordNum = contractFiling.getAppDept() + fDate
					+ contractFiling.getPrjNum().substring(12, 16) + type + serNum;
			contractFiling.setRecordNum(recordNum);
		return dao.add(contractFiling);
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId)
	{
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.queryById(recordId);
	}
	
	/**
	 * ��ͬ���������޸�
	 * @return
	 */
	public void modify(ContractFiling contractFiling)
	{
		IContractFilingDao dao = new ContractFilingDaoImpl();
		dao.modify(contractFiling);
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String recordId)
	{
		IContractFilingDao dao = new ContractFilingDaoImpl();
		dao.delete(recordId);
	}

	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.queryAppDept();
	}
	//��ͬ���
	public List<DictionaryClass> queryContractTypeNums()
	{
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.queryContractTypeNums();
	}
	/**
	 * ��ѯ��Ŀ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedPrjQuery(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.pagedPrjQuery(condition);
	}
	/**
	 * ��ѯ���쵥λ
	 * @param Condition
	 * @return
	 */
	@Override
	public Page pagedkcQuery(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.pagedkcQuery(condition);
	}
	
	/**
	 * ��ѯ��Ͷ����Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition)
	{
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.pagedTbInfoQuery(condition);
	}
	
	/**
	 * ��ѯ��ҵ����
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQuery(Condition condition)
	{
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.pagedTitleLeveQuery(condition);
	}

	@Override
	public List<ContractFiling> queryByNum(String PjNum) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.queryByPrNum(PjNum);
		
	}
	/**
	 * ��ѯ����λ��Ϣ
	 * @param condition
	 * @return
	 */
	@Override
	public Page pagedQueryjl(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.pagedTitleLeveQueryjl(condition);
	}
	/**
	 * ��ѯ�ܳа���Ϣ
	 * @param condition
	 * @return
	 */

	@Override
	public Page pagedQueryzb(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.pagedTitleLeveQueryzb(condition);
	}
	/**
	 * ��ѯ��ҵ����
	 * @param condition
	 * @return
	 */

	@Override
	public Page pagedQueryQycred(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.pagedTitleLeveQueryQycred(condition);
	}
	/**
	 * ��ѯ��ҵ����good
	 * @param condition
	 * @return
	 */

	@Override
	public Page pagedQueryQycredgood(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.pagedTitleLeveQueryQycredgood(condition);
	}
	@Override
	public Page pagedQueryfb(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		Page page=dao.pagedTitleLeveQueryfb(condition);
		InfoClient ic = new InfoClient();
		for(int i=0;i<page.getData().size();i++)
		{
			//�а���λ����
			String corpName = ((ContractFiling)page.getData().get(i)).getContractorCorpNameFB();
			//�а���λ��֯��������
			//String corpCode = ((ContractFiling)page.getData().get(i)).getContractorCorpCode();
			//ͨ���ӿڻ�ȡ��ȫ�������֤
			List<CORP_AQSCXKZ>  cas = ic.getCORP_AQSCXKZList("", corpName, "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			
			//ѭ�����صİ�ȫ�������֤��Ϣ
			for(int j=0;j<cas.size();j++)
			{
				//�����ȫ�������֤��Ч
				if(cas.get(j).getFState().equals("��Ч"))
				{
					((ContractFiling)page.getData().get(i)).setConstructorNamefbdate(cas.get(0).getFRegEndDate());
				}
			}
			
		}

		
		return page;
	}

	@Override
	public Page pagedQuerylw(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		Page page=dao.pagedTitleLeveQuerylw(condition);
		InfoClient ic = new InfoClient();
		for(int i=0;i<page.getData().size();i++)
		{
			//�а���λ����
			String corpName = ((ContractFiling)page.getData().get(i)).getContractorCorpNameLW();
			//�а���λ��֯��������
			//String corpCode = ((ContractFiling)page.getData().get(i)).getContractorCorpCode();
			//ͨ���ӿڻ�ȡ��ȫ�������֤
			List<CORP_AQSCXKZ>  cas = ic.getCORP_AQSCXKZList("", corpName, "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			
			//ѭ�����صİ�ȫ�������֤��Ϣ
			for(int j=0;j<cas.size();j++)
			{
				//�����ȫ�������֤��Ч
				if(cas.get(j).getFState().equals("��Ч"))
				{
					((ContractFiling)page.getData().get(i)).setConstructorNamelwdate(cas.get(j).getFRegEndDate());
				   
				}
			}
			
		}

		
		return page;
	}

	@Override
	public Page pagedQueryxmfz(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		Page page=dao.pagedTitleLeveQueryxmfz(condition);
		
		
		
		InfoClient ic = new InfoClient();
		for(int i=0;i<page.getData().size();i++)
		{
			//��Ŀ���������֤��
			String cardNum = ((ContractFiling)page.getData().get(i)).getConstructorNameSFZ();
			//ͨ���ӿڻ�ȡ����֤��
			List<PERSON_SLRY> cas = ic.getPERSON_SLRYList(cardNum, "", "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			PositionAndThreePersonDao dao1 = new PositionAndThreePersonDaoImpl();
			if(cas.size()==0)
			{
				cas=dao1.queryPERSON_SLRYList(cardNum, "");
			}
			if(cas.size()!=0)
			{
				//��ȡ�������
				((ContractFiling)page.getData().get(i)).setConstructorNameKHBH(cas.get(0).getFCertNumber());
			}
		}
		
		
		return page;
	}

	@Override
	public Page pagedQueryzzry(Condition condition) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		Page page=dao.pagedTitleLeveQueryzzry(condition);
		InfoClient ic = new InfoClient();
		for(int i=0;i<page.getData().size();i++)
		{
			//�ֳ�רְ��ȫ������Ա���֤��
			String cardId = ((ContractFiling)page.getData().get(i)).getConstructorNamezzrysf();
			//ͨ���ӿڻ�ȡ����֤��
			List<PERSON_SLRY> cas = ic.getPERSON_SLRYList(cardId, "", "1RGQywA@AtMTEjwADAADYEwAA2BMAAA==");
			if(cas.size()==0){
				((ContractFiling)page.getData().get(i)).setConstructorNamezzrykh("");
				
			}else{
			((ContractFiling)page.getData().get(i)).setConstructorNamezzrykh(cas.get(0).getFCertNumber());
			}
		}
		
		return page;
	}
	
	@Override
	public Page pagedQueryzzryNoLocal(Condition condition) 
	{
		// TODO �Զ����ɵķ������
		PositionAndThreePersonDao dao = new PositionAndThreePersonDaoImpl();
		Page page=dao.pagePositionQuery(condition);
		//InfoClient ic = new InfoClient();
		for(int i=0;i<page.getData().size();i++)
		{
			//�ֳ�רְ��ȫ������Ա���֤��
			String cardId = ((ContractFiling)page.getData().get(i)).getConstructorNamezzrysf();
			//ͨ���ӿڻ�ȡ����֤��
			List<PERSON_SLRY> cas = dao.queryPERSON_SLRYList(cardId, "");
			if(cas.size()==0){
				((ContractFiling)page.getData().get(i)).setConstructorNamezzrykh("");
				
			}else{
			((ContractFiling)page.getData().get(i)).setConstructorNamezzrykh(cas.get(0).getFCertNumber());
			}
		}
		
		return page;
	}
	
	

	@Override
	public CrediBillity querycred(String corpbadcreditid) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.querycred(corpbadcreditid);
	}

	@Override
	public CrediBillityGood querycredgood(String goodcreditid) {
		IContractFilingDao dao = new ContractFilingDaoImpl();
		return dao.querycredgood(goodcreditid);
	}





}
