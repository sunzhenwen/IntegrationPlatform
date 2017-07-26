package com.tj.jst.inner.business.safetyapply.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.safety.model.Safety;

/**
 * 安全勘察数据库接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface ISafetyApplyDao {

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
	public Safety queryApproval(String safetyId);

	/**
	 * 审批通过
	 * 
	 * @param project
	 * @return
	 */
	public String applySuccess(Safety safe);

	/**
	 * 审批退回
	 * 
	 * @param project
	 * @return
	 */
	public String applyFaile(Safety safe);

	/**
	 * 检查安全勘察阶段是否完成
	 * 
	 * @param prjNum
	 * @return
	 */
	public String queryQuality(String prjNum);

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
	 * 查询类型名称
	 * 
	 * @param typeNum
	 * @return
	 */
	public String queryTypeName(String typeNum);
	
	/**
	 * 通过更改授权表状态
	 * 
	 * @param prjId
	 * @return
	 */
	public String changeAuthor(String prjId);
}
