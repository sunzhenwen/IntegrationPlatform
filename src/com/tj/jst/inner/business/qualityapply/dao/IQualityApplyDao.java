package com.tj.jst.inner.business.qualityapply.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.quality.model.Quality;

/**
 * 质量勘察数据库接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IQualityApplyDao {

	/**
	 * 查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);

	/**
	 * 跳转审批页面
	 * 
	 * @param prjId
	 * @return
	 */
	public Quality queryApproval(String qualityId);

	/**
	 * 审批通过
	 * 
	 * @param project
	 * @return
	 */
	public String applySuccess(Quality qu);

	/**
	 * 审批退回
	 * 
	 * @param project
	 * @return
	 */
	public String applyFaile(Quality qu);

	/**
	 * 检查安全勘察阶段是否完成
	 * 
	 * @param prjNum
	 * @return
	 */
	public String querySafety(String prjNum);

	/**
	 * 勘察和设计都成功完成后，更改项目基本信息
	 */
	public void updateProjectInfo(String prjNum);

	/**
	 * 查看是否有上传的文件
	 * 
	 * @param prjId
	 * @return
	 */
	public List downloadInfo(String prjId);
	
	/**
	 * 通过更改授权表状态
	 * 
	 * @param prjId
	 * @return
	 */
	public String changeAuthor(String prjId);
}
