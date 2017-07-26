package com.tj.jst.inner.integrityShare.corpBadIntegrityShare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.BadCredit;

/**
 * 不良行为代码
 * @author Administrator
 *
 */
public class QueryCreditCodeDaoImpl extends BaseDao implements IQueryCreditCodeDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 查询
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
					BadCredit bc = new BadCredit();
					bc.setCorpBad(rs.getInt("corpBad"));
					bc.setBeHavior(rs.getString("BEHAVIOR")); //行为类别
					bc.setBeHviorCode(rs.getString("BEHAVIORCODE")); //行为代码
					bc.setBadBeHavior(rs.getString("BADBEHAVIOR")); //不良行为
					bc.setLegalBasis(rs.getString("LEGALBASIS")); //法律依据
					bc.setPunishBasis(rs.getString("PUNISHBASIS")); //处罚依据
					
					page.getData().add(bc);
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
