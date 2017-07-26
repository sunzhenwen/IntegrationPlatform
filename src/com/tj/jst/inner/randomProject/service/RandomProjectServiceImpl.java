package com.tj.jst.inner.randomProject.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomProject.dao.IRandomProjectDao;
import com.tj.jst.inner.randomProject.dao.RandomProjectDaoImpl;
import com.tj.jst.inner.randomProject.model.RandomProject;

/**
 * �����Ŀ
 * 
 * @author Administrator
 *
 */
public class RandomProjectServiceImpl implements IRandomProjectService {

	/**
	 * ��ѯ�����б�
	 * 
	 * @return
	 */
	@Override
	public List<DictionaryClass> queryCitys() {
		// TODO Auto-generated method stub
		IRandomProjectDao dao = new RandomProjectDaoImpl();
		return dao.queryCitys();
	}

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityCode)
	{
		// TODO Auto-generated method stub
		IRandomProjectDao dao = new RandomProjectDaoImpl();
		return dao.queryArea(cityCode.substring(0, 4),cityCode);
	}
	
	/**
	 * ���ݵ��в�ѯ��Ŀ
	 * 
	 * @return
	 */
	public List<RandomProject> queryProject(String code)
	{
		IRandomProjectDao dao = new RandomProjectDaoImpl();
		return dao.queryProject(code);
	}
}
