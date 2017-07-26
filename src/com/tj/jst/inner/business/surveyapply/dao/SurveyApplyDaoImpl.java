package com.tj.jst.inner.business.surveyapply.dao;

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
import com.tj.jst.inner.business.surveyapply.model.SurveyApply;
import com.tj.jst.inner.business.surveyapply.model.SurveyQualification;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 勘查阶段Dao类
 * 
 * @author DarkFlameMaster
 *
 */
public class SurveyApplyDaoImpl extends BaseDao implements ISurveyApplyDao {

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
					SurveyApply survey = new SurveyApply();
					survey.setSurveyId(rs.getString("surveyId"));
					survey.setPrjNum(rs.getString("prjNum"));
					survey.setPrjName(rs.getString("prjName"));
					survey.setSurveyNum(rs.getString("surveyNum"));
					survey.setSurveyCorpName(rs.getString("surveyCorpName"));
					survey.setSurveyCorpCode(rs.getString("surveyCorpCode"));
					survey.setAppSteffId(rs.getString("appSteffId"));
					survey.setAppSteffName(rs.getString("appSteffName"));
					survey.setAppDate(rs.getDate("appDate"));
					survey.setAppOpinion(rs.getString("appOpinion"));
					survey.setAppType(rs.getString("appType"));
					survey.setProcessSteps(rs.getString("processSteps"));
					survey.setApplyCorpCode(rs.getString("applyCorpCode"));
					survey.setCreateDate(rs.getDate("createDate"));
					survey.setAppDept(rs.getString("appDept"));
					survey.setAppDeptName(rs.getString("appDeptName"));
					page.getData().add(survey);
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
	 * 根据Id查询审批信息
	 */
	@Override
	public SurveyApply queryApproval(String surveyId) {
		// TODO Auto-generated method stub
		SurveyApply survey = new SurveyApply();
		try {
			String sql = "select t.* from  SURVEY_BUSINESS t where t.surveyId='"
					+ surveyId + "'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				survey.setSurveyId(rs.getString("surveyId"));
				survey.setPrjNum(rs.getString("prjNum"));
				survey.setSurveyNum(rs.getString("surveyNum"));
				survey.setPrjName(rs.getString("prjName"));
				survey.setSurveyCorpName(rs.getString("surveyCorpName"));
				survey.setSurveyCorpCode(rs.getString("surveyCorpCode"));
				survey.setAppSteffId(rs.getString("appSteffId"));
				survey.setAppSteffName(rs.getString("appSteffName"));
				survey.setAppDate(rs.getDate("appDate"));
				survey.setAppOpinion(rs.getString("appOpinion"));
				survey.setAppType(rs.getString("appType"));
				survey.setProcessSteps(rs.getString("processSteps"));
				survey.setApplyCorpCode(rs.getString("applyCorpCode"));
				survey.setCreateDate(rs.getDate("createDate"));
				survey.setAppDept(rs.getString("appDept"));
				survey.setAppDeptName(rs.getString("appDeptName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return survey;
	}

	/**
	 * 审批通过
	 */
	@Override
	public String applySuccess(SurveyApply design) {
		// TODO Auto-generated method stub
		String message = "";
		try {
//			Calendar c = Calendar.getInstance();
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
//			String fDate = simpleDateFormat.format(c.getTime());
//			String serNum = PrjCode.querySerNuma(design.getCreateDate(), 2);
//			String surveyNum = design.getAppDept() + fDate
//					+ design.getPrjNum().substring(12, 16) + "-HB-" + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  SURVEY_BUSINESS set APPTYPE=1,PROCESSSTEPS=3,APPSTEFFID=?,APPSTEFFNAME=?,APPDATE=?,APPOPINION=? where SURVEYID=?");
			pstmt.setString(1, design.getAppSteffId());
			pstmt.setString(2, design.getAppSteffName());
			pstmt.setDate(3, design.getAppDate());
			pstmt.setString(4, design.getAppOpinion());
			pstmt.setString(5, design.getSurveyId());
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
	public String applyFaile(SurveyApply design) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  SURVEY_BUSINESS set APPTYPE=2,PROCESSSTEPS=2,APPSTEFFID=?,APPSTEFFNAME=?,APPDATE=?,APPOPINION=? where SURVEYID=?");
			pstmt.setString(1, design.getAppSteffId());
			pstmt.setString(2, design.getAppSteffName());
			pstmt.setDate(3, design.getAppDate());
			pstmt.setString(4, design.getAppOpinion());
			pstmt.setString(5, design.getSurveyId());
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
	 * 查询设计阶段是否完成
	 */
	@Override
	public String querySurvey(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from DESIGN_BUSINESS where PRJNUM='" + prjNum
				+ "' and PROCESSSTEPS = 3 and APPTYPE = 1";
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
	 * 如果都完成则更改项目基本信息表中的信息
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update  TBProjectInfo_S set PROCESSSTEPS=3 where PRJNUM='"
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
	 * 审批附页
	 */
	@Override
	public Page sidebyPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					SurveyQualification design = new SurveyQualification();
					design.setSurveyId(rs.getString("surveyId"));
					design.setId(rs.getString("id"));
					design.setCretTypeName(rs.getString("certTypeName"));
					design.setCertId(rs.getString("certId"));
					design.setTitleLevelName(rs.getString("titleLevelName"));
					page.getData().add(design);
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
	 * 查看是否有上传的信息
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		String sql = "select * from UPLOAD_FILE where LINKNAME='勘察申请' and ID = '"
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

}
