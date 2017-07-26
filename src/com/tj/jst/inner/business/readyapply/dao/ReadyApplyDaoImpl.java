package com.tj.jst.inner.business.readyapply.dao;

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
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 竣工验收数据库类
 * 
 * @author DarkFlameMaster
 *
 */
public class ReadyApplyDaoImpl extends BaseDao implements IReadyApplyDao {

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
					Complete complete = new Complete();
					complete.setProjectName(rs.getString("projectName"));
					complete.setPrjId(rs.getString("prjId"));
					complete.setCompleteId(rs.getString("completeId"));// 主键
					complete.setPrjNum(rs.getString("prjNum"));// 项目编号
					complete.setPrjName(rs.getString("prjName"));// 项目名称
					complete.setBuilderLicenceNum(rs
							.getString("builderLicenceNum"));// 施工许可证编号
					complete.setQcCorpName(rs.getString("qcCorpName"));
					complete.setQcCorpCode(rs.getString("qcCorpCode"));
					complete.setFactCost(rs.getString("factCost"));
					complete.setFactArea(rs.getString("factArea"));
					complete.setFactSize(rs.getString("factSize"));
					complete.setPrjStructureTypeNum(rs
							.getString("prjStructureTypeNum"));
					complete.setBDate(rs.getDate("bDate"));
					complete.setEDate(rs.getDate("eDate"));
					complete.setMark(rs.getString("mark"));
					complete.setCreateDate(rs.getDate("createDate"));// 记录登记日期
					complete.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
					complete.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
					complete.setAppSteffId(rs.getString("appSteffId"));// 审批人id
					complete.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
					complete.setAppDate(rs.getDate("appDate"));// 审批时间
					complete.setAppOpinion(rs.getString("appOpinion"));// 审批意见
					/**
					 * 审批状态 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					complete.setAppType(rs.getString("appType").trim());// 审批状态
					/**
					 * 流程步骤 1:项目报建 2:勘察阶段、设计阶段 3:合同备案、施工图审查备案 4:质量监督、安全监督 5:施工许可
					 * 6:竣工验收
					 */
					complete.setProcessSteps(rs.getString("processSteps")
							.trim());
					complete.setAppDept(rs.getString("appDept").trim());// 审批单位id
					complete.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
					page.getData().add(complete);
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
	 * 查询审批详细
	 */
	@Override
	public Complete queryApproval(String completeId) {
		// TODO Auto-generated method stub
		Complete complete = new Complete();
		try {

			String qsql = "select * from TBPROJECTFINISHMANAGE where completeId=?";
			// 获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, completeId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				complete.setPrjId(rs.getString("prjId"));
				complete.setCompleteId(rs.getString("completeId"));// 主键
				complete.setProjectName(rs.getString("projectName"));
				complete.setPrjNum(rs.getString("prjNum"));// 项目编号
				complete.setPrjName(rs.getString("prjName"));// 项目名称
				complete.setPrjFinishNum(rs.getString("PRJFINISHNUM"));
				complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// 施工许可证编号
				complete.setQcCorpName(rs.getString("qcCorpName"));
				complete.setQcCorpCode(rs.getString("qcCorpCode"));
				complete.setFactCost(rs.getString("factCost"));
				complete.setFactArea(rs.getString("factArea"));
				complete.setFactSize(rs.getString("factSize"));
				complete.setPrjStructureTypeNum(rs
						.getString("prjStructureTypeNum"));
				complete.setBDate(rs.getDate("bDate"));
				complete.setEDate(rs.getDate("eDate"));
				complete.setCreateDate(rs.getDate("createDate"));// 记录登记日期
				complete.setMark(rs.getString("mark"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));// 申请企业组织机构代码
				complete.setApplyCorpName(rs.getString("applyCorpName"));// 申请企业名称
				complete.setAppDept(rs.getString("appDept").trim());// 审批单位id
				complete.setAppDeptName(rs.getString("appDeptName").trim());// 审批单位名称
				complete.setAppSteffId(rs.getString("appSteffId"));// 审批人id
				complete.setAppSteffName(rs.getString("appSteffName"));// 审批人姓名
				complete.setAppDate(rs.getDate("appDate"));// 审批时间
				complete.setAppType(rs.getString("appType"));
				complete.setAppOpinion(rs.getString("appOpinion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return complete;
	}

	/**
	 * 审批通过
	 */
	@Override
	public String approvalSuccess(Complete complete) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			// Calendar c = Calendar.getInstance();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyMMdd");
			// String fDate = simpleDateFormat.format(c.getTime());
			// String serNum = PrjCode.querySerNuma(complete.getCreateDate(),
			// 8);
			// String completeNum = complete.getAppDept() + fDate
			// + complete.getPrjNum().substring(12, 16) + "-JX-" + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  TBPROJECTFINISHMANAGE set APPTYPE=1,PROCESSSTEPS=7,APPSTEFFID=?,APPSTEFFNAME=?,APPDATE=?,APPOPINION=? where COMPLETEID=?");
			pstmt.setString(1, complete.getAppSteffId());
			pstmt.setString(2, complete.getAppSteffName());
			pstmt.setDate(3, complete.getAppDate());
			pstmt.setString(4, complete.getAppOpinion());
			pstmt.setString(5, complete.getCompleteId());
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
		
		//竣工审批通过后，将实际开工时间和实际竣工时间存储在项目报建表里TBPROJECTINFO_S
		try {
			System.out.println("--------------"+complete.getCompleteId());
			Complete complete1 = new Complete(); 
			conn = ConnectionFactory.getBasicConnection();
			//conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("select * from TBPROJECTFINISHMANAGE where COMPLETEID = ?");
			pstmt.setString(1, complete.getCompleteId());
			rs = pstmt.executeQuery();
			if(rs.next()){
				complete1.setBDate(rs.getDate("BDate"));
				complete1.setEDate(rs.getDate("EDate"));
				complete1.setPrjId(rs.getString("prjId"));
			}
			System.out.println("+++++++++"+complete1.getBDate());
			System.out.println("+++++++++"+complete1.getEDate());
			System.out.println("+++++++++"+complete1.getPrjId());
			pstmt = conn
					.prepareStatement("update  TBPROJECTINFO_S set BDATE=?,EDATE=? where PRJID=?");
			pstmt.setDate(1, complete1.getBDate());
			pstmt.setDate(2, complete1.getEDate());
			pstmt.setString(3, complete1.getPrjId());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 审批不通过
	 */
	@Override
	public String approvalFailed(Complete complete) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  TBPROJECTFINISHMANAGE set APPTYPE=2,PROCESSSTEPS=6,APPSTEFFID=?,APPSTEFFNAME=?,APPDATE=?,APPOPINION=? where COMPLETEID=?");
			pstmt.setString(1, complete.getAppSteffId());
			pstmt.setString(2, complete.getAppSteffName());
			pstmt.setDate(3, complete.getAppDate());
			pstmt.setString(4, complete.getAppOpinion());
			pstmt.setString(5, complete.getCompleteId());
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
	 * 审批完成更改状态
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update  TBProjectInfo_S set PROCESSSTEPS=7 where PRJNUM='"
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
		String sql = "select * from UPLOAD_FILE where LINKNAME='竣工验收' and ID = '"
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
		String sql = "update TO_AUTHORIZATION set PROCESSSTEPS=7 where prjNum='"
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
