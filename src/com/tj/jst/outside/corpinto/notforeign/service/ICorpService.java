package com.tj.jst.outside.corpinto.notforeign.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;


public interface ICorpService {
	
	//��ҵ��֯���������ѯ
	public Corp queryCorpCode(String corpCode);

	//��ҵ��֯���������ѯ
	public Corp queryCorpTypeCode(String corpCode);
	
	//��ѯʡ
	public List<DictionaryClass> queryProvince();
	
	//��ѯ��
	public List<DictionaryClass> queryCity(String provinceId);
	
	//��ѯ��
	public List<DictionaryClass> queryArea(String cityId);
	
	//������ҵ
	public String addCorp(Corp corp);
	
	//�޸���ҵ
	public String modifyCorp(Corp corp);
	
	//�޸���ҵ����
	public String modifyCorpType(Corp corp);

	//���赥λ��ת���޸�ҳ�棬��ѯһ����ҵ������Ϣ
	public Corp queryCorpCode1(String corpCode);
}
