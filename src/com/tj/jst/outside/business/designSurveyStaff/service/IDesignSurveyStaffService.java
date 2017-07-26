package com.tj.jst.outside.business.designSurveyStaff.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.designSurveyStaff.model.DesignSurveyStaff;

/**
 * ���������ͼ��Ա
 * @author hhc
 *
 */
public interface IDesignSurveyStaffService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ʩ����ȫ��ҵ��Ա���
	 * @return
	 */
	public void add(DesignSurveyStaff quality);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public DesignSurveyStaff queryById(String qualityId);
	
	/**
	 * ʩ����ȫ��ҵ��Ա�޸�
	 * @return
	 */
	public void modify(DesignSurveyStaff quality);
	
	/**
	 * ʩ����ȫ��ҵ��Աɾ��
	 * @return
	 */
	public void delete(String qualityId);
	
	//֤������
	public List<DictionaryClass> queryCardTypeNums();
	
	//ע�����ͼ��ȼ�
	public List<DictionaryClass> querySpecialtyTypNums();
	//�е���ɫ
	public List<DictionaryClass> queryPrjDutys();
}
