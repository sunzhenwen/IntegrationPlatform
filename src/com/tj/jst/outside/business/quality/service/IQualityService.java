package com.tj.jst.outside.business.quality.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.quality.model.Quality;

/**
 * �����ල
 * @author hhc
 *
 */
public interface IQualityService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ��ѯʩ��ͼ��
	 * @param condition
	 * @return
	 */
	public Page pagedQualityPlans(Condition condition);
	
	/**
	 * �����ල����
	 * @return
	 */
	public String add(Quality quality);
	
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
	public Quality queryById(String qualityId);
	
	/**
	 * �����ල�����޸�
	 * @return
	 */
	public void modify(Quality quality);
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String qualityId);
	
	/**
	 * ��ѯ��Ͷ����Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition);
}
