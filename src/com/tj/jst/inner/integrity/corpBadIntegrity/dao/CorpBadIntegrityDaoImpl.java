package com.tj.jst.inner.integrity.corpBadIntegrity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.CorpBadIntegrity;

/**
 * 企业不良行为诚信
 * @author hhc
 *
 */
public class CorpBadIntegrityDaoImpl extends BaseDao implements ICorpBadIntegrityDao {

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
					CorpBadIntegrity cbi = new CorpBadIntegrity();
					cbi.setCorpBadCreditId(rs.getString("corpBadCreditId")); //主键
					cbi.setCorpName(rs.getString("corpName"));
					cbi.setCorpCode(rs.getString("corpCode"));
					cbi.setCertTypeNum(rs.getString("certTypeNum"));
					cbi.setPrjNum(rs.getString("prjNum"));
					cbi.setPrjName(rs.getString("prjName"));
					cbi.setAddress(rs.getString("address"));
					cbi.setBuildCorpName(rs.getString("buildCorpName"));
					cbi.setBuildCorpCode(rs.getString("buildCorpCode"));
					cbi.setProvinceNum(rs.getString("provinceNum"));
					cbi.setCityNum(rs.getString("cityNum"));
					cbi.setCountyNum(rs.getString("countyNum"));
					cbi.setCreditClassNum(rs.getString("creditClassNum"));
					cbi.setCreditType(rs.getString("creditType"));
					cbi.setCreditCode(rs.getString("creditCode"));
					cbi.setContent(rs.getString("content"));
					cbi.setPunishDepartName(rs.getString("punishDepartName"));
					cbi.setPunishDepartType(rs.getString("punishDepartType"));
					cbi.setPunishEvidence(rs.getString("punishEvidence"));
					cbi.setPunishContent(rs.getString("punishContent"));
					cbi.setPunishNumber(rs.getString("punishNumber"));
					cbi.setPunishMoney(rs.getString("punishMoney"));
					cbi.setDepartName(rs.getString("departName"));
					cbi.setUserName(rs.getString("userName"));
					cbi.setIsPublic(rs.getString("isPublic"));
					cbi.setAuditUserName(rs.getString("auditUserName"));
					cbi.setHappenDate(rs.getDate("happenDate"));
					cbi.setPunishDate(rs.getDate("punishDate"));
					cbi.setPunishEDate(rs.getDate("punishEDate"));
					cbi.setCreateDate(rs.getDate("createDate"));
					cbi.setPublicBDate(rs.getDate("publicBDate"));
					cbi.setPublicEDate(rs.getDate("publicEDate"));
					cbi.setAuditDate(rs.getDate("auditDate"));
					
