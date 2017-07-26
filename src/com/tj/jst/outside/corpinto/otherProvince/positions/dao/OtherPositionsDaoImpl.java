package com.tj.jst.outside.corpinto.otherProvince.positions.dao;

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
import com.tj.jst.inner.personrecord.position.model.Position;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

/**
 * ��ʡ��λ��Ա
 * @author Administrator
 *
 */
public class OtherPositionsDaoImpl extends BaseDao implements IOtherPositionsDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					Positions constructor = new Positions();
					constructor.setPersonId(rs.getString("PERSONID"));
					constructor.setName(rs.getString("NAME"));//����
					constructor.setCardId(rs.getString("CARDID"));//���֤
					constructor.setSex(rs.getString("SEX"));//�Ա�
					constructor.setEntName(rs.getString("ENTNAME"));//��˾����
					constructor.setDuty(rs.getString("DUTY"));//��λ����
					constructor.setCreateDate(rs.getDate("createDate"));
					constructor.setCertNum(rs.getString("certNum"));
					page.getData().add(constructor);
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

	//�����Ա
	public String add(Positions positions)
	{
		// TODO Auto-generated method stub
		String personId = UUID.randomUUID().toString();
		String message = "";
		String sql = "insert into POSITION_CERTIFICATE(PERSONID,name,CARDID,SEX,"
				+ "ENTNAME,DUTY,CORPCODE,CORPID,PROVINCENAME,CITYNAME,COUNTYNAME,CREATEDATE,"
				+ "certNum) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,personId);				//��ԱId
				pstmt.setString(2,positions.getName());		//��Ա����
				pstmt.setString(3,positions.getCardId());	//��Ա֤������
				pstmt.setString(4,positions.getSex());		//��Ա�Ա�
				pstmt.setString(5,positions.getEntName());	//��Ա��ҵ����
				pstmt.setString(6,positions.getDuty());		//��Ա��λ����
				pstmt.setString(7,positions.getCorpCode());	//��Ա��֯��������
				pstmt.setString(8,positions.getCorpId());	//��Ա��ҵid
				pstmt.setString(9,positions.getProvinceName());//��Ա��ҵʡ
				pstmt.setString(10,positions.getCityName());//��Ա����ҵ��	
				pstmt.setString(11,positions.getCountyName());//��Ա����ҵ��
				pstmt.setDate(12, new Date(new java.util.Date().getTime()));
				pstmt.setString(13, positions.getCertNum());//֤����
				int check = pstmt.executeUpdate();
				if(check == 1)
				{
					message = "�����Ա�ɹ���";
				}else
				{
					message = "�����Աʧ�ܣ�";
				}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}
	
	//��ѯ����
	public Positions queryById(String personId)
	{
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from POSITION_CERTIFICATE where personId=?";
		Positions positions = new Positions();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,personId);	
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				positions.setPersonId(rs.getString("personId"));
				positions.setName(rs.getString("name"));
				positions.setSex(rs.getString("sex"));
				positions.setCardId(rs.getString("cardId"));
				positions.setDuty(rs.getString("duty"));
				positions.setCertNum(rs.getString("certNum"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return positions;
	}
	
	//�޸�
	public String modified(Positions positions)
	{
		// TODO Auto-generated method stub
		String message = "";

		String sql = "update POSITION_CERTIFICATE set name=? , sex = ? ,"
				+ " CARDID = ? , DUTY = ?,certNum=? where personId = ?";
		try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,positions.getName());
				pstmt.setString(2,positions.getSex());
				pstmt.setString(3,positions.getCardId());
				pstmt.setString(4,positions.getDuty());
				pstmt.setString(5, positions.getCertNum());
				pstmt.setString(6,positions.getPersonId());
				
				int check = pstmt.executeUpdate();
				if(check == 1)
				{
					message = "�޸ĳɹ���";
				}else
				{
					message = "�޸�ʧ�ܣ�";
				}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}
	
	//ɾ��
	public String delete(String personId)
	{
		// TODO Auto-generated method stub
		String message = "";
		String sql = "delete from POSITION_CERTIFICATE where personId=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,personId);	
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "ɾ���ɹ���";
			}else
			{
				message = "ɾ��ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}
	
	//��ѯ��λ����
	public List<DictionaryClass> queryDuty()
	{
		String sql = "select id,name from POSITION_DUTY";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("name"));
				dictionaryClass.setName(rs.getString("name"));
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
     * ������ݿ����Ƿ���ڴ����֤��
     * @return
     */
	public List checkCardId(String cardId)
	{
		List list = new ArrayList();
		// TODO Auto-generated method stub
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement("select entName FROM POSITION_CERTIFICATE where cardId=?");
			pstmt.setString(1,cardId);	
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				Position position = new Position();
				position.setEntName(rs.getString("entName"));
				list.add(position);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	
}
