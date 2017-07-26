package com.tj.jst.inner.integrity.corpGoodIntegrity.dao;

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
import com.tj.jst.inner.integrity.corpGoodIntegrity.model.CorpGoodIntegrity;

/**
 * 企业良好行为诚信
 * 
 * @author DarkFlameMaster
 *
 */
public class CorpGoodIntegrityDaoImpl extends BaseDao implements ICorpGoodIntegrityDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					CorpGoodIntegrity good = new CorpGoodIntegrity();
					good.setCorpGoodCreditId(rs.getString("goodCreditId"));
					good.setCorpCode(rs.getString("corpCode"));
					good.setCorpName(rs.getString("corpName"));
					good.setCertTypeNum(rs.getString("certTypeNum"));
					good.setPrjNum(rs.getString("prjNum"));
					good.setPrjName(rs.getString("prjName"));
					good.setAddress(rs.getString("address"));
					good.setBuildCorpName(rs.getString("buildCorpName"));
					good.setBuildCorpCode(rs.getString("buildCorpCode"));
					good.setProvinceNum(rs.getString("provinceNum"));
					good.setCityNum(rs.getString("cityNum"));
					good.setCountyNum(rs.getString("countyNum"));
					good.setAwardDepartName(rs.getString("awardDepartName"));
					good.setAwardDepartType(rs.getString("awardDepartType"));
					good.setAwardContent(rs.getString("awardContent"));
					good.setAwardDate(rs.getDate("awardDate"));
					good.setDepartName(rs.getString("departName"));
					good.setUserName(rs.getString("userName"));
					good.setCreateDate(rs.getDate("createDate"));
					good.setIsPublic(rs.getString("isPublic"));
					good.setPublicBDate(rs.getDate("publicBDate"));
					good.setPublicEDate(rs.getDate("publicEDate"));
					good.setAuditUserName(rs.getString("auditUserName"));
					good.setAuditDate(rs.getDate("auditDate"));
					page.getData().add(good);
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

	/**
	 * 查询所在省
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	/**
	 * 查询所在市
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '" + star + "%"
				+ end + "' and code != '" + provinceId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	/**
	 * 查询所在区
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '" + star
				+ "%' and code != '" + cityId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 查询企业类型
	 */
	@Override
	public List<DictionaryClass> queryCertTypeNums() {
		String sql = "select code,corpregtype from TBECONTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("corpregtype"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	/**
	 * 增加企业良好行为信息
	 */
	@Override
	public String addGoodInfo(CorpGoodIntegrity corpGoodIntegrity) {
		// TODO Auto-generated method stub
		String sql = "insert into TBCorpGoodCreditInfo (GOODCREDITID,CORPNAME,CORPCODE,"
				+ "CERTTYPENUM,PRJNUM,PRJNAME,ADDRESS,BUILDCORPNAME,BUILDCORPCODE,"
				+ "PROVINCENUM,CITYNUM,COUNTYNUM,AWARDDEPARTNAME,AWARDDEPARTTYPE,"
				+ "AWARDCONTENT,AWARDNUMBER,AWARDDATE,DEPARTNAME,USERNAME,CREATEDATE,"
				+ "ISPUBLIC,PUBLICBDATE,PUBLICEDATE,AUDITUSERNAME,AUDITDATE,DEPARTID) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String message = "";
		String goodCreditId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodCreditId);								//主键
			pstmt.setString(2, corpGoodIntegrity.getCorpName());			//企业名称
			pstmt.setString(3, corpGoodIntegrity.getCorpCode());			//企业组织机构代码证
			pstmt.setString(4, corpGoodIntegrity.getCertTypeNum());			//企业类型
			pstmt.setString(5, corpGoodIntegrity.getPrjNum());				//项目编号
			pstmt.setString(6, corpGoodIntegrity.getPrjName());				//工程名称
			pstmt.setString(7, corpGoodIntegrity.getAddress());				//工程地址
			pstmt.setString(8, corpGoodIntegrity.getBuildCorpName());		//建设单位
			pstmt.setString(9, corpGoodIntegrity.getBuildCorpCode());		//建设单位住址机构代码
			pstmt.setString(10, corpGoodIntegrity.getProvinceNum());		//良好行为发生所在省
			pstmt.setString(11, corpGoodIntegrity.getCityNum());			//所在市
			pstmt.setString(12, corpGoodIntegrity.getCountyNum());			//所在区
			pstmt.setString(13, corpGoodIntegrity.getAwardDepartName());	//奖励部门
			pstmt.setString(14, corpGoodIntegrity.getAwardDepartType());	//奖励部门级别
			pstmt.setString(15, corpGoodIntegrity.getAwardContent());		//江离决定内容
			pstmt.setString(16, corpGoodIntegrity.getAwardNumber());		//江离决定文号
			pstmt.setDate(17, corpGoodIntegrity.getAwardDate());			//奖励日期
			pstmt.setString(18, corpGoodIntegrity.getDepartName());			//登记部门
			pstmt.setString(19, corpGoodIntegrity.getUserName());			//登记人
			pstmt.setDate(20, new Date(new java.util.Date().getTime()));	//登记日期
			pstmt.setString(21, corpGoodIntegrity.getIsPublic());			//是否发布
			pstmt.setDate(22, corpGoodIntegrity.getPublicBDate());			//发布开始时间
			pstmt.setDate(23, corpGoodIntegrity.getPublicEDate());			//发布结束时间
			pstmt.setString(24, corpGoodIntegrity.getAuditUserName());		//审核领导
			pstmt.setDate(25, corpGoodIntegrity.getAuditDate());			//审核日期
			pstmt.setString(26, corpGoodIntegrity.getDepartId()); 			//登记部门Id
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "添加成功！";
			}else
			{
				message = "添加失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 查询所要修改的信息
	 */
	@Override
	public CorpGoodIntegrity queryCorpGoodInfo(String corpGoodCreditId) {
		// TODO Auto-generated method stub
		CorpGoodIntegrity corp = new CorpGoodIntegrity();
		String sql = "select * from TBCORPGOODCREDITINFO where goodCreditId = ?";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpGoodCreditId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				corp.setCorpGoodCreditId(rs.getString("goodCreditId"));
				corp.setCorpName(rs.getString("corpName"));
				corp.setCorpCode(rs.getString("corpCode"));
				corp.setCertTypeNum(rs.getString("certTypeNum").trim());
				corp.setDepartId(rs.getString("departId"));
				corp.setPrjNum(rs.getString("prjNum"));
				corp.setPrjName(rs.getString("prjName"));
				corp.setAddress(rs.getString("address"));
				corp.setBuildCorpName(rs.getString("buildCorpName"));
				corp.setBuildCorpCode(rs.getString("buildCorpCode"));
				corp.setProvinceNum(rs.getString("provinceNum"));
				corp.setCityNum(rs.getString("cityNum"));
				corp.setCountyNum(rs.getString("countyNum"));
				corp.setAwardDepartName(rs.getString("awardDepartName"));
				corp.setAwardDepartType(rs.getString("awardDepartType"));
				corp.setAwardContent(rs.getString("awardContent"));
				corp.setAwardNumber(rs.getString("awardNumber"));
				corp.setAwardDate(rs.getDate("awardDate"));
				corp.setDepartName(rs.getString("departName"));
				corp.setUserName(rs.getString("userName"));
				corp.setCreateDate(rs.getDate("createDate"));
				corp.setIsPublic(rs.getString("isPublic"));
				corp.setPublicBDate(rs.getDate("publicBDate"));
				corp.setPublicEDate(rs.getDate("publicEDate"));
				corp.setAuditUserName(rs.getString("auditUserName"));
				corp.setAuditDate(rs.getDate("auditDate"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return corp;
	}

	/**
	 * 修改良好信息
	 */
	@Override
	public String modifyGoodInfo(CorpGoodIntegrity corpGoodIntegrity) {
		// TODO Auto-generated method stub
		String sql = "update TBCorpGoodCreditinfo set CORPNAME=? , CORPCODE=? ,"
				+ " CERTTYPENUM=? , PRJNUM=? , PRJNAME=? , ADDRESS=? , BUILDCORPNAME=? , "
				+ "BUILDCORPCODE=? , PROVINCENUM=? , CITYNUM=? , COUNTYNUM=? , "
				+ "AWARDDEPARTNAME=? , AWARDDEPARTTYPE=? , AWARDCONTENT=? , AWARDNUMBER=? , "
				+ "AWARDDATE=?  , ISPUBLIC=? , PUBLICBDATE=? , PUBLICEDATE=? , "
				+ "AUDITUSERNAME=? , AUDITDATE=? where GOODCREDITID=? ";
		String message = "";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpGoodIntegrity.getCorpName());			//企业名称
			pstmt.setString(2, corpGoodIntegrity.getCorpCode());			//企业组织机构代码证
			pstmt.setString(3, corpGoodIntegrity.getCertTypeNum());			//企业类型
			pstmt.setString(4, corpGoodIntegrity.getPrjNum());				//项目编号
			pstmt.setString(5, corpGoodIntegrity.getPrjName());				//工程名称
			pstmt.setString(6, corpGoodIntegrity.getAddress());				//工程地址
			pstmt.setString(7, corpGoodIntegrity.getBuildCorpName());		//建设单位
			pstmt.setString(8, corpGoodIntegrity.getBuildCorpCode());		//建设单位住址机构代码
			pstmt.setString(9, corpGoodIntegrity.getProvinceNum());			//良好行为发生所在省
			pstmt.setString(10, corpGoodIntegrity.getCityNum());			//所在市
			pstmt.setString(11, corpGoodIntegrity.getCountyNum());			//所在区
			pstmt.setString(12, corpGoodIntegrity.getAwardDepartName());	//奖励部门
			pstmt.setString(13, corpGoodIntegrity.getAwardDepartType());	//奖励部门级别
			pstmt.setString(14, corpGoodIntegrity.getAwardContent());		//奖励决定内容
			pstmt.setString(15, corpGoodIntegrity.getAwardNumber());		//奖励决定文号
			pstmt.setDate(16, corpGoodIntegrity.getAwardDate());			//奖励决定日期
			pstmt.setString(17, corpGoodIntegrity.getIsPublic());			//是否发布
			pstmt.setDate(18, corpGoodIntegrity.getPublicBDate());			//发布开始时间
			pstmt.setDate(19, corpGoodIntegrity.getPublicEDate());			//发布结束时间
			pstmt.setString(20, corpGoodIntegrity.getAuditUserName());		//审核领导
			pstmt.setDate(21, corpGoodIntegrity.getAuditDate());			//审核日期
			pstmt.setString(22, corpGoodIntegrity.getCorpGoodCreditId()); 	//登记部门Id
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "修改成功！";
			}else
			{
				message = "修改失败！";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 *  删除企业良好信息
	 */
	@Override
	public String deleteGoodInfo(String corpGoodCreditId) {
		// TODO Auto-generated method stub
		String sql = "update TBCorpGoodCreditinfo set STATUS = ? where GOODCREDITID=?";
		String message = "";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"1");
			pstmt.setString(2,corpGoodCreditId);	
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "修改成功！";
			}else
			{
				message = "修改失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

}
