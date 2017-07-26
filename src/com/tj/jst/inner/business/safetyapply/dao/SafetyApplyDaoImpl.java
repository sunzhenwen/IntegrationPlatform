package com.tj.jst.inner.business.safetyapply.dao;

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
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ��ȫ�������ݿ���
 * 
 * @author DarkFlameMaster
 *
 */
public class SafetyApplyDaoImpl extends BaseDao implements ISafetyApplyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Safety safety = new Safety();
					safety.setSafetyId(rs.getString("SAFETYID"));// ����
					safety.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					safety.setPrjName(rs.getString("prjName"));// ��Ŀ����
					safety.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					safety.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					safety.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					safety.setAppSteffId(rs.getString("appSteffId"));// ������id
					safety.setAppSteffName(rs.getString("appSteffName"));// ����������
					safety.setAppDate(rs.getDate("appDate"));// ����ʱ��
					safety.setContractName(rs.getString("contractName"));// ʩ���ܳа���λ����
					safety.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					safety.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					safety.setProcessSteps(rs.getString("processSteps").trim());
					safety.setAppDept(rs.getString("appDept").trim());// ������λid
					safety.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
					page.getData().add(safety);
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
	 * ����������Ŀ
	 */
	@Override
	public Safety queryApproval(String safetyId) {
		// TODO Auto-generated method stub
		Safety quality = new Safety();
		try {

			String qsql = "select * from TB_SAFETYSUPERVISION where SAFETYID=?";
			// ��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, safetyId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				quality.setOversightNum(rs.getString("overSightNum"));
				quality.setSafetyId(rs.getString("SAFETYID"));// ����
				quality.setSafetyNum(rs.getString("safetyNum"));// ��ȫ����
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
				// quality.setOversightNum(rs.getString("oversightNum"));//��ȫ�ල�ǼǱ��
				quality.setProjectName(rs.getString("projectName"));// ��������
				quality.setProjectAddress(rs.getString("projectAddress"));// ���̵ص�
				quality.setProStartDate(rs.getDate("proStartDate"));// ��ͬ��������
				quality.setProEndDate(rs.getDate("proEndDate"));// ��ͬ��������
				quality.setProjectType(rs.getString("projectType"));// ��������
				quality.setSafetyTarget(rs.getString("safetyTarget"));// ��ȫ������׼������Ŀ��
				if (rs.getString("newlyBuild") != null) {
					quality.setNewlyBuild(rs.getString("newlyBuild").trim());// �½�
				} else {
					quality.setNewlyBuild(rs.getString("newlyBuild"));// �½�
				}
				if (rs.getString("extend") != null) {
					quality.setExtend(rs.getString("extend").trim());// ������
				} else {
					quality.setExtend(rs.getString("extend"));// ������
				}
				if (rs.getString("other") != null) {
					quality.setOther(rs.getString("other").trim());// ����
				} else {
					quality.setOther(rs.getString("other"));// ����
				}
				quality.setPolicingName(rs.getString("policingName"));// ���쵥λȫ��
				quality.setPolicingStaff(rs.getString("policingStaff"));// ���쵥λ��Ŀ������
				quality.setDesignName(rs.getString("designName"));// ��Ƶ�λȫ��
				quality.setDesignStaff(rs.getString("designStaff"));// ��Ƶ�λ��Ŀ������
				quality.setBuildingName(rs.getString("buildingName"));// ���赥λȫ��
				quality.setBuildingStaff(rs.getString("buildingStaff"));// ���赥λ��Ŀ������
				quality.setBuildingPhone(rs.getString("buildingPhone"));// ���赥λ��ϵ�绰
				quality.setSupervisionName(rs.getString("supervisionName"));// ����λȫ��
				quality.setSupervisionStaff(rs.getString("supervisionStaff"));// ����λ��Ŀ�ܼ�����
				quality.setSupervisionNum(rs.getString("supervisionNum"));// ����λ��Ŀ�ܼ�ע��֤���
				quality.setSupervisionPhone(rs.getString("supervisionPhone"));// ����λ��Ŀ�ܼ���ϵ�绰
				quality.setProbationStaff(rs.getString("probationStaff"));// ����λ��ȫ�ල����
				quality.setProbationPhone(rs.getString("probationPhone"));// ����λ��ȫ�ල��ϵ�绰
				quality.setProbationNum(rs.getString("probationNum"));// ����λ��ȫ�ලע��֤���
				quality.setProbationSafeNum(rs.getString("probationSafeNum"));// ����λ��ȫ�ල��ȫ����֤��
				quality.setContractName(rs.getString("contractName"));// ʩ���ܳа���λȫ��
				quality.setContractAdmin(rs.getString("contractAdmin"));// ʩ���ܳа���λ��˾��ȫ����
				quality.setContractPhone(rs.getString("contractPhone"));// ʩ���ܳа���λ��ϵ�绰
				quality.setContractStaff(rs.getString("contractStaff"));// ʩ���ܳа���λ������
				quality.setContractSafeNum(rs.getString("contractSafeNum"));// ʩ���ܳа���λ��ȫ����֤��
				quality.setContractProStaff(rs.getString("contractProStaff"));// ʩ���ܳа���λ��Ŀ����������
				quality.setContractProStaffPhone(rs
						.getString("contractProStaffPhone"));// ʩ���ܳа���λ��Ŀ��������ϵ�绰
				quality.setContractStaffRegNum(rs
						.getString("contractStaffRegNum"));// ʩ���ܳа���λ��Ŀ������ע��֤��
				quality.setContractStaffNum(rs.getString("contractStaffNum"));// ʩ���ܳа���λ��Ŀ�����˰�ȫ����֤��
				// quality.setSingleNum(rs.getString("singleNum"));//��λ���̱��
				quality.setUnitProject(rs.getString("unitProject"));// ��λ����
				quality.setScale(rs.getString("scale"));// ������ģ
				quality.setCost(rs.getString("cost"));// �������
				quality.setStructure(rs.getString("structure"));// �ṹ/���
				quality.setHeight(rs.getString("height"));// �����߶�

				// ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա
				List<ConstructionSafety> cs = new ArrayList<ConstructionSafety>();
				pstmt = conn
						.prepareStatement("select * from CONSTRUCTION_SAFETY "
								+ "where safetyId=?");
				pstmt.setString(1, safetyId);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					ConstructionSafety constructionSafety = new ConstructionSafety();
					constructionSafety.setConsId(rs.getString("consId"));
					constructionSafety.setPrjId(rs.getString("prjId"));
					constructionSafety.setSafetyId(safetyId);
					constructionSafety.setSafetyManagecheckNum(rs
							.getString("safetyManagecheckNum"));
					constructionSafety.setSafetyManageNum(rs
							.getString("safetyManageNum"));
					constructionSafety.setSafetyManageName(rs
							.getString("SafetyManageName"));
					cs.add(constructionSafety);
				}

				// רҵ�ְ���λ
				List<Major> majors = new ArrayList<Major>();
				pstmt = conn
						.prepareStatement("select * from SAFETY_MAJOR where safetyId=?");
				pstmt.setString(1, safetyId);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Major major = new Major();
					major.setMajorId(rs.getString("majorId"));
					major.setMajorLicenseDate(rs.getDate("majorLicenseDate"));
					major.setMajorCardNum(rs.getString("majorCardNum"));
					major.setMajorName(rs.getString("majorName"));
					major.setMajorPhone(rs.getString("majorPhone"));
					major.setMajorProject(rs.getString("majorProject"));
					major.setMajorStaff(rs.getString("majorStaff"));
					major.setPrjId(rs.getString("prjId"));
					major.setSafetyId(safetyId);
					majors.add(major);
				}

				// ����ְ���λ
				List<Labour> labours = new ArrayList<Labour>();
				pstmt = conn.prepareStatement("select * from SAFETY_LABOURS "
						+ "where safetyId=?");
				pstmt.setString(1, safetyId);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Labour labour = new Labour();
					labour.setLabourId(rs.getString("labourId"));
					labour.setLabourLicenseDate(rs.getDate("labourLicenseDate"));
					labour.setLabourName(rs.getString("labourName"));
					labour.setLabourPhone(rs.getString("labourPhone"));
					labour.setLabourStaff(rs.getString("labourStaff"));
					labour.setPrjId(rs.getString("prjId"));
					labour.setSafetyId(safetyId);
					labours.add(labour);
				}

				quality.setCsList(cs);
				quality.setMajors(majors);
				quality.setLabours(labours);
			}

			pstmt = conn
					.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1, safetyId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while (rs.next()) {
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			quality.setList(list);
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
	public String applySuccess(Safety safe) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			// Calendar c = Calendar.getInstance();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyMMdd");
			// String fDate = simpleDateFormat.format(c.getTime());
			// String serNum = PrjCode.querySerNuma(safe.getCreateDate(), 6);
			// String safeNum = safe.getAppDept() + fDate
			// + safe.getPrjNum().substring(12, 16) + "-SA-" + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE TB_SAFETYSUPERVISION set APPTYPE = 1 , PROCESSSTEPS = 5 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ? , OVERSIGHTNUM = ? where SAFETYID = ?");
			pstmt.setString(1, safe.getAppSteffId());
			pstmt.setString(2, safe.getAppSteffName());
			pstmt.setDate(3, safe.getAppDate());
			pstmt.setString(4, safe.getAppOpinion());
			pstmt.setString(5, safe.getOversightNum());
			pstmt.setString(6, safe.getSafetyId());
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
	public String applyFaile(Safety safe) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE TB_SAFETYSUPERVISION set APPTYPE = 2 , PROCESSSTEPS = 4 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ? where SAFETYID = ?");
			pstmt.setString(1, safe.getAppSteffId());
			pstmt.setString(2, safe.getAppSteffName());
			pstmt.setDate(3, safe.getAppDate());
			pstmt.setString(4, safe.getAppOpinion());
			pstmt.setString(5, safe.getSafetyId());
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
	 * ��ѯ���������Ƿ����
	 */
	@Override
	public String queryQuality(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_QUALITYSUPERVISION  where PRJNUM='"
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
	 * ���������Ļ�����Ϣ
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
		String sql = "select * from UPLOAD_FILE where LINKNAME='��ȫ�ල����' and ID = '"
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
	 * ������������
	 */
	@Override
	public String queryTypeName(String typeNum) {
		// TODO Auto-generated method stub
		String sql = "select * from PROJECT_TYPE where code = '" + typeNum
				+ "'";
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = rs.getString("NAMES");
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
	 * ͨ������״̬
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
