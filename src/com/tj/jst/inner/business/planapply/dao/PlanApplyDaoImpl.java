package com.tj.jst.inner.business.planapply.dao;

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
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.upload.model.Upload;

public class PlanApplyDaoImpl extends BaseDao implements IPlanApplyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					ConstructionPlans plan = new ConstructionPlans();
					plan.setPrjId(rs.getString("prjId"));
					plan.setCensorId(rs.getInt("censorId"));// 主键
					plan.setCensorNum(rs.getString("censorNum"));// 施工图审查合格证书编号
					plan.setPrjNum(rs.getString("prjNum"));// 项目编号
					plan.setPrjName(rs.getString("prjName"));// 项目名称
					plan.setCensorCorpName(rs.getString("censorCorpName"));// 施工图审查机构名称
					plan.setCensorCorpCode(rs.getString("censorCorpCode"));// 施工图审查机构组织机构代码
					plan.setCensorEDate(rs.getDate("censorEDate"));// 审查完成日期
					plan.setPrjSize(rs.getString("prjSize"));// 建设规模
					plan.setEconCorpName(rs.getString("econCorpName"));// 勘察单位名称
					plan.setEconCorpCode(rs.getString("econCorpCode"));// 勘察单位组织机构代码
					plan.setEconCorpName2(rs.getString("econCorpName2"));// 勘察单位名称2
					plan.setEconCorpCode2(rs.getString("econCorpCode2")); // 勘察单位组织机构代码2
					plan.setEconCorpName3(rs.getString("econCorpName3"));// 勘察单位名称3
					plan.setEconCorpCode3(rs.getString("econCorpCode3")); // 勘察单位组织机构代码3
					plan.setDesignCorpName(rs.getString("designCorpName"));// 设计单位名称
					plan.setDesignCorpCode(rs.getString("designCorpCode"));// 设计单位组织机构代码
					plan.setDesignCorpName2(rs.getString("designCorpName2"));// 设计单位名称2
					plan.setDesignCorpCode2(rs.getString("designCorpCode2"));// 设计单位组织机构代码2
					plan.setDesignCorpName3(rs.getString("designCorpName3"));// 设计单位名称3
					plan.setDesignCorpCode3(rs.getString("designCorpCode3"));// 设计单位组织机构代码3
					plan.setOneCensorIsPass(rs.getString("oneCensorIsPass"));// 一次审查是否通过
																				// 通过1、不通过0
					plan.setOneCensorWfqtCount(rs
							.getString("oneCensorWfqtCount"));// 一次审查时违反强条数
					plan.setOneCensorWfqtContent(rs
							.getString("oneCensorWfqtContent"));// 一次审查时违反的强条条目
					plan.setCreateDate(rs.getDate("createDate"));// 记录登记日期
					
					
					plan.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
					plan.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
					plan.setAppSteffId(rs.getString("appSteffId"));// 审批人id
					plan.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
					plan.setAppDate(rs.getDate("appDate"));// 审批时间
					plan.setAppOpinion(rs.getString("appOpinion"));// 审批意见
					/**
					 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					plan.setAppType(rs.getString("appType").trim());// 审批状态
					/**
					 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
					 * 6:竣工验收
					 */
					plan.setProcessSteps(rs.getString("processSteps").trim());
					plan.setAppDept(rs.getString("appDept").trim());// 审批单位id
					plan.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
					page.getData().add(plan);
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
	 * 查询审批条目
	 */
	@Override
	public ConstructionPlans queryApproval(String censorId) {
		// TODO Auto-generated method stub
		ConstructionPlans plan = new ConstructionPlans();
		String sql = "select * from TBPROJECTCENSORINFO where censorId = '"
				+ censorId + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				plan.setPrjId(rs.getString("prjId"));
				plan.setCensorId(rs.getInt("censorId"));// 主键
				plan.setCensorNum(rs.getString("censorNum"));// 施工图审查合格证书编号
				plan.setPrjNum(rs.getString("prjNum"));// 项目编号
				plan.setPrjName(rs.getString("prjName"));// 项目名称
				plan.setCensorCorpName(rs.getString("censorCorpName"));// 施工图审查机构名称
				plan.setCensorCorpCode(rs.getString("censorCorpCode"));// 施工图审查机构组织机构代码
				plan.setCensorEDate(rs.getDate("censorEDate"));// 审查完成日期
				plan.setPrjSize(rs.getString("prjSize"));// 建设规模
				plan.setEconCorpName(rs.getString("econCorpName"));// 勘察单位名称
				plan.setEconCorpCode(rs.getString("econCorpCode"));// 勘察单位组织机构代码
				plan.setEconCorpName2(rs.getString("econCorpName2"));// 勘察单位名称2
				plan.setEconCorpCode2(rs.getString("econCorpCode2")); // 勘察单位组织机构代码2
				plan.setEconCorpName3(rs.getString("econCorpName3"));// 勘察单位名称3
				plan.setEconCorpCode3(rs.getString("econCorpCode3")); // 勘察单位组织机构代码3
				plan.setDesignCorpName(rs.getString("designCorpName"));// 设计单位名称
				plan.setDesignCorpCode(rs.getString("designCorpCode"));// 设计单位组织机构代码
				plan.setDesignCorpName2(rs.getString("designCorpName2"));// 设计单位名称2
				plan.setDesignCorpCode2(rs.getString("designCorpCode2"));// 设计单位组织机构代码2
				plan.setDesignCorpName3(rs.getString("designCorpName3"));// 设计单位名称3
				plan.setDesignCorpCode3(rs.getString("designCorpCode3"));// 设计单位组织机构代码3
				plan.setOneCensorIsPass(rs.getString("oneCensorIsPass"));// 一次审查是否通过
																			// 通过1、不通过0
				plan.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));// 一次审查时违反强条数
				plan.setOneCensorWfqtContent(rs
						.getString("oneCensorWfqtContent"));// 一次审查时违反的强条条目
				plan.setCreateDate(rs.getDate("createDate"));// 记录登记日期
				plan.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				plan.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				plan.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				plan.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				plan.setAppDate(rs.getDate("appDate"));// 审批时间
				plan.setAppOpinion(rs.getString("appOpinion"));// 审批意见
				/**
				 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				plan.setAppType(rs.getString("appType").trim());// 审批状态
				/**
				 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
				 * 6:竣工验收
				 */
				plan.setProcessSteps(rs.getString("processSteps").trim());
				plan.setAppDept(rs.getString("appDept").trim());// 审批单位id
				plan.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return plan;
	}

	/**
	 * 审批通过
	 */
	@Override
	public String approvalSuccess(ConstructionPlans plan) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			// Calendar c = Calendar.getInstance();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyMMdd");
			// String fDate = simpleDateFormat.format(c.getTime());
			// String serNum = PrjCode.querySerNuma(plan.getCreateDate(), 4);
			// String planNum = plan.getAppDept() + fDate
			// + plan.getPrjNum().substring(12, 16) + "-TX-" + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE TBPROJECTCENSORINFO set oneCensorIsPass= 1, APPTYPE = 1 , PROCESSSTEPS = 4 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ? where CENSORID = ?");
			pstmt.setString(1, plan.getAppSteffId());
			pstmt.setString(2, plan.getAppSteffName());
			pstmt.setDate(3, plan.getAppDate());
			pstmt.setString(4, plan.getAppOpinion());
			pstmt.setInt(5, plan.getCensorId());
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
	public String approvalFailed(ConstructionPlans plan) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE TBPROJECTCENSORINFO set oneCensorIsPass= 0 ,  APPTYPE = 2 , PROCESSSTEPS = 3 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ? , oneCensorWfqtCount= ? , oneCensorWfqtContent = ? where CENSORID = ?");
			pstmt.setString(1, plan.getAppSteffId());
			pstmt.setString(2, plan.getAppSteffName());
			pstmt.setDate(3, plan.getAppDate());
			pstmt.setString(4, plan.getAppOpinion());
			pstmt.setString(5, plan.getOneCensorWfqtCount());
			pstmt.setString(6, plan.getOneCensorWfqtContent());
			pstmt.setInt(7, plan.getCensorId());
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
	public String queryFiling(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from tbcontractrecordmanage where PRJNUM='"
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
	 * 均完成改写项目基本信息
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
		String sql = "select * from UPLOAD_FILE where LINKNAME='施工图审' and ID = '"
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

}
