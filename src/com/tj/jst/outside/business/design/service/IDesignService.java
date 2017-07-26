package com.tj.jst.outside.business.design.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.design.model.Design;
import com.tj.jst.outside.business.design.model.DesignQualification;

/**
 * ���
 * @author hhc
 *
 */
public interface IDesignService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * �������
	 * @return
	 */
	public String add(Design design,List<DesignQualification> designQualifications);
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept();
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Design queryById(String designId);
	
	/**
	 * ��������޸�
	 * @return
	 */
	public void modify(Design design,List<DesignQualification> designQualifications);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String designId);

	
}
