package com.tj.jst.inner.personrecord.position.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

public class PositionDaoImpl extends BaseDao implements IPositionDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		Page page = super.positionsPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Positions constructor = new Positions();
					constructor.setPersonId(rs.getString("fPersonID"));
					constructor.setName(rs.getString("fName"));// ����
					constructor.setCardId(rs.getString("fCardId"));// ���֤
					constructor.setSex(rs.getString("fSex"));// �Ա�
					constructor.setEntName(rs.getString("fEntName"));// ��˾����
					constructor.setDuty(rs.getString("fDuty"));// ��λ����
					page.getData().add(constructor);
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
