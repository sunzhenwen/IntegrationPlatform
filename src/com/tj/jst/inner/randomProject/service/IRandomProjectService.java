package com.tj.jst.inner.randomProject.service;

import java.util.List;

import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.randomProject.model.RandomProject;

/**
 * 随机项目
 * 
 * @author Administrator
 *
 */
public interface IRandomProjectService {

	/**
	 * 查询城市列表
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryCitys();

	/**
	 * 查询区县
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryArea(String cityCode);
	
	/**
	 * 根据地市查询项目
	 * 
	 * @return
	 */
	public List<RandomProject> queryProject(String code);
}
