package com.tj.jst.outside.business.constructionFiling.mainContractor.dao;

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
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.model.Certdetail;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.contractFiling.model.ProjcetTenderInfo;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ʩ����ͬ����
 * @author hhc
 *
 */
public class ConstructionContractDaoImpl extends BaseDao implements IConstructionContractDao {

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
					ContractFiling contractFiling = new ContractFiling();
					
					contractFiling.setRecordId(rs.getString("recordId"));//����
					contractFiling.setRecordNum(rs.getString("recordNum"));//��ͬ�������
					contractFiling.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					contractFiling.setPrjName(rs.getString("prjName"));//��Ŀ����
					contractFiling.setContractNum(rs.getString("contractNum"));//��ͬ���
					contractFiling.setContractTypeNum(rs.getString("contractTypeNum"));//��ͬ���(TBCONTRACTTYPEDIC)
					contractFiling.setContractTypeName(rs.getString("contractTypeName"));//��ͬ�������
					contractFiling.setContractMoney(rs.getString("contractMoney"));//��ͬ���(��Ԫ)
					contractFiling.setPrjSize(rs.getString("prjSize"));//�����ģ
					contractFiling.setContractDate(rs.getDate("contractDate"));//��ͬǩ������
					contractFiling.setPropietorCorpName(rs.getString("propietorCorpName"));//������λ����
					contractFiling.setPropietorCorpCode(rs.getString("propietorCorpCode"));//������λס��֯����
					contractFiling.setContractorCorpName(rs.getString("contractorCorpName"));//�а���λ����
					contractFiling.setContractorCorpCode(rs.getString("contractorCorpCode"));//�а���λ��֯����
					contractFiling.setUnionCorpName(rs.getString("unionCorpName"));//������а���λ����
					contractFiling.setUnionCorpCode(rs.getString("unionCorpCode"));//������а���λ��֯����
					contractFiling.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
					contractFiling.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					contractFiling.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
					contractFiling.setAppSteffId(rs.getString("appSteffId"));//������id
					contractFiling.setAppSteffName(rs.getString("appSteffName"));//����������
					contractFiling.setAppDate(rs.getDate("appDate"));//����ʱ��
					contractFiling.setAppOpinion(rs.getString("appOpinion"));//�������
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					contractFiling.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					contractFiling.setProcessSteps(rs.getString("processSteps").trim());
					contractFiling.setAppDept(rs.getString("appDept").trim());//������λid
					contractFiling.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
					contractFiling.setTenderNum(rs.getString("tenderNum"));
					contractFiling.setSectionName(rs.getString("sectionName"));
					page.getData().add(contractFiling);
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
	 * ��ͬ��������
	 * @return
	 */
	public String add(ContractFiling contractFiling)
	{
		String recordId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into tbcontractrecordmanage(RECORDID,PRJNUM,PRJNAME,"
					+ "CONTRACTNUM,CONTRACTTYPENUM,CONTRACTMONEY,PRJSIZE,CONTRACTDATE,"
					+ "PROPIETORCORPNAME,PROPIETORCORPCODE,CONTRACTORCORPNAME,CONTRACTORCORPCODE,"
					+ "UNIONCORPNAME,UNIONCORPCODE,CREATEDATE,APPLYCORPCODE,APPLYCORPNAME,APPTYPE,"
					+ "PROCESSSTEPS,APPDEPT,APPDEPTNAME,recordNum,tenderNum,sectionName,"
					+ "projectAddress,projectCost,area,constructorName,titleLeve,phone,"
					+ "qualificationsType,qualificationsTypeName,specialtyType,"
					+ "specialtyTypeName,rating,ratingName,"
					+ "technicalName,"
					+ "technicalIdCardTypeNum,"
					+ "technicalIdCard,"
					+ "technicalCertNum,"
					+ "qualityName,"
					+ "qualityIdCardTypeNum,"
					+ "qualityIdCard,"
					+ "qualityCertNum,"
					+ "securityName,"
					+ "securityIdCardTypeNum,"
					+ "securityIdCard,"
					+ "seCurityCertNum,"
					+ "constructionName,"
					+ "constructionIdCardTypeNum,"
					+ "constructionIdCard,"
					+ "constructionCertNum,"
					+ "directorName,"
					+ "directorIdCardTypeNum,"
					+ "directorIdCard,"
					+ "directorCertNum,"
					+ "represEntativeName,"
					+ "represEntativeIdCardTypeNum,"
					+ "represEntativeIdCard,"
					+ "represEntativeCertNum,"
					+ "safetyName,"
					+ "safetyIdCardTypeNum,"
					+ "safetyIdCard,"
					+ "contrType,"
					+ "contractStart,"
					+ "contractEnd) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,recordId);	//����
			pstmt.setString(2,contractFiling.getPrjNum()); //��Ŀ���
			pstmt.setString(3,contractFiling.getPrjName());//��Ŀ����
			pstmt.setString(4,contractFiling.getContractNum()); //��ͬ���
			pstmt.setString(5,contractFiling.getContractTypeNum()); //��ͬ���(TBCONTRACTTYPEDIC)
			pstmt.setString(6,contractFiling.getContractMoney()); //��ͬ���(��Ԫ)
			pstmt.setString(7,contractFiling.getPrjSize()); //�����ģ
			pstmt.setDate(8, contractFiling.getContractDate());; //��ͬǩ������
			pstmt.setString(9,contractFiling.getPropietorCorpName()); //������λ����
			pstmt.setString(10,contractFiling.getPropietorCorpCode()); //������λס��֯����
			pstmt.setString(11,contractFiling.getContractorCorpName()); //�а���λ����
			pstmt.setString(12,contractFiling.getContractorCorpCode()); //�а���λ��֯����
			pstmt.setString(13,contractFiling.getUnionCorpName()); //������а���λ����
			pstmt.setString(14,contractFiling.getUnionCorpCode()); //������а���λ��֯����
			pstmt.setDate(15, new Date(new java.util.Date().getTime()));//��¼�Ǽ�ʱ��
			pstmt.setString(16,contractFiling.getApplyCorpCode());//������ҵ��֯��������
			pstmt.setString(17,contractFiling.getApplyCorpName());//������ҵ����
			/**
			 * ����״̬
			 * 0�����룬1������ͨ����2������δͨ��
			 */
			pstmt.setString(18,"3");//����״̬
			/**
			 * ���̲���
			 * 1:��Ŀ����
			 * 2:����׶Ρ���ƽ׶�
			 * 3:��ͬ������ʩ��ͼ��鱸��
			 * 4:�����ල����ȫ�ල
			 * 5:ʩ�����
			 * 6:��������
			 */
			pstmt.setString(19,"3");
			pstmt.setString(20,contractFiling.getAppDept());//������λid
			pstmt.setString(21,contractFiling.getAppDeptName());//������λ����
			pstmt.setString(22, contractFiling.getRecordNum());//��ͬ�������
			pstmt.setString(23, contractFiling.getTenderNum());//�б�֪ͨ����
			pstmt.setString(24, contractFiling.getSectionName());//�������
			pstmt.setString(25, contractFiling.getProjectAddress());//���̵�ַ
			pstmt.setString(26, contractFiling.getProjectCost());//�������
			pstmt.setString(27, contractFiling.getArea());//���
			pstmt.setString(28, contractFiling.getConstructorName());//��Ŀ��������
			pstmt.setString(29, contractFiling.getTitleLeve());//���ʵȼ�
			pstmt.setString(30, contractFiling.getPhone());//��ϵ�绰
			pstmt.setString(31, contractFiling.getQualificationsType());
			pstmt.setString(32, contractFiling.getQualificationsTypeName());
			pstmt.setString(33, contractFiling.getSpecialtyType());
			pstmt.setString(34, contractFiling.getSpecialtyTypeName());
			pstmt.setString(35, contractFiling.getRating());
			pstmt.setString(36, contractFiling.getRatingName());
			
			
			pstmt.setString(37, contractFiling.getTechnicalName());//��������������
			pstmt.setString(38, contractFiling.getTechnicalIdCardTypeNum());//����������֤������
			pstmt.setString(39, contractFiling.getTechnicalIdCard());//����������֤������
			pstmt.setString(40, contractFiling.getTechnicalCertNum());//����������֤���
			pstmt.setString(41, contractFiling.getQualityName());//�������Ա����
			pstmt.setString(42, contractFiling.getQualityIdCardTypeNum());//�������Ա֤������
			pstmt.setString(43, contractFiling.getQualityIdCard());//�������Ա֤������
			pstmt.setString(44, contractFiling.getQualityCertNum());//�������Ա֤���
			pstmt.setString(45, contractFiling.getSecurityName());//��ȫԱ����
			pstmt.setString(46, contractFiling.getSecurityIdCardTypeNum());//��ȫԱ֤������
			pstmt.setString(47, contractFiling.getSecurityIdCard());//��ȫԱ֤������
			pstmt.setString(48, contractFiling.getSecurityCertNum());//��ȫԱ֤���
			pstmt.setString(49, contractFiling.getConstructionName());//ʩ��Ա������������
			pstmt.setString(50, contractFiling.getConstructionIdCardTypeNum());//ʩ��Ա��������֤������
			pstmt.setString(51, contractFiling.getConstructionIdCard());//ʩ��Ա��������֤������
			pstmt.setString(52, contractFiling.getConstructionCertNum());//ʩ��Ա��������֤���
			pstmt.setString(53, contractFiling.getDirectorName());//��������Ա���ܼ�����
			pstmt.setString(54, contractFiling.getDirectorIdCardTypeNum());//��������Ա���ܼ�֤������
			pstmt.setString(55, contractFiling.getDirectorIdCard());//��������Ա���ܼ�֤������
			pstmt.setString(56, contractFiling.getDirectorCertNum());//��������Ա���ܼ�֤���
			pstmt.setString(57, contractFiling.getRepresEntativeName());//�ܼ��������
			pstmt.setString(58, contractFiling.getRepresEntativeIdCardTypeNum());//�ܼ����֤������
			pstmt.setString(59, contractFiling.getRepresEntativeIdCard());//�ܼ����֤������
			pstmt.setString(60, contractFiling.getRepresEntativeCertNum());//�ܼ����֤���
			pstmt.setString(61, contractFiling.getSafetyName());//��ȫ��������
			pstmt.setString(62, contractFiling.getSafetyIdCardTypeNum());//��ȫ����֤������
			pstmt.setString(63, contractFiling.getSafetyIdCard());//��ȫ����֤������
			pstmt.setString(64, contractFiling.getContrType());
			pstmt.setDate(65, contractFiling.getContractStart());
			pstmt.setDate(66, contractFiling.getContractEnd());
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
		return recordId;
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId)
	{

		ContractFiling contractFiling = new ContractFiling();
		try {
			
			String qsql = "select * from v_tbcontractrecordmanage where recordId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, recordId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				contractFiling.setRecordId(rs.getString("recordId"));//����
				contractFiling.setRecordNum(rs.getString("recordNum"));//��ͬ�������
				contractFiling.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				contractFiling.setPrjName(rs.getString("prjName"));//��Ŀ����
				contractFiling.setContractNum(rs.getString("contractNum"));//��ͬ���
				contractFiling.setContractTypeNum(rs.getString("contractTypeNum"));//��ͬ���(TBCONTRACTTYPEDIC)
				contractFiling.setContractTypeName(rs.getString("contractTypeName"));//��ͬ�������
				contractFiling.setContractMoney(rs.getString("contractMoney"));//��ͬ���(��Ԫ)
				contractFiling.setPrjSize(rs.getString("prjSize"));//�����ģ
				contractFiling.setContractDate(rs.getDate("contractDate"));//��ͬǩ������
				contractFiling.setPropietorCorpName(rs.getString("propietorCorpName"));//������λ����
				contractFiling.setPropietorCorpCode(rs.getString("propietorCorpCode"));//������λס��֯����
				contractFiling.setContractorCorpName(rs.getString("contractorCorpName"));//�а���λ����
				contractFiling.setContractorCorpCode(rs.getString("contractorCorpCode"));//�а���λ��֯����
				contractFiling.setUnionCorpName(rs.getString("unionCorpName"));//������а���λ����
				contractFiling.setUnionCorpCode(rs.getString("unionCorpCode"));//������а���λ��֯����
				contractFiling.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
				contractFiling.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				contractFiling.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				contractFiling.setAppSteffId(rs.getString("appSteffId"));//������id
				contractFiling.setAppSteffName(rs.getString("appSteffName"));//����������
				contractFiling.setAppDate(rs.getDate("appDate"));//����ʱ��
				contractFiling.setAppOpinion(rs.getString("appOpinion"));//�������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				contractFiling.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				contractFiling.setProcessSteps(rs.getString("processSteps").trim());
				contractFiling.setAppDept(rs.getString("appDept").trim());//������λid
				contractFiling.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				contractFiling.setSectionName(rs.getString("sectionName"));
				contractFiling.setTenderNum(rs.getString("tenderNum"));
				contractFiling.setProjectAddress(rs.getString("projectAddress"));
				contractFiling.setProjectCost(rs.getString("projectCost"));
				contractFiling.setArea(rs.getString("area"));
				contractFiling.setConstructorName(rs.getString("constructorName"));//��Ŀ��������
				contractFiling.setTitleLeve(rs.getString("titleLeve"));//���ʵȼ�
				contractFiling.setPhone(rs.getString("phone"));//��ϵ�绰
				contractFiling.setQualificationsType(rs.getString("qualificationsType"));
				contractFiling.setQualificationsTypeName(rs.getString("qualificationsTypeName"));
				contractFiling.setSpecialtyType(rs.getString("specialtyType"));
				contractFiling.setSpecialtyTypeName(rs.getString("specialtyTypeName"));
				contractFiling.setRating(rs.getString("rating"));
				contractFiling.setRatingName(rs.getString("ratingName"));
				contractFiling.setContrType(rs.getString("contrType"));
				
				//-------------------------------��Ա-----------------------------------	
				contractFiling.setTechnicalName(rs.getString("technicalName"));//��������������
				contractFiling.setTechnicalIdCardTypeNum(rs.getString("technicalIdCardTypeNum"));//����������֤������
				contractFiling.setTechnicalIdCard(rs.getString("technicalIdCard"));//����������֤������
				contractFiling.setTechnicalCertNum(rs.getString("technicalCertNum"));//����������֤���
				contractFiling.setQualityName(rs.getString("qualityName"));//�������Ա����
				contractFiling.setQualityIdCardTypeNum(rs.getString("qualityIdCardTypeNum"));//�������Ա֤������
				contractFiling.setQualityIdCard(rs.getString("qualityIdCard"));//�������Ա֤������
				contractFiling.setQualityCertNum(rs.getString("qualityCertNum"));//�������Ա֤���
				contractFiling.setSecurityName(rs.getString("securityName"));//��ȫԱ����
				contractFiling.setSecurityIdCardTypeNum(rs.getString("securityIdCardTypeNum"));//��ȫԱ֤������
				contractFiling.setSecurityIdCard(rs.getString("securityIdCard"));//��ȫԱ֤������
				contractFiling.setSecurityCertNum(rs.getString("securityCertNum"));//��ȫԱ֤���
				contractFiling.setConstructionName(rs.getString("constructionName"));//ʩ��Ա������������
				contractFiling.setConstructionIdCardTypeNum(rs.getString("constructionIdCardTypeNum"));//ʩ��Ա��������֤������
				contractFiling.setConstructionIdCard(rs.getString("constructionIdCard"));//ʩ��Ա��������֤������
				contractFiling.setConstructionCertNum(rs.getString("constructionCertNum"));//ʩ��Ա��������֤���
				contractFiling.setDirectorName(rs.getString("directorName"));//��������Ա���ܼ�����
				contractFiling.setDirectorIdCardTypeNum(rs.getString("directorIdCardTypeNum"));//��������Ա���ܼ�֤������
				contractFiling.setDirectorIdCard(rs.getString("directorIdCard"));//��������Ա���ܼ�֤������
				contractFiling.setDirectorCertNum(rs.getString("directorCertNum"));//��������Ա���ܼ�֤���
				contractFiling.setRepresEntativeName(rs.getString("represEntativeName"));//�ܼ��������
				contractFiling.setRepresEntativeIdCardTypeNum(rs.getString("represEntativeIdCardTypeNum"));//�ܼ����֤������
				contractFiling.setRepresEntativeIdCard(rs.getString("represEntativeIdCard"));//�ܼ����֤������
				contractFiling.setRepresEntativeCertNum(rs.getString("represEntativeCertNum"));//�ܼ����֤���
				contractFiling.setSafetyName(rs.getString("safetyName"));//��ȫ��������
				contractFiling.setSafetyIdCardTypeNum(rs.getString("safetyIdCardTypeNum"));//��ȫ����֤������
				contractFiling.setSafetyIdCard(rs.getString("safetyIdCard"));//��ȫ����֤������
				contractFiling.setContractStart(rs.getDate("contractStart"));
				contractFiling.setContractEnd(rs.getDate("contractEnd"));
			}
			
			String linkNum = "";
			if("301".equals(contractFiling.getContractTypeNum().trim()))
			{
				linkNum = "10";
			}
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=? order by num");
			pstmt.setString(1, linkNum);
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
				pstmt.setString(1,recordId);
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
			contractFiling.setAccessoryList(accessoryList);
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
		return contractFiling;
	}
	
	/**
	 * ��ͬ���������޸�
	 * @return
	 */
	public void modify(ContractFiling contractFiling)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update tbcontractrecordmanage set PRJNUM=?,PRJNAME=?,"
					+ "CONTRACTNUM=?,CONTRACTTYPENUM=?,CONTRACTMONEY=?,PRJSIZE=?,CONTRACTDATE=?,"
					+ "PROPIETORCORPNAME=?,PROPIETORCORPCODE=?,CONTRACTORCORPNAME=?,"
					+ "CONTRACTORCORPCODE=?,UNIONCORPNAME=?,UNIONCORPCODE=?,APPDEPT=?,"
					+ "APPDEPTNAME=?,tenderNum=?,sectionName=?,projectAddress=?,"
					+ "projectCost=?,area=?,constructorName=?,titleLeve=?,phone=?,"
					+ "qualificationsType=?,specialtyType=?,rating=?,"
					+ "qualificationsTypeName=?,specialtyTypeName=?,ratingName=?,"
					+ "technicalName=?,"
					+ "technicalIdCardTypeNum=?,"
					+ "technicalIdCard=?,"
					+ "technicalCertNum=?,"
					+ "qualityName=?,"
					+ "qualityIdCardTypeNum=?,"
					+ "qualityIdCard=?,"
					+ "qualityCertNum=?,"
					+ "securityName=?,"
					+ "securityIdCardTypeNum=?,"
					+ "securityIdCard=?,"
					+ "seCurityCertNum=?,"
					+ "constructionName=?,"
					+ "constructionIdCardTypeNum=?,"
					+ "constructionIdCard=?,"
					+ "constructionCertNum=?,"
					+ "directorName=?,"
					+ "directorIdCardTypeNum=?,"
					+ "directorIdCard=?,"
					+ "directorCertNum=?,"
					+ "represEntativeName=?,"
					+ "represEntativeIdCardTypeNum=?,"
					+ "represEntativeIdCard=?,"
					+ "represEntativeCertNum=?,"
					+ "safetyName=?,"
					+ "safetyIdCardTypeNum=?,"
					+ "safetyIdCard=?,  "
					+ "contrType=?,"
					+ "contractStart=?,"
					+ "contractEnd=?  "
					+ "where RECORDID=? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,contractFiling.getPrjNum()); //��Ŀ���
			pstmt.setString(2,contractFiling.getPrjName());//��Ŀ����
			pstmt.setString(3,contractFiling.getContractNum()); //��ͬ���
			pstmt.setString(4,contractFiling.getContractTypeNum()); //��ͬ���(TBCONTRACTTYPEDIC)
			pstmt.setString(5,contractFiling.getContractMoney()); //��ͬ���(��Ԫ)
			pstmt.setString(6,contractFiling.getPrjSize()); //�����ģ
			pstmt.setDate(7, contractFiling.getContractDate());; //��ͬǩ������
			pstmt.setString(8,contractFiling.getPropietorCorpName()); //������λ����
			pstmt.setString(9,contractFiling.getPropietorCorpCode()); //������λס��֯����
			pstmt.setString(10,contractFiling.getContractorCorpName()); //�а���λ����
			pstmt.setString(11,contractFiling.getContractorCorpCode()); //�а���λ��֯����
			pstmt.setString(12,contractFiling.getUnionCorpName()); //������а���λ����
			pstmt.setString(13,contractFiling.getUnionCorpCode()); //������а���λ��֯����
			pstmt.setString(14,contractFiling.getAppDept());//������λid
			pstmt.setString(15,contractFiling.getAppDeptName());//������λ����
			pstmt.setString(16, contractFiling.getTenderNum());
			pstmt.setString(17, contractFiling.getSectionName());
			pstmt.setString(18, contractFiling.getProjectAddress());
			pstmt.setString(19, contractFiling.getProjectCost());
			pstmt.setString(20, contractFiling.getArea());//���
			pstmt.setString(21, contractFiling.getConstructorName());//��Ŀ��������
			pstmt.setString(22, contractFiling.getTitleLeve());//���ʵȼ�
			pstmt.setString(23, contractFiling.getPhone());//����
			pstmt.setString(24, contractFiling.getQualificationsType());
			pstmt.setString(25, contractFiling.getSpecialtyType());
			pstmt.setString(26, contractFiling.getRating());
			pstmt.setString(27, contractFiling.getQualificationsTypeName());
			pstmt.setString(28, contractFiling.getSpecialtyTypeName());
			pstmt.setString(29, contractFiling.getRatingName());
			
			pstmt.setString(30, contractFiling.getTechnicalName());//��������������
			pstmt.setString(31, contractFiling.getTechnicalIdCardTypeNum());//����������֤������
			pstmt.setString(32, contractFiling.getTechnicalIdCard());//����������֤������
			pstmt.setString(33, contractFiling.getTechnicalCertNum());//����������֤���
			pstmt.setString(34, contractFiling.getQualityName());//�������Ա����
			pstmt.setString(35, contractFiling.getQualityIdCardTypeNum());//�������Ա֤������
			pstmt.setString(36, contractFiling.getQualityIdCard());//�������Ա֤������
			pstmt.setString(37, contractFiling.getQualityCertNum());//�������Ա֤���
			pstmt.setString(38, contractFiling.getSecurityName());//��ȫԱ����
			pstmt.setString(39, contractFiling.getSecurityIdCardTypeNum());//��ȫԱ֤������
			pstmt.setString(40, contractFiling.getSecurityIdCard());//��ȫԱ֤������
			pstmt.setString(41, contractFiling.getSecurityCertNum());//��ȫԱ֤���
			pstmt.setString(42, contractFiling.getConstructionName());//ʩ��Ա������������
			pstmt.setString(43, contractFiling.getConstructionIdCardTypeNum());//ʩ��Ա��������֤������
			pstmt.setString(44, contractFiling.getConstructionIdCard());//ʩ��Ա��������֤������
			pstmt.setString(45, contractFiling.getConstructionCertNum());//ʩ��Ա��������֤���
			pstmt.setString(46, contractFiling.getDirectorName());//��������Ա���ܼ�����
			pstmt.setString(47, contractFiling.getDirectorIdCardTypeNum());//��������Ա���ܼ�֤������
			pstmt.setString(48, contractFiling.getDirectorIdCard());//��������Ա���ܼ�֤������
			pstmt.setString(49, contractFiling.getDirectorCertNum());//��������Ա���ܼ�֤���
			pstmt.setString(50, contractFiling.getRepresEntativeName());//�ܼ��������
			pstmt.setString(51, contractFiling.getRepresEntativeIdCardTypeNum());//�ܼ����֤������
			pstmt.setString(52, contractFiling.getRepresEntativeIdCard());//�ܼ����֤������
			pstmt.setString(53, contractFiling.getRepresEntativeCertNum());//�ܼ����֤���
			pstmt.setString(54, contractFiling.getSafetyName());//��ȫ��������
			pstmt.setString(55, contractFiling.getSafetyIdCardTypeNum());//��ȫ����֤������
			pstmt.setString(56, contractFiling.getSafetyIdCard());//��ȫ����֤������
			
			pstmt.setString(57, contractFiling.getContrType());
			pstmt.setDate(58, contractFiling.getContractStart());
			pstmt.setDate(59, contractFiling.getContractEnd());
			pstmt.setString(60, contractFiling.getRecordId());//����
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
	public void delete(String recordId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from tbcontractrecordmanage where recordId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recordId);//����
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,recordId);	
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
			pstmt.setString(1,recordId);	
			pstmt.executeUpdate();
			
