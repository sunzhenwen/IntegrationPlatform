package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.quality.condition.QualityTenderInfoCondition;
import com.tj.jst.outside.business.quality.service.IQualityService;
import com.tj.jst.outside.business.quality.service.QualityServiceImpl;

/**
 * 质量监督注册,招投标信息查询
 * @author Administrator
 *
 */
public class QualityTenderInfoAction extends BaseAction {
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IQualityService service = new QualityServiceImpl();

		//分页查询
		currentPage = service.pagedTbInfoQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "queryTenderInfo";
	}

	private QualityTenderInfoCondition condition = new QualityTenderInfoCondition();
	
	public void setCondition(QualityTenderInfoCondition condition) {
		this.condition = condition;
	}

	public QualityTenderInfoCondition getCondition() {
		QualityTenderInfoCondition sessionCondition = (QualityTenderInfoCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
}
