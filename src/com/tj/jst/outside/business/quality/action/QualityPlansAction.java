package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.quality.condition.QualityPlansCondition;
import com.tj.jst.outside.business.quality.service.IQualityService;
import com.tj.jst.outside.business.quality.service.QualityServiceImpl;

/**
 * ����,ʩ��ͼ����Ϣ��ѯ
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
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IQualityService service = new QualityServiceImpl();
		//��ҳ��ѯ
		currentPage = service.pagedQualityPlans(this.getCondition());
		this.set(getActionName(), condition);
		return "qualityPlans";
	}

}
