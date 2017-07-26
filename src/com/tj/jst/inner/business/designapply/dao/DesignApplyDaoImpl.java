package com.tj.jst.inner.business.designapply.dao;

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
import com.tj.jst.inner.business.designapply.model.DesignApply;
import com.tj.jst.inner.business.designapply.model.DesignQualification;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 项目设计阶段Dao类
 * 
 * @author DarkFlameMaster
 *
 */
public class DesignApplyDaoImpl extends BaseDao implements IDesignApplyDao {

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
					DesignApply design = new DesignApply();
					design.setDesignId(rs.getString("designId"));
					design.setPrjName(rs.getString("prjName"));
					design.setPrjNum(rs.getString("prjNum"));
					design.setDesignNum(rs.getString("designNum"));
					design.setDesignCorpName(rs.getString("designCorpName"));
					design.setDesignCorpCode(rs.getString("designCorpCode"));
					design.setAppSteffId(rs.getString("appSteffId"));
					design.setAppSteffName(rs.getString("appSteffName"));
					design.setAppDate(rs.getDate("appDate"));
					design.setAppOpinion(rs.getString("appOpinion"));
					design.setAppType(rs.getString("appType"));
					design.setProcessSteps(rs.getString("processSteps"));
					design.setApplyCorpCode(rs.getString("applyCorpCode"));
					design.setCreateDate(rs.getDate("createDate"));
					design.setAppDept(rs.getString("appDept"));
					design.setAppDeptName(rs.getString("appDeptName"));
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
	 * 根据Id查询所选条目
	 */
	@Override
	public DesignApply queryApproval(String designId) {
		// TODO Auto-generated method stub
		DesignApply design = new DesignApply();
		try {
			String sql = "select t.* from  DESIGN_BUSINESS t where t.designId='"
					+ designId + "'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				design.setDesignId(rs.getString("designId"));
				design.setPrjNum(rs.getString("prjNum"));
				design.setPrjName(rs.getString("prjName"));
				design.setDesignNum(rs.getString("designNum"));
				design.setDesignCorpName(rs.getString("designCorpName"));
				design.setDesignCorpCode(rs.getString("designCorpCode"));
				design.setAppSteffId(rs.getString("appSteffId"));
				design.setAppSteffName(rs.getString("appSteffName"));
				design.setAppDate(rs.getDate("appDate"));
				design.setAppOpinion(rs.getString("appOpinion"));
				design.setAppType(rs.getString("appType"));
				design.setProcessSteps(rs.getString("processSteps"));
				design.setApplyCorpCode(rs.getString("applyCorpCode"));
				design.setCreateDate(rs.getDate("createDate"));
				design.setAppDept(rs.getString("appDept"));
				design.setAppDeptName(rs.getString("appDeptName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return design;
	}

	/**
	 * 审批通过
	 */
	@Override
	public String applySuccess(DesignApply design) {
		// TODO Auto-generated method stub
		String message = "";
		try {
//			Calendar c = Calendar.getInstance();
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
//			String fDate = simpleDateFormat.format(c.getTime());
//			String serNum = PrjCode.querySerNuma(design.getCreateDate(), 1);
//			String designNum = design.getAppDept() + fDate
//					+ design.getPrjNum().substring(12, 16) + "-HA-" + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  DESIGN_BUSINESS set APPTYPE=1,PROCESSSTEPS=3,APPSTEFFID=?,APPSTEFFNAME=?,APPDATE=?,APPOPINION=? where DESIGNID=?");
			pstmt.setString(1, design.getAppSteffId());
			pstmt.setString(2, design.getAppSteffName());
			pstmt.setDate(3, design.getAppDate());
			pstmt.setString(4, design.getAppOpinion());
			pstmt.setString(5, design.getDesignId());
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
	public String applyFaile(DesignApply design) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  DESIGN_BUSINESS set APPTYPE=2,PROCESSSTEPS=2,APPSTEFFID=?,APPSTEFFNAME=?,APPDATE=?,APPOPINION=? where DESIGNID=?");
			pstmt.setString(1, design.getAppSteffId());
			pstmt.setString(2, design.getAppSteffName());
			pstmt.setDate(3, design.getAppDate());
			pstmt.setString(4, design.getAppOpinion());
			pstmt.setString(5, design.getDesignId());
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
	 * 检测勘察阶段是否完成
	 */
	@Override
	public String querySurvey(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from SURVEY_BUSINESS where PRJNUM='" + prjNum
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
	 * 更改项目基本信息表
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
					DesignQualification design = new DesignQualification();
					design.setDesignId(rs.getString("designId"));
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
		String sql = "select * from UPLOAD_FILE where LINKNAME='设计申请' and ID = '"
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
