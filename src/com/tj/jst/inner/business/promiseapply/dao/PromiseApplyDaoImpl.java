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
 * ʩ��������ݿ���
 * 
 * @author DarkFlameMaster
 *
 */
public class PromiseApplyDaoImpl extends BaseDao implements IPromiseApplyDao {

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
					Permit permit = new Permit();
					permit.setPrjId(rs.getString("prjId"));
					permit.setPermitId(rs.getString("permitId"));// ����
					permit.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					permit.setProjectName(rs.getString("projectName"));// ��������
					permit.setPrjName(rs.getString("prjName"));// ��Ŀ����
					permit.setBuilderLicenceNum(rs
							.getString("builderLicenceNum"));// ʩ�����֤���
					permit.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
					permit.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
					permit.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�����
					permit.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
					permit.setArea(rs.getString("area"));// ���(ƽ����)
					permit.setPrjSize(rs.getString("prjSize"));// �����ģ
					permit.setIssueCertDate(rs.getDate("issueCertDate"));// ��֤����
					permit.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
					permit.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
					permit.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
					permit.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
					permit.setConsCorpname(rs.getString("consCorpname"));// ʩ����λ����
					permit.setConsCorpCode(rs.getString("consCorpCode"));// ʩ����λ��֯��������
					permit.setSafetyCerId(rs.getString("safetyCerId"));// ʩ����λ��ȫ�������֤���
					permit.setSuperCorpName(rs.getString("superCorpName"));// ����λ����
					permit.setSuperCorpCode(rs.getString("superCorpCode"));// ����λ��֯��������
					permit.setConstructorName(rs.getString("constructorName"));// ��Ŀ��������
					permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));// ��Ŀ����֤������(TBIDCARDTYPEDIC)
					permit.setConstructorIdCard(rs
							.getString("constructorIdCard"));// ��Ŀ����֤������
					permit.setSupervisionName(rs.getString("supervisionName"));// �ܼ�����ʦ����
					permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));// �ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
					permit.setSupervisionIdCard(rs
							.getString("supervisionIdCard"));// �ܼ�����ʦ����
					permit.setUserName(rs.getString("userName"));// ��ȫ����������Ա����
					permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));// ��ȫ��������֤������(TBIDCARDTYPEDIC)
					permit.setIdCard(rs.getString("idCard"));// ��ȫ����������Ա֤����
					permit.setCertId(rs.getString("certId"));// ��ȫ�������˺ϸ�֤����
					permit.setUserType(rs.getString("userType"));// ��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
					permit.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					permit.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					permit.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					permit.setAppSteffId(rs.getString("appSteffId"));// ������id
					permit.setAppSteffName(rs.getString("appSteffName"));// ����������
					permit.setAppDate(rs.getDate("appDate"));// ����ʱ��
					permit.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					permit.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					permit.setProcessSteps(rs.getString("processSteps").trim());
					permit.setAppDept(rs.getString("appDept").trim());// ������λid
					permit.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
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
	 * ��ѯ��ϸ
	 */
	@Override
	public Permit queryApproval(String permitId) {
		// TODO Auto-generated method stub
		Permit permit = new Permit();
		try {

			String qsql = "select * from tbbuilderlicencemanage where permitId=?";
			// ��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, permitId);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				permit.setPrjId(rs.getString("prjId"));
				permit.setPermitId(rs.getString("permitId"));// ����
				permit.setProjectName(rs.getString("projectName"));// ��������
				permit.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				permit.setPrjName(rs.getString("prjName"));// ��Ŀ����
				permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// ʩ�����֤���
				permit.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
				permit.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
				permit.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�����
				permit.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
				permit.setArea(rs.getString("area"));// ���(ƽ����)
				permit.setPrjSize(rs.getString("prjSize"));// �����ģ
				permit.setIssueCertDate(rs.getDate("issueCertDate"));// ��֤����
				permit.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
				permit.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
				permit.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
				permit.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
				permit.setConsCorpname(rs.getString("consCorpname"));// ʩ����λ����
				permit.setConsCorpCode(rs.getString("consCorpCode"));// ʩ����λ��֯��������
				permit.setSafetyCerId(rs.getString("safetyCerId"));// ʩ����λ��ȫ�������֤���
				permit.setSuperCorpName(rs.getString("superCorpName"));// ����λ����
				permit.setSuperCorpCode(rs.getString("superCorpCode"));// ����λ��֯��������
				permit.setConstructorName(rs.getString("constructorName"));// ��Ŀ��������
				permit.setCidCardTypeNum(rs.getString("cidCardTypeNum").trim());// ��Ŀ����֤������(TBIDCARDTYPEDIC)
				permit.setConstructorIdCard(rs.getString("constructorIdCard"));// ��Ŀ����֤������
				permit.setSupervisionName(rs.getString("supervisionName"));// �ܼ�����ʦ����
				permit.setSidCardTypeNum(rs.getString("sidCardTypeNum").trim());// �ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
				permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));// �ܼ�����ʦ����
				permit.setUserName(rs.getString("userName"));// ��ȫ����������Ա����
				//permit.setIdCardTypeNum(rs.getString("IDCARDTYPENUM").trim());// ��ȫ��������֤������(TBIDCARDTYPEDIC)
				permit.setIdCard(rs.getString("idCard"));// ��ȫ����������Ա֤����
				permit.setCertId(rs.getString("certId"));// ��ȫ�������˺ϸ�֤����
				//permit.setUserType(rs.getString("userType").trim());// ��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
				permit.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				permit.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				permit.setAppSteffId(rs.getString("appSteffId"));// ������id
				permit.setAppSteffName(rs.getString("appSteffName"));// ����������
				permit.setAppDate(rs.getDate("appDate"));// ����ʱ��
				permit.setAppOpinion(rs.getString("appOpinion"));// �������
				permit.setProjectName(rs.getString("projectName"));
				/**
				 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				permit.setAppType(rs.getString("appType").trim());// ����״̬
				/**
				 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
				 * 6:��������
				 */
				permit.setProcessSteps(rs.getString("processSteps").trim());
				permit.setAppDept(rs.getString("appDept").trim());// ������λid
				permit.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
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
	 * ����ͨ��
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
	 * ��ɺ���Ļ�����Ϣ
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
		String sql = "select * from UPLOAD_FILE where LINKNAME='ʩ�����' and ID = '"
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
		String sql = "update TO_AUTHORIZATION set PROCESSSTEPS=6 where prjNum='"
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
