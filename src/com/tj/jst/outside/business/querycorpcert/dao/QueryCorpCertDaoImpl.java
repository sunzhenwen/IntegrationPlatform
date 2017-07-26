package com.tj.jst.outside.business.querycorpcert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.contractFiling.model.Certdetail;

/**
 * 查询企业拥有资质
 * 
 * @author Administrator
 *
 */
public class QueryCorpCertDaoImpl extends BaseDao implements IQueryCorpCertDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
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
					cert.setCorpCode(rs.getString("corpCode"));
					cert.setCorpName(rs.getString("corpName"));
					cert.setCertNum(rs.getString("certId"));
					cert.setCertName(rs.getString("certTypeName"));
					cert.setTradeTypeName(rs.getString("tradeTypeName"));
					cert.setTradeBoundName(rs.getString("tradeBoundName"));
					cert.setTitleLevel(rs.getString("titleLevel"));
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

}
