package com.tj.jst.outside.business.queryBusiness.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
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
import com.tj.jst.base.util.UtilDecode;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.constructionFiling.fileWorld.model.FileWorld;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 合同备案
 * @author hhc
 *
 */
public class QueryContractFilingDaoImpl extends BaseDao implements IQueryContractFilingDao {

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
					ContractFiling contractFiling = new ContractFiling();
					
					contractFiling.setRecordId(rs.getString("recordId"));//主键
					contractFiling.setRecordNum(rs.getString("recordNum"));//合同备案编号
					contractFiling.setPrjNum(rs.getString("prjNum"));//项目编号
					contractFiling.setPrjName(rs.getString("prjName"));//项目名称
					contractFiling.setContractNum(rs.getString("contractNum"));//合同编号
					contractFiling.setContractTypeNum(rs.getString("contractTypeNum"));//合同类别(TBCONTRACTTYPEDIC)
					contractFiling.setContractTypeName(rs.getString("contractTypeName"));//合同类别名称
					contractFiling.setContractMoney(rs.getString("contractMoney"));//合同金额(万元)
					contractFiling.setPrjSize(rs.getString("prjSize"));//建设规模
					contractFiling.setContractDate(rs.getDate("contractDate"));//合同签订日期
					contractFiling.setPropietorCorpName(rs.getString("propietorCorpName"));//发包单位名称
					contractFiling.setPropietorCorpCode(rs.getString("propietorCorpCode"));//发包单位住组织代码
					contractFiling.setContractorCorpName(rs.getString("contractorCorpName"));//承包单位名称
					contractFiling.setContractorCorpCode(rs.getString("contractorCorpCode"));//承包单位组织代码
					contractFiling.setUnionCorpName(rs.getString("unionCorpName"));//联合体承包单位名称
					contractFiling.setUnionCorpCode(rs.getString("unionCorpCode"));//联合体承包单位组织代码
					contractFiling.setCreateDate(rs.getDate("createDate"));//记录登记时间
					contractFiling.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
					contractFiling.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
					contractFiling.setAppSteffId(rs.getString("appSteffId"));//审批人id
					contractFiling.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
					contractFiling.setAppDate(rs.getDate("appDate"));//审批时间
					contractFiling.setAppOpinion(rs.getString("appOpinion"));//审批意见
					/**
					 * 审批状态
					 * 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					contractFiling.setAppType(rs.getString("appType").trim());//审批状态
					/**
					 * 流程步骤
					 * 1:项目报建
					 * 2:勘察阶段、设计阶段
					 * 3:合同备案、施工图审查备案
					 * 4:质量监督、安全监督
					 * 5:施工许可
					 * 6:竣工验收
					 */
					contractFiling.setProcessSteps(rs.getString("processSteps").trim());
					contractFiling.setAppDept(rs.getString("appDept").trim());//审批单位id
					contractFiling.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
					contractFiling.setAuCorpName(rs.getString("auCorpName"));
					contractFiling.setAuCorpCode(rs.getString("auCorpCode"));
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
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public ContractFiling queryById(String recordId)
	{

		ContractFiling contractFiling = new ContractFiling();
		try {
			
			String qsql = "select * from v_tbcontractrecordmanage where recordId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, recordId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				contractFiling.setRecordId(rs.getString("recordId"));//主键
				contractFiling.setRecordNum(rs.getString("recordNum"));//合同备案编号
				contractFiling.setPrjNum(rs.getString("prjNum"));//项目编号
				contractFiling.setPrjName(rs.getString("prjName"));//项目名称
				contractFiling.setContractNum(rs.getString("contractNum"));//合同编号
				contractFiling.setContractTypeNum(rs.getString("contractTypeNum").trim());//合同类别(TBCONTRACTTYPEDIC)
				contractFiling.setContractTypeName(rs.getString("contractTypeName"));//合同类别名称
				contractFiling.setContractMoney(rs.getString("contractMoney"));//合同金额(万元)
				contractFiling.setPrjSize(rs.getString("prjSize"));//建设规模
				contractFiling.setContractDate(rs.getDate("contractDate"));//合同签订日期
				contractFiling.setPropietorCorpName(rs.getString("propietorCorpName"));//发包单位名称
				contractFiling.setPropietorCorpCode(rs.getString("propietorCorpCode"));//发包单位住组织代码
				contractFiling.setContractorCorpName(rs.getString("contractorCorpName"));//承包单位名称
				contractFiling.setContractorCorpCode(rs.getString("contractorCorpCode"));//承包单位组织代码
				contractFiling.setUnionCorpName(rs.getString("unionCorpName"));//联合体承包单位名称
				contractFiling.setUnionCorpCode(rs.getString("unionCorpCode"));//联合体承包单位组织代码
				contractFiling.setCreateDate(rs.getDate("createDate"));//记录登记时间
				contractFiling.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				contractFiling.setApplyCorpName(rs.getString("applyCorpName"));//申请企业名称
				contractFiling.setAppSteffId(rs.getString("appSteffId"));//审批人id
				contractFiling.setAppSteffName(rs.getString("appSteffName"));//审批人姓名
				contractFiling.setAppDate(rs.getDate("appDate"));//审批时间
				contractFiling.setAppOpinion(rs.getString("appOpinion"));//审批意见
				/**
				 * 审批状态
				 * 项目报建：3、保存，0、申请，1、审批通过，2、审批未通过
				 */
				contractFiling.setAppType(rs.getString("appType").trim());//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				contractFiling.setProcessSteps(rs.getString("processSteps").trim());
				contractFiling.setAppDept(rs.getString("appDept").trim());//审批单位id
				contractFiling.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
			}
			
//			if(contractFiling.getContractTypeNum().trim().equals("301") || contractFiling.getContractTypeNum().trim().equals("302") || contractFiling.getContractTypeNum().trim().equals("303"))
//			{
//				String sql = "select * from TB_CONTRACTINFO_BUSINESS where recordId=? order by PNUMBER asc";
//				//获取基础数据库链接，首先从基础数据库查询
//				conn = ConnectionFactory.getBasicConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, contractFiling.getRecordId());
//				rs = pstmt.executeQuery();
//				while(rs.next())
//				{
//					FileWorld fw = new FileWorld();
//					fw.setConId(rs.getString("conId"));//主键
//					fw.setConName(rs.getString("conName"));//名称
//					contractFiling.getWorldList().add(fw);
//				}
//			}
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,recordId);
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
			contractFiling.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return contractFiling;
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
	
