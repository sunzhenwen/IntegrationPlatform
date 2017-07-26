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
 * �����������ݿ���
 * 
 * @author DarkFlameMaster
 *
 */
public class ReadyApplyDaoImpl extends BaseDao implements IReadyApplyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ
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
					complete.setCompleteId(rs.getString("completeId"));// ����
					complete.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					complete.setPrjName(rs.getString("prjName"));// ��Ŀ����
					complete.setBuilderLicenceNum(rs
							.getString("builderLicenceNum"));// ʩ�����֤���
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
					complete.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					complete.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					complete.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					complete.setAppSteffId(rs.getString("appSteffId"));// ������id
					complete.setAppSteffName(rs.getString("appSteffName"));// ����������
					complete.setAppDate(rs.getDate("appDate"));// ����ʱ��
					complete.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					complete.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					complete.setProcessSteps(rs.getString("processSteps")
							.trim());
					complete.setAppDept(rs.getString("appDept").trim());// ������λid
					complete.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
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
	 * ��ѯ������ϸ
	 */
	@Override
	public Complete queryApproval(String completeId) {
		// TODO Auto-generated method stub
		Complete complete = new Complete();
		try {

			String qsql = "select * from TBPROJECTFINISHMANAGE where completeId=?";
			// ��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, completeId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				complete.setPrjId(rs.getString("prjId"));
				complete.setCompleteId(rs.getString("completeId"));// ����
				complete.setProjectName(rs.getString("projectName"));
				complete.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				complete.setPrjName(rs.getString("prjName"));// ��Ŀ����
				complete.setPrjFinishNum(rs.getString("PRJFINISHNUM"));
				complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// ʩ�����֤���
				complete.setQcCorpName(rs.getString("qcCorpName"));
				complete.setQcCorpCode(rs.getString("qcCorpCode"));
				complete.setFactCost(rs.getString("factCost"));
				complete.setFactArea(rs.getString("factArea"));
				complete.setFactSize(rs.getString("factSize"));
				complete.setPrjStructureTypeNum(rs
						.getString("prjStructureTypeNum"));
				complete.setBDate(rs.getDate("bDate"));
				complete.setEDate(rs.getDate("eDate"));
				complete.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				complete.setMark(rs.getString("mark"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				complete.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				complete.setAppDept(rs.getString("appDept").trim());// ������λid
				complete.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
				complete.setAppSteffId(rs.getString("appSteffId"));// ������id
				complete.setAppSteffName(rs.getString("appSteffName"));// ����������
				complete.setAppDate(rs.getDate("appDate"));// ����ʱ��
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
	 * ����ͨ��
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
			message = "�ɹ�";
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
		
		//��������ͨ���󣬽�ʵ�ʿ���ʱ���ʵ�ʿ���ʱ��洢����Ŀ��������TBPROJECTINFO_S
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
	 * ������ͨ��
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
			message = "�ɹ�";
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
	 * ������ɸ���״̬
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
				message = "�ɹ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

	}

	/**
	 * �鿴�Ƿ����ϴ�����Ϣ
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		String sql = "select * from UPLOAD_FILE where LINKNAME='��������' and ID = '"
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
	 * ������Ȩ״̬
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
				message = "�ɹ�";
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