					page.getData().add(cbi);
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
	 * 添加
	 * @return
	 */
	public void add(CorpBadIntegrity corpBadIntegrity)
	{
		String sql = "insert into tbcorpbadcreditinfo(CORPBADCREDITID,CORPNAME,CORPCODE,CREDITTYPE"
				+ ",CREDITCODE,HAPPENDATE,PRJNUM,DEPARTNAME,PUNISHEVIDENCE,PUNISHCONTENT"
				+ ",PUNISHNUMBER,PUNISHDATE,PUNISHEDATE,CERTTYPENUM,PRJNAME,ADDRESS,BUILDCORPNAME"
				+ ",BUILDCORPCODE,PROVINCENUM,CITYNUM,COUNTYNUM,CREDITCLASSNUM,CONTENT"
				+ ",PUNISHDEPARTNAME,AUDITDATE,AUDITUSERNAME,PUBLICEDATE,PUBLICBDATE,ISPUBLIC"
				+ ",CREATEDATE,USERNAME,PUNISHMONEY,PUNISHDEPARTTYPE,delType,departId) "
				+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String corpBadCreditId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpBadCreditId);	//主键
			pstmt.setString(2,corpBadIntegrity.getCorpName()); 	//企业名称
			pstmt.setString(3,corpBadIntegrity.getCorpCode());//组织机构代码
			pstmt.setString(4,corpBadIntegrity.getCreditType());//不良行为类别(字典表：TBCORPBADDIC)
			pstmt.setString(5,corpBadIntegrity.getCreditCode());//不良行为代码(字典表：TBCORPBADDIC)
			pstmt.setDate(6,corpBadIntegrity.getHappenDate());//不良行为发生日期
			pstmt.setString(7,corpBadIntegrity.getPrjNum());//项目编号
			pstmt.setString(8,corpBadIntegrity.getDepartName());//登记部门
			pstmt.setString(9,corpBadIntegrity.getPunishEvidence());//处罚依据
			pstmt.setString(10,corpBadIntegrity.getPunishContent());//处罚决定内容
			pstmt.setString(11,corpBadIntegrity.getPunishNumber());//处罚决定文号
			pstmt.setDate(12,corpBadIntegrity.getPunishDate());//处罚日期
			pstmt.setDate(13,corpBadIntegrity.getPunishEDate());//处罚截至日期
			pstmt.setString(14,corpBadIntegrity.getCertTypeNum());//企业类型(字典表：TBAPTITUDEKINDDIC)
			pstmt.setString(15,corpBadIntegrity.getPrjName()); //工程名称
			pstmt.setString(16,corpBadIntegrity.getAddress());	//工程地址
			pstmt.setString(17,corpBadIntegrity.getBuildCorpName());//建设单位
			pstmt.setString(18,corpBadIntegrity.getBuildCorpCode());//建设单位组织机构代码
			pstmt.setString(19,corpBadIntegrity.getProvinceNum());//不良行为发生所在省(字典表：TBXZQDMDIC)
			pstmt.setString(20,corpBadIntegrity.getCityNum());//不良行为发生所在地市(字典表：TBXZQDMDIC)
			pstmt.setString(21,corpBadIntegrity.getCountyNum());//不良行为发生所在区县(字典表：TBXZQDMDIC)
			pstmt.setString(22,corpBadIntegrity.getCreditClassNum());//不良行为分类(字典表：TBCREDITTYPE)
			pstmt.setString(23,corpBadIntegrity.getContent());//不良行为内容
			pstmt.setString(24,corpBadIntegrity.getPunishDepartName());//处罚部门
			pstmt.setDate(25,corpBadIntegrity.getAuditDate());//审核时间（发布时须填写）
			pstmt.setString(26,corpBadIntegrity.getAuditUserName());//审核领导
			pstmt.setDate(27,corpBadIntegrity.getPublicEDate());//发布结束时间（发布时须填写）
			pstmt.setDate(28,corpBadIntegrity.getPublicBDate()); //发布开始时间（发布时须填写）
			pstmt.setString(29,corpBadIntegrity.getIsPublic());	//是否发布；0：未发布，1：已发布
			pstmt.setDate(30, corpBadIntegrity.getCreateDate());//登记日期
			pstmt.setString(31, corpBadIntegrity.getUserName()); //登记人姓名
			pstmt.setString(32, corpBadIntegrity.getPunishMoney());//处罚金额
			pstmt.setString(33, corpBadIntegrity.getPunishDepartType());//处罚部门级别；0：部级，1：省市，2：地市，3：区县
			pstmt.setString(34, "0");
			pstmt.setString(35, corpBadIntegrity.getDepartId());//登记部门Id
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * 查询单条记录
	 * @param corpBadCreditId
	 * @return
	 */
	public CorpBadIntegrity queryById(String corpBadCreditId)
	{
		String sql = "select * from tbcorpbadcreditinfo where CORPBADCREDITID=? ";
		CorpBadIntegrity corpBadIntegrity = new CorpBadIntegrity();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpBadCreditId);	//主键
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				corpBadIntegrity.setCorpBadCreditId(rs.getString("corpBadCreditId"));//主键
				corpBadIntegrity.setCorpName(rs.getString("CORPNAME")); 	//企业名称
				corpBadIntegrity.setCorpCode(rs.getString("CORPCODE"));//组织机构代码
				corpBadIntegrity.setCreditType(rs.getString("CREDITTYPE"));//不良行为类别(字典表：TBCORPBADDIC)
				corpBadIntegrity.setCreditCode(rs.getString("CREDITCODE"));//不良行为代码(字典表：TBCORPBADDIC)
				corpBadIntegrity.setHappenDate(rs.getDate("HAPPENDATE"));//不良行为发生日期
				corpBadIntegrity.setPrjNum(rs.getString("PRJNUM"));//项目编号
				corpBadIntegrity.setDepartName(rs.getString("DEPARTNAME"));//登记部门
				corpBadIntegrity.setPunishEvidence(rs.getString("PUNISHEVIDENCE"));//处罚依据
				corpBadIntegrity.setPunishContent(rs.getString("PUNISHCONTENT"));//处罚决定内容
				corpBadIntegrity.setPunishNumber(rs.getString("PUNISHNUMBER"));//处罚决定文号
				corpBadIntegrity.setPunishDate(rs.getDate("PUNISHDATE"));//处罚日期
				corpBadIntegrity.setPunishEDate(rs.getDate("PUNISHEDATE"));//处罚截至日期
				corpBadIntegrity.setCertTypeNum(rs.getString("CERTTYPENUM"));//企业类型(字典表：TBAPTITUDEKINDDIC)
				corpBadIntegrity.setPrjName(rs.getString("PRJNAME")); //工程名称
				corpBadIntegrity.setAddress(rs.getString("ADDRESS"));	//工程地址
				corpBadIntegrity.setBuildCorpName(rs.getString("BUILDCORPNAME"));//建设单位
				corpBadIntegrity.setBuildCorpCode(rs.getString("BUILDCORPCODE"));//建设单位组织机构代码
				corpBadIntegrity.setProvinceNum(rs.getString("PROVINCENUM"));//不良行为发生所在省(字典表：TBXZQDMDIC)
				corpBadIntegrity.setCityNum(rs.getString("CITYNUM"));//不良行为发生所在地市(字典表：TBXZQDMDIC)
				corpBadIntegrity.setCountyNum(rs.getString("COUNTYNUM"));//不良行为发生所在区县(字典表：TBXZQDMDIC)
				corpBadIntegrity.setCreditClassNum(rs.getString("CREDITCLASSNUM"));//不良行为分类(字典表：TBCREDITTYPE)
				corpBadIntegrity.setContent(rs.getString("CONTENT"));//不良行为内容
				corpBadIntegrity.setPunishDepartName(rs.getString("PUNISHDEPARTNAME"));//处罚部门
				corpBadIntegrity.setAuditDate(rs.getDate("AUDITDATE"));//审核时间（发布时须填写）
				corpBadIntegrity.setAuditUserName(rs.getString("AUDITUSERNAME"));//审核领导
				corpBadIntegrity.setPublicEDate(rs.getDate("PUBLICEDATE"));//发布结束时间（发布时须填写）
				corpBadIntegrity.setPublicBDate(rs.getDate("PUBLICBDATE")); //发布开始时间（发布时须填写）
				corpBadIntegrity.setIsPublic(rs.getString("ISPUBLIC"));	//是否发布；0：未发布，1：已发布
				corpBadIntegrity.setCreateDate(rs.getDate("CREATEDATE"));//登记日期
				corpBadIntegrity.setUserName(rs.getString("USERNAME")); //登记人姓名
				corpBadIntegrity.setPunishMoney(rs.getString("PUNISHMONEY"));//处罚金额
				corpBadIntegrity.setPunishDepartType(rs.getString("PUNISHDEPARTTYPE"));//处罚部门级别；0：部级，1：省市，2：地市，3：区县
				corpBadIntegrity.setDepartId(rs.getString("DEPARTID"));//登记部门Id
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corpBadIntegrity;
	}
	
	/**
	 * 修改
	 * @return
	 */
	public void modify(CorpBadIntegrity corpBadIntegrity)
	{
		String sql = "update tbcorpbadcreditinfo set CORPNAME=?,CORPCODE=?,CREDITTYPE=?"
				+ ",CREDITCODE=?,HAPPENDATE=?,PRJNUM=?,DEPARTNAME=?,PUNISHEVIDENCE=?"
				+ ",PUNISHCONTENT=?,PUNISHNUMBER=?,PUNISHDATE=?,PUNISHEDATE=?,CERTTYPENUM=?"
				+ ",PRJNAME=?,ADDRESS=?,BUILDCORPNAME=?,BUILDCORPCODE=?,PROVINCENUM=?,CITYNUM=?"
				+ ",COUNTYNUM=?,CREDITCLASSNUM=?,CONTENT=?,PUNISHDEPARTNAME=?,AUDITDATE=?"
				+ ",AUDITUSERNAME=?,PUBLICEDATE=?,PUBLICBDATE=?,ISPUBLIC=?,CREATEDATE=?"
				+ ",USERNAME=?,PUNISHMONEY=?,PUNISHDEPARTTYPE=?,departId=? "
				+ "where CORPBADCREDITID=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,corpBadIntegrity.getCorpName()); //企业名称
			pstmt.setString(2,corpBadIntegrity.getCorpCode());//组织机构代码
			pstmt.setString(3,corpBadIntegrity.getCreditType());//不良行为类别(字典表：TBCORPBADDIC)
			pstmt.setString(4,corpBadIntegrity.getCreditCode());//不良行为代码(字典表：TBCORPBADDIC)
			pstmt.setDate(5,corpBadIntegrity.getHappenDate());//不良行为发生日期
			pstmt.setString(6,corpBadIntegrity.getPrjNum());//项目编号
			pstmt.setString(7,corpBadIntegrity.getDepartName());//登记部门
			pstmt.setString(8,corpBadIntegrity.getPunishEvidence());//处罚依据
			pstmt.setString(9,corpBadIntegrity.getPunishContent());//处罚决定内容
			pstmt.setString(10,corpBadIntegrity.getPunishNumber());//处罚决定文号
			pstmt.setDate(11,corpBadIntegrity.getPunishDate());//处罚日期
			pstmt.setDate(12,corpBadIntegrity.getPunishEDate());//处罚截至日期
			pstmt.setString(13,corpBadIntegrity.getCertTypeNum());//企业类型(字典表：TBAPTITUDEKINDDIC)
			pstmt.setString(14,corpBadIntegrity.getPrjName()); //工程名称
			pstmt.setString(15,corpBadIntegrity.getAddress());	//工程地址
			pstmt.setString(16,corpBadIntegrity.getBuildCorpName());//建设单位
			pstmt.setString(17,corpBadIntegrity.getBuildCorpCode());//建设单位组织机构代码
			pstmt.setString(18,corpBadIntegrity.getProvinceNum());//不良行为发生所在省(字典表：TBXZQDMDIC)
			pstmt.setString(19,corpBadIntegrity.getCityNum());//不良行为发生所在地市(字典表：TBXZQDMDIC)
			pstmt.setString(20,corpBadIntegrity.getCountyNum());//不良行为发生所在区县(字典表：TBXZQDMDIC)
			pstmt.setString(21,corpBadIntegrity.getCreditClassNum());//不良行为分类(字典表：TBCREDITTYPE)
			pstmt.setString(22,corpBadIntegrity.getContent());//不良行为内容
			pstmt.setString(23,corpBadIntegrity.getPunishDepartName());//处罚部门
			pstmt.setDate(24,corpBadIntegrity.getAuditDate());//审核时间（发布时须填写）
			pstmt.setString(25,corpBadIntegrity.getAuditUserName());//审核领导
			pstmt.setDate(26,corpBadIntegrity.getPublicEDate());//发布结束时间（发布时须填写）
			pstmt.setDate(27,corpBadIntegrity.getPublicBDate()); //发布开始时间（发布时须填写）
			pstmt.setString(28,corpBadIntegrity.getIsPublic());	//是否发布；0：未发布，1：已发布
			pstmt.setDate(29,corpBadIntegrity.getCreateDate());//登记日期
			pstmt.setString(30,corpBadIntegrity.getUserName()); //登记人姓名
			pstmt.setString(31,corpBadIntegrity.getPunishMoney());//处罚金额
			pstmt.setString(32,corpBadIntegrity.getPunishDepartType());//处罚部门级别；0：部级，1：省市，2：地市，3：区县
			pstmt.setString(33,corpBadIntegrity.getDepartId());//登记部门Id
			pstmt.setString(34,corpBadIntegrity.getCorpBadCreditId());	//主键
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String corpBadCreditId)
	{
		String sql = "update tbcorpbadcreditinfo set delType=? where CORPBADCREDITID=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "1");//删除状态
			pstmt.setString(2,corpBadCreditId); //主键
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

	//查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%"+end+"' and code != '"+provinceId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

	//查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%' and code != '"+cityId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	
	//企业类型(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCertTypeNums(){
		String sql = "select code,corpregtype from TBECONTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("corpregtype"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	//不良行为分类(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums(){
		String sql = "select code,BADBEHAVIOUR from TBCREDITTYPE";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("BADBEHAVIOUR"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
}