			String sqlCb = "delete from TB_CONTRACTINFO_BUSINESS where recordId=? ";
			pstmt = conn.prepareStatement(sqlCb);
			pstmt.setString(1, recordId);//����
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
	
	//��ͬ���
	public List<DictionaryClass> queryContractTypeNums()
	{
		String sql = "select * from TBCONTRACTTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("CONTRACTTYPE"));
				dictionaryClass.setCode(rs.getString("code"));
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
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedPrjQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					Construction construction = new Construction();
					construction.setPrjId(rs.getString("prjId"));//����
					construction.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					construction.setPrjName(rs.getString("prjName"));//��Ŀ����
					construction.setCreateDate(rs.getDate("createDate"));
					construction.setAppDept(rs.getString("appDept"));//������λ
					construction.setAppDeptName(rs.getString("appDeptName"));//������λ����
					page.getData().add(construction);
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
	 * ��ѯ��Ͷ����Ŀ
	 * @param condition
	 * @return
	 */
	public Page pagedTbInfoQuery(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					ProjcetTenderInfo construction = new ProjcetTenderInfo();
					construction.setPrjNum(rs.getString("prjNum"));
					construction.setPrjSize(rs.getString("prjSize"));
					construction.setSectionName(rs.getString("sectionName"));//�������
					construction.setTenderNum(rs.getString("tenderNum"));//�б�֪ͨ����
					construction.setTenderCorpCode(rs.getString("tenderCorpCode"));//�а���λ��֯����
					construction.setTenderCorpName(rs.getString("tenderCorpName"));//�а���λ����
					construction.setTenderMoney(rs.getString("tenderMoney"));//�б���
					construction.setUnionCorpName(rs.getString("unionCorpName")); //������а���λ����(��ͬ����)
					construction.setUnionCorpCode(rs.getString("unionCorpCode")); //������а���λ��֯����(��ͬ����)
					construction.setCreatedate(rs.getDate("createdate"));
					construction.setProjectAddress(rs.getString("projectAddress"));//���̵�ַ
					construction.setProjectCost(rs.getString("projectCost"));//�������
					construction.setArea(rs.getString("area"));//���
					construction.setPropietorCorpName(rs.getString("propietorCorpName"));//������λ����
					construction.setPropietorCorpCode(rs.getString("propietorCorpCode")); //������λס��֯����
					construction.setConstructorName(rs.getString("constructorName"));//��Ŀ��������
					page.getData().add(construction);
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
	 * ��ѯ��ҵ����
	 * @param condition
	 * @return
	 */
	public Page pagedTitleLeveQuery(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
					Certdetail cd = new Certdetail();
					cd.setCorpName(rs.getString("corpName"));
					cd.setCorpCode(rs.getString("corpCode"));
					cd.setQualificationsType(rs.getString("qualificationsType"));
					cd.setSpecialtyType(rs.getString("specialtyType"));
					cd.setRating(rs.getString("rating"));
					cd.setQualificationsTypeName(rs.getString("qualificationsTypeName"));//�����ʸ���������
					cd.setSpecialtyTypeName(rs.getString("specialtyTypeName"));//רҵ�������
					cd.setRatingName(rs.getString("ratingName"));//�����ʸ�ȼ�����
					page.getData().add(cd);
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
	 * �ύ
	 * @return
	 */
	public void sub(String recordId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update tbcontractrecordmanage set apptype=?  "
					+ "where RECORDID=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "0");//��Ϊ�ύ״̬
			pstmt.setString(2,recordId); //����
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
}
