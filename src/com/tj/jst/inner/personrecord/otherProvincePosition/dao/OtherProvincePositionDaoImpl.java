package com.tj.jst.inner.personrecord.otherProvincePosition.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.staffmanage.positions.model.Positions;

public class OtherProvincePositionDaoImpl extends BaseDao implements IOtherProvincePositionDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Positions constructor = new Positions();
					constructor.setPersonId(rs.getString("personID"));
					constructor.setName(rs.getString("name"));// ����
					constructor.setCardId(rs.getString("cardId"));// ���֤
					constructor.setSex(rs.getString("sex"));// �Ա�
					constructor.setEntName(rs.getString("entName"));// ��˾����
					constructor.setDuty(rs.getString("duty"));// ��λ����
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
