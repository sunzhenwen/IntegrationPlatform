package com.tj.jst.inner.randomProject.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomProject.dao.IRandomProjectDao;
import com.tj.jst.inner.randomProject.dao.RandomProjectDaoImpl;
import com.tj.jst.inner.randomProject.model.RandomProject;

/**
 * 随机项目
 * 
 * @author Administrator
 *
 */
public class RandomProjectServiceImpl implements IRandomProjectService {

	/**
	 * 查询城市列表
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
	 * 查询区县
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
	 * 根据地市查询项目
	 * 
	 * @return
	 */
	public List<RandomProject> queryProject(String code)
	{
		IRandomProjectDao dao = new RandomProjectDaoImpl();
		return dao.queryProject(code);
	}
}
