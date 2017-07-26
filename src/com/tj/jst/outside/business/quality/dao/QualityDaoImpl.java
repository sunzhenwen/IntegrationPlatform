package com.tj.jst.outside.business.quality.dao;

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
import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.contractFiling.model.ProjcetTenderInfo;
import com.tj.jst.outside.business.quality.model.Plans;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * �����ල
 * @author hhc
 *
 */
public class QualityDaoImpl extends BaseDao implements IQualityDao {

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
					Quality quality = new Quality();
					quality.setQualityId(rs.getString("qualityId"));//����
					quality.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					quality.setPrjName(rs.getString("prjName"));//��Ŀ����
					quality.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
					quality.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					quality.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
					quality.setAppSteffId(rs.getString("appSteffId"));//������id
					quality.setAppSteffName(rs.getString("appSteffName"));//����������
					quality.setAppDate(rs.getDate("appDate"));//����ʱ��
					quality.setAppOpinion(rs.getString("appOpinion"));//�������
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					quality.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					quality.setProcessSteps(rs.getString("processSteps").trim());
					quality.setAppDept(rs.getString("appDept").trim());//������λid
					quality.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
					page.getData().add(quality);
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
	 * ��ѯʩ��ͼ��
	 * @param condition
	 * @return
	 */
	public Page pagedQualityPlans(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					Plans plans = new Plans();
					plans.setCensorNum(rs.getString("CensorNum"));//���ϸ�����
					plans.setPrjName(rs.getString("PrjName"));//���ʱ�Ĺ�������
					plans.setCensorCorpName(rs.getString("CensorCorpName"));//������
					plans.setCensorId(rs.getString("CensorId"));//�������
					plans.setEconCorpName(rs.getString("EconCorpName"));//���쵥λ
					plans.setDesignCorpName(rs.getString("DesignCorpName"));//��Ƶ�λ����
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
	
	/**
	 * �����ල����
	 * @return
	 */
	public String add(Quality quality)
	{
		String qualityId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TB_QUALITYSUPERVISION(qualityId,PRJNUM,PRJNAME,"
					+ "prjId,createDate,applyCorpCode,applyCorpName,appType,processSteps,appDept,"
					+ "appDeptName,projectName,configuration,projectAddress,contact,"
					+ "constructionArea,quantities,expensive,superviseCost,startDate,"
					+ "endDate,developmentOrganization,developmentQualificationLevel,"
					+ "developmentCharge,developmentPhone,surveyUnit,"
					+ "surveyUnitQualificationLevel,surveyUnitCharge,surveyUnitPhone,"
					+ "designUnit,designUnitQualificationLevel,designUnitCharge,"
					+ "designUnitPhone,supervisionUnit,supervisionUnitQualLevel,"
					+ "supervisionUnitEngineer,supervisionUnitPhone,constructionUnit,"
					+ "constructionUnitQualLevel,constructionUnitProjectManager,"
					+ "constructionUnitPhone,constructionPlans,constructionPlansType,"
					+ "constructionPlansCharge,constructionPlansPhone,"
					+ "constructionContractFileNum,constructionOrganFileNum,"
					+ "constructionPlansFileNum,supervisionContractFileNum,"
					+ "supervisionPlanFileNum,fireControlFileNum,developmentOrganFileNum,"
					+ "onstructionUnitFileNum,supervisionUnitFileNum,"
					+ "constructionSiteFileNum,qualityTestingFileNum,"
					+ "fieldSupervisionFileNum,qualityNum,sectionName,tenderNum,contractMoney,econCorpCode,designCorpCode,consCorpCode,superCorpCode) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,qualityId);//����
			pstmt.setString(2,quality.getPrjNum());//��Ŀ���
			pstmt.setString(3,quality.getPrjName());//��Ŀ����
			pstmt.setString(4,quality.getPrjId());//��Ŀ��������
			pstmt.setDate(5,new Date(new java.util.Date().getTime())); //��¼�Ǽ�����
			pstmt.setString(6,quality.getApplyCorpCode()); //������ҵ��֯��������
			pstmt.setString(7,quality.getApplyCorpName()); //������ҵ����
			/**
			 * ����״̬
			 * 0�����룬1������ͨ����2������δͨ��
			 */
			pstmt.setString(8,"0");//����״̬
			/**
			 * ���̲���
			 * 1:��Ŀ����
			 * 2:����׶Ρ���ƽ׶�
			 * 3:��ͬ������ʩ��ͼ��鱸��
			 * 4:�����ල����ȫ�ල
			 * 5:ʩ�����
			 * 6:��������
			 */
			pstmt.setString(9,"4");
			pstmt.setString(10,quality.getAppDept());//������λid
			pstmt.setString(11,quality.getAppDeptName());//������λ����
			pstmt.setString(12,quality.getProjectName());//��������
			pstmt.setString(13,quality.getConfiguration());//�ṹ/����
			pstmt.setString(14,quality.getProjectAddress());//���̵ص�
			pstmt.setString(15,quality.getContact());//��ϵ��
			pstmt.setString(16,quality.getConstructionArea());//�������(ƽ����)
			pstmt.setString(17,quality.getQuantities());//��װ������(��Ԫ)
			pstmt.setString(18,quality.getExpensive());//���������(��Ԫ)
			pstmt.setString(19,quality.getSuperviseCost());//�ල��(Ԫ)
			pstmt.setDate(20,quality.getStartDate());//�ƻ���������
			pstmt.setDate(21,quality.getEndDate());//�ƻ���������
			pstmt.setString(22,quality.getDevelopmentOrganization());//���赥λ
			pstmt.setString(23,quality.getDevelopmentQualificationLevel());//���赥λ���ʵȼ�
			pstmt.setString(24,quality.getDevelopmentCharge());//���赥λ��Ŀ������
			pstmt.setString(25,quality.getDevelopmentPhone());//���赥λ��ϵ�绰
			pstmt.setString(26,quality.getSurveyUnit());//���쵥λ
			pstmt.setString(27,quality.getSurveyUnitQualificationLevel());//���쵥λ���ʵȼ�
			pstmt.setString(28,quality.getSurveyUnitCharge());//���쵥λ��Ŀ������
			pstmt.setString(29,quality.getSurveyUnitPhone());//���쵥λ��ϵ�绰
			pstmt.setString(30,quality.getDesignUnit());//��Ƶ�λ
			pstmt.setString(31,quality.getDesignUnitQualificationLevel());//��Ƶ�λ���ʵȼ�
			pstmt.setString(32,quality.getDesignUnitCharge());//��Ƶ�λ��Ŀ������
			pstmt.setString(33,quality.getDesignUnitPhone());//��Ƶ�λ��ϵ�绰
			pstmt.setString(34,quality.getSupervisionUnit());//����λ
			pstmt.setString(35,quality.getSupervisionUnitQualLevel());//����λ���ʵȼ�
			pstmt.setString(36,quality.getSupervisionUnitEngineer());//�ܼ�����ʦ
			pstmt.setString(37,quality.getSupervisionUnitPhone());//����λ��ϵ�绰
			pstmt.setString(38,quality.getConstructionUnit());//ʩ����λ
			pstmt.setString(39,quality.getConstructionUnitQualLevel());//ʩ����λ���ʵȼ�
			pstmt.setString(40,quality.getConstructionUnitProjectManager());//ʩ����λ��Ŀ����
			pstmt.setString(41,quality.getConstructionUnitPhone());//ʩ����λ��ϵ�绰
			pstmt.setString(42,quality.getConstructionPlans());//ʩ��ͼ������
			pstmt.setString(43,quality.getConstructionPlansType());//ʩ��ͼ���������
			pstmt.setString(44,quality.getConstructionPlansCharge());//ʩ��ͼ��������Ŀ������
			pstmt.setString(45,quality.getConstructionPlansPhone());//ʩ��ͼ��������ϵ�绰
			pstmt.setString(46,quality.getConstructionContractFileNum());//ʩ����ͬ�ļ���
			pstmt.setString(47,quality.getConstructionOrganFileNum());//ʩ����֯����ļ���
			pstmt.setString(48,quality.getConstructionPlansFileNum());//ʩ��ͼ��鱨�����׼���ļ���
			pstmt.setString(49,quality.getSupervisionContractFileNum());//�����ͬ�ļ���
			pstmt.setString(50,quality.getSupervisionPlanFileNum());//����滮�ļ���
			pstmt.setString(51,quality.getFireControlFileNum());//����������ϸ�����֤���ļ��ļ���
			pstmt.setString(52,quality.getDevelopmentOrganFileNum());//���赥λ��Ŀ�����˼���Ŀ��������ļ���
			pstmt.setString(53,quality.getOnstructionUnitFileNum());//ʩ����λ��Ŀ�����˼���Ŀ��������ļ���
			pstmt.setString(54,quality.getSupervisionUnitFileNum());//����λ��Ŀ�����˼���Ŀ��������ļ���
			pstmt.setString(55,quality.getConstructionSiteFileNum());//ʩ���ֳ���Ŀ�����ˡ�������Ա�ʸ�֤���ļ���
			pstmt.setString(56,quality.getQualityTestingFileNum());//�������Ա��λ֤���ļ���
			pstmt.setString(57,quality.getFieldSupervisionFileNum());//�ֳ�������Աע��ִҵ֤���ļ���
			pstmt.setString(58, quality.getQualityNum());
			pstmt.setString(59, quality.getSectionName());
			pstmt.setString(60, quality.getTenderNum());
			
			pstmt.setString(61, quality.getContractMoney());
			pstmt.setString(62, quality.getEconCorpCode());
			pstmt.setString(63, quality.getDesignCorpCode());
			pstmt.setString(64, quality.getConsCorpCode());
			pstmt.setString(65, quality.getSuperCorpCode());
			
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
		return qualityId;
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Quality queryById(String qualityId)
	{

		Quality quality = new Quality();
		try {
			
			String qsql = "select * from TB_QUALITYSUPERVISION where qualityId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, qualityId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				quality.setQualityId(rs.getString("qualityId"));//����
				quality.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				quality.setPrjName(rs.getString("prjName"));//��Ŀ����
				quality.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
				quality.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				quality.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				quality.setAppSteffId(rs.getString("appSteffId"));//������id
				quality.setAppSteffName(rs.getString("appSteffName"));//����������
				quality.setAppDate(rs.getDate("appDate"));//����ʱ��
				quality.setAppOpinion(rs.getString("appOpinion"));//�������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				quality.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				quality.setProcessSteps(rs.getString("processSteps").trim());
				quality.setAppDept(rs.getString("appDept").trim());//������λid
				quality.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				quality.setPrjId(rs.getString("prjId"));
				quality.setProjectName(rs.getString("projectName"));//��������
				quality.setConfiguration(rs.getString("configuration"));//�ṹ/����
				quality.setProjectAddress(rs.getString("projectAddress"));//���̵ص�
				quality.setContact(rs.getString("contact"));//��ϵ��
				quality.setConstructionArea(rs.getString("constructionArea"));//�������(ƽ����)
				quality.setQuantities(rs.getString("quantities"));//��װ������(��Ԫ)
				quality.setExpensive(rs.getString("expensive"));//���������(��Ԫ)
				quality.setSuperviseCost(rs.getString("superviseCost"));//�ල��(Ԫ)
				quality.setStartDate(rs.getDate("startDate"));//�ƻ���������
				quality.setEndDate(rs.getDate("endDate"));//�ƻ���������
				quality.setDevelopmentOrganization(rs.getString("developmentOrganization"));//���赥λ
				quality.setDevelopmentQualificationLevel(rs.getString("developmentQualificationLevel"));//���赥λ���ʵȼ�
				quality.setDevelopmentCharge(rs.getString("developmentCharge"));//���赥λ��Ŀ������
				quality.setDevelopmentPhone(rs.getString("developmentPhone"));//���赥λ��ϵ�绰
				quality.setSurveyUnit(rs.getString("surveyUnit"));//���쵥λ
				quality.setSurveyUnitQualificationLevel(rs.getString("surveyUnitQualificationLevel"));//���쵥λ���ʵȼ�
				quality.setSurveyUnitCharge(rs.getString("surveyUnitCharge"));//���쵥λ��Ŀ������
				quality.setSurveyUnitPhone(rs.getString("surveyUnitPhone"));//���쵥λ��ϵ�绰
				quality.setDesignUnit(rs.getString("designUnit"));//��Ƶ�λ
				quality.setDesignUnitQualificationLevel(rs.getString("designUnitQualificationLevel"));//��Ƶ�λ���ʵȼ�
				quality.setDesignUnitCharge(rs.getString("designUnitCharge"));//��Ƶ�λ��Ŀ������
				quality.setDesignUnitPhone(rs.getString("designUnitPhone"));//��Ƶ�λ��ϵ�绰
				quality.setSupervisionUnit(rs.getString("supervisionUnit"));//����λ
				quality.setSupervisionUnitQualLevel(rs.getString("supervisionUnitQualLevel"));//����λ���ʵȼ�
				quality.setSupervisionUnitEngineer(rs.getString("supervisionUnitEngineer"));//�ܼ�����ʦ
				quality.setSupervisionUnitPhone(rs.getString("supervisionUnitPhone"));//����λ��ϵ�绰
				quality.setConstructionUnit(rs.getString("constructionUnit"));//ʩ����λ
				quality.setConstructionUnitQualLevel(rs.getString("constructionUnitQualLevel"));//ʩ����λ���ʵȼ�
				quality.setConstructionUnitProjectManager(rs.getString("constructionUnitProjectManager"));//ʩ����λ��Ŀ����
				quality.setConstructionUnitPhone(rs.getString("constructionUnitPhone"));//ʩ����λ��ϵ�绰
				quality.setConstructionPlans(rs.getString("constructionPlans"));//ʩ��ͼ������
				quality.setConstructionPlansType(rs.getString("constructionPlansType"));//ʩ��ͼ���������
				quality.setConstructionPlansCharge(rs.getString("constructionPlansCharge"));//ʩ��ͼ��������Ŀ������
				quality.setConstructionPlansPhone(rs.getString("constructionPlansPhone"));//ʩ��ͼ��������ϵ�绰
				quality.setConstructionContractFileNum(rs.getString("constructionContractFileNum"));//ʩ����ͬ�ļ���
				quality.setConstructionOrganFileNum(rs.getString("constructionOrganFileNum"));//ʩ����֯����ļ���
				quality.setConstructionPlansFileNum(rs.getString("constructionPlansFileNum"));//ʩ��ͼ��鱨�����׼���ļ���
				quality.setSupervisionContractFileNum(rs.getString("supervisionContractFileNum"));//�����ͬ�ļ���
				quality.setSupervisionPlanFileNum(rs.getString("supervisionPlanFileNum"));//����滮�ļ���
				quality.setFireControlFileNum(rs.getString("FireControlFileNum"));//����������ϸ�����֤���ļ��ļ���
				quality.setDevelopmentOrganFileNum(rs.getString("DevelopmentOrganFileNum"));//���赥λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setOnstructionUnitFileNum(rs.getString("OnstructionUnitFileNum"));//ʩ����λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setSupervisionUnitFileNum(rs.getString("SupervisionUnitFileNum"));//����λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setConstructionSiteFileNum(rs.getString("ConstructionSiteFileNum"));//ʩ���ֳ���Ŀ�����ˡ�������Ա�ʸ�֤���ļ���
				quality.setQualityTestingFileNum(rs.getString("QualityTestingFileNum"));//�������Ա��λ֤���ļ���
				quality.setFieldSupervisionFileNum(rs.getString("FieldSupervisionFileNum"));//�ֳ�������Աע��ִҵ֤���ļ���
				quality.setQualityNum(rs.getString("qualityNum"));
				quality.setSectionName(rs.getString("sectionName"));
				quality.setTenderNum(rs.getString("tenderNum"));
				
				quality.setContractMoney(rs.getString("contractMoney"));
				quality.setEconCorpCode(rs.getString("econCorpCode"));
				quality.setDesignCorpCode(rs.getString("designCorpCode"));
				quality.setConsCorpCode(rs.getString("consCorpCode"));
				quality.setSuperCorpCode(rs.getString("superCorpCode"));
			}
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=4 order by num");
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
				pstmt.setString(1,qualityId);
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
			quality.setAccessoryList(accessoryList);
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
		return quality;
	}
	
	/**
	 * �����ල�����޸�
	 * @return
	 */
	public void modify(Quality quality)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TB_QUALITYSUPERVISION set PRJNUM=?,PRJNAME=?,"
					+ "prjId=?,"
					+ "projectName=?,configuration=?,projectAddress=?,contact=?,"
					+ "constructionArea=?,quantities=?,expensive=?,superviseCost=?,"
					+ "startDate=?,"
					+ "endDate=?,developmentOrganization=?,developmentQualificationLevel=?,"
					+ "developmentCharge=?,developmentPhone=?,surveyUnit=?,"
					+ "surveyUnitQualificationLevel=?,surveyUnitCharge=?,surveyUnitPhone=?,"
					+ "designUnit=?,designUnitQualificationLevel=?,designUnitCharge=?,"
					+ "designUnitPhone=?,supervisionUnit=?,supervisionUnitQualLevel=?,"
					+ "supervisionUnitEngineer=?,supervisionUnitPhone=?,constructionUnit=?,"
					+ "constructionUnitQualLevel=?,constructionUnitProjectManager=?,"
					+ "constructionUnitPhone=?,constructionPlans=?,constructionPlansType=?,"
					+ "constructionPlansCharge=?,constructionPlansPhone=?,"
					+ "constructionContractFileNum=?,constructionOrganFileNum=?,"
					+ "constructionPlansFileNum=?,supervisionContractFileNum=?,"
					+ "supervisionPlanFileNum=?,fireControlFileNum=?,developmentOrganFileNum=?,"
					+ "onstructionUnitFileNum=?,supervisionUnitFileNum=?,"
					+ "constructionSiteFileNum=?,qualityTestingFileNum=?,"
					+ " fieldSupervisionFileNum=?,tenderNum=?,sectionName=?, "
					
					+ " contractMoney=?,econCorpCode=?,designCorpCode=?,consCorpCode=?,"
					+ "superCorpCode=? "
					
					+ " where qualityId=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,quality.getPrjNum());//��Ŀ���
			pstmt.setString(2,quality.getPrjName());//��Ŀ����
			pstmt.setString(3,quality.getPrjId());//��Ŀ��������
			pstmt.setString(4,quality.getProjectName());//��������
			pstmt.setString(5,quality.getConfiguration());//�ṹ/����
			pstmt.setString(6,quality.getProjectAddress());//���̵ص�
			pstmt.setString(7,quality.getContact());//��ϵ��
			pstmt.setString(8,quality.getConstructionArea());//�������(ƽ����)
			pstmt.setString(9,quality.getQuantities());//��װ������(��Ԫ)
			pstmt.setString(10,quality.getExpensive());//���������(��Ԫ)
			pstmt.setString(11,quality.getSuperviseCost());//�ල��(Ԫ)
			pstmt.setDate(12,quality.getStartDate());//�ƻ���������
			pstmt.setDate(13,quality.getEndDate());//�ƻ���������
			pstmt.setString(14,quality.getDevelopmentOrganization());//���赥λ
			pstmt.setString(15,quality.getDevelopmentQualificationLevel());//���赥λ���ʵȼ�
			pstmt.setString(16,quality.getDevelopmentCharge());//���赥λ��Ŀ������
			pstmt.setString(17,quality.getDevelopmentPhone());//���赥λ��ϵ�绰
			pstmt.setString(18,quality.getSurveyUnit());//���쵥λ
			pstmt.setString(19,quality.getSurveyUnitQualificationLevel());//���쵥λ���ʵȼ�
			pstmt.setString(20,quality.getSurveyUnitCharge());//���쵥λ��Ŀ������
			pstmt.setString(21,quality.getSurveyUnitPhone());//���쵥λ��ϵ�绰
			pstmt.setString(22,quality.getDesignUnit());//��Ƶ�λ
			pstmt.setString(23,quality.getDesignUnitQualificationLevel());//��Ƶ�λ���ʵȼ�
			pstmt.setString(24,quality.getDesignUnitCharge());//��Ƶ�λ��Ŀ������
			pstmt.setString(25,quality.getDesignUnitPhone());//��Ƶ�λ��ϵ�绰
			pstmt.setString(26,quality.getSupervisionUnit());//����λ
			pstmt.setString(27,quality.getSupervisionUnitQualLevel());//����λ���ʵȼ�
			pstmt.setString(28,quality.getSupervisionUnitEngineer());//�ܼ�����ʦ
			pstmt.setString(29,quality.getSupervisionUnitPhone());//����λ��ϵ�绰
			pstmt.setString(30,quality.getConstructionUnit());//ʩ����λ
			pstmt.setString(31,quality.getConstructionUnitQualLevel());//ʩ����λ���ʵȼ�
			pstmt.setString(32,quality.getConstructionUnitProjectManager());//ʩ����λ��Ŀ����
			pstmt.setString(33,quality.getConstructionUnitPhone());//ʩ����λ��ϵ�绰
			pstmt.setString(34,quality.getConstructionPlans());//ʩ��ͼ������
			pstmt.setString(35,quality.getConstructionPlansType());//ʩ��ͼ���������
			pstmt.setString(36,quality.getConstructionPlansCharge());//ʩ��ͼ��������Ŀ������
			pstmt.setString(37,quality.getConstructionPlansPhone());//ʩ��ͼ��������ϵ�绰
			pstmt.setString(38,quality.getConstructionContractFileNum());//ʩ����ͬ�ļ���
			pstmt.setString(39,quality.getConstructionOrganFileNum());//ʩ����֯����ļ���
			pstmt.setString(40,quality.getConstructionPlansFileNum());//ʩ��ͼ��鱨�����׼���ļ���
			pstmt.setString(41,quality.getSupervisionContractFileNum());//�����ͬ�ļ���
			pstmt.setString(42,quality.getSupervisionPlanFileNum());//����滮�ļ���
			pstmt.setString(43,quality.getFireControlFileNum());//����������ϸ�����֤���ļ��ļ���
			pstmt.setString(44,quality.getDevelopmentOrganFileNum());//���赥λ��Ŀ�����˼���Ŀ��������ļ���
			pstmt.setString(45,quality.getOnstructionUnitFileNum());//ʩ����λ��Ŀ�����˼���Ŀ��������ļ���
			pstmt.setString(46,quality.getSupervisionUnitFileNum());//����λ��Ŀ�����˼���Ŀ��������ļ���
			pstmt.setString(47,quality.getConstructionSiteFileNum());//ʩ���ֳ���Ŀ�����ˡ�������Ա�ʸ�֤���ļ���
			pstmt.setString(48,quality.getQualityTestingFileNum());//�������Ա��λ֤���ļ���
			pstmt.setString(49,quality.getFieldSupervisionFileNum());//�ֳ�������Աע��ִҵ֤���ļ���
			pstmt.setString(50, quality.getTenderNum());
			pstmt.setString(51, quality.getSectionName());
			
			
			pstmt.setString(52, quality.getContractMoney());
			pstmt.setString(53, quality.getEconCorpCode());
			pstmt.setString(54, quality.getDesignCorpCode());
			pstmt.setString(55, quality.getConsCorpCode());
			pstmt.setString(56, quality.getSuperCorpCode());
			
			pstmt.setString(57,quality.getQualityId());//����
			

			
			
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
	public void delete(String qualityId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TB_QUALITYSUPERVISION where qualityId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qualityId);//����
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,qualityId);	
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
			pstmt.setString(1,qualityId);	
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
	construction.setTenderCorpName(rs.getString("tenderCorpName"));//�б굥λ
	//------------------------------------------------------------------------------
//	construction.setProjectName(rs.getString("projectName"));// ��������(�����ලע��)
//	construction.setConfiguration(rs.getString("configuration"));// �ṹ/����(�����ලע��)
//	construction.setProjectAddress(rs.getString("projectAddress"));// ���̵ص�(�����ලע��)
//	construction.setContact(rs.getString("contact"));// ��ϵ��(�����ලע��)
//	construction.setConstructionArea(rs.getString("constructionArea"));// �������(ƽ����)(�����ලע��)
//	construction.setQuantities(rs.getString("quantities"));// ��װ������(��Ԫ)(�����ලע��)
//	construction.setExpensive(rs.getString("expensive"));// ���������(��Ԫ)(�����ලע��)
//	construction.setSuperviseCost(rs.getString("superviseCost"));// �ල��(Ԫ)(�����ලע��)
//	construction.setStartDate(rs.getDate("startDate"));// �ƻ���������(�����ලע��)
//	construction.setEndDate(rs.getDate("endDate"));// �ƻ���������(�����ලע��)
//	construction.setDevelopmentOrganization(rs.getString("developmentOrganization"));// ���赥λ(�����ලע��)
//	construction.setDevelopmentQualificationLevel(rs.getString("developmentQualificationLevel"));// ���赥λ���ʵȼ�(�����ලע��)
//	construction.setDevelopmentCharge(rs.getString("developmentCharge"));// ���赥λ��Ŀ������(�����ලע��)
//	construction.setDevelopmentPhone(rs.getString("developmentPhone"));// ���赥λ��ϵ�绰(�����ලע��)
//	construction.setSurveyUnit(rs.getString("surveyUnit"));// ���쵥λ(�����ලע��)
//	construction.setSurveyUnitQualificationLevel(rs.getString("surveyUnitQualificationLevel"));// ���쵥λ���ʵȼ�(�����ලע��)
//	construction.setSurveyUnitCharge(rs.getString("surveyUnitCharge"));// ���쵥λ��Ŀ������(�����ලע��)
//	construction.setSurveyUnitPhone(rs.getString("surveyUnitPhone"));// ���쵥λ��ϵ�绰(�����ලע��)
//	construction.setDesignUnit(rs.getString("designUnit"));// ��Ƶ�λ(�����ලע��)
//	construction.setDesignUnitQualificationLevel(rs.getString("designUnitQualificationLevel"));// ��Ƶ�λ���ʵȼ�(�����ලע��)
//	construction.setDesignUnitCharge(rs.getString("designUnitCharge"));// ��Ƶ�λ��Ŀ������(�����ලע��)
//	construction.setDesignUnitPhone(rs.getString("designUnitPhone"));// ��Ƶ�λ��ϵ�绰(�����ලע��)
//	construction.setSupervisionUnit(rs.getString("supervisionUnit"));// ����λ(�����ලע��)
//	construction.setSupervisionUnitQualLevel(rs.getString("supervisionUnitQualLevel"));// ����λ���ʵȼ�(�����ලע��)
//	construction.setSupervisionUnitEngineer(rs.getString("supervisionUnitEngineer"));// �ܼ�����ʦ(�����ලע��)
//	construction.setSupervisionUnitPhone(rs.getString("supervisionUnitPhone"));// ����λ��ϵ�绰(�����ලע��)
//	construction.setConstructionUnit(rs.getString("constructionUnit"));// ʩ����λ(�����ලע��)
//	construction.setConstructionUnitQualLevel(rs.getString("constructionUnitQualLevel"));// ʩ����λ���ʵȼ�(�����ලע��)
//	construction.setConstructionUnitProjectManager(rs.getString("constructionUnitProjectManager"));// ʩ����λ��Ŀ����(�����ලע��)
//	construction.setConstructionUnitPhone(rs.getString("constructionUnitPhone"));// ʩ����λ��ϵ�绰(�����ලע��)
//	construction.setConstructionPlans(rs.getString("constructionPlans"));// ʩ��ͼ������(�����ලע��)
//	construction.setConstructionPlansType(rs.getString("constructionPlansType"));// ʩ��ͼ���������(�����ලע��)
//	construction.setConstructionPlansCharge(rs.getString("constructionPlansCharge"));// ʩ��ͼ��������Ŀ������(�����ලע��)
//	construction.setConstructionPlansPhone(rs.getString("constructionPlansPhone"));// ʩ��ͼ��������ϵ�绰(�����ලע��)
//	// ----------------------------------�ʱ�����---------------------------------
//	construction.setConstructionContractFileNum(rs.getString("constructionContractFileNum"));// ʩ����ͬ�ļ���(�����ලע��)
//	construction.setConstructionOrganFileNum(rs.getString("constructionOrganFileNum"));// ʩ����֯����ļ���(�����ලע��)
//	construction.setConstructionPlansFileNum(rs.getString("constructionPlansFileNum"));// ʩ��ͼ��鱨�����׼���ļ���(�����ලע��)
//	construction.setSupervisionContractFileNum(rs.getString("supervisionContractFileNum"));// �����ͬ�ļ���(�����ලע��)
//	construction.setSupervisionPlanFileNum(rs.getString("supervisionPlanFileNum"));// ����滮�ļ���(�����ලע��)
//	construction.setFireControlFileNum(rs.getString("fireControlFileNum"));// ����������ϸ�����֤���ļ��ļ���(�����ලע��)
//	construction.setDevelopmentOrganFileNum(rs.getString("developmentOrganFileNum"));// ���赥λ��Ŀ�����˼���Ŀ��������ļ���(�����ලע��)
//	construction.setOnstructionUnitFileNum(rs.getString("onstructionUnitFileNum"));// ʩ����λ��Ŀ�����˼���Ŀ��������ļ���(�����ලע��)
//	construction.setSupervisionUnitFileNum(rs.getString("supervisionUnitFileNum"));// ����λ��Ŀ�����˼���Ŀ��������ļ���(�����ලע��)
//	construction.setConstructionSiteFileNum(rs.getString("constructionSiteFileNum"));// ʩ���ֳ���Ŀ�����ˡ�������Ա�ʸ�֤���ļ���(�����ලע��)
//	construction.setQualityTestingFileNum(rs.getString("qualityTestingFileNum"));// �������Ա��λ֤���ļ���(�����ලע��)
//	construction.setFieldSupervisionFileNum(rs.getString("fieldSupervisionFileNum"));// �ֳ�������Աע��ִҵ֤���ļ���(�����ලע��)
	
	
	construction.setCreatedate(rs.getDate("createdate"));
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
}
