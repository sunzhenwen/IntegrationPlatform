package com.tj.jst.outside.corpinto.otherProvince.queryOtherCorpCert.dao;

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
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.contractFiling.model.Certdetail;

/**
 * ��ѯ��ʡ������ҵӵ������
 * 
 * @author Administrator
 *
 */
public class QueryOtherCorpCertDaoImpl extends BaseDao implements IQueryOtherCorpCertDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Certdetail cert = new Certdetail();
					cert.setId(rs.getString("certdetailid"));
					cert.setCorpCode(rs.getString("corpCode"));
					cert.setCorpName(rs.getString("corpName"));
					cert.setCertNum(rs.getString("certId"));
					cert.setCertName(rs.getString("certTypeName"));
					cert.setTradeTypeName(rs.getString("tradeTypeName"));
					cert.setTradeBoundName(rs.getString("tradeBoundName"));
					cert.setTitleLevel(rs.getString("titleLevel"));
					cert.setDataSource(rs.getString("dataSource"));
					page.getData().add(cert);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	//�����ʸ�����(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> qualificationsTypes()
	{
		String sql = "select * from TBAPTITUDEKINDDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("qualificationstype"));
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
	
	//�����ʸ�����
	public List<DictionaryClass> queryTradeTypeNum(String requirement)
	{
		String sql = "select * from TBTRADETYPEDIC where code like '"+requirement+"%'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("CODENAME"));
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
	
	//�����ʸ�ȼ�(TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryRating(String requirement)
	{
		String sql = "select * from TBCERTTITLELEVELDIC where qualificationstype='"+requirement+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("rating"));
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
	 * רҵ���(TBTRADETYPEBOUNDDIC)
	 * @return
	 */
	public List<DictionaryClass> specialtyType(String specialtyType)
	{
		String sql = "select * from TBTRADETYPEBOUNDDIC where code like '"+specialtyType+"%'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("specialtytype"));
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
	
	//���
	public void add(Certdetail certdetail)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			// ȡ���Զ��ύ
            conn.setAutoCommit(false);
            
            String sql = "insert into TBCorpCertdetailinfo "
            		+ "(CertID,CorpCode,corpname,corpId,CertTypeNum,TradeTypeNum,"
            		+ "TradeBoundNum,TitleLevelNum,IsMaster,NoteNumber,"
            		+ "NoteDate,addtypenum,oldornew,datasource,certdetailid) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERT_SEQ.nextval)";
            
            String sql1 = "insert into TBCorpCertinfo "
					+ "(CertID,CertTypeNum,TitleLevelNum,CorpId,CorpName,CorpCode,"
					+ "OrganName,OrganDate,EndDate,"
					+ "IsValid,oldornew,datasource,corpCertid) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(sql,new String[]{"certdetailid"});
            pstmt.setString(1,certdetail.getCertId());//֤����
            pstmt.setString(2,certdetail.getCorpCode()); //��ҵ��֯��������
            pstmt.setString(3,certdetail.getCorpName());//��ҵ����
            pstmt.setString(4, certdetail.getCorpId());//��ҵ����
            pstmt.setInt(5,Integer.parseInt(certdetail.getQualificationsType()));//�����ʸ�����
            pstmt.setInt(6,Integer.parseInt(certdetail.getTradeTypeNum()));//�����ʸ�����
            pstmt.setInt(7,Integer.parseInt(certdetail.getSpecialtyType()));//רҵ���
            pstmt.setInt(8,Integer.parseInt(certdetail.getTitleLevelNum()));//�����ʸ�ȼ�
            if("".equals(certdetail.getIsMaster()))
            {
            	pstmt.setInt(9,-1); //�Ƿ���������
            }else
            {
            	pstmt.setInt(9,Integer.parseInt(certdetail.getIsMaster())); //�Ƿ���������
            }
            pstmt.setString(10, certdetail.getNoteNumber()); //�״���׼�����ʸ��ĺ�
            pstmt.setDate(11,certdetail.getNoteDate()); //�״���׼�����ʸ�����
            pstmt.setString(12,"001"); //����ȡ�÷�ʽ
            pstmt.setString(13,"1"); //��������
            pstmt.setString(14,"09"); //������Դ 09����ʡ��ҵ�ֶ����
            pstmt.executeUpdate();
            rs=pstmt.getGeneratedKeys();  
            rs.next();  
            int id=rs.getInt(1);  
            
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,certdetail.getCertId());//֤����
			pstmt.setInt(2,Integer.parseInt(certdetail.getQualificationsType()));//�����ʸ�����
			pstmt.setInt(3,Integer.parseInt(certdetail.getTitleLevelNum()));//�����ʸ�ȼ�
			pstmt.setString(4,certdetail.getCertId());//֤����
			pstmt.setString(5,certdetail.getCorpName());//��ҵ����
            pstmt.setString(6,certdetail.getCorpCode()); //��ҵ��֯��������
            pstmt.setString(7,certdetail.getOrganName()); //��֤����
            pstmt.setDate(8,certdetail.getOrganDate()); //��֤����
            pstmt.setDate(9,certdetail.getEndDate()); //֤����Ч�ڽ�ֹ����
            pstmt.setInt(10,1); //֤��״̬
            pstmt.setString(11, "1");//��������
            pstmt.setString(12, "09");//���� 09����ʡ��ҵ�ֶ����
            pstmt.setInt(13, id);//����
            pstmt.executeUpdate();
			
            conn.commit();
		}catch (SQLException e) {
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
	
	//ɾ��
	public void deleteCer(String id)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			// ȡ���Զ��ύ
            conn.setAutoCommit(false);
            
            String sql = "delete from TBCorpCertdetailinfo where certdetailid=? ";
            String sql1 = "delete from TBCorpCertinfo where corpCertid=? ";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(id));
            pstmt.executeUpdate();
           
            
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1,Integer.parseInt(id));
			pstmt.executeUpdate();
			
            conn.commit();
		}catch (SQLException e) {
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
}
