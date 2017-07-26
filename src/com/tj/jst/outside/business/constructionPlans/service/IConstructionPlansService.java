package com.tj.jst.outside.business.constructionPlans.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;

/**
 * ʩ��ͼ���
 * @author hhc
 *
 */
public interface IConstructionPlansService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ʩ��ͼ�������
	 * @return
	 */
	public String add(ConstructionPlans constructionPlans);
	
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
	public ConstructionPlans queryById(String censorId);
	
	/**
	 * ��ͬ���������޸�
	 * @return
	 */
	public void modify(ConstructionPlans constructionPlans);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String censorId);
}
