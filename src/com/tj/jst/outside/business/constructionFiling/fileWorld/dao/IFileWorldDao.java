package com.tj.jst.outside.business.constructionFiling.fileWorld.dao;

import java.util.List;

import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;


/**
 * 施工合同word模板
 * @author hhc
 *
 */
public interface IFileWorldDao {

	/**
	 * 查询列表(业务表)
	 * @param recordId
	 * @return
	 */
	public List<FileWorld> queryFileWorldBusiness(String recordId,String conType);
	
	/**
	 * 查询模板表
	 * @return
	 */
	public List<FileWorld> queryFileWorld(String recordId,String conType);
	
	//未提交,查询模板表
	public FileWorld queryFileWorldById(String conId);
	
	//已提交,查询业务表
	public FileWorld queryFileWorldBusinessById(String conId);
	
	/**
	 * 如果未提交，在业务表中插入数据
	 * @param fileWorld
	 */
	public String save(FileWorld fileWorld);

//	/**
//	 * 如果已提交修改业务表中的数据
//	 * @param fileWorld
//	 */
//	public String update(FileWorld fileWorld);
	
	/**
	 * 删除业务表数据还原模板
	 * @return
	 */
	public void delete(String conId);
	
	/**
	 * 查看
	 * @return
	 */
	public FileWorld viewDetails(String conId);
}
