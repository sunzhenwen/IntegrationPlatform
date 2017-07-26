package com.tj.jst.outside.staffmanage.threeTypePerson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.corpinto.otherProvince.threeTypePerson.model.ThreeTypePerson;

/**
 * 外省三类人员
 * @author Administrator
 *
 */
public class ThreePersonDaoImpl extends BaseDao implements IThreePersonDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 分页查询
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					ThreeTypePerson tp = new ThreeTypePerson();
					tp.setThreeTypePersonId(rs.getString("threeTypePersonId"));
					tp.setCorpId(rs.getString("corpId"));
					tp.setFCertNumber(rs.getString("fCertNumber"));
					tp.setFCertType(rs.getString("fCertType"));
					tp.setFEntName(rs.getString("fEntName"));
					tp.setFEntName1(rs.getString("fEntName1"));
					tp.setFIdCertNo(rs.getString("fIdCertNo"));
					tp.setFName(rs.getString("fName"));
					tp.setFRegDate(rs.getDate("fRegDate"));
					tp.setFRegEndDate(rs.getDate("fRegEndDate"));
					tp.setFState(rs.getString("fState"));
				    page.getData().add(tp);
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
