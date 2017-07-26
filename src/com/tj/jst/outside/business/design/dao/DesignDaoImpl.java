package com.tj.jst.outside.business.design.dao;

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
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.design.model.Design;
import com.tj.jst.outside.business.design.model.DesignQualification;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ���
 * @author hhc
 *
 */
public class DesignDaoImpl extends BaseDao implements IDesignDao {

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
					Design design = new Design();
					
					design.setPrjId(rs.getString("prjId"));//����
					design.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					design.setPrjName(rs.getString("prjName"));//��Ŀ����
					design.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					design.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					design.setProcessSteps(rs.getString("processSteps").trim());
					//------------------------------------------���-------------------------------------------
					design.setDesignId(rs.getString("designId"));//�������
					design.setDesignNum(rs.getString("designNum"));//��Ʊ���
					design.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
					design.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
					design.setIsUnits(rs.getString("isUnits"));//��Ƶ�λ�Ƿ���д���� 0:�� 1:��
					design.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					page.getData().add(design);
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
	 * �������
	 * @return
	 */
	public String add(Design design,List<DesignQualification> designQualifications)
	{
		String designId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into DESIGN_BUSINESS(designId,prjNum,prjName,"
					+ "designCorpName,DESIGNCORPCODE,appType,processSteps,applyCorpCode,"
					+ "createDate,appDept,appDeptName,isUnits,PRJID,corpName,designNum) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,designId);	//����
			pstmt.setString(2, design.getPrjNum());//��Ŀ���
			pstmt.setString(3, design.getPrjName()); //��Ŀ����
			pstmt.setString(4, design.getDesignCorpName()); //��Ƶ�λ����
			pstmt.setString(5, design.getDesignCorpCode()); //��Ƶ�λ��֯��������
			/**
			 * ����״̬
			 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
			 */
			pstmt.setString(6, "0");//����״̬
			/**
			 * ���̲���
			 * 1:��Ŀ����
			 * 2:����׶Ρ���ƽ׶�
			 * 3:��ͬ������ʩ��ͼ��鱸��
			 * 4:�����ල����ȫ�ල
			 * 5:ʩ�����
			 * 6:��������
			 */
			pstmt.setString(7, "2");
			pstmt.setString(8, design.getApplyCorpCode());//������ҵ��֯��������
			pstmt.setDate(9, new Date(new java.util.Date().getTime()));//��¼�Ǽ�ʱ��
			pstmt.setString(10, design.getAppDept().trim());//������λid
			pstmt.setString(11, design.getAppDeptName());//������λ����
			pstmt.setString(12, design.getIsUnits().trim());//�Ƿ�λ����   0���ǣ�1����
			pstmt.setString(13, design.getPrjId());//��Ŀ����id
			pstmt.setString(14, design.getCorpName());//���赥λ
			pstmt.setString(15, design.getDesignNum());//��Ʊ���
			pstmt.executeUpdate();
			if(design.getIsUnits().equals("0"))
			{
				for(int i=0;i<designQualifications.size();i++)
				{
					if(designQualifications.get(i)!=null)
					{
						String id = UUID.randomUUID().toString();
						pstmt = conn.prepareStatement("insert into DESIGN_QUALIFICATION(ID,DESIGNID,"
								+ "CERTTYPENAME,TITLELEVELNAME,CERTID,QUALIFNAME) values(?,?,?,?,?,?)");
						pstmt.setString(1,id);	
						pstmt.setString(2,designId); 
						pstmt.setString(3,designQualifications.get(i).getCertTypeName()); 
						pstmt.setString(4,designQualifications.get(i).getTitleLevelName()); 
						pstmt.setString(5,designQualifications.get(i).getCertId()); 
						pstmt.setString(6, designQualifications.get(i).getQualifName());
						pstmt.executeUpdate();
					}
				}
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
		return designId;
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Design queryById(String designId)
	{

		Design design = new Design();
		try {
			
			String qsql = "select * from DESIGN_BUSINESS where designId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, designId);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				design.setDesignId(rs.getString("designId"));//����
				design.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				design.setPrjName(rs.getString("prjName"));//��Ŀ����
				design.setDesignNum(rs.getString("designNum"));//��Ʊ���
				design.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
				design.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				design.setAppType(rs.getString("appType"));//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				design.setProcessSteps(rs.getString("processSteps"));
				design.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				design.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
				design.setAppDept(rs.getString("appDept").trim());//������λid
				design.setAppDeptName(rs.getString("appDeptName"));//������λ����
				design.setIsUnits(rs.getString("isUnits").trim());//�Ƿ�λ����   0���ǣ�1����
				design.setPrjId(rs.getString("prjId"));//��Ŀ����id
				design.setCorpName(rs.getString("corpName"));//���赥λ
			}
			
			if(design.getIsUnits().equals("0"))
			{
				pstmt = conn.prepareStatement("select * from DESIGN_QUALIFICATION where DESIGNID=?");
				pstmt.setString(1, designId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					DesignQualification designQualification = new DesignQualification();
					designQualification.setId(rs.getString("id"));
					designQualification.setDesignId(rs.getString("designId"));
					designQualification.setTitleLevelName(rs.getString("titleLevelName"));
					designQualification.setCertTypeName(rs.getString("certTypeName"));
					designQualification.setCertId(rs.getString("certId"));
					designQualification.setQualifName(rs.getString("qualifName"));
					design.getDesignQualifications().add(designQualification);
				}
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,designId);
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
			design.setList(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return design;
	}
	
	/**
	 * ��������޸�
	 * @return
	 */
	public void modify(Design design,List<DesignQualification> designQualifications)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update DESIGN_BUSINESS set designCorpName=?,designCorpCode=?,appDept=?,"
					+ "APPDEPTNAME=?,isUnits=? where designId=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, design.getDesignCorpName());
			pstmt.setString(2, design.getDesignCorpCode());
			pstmt.setString(3, design.getAppDept());
			pstmt.setString(4, design.getAppDeptName());
			pstmt.setString(5, design.getIsUnits());
			pstmt.setString(6, design.getDesignId());
			pstmt.executeUpdate();
			
			if(design.getIsUnits().trim().equals("0"))
			{
				
				pstmt = conn.prepareStatement("delete from DESIGN_QUALIFICATION where designId=?");
				pstmt.setString(1,design.getDesignId());	
				pstmt.executeUpdate();
				
				for(int i=0;i<designQualifications.size();i++)
				{
					if(designQualifications.get(i)!=null)
					{
						String id = UUID.randomUUID().toString();
						pstmt = conn.prepareStatement("insert into DESIGN_QUALIFICATION(ID,DESIGNID,"
								+ "CERTTYPENAME,TITLELEVELNAME,CERTID,qualifName) values(?,?,?,?,?,?)");
						pstmt.setString(1,id);	
						pstmt.setString(2,design.getDesignId()); 
						pstmt.setString(3,designQualifications.get(i).getCertTypeName()); 
						pstmt.setString(4,designQualifications.get(i).getTitleLevelName()); 
						pstmt.setString(5,designQualifications.get(i).getCertId()); 
						pstmt.setString(6,designQualifications.get(i).getQualifName());
						pstmt.executeUpdate();
					}
				}
			}else
			{
				pstmt = conn.prepareStatement("delete from DESIGN_QUALIFICATION where DESIGNID=?");
				pstmt.setString(1,design.getDesignId());	
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
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String designId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from DESIGN_QUALIFICATION where designId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, designId);//����
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from DESIGN_BUSINESS where designId=? ");
			pstmt.setString(1, designId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,designId);	
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
			pstmt.setString(1,designId);	
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
}
