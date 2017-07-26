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
 * 外省岗位人员
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
					constructor.setName(rs.getString("NAME"));//姓名
					constructor.setCardId(rs.getString("CARDID"));//身份证
					constructor.setSex(rs.getString("SEX"));//性别
					constructor.setEntName(rs.getString("ENTNAME"));//公司名称
					constructor.setDuty(rs.getString("DUTY"));//岗位名称
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

	//添加人员
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
				pstmt.setString(1,personId);				//人员Id
				pstmt.setString(2,positions.getName());		//人员姓名
				pstmt.setString(3,positions.getCardId());	//人员证件号码
				pstmt.setString(4,positions.getSex());		//人员性别
				pstmt.setString(5,positions.getEntName());	//人员企业名称
				pstmt.setString(6,positions.getDuty());		//人员岗位名称
				pstmt.setString(7,positions.getCorpCode());	//人员组织机构代码
				pstmt.setString(8,positions.getCorpId());	//人员企业id
				pstmt.setString(9,positions.getProvinceName());//人员企业省
				pstmt.setString(10,positions.getCityName());//人员的企业市	
				pstmt.setString(11,positions.getCountyName());//人员的企业区
				pstmt.setDate(12, new Date(new java.util.Date().getTime()));
				pstmt.setString(13, positions.getCertNum());//证书编号
				int check = pstmt.executeUpdate();
				if(check == 1)
				{
					message = "添加人员成功！";
				}else
				{
					message = "添加人员失败！";
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
	
	//查询单挑
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
	
	//修改
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
					message = "修改成功！";
				}else
				{
					message = "修改失败！";
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
	
	//删除
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
				message = "删除成功！";
			}else
			{
				message = "删除失败！";
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
	
	//查询岗位名称
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
     * 检测数据库中是否存在此身份证号
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
