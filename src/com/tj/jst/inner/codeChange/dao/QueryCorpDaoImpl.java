package com.tj.jst.inner.codeChange.dao;

import java.io.File;
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
import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.upload.model.Upload;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 查询企业
 * @author hhc 2016-04-21
 *
 */
public class QueryCorpDaoImpl extends BaseDao implements IQueryCorpDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;
	
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
					Corp corp = new Corp();
					corp.setCorpId(rs.getString("corpId"));//主键
					corp.setCorpName(rs.getString("corpName"));//企业名称
					corp.setCorpCode(rs.getString("corpCode"));//企业名组织机构代码
					page.getData().add(corp);
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
