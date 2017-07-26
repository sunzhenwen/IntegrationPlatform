package com.tj.jst.outside.corpinto.notforeign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.dao.CorpDaoImpl;
import com.tj.jst.outside.corpinto.notforeign.dao.ICorpDao;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public class CorpServiceImpl implements ICorpService {

	//��ҵ��֯���������ѯ
	@Override
	public Corp queryCorpCode(String corpCode) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCorpCode(corpCode);
	}

	//��ҵ��֯���������ѯ
	public Corp queryCorpTypeCode(String corpCode)
	{
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCorpTypeCode(corpCode);
	}
	
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryProvince();
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCity(provinceId);
	}

	//������ҵ
	@Override
	public String addCorp(Corp corp) {
		ICorpDao corpDao = new CorpDaoImpl();
		if(corp.getCheckForeign().equals("0"))
		{
			//������ҵ
			return corpDao.addForeignCorp(corp);
		}else
		{
			//��������ҵ
			return corpDao.addCorp(corp);
		}
	}

	//�޸���ҵ
	@Override
	public String modifyCorp(Corp corp) {
		// TODO Auto-generated method stub
		ICorpDao corpDao = new CorpDaoImpl();
		
		if(corp.getCheckForeign().equals("0"))
		{
			//������ҵ
			return corpDao.modifyForeignCorp(corp);
		}else
		{
			//��������ҵ
			return corpDao.modifyCorp(corp);
		}
		
		
	}

	//�޸���ҵ����
	public String modifyCorpType(Corp corp)
	{
		// TODO Auto-generated method stub
		ICorpDao corpDao = new CorpDaoImpl();
		//��������ҵ
		return corpDao.modifyCorpType(corp);
	}
	
	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryArea(cityId);
	}

	//���赥λ��ת�޸�ҳ�棬��ѯһ����ҵ������Ϣ
	@Override
	public Corp queryCorpCode1(String corpCode) {
		// TODO Auto-generated method stub
		ICorpDao corpDao = new CorpDaoImpl();
		return corpDao.queryCorpCode1(corpCode);
	}
	
}
