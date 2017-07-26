package com.tj.jst.inner.randomProject.dao;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomProject.model.RandomProject;

/**
 * �����Ŀ
 * 
 * @author Administrator
 *
 */
public interface IRandomProjectDao {

	/**
	 * ��ѯ�����б�
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryCitys();

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryArea(String subCityCode,String cityCode);
	
	/**
	 * ���ݵ��в�ѯ��Ŀ
	 * 
	 * @return
	 */
	public List<RandomProject> queryProject(String code);
}
