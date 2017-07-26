package com.tj.jst.outside.business.queryQualification.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.queryQualification.model.Qualification;
import com.tj.jst.outside.business.queryprojection.model.Filing;
import com.tj.jst.outside.business.queryprojection.model.Permit;
import com.tj.jst.outside.business.queryprojection.model.Plan;
import com.tj.jst.outside.business.queryprojection.model.ProjectModel;
import com.tj.jst.outside.business.queryprojection.model.Ready;
import com.tj.jst.outside.business.queryprojection.model.Tender;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;

/**
 * 业务查询
 * 
 * @author Administrator
 *
 */
public interface IQueryQualificationService {

	/**
	 * 查询分页
	 * 
	 * @param corpCode
	 * @return
	 */
	public List<Qualification> queryPage(String corpCode);
}

