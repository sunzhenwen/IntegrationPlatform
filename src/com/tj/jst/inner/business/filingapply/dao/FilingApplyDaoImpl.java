package com.tj.jst.inner.business.filingapply.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.UtilDecode;
import com.tj.jst.inner.business.filingapply.model.ContractBusiness;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 合同备案数据库类
 * 
 * @author DarkFlameMaster
 *
 */
public class FilingApplyDaoImpl extends BaseDao implements IFilingApplyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Connection qconn = null;
	PreparedStatement qpstmt = null;
	ResultSet qrs = null;

	/**
	 * 分页了
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					ContractFiling filing = new ContractFiling();
					filing.setRecordId(rs.getString("recordId"));// 主键
					filing.setRecordNum(rs.getString("recordNum"));// 合同备案编号
					filing.setPrjNum(rs.getString("prjNum"));// 项目编号
					filing.setPrjName(rs.getString("prjName"));// 项目名称
					filing.setContractNum(rs.getString("contractNum"));// 合同编号
					filing.setContractTypeNum(rs.getString("contractTypeNum"));// 合同类别(TBCONTRACTTYPEDIC)
					filing.setContractTypeName(rs.getString("contractTypeName"));// 合同类别名称
					filing.setContractMoney(rs.getString("contractMoney"));// 合同金额(万元)
					filing.setPrjSize(rs.getString("prjSize"));// 建设规模
					filing.setContractDate(rs.getDate("contractDate"));// 合同签订日期
					filing.setPropietorCorpName(rs
							.getString("propietorCorpName"));// 发包单位名称
					filing.setPropietorCorpCode(rs
							.getString("propietorCorpCode"));// 发包单位住组织代码
					filing.setContractorCorpName(rs
							.getString("contractorCorpName"));// 承包单位名称
					filing.setContractorCorpCode(rs
							.getString("contractorCorpCode"));// 承包单位组织代码
					filing.setUnionCorpName(rs.getString("unionCorpName"));// 联合体承包单位名称
					filing.setUnionCorpCode(rs.getString("unionCorpCode"));// 联合体承包单位组织代码
					filing.setCreateDate(rs.getDate("createDate"));// 记录登记时间
					filing.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
					filing.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
					filing.setAppSteffId(rs.getString("appSteffId"));// 审批人id
					filing.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
					filing.setAppDate(rs.getDate("appDate"));// 审批时间
					filing.setAppOpinion(rs.getString("appOpinion"));// 审批意见
					/**
					 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					filing.setAppType(rs.getString("appType").trim());// 审批状态
					/**
					 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
					 * 6:竣工验收
					 */
					filing.setProcessSteps(rs.getString("processSteps").trim());
					filing.setAppDept(rs.getString("appDept").trim());// 审批单位id
					filing.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
					page.getData().add(filing);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * 跳转审批页面
	 */
	@Override
	public ContractFiling queryApproval(String recordId) {
		// TODO Auto-generated method stub
		ContractFiling filing = new ContractFiling();
		String sql = "select * from v_tbcontractrecordmanage where recordId = '"
				+ recordId + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				filing.setRecordId(rs.getString("recordId"));// 主键
				filing.setRecordNum(rs.getString("recordNum"));// 合同备案编号
				filing.setPrjNum(rs.getString("prjNum"));// 项目编号
				filing.setPrjName(rs.getString("prjName"));// 项目名称
				filing.setContractNum(rs.getString("contractNum"));// 合同编号
				filing.setContractTypeNum(rs.getString("contractTypeNum"));// 合同类别(TBCONTRACTTYPEDIC)
				filing.setContractTypeName(rs.getString("contractTypeName"));// 合同类别名称
				filing.setContractMoney(rs.getString("contractMoney"));// 合同金额(万元)
				filing.setPrjSize(rs.getString("prjSize"));// 建设规模
				filing.setContractDate(rs.getDate("contractDate"));// 合同签订日期
				filing.setPropietorCorpName(rs.getString("propietorCorpName"));// 发包单位名称
				filing.setPropietorCorpCode(rs.getString("propietorCorpCode"));// 发包单位住组织代码
				filing.setContractorCorpName(rs.getString("contractorCorpName"));// 承包单位名称
				filing.setContractorCorpCode(rs.getString("contractorCorpCode"));// 承包单位组织代码
				filing.setUnionCorpName(rs.getString("unionCorpName"));// 联合体承包单位名称
				filing.setUnionCorpCode(rs.getString("unionCorpCode"));// 联合体承包单位组织代码
				filing.setCreateDate(rs.getDate("createDate"));// 记录登记时间
				filing.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				filing.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				filing.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				filing.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				filing.setAppDate(rs.getDate("appDate"));// 审批时间
				filing.setAppOpinion(rs.getString("appOpinion"));// 审批意见
				/**
				 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				filing.setAppType(rs.getString("appType").trim());// 审批状态
				/**
				 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
				 * 6:竣工验收
				 */
				filing.setProcessSteps(rs.getString("processSteps").trim());
				filing.setAppDept(rs.getString("appDept").trim());// 审批单位id
				filing.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
				filing.setSectionName(rs.getString("sectionName"));
				filing.setTenderNum(rs.getString("tenderNum"));
				filing.setProjectAddress(rs.getString("projectAddress"));
				filing.setProjectCost(rs.getString("projectCost"));
				filing.setArea(rs.getString("area"));
				filing.setConstructorName(rs.getString("constructorName"));// 项目经理姓名
				filing.setTitleLeve(rs.getString("titleLeve"));// 资质等级
				filing.setPhone(rs.getString("phone"));// 联系电话
				filing.setQualificationsType(rs.getString("qualificationsType"));
				filing.setQualificationsTypeName(rs
						.getString("qualificationsTypeName"));
				filing.setSpecialtyType(rs.getString("specialtyType"));
				filing.setSpecialtyTypeName(rs.getString("specialtyTypeName"));
				filing.setRating(rs.getString("rating"));
				filing.setRatingName(rs.getString("ratingName"));
				// -------------------------------人员-----------------------------------
				filing.setTechnicalName(rs.getString("technicalName"));// 技术负责人姓名
				filing.setTechnicalIdCardTypeNum(rs
						.getString("technicalIdCardTypeNum"));// 技术负责人证件类型
				filing.setTechnicalIdCard(rs.getString("technicalIdCard"));// 技术负责人证件号码
				filing.setTechnicalCertNum(rs.getString("technicalCertNum"));// 技术负责人证书号
				filing.setQualityName(rs.getString("qualityName"));// 质量检查员姓名
				filing.setQualityIdCardTypeNum(rs
						.getString("qualityIdCardTypeNum"));// 质量检查员证件类型
				filing.setQualityIdCard(rs.getString("qualityIdCard"));// 质量检查员证件号码
				filing.setQualityCertNum(rs.getString("qualityCertNum"));// 质量检查员证书号
				filing.setSecurityName(rs.getString("securityName"));// 安全员姓名
				filing.setSecurityIdCardTypeNum(rs
						.getString("securityIdCardTypeNum"));// 安全员证件类型
				filing.setSecurityIdCard(rs.getString("securityIdCard"));// 安全员证件号码
				filing.setSecurityCertNum(rs.getString("securityCertNum"));// 安全员证书号
				filing.setConstructionName(rs.getString("constructionName"));// 施工员（工长）姓名
				filing.setConstructionIdCardTypeNum(rs
						.getString("constructionIdCardTypeNum"));// 施工员（工长）证件类型
				filing.setConstructionIdCard(rs.getString("constructionIdCard"));// 施工员（工长）证件号码
				filing.setConstructionCertNum(rs
						.getString("constructionCertNum"));// 施工员（工长）证书号
				filing.setDirectorName(rs.getString("directorName"));// （监理人员）总监姓名
				filing.setDirectorIdCardTypeNum(rs
						.getString("directorIdCardTypeNum"));// （监理人员）总监证件类型
				filing.setDirectorIdCard(rs.getString("directorIdCard"));// （监理人员）总监证件号码
				filing.setDirectorCertNum(rs.getString("directorCertNum"));// （监理人员）总监证书号
				filing.setRepresEntativeName(rs.getString("represEntativeName"));// 总监代表姓名
				filing.setRepresEntativeIdCardTypeNum(rs
						.getString("represEntativeIdCardTypeNum"));// 总监代表证件类型
				filing.setRepresEntativeIdCard(rs
						.getString("represEntativeIdCard"));// 总监代表证件号码
				filing.setRepresEntativeCertNum(rs
						.getString("represEntativeCertNum"));// 总监代表证书号
				filing.setSafetyName(rs.getString("safetyName"));// 安全监理姓名
				filing.setSafetyIdCardTypeNum(rs
						.getString("safetyIdCardTypeNum"));// 安全监理证件类型
				filing.setSafetyIdCard(rs.getString("safetyIdCard"));// 安全监理证件号码
				filing.setMainRecordNum(rs.getString("mainRecordNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return filing;
	}

	/**
	 * 审批通过
	 */
	@Override
	public String approvalSuccess(ContractFiling filing) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			// String type = filing.getContractTypeNum();
			// switch (type) {
			// case "100":
			// type = "-HB-";
			// break;
			// case "200":
			// type = "-HA-";
			// break;
			// case "301":
			// type = "-HZ-";
			// break;
			// case "302":
			// type = "-HF-";
			// break;
			// case "303":
			// type = "-HL-";
			// break;
			// case "400":
			// type = "-HE-";
			// break;
			// case "500":
			// type = "-HC-";
			// break;
			// case "600":
			// type = "-HG-";
			// break;
			// case "700":
			// type = "-HM-";
			// break;
			//
			// }
			// Calendar c = Calendar.getInstance();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyMMdd");
			// String fDate = simpleDateFormat.format(c.getTime());
			// String serNum = PrjCode.querySerNuma(filing.getCreateDate(), 3);
			// String filingNum = filing.getAppDept() + fDate
			// + filing.getPrjNum().substring(12, 16) + type + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE tbcontractrecordmanage set APPTYPE = 1 , PROCESSSTEPS = 4 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ?  where RECORDID = ?");
			pstmt.setString(1, filing.getAppSteffId());
			pstmt.setString(2, filing.getAppSteffName());
			pstmt.setDate(3, filing.getAppDate());
			pstmt.setString(4, filing.getAppOpinion());
			pstmt.setString(5, filing.getRecordId());
			pstmt.executeUpdate();
			conn.commit();
			message = "成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String approvalFailed(ContractFiling filing) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE tbcontractrecordmanage set APPTYPE = 2 , PROCESSSTEPS = 3 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ? where RECORDID = ?");
			pstmt.setString(1, filing.getAppSteffId());
			pstmt.setString(2, filing.getAppSteffName());
			pstmt.setDate(3, filing.getAppDate());
			pstmt.setString(4, filing.getAppOpinion());
			pstmt.setString(5, filing.getRecordId());
			pstmt.executeUpdate();
			conn.commit();
			message = "成功";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 查询施工图是否完成
	 */
	@Override
	public String queryPlans(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TBPROJECTCENSORINFO where PRJNUM='"
				+ prjNum + "' and PROCESSSTEPS = 4 and APPTYPE = 1";
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = "成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * 均完成则修改基本信息
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "update  TBProjectInfo_S set PROCESSSTEPS=4 where PRJNUM='"
				+ prjNum + "' ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String message = "成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
	}

	/**
	 * 查看是否有上传的信息
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		String sql = "select * from UPLOAD_FILE where LINKNAME like '%合同备案%' and ID = '"
				+ prjId + "'";
		List<Upload> list = new ArrayList<Upload>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setFileFileName(rs.getString("fileFileName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setNewName(rs.getString("newName"));
				upload.setRoot(rs.getString("root"));
				upload.setId(rs.getString("id"));
				list.add(upload);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 通过更改授权状态
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TO_AUTHORIZATION set PROCESSSTEPS=4 where prjNum='"
				+ prjId + "' ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = "成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * 查询合同信息
	 */
	@Override
	public ContractBusiness queryByConId(String conId) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_CONTRACTINFO_BUSINESS where conId = '"
				+ conId + "'";
		String sql2 = "select * from TB_CONTRACTINFO_RECORD where conId=?";
		ContractBusiness contract = new ContractBusiness();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				contract.setConId(rs.getString("conId"));
				contract.setLinkAddress(rs.getString("linkAddress"));
				contract.setConName(rs.getString("conName"));
				contract.setZhConName(UtilDecode.transformation(rs.getString("conName")));
				contract.setConType(rs.getString("conType"));
				contract.setCreateDate(rs.getDate("createDate"));
				contract.setIsLocking(rs.getString("isLocking"));
				contract.setRecordId(rs.getString("recordId"));
				try {
					qconn = ConnectionFactory.getBasicConnection();
					qpstmt = qconn.prepareStatement(sql2);
					qpstmt.setString(1, rs.getString("conId"));
					qrs = qpstmt.executeQuery();
					if (qrs.next()) {
						contract.setADate(qrs.getString("aDate"));
						contract.setReason(qrs.getString("reason"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
			ConnectionFactory.closeConn(qconn, qpstmt, qrs);
		}
		return contract;
	}

	/**
	 * 修改合同信息
	 */
	@Override
	public String modifyContractBusiness(ContractBusiness contract) {
		// TODO Auto-generated method stub
		int check = 0;
		String message = "";
		String sql = "update TB_CONTRACTINFO_BUSINESS set isLocking=?,CHECKTYPE=1 where conId=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contract.getIsLocking());
			pstmt.setString(2, contract.getConId());
			check = pstmt.executeUpdate();
			if (check == 1) {
				message = "成功";
			} else {
				message = "失败";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * 增加审核记录
	 */
	@Override
	public String insertContractBusiness(ContractBusiness contract) {
		// TODO Auto-generated method stub
		String message = "";
		int check = 0;
		String recordId = UUID.randomUUID().toString();
		String sql = "insert into TB_CONTRACTINFO_RECORD(RECORDID,REASON,CREATEDATE,CONID,ADATE) values (?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getBasicConnection();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			System.out.println(sdf.format(new java.util.Date()));
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recordId);
			pstmt.setString(2, contract.getReason());
			pstmt.setDate(3, new Date(new java.util.Date().getTime()));
			pstmt.setString(4, contract.getConId());
			pstmt.setString(5, sdf.format(new java.util.Date()));
			check = pstmt.executeUpdate();
			if (check == 1) {
				message = "成功";
			} else {
				message = "失败";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * 合同分页
	 */
	@Override
	public Page queryBusinessPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					ContractBusiness contract = new ContractBusiness();
					contract.setConId(rs.getString("conId"));
					contract.setConName(rs.getString("conName"));
					contract.setZhConName(UtilDecode.transformation(rs.getString("conName")));
					contract.setConType(rs.getString("conType"));
					contract.setCreateDate(rs.getDate("createDate"));
					contract.setIsLocking(rs.getString("isLocking"));
					contract.setCheckType(rs.getString("checkType"));
					contract.setRecordId(rs.getString("recordId"));
					page.getData().add(contract);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * 审核不通过更改状态
	 * 
	 * @param recordId
	 * @return
	 */
	@Override
	public String changeBusinessType(String recordId, String type) {
		// TODO Auto-generated method stub
		String sql = "update TB_CONTRACTINFO_BUSINESS set checkType=? where recordId=?";
		String message = "";
		int check = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setString(2, recordId);
			check = pstmt.executeUpdate();
			if (check == 1) {
				message = "成功";
			} else {
				message = "失败";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

}
