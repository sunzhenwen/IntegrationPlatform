package com.tj.jst.outside.business.safety.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;

/**
 * ��ȫ�ල
 * @author hhc
 *
 */
public interface ISafetyDao {
	
	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ��ȫ�ල����
	 * @return
	 */
	public String add(Safety quality,List<ConstructionSafety> constructionSafety,List<Major> majors,List<Labour> labours);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Safety queryById(String qualityId);
	
	/**
	 * ��ȫ�ල�����޸�
	 * @return
	 */
	public void modify(Safety quality,List<ConstructionSafety> constructionSafety,List<Major> majors,List<Labour> labours);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String qualityId);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	/**
	 * ������������id��ѯ�������
	 * @param appDept
	 * @return
	 */
	public String queryAppDeptId(String appDept);
	
	//��������
	public List<DictionaryClass> queryProjectTypes();
}
