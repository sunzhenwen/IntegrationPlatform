package com.tj.jst.outside.business.constructionFiling.fileWorld.service;

import java.util.List;

import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;


/**
 * 施工合同word模板
 * @author hhc
 *
 */
public interface IFileWorldService {
	
	/**
	 * 查询列表
	 * @param recordId
	 * @return
	 */
	public List<FileWorld> queryFileWorld(String recordId,String conType);
	
	/**
	 * 查询详细
	 * @param conId
	 * @param checkType
	 * @return
	 */
	public FileWorld queryConMessage(String conId,String checkType,String recordId);
	
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
