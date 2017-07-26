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
	 * 分页查询
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
					constructor.setName(rs.getString("name"));// 姓名
					constructor.setCardId(rs.getString("cardId"));// 身份证
					constructor.setSex(rs.getString("sex"));// 性别
					constructor.setEntName(rs.getString("entName"));// 公司名称
					constructor.setDuty(rs.getString("duty"));// 岗位名称
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