	//合同类别
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
	 * 查询
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
					construction.setPrjId(rs.getString("prjId"));//主键
					construction.setPrjNum(rs.getString("prjNum"));//项目编号
					construction.setPrjName(rs.getString("prjName"));//项目名称
					construction.setAllArea(rs.getString("allArea"));
					construction.setAllInvest(rs.getString("allInvest"));
					construction.setCreateDate(rs.getDate("createDate"));
					construction.setAppDept(rs.getString("appDept"));//审批单位
					construction.setAppDeptName(rs.getString("appDeptName"));//审批单位名称
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
	 * 查看合同列表
	 * @return
	 */
	public List<FileWorld> fileWorldList(String recordId)
	{
		String conType = "";
		List<FileWorld> list = new ArrayList<FileWorld>();
		try {
			
			String qsql = "select * from TB_CONTRACTINFO_BUSINESS where recordId=? order by PNUMBER asc";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, recordId);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				FileWorld fw = new FileWorld();
				fw.setConId(rs.getString("conId"));
				fw.setConName(rs.getString("conName"));
				fw.setZhConName(UtilDecode.transformation(rs.getString("conName")));
				conType = rs.getString("conType");
				fw.setConType(conType);
				fw.setLinkAddress(rs.getString("linkAddress"));
				fw.setCreateDate(rs.getDate("createDate"));
				fw.setCheckType("1");
				fw.setRecordId(rs.getString("recordId"));
				fw.setTemplateId(rs.getString("templateId"));
				fw.setPnumber(rs.getInt("pnumber"));
				list.add(fw);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		if(!"".equals(conType))
		{
			try {
				
				String qsql = "select * from TB_CONTRACTINFO where conType=? and inCommon=0";
				//获取基础数据库链接，首先从基础数据库查询
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(qsql);
				pstmt.setString(1, conType);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					FileWorld fw = new FileWorld();
					fw.setConId(rs.getString("conId"));
					fw.setConName(rs.getString("conName"));
					fw.setZhConName(UtilDecode.transformation(rs.getString("conName")));
					fw.setConType(rs.getString("conType"));
					fw.setLinkAddress(rs.getString("linkAddress"));
					fw.setPnumber(rs.getInt("pnumber"));
					fw.setInCommon(rs.getString("inCommon"));
					list.add(fw);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}
		}
		return list;
	}
	
	public String ClobToString(Clob clob) throws SQLException, IOException {

		String reString = "";
		Reader is = clob.getCharacterStream();// 得到流
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}
	
	/**
	 * 查看合同列表
	 * @return
	 */
	public FileWorld fileWorld(String conId)
	{
		FileWorld fw = new FileWorld();
		try {
			
			String qsql = "select * from TB_CONTRACTINFO_BUSINESS where conId=? order by PNUMBER asc";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, conId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				
				fw.setConId(rs.getString("conId"));
				fw.setConName(rs.getString("conName"));
				fw.setConType(rs.getString("conType"));
				fw.setLinkAddress(rs.getString("linkAddress"));
				fw.setCreateDate(rs.getDate("createDate"));
				fw.setCheckType("1");
				fw.setRecordId(rs.getString("recordId"));
				fw.setTemplateId(rs.getString("templateId"));
				fw.setPnumber(rs.getInt("pnumber"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return fw;
	}
	
	/**
	 * 查看通用合同
	 * @return
	 */
	public FileWorld currencyFileWorld(String inCommon,String conType)
	{
		FileWorld fw = new FileWorld();
		try {
			String qsql = "select * from TB_CONTRACTINFO where conType=? and inCommon=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, conType);
			pstmt.setString(2, inCommon);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				fw.setConId(rs.getString("conId"));
				fw.setConName(rs.getString("conName"));
				fw.setConType(rs.getString("conType"));
				fw.setLinkAddress(rs.getString("linkAddress")+"\\"+rs.getString("conName")+".doc");
				fw.setPnumber(rs.getInt("pnumber"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return fw;
	}
}
