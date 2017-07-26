package com.tj.jst.inner.business.promiseapply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 施工许可数据库类
 * 
 * @author DarkFlameMaster
 *
 */
public class PromiseApplyDaoImpl extends BaseDao implements IPromiseApplyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Permit permit = new Permit();
					permit.setPrjId(rs.getString("prjId"));
					permit.setPermitId(rs.getString("permitId"));// 主键
					permit.setPrjNum(rs.getString("prjNum"));// 项目编号
					permit.setProjectName(rs.getString("projectName"));// 工程名称
					permit.setPrjName(rs.getString("prjName"));// 项目名称
					permit.setBuilderLicenceNum(rs
							.getString("builderLicenceNum"));// 施工许可证编号
					permit.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
					permit.setProjectPlanNum(rs.getString("projectPlanNum"));// 建设工程规划许可证编号
					permit.setCensorNum(rs.getString("censorNum"));// 施工图审查合格书便好
					permit.setContractMoney(rs.getString("contractMoney"));// 合同金额(万元)
					permit.setArea(rs.getString("area"));// 面积(平方米)
					permit.setPrjSize(rs.getString("prjSize"));// 建设规模
					permit.setIssueCertDate(rs.getDate("issueCertDate"));// 发证日期
					permit.setEconCorpName(rs.getString("econCorpName"));// 勘察单位名称
					permit.setEconCorpCode(rs.getString("econCorpCode"));// 勘察单位组织机构代码
					permit.setDesignCorpName(rs.getString("designCorpName"));// 设计单位名称
					permit.setDesignCorpCode(rs.getString("designCorpCode"));// 设计单位组织机构代码
					permit.setConsCorpname(rs.getString("consCorpname"));// 施工单位名称
					permit.setConsCorpCode(rs.getString("consCorpCode"));// 施工单位组织机构代码
					permit.setSafetyCerId(rs.getString("safetyCerId"));// 施工单位安全生产许可证编号
					permit.setSuperCorpName(rs.getString("superCorpName"));// 监理单位名称
					permit.setSuperCorpCode(rs.getString("superCorpCode"));// 监理单位组织机构代码
					permit.setConstructorName(rs.getString("constructorName"));// 项目经理姓名
					permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));// 项目经理证件类型(TBIDCARDTYPEDIC)
					permit.setConstructorIdCard(rs
							.getString("constructorIdCard"));// 项目经理证件号码
					permit.setSupervisionName(rs.getString("supervisionName"));// 总监理工程师姓名
					permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));// 总监理工程师证件类型(TBIDCARDTYPEDIC)
					permit.setSupervisionIdCard(rs
							.getString("supervisionIdCard"));// 总监理工程师号码
					permit.setUserName(rs.getString("userName"));// 安全生产管理人员姓名
					permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));// 安全生产管理证件类型(TBIDCARDTYPEDIC)
					permit.setIdCard(rs.getString("idCard"));// 安全生产管理人员证件号
					permit.setCertId(rs.getString("certId"));// 安全生产考核合格证书编号
					permit.setUserType(rs.getString("userType"));// 安全生产管理人员类型(1主要负责人、2项目负责人、3安全员)
					permit.setCreateDate(rs.getDate("createDate"));// 记录登记日期
					permit.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
					permit.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
					permit.setAppSteffId(rs.getString("appSteffId"));// 审批人id
					permit.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
					permit.setAppDate(rs.getDate("appDate"));// 审批时间
					permit.setAppOpinion(rs.getString("appOpinion"));// 审批意见
					/**
					 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					permit.setAppType(rs.getString("appType").trim());// 审批状态
					/**
					 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
					 * 6:竣工验收
					 */
					permit.setProcessSteps(rs.getString("processSteps").trim());
					permit.setAppDept(rs.getString("appDept").trim());// 审批单位id
					permit.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
					page.getData().add(permit);
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
	 * 查询详细
	 */
	@Override
	public Permit queryApproval(String permitId) {
		// TODO Auto-generated method stub
		Permit permit = new Permit();
		try {

			String qsql = "select * from tbbuilderlicencemanage where permitId=?";
			// 获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, permitId);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				permit.setPrjId(rs.getString("prjId"));
				permit.setPermitId(rs.getString("permitId"));// 主键
				permit.setProjectName(rs.getString("projectName"));// 工程名称
				permit.setPrjNum(rs.getString("prjNum"));// 项目编号
				permit.setPrjName(rs.getString("prjName"));// 项目名称
				permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// 施工许可证编号
				permit.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
				permit.setProjectPlanNum(rs.getString("projectPlanNum"));// 建设工程规划许可证编号
				permit.setCensorNum(rs.getString("censorNum"));// 施工图审查合格书便好
				permit.setContractMoney(rs.getString("contractMoney"));// 合同金额(万元)
				permit.setArea(rs.getString("area"));// 面积(平方米)
				permit.setPrjSize(rs.getString("prjSize"));// 建设规模
				permit.setIssueCertDate(rs.getDate("issueCertDate"));// 发证日期
				permit.setEconCorpName(rs.getString("econCorpName"));// 勘察单位名称
				permit.setEconCorpCode(rs.getString("econCorpCode"));// 勘察单位组织机构代码
				permit.setDesignCorpName(rs.getString("designCorpName"));// 设计单位名称
				permit.setDesignCorpCode(rs.getString("designCorpCode"));// 设计单位组织机构代码
				permit.setConsCorpname(rs.getString("consCorpname"));// 施工单位名称
				permit.setConsCorpCode(rs.getString("consCorpCode"));// 施工单位组织机构代码
				permit.setSafetyCerId(rs.getString("safetyCerId"));// 施工单位安全生产许可证编号
				permit.setSuperCorpName(rs.getString("superCorpName"));// 监理单位名称
				permit.setSuperCorpCode(rs.getString("superCorpCode"));// 监理单位组织机构代码
				permit.setConstructorName(rs.getString("constructorName"));// 项目经理姓名
				permit.setCidCardTypeNum(rs.getString("cidCardTypeNum").trim());// 项目经理证件类型(TBIDCARDTYPEDIC)
				permit.setConstructorIdCard(rs.getString("constructorIdCard"));// 项目经理证件号码
				permit.setSupervisionName(rs.getString("supervisionName"));// 总监理工程师姓名
				permit.setSidCardTypeNum(rs.getString("sidCardTypeNum").trim());// 总监理工程师证件类型(TBIDCARDTYPEDIC)
				permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));// 总监理工程师号码
				permit.setUserName(rs.getString("userName"));// 安全生产管理人员姓名
				//permit.setIdCardTypeNum(rs.getString("IDCARDTYPENUM").trim());// 安全生产管理证件类型(TBIDCARDTYPEDIC)
				permit.setIdCard(rs.getString("idCard"));// 安全生产管理人员证件号
				permit.setCertId(rs.getString("certId"));// 安全生产考核合格证书编号
				//permit.setUserType(rs.getString("userType").trim());// 安全生产管理人员类型(1主要负责人、2项目负责人、3安全员)
				permit.setCreateDate(rs.getDate("createDate"));// 记录登记日期
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				permit.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				permit.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				permit.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				permit.setAppDate(rs.getDate("appDate"));// 审批时间
				permit.setAppOpinion(rs.getString("appOpinion"));// 审批意见
				permit.setProjectName(rs.getString("projectName"));
				/**
				 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				permit.setAppType(rs.getString("appType").trim());// 审批状态
				/**
				 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
				 * 6:竣工验收
				 */
				permit.setProcessSteps(rs.getString("processSteps").trim());
				permit.setAppDept(rs.getString("appDept").trim());// 审批单位id
				permit.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
				permit.setStarDate(rs.getDate("starDate"));
				permit.setQualityNum(rs.getString("qualityNum"));
				permit.setSafetyNum(rs.getString("safetyNum"));
				permit.setEndDate(rs.getDate("endDate"));
				permit.setTimeLimit(rs.getString("timeLimit"));;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return permit;
	}

	/**
	 * 审批通过
	 */
	@Override
	public String approvalSuccess(Permit permit) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			// Calendar c = Calendar.getInstance();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyMMdd");
			// String fDate = simpleDateFormat.format(c.getTime());
			// String serNum = PrjCode.querySerNuma(permit.getCreateDate(), 7);
			// String permitNum = permit.getAppDept() + fDate
			// + permit.getPrjNum().substring(12, 16) + "-SX-" + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  tbbuilderlicencemanage set APPTYPE=1,PROCESSSTEPS=6,APPSTEFFID=?,APPSTEFFNAME=?,APPDATE=?,APPOPINION=? where PERMITID=?");
			pstmt.setString(1, permit.getAppSteffId());
			pstmt.setString(2, permit.getAppSteffName());
			pstmt.setDate(3, permit.getAppDate());
			pstmt.setString(4, permit.getAppOpinion());
			pstmt.setString(5, permit.getPermitId());
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
	public String approvalFailed(Permit permit) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  tbbuilderlicencemanage set APPTYPE=2,PROCESSSTEPS=5,APPSTEFFID=?,APPSTEFFNAME=?,APPDATE=?,APPOPINION=? where PERMITID=?");
			pstmt.setString(1, permit.getAppSteffId());
			pstmt.setString(2, permit.getAppSteffName());
			pstmt.setDate(3, permit.getAppDate());
			pstmt.setString(4, permit.getAppOpinion());
			pstmt.setString(5, permit.getPermitId());
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
	 * 完成后更改基本信息
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update  TBProjectInfo_S set PROCESSSTEPS=6 where PRJNUM='"
				+ prjNum + "' ";
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
	}

	/**
	 * 查看是否有上传的信息
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		String sql = "select * from UPLOAD_FILE where LINKNAME='施工许可' and ID = '"
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
	 * 更改授权状态
	 */
	@Override
	public String changeAuthor(String prjId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TO_AUTHORIZATION set PROCESSSTEPS=6 where prjNum='"
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

}
