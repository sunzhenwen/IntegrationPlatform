package com.tj.jst.inner.business.qualityapply.dao;

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
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * �����������ݿ������
 * 
 * @author DarkFlameMaster
 *
 */
public class QualityApplyDaoImpl extends BaseDao implements IQualityApplyDao {

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
					Quality quality = new Quality();
					quality.setQualityId(rs.getString("qualityId"));// ����
					quality.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					quality.setPrjName(rs.getString("prjName"));// ��Ŀ����
					quality.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					quality.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					quality.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					quality.setAppSteffId(rs.getString("appSteffId"));// ������id
					quality.setAppSteffName(rs.getString("appSteffName"));// ����������
					quality.setAppDate(rs.getDate("appDate"));// ����ʱ��
					quality.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					quality.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					quality.setProcessSteps(rs.getString("processSteps").trim());
					quality.setAppDept(rs.getString("appDept").trim());// ������λid
					quality.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
					page.getData().add(quality);
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
	 * ������Ŀ��ѯ��
	 */
	@Override
	public Quality queryApproval(String qualityId) {
		// TODO Auto-generated method stub
		Quality quality = new Quality();
		try {

			String qsql = "select * from TB_QUALITYSUPERVISION where qualityId=?";
			// ��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, qualityId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				quality.setJianduzhuceNum(rs.getString("jianDuZhuCeNum"));
				quality.setQualityNum(rs.getString("QUALITYNUM"));
				quality.setWenjianNum(rs.getString("wenjianNum"));
				quality.setQualityId(rs.getString("qualityId"));// ����
				quality.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				quality.setPrjName(rs.getString("prjName"));// ��Ŀ����
				quality.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				quality.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				quality.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				quality.setAppSteffId(rs.getString("appSteffId"));// ������id
				quality.setAppSteffName(rs.getString("appSteffName"));// ����������
				quality.setAppDate(rs.getDate("appDate"));// ����ʱ��
				quality.setAppOpinion(rs.getString("appOpinion"));// �������
				/**
				 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				quality.setAppType(rs.getString("appType").trim());// ����״̬
				/**
				 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
				 * 6:��������
				 */
				quality.setProcessSteps(rs.getString("processSteps").trim());
				quality.setAppDept(rs.getString("appDept").trim());// ������λid
				quality.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
				quality.setPrjId(rs.getString("prjId"));
				quality.setProjectName(rs.getString("projectName"));// ��������
				quality.setConfiguration(rs.getString("configuration"));// �ṹ/����
				quality.setProjectAddress(rs.getString("projectAddress"));// ���̵ص�
				quality.setContact(rs.getString("contact"));// ��ϵ��
				quality.setConstructionArea(rs.getString("constructionArea"));// �������(ƽ����)
				quality.setQuantities(rs.getString("quantities"));// ��װ������(��Ԫ)
				quality.setExpensive(rs.getString("expensive"));// ���������(��Ԫ)
				quality.setSuperviseCost(rs.getString("superviseCost"));// �ල��(Ԫ)
				quality.setStartDate(rs.getDate("startDate"));// �ƻ���������
				quality.setEndDate(rs.getDate("endDate"));// �ƻ���������
				quality.setDevelopmentOrganization(rs
						.getString("developmentOrganization"));// ���赥λ
				quality.setDevelopmentQualificationLevel(rs
						.getString("developmentQualificationLevel"));// ���赥λ���ʵȼ�
				quality.setDevelopmentCharge(rs.getString("developmentCharge"));// ���赥λ��Ŀ������
				quality.setDevelopmentPhone(rs.getString("developmentPhone"));// ���赥λ��ϵ�绰
				quality.setSurveyUnit(rs.getString("surveyUnit"));// ���쵥λ
				quality.setSurveyUnitQualificationLevel(rs
						.getString("surveyUnitQualificationLevel"));// ���쵥λ���ʵȼ�
				quality.setSurveyUnitCharge(rs.getString("surveyUnitCharge"));// ���쵥λ��Ŀ������
				quality.setSurveyUnitPhone(rs.getString("surveyUnitPhone"));// ���쵥λ��ϵ�绰
				quality.setDesignUnit(rs.getString("designUnit"));// ��Ƶ�λ
				quality.setDesignUnitQualificationLevel(rs
						.getString("designUnitQualificationLevel"));// ��Ƶ�λ���ʵȼ�
				quality.setDesignUnitCharge(rs.getString("designUnitCharge"));// ��Ƶ�λ��Ŀ������
				quality.setDesignUnitPhone(rs.getString("designUnitPhone"));// ��Ƶ�λ��ϵ�绰
				quality.setSupervisionUnit(rs.getString("supervisionUnit"));// ����λ
				quality.setSupervisionUnitQualLevel(rs
						.getString("supervisionUnitQualLevel"));// ����λ���ʵȼ�
				quality.setSupervisionUnitEngineer(rs
						.getString("supervisionUnitEngineer"));// �ܼ�����ʦ
				quality.setSupervisionUnitPhone(rs
						.getString("supervisionUnitPhone"));// ����λ��ϵ�绰
				quality.setConstructionUnit(rs.getString("constructionUnit"));// ʩ����λ
				quality.setConstructionUnitQualLevel(rs
						.getString("constructionUnitQualLevel"));// ʩ����λ���ʵȼ�
				quality.setConstructionUnitProjectManager(rs
						.getString("constructionUnitProjectManager"));// ʩ����λ��Ŀ����
				quality.setConstructionUnitPhone(rs
						.getString("constructionUnitPhone"));// ʩ����λ��ϵ�绰
				quality.setConstructionPlans(rs.getString("constructionPlans"));// ʩ��ͼ������
				quality.setConstructionPlansType(rs
						.getString("constructionPlansType"));// ʩ��ͼ���������
				quality.setConstructionPlansCharge(rs
						.getString("constructionPlansCharge"));// ʩ��ͼ��������Ŀ������
				quality.setConstructionPlansPhone(rs
						.getString("constructionPlansPhone"));// ʩ��ͼ��������ϵ�绰
				quality.setConstructionContractFileNum(rs
						.getString("constructionContractFileNum"));// ʩ����ͬ�ļ���
				quality.setConstructionOrganFileNum(rs
						.getString("constructionOrganFileNum"));// ʩ����֯����ļ���
				quality.setConstructionPlansFileNum(rs
						.getString("constructionPlansFileNum"));// ʩ��ͼ��鱨�����׼���ļ���
				quality.setSupervisionContractFileNum(rs
						.getString("supervisionContractFileNum"));// �����ͬ�ļ���
				quality.setSupervisionPlanFileNum(rs
						.getString("supervisionPlanFileNum"));// ����滮�ļ���
				quality.setFireControlFileNum(rs
						.getString("FireControlFileNum"));// ����������ϸ�����֤���ļ��ļ���
				quality.setDevelopmentOrganFileNum(rs
						.getString("DevelopmentOrganFileNum"));// ���赥λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setOnstructionUnitFileNum(rs
						.getString("OnstructionUnitFileNum"));// ʩ����λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setSupervisionUnitFileNum(rs
						.getString("SupervisionUnitFileNum"));// ����λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setConstructionSiteFileNum(rs
						.getString("ConstructionSiteFileNum"));// ʩ���ֳ���Ŀ�����ˡ�������Ա�ʸ�֤���ļ���
				quality.setQualityTestingFileNum(rs
						.getString("QualityTestingFileNum"));// �������Ա��λ֤���ļ���
				quality.setFieldSupervisionFileNum(rs
						.getString("FieldSupervisionFileNum"));// �ֳ�������Աע��ִҵ֤���ļ���
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String applySuccess(Quality qu) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			// Calendar c = Calendar.getInstance();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyMMdd");
			// String fDate = simpleDateFormat.format(c.getTime());
			// String serNum = PrjCode.querySerNuma(qu.getCreateDate(), 5);
			// String quNum = qu.getAppDept() + fDate
			// + qu.getPrjNum().substring(12, 16) + "-QU-" + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE TB_QUALITYSUPERVISION set APPTYPE = 1 , PROCESSSTEPS = 5 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ? , JIANDUZHUCENUM = ? , WENJIANNUM = ? where QUALITYID = ?");
			pstmt.setString(1, qu.getAppSteffId());
			pstmt.setString(2, qu.getAppSteffName());
			pstmt.setDate(3, qu.getAppDate());
			pstmt.setString(4, qu.getAppOpinion());
			pstmt.setString(5, qu.getJianduzhuceNum());
			pstmt.setString(6, qu.getWenjianNum());
			pstmt.setString(7, qu.getQualityId());
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
	public String applyFaile(Quality qu) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE TB_QUALITYSUPERVISION set APPTYPE = 2 , PROCESSSTEPS = 4 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ? where QUALITYID = ?");
			pstmt.setString(1, qu.getAppSteffId());
			pstmt.setString(2, qu.getAppSteffName());
			pstmt.setDate(3, qu.getAppDate());
			pstmt.setString(4, qu.getAppOpinion());
			pstmt.setString(5, qu.getQualityId());
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
	 * ��ѯ��ȫ�Ƿ����
	 */
	@Override
	public String querySafety(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_SAFETYSUPERVISION  where PRJNUM='"
				+ prjNum + "' and PROCESSSTEPS = 5 and APPTYPE = 1";
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
	 * �������Ļ�����Ϣ
	 */
	@Override
	public void updateProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "update  TBProjectInfo_S set PROCESSSTEPS=5 where PRJNUM='"
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
		String sql = "select * from UPLOAD_FILE where LINKNAME='�����ලע��' and ID = '"
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
		String sql = "update TO_AUTHORIZATION set PROCESSSTEPS=5 where prjNum='"
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
