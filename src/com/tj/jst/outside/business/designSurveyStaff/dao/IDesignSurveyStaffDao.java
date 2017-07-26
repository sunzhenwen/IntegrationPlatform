package com.tj.jst.outside.business.designSurveyStaff.dao;

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
public interface IDesignSurveyStaffDao {
	
	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	public void add(DesignSurveyStaff quality);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public DesignSurveyStaff queryById(String qualityId);
	
	/**
	 * ��ȫ�ල�����޸�
	 * @return
	 */
	public void modify(DesignSurveyStaff quality);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String qualityId);
	
	//ע�����ͼ��ȼ�
	public List<DictionaryClass> querySpecialtyTypNums();
	//�е���ɫ
	public List<DictionaryClass> queryPrjDutys();
}
