package com.tj.jst.outside.business.constructionPlans.dao;

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
import com.tj.jst.outside.business.constructionPlans.model.ConstructionPlans;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ʩ��ͼ���
 * @author hhc
 *
 */
public class ConstructionPlansDaoImpl extends BaseDao implements IConstructionPlansDao {

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
					ConstructionPlans constructionPlans = new ConstructionPlans();
					constructionPlans.setCensorId(rs.getInt("censorId"));//����
					constructionPlans.setCensorNum(rs.getString("censorNum"));//ʩ��ͼ���ϸ�֤����
					constructionPlans.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					constructionPlans.setPrjName(rs.getString("prjName"));//��Ŀ����
					constructionPlans.setCensorCorpName(rs.getString("censorCorpName"));//ʩ��ͼ����������
					constructionPlans.setCensorCorpCode(rs.getString("censorCorpCode"));//ʩ��ͼ��������֯��������
					constructionPlans.setCensorEDate(rs.getDate("censorEDate"));//����������
					constructionPlans.setPrjSize(rs.getString("prjSize"));//�����ģ
					constructionPlans.setEconCorpName(rs.getString("econCorpName"));//���쵥λ����
					constructionPlans.setEconCorpCode(rs.getString("econCorpCode"));//���쵥λ��֯��������
					constructionPlans.setEconCorpName2(rs.getString("econCorpName2"));//���쵥λ����2
					constructionPlans.setEconCorpCode2(rs.getString("econCorpCode2")); //���쵥λ��֯��������2
					constructionPlans.setEconCorpName3(rs.getString("econCorpName3"));//���쵥λ����3
					constructionPlans.setEconCorpCode3(rs.getString("econCorpCode3")); //���쵥λ��֯��������3
					constructionPlans.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
					constructionPlans.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
					constructionPlans.setDesignCorpName2(rs.getString("designCorpName2"));//��Ƶ�λ����2
					constructionPlans.setDesignCorpCode2(rs.getString("designCorpCode2"));//��Ƶ�λ��֯��������2
					constructionPlans.setDesignCorpName3(rs.getString("designCorpName3"));//��Ƶ�λ����3
					constructionPlans.setDesignCorpCode3(rs.getString("designCorpCode3"));//��Ƶ�λ��֯��������3
					constructionPlans.setOneCensorIsPass(rs.getString("oneCensorIsPass"));//һ������Ƿ�ͨ�� ͨ��1����ͨ��0
					constructionPlans.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));//һ�����ʱΥ��ǿ����
					constructionPlans.setOneCensorWfqtContent(rs.getString("oneCensorWfqtContent"));//һ�����ʱΥ����ǿ����Ŀ
					constructionPlans.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
					constructionPlans.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					constructionPlans.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
					constructionPlans.setAppSteffId(rs.getString("appSteffId"));//������id
					constructionPlans.setAppSteffName(rs.getString("appSteffName"));//����������
					constructionPlans.setAppDate(rs.getDate("appDate"));//����ʱ��
					constructionPlans.setAppOpinion(rs.getString("appOpinion"));//�������
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					constructionPlans.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					constructionPlans.setProcessSteps(rs.getString("processSteps").trim());
					constructionPlans.setAppDept(rs.getString("appDept").trim());//������λid
					constructionPlans.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
					page.getData().add(constructionPlans);
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
	 * ʩ��ͼ�������
	 * @return
	 */
	public String add(ConstructionPlans constructionPlans)
	{
		String censorId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBPROJECTCENSORINFO(censorId,PRJNUM,PRJNAME,"
					+ "prjId,censorCorpName,censorCorpCode,censorEDate,prjSize,"
					+ "econCorpName,econCorpCode,econCorpName2,econCorpCode2,"
					+ "econCorpName3,econCorpCode3,designCorpName,designCorpCode,designCorpName2,"
					+ "designCorpCode2,designCorpName3,designCorpCode3,oneCensorIsPass,"
					+ "oneCensorWfqtCount,oneCensorWfqtContent,createDate,applyCorpCode,"
					+ "applyCorpName,appType,processSteps,appDept,appDeptName,censorNum) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,censorId);//����
			pstmt.setString(2,constructionPlans.getPrjNum());//��Ŀ���
			pstmt.setString(3,constructionPlans.getPrjName());//��Ŀ����
			pstmt.setString(4,constructionPlans.getPrjId());//��Ŀ��������
			pstmt.setString(5,constructionPlans.getCensorCorpName());//ʩ��ͼ����������
			pstmt.setString(6,constructionPlans.getCensorCorpCode());//ʩ��ͼ��������֯��������
			pstmt.setDate(7,constructionPlans.getCensorEDate());//����������
			pstmt.setString(8,constructionPlans.getPrjSize());//�����ģ
			pstmt.setString(9,constructionPlans.getEconCorpName());//���쵥λ����
			pstmt.setString(10,constructionPlans.getEconCorpCode());//���쵥λ��֯��������
			pstmt.setString(11,constructionPlans.getEconCorpName2());//���쵥λ����2
			pstmt.setString(12,constructionPlans.getEconCorpCode2());//���쵥λ��֯��������2
			pstmt.setString(13,constructionPlans.getEconCorpName3());//���쵥λ����3
			pstmt.setString(14,constructionPlans.getEconCorpCode3());//���쵥λ��֯��������3
			pstmt.setString(15,constructionPlans.getDesignCorpName());//��Ƶ�λ����
			pstmt.setString(16,constructionPlans.getDesignCorpCode());//��Ƶ�λ��֯��������
			pstmt.setString(17,constructionPlans.getDesignCorpName2());//��Ƶ�λ����2
			pstmt.setString(18,constructionPlans.getDesignCorpCode2());//��Ƶ�λ��֯��������2
			pstmt.setString(19,constructionPlans.getDesignCorpName3());//��Ƶ�λ����3
			pstmt.setString(20,constructionPlans.getDesignCorpCode3());//��Ƶ�λ��֯��������3
			pstmt.setString(21,constructionPlans.getOneCensorIsPass());//һ������Ƿ�ͨ�� ͨ��1����ͨ��0
			pstmt.setString(22,constructionPlans.getOneCensorWfqtCount());//һ�����ʱΥ��ǿ����
			pstmt.setString(23,constructionPlans.getOneCensorWfqtContent());//һ�����ʱΥ����ǿ����Ŀ
			pstmt.setDate(24,new Date(new java.util.Date().getTime())); //��¼�Ǽ�����
			pstmt.setString(25,constructionPlans.getApplyCorpCode()); //������ҵ��֯��������
			pstmt.setString(26,constructionPlans.getApplyCorpName()); //������ҵ����
			/**
			 * ����״̬
			 * 0�����룬1������ͨ����2������δͨ��
			 */
			pstmt.setString(27,"0");//����״̬
			/**
			 * ���̲���
			 * 1:��Ŀ����
			 * 2:����׶Ρ���ƽ׶�
			 * 3:��ͬ������ʩ��ͼ��鱸��
			 * 4:�����ල����ȫ�ල
			 * 5:ʩ�����
			 * 6:��������
			 */
			pstmt.setString(28,"3");
			pstmt.setString(29,constructionPlans.getAppDept());//������λid
			pstmt.setString(30,constructionPlans.getAppDeptName());//������λ����
			pstmt.setString(31, constructionPlans.getCensorNum());//ʩ��ͼ���ϸ�֤����
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
		return censorId;
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public ConstructionPlans queryById(String censorId)
	{

		ConstructionPlans constructionPlans = new ConstructionPlans();
		try {
			
			String qsql = "select * from TBPROJECTCENSORINFO where censorId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, censorId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				constructionPlans.setCensorId(rs.getInt("censorId"));//����
				constructionPlans.setCensorNum(rs.getString("censorNum"));//ʩ��ͼ���ϸ�֤����
				constructionPlans.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				constructionPlans.setPrjName(rs.getString("prjName"));//��Ŀ����
				constructionPlans.setCensorCorpName(rs.getString("censorCorpName"));//ʩ��ͼ����������
				constructionPlans.setCensorCorpCode(rs.getString("censorCorpCode"));//ʩ��ͼ��������֯��������
				constructionPlans.setCensorEDate(rs.getDate("censorEDate"));//����������
				constructionPlans.setPrjSize(rs.getString("prjSize"));//�����ģ
				constructionPlans.setEconCorpName(rs.getString("econCorpName"));//���쵥λ����
				constructionPlans.setEconCorpCode(rs.getString("econCorpCode"));//���쵥λ��֯��������
				constructionPlans.setEconCorpName2(rs.getString("econCorpName2"));//���쵥λ����2
				constructionPlans.setEconCorpCode2(rs.getString("econCorpCode2")); //���쵥λ��֯��������2
				constructionPlans.setEconCorpName3(rs.getString("econCorpName3"));//���쵥λ����3
				constructionPlans.setEconCorpCode3(rs.getString("econCorpCode3")); //���쵥λ��֯��������3
				constructionPlans.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
				constructionPlans.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
				constructionPlans.setDesignCorpName2(rs.getString("designCorpName2"));//��Ƶ�λ����2
				constructionPlans.setDesignCorpCode2(rs.getString("designCorpCode2"));//��Ƶ�λ��֯��������2
				constructionPlans.setDesignCorpName3(rs.getString("designCorpName3"));//��Ƶ�λ����3
				constructionPlans.setDesignCorpCode3(rs.getString("designCorpCode3"));//��Ƶ�λ��֯��������3
				constructionPlans.setOneCensorIsPass(rs.getString("oneCensorIsPass"));//һ������Ƿ�ͨ�� ͨ��1����ͨ��0
				constructionPlans.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));//һ�����ʱΥ��ǿ����
				constructionPlans.setOneCensorWfqtContent(rs.getString("oneCensorWfqtContent"));//һ�����ʱΥ����ǿ����Ŀ
				constructionPlans.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
				constructionPlans.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				constructionPlans.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				constructionPlans.setAppSteffId(rs.getString("appSteffId"));//������id
				constructionPlans.setAppSteffName(rs.getString("appSteffName"));//����������
				constructionPlans.setAppDate(rs.getDate("appDate"));//����ʱ��
				constructionPlans.setAppOpinion(rs.getString("appOpinion"));//�������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				constructionPlans.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				constructionPlans.setProcessSteps(rs.getString("processSteps").trim());
				constructionPlans.setAppDept(rs.getString("appDept").trim());//������λid
				constructionPlans.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				constructionPlans.setPrjId(rs.getString("prjId"));
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,censorId);
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
			constructionPlans.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return constructionPlans;
	}
	
	/**
	 * ��ͬ���������޸�
	 * @return
	 */
	public void modify(ConstructionPlans constructionPlans)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBPROJECTCENSORINFO set PRJNUM=?,PRJNAME=?,"
					+ "prjId=?,censorCorpName=?,censorCorpCode=?,censorEDate=?,prjSize=?,"
					+ "econCorpName=?,econCorpCode=?,econCorpName2=?,econCorpCode2=?,"
					+ "econCorpName3=?,econCorpCode3=?,designCorpName=?,designCorpCode=?,"
					+ "designCorpName2=?,designCorpCode2=?,designCorpName3=?,designCorpCode3=?,"
					+ "oneCensorIsPass=?,oneCensorWfqtCount=?,oneCensorWfqtContent=?,"
					+ "appDept=?,appDeptName=? where censorId=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,constructionPlans.getPrjNum());//��Ŀ���
			pstmt.setString(2,constructionPlans.getPrjName());//��Ŀ����
			pstmt.setString(3,constructionPlans.getPrjId());//��Ŀ��������
			pstmt.setString(4,constructionPlans.getCensorCorpName());//ʩ��ͼ����������
			pstmt.setString(5,constructionPlans.getCensorCorpCode());//ʩ��ͼ��������֯��������
			pstmt.setDate(6,constructionPlans.getCensorEDate());//����������
			pstmt.setString(7,constructionPlans.getPrjSize());//�����ģ
			pstmt.setString(8,constructionPlans.getEconCorpName());//���쵥λ����
			pstmt.setString(9,constructionPlans.getEconCorpCode());//���쵥λ��֯��������
			pstmt.setString(10,constructionPlans.getEconCorpName2());//���쵥λ����2
			pstmt.setString(11,constructionPlans.getEconCorpCode2());//���쵥λ��֯��������2
			pstmt.setString(12,constructionPlans.getEconCorpName3());//���쵥λ����3
			pstmt.setString(13,constructionPlans.getEconCorpCode3());//���쵥λ��֯��������3
			pstmt.setString(14,constructionPlans.getDesignCorpName());//��Ƶ�λ����
			pstmt.setString(15,constructionPlans.getDesignCorpCode());//��Ƶ�λ��֯��������
			pstmt.setString(16,constructionPlans.getDesignCorpName2());//��Ƶ�λ����2
			pstmt.setString(17,constructionPlans.getDesignCorpCode2());//��Ƶ�λ��֯��������2
			pstmt.setString(18,constructionPlans.getDesignCorpName3());//��Ƶ�λ����3
			pstmt.setString(19,constructionPlans.getDesignCorpCode3());//��Ƶ�λ��֯��������3
			pstmt.setString(20,constructionPlans.getOneCensorIsPass());//һ������Ƿ�ͨ�� ͨ��1����ͨ��0
			pstmt.setString(21,constructionPlans.getOneCensorWfqtCount());//һ�����ʱΥ��ǿ����
			pstmt.setString(22,constructionPlans.getOneCensorWfqtContent());//һ�����ʱΥ����ǿ����Ŀ
			pstmt.setString(23,constructionPlans.getAppDept());//������λid
			pstmt.setString(24,constructionPlans.getAppDeptName());//������λ����
			pstmt.setInt(25,constructionPlans.getCensorId());//����
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
	public void delete(String censorId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTCENSORINFO where censorId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, censorId);//����
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,censorId);	
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
			pstmt.setString(1,censorId);	
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
