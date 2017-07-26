package com.tj.jst.outside.business.designSurveyStaff.dao;

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
import com.tj.jst.outside.business.designSurveyStaff.model.DesignSurveyStaff;

/**
 * ���������ͼ��Ա
 * @author hhc
 *
 */
public class DesignSurveyStaffDaoImpl extends BaseDao implements IDesignSurveyStaffDao {

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
					DesignSurveyStaff quality = new DesignSurveyStaff();
					quality.setDsId(rs.getString("ECONUSERID"));//����
					quality.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					quality.setPrjName(rs.getString("prjName"));//��Ŀ����
					quality.setCensorNum(rs.getString("censorNum"));//ʩ��ͼ���ϸ�֤����
					quality.setCorpName(rs.getString("corpName"));
					quality.setCorpCode(rs.getString("corpCode"));
					quality.setUserName(rs.getString("userName"));//��Ա����
					quality.setIdCardTypeNum(rs.getString("idCardTypeNum"));//֤������
					quality.setIdCard(rs.getString("idCard"));//��Ա֤������
					quality.setSpecialtyTypNum(rs.getString("specialtyTypNum"));//ע�����ͼ��ȼ�
					quality.setPrjDuty(rs.getString("prjDuty"));//�е���ɫ
					quality.setConCorpCode(rs.getString("conCorpCode"));
					quality.setConCorpName(rs.getString("conCorpName"));
					quality.setCreateDate(rs.getDate("createDate"));
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
	 * ��ȫ�ල����
	 * @return
	 */
	public void add(DesignSurveyStaff quality)
	{
		String dsId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBPROJECTDESIGNECONUSERINFO(ECONUSERID,PRJNUM,"
					+ "PRJNAME,censorNum,corpName,corpCode,userName,"
					+ "idCardTypeNum,idCard,specialtyTypNum,prjDuty,conCorpName,"
					+ "conCorpCode,createDate) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dsId);//����
			pstmt.setString(2,quality.getPrjNum());//��Ŀ���
			pstmt.setString(3,quality.getPrjName());//��Ŀ����
			pstmt.setString(4, quality.getCensorNum());
			pstmt.setString(5, quality.getCorpName());
			pstmt.setString(6, quality.getCorpCode());
			pstmt.setString(7, quality.getUserName());
			pstmt.setString(8, quality.getIdCardTypeNum());
			pstmt.setString(9, quality.getIdCard());
			pstmt.setString(10, quality.getSpecialtyTypNum());
			pstmt.setString(11, quality.getPrjDuty());
			pstmt.setString(12, quality.getConCorpName());
			pstmt.setString(13, quality.getConCorpCode());
			pstmt.setDate(14,new Date(new java.util.Date().getTime())); //��¼�Ǽ�����
			
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
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public DesignSurveyStaff queryById(String dsId)
	{

		DesignSurveyStaff quality = new DesignSurveyStaff();
		try {
			
			String qsql = "select * from TBPROJECTDESIGNECONUSERINFO where ECONUSERID=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, dsId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				quality.setDsId(rs.getString("ECONUSERID"));//����
				quality.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				quality.setPrjName(rs.getString("prjName"));//��Ŀ����
				quality.setCensorNum(rs.getString("censorNum"));//ʩ��ͼ���ϸ�֤����
				quality.setCorpName(rs.getString("corpName"));
				quality.setCorpCode(rs.getString("corpCode"));
				quality.setUserName(rs.getString("userName"));//��Ա����
				quality.setIdCardTypeNum(rs.getString("idCardTypeNum"));//֤������
				quality.setIdCard(rs.getString("idCard"));//��Ա֤������
				quality.setSpecialtyTypNum(rs.getString("specialtyTypNum"));//ע�����ͼ��ȼ�
				quality.setPrjDuty(rs.getString("prjDuty"));//�е���ɫ
				quality.setConCorpCode(rs.getString("conCorpCode"));
				quality.setConCorpName(rs.getString("conCorpName"));
				quality.setCreateDate(rs.getDate("createDate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
	}
	
	/**
	 * ��ȫ�ල�����޸�
	 * @return
	 */
	public void modify(DesignSurveyStaff quality)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBPROJECTDESIGNECONUSERINFO set PRJNUM=?,"
					+ "PRJNAME=?,censorNum=?,corpName=?,corpCode=?,userName=?,"
					+ "idCardTypeNum=?,idCard=?,specialtyTypNum=?,prjDuty=? "
					+ "where ECONUSERID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,quality.getPrjNum());//��Ŀ���
			pstmt.setString(2,quality.getPrjName());//��Ŀ����
			pstmt.setString(3, quality.getCensorNum());
			pstmt.setString(4, quality.getCorpName());
			pstmt.setString(5, quality.getCorpCode());
			pstmt.setString(6, quality.getUserName());
			pstmt.setString(7, quality.getIdCardTypeNum());
			pstmt.setString(8, quality.getIdCard());
			pstmt.setString(9, quality.getSpecialtyTypNum());
			pstmt.setString(10, quality.getPrjDuty());
			pstmt.setString(11,quality.getDsId());//����
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
	public void delete(String id)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTDESIGNECONUSERINFO where ECONUSERID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);//����
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
	
	//ע�����ͼ��ȼ�
	public List<DictionaryClass> querySpecialtyTypNums()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from TBSPECIALTYTYPEDIC ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("TYPELEVEL"));
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
	
	//�е���ɫ
	public List<DictionaryClass> queryPrjDutys()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from TBWORKDUTYDIC ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("ROLE"));
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
}
