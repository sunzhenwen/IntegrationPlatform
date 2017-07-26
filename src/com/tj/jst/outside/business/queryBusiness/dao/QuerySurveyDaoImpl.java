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
 * 勘察
 * @author hhc
 *
 */
public class QuerySurveyDaoImpl extends BaseDao implements IQuerySurveyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 查询
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
					
					survey.setPrjId(rs.getString("prjId"));//主键
					survey.setPrjNum(rs.getString("prjNum"));//项目编号
					survey.setPrjName(rs.getString("prjName"));//项目名称
					survey.setCreateDate(rs.getDate("createDate"));//记录登记时间
					/**
					 * 审批状态
					 * 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					survey.setAppType(rs.getString("appType").trim());//审批状态
					/**
					 * 流程步骤
					 * 1:项目报建
					 * 2:勘察阶段、设计阶段
					 * 3:合同备案、施工图审查备案
					 * 4:质量监督、安全监督
					 * 5:施工许可
					 * 6:竣工验收
					 */
					survey.setProcessSteps(rs.getString("processSteps").trim());
					survey.setSurveyId(rs.getString("surveyId"));//勘察主键
					survey.setSurveyNum(rs.getString("surveyNum"));//勘察编码
					survey.setSurveyCorpName(rs.getString("surveyCorpName"));//设计单位名称
					survey.setSurveyCorpCode(rs.getString("surveyCorpCode"));//设计单位组织机构代码
					survey.setIsUnits(rs.getString("isUnits"));//设计单位是否填写资质 0:是 1:否
					survey.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
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
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Survey queryById(String surveyId)
	{

		Survey survey = new Survey();
		try {
			
			String qsql = "select * from survey_business where surveyId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, surveyId);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				survey.setSurveyId(rs.getString("SURVEYID"));//主键
				survey.setPrjNum(rs.getString("prjNum"));//项目编号
				survey.setPrjName(rs.getString("prjName"));//项目名称
				survey.setSurveyNum(rs.getString("SURVEYNUM"));//勘察编码
				survey.setSurveyCorpName(rs.getString("SURVEYCorpName"));//勘察单位名称
				survey.setSurveyCorpCode(rs.getString("SURVEYCorpCode"));//勘察单位组织机构代码
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				survey.setAppType(rs.getString("appType"));//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				survey.setProcessSteps(rs.getString("processSteps"));
				survey.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				survey.setCreateDate(rs.getDate("createDate"));//记录登记时间
				survey.setAppDept(rs.getString("appDept").trim());//审批单位id
				survey.setAppDeptName(rs.getString("appDeptName"));//审批单位名称
				survey.setIsUnits(rs.getString("isUnits").trim());//是否单位工程   0：是，1：否
				survey.setPrjId(rs.getString("prjId"));//项目报建id
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
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		//查询黑龙江
		String sql = "select * from TBXZQDMDIC where name like '%黑龙江%'";
		List<Regional> list = new ArrayList<Regional>();
		//省Id
		String prId = "";
		//市Id
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
			//查询市
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
			//查询区县
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
	 * 根据树形排序id查询区域编码
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
