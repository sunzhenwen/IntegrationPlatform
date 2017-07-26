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
	 * ��ҳ��ѯ
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
					plan.setCensorId(rs.getInt("censorId"));// ����
					plan.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�֤����
					plan.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					plan.setPrjName(rs.getString("prjName"));// ��Ŀ����
					plan.setCensorCorpName(rs.getString("censorCorpName"));// ʩ��ͼ����������
					plan.setCensorCorpCode(rs.getString("censorCorpCode"));// ʩ��ͼ��������֯��������
					plan.setCensorEDate(rs.getDate("censorEDate"));// ����������
					plan.setPrjSize(rs.getString("prjSize"));// �����ģ
					plan.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
					plan.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
					plan.setEconCorpName2(rs.getString("econCorpName2"));// ���쵥λ����2
					plan.setEconCorpCode2(rs.getString("econCorpCode2")); // ���쵥λ��֯��������2
					plan.setEconCorpName3(rs.getString("econCorpName3"));// ���쵥λ����3
					plan.setEconCorpCode3(rs.getString("econCorpCode3")); // ���쵥λ��֯��������3
					plan.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
					plan.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
					plan.setDesignCorpName2(rs.getString("designCorpName2"));// ��Ƶ�λ����2
					plan.setDesignCorpCode2(rs.getString("designCorpCode2"));// ��Ƶ�λ��֯��������2
					plan.setDesignCorpName3(rs.getString("designCorpName3"));// ��Ƶ�λ����3
					plan.setDesignCorpCode3(rs.getString("designCorpCode3"));// ��Ƶ�λ��֯��������3
					plan.setOneCensorIsPass(rs.getString("oneCensorIsPass"));// һ������Ƿ�ͨ��
																				// ͨ��1����ͨ��0
					plan.setOneCensorWfqtCount(rs
							.getString("oneCensorWfqtCount"));// һ�����ʱΥ��ǿ����
					plan.setOneCensorWfqtContent(rs
							.getString("oneCensorWfqtContent"));// һ�����ʱΥ����ǿ����Ŀ
					plan.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					
					
					plan.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					plan.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					plan.setAppSteffId(rs.getString("appSteffId"));// ������id
					plan.setAppSteffName(rs.getString("appSteffName"));// ����������
					plan.setAppDate(rs.getDate("appDate"));// ����ʱ��
					plan.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					plan.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					plan.setProcessSteps(rs.getString("processSteps").trim());
					plan.setAppDept(rs.getString("appDept").trim());// ������λid
					plan.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
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
	 * ��ѯ������Ŀ
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
				plan.setCensorId(rs.getInt("censorId"));// ����
				plan.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�֤����
				plan.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				plan.setPrjName(rs.getString("prjName"));// ��Ŀ����
				plan.setCensorCorpName(rs.getString("censorCorpName"));// ʩ��ͼ����������
				plan.setCensorCorpCode(rs.getString("censorCorpCode"));// ʩ��ͼ��������֯��������
				plan.setCensorEDate(rs.getDate("censorEDate"));// ����������
				plan.setPrjSize(rs.getString("prjSize"));// �����ģ
				plan.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
				plan.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
				plan.setEconCorpName2(rs.getString("econCorpName2"));// ���쵥λ����2
				plan.setEconCorpCode2(rs.getString("econCorpCode2")); // ���쵥λ��֯��������2
				plan.setEconCorpName3(rs.getString("econCorpName3"));// ���쵥λ����3
				plan.setEconCorpCode3(rs.getString("econCorpCode3")); // ���쵥λ��֯��������3
				plan.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
				plan.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
				plan.setDesignCorpName2(rs.getString("designCorpName2"));// ��Ƶ�λ����2
				plan.setDesignCorpCode2(rs.getString("designCorpCode2"));// ��Ƶ�λ��֯��������2
				plan.setDesignCorpName3(rs.getString("designCorpName3"));// ��Ƶ�λ����3
				plan.setDesignCorpCode3(rs.getString("designCorpCode3"));// ��Ƶ�λ��֯��������3
				plan.setOneCensorIsPass(rs.getString("oneCensorIsPass"));// һ������Ƿ�ͨ��
																			// ͨ��1����ͨ��0
				plan.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));// һ�����ʱΥ��ǿ����
				plan.setOneCensorWfqtContent(rs
						.getString("oneCensorWfqtContent"));// һ�����ʱΥ����ǿ����Ŀ
				plan.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				plan.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				plan.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				plan.setAppSteffId(rs.getString("appSteffId"));// ������id
				plan.setAppSteffName(rs.getString("appSteffName"));// ����������
				plan.setAppDate(rs.getDate("appDate"));// ����ʱ��
				plan.setAppOpinion(rs.getString("appOpinion"));// �������
				/**
				 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				plan.setAppType(rs.getString("appType").trim());// ����״̬
				/**
				 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
				 * 6:��������
				 */
				plan.setProcessSteps(rs.getString("processSteps").trim());
				plan.setAppDept(rs.getString("appDept").trim());// ������λid
				plan.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
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
	 * ����ͨ��
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
	 * ������ͨ��
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
	 * ��ѯʩ��ͼ�Ƿ����
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

	/**
	 * ����ɸ�д��Ŀ������Ϣ
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
				String message = "�ɹ�";
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
		String sql = "select * from UPLOAD_FILE where LINKNAME='ʩ��ͼ��' and ID = '"
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
		String sql = "update TO_AUTHORIZATION set PROCESSSTEPS=4 where prjNum='"
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
