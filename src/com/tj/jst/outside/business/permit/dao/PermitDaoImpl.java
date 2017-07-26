package com.tj.jst.outside.business.permit.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ʩ�����
 * @author hhc
 *
 */
public class PermitDaoImpl extends BaseDao implements IPermitDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					Permit permit = new Permit();
					permit.setPermitId(rs.getString("permitId"));//����
					permit.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					permit.setPrjName(rs.getString("prjName"));//��Ŀ����
					permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//ʩ�����֤���
					permit.setBuldPlanNum(rs.getString("buldPlanNum"));//�����õع滮���֤���
					permit.setProjectPlanNum(rs.getString("projectPlanNum"));//���蹤�̹滮���֤���
					permit.setCensorNum(rs.getString("censorNum"));//ʩ��ͼ���ϸ�����
					permit.setContractMoney(rs.getString("contractMoney"));//��ͬ���(��Ԫ)
					permit.setArea(rs.getString("area"));//���(ƽ����)
					permit.setPrjSize(rs.getString("prjSize"));//�����ģ
					permit.setIssueCertDate(rs.getDate("issueCertDate"));//��֤����
					permit.setEconCorpName(rs.getString("econCorpName"));//���쵥λ����
					permit.setEconCorpCode(rs.getString("econCorpCode"));//���쵥λ��֯��������
					permit.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
					permit.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
					permit.setConsCorpname(rs.getString("consCorpname"));//ʩ����λ����
					permit.setConsCorpCode(rs.getString("consCorpCode"));//ʩ����λ��֯��������
					permit.setSafetyCerId(rs.getString("safetyCerId"));//ʩ����λ��ȫ�������֤���
					permit.setSuperCorpName(rs.getString("superCorpName"));//����λ����     
					permit.setSuperCorpCode(rs.getString("superCorpCode"));//����λ��֯��������
					permit.setConstructorName(rs.getString("constructorName"));//��Ŀ��������
					permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));//��Ŀ����֤������(TBIDCARDTYPEDIC)
					permit.setConstructorIdCard(rs.getString("constructorIdCard"));//��Ŀ����֤������
					permit.setSupervisionName(rs.getString("supervisionName"));//�ܼ�����ʦ����
					permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));//�ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
					permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));//�ܼ�����ʦ����
					permit.setUserName(rs.getString("userName"));//��ȫ����������Ա����
					permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));//��ȫ��������֤������(TBIDCARDTYPEDIC)
					permit.setIdCard(rs.getString("idCard"));//��ȫ����������Ա֤����
					permit.setCertId(rs.getString("certId"));//��ȫ�������˺ϸ�֤����
					permit.setUserType(rs.getString("userType"));//��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
					permit.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
					permit.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					permit.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
					permit.setAppSteffId(rs.getString("appSteffId"));//������id
					permit.setAppSteffName(rs.getString("appSteffName"));//����������
					permit.setAppDate(rs.getDate("appDate"));//����ʱ��
					permit.setAppOpinion(rs.getString("appOpinion"));//�������
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					permit.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					permit.setProcessSteps(rs.getString("processSteps").trim());
					if(rs.getString("appDept")!=null)
					{
						permit.setAppDept(rs.getString("appDept").trim());//������λid
					}else
					{
						permit.setAppDept(rs.getString("appDept"));//������λid
					}
					
					permit.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
					page.getData().add(permit);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	/**
	 * ʩ���������
	 * @return
	 */
	public String add(Permit permit)
	{
		String permitId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into tbbuilderlicencemanage(permitId,PRJNUM,PRJNAME,"
					+ "buldPlanNum,projectPlanNum,censorNum,contractMoney,"
					+ "area,prjSize,issueCertDate,econCorpName,econCorpCode,designCorpName,"
					+ "designCorpCode,consCorpName,"
					+ "consCorpCode,safetyCerId,superCorpName,superCorpCode,"
					+ "constructorName,cidCardTypeNum,constructorIdCard,supervisionName,"
					+ "sidCardTypeNum,supervisionIdCard,userName,idCardTypeNum,idCard,"
					+ "certId,userType,prjId,createDate,applyCorpCode,applyCorpName,"
					+ "appType,processSteps,appDept,appDeptName,projectName,"
					+ "builderLicenceNum,tenderNum,sectionName,qualityNum,safetyNum,"
					+ "starDate,endDate,timeLimit) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,permitId);//����
			pstmt.setString(2,permit.getPrjNum());//��Ŀ���
			pstmt.setString(3,permit.getPrjName());//��Ŀ����
			pstmt.setString(4,permit.getBuldPlanNum());//�����õع滮���֤���
			pstmt.setString(5,permit.getProjectPlanNum());//���蹤�̹滮���֤���
			pstmt.setString(6,permit.getCensorNum());//ʩ��ͼ���ϸ�����
			pstmt.setString(7,permit.getContractMoney());//��ͬ���(��Ԫ)
			pstmt.setString(8,permit.getArea());//���(ƽ����)
			pstmt.setString(9,permit.getPrjSize());//�����ģ
			pstmt.setDate(10, permit.getIssueCertDate());//��֤����
			pstmt.setString(11,permit.getEconCorpName());//���쵥λ����
			pstmt.setString(12,permit.getEconCorpCode());//���쵥λ��֯��������
			pstmt.setString(13,permit.getDesignCorpName());//��Ƶ�λ����
			pstmt.setString(14,permit.getDesignCorpCode());//��Ƶ�λ��֯��������
			pstmt.setString(15,permit.getConsCorpname());//ʩ����λ����
			pstmt.setString(16,permit.getConsCorpCode());//ʩ����λ��֯��������
			pstmt.setString(17,permit.getSafetyCerId());//ʩ����λ��ȫ�������֤���
			pstmt.setString(18,permit.getSuperCorpName());//����λ����
			pstmt.setString(19,permit.getSuperCorpCode());//����λ��֯��������
			pstmt.setString(20,permit.getConstructorName());//��Ŀ��������
			pstmt.setString(21,permit.getCidCardTypeNum());//��Ŀ����֤������(TBIDCARDTYPEDIC)
			pstmt.setString(22,permit.getConstructorIdCard());//��Ŀ����֤������
			pstmt.setString(23,permit.getSupervisionName());//�ܼ�����ʦ����
			pstmt.setString(24,permit.getSidCardTypeNum());//�ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
			pstmt.setString(25,permit.getSupervisionIdCard());//�ܼ�����ʦ����
			pstmt.setString(26,permit.getUserName());//��ȫ����������Ա����
			pstmt.setString(27,permit.getIdCardTypeNum());//��ȫ��������֤������(TBIDCARDTYPEDIC)
			pstmt.setString(28,permit.getIdCard());//��ȫ����������Ա֤����
			pstmt.setString(29,permit.getCertId());//��ȫ�������˺ϸ�֤����
			pstmt.setString(30,permit.getUserType());//��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
			pstmt.setString(31,permit.getPrjId());//��Ŀ��������
			pstmt.setDate(32,new Date(new java.util.Date().getTime())); //��¼�Ǽ�����
			pstmt.setString(33,permit.getApplyCorpCode()); //������ҵ��֯��������
			pstmt.setString(34,permit.getApplyCorpName()); //������ҵ����
			/**
			 * ����״̬
			 * 0�����룬1������ͨ����2������δͨ��
			 */
			pstmt.setString(35,"0");//����״̬
			/**
			 * ���̲���
			 * 1:��Ŀ����
			 * 2:����׶Ρ���ƽ׶�
			 * 3:��ͬ������ʩ��ͼ��鱸��
			 * 4:�����ල����ȫ�ල
			 * 5:ʩ�����
			 * 6:��������
			 */
			pstmt.setString(36,"5");
			pstmt.setString(37,permit.getAppDept());//������λid
			pstmt.setString(38,permit.getAppDeptName());//������λ����
			pstmt.setString(39, permit.getProjectName());//��������
			pstmt.setString(40, permit.getBuilderLicenceNum());
			pstmt.setString(41, permit.getTenderNum());
			pstmt.setString(42, permit.getSectionName());
			pstmt.setString(43, permit.getQualityNum());
			pstmt.setString(44, permit.getSafetyNum());
			pstmt.setDate(45, permit.getStarDate());
			pstmt.setDate(46, permit.getEndDate());
			pstmt.setString(47, permit.getTimeLimit());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBPROJECTINFO_S set buldPlanNum=?,"
					+ "projectPlanNum=? where prjNum=?");
			pstmt.setString(1, permit.getBuldPlanNum());
			pstmt.setString(2, permit.getProjectPlanNum());
			pstmt.setString(3, permit.getPrjNum());
			pstmt.executeUpdate();
			
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
		return permitId;
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Permit queryById(String permitId)
	{

		Permit permit = new Permit();
		try {
			
			String qsql = "select * from tbbuilderlicencemanage where permitId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, permitId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				
				permit.setPermitId(rs.getString("permitId"));//����
				permit.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				permit.setPrjId(rs.getString("prjId"));//������Ŀ����
				permit.setPrjName(rs.getString("prjName"));//��Ŀ����
				permit.setProjectName(rs.getString("projectName"));//��������
				permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//ʩ�����֤���
				permit.setBuldPlanNum(rs.getString("buldPlanNum"));//�����õع滮���֤���
				permit.setProjectPlanNum(rs.getString("projectPlanNum"));//���蹤�̹滮���֤���
				permit.setCensorNum(rs.getString("censorNum"));//ʩ��ͼ���ϸ�����
				permit.setContractMoney(rs.getString("contractMoney"));//��ͬ���(��Ԫ)
				permit.setArea(rs.getString("area"));//���(ƽ����)
				permit.setPrjSize(rs.getString("prjSize"));//�����ģ
				permit.setIssueCertDate(rs.getDate("issueCertDate"));//��֤����
				permit.setEconCorpName(rs.getString("econCorpName"));//���쵥λ����
				permit.setEconCorpCode(rs.getString("econCorpCode"));//���쵥λ��֯��������
				permit.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
				permit.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
				permit.setConsCorpname(rs.getString("consCorpname"));//ʩ����λ����
				permit.setConsCorpCode(rs.getString("consCorpCode"));//ʩ����λ��֯��������
				permit.setSafetyCerId(rs.getString("safetyCerId"));//ʩ����λ��ȫ�������֤���
				permit.setSuperCorpName(rs.getString("superCorpName"));//����λ����     
				permit.setSuperCorpCode(rs.getString("superCorpCode"));//����λ��֯��������
				permit.setConstructorName(rs.getString("constructorName"));//��Ŀ��������
				permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));//��Ŀ����֤������(TBIDCARDTYPEDIC)
				permit.setConstructorIdCard(rs.getString("constructorIdCard"));//��Ŀ����֤������
				permit.setSupervisionName(rs.getString("supervisionName"));//�ܼ�����ʦ����
				permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));//�ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
				permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));//�ܼ�����ʦ����
				permit.setUserName(rs.getString("userName"));//��ȫ����������Ա����
				permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));//��ȫ��������֤������(TBIDCARDTYPEDIC)
				permit.setIdCard(rs.getString("idCard"));//��ȫ����������Ա֤����
				permit.setCertId(rs.getString("certId"));//��ȫ�������˺ϸ�֤����
				permit.setUserType(rs.getString("userType"));//��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
				permit.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				permit.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				permit.setAppSteffId(rs.getString("appSteffId"));//������id
				permit.setAppSteffName(rs.getString("appSteffName"));//����������
				permit.setAppDate(rs.getDate("appDate"));//����ʱ��
				permit.setAppOpinion(rs.getString("appOpinion"));//�������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				permit.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				permit.setProcessSteps(rs.getString("processSteps").trim());
				if(rs.getString("appDept")!=null)
				{
					permit.setAppDept(rs.getString("appDept").trim());//������λid
				}else
				{
					permit.setAppDept(rs.getString("appDept"));//������λid
				}
				permit.setAppDept(rs.getString("appDept").trim());//������λid
				permit.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				permit.setTenderNum(rs.getString("tenderNum"));
				permit.setSectionName(rs.getString("sectionName"));
				permit.setQualityNum(rs.getString("qualityNum"));
				permit.setSafetyNum(rs.getString("safetyNum"));
				permit.setStarDate(rs.getDate("starDate"));
				permit.setEndDate(rs.getDate("endDate"));
				permit.setTimeLimit(rs.getString("timeLimit"));
				
			}
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=6 order by num");
			rs = pstmt.executeQuery();
			List<Accessory> accessoryList = new ArrayList<Accessory>();
			while(rs.next())
			{
				Accessory acc = new Accessory();
				acc.setId(rs.getString("id"));
				acc.setLinkNum(rs.getString("linkNum"));
				acc.setLinkName(rs.getString("linkName"));
				acc.setMessage(rs.getString("message"));
				
				
				pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=? and ACCESSOTYID=? ");
				pstmt.setString(1,permitId);
				pstmt.setString(2, acc.getId());
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
				acc.setList(list);
				accessoryList.add(acc);
			}
			permit.setAccessoryList(accessoryList);
		} catch (SQLException e) {
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
		return permit;
	}
	
	/**
	 * ʩ����������޸�
	 * @return
	 */
	public void modify(Permit permit)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update tbbuilderlicencemanage set PRJNUM=?,PRJNAME=?,"
					+ "buldPlanNum=?,projectPlanNum=?,censorNum=?,contractMoney=?,"
					+ "area=?,prjSize=?,econCorpName=?,econCorpCode=?,designCorpName=?,"
					+ "designCorpCode=?,consCorpName=?,"
					+ "consCorpCode=?,safetyCerId=?,superCorpName=?,superCorpCode=?,"
					+ "constructorName=?,cidCardTypeNum=?,constructorIdCard=?,"
					+ "supervisionName=?,sidCardTypeNum=?,supervisionIdCard=?,"
					+ "userName=?,idCardTypeNum=?,idCard=?,certId=?,userType=?,"
					+ "projectName=?,tenderNum=?,sectionName=?,STARDATE=?,ENDDATE=?, "
					+ " TIMELIMIT=? where permitId=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,permit.getPrjNum());//��Ŀ���
			pstmt.setString(2,permit.getPrjName());//��Ŀ����
			pstmt.setString(3,permit.getBuldPlanNum());//�����õع滮���֤���
			pstmt.setString(4,permit.getProjectPlanNum());//���蹤�̹滮���֤���
			pstmt.setString(5,permit.getCensorNum());//ʩ��ͼ���ϸ�����
			pstmt.setString(6,permit.getContractMoney());//��ͬ���(��Ԫ)
			pstmt.setString(7,permit.getArea());//���(ƽ����)
			pstmt.setString(8,permit.getPrjSize());//�����ģ
			pstmt.setString(9,permit.getEconCorpName());//���쵥λ����
			pstmt.setString(10,permit.getEconCorpCode());//���쵥λ��֯��������
			pstmt.setString(11,permit.getDesignCorpName());//��Ƶ�λ����
			pstmt.setString(12,permit.getDesignCorpCode());//��Ƶ�λ��֯��������
			pstmt.setString(13,permit.getConsCorpname());//ʩ����λ����
			pstmt.setString(14,permit.getConsCorpCode());//ʩ����λ��֯��������
			pstmt.setString(15,permit.getSafetyCerId());//ʩ����λ��ȫ�������֤���
			pstmt.setString(16,permit.getSuperCorpName());//����λ����
			pstmt.setString(17,permit.getSuperCorpCode());//����λ��֯��������
			pstmt.setString(18,permit.getConstructorName());//��Ŀ��������
			pstmt.setString(19,permit.getCidCardTypeNum());//��Ŀ����֤������(TBIDCARDTYPEDIC)
			pstmt.setString(20,permit.getConstructorIdCard());//��Ŀ����֤������
			pstmt.setString(21,permit.getSupervisionName());//�ܼ�����ʦ����
			pstmt.setString(22,permit.getSidCardTypeNum());//�ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
			pstmt.setString(23,permit.getSupervisionIdCard());//�ܼ�����ʦ����
			pstmt.setString(24,permit.getUserName());//��ȫ����������Ա����
			pstmt.setString(25,permit.getIdCardTypeNum());//��ȫ��������֤������(TBIDCARDTYPEDIC)
			pstmt.setString(26,permit.getIdCard());//��ȫ����������Ա֤����
			pstmt.setString(27,permit.getCertId());//��ȫ�������˺ϸ�֤����
			pstmt.setString(28,permit.getUserType());//��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
			pstmt.setString(29, permit.getProjectName());//��������
			pstmt.setString(30, permit.getTenderNum());
			pstmt.setString(31, permit.getSectionName());
			pstmt.setDate(32, permit.getStarDate());
			pstmt.setDate(33, permit.getEndDate());
			pstmt.setString(34, permit.getTimeLimit());
			pstmt.setString(35,permit.getPermitId());//����
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBPROJECTINFO_S set buldPlanNum=?,"
					+ "projectPlanNum=? where prjNum=?");
			pstmt.setString(1, permit.getBuldPlanNum());
			pstmt.setString(2, permit.getProjectPlanNum());
			pstmt.setString(3, permit.getPrjNum());
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
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String permitId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from tbbuilderlicencemanage where permitId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, permitId);//����
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,permitId);	
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
			pstmt.setString(1,permitId);	
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
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		//��ѯ������
		String sql = "select * from TBXZQDMDIC where name like '%������%'";
		List<Regional> list = new ArrayList<Regional>();
		//ʡId
		String prId = "";
		//��Id
		List<String> citys = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Regional regional = new Regional();
				regional.setId(rs.getString("code"));
				regional.setpId("-1");
				regional.setName(rs.getString("name"));
				regional.setOpen("true");
				prId = regional.getId();
				list.add(regional);
			}
			//��ѯ��
			pstmt = conn.prepareStatement("select * from TBXZQDMDIC where code like '23%00' and code !='230000'");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Regional regional = new Regional();
				regional.setId(rs.getString("code"));
				regional.setpId(prId);
				regional.setName(rs.getString("name"));
				regional.setOpen("true");
				citys.add(regional.getId());
				list.add(regional);
			}
			//��ѯ����
			for(int i=0;i<citys.size();i++)
			{
				String star = citys.get(i).substring(0, 4);
				pstmt = conn.prepareStatement("select * from TBXZQDMDIC where code like '"+star+"%' and code != '"+citys.get(i)+"'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					Regional regional = new Regional();
					regional.setId(rs.getString("code"));
					regional.setpId(citys.get(i));
					regional.setName(rs.getString("name"));
					list.add(regional);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	/**
	 * ������������id��ѯ�������
	 * @param appDept
	 * @return
	 */
	public String queryAppDeptId(String appDept)
	{
		String sql = "select code from TBXZQDMDIC_APP where sortnum=?";
		String code = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, appDept);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				code = rs.getString("code");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return code;
	}

	//֤������
	public List<DictionaryClass> queryCardTypeNums()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from TBIDCARDTYPEDIC ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("PAPERTYPE"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	
	/**
	 * ʩ�����,������Ϣ��ѯ
	 * @author Administrator
	 *
	 */
	public Page pagedQueryQuality(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
				Quality qu = new Quality();
				qu.setPrjName(rs.getString("prjName"));//��Ŀ����
				qu.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				qu.setQualityNum(rs.getString("qualityNum"));//��������
				qu.setTenderNum(rs.getString("tenderNum"));//�б�֪ͨ����
				qu.setSectionName(rs.getString("sectionName"));//�������
				qu.setProjectName(rs.getString("projectName"));//��������
				qu.setConstructionArea(rs.getString("constructionArea"));//���
				qu.setSurveyUnit(rs.getString("SURVEYUNIT"));//���쵥λȫ��
				qu.setSurveyCode(rs.getString("econcorpcode"));//���쵥λ��֯��������
				qu.setDesignUnit(rs.getString("DESIGNUNIT"));//��Ƶ�λȫ��
				qu.setDesignCode(rs.getString("designcorpcode"));//��Ƶ�λ��֯��������
				qu.setConstructionUnit(rs.getString("CONSTRUCTIONUNIT"));//ʩ���ܳа���λȫ��
				qu.setConstructionCode(rs.getString("conscorpcode"));//ʩ���ܳа���λ��֯��������
				qu.setContractMoney(rs.getString("contractmoney"));//��ͬ���
				qu.setPrjId(rs.getString("prjId"));
				qu.setCreateDate(rs.getDate("createDate"));
				page.getData().add(qu);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}
	
	/**
	 * ʩ�����,��ȫ��Ϣ��ѯ
	 * @author Administrator
	 *
	 */
	public Page pagedQueryPermSafety(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
				Safety sf = new Safety();
				sf.setPrjNum(rs.getString("prjNum"));
				sf.setPrjName(rs.getString("prjName"));
				sf.setSafetyNum(rs.getString("safetyNum"));//��ȫ�ල����
				sf.setSupervisionName(rs.getString("supervisionName"));//����λȫ��
				sf.setContractorCorpCode(rs.getString("contractorCorpCode"));//����λ��֯��������
				sf.setSupervisionStaff(rs.getString("supervisionStaff"));//����λ��Ŀ�ܼ�����
				sf.setSupervisionNum(rs.getString("supervisionNum"));//����λ��Ŀ�ܼ�ע��֤���
				sf.setProbationStaff(rs.getString("probationStaff"));//����λ��ȫ�ල����
				sf.setProbationSafeNum(rs.getString("probationSafeNum"));//����λ��ȫ�ල��ȫ����֤��
				sf.setContractstart(rs.getDate("PROSTARTDATE"));//��ͬ��������
				sf.setContractend(rs.getDate("PROENDDATE"));//��ͬ��������
				sf.setCreateDate(rs.getDate("createDate"));
				page.getData().add(sf);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}
	
	/**
	 * ʩ�����,ʩ��ͼ���ϸ�����
	 * @param condition
	 * @return
	 */
	public Page pagedQueryPlanNum(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs != null)
			{
				while (rs.next()) {
					ConstructionPlans plans = new ConstructionPlans();
					//ʩ��ͼ����������
					plans.setCensorCorpName(rs.getString("censorCorpName"));
					//��Ŀ����
					plans.setPrjName(rs.getString("prjName"));
					//֤����
					plans.setCensorNum(rs.getString("censorNum"));
					page.getData().add(plans);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}
}
