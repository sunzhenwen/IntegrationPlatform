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
 * ��ͬ����
 * @author hhc
 *
 */
public class QueryContractFilingDaoImpl extends BaseDao implements IQueryContractFilingDao {

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
				contractFiling.setContractTypeNum(rs.getString("contractTypeNum").trim());//��ͬ���(TBCONTRACTTYPEDIC)
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
				 * ��Ŀ������3�����棬0�����룬1������ͨ����2������δͨ��
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
			}
			
//			if(contractFiling.getContractTypeNum().trim().equals("301") || contractFiling.getContractTypeNum().trim().equals("302") || contractFiling.getContractTypeNum().trim().equals("303"))
//			{
//				String sql = "select * from TB_CONTRACTINFO_BUSINESS where recordId=? order by PNUMBER asc";
//				//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
//				conn = ConnectionFactory.getBasicConnection();
//				pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, contractFiling.getRecordId());
//				rs = pstmt.executeQuery();
//				while(rs.next())
//				{
//					FileWorld fw = new FileWorld();
//					fw.setConId(rs.getString("conId"));//����
//					fw.setConName(rs.getString("conName"));//����
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
					construction.setAllArea(rs.getString("allArea"));
					construction.setAllInvest(rs.getString("allInvest"));
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
	 * �鿴��ͬ�б�
	 * @return
	 */
	public List<FileWorld> fileWorldList(String recordId)
	{
		String conType = "";
		List<FileWorld> list = new ArrayList<FileWorld>();
		try {
			
			String qsql = "select * from TB_CONTRACTINFO_BUSINESS where recordId=? order by PNUMBER asc";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
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
				//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
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
		Reader is = clob.getCharacterStream();// �õ���
		BufferedReader br = new BufferedReader(is);
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		while (s != null) {// ִ��ѭ�����ַ���ȫ��ȡ����ֵ��StringBuffer��StringBufferת��STRING
			sb.append(s);
			s = br.readLine();
		}
		reString = sb.toString();
		return reString;
	}
	
	/**
	 * �鿴��ͬ�б�
	 * @return
	 */
	public FileWorld fileWorld(String conId)
	{
		FileWorld fw = new FileWorld();
		try {
			
			String qsql = "select * from TB_CONTRACTINFO_BUSINESS where conId=? order by PNUMBER asc";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
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
	 * �鿴ͨ�ú�ͬ
	 * @return
	 */
	public FileWorld currencyFileWorld(String inCommon,String conType)
	{
		FileWorld fw = new FileWorld();
		try {
			String qsql = "select * from TB_CONTRACTINFO where conType=? and inCommon=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
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
