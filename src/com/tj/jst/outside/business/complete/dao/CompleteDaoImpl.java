package com.tj.jst.outside.business.complete.dao;

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
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ��������
 * @author hhc
 *
 */
public class CompleteDaoImpl extends BaseDao implements ICompleteDao {

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
					Complete complete = new Complete();
					complete.setCompleteId(rs.getString("completeId"));//����
					complete.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					complete.setPrjName(rs.getString("prjName"));//��Ŀ����
					complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//ʩ�����֤���
					complete.setQcCorpName(rs.getString("qcCorpName"));
					complete.setQcCorpCode(rs.getString("qcCorpCode"));
					complete.setFactCost(rs.getString("factCost"));
					complete.setFactArea(rs.getString("factArea"));
					complete.setFactSize(rs.getString("factSize"));
					complete.setPrjStructureTypeNum(rs.getString("prjStructureTypeNum"));
					complete.setBDate(rs.getDate("bDate"));
					complete.setEDate(rs.getDate("eDate"));
					complete.setMark(rs.getString("mark"));
					complete.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
					complete.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					complete.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
					complete.setAppSteffId(rs.getString("appSteffId"));//������id
					complete.setAppSteffName(rs.getString("appSteffName"));//����������
					complete.setAppDate(rs.getDate("appDate"));//����ʱ��
					complete.setAppOpinion(rs.getString("appOpinion"));//�������
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					complete.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					complete.setProcessSteps(rs.getString("processSteps").trim());
					complete.setAppDept(rs.getString("appDept").trim());//������λid
					complete.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
					page.getData().add(complete);
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
	 * ������������
	 * @return
	 */
	public String add(Complete complete)
	{
		String completeId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBPROJECTFINISHMANAGE(completeId,PRJNUM,PRJNAME,"
					+ "builderLicenceNum,"
					+ "qcCorpName,qcCorpCode,factCost,factArea,"
					+ "factSize,prjStructureTypeNum,bDate,EDate,mark,"
					+ "prjId,createDate,applyCorpCode,applyCorpName,"
					+ "appType,processSteps,appDept,appDeptName,projectName,"
					+ "prjFinishNum,tenderNum,sectionName) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,completeId);//����
			pstmt.setString(2,complete.getPrjNum());//��Ŀ���
			pstmt.setString(3,complete.getPrjName());//��Ŀ����
			pstmt.setString(4,complete.getBuilderLicenceNum());//ʩ�����֤���
			pstmt.setString(5,complete.getQcCorpName());
			pstmt.setString(6,complete.getQcCorpCode());
			pstmt.setString(7,complete.getFactCost());
			pstmt.setString(8,complete.getFactArea());
			pstmt.setString(9,complete.getFactSize());
			pstmt.setString(10,complete.getPrjStructureTypeNum());
			pstmt.setDate(11, complete.getBDate());
			pstmt.setDate(12,complete.getEDate());
			pstmt.setString(13,complete.getMark());
			pstmt.setString(14,complete.getPrjId());//��Ŀ��������
			pstmt.setDate(15,new Date(new java.util.Date().getTime())); //��¼�Ǽ�����
			pstmt.setString(16,complete.getApplyCorpCode()); //������ҵ��֯��������
			pstmt.setString(17,complete.getApplyCorpName()); //������ҵ����
			/**
			 * ����״̬
			 * 0�����룬1������ͨ����2������δͨ��
			 */
			pstmt.setString(18,"0");//����״̬
			/**
			 * ���̲���
			 * 1:��Ŀ����
			 * 2:����׶Ρ���ƽ׶�
			 * 3:��ͬ������ʩ��ͼ��鱸��
			 * 4:�����ල����ȫ�ල
			 * 5:ʩ�����
			 * 6:��������
			 */
			pstmt.setString(19,"6");
			pstmt.setString(20,complete.getAppDept());//������λid
			pstmt.setString(21,complete.getAppDeptName());//������λ����
			pstmt.setString(22, complete.getProjectName());//��������
			pstmt.setString(23, complete.getPrjFinishNum());
			pstmt.setString(24, complete.getTenderNum());
			pstmt.setString(25, complete.getSectionName());
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
		return completeId;
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Complete queryById(String completeId)
	{

		Complete complete = new Complete();
		try {
			
			String qsql = "select * from TBPROJECTFINISHMANAGE where completeId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, completeId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				complete.setCompleteId(rs.getString("completeId"));//����
				complete.setPrjId(rs.getString("prjId"));//������Ŀ����
				complete.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				complete.setPrjName(rs.getString("prjName"));//��Ŀ����
				complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//ʩ�����֤���
				complete.setPrjFinishNum(rs.getString("prjFinishNum"));
				complete.setQcCorpName(rs.getString("qcCorpName"));
				complete.setQcCorpCode(rs.getString("qcCorpCode"));
				complete.setFactCost(rs.getString("factCost"));
				complete.setFactArea(rs.getString("factArea"));
				complete.setFactSize(rs.getString("factSize"));
				complete.setPrjStructureTypeNum(rs.getString("prjStructureTypeNum"));
				complete.setBDate(rs.getDate("bDate"));
				complete.setEDate(rs.getDate("eDate"));
				complete.setMark(rs.getString("mark"));
				complete.setPrjId(rs.getString("prjId"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				complete.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				complete.setAppDept(rs.getString("appDept").trim());//������λid
				complete.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				complete.setProjectName(rs.getString("projectName"));//��������
				complete.setPrjFinishNum(rs.getString("prjFinishNum"));
				complete.setTenderNum(rs.getString("tenderNum"));
				complete.setSectionName(rs.getString("sectionName"));
			}
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=7 order by num");
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
				pstmt.setString(1,completeId);
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
			complete.setAccessoryList(accessoryList);
			
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
		return complete;
	}
	
	/**
	 * �������������޸�
	 * @return
	 */
	public void modify(Complete complete)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			
			String sql = "update TBPROJECTFINISHMANAGE set PRJNUM=?,PRJNAME=?,"
					+ "builderLicenceNum=?,"
					+ "qcCorpName=?,qcCorpCode=?,factCost=?,factArea=?,"
					+ "factSize=?,prjStructureTypeNum=?,bDate=?,EDate=?,mark=?,"
					+ "prjId=?,appDept=?,appDeptName=?,projectName=?,sectionName=?,"
					+ "tenderNum=? where completeId=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,complete.getPrjNum());//��Ŀ���
			pstmt.setString(2,complete.getPrjName());//��Ŀ����
			pstmt.setString(3,complete.getBuilderLicenceNum());//ʩ�����֤���
			pstmt.setString(4,complete.getQcCorpName());
			pstmt.setString(5,complete.getQcCorpCode());
			pstmt.setString(6,complete.getFactCost());
			pstmt.setString(7,complete.getFactArea());
			pstmt.setString(8,complete.getFactSize());
			pstmt.setString(9,complete.getPrjStructureTypeNum());
			pstmt.setDate(10, complete.getBDate());
			pstmt.setDate(11,complete.getEDate());
			pstmt.setString(12,complete.getMark());
			pstmt.setString(13,complete.getPrjId());//��Ŀ��������
			pstmt.setString(14,complete.getAppDept());//������λid
			pstmt.setString(15,complete.getAppDeptName());//������λ����
			pstmt.setString(16, complete.getProjectName());//��������
			pstmt.setString(17, complete.getSectionName());
			pstmt.setString(18, complete.getTenderNum());
			pstmt.setString(19,complete.getCompleteId());//����
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
	public void delete(String completeId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTFINISHMANAGE where completeId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, completeId);//����
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,completeId);	
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
			pstmt.setString(1,completeId);	
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

	//�ṹ��ϵ
	public List<DictionaryClass> queryPrjStructureTypeNums()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from TBPRJSTRUCTURETYPEDIC ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("STRUCT"));
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
	 * ��������,ʩ�������Ϣ��ѯ
	 * @author Administrator
	 *
	 */
	public Page pagedTbInfoQuery(Condition condition)
	{
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					
				Permit pt = new Permit();
				pt.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				pt.setPrjName(rs.getString("prjName"));//��Ŀ����
				pt.setPrjSize(rs.getString("prjSize"));//�����ģ
				pt.setSectionName(rs.getString("sectionName"));//�������
				pt.setTenderNum(rs.getString("tenderNum"));//�б�֪ͨ����
				pt.setProjectName(rs.getString("projectName"));//��������
				pt.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//ʩ�����֤��
				pt.setCreateDate(rs.getDate("createDate"));
				page.getData().add(pt);
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
