package com.tj.jst.outside.staffmanage.positions.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

public class PositionsDaoImpl extends BaseDao implements IPositionsDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Page pagedQuery(Condition condition) {
		
		Page page = super.positionsPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					Positions constructor = new Positions();
					constructor.setPersonId(rs.getString("fPersonID"));
					constructor.setName(rs.getString("fName"));//姓名
					constructor.setCardId(rs.getString("fCardId"));//身份证
					constructor.setSex(rs.getString("fSex"));//性别
					constructor.setEntName(rs.getString("fEntName"));//公司名称
					constructor.setDuty(rs.getString("fDuty"));//岗位名称
					//constructor.setCertNum(rs.getString("certNum"));
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

}
