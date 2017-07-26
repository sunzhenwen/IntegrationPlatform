package com.tj.jst.inner.projectconstruction.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

public interface IProjectConstructionDao {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * 历史审批查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page historyPagedQuery(Condition condition);

	/**
	 * 跳转审批页面
	 * 
	 * @param prjId
	 * @return
	 */
	public ProjectConstruction queryApproval(String prjId);

	/**
	 * 审批通过
	 * 
	 * @param project
	 * @return
	 */
	public String applySuccess(ProjectConstruction project);

	/**
	 * 审批退回
	 * 
	 * @param project
	 * @return
	 */
	public String applyFaile(ProjectConstruction project);

	/**
	 * 批量审批
	 * 
	 * @return
	 */
	public List<ProjectConstruction> batchApplythrough(String[] ids);

	/**
	 * 根据项目编号查找项目
	 * 
	 * @param prjNum
	 * @return
	 */
	public ProjectConstruction getProjectInfo(String prjNum);

	// /**
	// * 审批分项
	// *
	// * @param condition
	// * @return
	// */
	// public Page projectPage(Condition condition);

	/**
	 * 查看是否有上传的文件
	 * 
	 * @param prjId
	 * @return
	 */
	public List downloadInfo(String prjId);

	/**
	 * 更新到授权库
	 * 
	 * @param project
	 * @return
	 */
	public String updateAuthor(ProjectConstruction project);

}
