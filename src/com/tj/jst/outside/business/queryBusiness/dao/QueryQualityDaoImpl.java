package com.tj.jst.outside.business.queryBusiness.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * �����ල
 * @author hhc
 *
 */
public class QueryQualityDaoImpl extends BaseDao implements IQueryQualityDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
					quality.setAuCorpName(rs.getString("auCorpName"));
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
				quality.setJianduzhuceNum(rs.getString("jianDuZhuCeNum"));//�ලע���
				quality.setWenjianNum(rs.getString("wenJianNum"));//�ļ����
				quality.setQualityNum(rs.getString("qualityNum"));
			}
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,qualityId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
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
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
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

}
