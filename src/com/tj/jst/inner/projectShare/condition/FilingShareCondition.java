package com.tj.jst.inner.projectShare.condition;

import com.tj.jst.base.page.Condition;

/**
 * 合同备案共享查询
 * @author DarkFlameMaster
 *
 */
public class FilingShareCondition extends Condition {

	private String appDept;// 查询条件
	private String prjName;// 项目名称
	private String prjNum;// 项目编号
	private String contractNum;// 合同编号
	private String contractTypeName;// 类型名称
	private String appType;//状态
	//审批市编码
	private String approvalCityId;
	//审批区域编码
	private String approvalAreaId;

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

		if (approvalAreaId != null && !"".equals(approvalAreaId)) {
			sb.append(" and APPDEPT = '" + approvalAreaId + "'");
		}else
		{
			if (approvalCityId != null && !"".equals(approvalCityId)) {
				sb.append(" and APPDEPT = '" + approvalCityId + "'");
			}
		}
		
		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and PRJNAME like '%" + prjName.trim() + "%'");
		}
		if (contractNum != null && !"".equals(contractNum)) {
			sb.append(" and contractNum ='" + contractNum.trim() + "'");
		}
		if (contractTypeName != null && !"".equals(contractTypeName)) {
			sb.append(" and contractTypeName ='" + contractTypeName.trim()
					+ "'");
		}

		String sql = "select * from v_zgbm_tbcontractrecordmanage " + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub
		// 设置排序
		this.setOrderByItem(" CREATEDATE desc ");
		// 查询当前可用单位；
		StringBuffer sb = new StringBuffer(" where apptype=1 ");

		if (approvalAreaId != null && !"".equals(approvalAreaId)) {
			sb.append(" and APPDEPT = '" + approvalAreaId + "'");
		}else
		{
			if (approvalCityId != null && !"".equals(approvalCityId)) {
				sb.append(" and APPDEPT = '" + approvalCityId + "'");
			}
		}
		
		if (prjNum != null && !"".equals(prjNum)) {
			sb.append(" and prjNum like '%" + prjNum.trim() + "%'");
		}
		if (prjName != null && !"".equals(prjName)) {
			sb.append(" and PRJNAME like '%" + prjName.trim() + "%'");
		}
		if (contractNum != null && !"".equals(contractNum)) {
			sb.append(" and contractNum ='" + contractNum.trim() + "'");
		}
		if (contractTypeName != null && !"".equals(contractTypeName)) {
			sb.append(" and contractTypeName ='" + contractTypeName.trim()
					+ "'");
		}
		
		String sqlCount = "select count(*) from v_zgbm_tbcontractrecordmanage "
				+ sb.toString();
		return sqlCount;
	}

	public String getPrjName() {
		return prjName;
	}

	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}

	public String getPrjNum() {
		return prjNum;
	}

	public void setPrjNum(String prjNum) {
		this.prjNum = prjNum;
	}

	public String getAppDept() {
		return appDept;
	}

	public void setAppDept(String appDept) {
		this.appDept = appDept;
	}

	public String getContractNum() {
		return contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}

	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getApprovalCityId() {
		return approvalCityId;
	}

	public void setApprovalCityId(String approvalCityId) {
		this.approvalCityId = approvalCityId;
	}

	public String getApprovalAreaId() {
		return approvalAreaId;
	}

	public void setApprovalAreaId(String approvalAreaId) {
		this.approvalAreaId = approvalAreaId;
	}
}
