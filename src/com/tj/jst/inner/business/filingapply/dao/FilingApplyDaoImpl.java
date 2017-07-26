package com.tj.jst.inner.business.filingapply.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.UtilDecode;
import com.tj.jst.inner.business.filingapply.model.ContractBusiness;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ��ͬ�������ݿ���
 * 
 * @author DarkFlameMaster
 *
 */
public class FilingApplyDaoImpl extends BaseDao implements IFilingApplyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Connection qconn = null;
	PreparedStatement qpstmt = null;
	ResultSet qrs = null;

	/**
	 * ��ҳ��
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					ContractFiling filing = new ContractFiling();
					filing.setRecordId(rs.getString("recordId"));// ����
					filing.setRecordNum(rs.getString("recordNum"));// ��ͬ�������
					filing.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					filing.setPrjName(rs.getString("prjName"));// ��Ŀ����
					filing.setContractNum(rs.getString("contractNum"));// ��ͬ���
					filing.setContractTypeNum(rs.getString("contractTypeNum"));// ��ͬ���(TBCONTRACTTYPEDIC)
					filing.setContractTypeName(rs.getString("contractTypeName"));// ��ͬ�������
					filing.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
					filing.setPrjSize(rs.getString("prjSize"));// �����ģ
					filing.setContractDate(rs.getDate("contractDate"));// ��ͬǩ������
					filing.setPropietorCorpName(rs
							.getString("propietorCorpName"));// ������λ����
					filing.setPropietorCorpCode(rs
							.getString("propietorCorpCode"));// ������λס��֯����
					filing.setContractorCorpName(rs
							.getString("contractorCorpName"));// �а���λ����
					filing.setContractorCorpCode(rs
							.getString("contractorCorpCode"));// �а���λ��֯����
					filing.setUnionCorpName(rs.getString("unionCorpName"));// ������а���λ����
					filing.setUnionCorpCode(rs.getString("unionCorpCode"));// ������а���λ��֯����
					filing.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
					filing.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					filing.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					filing.setAppSteffId(rs.getString("appSteffId"));// ������id
					filing.setAppSteffName(rs.getString("appSteffName"));// ����������
					filing.setAppDate(rs.getDate("appDate"));// ����ʱ��
					filing.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					filing.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					filing.setProcessSteps(rs.getString("processSteps").trim());
					filing.setAppDept(rs.getString("appDept").trim());// ������λid
					filing.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
					page.getData().add(filing);
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
	 * ��ת����ҳ��
	 */
	@Override
	public ContractFiling queryApproval(String recordId) {
		// TODO Auto-generated method stub
		ContractFiling filing = new ContractFiling();
		String sql = "select * from v_tbcontractrecordmanage where recordId = '"
				+ recordId + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				filing.setRecordId(rs.getString("recordId"));// ����
				filing.setRecordNum(rs.getString("recordNum"));// ��ͬ�������
				filing.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				filing.setPrjName(rs.getString("prjName"));// ��Ŀ����
				filing.setContractNum(rs.getString("contractNum"));// ��ͬ���
				filing.setContractTypeNum(rs.getString("contractTypeNum"));// ��ͬ���(TBCONTRACTTYPEDIC)
				filing.setContractTypeName(rs.getString("contractTypeName"));// ��ͬ�������
				filing.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
				filing.setPrjSize(rs.getString("prjSize"));// �����ģ
				filing.setContractDate(rs.getDate("contractDate"));// ��ͬǩ������
				filing.setPropietorCorpName(rs.getString("propietorCorpName"));// ������λ����
				filing.setPropietorCorpCode(rs.getString("propietorCorpCode"));// ������λס��֯����
				filing.setContractorCorpName(rs.getString("contractorCorpName"));// �а���λ����
				filing.setContractorCorpCode(rs.getString("contractorCorpCode"));// �а���λ��֯����
				filing.setUnionCorpName(rs.getString("unionCorpName"));// ������а���λ����
				filing.setUnionCorpCode(rs.getString("unionCorpCode"));// ������а���λ��֯����
				filing.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
				filing.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				filing.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				filing.setAppSteffId(rs.getString("appSteffId"));// ������id
				filing.setAppSteffName(rs.getString("appSteffName"));// ����������
				filing.setAppDate(rs.getDate("appDate"));// ����ʱ��
				filing.setAppOpinion(rs.getString("appOpinion"));// �������
				/**
				 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				filing.setAppType(rs.getString("appType").trim());// ����״̬
				/**
				 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
				 * 6:��������
				 */
				filing.setProcessSteps(rs.getString("processSteps").trim());
				filing.setAppDept(rs.getString("appDept").trim());// ������λid
				filing.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
				filing.setSectionName(rs.getString("sectionName"));
				filing.setTenderNum(rs.getString("tenderNum"));
				filing.setProjectAddress(rs.getString("projectAddress"));
				filing.setProjectCost(rs.getString("projectCost"));
				filing.setArea(rs.getString("area"));
				filing.setConstructorName(rs.getString("constructorName"));// ��Ŀ��������
				filing.setTitleLeve(rs.getString("titleLeve"));// ���ʵȼ�
				filing.setPhone(rs.getString("phone"));// ��ϵ�绰
				filing.setQualificationsType(rs.getString("qualificationsType"));
				filing.setQualificationsTypeName(rs
						.getString("qualificationsTypeName"));
				filing.setSpecialtyType(rs.getString("specialtyType"));
				filing.setSpecialtyTypeName(rs.getString("specialtyTypeName"));
				filing.setRating(rs.getString("rating"));
				filing.setRatingName(rs.getString("ratingName"));
				// -------------------------------��Ա-----------------------------------
				filing.setTechnicalName(rs.getString("technicalName"));// ��������������
				filing.setTechnicalIdCardTypeNum(rs
						.getString("technicalIdCardTypeNum"));// ����������֤������
				filing.setTechnicalIdCard(rs.getString("technicalIdCard"));// ����������֤������
				filing.setTechnicalCertNum(rs.getString("technicalCertNum"));// ����������֤���
				filing.setQualityName(rs.getString("qualityName"));// �������Ա����
				filing.setQualityIdCardTypeNum(rs
						.getString("qualityIdCardTypeNum"));// �������Ա֤������
				filing.setQualityIdCard(rs.getString("qualityIdCard"));// �������Ա֤������
				filing.setQualityCertNum(rs.getString("qualityCertNum"));// �������Ա֤���
				filing.setSecurityName(rs.getString("securityName"));// ��ȫԱ����
				filing.setSecurityIdCardTypeNum(rs
						.getString("securityIdCardTypeNum"));// ��ȫԱ֤������
				filing.setSecurityIdCard(rs.getString("securityIdCard"));// ��ȫԱ֤������
				filing.setSecurityCertNum(rs.getString("securityCertNum"));// ��ȫԱ֤���
				filing.setConstructionName(rs.getString("constructionName"));// ʩ��Ա������������
				filing.setConstructionIdCardTypeNum(rs
						.getString("constructionIdCardTypeNum"));// ʩ��Ա��������֤������
				filing.setConstructionIdCard(rs.getString("constructionIdCard"));// ʩ��Ա��������֤������
				filing.setConstructionCertNum(rs
						.getString("constructionCertNum"));// ʩ��Ա��������֤���
				filing.setDirectorName(rs.getString("directorName"));// ��������Ա���ܼ�����
				filing.setDirectorIdCardTypeNum(rs
						.getString("directorIdCardTypeNum"));// ��������Ա���ܼ�֤������
				filing.setDirectorIdCard(rs.getString("directorIdCard"));// ��������Ա���ܼ�֤������
				filing.setDirectorCertNum(rs.getString("directorCertNum"));// ��������Ա���ܼ�֤���
				filing.setRepresEntativeName(rs.getString("represEntativeName"));// �ܼ��������
				filing.setRepresEntativeIdCardTypeNum(rs
						.getString("represEntativeIdCardTypeNum"));// �ܼ����֤������
				filing.setRepresEntativeIdCard(rs
						.getString("represEntativeIdCard"));// �ܼ����֤������
				filing.setRepresEntativeCertNum(rs
						.getString("represEntativeCertNum"));// �ܼ����֤���
				filing.setSafetyName(rs.getString("safetyName"));// ��ȫ��������
				filing.setSafetyIdCardTypeNum(rs
						.getString("safetyIdCardTypeNum"));// ��ȫ����֤������
				filing.setSafetyIdCard(rs.getString("safetyIdCard"));// ��ȫ����֤������
				filing.setMainRecordNum(rs.getString("mainRecordNum"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return filing;
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String approvalSuccess(ContractFiling filing) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			// String type = filing.getContractTypeNum();
			// switch (type) {
			// case "100":
			// type = "-HB-";
			// break;
			// case "200":
			// type = "-HA-";
			// break;
			// case "301":
			// type = "-HZ-";
			// break;
			// case "302":
			// type = "-HF-";
			// break;
			// case "303":
			// type = "-HL-";
			// break;
			// case "400":
			// type = "-HE-";
			// break;
			// case "500":
			// type = "-HC-";
			// break;
			// case "600":
			// type = "-HG-";
			// break;
			// case "700":
			// type = "-HM-";
			// break;
			//
			// }
			// Calendar c = Calendar.getInstance();
			// SimpleDateFormat simpleDateFormat = new
			// SimpleDateFormat("yyMMdd");
			// String fDate = simpleDateFormat.format(c.getTime());
			// String serNum = PrjCode.querySerNuma(filing.getCreateDate(), 3);
			// String filingNum = filing.getAppDept() + fDate
			// + filing.getPrjNum().substring(12, 16) + type + serNum;
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE tbcontractrecordmanage set APPTYPE = 1 , PROCESSSTEPS = 4 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ?  where RECORDID = ?");
			pstmt.setString(1, filing.getAppSteffId());
			pstmt.setString(2, filing.getAppSteffName());
			pstmt.setDate(3, filing.getAppDate());
			pstmt.setString(4, filing.getAppOpinion());
			pstmt.setString(5, filing.getRecordId());
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
	public String approvalFailed(ContractFiling filing) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("UPDATE tbcontractrecordmanage set APPTYPE = 2 , PROCESSSTEPS = 3 , APPSTEFFID = ? , APPSTEFFNAME = ? , APPDATE = ? , APPOPINION = ? where RECORDID = ?");
			pstmt.setString(1, filing.getAppSteffId());
			pstmt.setString(2, filing.getAppSteffName());
			pstmt.setDate(3, filing.getAppDate());
			pstmt.setString(4, filing.getAppOpinion());
			pstmt.setString(5, filing.getRecordId());
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
	public String queryPlans(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TBPROJECTCENSORINFO where PRJNUM='"
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
	 * ��������޸Ļ�����Ϣ
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
		String sql = "select * from UPLOAD_FILE where LINKNAME like '%��ͬ����%' and ID = '"
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
	 * ͨ��������Ȩ״̬
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

	/**
	 * ��ѯ��ͬ��Ϣ
	 */
	@Override
	public ContractBusiness queryByConId(String conId) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_CONTRACTINFO_BUSINESS where conId = '"
				+ conId + "'";
		String sql2 = "select * from TB_CONTRACTINFO_RECORD where conId=?";
		ContractBusiness contract = new ContractBusiness();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				contract.setConId(rs.getString("conId"));
				contract.setLinkAddress(rs.getString("linkAddress"));
				contract.setConName(rs.getString("conName"));
				contract.setZhConName(UtilDecode.transformation(rs.getString("conName")));
				contract.setConType(rs.getString("conType"));
				contract.setCreateDate(rs.getDate("createDate"));
				contract.setIsLocking(rs.getString("isLocking"));
				contract.setRecordId(rs.getString("recordId"));
				try {
					qconn = ConnectionFactory.getBasicConnection();
					qpstmt = qconn.prepareStatement(sql2);
					qpstmt.setString(1, rs.getString("conId"));
					qrs = qpstmt.executeQuery();
					if (qrs.next()) {
						contract.setADate(qrs.getString("aDate"));
						contract.setReason(qrs.getString("reason"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
			ConnectionFactory.closeConn(qconn, qpstmt, qrs);
		}
		return contract;
	}

	/**
	 * �޸ĺ�ͬ��Ϣ
	 */
	@Override
	public String modifyContractBusiness(ContractBusiness contract) {
		// TODO Auto-generated method stub
		int check = 0;
		String message = "";
		String sql = "update TB_CONTRACTINFO_BUSINESS set isLocking=?,CHECKTYPE=1 where conId=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contract.getIsLocking());
			pstmt.setString(2, contract.getConId());
			check = pstmt.executeUpdate();
			if (check == 1) {
				message = "�ɹ�";
			} else {
				message = "ʧ��";
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
	 * ������˼�¼
	 */
	@Override
	public String insertContractBusiness(ContractBusiness contract) {
		// TODO Auto-generated method stub
		String message = "";
		int check = 0;
		String recordId = UUID.randomUUID().toString();
		String sql = "insert into TB_CONTRACTINFO_RECORD(RECORDID,REASON,CREATEDATE,CONID,ADATE) values (?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getBasicConnection();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			System.out.println(sdf.format(new java.util.Date()));
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recordId);
			pstmt.setString(2, contract.getReason());
			pstmt.setDate(3, new Date(new java.util.Date().getTime()));
			pstmt.setString(4, contract.getConId());
			pstmt.setString(5, sdf.format(new java.util.Date()));
			check = pstmt.executeUpdate();
			if (check == 1) {
				message = "�ɹ�";
			} else {
				message = "ʧ��";
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
	 * ��ͬ��ҳ
	 */
	@Override
	public Page queryBusinessPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					ContractBusiness contract = new ContractBusiness();
					contract.setConId(rs.getString("conId"));
					contract.setConName(rs.getString("conName"));
					contract.setZhConName(UtilDecode.transformation(rs.getString("conName")));
					contract.setConType(rs.getString("conType"));
					contract.setCreateDate(rs.getDate("createDate"));
					contract.setIsLocking(rs.getString("isLocking"));
					contract.setCheckType(rs.getString("checkType"));
					contract.setRecordId(rs.getString("recordId"));
					page.getData().add(contract);
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
	 * ��˲�ͨ������״̬
	 * 
	 * @param recordId
	 * @return
	 */
	@Override
	public String changeBusinessType(String recordId, String type) {
		// TODO Auto-generated method stub
		String sql = "update TB_CONTRACTINFO_BUSINESS set checkType=? where recordId=?";
		String message = "";
		int check = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setString(2, recordId);
			check = pstmt.executeUpdate();
			if (check == 1) {
				message = "�ɹ�";
			} else {
				message = "ʧ��";
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
