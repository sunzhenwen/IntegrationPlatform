package com.tj.jst.inner.integrity.personBadIntegrity.dao;

import java.sql.Connection;
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
import com.tj.jst.inner.integrity.personBadIntegrity.model.PersonBadIntegrity;

/**
 * 注册人员不良行为信息数据表
 * @author hhc
 *
 */
public class PersonBadIntegrityDaoImpl extends BaseDao implements IPersonBadIntegrityDao {

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
					PersonBadIntegrity pbi = new PersonBadIntegrity();
					
					pbi.setBadPersonId(rs.getString("badPersonId"));//主键
					pbi.setPersonName(rs.getString("personName"));//姓名
					pbi.setIdCardTypeNum(rs.getString("idCardTypeNum"));//证件类型(字典表：TBIDCARDTYPEDIC)
					pbi.setIdCard18(rs.getString("idCard18"));//证件号码
					pbi.setSpecialtyTypNum(rs.getString("specialtyTypNum"));//人员类型(字典表：TBSPECIALTYTYPEDIC)
					
					pbi.setCorpName(rs.getString("corpName"));
					pbi.setCorpCode(rs.getString("corpCode"));
					pbi.setPrjNum(rs.getString("prjNum"));
					pbi.setPrjName(rs.getString("prjName"));
					pbi.setAddress(rs.getString("address"));
					pbi.setBuildCorpName(rs.getString("buildCorpName"));
					pbi.setBuildCorpCode(rs.getString("buildCorpCode"));
					pbi.setProvinceNum(rs.getString("provinceNum"));
					pbi.setCityNum(rs.getString("cityNum"));
					pbi.setCountyNum(rs.getString("countyNum"));
					pbi.setCreditClassNum(rs.getString("creditClassNum"));
					pbi.setCreditType(rs.getString("creditType"));
					pbi.setCreditCode(rs.getString("creditCode"));
					pbi.setContent(rs.getString("content"));
					pbi.setPunishDepartName(rs.getString("punishDepartName"));
					pbi.setPunishDepartType(rs.getString("punishDepartType"));
					pbi.setPunishEvidence(rs.getString("punishEvidence"));
					pbi.setPunishContent(rs.getString("punishContent"));
					pbi.setPunishNumber(rs.getString("punishNumber"));
					pbi.setPunishMoney(rs.getString("punishMoney"));
					pbi.setDepartName(rs.getString("departName"));
					pbi.setUserName(rs.getString("userName"));
					pbi.setIsPublic(rs.getString("isPublic"));
					pbi.setAuditUserName(rs.getString("auditUserName"));
					pbi.setHappenDate(rs.getDate("happenDate"));
					pbi.setPunishDate(rs.getDate("punishDate"));
					pbi.setPunishEDate(rs.getDate("punishEDate"));
					pbi.setCreateDate(rs.getDate("createDate"));
					pbi.setPublicBDate(rs.getDate("publicBDate"));
					pbi.setPublicEDate(rs.getDate("publicEDate"));
					pbi.setAuditDate(rs.getDate("auditDate"));
					
