package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.quality.condition.QualityPlansCondition;
import com.tj.jst.outside.business.quality.service.IQualityService;
import com.tj.jst.outside.business.quality.service.QualityServiceImpl;

/**
 * 质量,施工图审信息查询
 * @author Administrator
 *
 */
public class QualityPlansAction extends BaseAction {


	private QualityPlansCondition condition = new QualityPlansCondition();
	
	public void setCondition(QualityPlansCondition condition) {
		this.condition = condition;
	}

	public QualityPlansCondition getCondition() {
		QualityPlansCondition sessionCondition = (QualityPlansCondition) get(getActionName());
		if (sessionCondition != null)
		{
			condition = sessionCondition;
		}
		return condition;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String queryPage()
	{
		IQualityService service = new QualityServiceImpl();
		//分页查询
		currentPage = service.pagedQualityPlans(this.getCondition());
		this.set(getActionName(), condition);
		return "qualityPlans";
	}

}
