package com.tj.jst.outside.business.queryQualification.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.queryQualification.model.Qualification;
import com.tj.jst.outside.business.queryprojection.model.Filing;
import com.tj.jst.outside.business.queryprojection.model.Permit;
import com.tj.jst.outside.business.queryprojection.model.Plan;
import com.tj.jst.outside.business.queryprojection.model.ProjectModel;
import com.tj.jst.outside.business.queryprojection.model.Ready;
import com.tj.jst.outside.business.queryprojection.model.Tender;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 业务查询
 * 
 * @author Administrator
 *
 */
public class QueryQualificationDaoImpl extends BaseDao implements IQueryQualificationDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
	@Override
	public List<Qualification> queryPage(String corpCode) {
		// TODO Auto-generated method stub
		List<Qualification> qualifications = new ArrayList<Qualification>();
		String sql = "select * from TBCORPCERTINFO where corpCode = ? " ;
		
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Qualification qualification = new Qualification();
					
					qualification.setCorpName(rs.getString("corpName"));
					qualification.setCertName(rs.getString("certName"));
					qualification.setCertId(rs.getString("certId"));
					qualification.setOrganDate(rs.getDate("organDate"));

					qualifications.add(qualification);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn,pstmt,null);
		}
		return qualifications;
	}

}