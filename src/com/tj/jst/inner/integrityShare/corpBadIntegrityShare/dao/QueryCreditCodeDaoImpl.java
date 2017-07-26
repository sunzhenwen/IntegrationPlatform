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
 * ������Ϊ����
 * @author Administrator
 *
 */
public class QueryCreditCodeDaoImpl extends BaseDao implements IQueryCreditCodeDao {

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
					BadCredit bc = new BadCredit();
					bc.setCorpBad(rs.getInt("corpBad"));
					bc.setBeHavior(rs.getString("BEHAVIOR")); //��Ϊ���
					bc.setBeHviorCode(rs.getString("BEHAVIORCODE")); //��Ϊ����
					bc.setBadBeHavior(rs.getString("BADBEHAVIOR")); //������Ϊ
					bc.setLegalBasis(rs.getString("LEGALBASIS")); //��������
					bc.setPunishBasis(rs.getString("PUNISHBASIS")); //��������
					
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
