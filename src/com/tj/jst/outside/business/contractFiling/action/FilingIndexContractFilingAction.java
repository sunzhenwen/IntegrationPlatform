package com.tj.jst.outside.business.contractFiling.action;

import com.tj.jst.base.action.BaseAction;

/**
 * 跳转 勘察合同备案、设计合同备案、监理合同备案 页面
 * @author hhc
 *
 */
public class FilingIndexContractFilingAction extends BaseAction {
	
	/**
	 * 跳转 勘察合同备案、设计合同备案、监理合同备案 页面
	 * @return
	 */
	public String filingIndex()
	{
		return "filingIndex";
	}
	
	/**
	 * 跳转 施工合同备案 页面
	 * @return
	 */
	public String constructionFiling()
	{
		return "constructionFiling";
	}
}
