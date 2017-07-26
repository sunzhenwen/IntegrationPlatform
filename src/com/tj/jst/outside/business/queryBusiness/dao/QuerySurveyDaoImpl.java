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
import com.tj.jst.outside.business.survey.model.Survey;
import com.tj.jst.outside.business.survey.model.SurveyQualification;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ����
 * @author hhc
 *
 */
public class QuerySurveyDaoImpl extends BaseDao implements IQuerySurveyDao {

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
					Survey survey = new Survey();
					
					survey.setPrjId(rs.getString("prjId"));//����
					survey.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					survey.setPrjName(rs.getString("prjName"));//��Ŀ����
					survey.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					survey.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					survey.setProcessSteps(rs.getString("processSteps").trim());
					survey.setSurveyId(rs.getString("surveyId"));//��������
					survey.setSurveyNum(rs.getString("surveyNum"));//�������
					survey.setSurveyCorpName(rs.getString("surveyCorpName"));//��Ƶ�λ����
					survey.setSurveyCorpCode(rs.getString("surveyCorpCode"));//��Ƶ�λ��֯��������
					survey.setIsUnits(rs.getString("isUnits"));//��Ƶ�λ�Ƿ���д���� 0:�� 1:��
					survey.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					page.getData().add(survey);
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
	public Survey queryById(String surveyId)
	{

		Survey survey = new Survey();
		try {
			
			String qsql = "select * from survey_business where surveyId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, surveyId);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				survey.setSurveyId(rs.getString("SURVEYID"));//����
				survey.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				survey.setPrjName(rs.getString("prjName"));//��Ŀ����
				survey.setSurveyNum(rs.getString("SURVEYNUM"));//�������
				survey.setSurveyCorpName(rs.getString("SURVEYCorpName"));//���쵥λ����
				survey.setSurveyCorpCode(rs.getString("SURVEYCorpCode"));//���쵥λ��֯��������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				survey.setAppType(rs.getString("appType"));//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				survey.setProcessSteps(rs.getString("processSteps"));
				survey.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				survey.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
				survey.setAppDept(rs.getString("appDept").trim());//������λid
				survey.setAppDeptName(rs.getString("appDeptName"));//������λ����
				survey.setIsUnits(rs.getString("isUnits").trim());//�Ƿ�λ����   0���ǣ�1����
				survey.setPrjId(rs.getString("prjId"));//��Ŀ����id
			}
			
			if(survey.getIsUnits().equals("0"))
			{
				pstmt = conn.prepareStatement("select * from SURVEY_QUALIFICATION where SURVEYID=?");
				pstmt.setString(1, surveyId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					SurveyQualification surveyQualification = new SurveyQualification();
					surveyQualification.setId(rs.getString("id"));
					surveyQualification.setSurveyId(rs.getString("SURVEYID"));
					surveyQualification.setTitleLevelName(rs.getString("titleLevelName"));
					surveyQualification.setCertTypeName(rs.getString("certTypeName"));
					surveyQualification.setCertId(rs.getString("certId"));
					surveyQualification.setQualifName(rs.getString("qualifName"));
					survey.getSurveyQualis().add(surveyQualification);
				}
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,surveyId);
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
			survey.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return survey;
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
