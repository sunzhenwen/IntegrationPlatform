package com.tj.jst.outside.business.quality.action;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.outside.business.quality.condition.QualityTenderInfoCondition;
import com.tj.jst.outside.business.quality.service.IQualityService;
import com.tj.jst.outside.business.quality.service.QualityServiceImpl;

/**
 * �����ලע��,��Ͷ����Ϣ��ѯ
 * @author Administrator
 *
 */
public class QualityTenderInfoAction extends BaseAction {
	
	/**
	 * ��ѯ
	 * @return
	 */
	public String queryPage()
	{
		IQualityService service = new QualityServiceImpl();

		//��ҳ��ѯ
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
