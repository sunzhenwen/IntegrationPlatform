package com.tj.jst.inner.business.cityCount.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.inner.business.cityCount.model.CityCount;

/**
 * 地市项目统计
 * 
 * @author Administrator
 *
 */
public class CityCountDaoImpl extends BaseDao implements ICityCountDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 查询
	 * 
	 * @return
	 */
	public List<CityCount> queryCount()
	{
		// TODO Auto-generated method stub
		String sql = "select t.appdeptname , count(*) as cityNum,t.appdept "
				+ "from TBProjectInfo_S t "
				+ "where createdate >= to_date('2016-1-1','yyyy-mm-dd') "
				+ "group by t.appdeptname , t.appdept "
				+ "order by t.appdept";
		List<CityCount> list = new ArrayList<CityCount>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CityCount cityCount = new CityCount();
				cityCount.setAppDept(rs.getString("appDept"));
				cityCount.setAppDeptName(rs.getString("appDeptName"));
				cityCount.setCityNum(rs.getString("cityNum"));
				list.add(cityCount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

}