					page.getData().add(pbi);
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
	public void add(PersonBadIntegrity personBadIntegrity)
	{
		
		String sql = "insert into TBREGPERSONBADCREDITINFO(badPersonId,CORPNAME,CORPCODE,CREDITTYPE"
				+ ",CREDITCODE,HAPPENDATE,PRJNUM,DEPARTNAME,PUNISHEVIDENCE,PUNISHCONTENT"
				+ ",PUNISHNUMBER,PUNISHDATE,PUNISHEDATE,specialtyTypNum,PRJNAME,ADDRESS,BUILDCORPNAME"
				+ ",BUILDCORPCODE,PROVINCENUM,CITYNUM,COUNTYNUM,CREDITCLASSNUM,CONTENT"
				+ ",PUNISHDEPARTNAME,AUDITDATE,AUDITUSERNAME,PUBLICEDATE,PUBLICBDATE,ISPUBLIC"
				+ ",CREATEDATE,USERNAME,PUNISHMONEY,PUNISHDEPARTTYPE,departId,personName"
				+ ",idCardTypeNum,idCard18,delType) "
				+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String badPersonId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,badPersonId);	//主键
			pstmt.setString(2,personBadIntegrity.getCorpName()); 	//企业名称
			pstmt.setString(3,personBadIntegrity.getCorpCode());//组织机构代码
			pstmt.setString(4,personBadIntegrity.getCreditType());//不良行为类别(字典表：TBCORPBADDIC)
			pstmt.setString(5,personBadIntegrity.getCreditCode());//不良行为代码(字典表：TBCORPBADDIC)
			pstmt.setDate(6,personBadIntegrity.getHappenDate());//不良行为发生日期
			pstmt.setString(7,personBadIntegrity.getPrjNum());//项目编号
			pstmt.setString(8,personBadIntegrity.getDepartName());//登记部门
			pstmt.setString(9,personBadIntegrity.getPunishEvidence());//处罚依据
			pstmt.setString(10,personBadIntegrity.getPunishContent());//处罚决定内容
			pstmt.setString(11,personBadIntegrity.getPunishNumber());//处罚决定文号
			pstmt.setDate(12,personBadIntegrity.getPunishDate());//处罚日期
			pstmt.setDate(13,personBadIntegrity.getPunishEDate());//处罚截至日期
			pstmt.setString(14,personBadIntegrity.getSpecialtyTypNum());//人员类型(字典表：TBSPECIALTYTYPEDIC)
			pstmt.setString(15,personBadIntegrity.getPrjName()); //工程名称
			pstmt.setString(16,personBadIntegrity.getAddress());	//工程地址
			pstmt.setString(17,personBadIntegrity.getBuildCorpName());//建设单位
			pstmt.setString(18,personBadIntegrity.getBuildCorpCode());//建设单位组织机构代码
			pstmt.setString(19,personBadIntegrity.getProvinceNum());//不良行为发生所在省(字典表：TBXZQDMDIC)
			pstmt.setString(20,personBadIntegrity.getCityNum());//不良行为发生所在地市(字典表：TBXZQDMDIC)
			pstmt.setString(21,personBadIntegrity.getCountyNum());//不良行为发生所在区县(字典表：TBXZQDMDIC)
			pstmt.setString(22,personBadIntegrity.getCreditClassNum());//不良行为分类(字典表：TBCREDITTYPE)
			pstmt.setString(23,personBadIntegrity.getContent());//不良行为内容
			pstmt.setString(24,personBadIntegrity.getPunishDepartName());//处罚部门
			pstmt.setDate(25,personBadIntegrity.getAuditDate());//审核时间（发布时须填写）
			pstmt.setString(26,personBadIntegrity.getAuditUserName());//审核领导
			pstmt.setDate(27,personBadIntegrity.getPublicEDate());//发布结束时间（发布时须填写）
			pstmt.setDate(28,personBadIntegrity.getPublicBDate()); //发布开始时间（发布时须填写）
			pstmt.setString(29,personBadIntegrity.getIsPublic());	//是否发布；0：未发布，1：已发布
			pstmt.setDate(30, personBadIntegrity.getCreateDate());//登记日期
			pstmt.setString(31, personBadIntegrity.getUserName()); //登记人姓名
			pstmt.setString(32, personBadIntegrity.getPunishMoney());//处罚金额
			pstmt.setString(33, personBadIntegrity.getPunishDepartType());//处罚部门级别；0：部级，1：省市，2：地市，3：区县
			pstmt.setString(34, personBadIntegrity.getDepartId());//登记部门Id
			pstmt.setString(35, personBadIntegrity.getPersonName());//姓名
			pstmt.setString(36, personBadIntegrity.getIdCardTypeNum());//证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(37, personBadIntegrity.getIdCard18());//证件号码
			pstmt.setString(38, "0");
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
	 * @param badPersonId
	 * @return
	 */
	public PersonBadIntegrity queryById(String badPersonId)
	{
		String sql = "select * from TBREGPERSONBADCREDITINFO where badPersonId=? ";
		PersonBadIntegrity personBadIntegrity = new PersonBadIntegrity();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,badPersonId);	//主键
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				personBadIntegrity.setBadPersonId(rs.getString("badPersonId"));//主键
				personBadIntegrity.setCorpName(rs.getString("CORPNAME")); 	//企业名称
				personBadIntegrity.setCorpCode(rs.getString("CORPCODE"));//组织机构代码
				personBadIntegrity.setCreditType(rs.getString("CREDITTYPE"));//不良行为类别(字典表：TBCORPBADDIC)
				personBadIntegrity.setCreditCode(rs.getString("CREDITCODE"));//不良行为代码(字典表：TBCORPBADDIC)
				personBadIntegrity.setHappenDate(rs.getDate("HAPPENDATE"));//不良行为发生日期
				personBadIntegrity.setPrjNum(rs.getString("PRJNUM"));//项目编号
				personBadIntegrity.setDepartName(rs.getString("DEPARTNAME"));//登记部门
				personBadIntegrity.setPunishEvidence(rs.getString("PUNISHEVIDENCE"));//处罚依据
				personBadIntegrity.setPunishContent(rs.getString("PUNISHCONTENT"));//处罚决定内容
				personBadIntegrity.setPunishNumber(rs.getString("PUNISHNUMBER"));//处罚决定文号
				personBadIntegrity.setPunishDate(rs.getDate("PUNISHDATE"));//处罚日期
				personBadIntegrity.setPunishEDate(rs.getDate("PUNISHEDATE"));//处罚截至日期
				personBadIntegrity.setSpecialtyTypNum(rs.getString("specialtyTypNum"));//人员类型(字典表：TBSPECIALTYTYPEDIC)
				personBadIntegrity.setPrjName(rs.getString("PRJNAME")); //工程名称
				personBadIntegrity.setAddress(rs.getString("ADDRESS"));	//工程地址
				personBadIntegrity.setBuildCorpName(rs.getString("BUILDCORPNAME"));//建设单位
				personBadIntegrity.setBuildCorpCode(rs.getString("BUILDCORPCODE"));//建设单位组织机构代码
				personBadIntegrity.setProvinceNum(rs.getString("PROVINCENUM"));//不良行为发生所在省(字典表：TBXZQDMDIC)
				personBadIntegrity.setCityNum(rs.getString("CITYNUM"));//不良行为发生所在地市(字典表：TBXZQDMDIC)
				personBadIntegrity.setCountyNum(rs.getString("COUNTYNUM"));//不良行为发生所在区县(字典表：TBXZQDMDIC)
				personBadIntegrity.setCreditClassNum(rs.getString("CREDITCLASSNUM"));//不良行为分类(字典表：TBCREDITTYPE)
				personBadIntegrity.setContent(rs.getString("CONTENT"));//不良行为内容
				personBadIntegrity.setPunishDepartName(rs.getString("PUNISHDEPARTNAME"));//处罚部门
				personBadIntegrity.setAuditDate(rs.getDate("AUDITDATE"));//审核时间（发布时须填写）
				personBadIntegrity.setAuditUserName(rs.getString("AUDITUSERNAME"));//审核领导
				personBadIntegrity.setPublicEDate(rs.getDate("PUBLICEDATE"));//发布结束时间（发布时须填写）
				personBadIntegrity.setPublicBDate(rs.getDate("PUBLICBDATE")); //发布开始时间（发布时须填写）
				personBadIntegrity.setIsPublic(rs.getString("ISPUBLIC"));	//是否发布；0：未发布，1：已发布
				personBadIntegrity.setCreateDate(rs.getDate("CREATEDATE"));//登记日期
				personBadIntegrity.setUserName(rs.getString("USERNAME")); //登记人姓名
				personBadIntegrity.setPunishMoney(rs.getString("PUNISHMONEY"));//处罚金额
				personBadIntegrity.setPunishDepartType(rs.getString("PUNISHDEPARTTYPE"));//处罚部门级别；0：部级，1：省市，2：地市，3：区县
				personBadIntegrity.setDepartId(rs.getString("DEPARTID"));//登记部门Id
				personBadIntegrity.setPersonName(rs.getString("personName"));//姓名
				personBadIntegrity.setIdCardTypeNum(rs.getString("idCardTypeNum"));//证件类型(字典表：TBIDCARDTYPEDIC)
				personBadIntegrity.setIdCard18(rs.getString("idCard18"));//证件号码
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return personBadIntegrity;
	}
	
	/**
	 * 修改
	 * @return
	 */
	public void modify(PersonBadIntegrity personBadIntegrity)
	{
		
		String sql = "update TBREGPERSONBADCREDITINFO set CORPNAME=?,CORPCODE=?,CREDITTYPE=?"
				+ ",CREDITCODE=?,HAPPENDATE=?,PRJNUM=?,DEPARTNAME=?,PUNISHEVIDENCE=?"
				+ ",PUNISHCONTENT=?,PUNISHNUMBER=?,PUNISHDATE=?,PUNISHEDATE=?,specialtyTypNum=?"
				+ ",PRJNAME=?,ADDRESS=?,BUILDCORPNAME=?,BUILDCORPCODE=?,PROVINCENUM=?,CITYNUM=?"
				+ ",COUNTYNUM=?,CREDITCLASSNUM=?,CONTENT=?,PUNISHDEPARTNAME=?,AUDITDATE=?"
				+ ",AUDITUSERNAME=?,PUBLICEDATE=?,PUBLICBDATE=?,ISPUBLIC=?,CREATEDATE=?"
				+ ",USERNAME=?,PUNISHMONEY=?,PUNISHDEPARTTYPE=?,departId=?,personName=?"
				+ ",idCardTypeNum=?,idCard18=? "
				+ "where badPersonId=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,personBadIntegrity.getCorpName()); //企业名称
			pstmt.setString(2,personBadIntegrity.getCorpCode());//组织机构代码
			pstmt.setString(3,personBadIntegrity.getCreditType());//不良行为类别(字典表：TBCORPBADDIC)
			pstmt.setString(4,personBadIntegrity.getCreditCode());//不良行为代码(字典表：TBCORPBADDIC)
			pstmt.setDate(5,personBadIntegrity.getHappenDate());//不良行为发生日期
			pstmt.setString(6,personBadIntegrity.getPrjNum());//项目编号
			pstmt.setString(7,personBadIntegrity.getDepartName());//登记部门
			pstmt.setString(8,personBadIntegrity.getPunishEvidence());//处罚依据
			pstmt.setString(9,personBadIntegrity.getPunishContent());//处罚决定内容
			pstmt.setString(10,personBadIntegrity.getPunishNumber());//处罚决定文号
			pstmt.setDate(11,personBadIntegrity.getPunishDate());//处罚日期
			pstmt.setDate(12,personBadIntegrity.getPunishEDate());//处罚截至日期
			pstmt.setString(13,personBadIntegrity.getSpecialtyTypNum());//人员类型(字典表：TBSPECIALTYTYPEDIC)
			pstmt.setString(14,personBadIntegrity.getPrjName()); //工程名称
			pstmt.setString(15,personBadIntegrity.getAddress());	//工程地址
			pstmt.setString(16,personBadIntegrity.getBuildCorpName());//建设单位
			pstmt.setString(17,personBadIntegrity.getBuildCorpCode());//建设单位组织机构代码
			pstmt.setString(18,personBadIntegrity.getProvinceNum());//不良行为发生所在省(字典表：TBXZQDMDIC)
			pstmt.setString(19,personBadIntegrity.getCityNum());//不良行为发生所在地市(字典表：TBXZQDMDIC)
			pstmt.setString(20,personBadIntegrity.getCountyNum());//不良行为发生所在区县(字典表：TBXZQDMDIC)
			pstmt.setString(21,personBadIntegrity.getCreditClassNum());//不良行为分类(字典表：TBCREDITTYPE)
			pstmt.setString(22,personBadIntegrity.getContent());//不良行为内容
			pstmt.setString(23,personBadIntegrity.getPunishDepartName());//处罚部门
			pstmt.setDate(24,personBadIntegrity.getAuditDate());//审核时间（发布时须填写）
			pstmt.setString(25,personBadIntegrity.getAuditUserName());//审核领导
			pstmt.setDate(26,personBadIntegrity.getPublicEDate());//发布结束时间（发布时须填写）
			pstmt.setDate(27,personBadIntegrity.getPublicBDate()); //发布开始时间（发布时须填写）
			pstmt.setString(28,personBadIntegrity.getIsPublic());	//是否发布；0：未发布，1：已发布
			pstmt.setDate(29,personBadIntegrity.getCreateDate());//登记日期
			pstmt.setString(30,personBadIntegrity.getUserName()); //登记人姓名
			pstmt.setString(31,personBadIntegrity.getPunishMoney());//处罚金额
			pstmt.setString(32,personBadIntegrity.getPunishDepartType());//处罚部门级别；0：部级，1：省市，2：地市，3：区县
			pstmt.setString(33,personBadIntegrity.getDepartId());//登记部门Id
			pstmt.setString(34, personBadIntegrity.getPersonName());//姓名
			pstmt.setString(35, personBadIntegrity.getIdCardTypeNum());//证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(36, personBadIntegrity.getIdCard18());//证件号码
			pstmt.setString(37,personBadIntegrity.getBadPersonId());	//主键
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
	public void delete(String badPersonId)
	{
		String sql = "update TBREGPERSONBADCREDITINFO set delType=? where badPersonId=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"1"); //主键
			pstmt.setString(2,badPersonId); //主键
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
	
	
	//人员类型(TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySpecialtyTypNums(){
		String sql = "select code,TYPELEVEL from TBSPECIALTYTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("TYPELEVEL"));
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
	
	//证件类型(字典表：TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums()
	{
		String sql = "select code,PAPERTYPE from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("PAPERTYPE"));
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
	
	//不良行为类别(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditType(){
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		
		return list;
	}
	//不良行为代码(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditCodes(){
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		
		return list;
	}
	//处罚依据(TBCORPBADDIC)
	public List<DictionaryClass> queryPuishEvidences(){
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		
		return list;
	}
}
