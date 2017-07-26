package com.tj.jst.inner.business.scenesafe.dao;
 
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.PrjCode;
import com.tj.jst.inner.business.scenesafe.model.ConstruScenesafe;
import com.tj.jst.inner.business.scenesafe.model.SceneSafe;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ʩ��������ݿ���
 * 
 * @author DarkFlameMaster
 *
 */
public class ScenesafeDaoImpl extends BaseDao implements ScenesafeDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;

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
					SceneSafe scenesafe = new SceneSafe();
					scenesafe.setPrjnamee(rs.getString("PRJNAME"));// ��Ŀ����
					scenesafe.setPrjnumm(rs.getString("PRJNUM"));// ��Ŀ���
					scenesafe.setBuilderlicencenum(rs.getString("BUILDERLICENCENUM"));//ʩ�����
					page.getData().add(scenesafe);
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

	@Override
	public String add(SceneSafe scenesafe,List<ConstruScenesafe> construscenesafe) {
		String permitid = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into tbscenesafe(PERMITID,PRJNAMEE,PRJNUMM,"
					+ "BUILDERLICENCENUM,JCPORSON,JCDATE,FZPORSON,DJPORSON,DJDATE,COMPANYJC,"
					+ "COMPANYKC,COMPANYSJ,COMPANYJL,COMPANYSG,NRDESCRIPTION,JCCONCLUSION,CLSUGGESTION,CLGIST,appDept) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,permitid);//����
			pstmt.setString(2,scenesafe.getPrjnamee());//��Ŀ����
			pstmt.setString(3,scenesafe.getPrjnumm());//��Ŀ���
			pstmt.setString(4,scenesafe.getBuilderlicencenum());//ʩ�����
			pstmt.setString(5,scenesafe.getJcporson());//�����
			pstmt.setDate(6,scenesafe.getJcdate());//���ʱ��
			pstmt.setString(7,scenesafe.getFzporson());//�ֳ�������
			pstmt.setString(8,scenesafe.getDjporson());//�Ǽ���
			pstmt.setDate(9,scenesafe.getDjdate());//�Ǽ�ʱ��
			pstmt.setString(10,scenesafe.getCompanyjc());//�漰���赥λ
			pstmt.setString(11,scenesafe.getCompanykc());//�漰���쵥λ
			pstmt.setString(12,scenesafe.getCompanyjl());//�漰����λ
			pstmt.setString(13,scenesafe.getCompanysj());//�漰�漰��λ
			pstmt.setString(14,scenesafe.getCompanysg());//�漰ʩ����λ
			pstmt.setString(15,scenesafe.getNrdescription());//��������
			pstmt.setString(16,scenesafe.getJcconclusion());//������
			pstmt.setString(17,scenesafe.getClsuggestion());//�������
			pstmt.setString(18,scenesafe.getClgist());//��������
			pstmt.setString(19,scenesafe.getAppDept());//��������
			pstmt.executeUpdate();	
			
			
			//�ֳ���ȫ�ල����б�
			for(int i=0;i<construscenesafe.size();i++)
			{
				
					String id = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into tbscenesafe_mz("
							+ "prjid,permitid,jcneirong,"
							+ "question,suggestion)"
							+ "values(?,?,?,?,?)");
					pstmt.setString(1,id);	
					pstmt.setString(2,permitid); 
					pstmt.setString(3,construscenesafe.get(i).getJcneirong()); 
					pstmt.setString(4,construscenesafe.get(i).getQuestion()); 
					pstmt.setString(5,construscenesafe.get(i).getSuggestion());
					pstmt.executeUpdate();	
			}
			
			
			
			
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return permitid;
	}

	@Override
	public Page pagedQuerypage(Condition condition) {
				Page page = super.basePagedQuery(condition);
				ResultSet rs = page.getRs();
				try {
					if (rs != null) {
						while (rs.next()) {
							SceneSafe scenesafe = new SceneSafe();
							scenesafe.setPermitid(rs.getString("permitid"));// ����
							scenesafe.setPrjnamee(rs.getString("PRJNAMEE"));// ��Ŀ����
							scenesafe.setPrjnumm(rs.getString("PRJNUMM"));// ��Ŀ���
							scenesafe.setBuilderlicencenum(rs.getString("BUILDERLICENCENUM"));//ʩ�����
							scenesafe.setJcporson(rs.getString("jcporson"));// �����
							scenesafe.setJcdate(rs.getDate("jcdate"));// ���ʱ��
							scenesafe.setFzporson(rs.getString("fzporson"));// �ֳ�������
							scenesafe.setDjporson(rs.getString("djporson"));// �Ǽ���
							scenesafe.setDjdate(rs.getDate("djdate"));// �Ǽ�ʱ��
							scenesafe.setCompanyjc(rs.getString("companyjc"));// �漰���赥λ
							scenesafe.setCompanyjl(rs.getString("companyjl"));// �漰���赥λ
							scenesafe.setCompanysg(rs.getString("companysg"));// �漰���赥λ
							scenesafe.setCompanykc(rs.getString("companykc"));// �漰���赥λ
							scenesafe.setCompanysj(rs.getString("companysj"));// �漰���赥λ
							scenesafe.setNrdescription(rs.getString("nrdescription"));// �����������
							scenesafe.setJcconclusion(rs.getString("jcconclusion"));//������
							scenesafe.setClgist(rs.getString("clgist"));// ��������

							page.getData().add(scenesafe);
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

	@Override
	public SceneSafe queryById(String permitid) {
		SceneSafe scenesafe = new SceneSafe();
		try {
			
			String qsql = "select * from tbscenesafe where PERMITID=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, permitid);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				scenesafe.setPermitid(rs.getString("permitid"));//����
				scenesafe.setPrjnumm(rs.getString("prjnumm"));//��Ŀ���
				scenesafe.setPrjnamee(rs.getString("prjnamee"));//��Ŀ����
				scenesafe.setJcdate(rs.getDate("jcdate"));//�������
				scenesafe.setJcporson(rs.getString("jcporson"));//�����
				scenesafe.setBuilderlicencenum(rs.getString("builderlicencenum"));//ʩ�����
				scenesafe.setFzporson(rs.getString("fzporson"));//�ֳ�������
				scenesafe.setDjporson(rs.getString("djporson"));//�Ǽ���
				scenesafe.setDjdate(rs.getDate("djdate"));//�Ǽ�ʱ��
				scenesafe.setCompanyjc(rs.getString("companyjc"));//�漰���赥λ
				scenesafe.setCompanykc(rs.getString("companykc"));//�漰���赥λ
				scenesafe.setCompanyjl(rs.getString("companyjl"));//�漰���赥λ
				scenesafe.setCompanysg(rs.getString("companysg"));//�漰���赥λ
				scenesafe.setCompanysj(rs.getString("companysj"));//�漰���赥λ
				scenesafe.setNrdescription(rs.getString("nrdescription"));//�����������
				scenesafe.setJcconclusion(rs.getString("jcconclusion"));//������
				scenesafe.setClsuggestion(rs.getString("clsuggestion"));//�������
				scenesafe.setClgist(rs.getString("clgist"));//��������
				scenesafe.setAppDept(rs.getString("appDept"));//��������
				
				//ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա
				List<ConstruScenesafe> cs = new ArrayList<ConstruScenesafe>();
				pstmt = conn.prepareStatement("select * from tbscenesafe_mz "
								+ "where PERMITID=?");
				pstmt.setString(1,permitid);	
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					ConstruScenesafe construscenesafe = new ConstruScenesafe();
					construscenesafe.setPrjid(rs.getString("prjid"));
					construscenesafe.setPermitid(permitid); 
					construscenesafe.setJcneirong(rs.getString("jcneirong"));
					construscenesafe.setQuestion(rs.getString("question"));
					construscenesafe.setSuggestion(rs.getString("suggestion"));
					cs.add(construscenesafe);
				}
				
				pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=? ");
				pstmt.setString(1,permitid);				
				uploadRs = pstmt.executeQuery();
				List<Upload> list = new ArrayList<Upload>();
				while(uploadRs.next())
				{
					Upload upload = new Upload();
					upload.setUploadId(uploadRs.getString("uploadId"));
					upload.setRoot(uploadRs.getString("root"));
					upload.setNewName(uploadRs.getString("newName"));
					upload.setLinkName(uploadRs.getString("linkName"));
					upload.setIsUnits(uploadRs.getString("isUnits"));
					upload.setId(uploadRs.getString("id"));
					upload.setFileFileName(uploadRs.getString("fileFileName"));
					list.add(upload);
				}
				
				
				scenesafe.setList(list);
				scenesafe.setConstruscenesafe(cs); 
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if(uploadRs!=null)
			{
				try {
					uploadRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return scenesafe;
	}

	@Override
	public void delete(String permitid) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from tbscenesafe where PERMITID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, permitid);//����
			pstmt.executeUpdate();
			
			//�ֳ�������ȫ�ල��ϸ
			pstmt = conn.prepareStatement("delete from tbscenesafe_mz where PERMITID=?");
			pstmt.setString(1, permitid);
			pstmt.executeUpdate();
		
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,permitid);	
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				try {
					File myDelFile = new File(rs.getString("root")+"\\"+rs.getString("newName"));
					if (myDelFile.exists())
						myDelFile.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			pstmt = conn.prepareStatement("delete from UPLOAD_FILE where id=?");
			pstmt.setString(1,permitid);	
			pstmt.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
	}

	@Override
	public void modify(SceneSafe scenesafe,List<ConstruScenesafe> construscenesafe) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update tbscenesafe set prjnamee=?,"
					+ "prjnumm=?,"
					+ "builderlicencenum=?,jcporson=?,"
					+ "jcdate=?,fzporson=?,djporson=?,djdate=?,companyjc=?,"
					+ "companykc=?,companysj=?,companyjl=?,companysg=?,nrdescription=?,jcconclusion=?,"
					+ "clsuggestion=?,clgist=?,appDept=? where permitid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,scenesafe.getPrjnamee());//��Ŀ����
			pstmt.setString(2,scenesafe.getPrjnumm());//��Ŀ���
			pstmt.setString(3,scenesafe.getBuilderlicencenum());//ʹ�����
			pstmt.setString(4,scenesafe.getJcporson());//�����
			pstmt.setDate(5,scenesafe.getJcdate());//���ʱ��
			pstmt.setString(6,scenesafe.getFzporson());//�ֳ�������
			pstmt.setString(7,scenesafe.getDjporson());//�Ǽ���
			pstmt.setDate(8,scenesafe.getDjdate());//�Ǽ�ʱ��
			pstmt.setString(9,scenesafe.getCompanyjc());//��Ŀ���
			pstmt.setString(10,scenesafe.getCompanykc());//��Ŀ���
			pstmt.setString(11,scenesafe.getCompanysj());//��Ŀ���
			pstmt.setString(12,scenesafe.getCompanyjl());//��Ŀ���
			pstmt.setString(13,scenesafe.getCompanysg());//��Ŀ���
			pstmt.setString(14,scenesafe.getNrdescription());//�����������
			pstmt.setString(15,scenesafe.getJcconclusion());//������
			pstmt.setString(16,scenesafe.getClsuggestion());//�������
			pstmt.setString(17,scenesafe.getClgist());//��������
			pstmt.setString(18,scenesafe.getAppDept());//��������
			pstmt.setString(19,scenesafe.getPermitid());//����
			pstmt.executeUpdate();
			//��ϸ
			pstmt = conn.prepareStatement("delete from tbscenesafe_mz where PERMITID=?");
			pstmt.setString(1,scenesafe.getPermitid()); 
			pstmt.executeUpdate();
			for(int i=1;i<construscenesafe.size();i++)
			{
			
				 
					String labourId = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into tbscenesafe_mz("
							+ "prjid,permitid,jcneirong,"
							+ "question,suggestion)"
							+ "values(?,?,?,?,?)");
					pstmt.setString(1,labourId);	
					pstmt.setString(2,scenesafe.getPermitid()); 
					pstmt.setString(3,construscenesafe.get(i).getJcneirong()); 
					pstmt.setString(4,construscenesafe.get(i).getQuestion()); 
					pstmt.setString(5,construscenesafe.get(i).getSuggestion());
					pstmt.executeUpdate();	
				
			}
			
			
			conn.commit();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
	}

}
