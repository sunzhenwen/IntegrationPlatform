package com.tj.jst.outside.corpinto.otherProvince.constructor.dao;

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
import com.tj.jst.outside.business.contractFiling.model.CertdetailInfo;
import com.tj.jst.outside.business.contractFiling.model.Certinfo;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * 外省注册建造师
 * @author Administrator
 *
 */
public class OtherConstructorDaoImpl extends BaseDao implements IOtherConstructorDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					Constructor constructor = new Constructor();
				    constructor.setPersonId(rs.getString("PERSONID"));			//主键
				    constructor.setPersonName(rs.getString("personName"));		//人名
					constructor.setSexName(rs.getString("sexName")); 			//性别(字典表：TBSEXDIC)
					constructor.setIdCardTypeName(rs.getString("idCardTypeName")); //证件类型(字典表：TBIDCARDTYPEDIC)
					constructor.setIdCard(rs.getString("idCard")); 				//身份证号(必须为18位)
					constructor.setBirthday(rs.getDate("birthday")); 			//生日
					constructor.setNationAlityName(rs.getString("paperTypeName"));//民族(字典表：TBNATIONDIC)
					constructor.setEduLevelName(rs.getString("eduLevelName")); 	//学历(字典表：TBEDULEVELDIC)
					constructor.setDegreeName(rs.getString("degreeName")); 		//学位(字典表：TBDEGREEDIC)
					constructor.setMobile(rs.getString("mobile")); 				//手机号码
					constructor.setSepecialtyTypName(rs.getString("specialtytypname"));//注册类型及等级名称
					constructor.setCertNum(rs.getString("certNum"));//注册证书编号
					constructor.setAwardDate(rs.getDate("awardDate"));//发证日期
					constructor.setAwardDepart(rs.getString("awardDepart"));//发证单位
					constructor.setStampNum(rs.getString("stampNum"));//执业印章号
					constructor.setEffectDate(rs.getDate("effectDate"));//注册有效期
					constructor.setCallingTypeName(rs.getString("callingTypeName"));//所在企业行业类型
					constructor.setCertId(rs.getString("certId"));//所在企业证书编号
					constructor.setTradeTypeAwardDate(rs.getDate("tradeTypeAwardDate"));//注册开始日期(1-8)
					constructor.setTradeTypeEffectDate(rs.getDate("tradeTypeEffectDate"));//注册截止日期(1-8)
					constructor.setRegTradeTypeName(rs.getString("regTradeTypeName")); //人员注册专业 
					constructor.setCorpCode(rs.getString("corpcode"));//组织机构代码
					constructor.setDataSource(rs.getString("dataSource"));
				    page.getData().add(constructor);
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

	//学历
	@Override
	public List<DictionaryClass> eduLevelNums() {
		String sql = "select * from TBEDULEVELDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("diploma"));
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

	//学位
	@Override
	public List<DictionaryClass> degreeNums() {
		String sql = "select * from TBDEGREEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("degree"));
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

	//查询详细
	@Override
	public Constructor queryDetailed(String idCard,String corpCode) {
		String sql = "select t.*,"
				+ "(select a.papertype from TBIDCARDTYPEDIC a where a.code=t.idcardtypenum) as idCardTypeName,"
				+ "(select b.typelevel from TBSPECIALTYTYPEDIC b where b.code=t.specialtytypnum) as sepecialtyTypName,"
				+ "(select c.type from TBCALLINGTYPEDIC c where c.code=t.callingtypenum) as callingTypeName,"
				+ "(select d.discipline from TBREGTRADETYPEDIC d where d.code=t.regtradetypenum) as regTradeTypeName,"
				+ "(select e.status from TBQSTATEDIC e where e.code=t.qstate) as qStateName "
				+ "from TBREGPERSONREGINFO t where t.idCard18=? and t.corpCode=? ";

		Constructor constructor = new Constructor();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			pstmt.setString(2, corpCode);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				constructor.setPersonId(rs.getString("personId"));
				constructor.setPersonName(rs.getString("personName"));
				constructor.setIdCardTypeName(rs.getString("idCardTypeName"));
				constructor.setIdCard(rs.getString("idCard18"));
				constructor.setSepecialtyTypName(rs.getString("sepecialtyTypName"));
				constructor.setCertNum(rs.getString("certNum"));
				constructor.setAwardDate(rs.getDate("awardDate"));
				constructor.setAwardDepart(rs.getString("awardDepart"));
				constructor.setStampNum(rs.getString("stampNum"));
				constructor.setEffectDate(rs.getDate("effectDate"));
				constructor.setCallingTypeName(rs.getString("callingTypeName"));
				constructor.setCorpName(rs.getString("corpName"));
				constructor.setCorpCode(rs.getString("corpCode"));
				constructor.setCertId(rs.getString("certId"));
				constructor.setRegTradeTypeName(rs.getString("regTradeTypeName"));
				constructor.setRegTradeTypeNum(rs.getString("REGTRADETYPENUM"));
				constructor.setTradeTypeAwardDate(rs.getDate("TRADETYPEAWARDDATE"));
				constructor.setTradeTypeEffectDate(rs.getDate("TRADETYPEEFFECTDATE"));
				constructor.setStateName(rs.getString("qStateName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return constructor;
	}
	
	//查询中建表中的数据(建造师)
	public List<Constructor> queryImportConstructor(String corpName,String corpCode)
	{
		String personId = UUID.randomUUID().toString();
		List<Constructor> list = new ArrayList<Constructor>();
		//建造师
		String sql = "select "
				+ "a.personname,"
				+ "a.idcardtypenum,"
				+ "a.idcard18,"
				+ "a.specialtytypnum,"
				+ "case when a.certnum='' or a.certnum is null then '-1'  else a.certnum end  as certnum,"
				+ "case when to_char(a.awarddate,'yyyy-MM-dd')='' or to_char(a.awarddate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.awarddate,'yyyy-MM-dd') end as awarddate,"
				+ "case when  a.awarddepart='' or  a.awarddepart is null then '-1'  else  a.awarddepart end  as awarddepart,"
				+ "case when a.stampnum='' or a.stampnum is null then '-1'  else a.stampnum end  as stampnum,"
				+ "case when to_char(a.effectdate,'yyyy-MM-dd')='' or to_char(a.effectdate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.effectdate,'yyyy-MM-dd') end as effectdate,"
				+ "'2' callingtypenum,a.corpname, a.corpcode,"
				+ "case when a.certid='' or a.certid is null then '-1'  else a.certid end  as certid,"
				+ "case when  b.TradeTypeNum is null then 1  else b.TradeTypeNum end  as  regtradetypenum,"
				+ "case when to_char(b.Yxqq,'yyyy-MM-dd')='' or b.Yxqq is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(b.Yxqq,'yyyy-MM-dd') end  as tradetypeawarddate,"
				+ "case when to_char(b.Yxqz,'yyyy-MM-dd')='' or b.Yxqz is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(b.Yxqz,'yyyy-MM-dd') end  as tradetypeeffectdate,"
				+ "a.qstate,"
				+ "updatetime,"
				+ "'1' oldornew,'07' datasource,'' ftype "
				+ "from  zjb_TBRegPersonReginfo a left join  zjb_TBregPersonZczy b "
				+ "on a.idcard18=b.idcard18 "
				+ "where　a.specialtytypnum　in　('81','82','83','84') and a.corpcode=?";

		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Constructor cs = new Constructor();
				cs.setPersonId(personId);
				cs.setPersonName(rs.getString("personName"));
				cs.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				cs.setIdCard(rs.getString("IDCARD18"));
				cs.setSepecialtyTypNum(rs.getString("specialtytypnum"));
				cs.setCertNum(rs.getString("certNum"));
				cs.setAwardDate(rs.getDate("awardDate"));
				cs.setAwardDepart(rs.getString("awardDepart"));
				cs.setStampNum(rs.getString("stampNum"));
				cs.setEffectDate(rs.getDate("effectDate"));
				cs.setCallingTypeNum(rs.getString("callingTypeNum"));
				cs.setCorpName(rs.getString("corpName"));
				cs.setCorpCode(rs.getString("corpCode"));
				cs.setCertId(rs.getString("certId"));
				cs.setRegTradeTypeNum(rs.getString("regTradeTypeNum"));
				cs.setTradeTypeAwardDate(rs.getDate("tradeTypeAwardDate"));
				cs.setTradeTypeEffectDate(rs.getDate("tradeTypeEffectDate"));
				cs.setqState(rs.getString("qState"));
				cs.setUpdateTime(rs.getDate("UPDATETIME"));
				cs.setOldOrNew(rs.getString("oldOrNew"));
				cs.setDataSource(rs.getString("dataSource"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	//查询中建表中的数据(监理工程师 第一专业)
	public List<Constructor> queryImportSupervisorOne(String corpName,String corpCode)
	{
		String personId = UUID.randomUUID().toString();
		List<Constructor> list = new ArrayList<Constructor>();
		//监理工程师 第一专业
		String sql = "select a.personname,a.idcardtypenum,a.idcard18,a.specialtytypnum,"
				+ "case when a.certnum='' or a.certnum is null then '-1'  else a.certnum end  as certnum,"
				+ "case when to_char(a.awarddate,'yyyy-MM-dd')='' or to_char(a.awarddate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.awarddate,'yyyy-MM-dd') end as awarddate,"
				+ "case when  a.awarddepart='' or  a.awarddepart is null then '-1'  else  a.awarddepart end  as awarddepart,"
				+ "case when a.stampnum='' or a.stampnum is null then '-1'  else a.stampnum end  as stampnum,"
				+ "case when to_char(a.effectdate,'yyyy-MM-dd')='' or to_char(a.effectdate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.effectdate,'yyyy-MM-dd') end as effectdate,"
				+ "callingtypenum,"
				+ "case when a.corpname='' or a.corpname is null then '-1'  else a.corpname end  as corpname,"
				+ "case when a.corpcode='' or a.corpcode is null then '-1'  else a.corpcode end  as  corpcode,"
				+ "case when a.certid='' or a.certid is null then '-1'  else a.certid end  as certid,"
				+ "case when  a.Regspec1 is null then 1  else a.Regspec1 end  as  regtradetypenum,"
				+ "a.qstate,updatetime,"
				+ "'1' oldornew,'07' datasource,'' ftype "
				+ "from  zjb_TBRegPersonReginfo a where　a.specialtytypnum='71' "
				+ "and a.corpcode=?";
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Constructor cs = new Constructor();
				cs.setPersonId(personId);
				cs.setPersonName(rs.getString("personName"));
				cs.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				cs.setIdCard(rs.getString("IDCARD18"));
				cs.setSepecialtyTypNum(rs.getString("SPECIALTYTYPNUM"));
				cs.setCertNum(rs.getString("certNum"));
				cs.setAwardDate(rs.getDate("awardDate"));
				cs.setAwardDepart(rs.getString("awardDepart"));
				cs.setStampNum(rs.getString("stampNum"));
				cs.setEffectDate(rs.getDate("effectDate"));
				cs.setCallingTypeNum(rs.getString("callingTypeNum"));
				cs.setCorpName(rs.getString("corpName"));
				cs.setCorpCode(rs.getString("corpCode"));
				cs.setCertId(rs.getString("certId"));
				cs.setRegTradeTypeNum(rs.getString("regTradeTypeNum"));
				cs.setTradeTypeAwardDate(rs.getDate("tradeTypeAwardDate"));
				cs.setTradeTypeEffectDate(rs.getDate("tradeTypeEffectDate"));
				cs.setqState(rs.getString("qState"));
				cs.setUpdateTime(rs.getDate("updateTime"));
				cs.setOldOrNew(rs.getString("oldOrNew"));
				cs.setDataSource(rs.getString("dataSource"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	//查询中建表中的数据(监理工程师 第二专业)
	public List<Constructor> queryImportSupervisorTwo(String corpName,String corpCode)
	{
		String personId = UUID.randomUUID().toString();
		List<Constructor> list = new ArrayList<Constructor>();
		
		//监理工程师 第二专业
		String sql = "select a.personname,a.idcardtypenum,a.idcard18,a.specialtytypnum,"
				+ "case when a.certnum='' or a.certnum is null then '-1'  else a.certnum end  as certnum,"
				+ "case when to_char(a.awarddate,'yyyy-MM-dd')='' or to_char(a.awarddate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.awarddate,'yyyy-MM-dd') end as awarddate,"
				+ "case when  a.awarddepart='' or  a.awarddepart is null then '-1'  else  a.awarddepart end  as awarddepart,"
				+ "case when a.stampnum='' or a.stampnum is null then '-1'  else a.stampnum end  as stampnum,"
				+ "case when to_char(a.effectdate,'yyyy-MM-dd')='' or to_char(a.effectdate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.effectdate,'yyyy-MM-dd') end as effectdate,"
				+ "callingtypenum,"
				+ "case when a.corpname='' or a.corpname is null then '-1'  else a.corpname end  as corpname,"
				+ "case when a.corpcode='' or a.corpcode is null then '-1'  else a.corpcode end  as  corpcode,"
				+ "case when a.certid='' or a.certid is null then '-1'  else a.certid end  as certid,"
				+ "case when  a.Regspec2 is null then 1  else a.Regspec2 end  as  regtradetypenum,"
				+ "a.qstate,"
				+ "updatetime,"
				+ "'1' oldornew,'07' datasource,'' ftype "
				+ "from  zjb_TBRegPersonReginfo a "
				+ "where　a.specialtytypnum='71' and a.Regspec2!=0 "
				+ "and   a.corpcode=?";
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Constructor cs = new Constructor();
				cs.setPersonId(personId);
				cs.setPersonName(rs.getString("personName"));
				cs.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				cs.setIdCard(rs.getString("IDCARD18"));
				cs.setSepecialtyTypNum(rs.getString("SPECIALTYTYPNUM"));
				cs.setCertNum(rs.getString("certNum"));
				cs.setAwardDate(rs.getDate("awardDate"));
				cs.setAwardDepart(rs.getString("awardDepart"));
				cs.setStampNum(rs.getString("stampNum"));
				cs.setEffectDate(rs.getDate("effectDate"));
				cs.setCallingTypeNum(rs.getString("callingTypeNum"));
				cs.setCorpName(rs.getString("corpName"));
				cs.setCorpCode(rs.getString("corpCode"));
				cs.setCertId(rs.getString("certId"));
				cs.setRegTradeTypeNum(rs.getString("regTradeTypeNum"));
				cs.setTradeTypeAwardDate(rs.getDate("tradeTypeAwardDate"));
				cs.setTradeTypeEffectDate(rs.getDate("tradeTypeEffectDate"));
				cs.setqState(rs.getString("qState"));
				cs.setUpdateTime(rs.getDate("updateTime"));
				cs.setOldOrNew(rs.getString("oldOrNew"));
				cs.setDataSource(rs.getString("dataSource"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//查询中建表中的数据(除了建造师和监理工程师以外的)
	public List<Constructor> queryImportOther(String corpName,String corpCode)
	{
		String personId = UUID.randomUUID().toString();
		List<Constructor> list = new ArrayList<Constructor>();
		//除了建造师和监理工程师以外的
		String sql = "select a.personname,a.idcardtypenum,a.idcard18,a.specialtytypnum,"
				+ "case when a.certnum='' or a.certnum is null then '-1'  else a.certnum end  as certnum,"
				+ "case when to_char(a.awarddate,'yyyy-MM-dd')='' or to_char(a.awarddate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.awarddate,'yyyy-MM-dd') end as awarddate,"
				+ "case when  a.awarddepart='' or  a.awarddepart is null then '-1'  else  a.awarddepart end  as awarddepart,"
				+ "case when a.stampnum='' or a.stampnum is null then '-1'  else a.stampnum end  as stampnum,"
				+ "case when to_char(a.effectdate,'yyyy-MM-dd')='' or to_char(a.effectdate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.effectdate,'yyyy-MM-dd') end as effectdate,"
				+ "callingtypenum,"
				+ "case when a.corpname='' or a.corpname is null then '-1'  else a.corpname end  as corpname,"
				+ "case when a.corpcode='' or a.corpcode is null then '-1'  else a.corpcode end  as  corpcode,"
				+ "case when a.certid='' or a.certid is null then '-1'  else a.certid end  as certid,"
				+ "'-1'  regtradetypenum,a.qstate,"
				+ "updatetime,"
				+ "'1' oldornew,'07' datasource,'' ftype "
				+ "from  zjb_TBRegPersonReginfo a "
				+ "where　a.specialtytypnum not in ('71','81','82','83','84') and "
				+ "a.corpcode=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Constructor cs = new Constructor();
				cs.setPersonId(personId);
				cs.setPersonName(rs.getString("personName"));
				cs.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				cs.setIdCard(rs.getString("IDCARD18"));
				cs.setSepecialtyTypNum(rs.getString("SPECIALTYTYPNUM"));
				cs.setCertNum(rs.getString("certNum"));
				cs.setAwardDate(rs.getDate("awardDate"));
				cs.setAwardDepart(rs.getString("awardDepart"));
				cs.setStampNum(rs.getString("stampNum"));
				cs.setEffectDate(rs.getDate("effectDate"));
				cs.setCallingTypeNum(rs.getString("callingTypeNum"));
				cs.setCorpName(rs.getString("corpName"));
				cs.setCorpCode(rs.getString("corpCode"));
				cs.setCertId(rs.getString("certId"));
				cs.setRegTradeTypeNum(rs.getString("regTradeTypeNum"));
				cs.setTradeTypeAwardDate(rs.getDate("AwardDate"));
				cs.setTradeTypeEffectDate(rs.getDate("EffectDate"));
				cs.setqState(rs.getString("qState"));
				cs.setUpdateTime(rs.getDate("updateTime"));
				cs.setOldOrNew(rs.getString("oldOrNew"));
				cs.setDataSource(rs.getString("dataSource"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//从中间表重新导入新数据
	public boolean importData(List<Constructor> list,String corpCode)
	{
		boolean check = true;
		//先删除老数据
		this.deletePersonInfo(corpCode);
		try{
				conn = ConnectionFactory.getBasicConnection();
				// 取消自动提交
	            conn.setAutoCommit(false);
				//再插入从中间表导入的新数据
				pstmt = conn.prepareStatement("insert into TBREGPERSONREGINFO"
						+ "(personId,personName,idCardTypeNum,IDCARD18,"
						+ "SPECIALTYTYPNUM,certNum,awardDate,awardDepart,stampNum,effectDate,"
						+ "callingTypeNum,corpName,corpCode,certId,regTradeTypeNum,tradeTypeAwardDate,"
						+ "tradeTypeEffectDate,qState,updateTime,oldOrNew,dataSource) values "
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				for(int i=0;i<list.size();i++)
	            {
	            	pstmt.setString(1,list.get(i).getPersonId());
					pstmt.setString(2,list.get(i).getPersonName());
					pstmt.setString(3,list.get(i).getIdCardTypeNum().trim());
					pstmt.setString(4,list.get(i).getIdCard());
					pstmt.setString(5,list.get(i).getSepecialtyTypNum());
					pstmt.setString(6,list.get(i).getCertNum());
					pstmt.setDate(7,list.get(i).getAwardDate());
					pstmt.setString(8,list.get(i).getAwardDepart());
					pstmt.setString(9,list.get(i).getStampNum());
					pstmt.setDate(10,list.get(i).getEffectDate());
					pstmt.setString(11,list.get(i).getCallingTypeNum());
					pstmt.setString(12,list.get(i).getCorpName());
					pstmt.setString(13,list.get(i).getCorpCode());
					pstmt.setString(14,list.get(i).getCertId());
					pstmt.setString(15,list.get(i).getRegTradeTypeNum());
					pstmt.setDate(16,list.get(i).getTradeTypeAwardDate());
					pstmt.setDate(17,list.get(i).getTradeTypeEffectDate());
					pstmt.setString(18,list.get(i).getqState());
					pstmt.setDate(19,list.get(i).getUpdateTime());
					pstmt.setString(20,list.get(i).getOldOrNew());
					pstmt.setString(21,"07");
					pstmt.addBatch();
				}
				
				pstmt.executeBatch();
	            // 如果没有错误，则表示可以向下执行 手工提交
	            conn.commit();
	            //删除中间表数据
	            this.deleteZjbPersonInfo(corpCode);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			check = false;
			e.printStackTrace();
			try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return check;
	}
	
	//查询中间表人员基础数据
	public List<Constructor> queryBasePerson(String corpCode)
	{
		String personId = UUID.randomUUID().toString();
		List<Constructor> list = new ArrayList<Constructor>();
		//查询人员基础中间表
		String sql = "select a.PersonName personname,"
				+ "a.SexNum sexnum,"
				+ "a.IDCardTypeNum idcardtypenum,"
				+ "a.IDCard18 idcard,"
				+ "is_date(a.Birthday) ISDATE,"
				+ "a.Birthday,"
				+ "case when  a.NationalityNum  is null then 1  else a.NationalityNum  end  as  nationalitynum,"
				+ "a.EduLevelNum edulevelnum,"
				+ "a.DegreeNum  degreenum,"
				+ "a.Mobile mobile,"
				+ "'' corpid,"
				+ "'' personid,"
				+ "sysdate updatetime,"
				+ "'1' oldornew ,"
				+ "'07' datasource,"
				+ "corpcode "
				+ "from zjb_tbregpersonbasicinfo a where corpCode=?	";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Constructor cs = new Constructor();
				cs.setPersonId(personId);
				cs.setPersonName(rs.getString("personName"));
				cs.setSexNum(rs.getString("sexNum"));
				cs.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				cs.setIdCard(rs.getString("idCard"));
				cs.setIsDate(rs.getString("isDate"));
				cs.setBirthday(rs.getDate("birthday"));
				cs.setNationAlityNum(rs.getString("nationAlityNum"));
				cs.setEduLevelNum(rs.getString("eduLevelNum"));
				cs.setDegreeNum(rs.getString("degreeNum"));
				cs.setMobile(rs.getString("mobile"));
				cs.setCorpId(rs.getString("corpId"));
				cs.setPersonId(rs.getString("personId"));
				cs.setUpdateTime(rs.getDate("updateTime"));
				cs.setOldOrNew(rs.getString("oldOrNew"));
				cs.setDataSource(rs.getString("dataSource"));
				cs.setCorpCode(rs.getString("corpCode"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//从中间表导入人员基础数据
	public boolean importBasePerson(List<Constructor> list,String corpCode)
	{
		boolean check = true;
		//先删除老数据
		this.deletePersonBase(corpCode);
		try{
				conn = ConnectionFactory.getBasicConnection();
				// 取消自动提交
	            conn.setAutoCommit(false);
				//再插入从中间表导入的新数据
				pstmt = conn.prepareStatement("insert into tbregpersonbasicinfo"
						+ "(personId,personName,sexNum,idCardTypeNum,"
						+ "idCard,birthday,nationAlityNum,eduLevelNum,degreeNum,"
						+ "mobile,corpId,updateTime,oldOrNew,dataSource,corpCode) "
						+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				for(int i=0;i<list.size();i++)
	            {
	            	pstmt.setString(1,list.get(i).getPersonId());
	            	pstmt.setString(2,list.get(i).getPersonName());
					pstmt.setString(3,list.get(i).getSexNum());
					pstmt.setString(4,list.get(i).getIdCardTypeNum());
					pstmt.setString(5,list.get(i).getIdCard());
					pstmt.setDate(6,list.get(i).getBirthday());
					pstmt.setString(7,list.get(i).getNationAlityNum());
					pstmt.setString(8,list.get(i).getEduLevelNum());
					pstmt.setString(9,list.get(i).getDegreeNum());
					pstmt.setString(10,list.get(i).getMobile());
					pstmt.setString(11,list.get(i).getCorpId());
					pstmt.setDate(12,list.get(i).getUpdateTime());
					pstmt.setString(13,list.get(i).getOldOrNew());
					pstmt.setString(14,"07");
					pstmt.setString(15,list.get(i).getCorpCode());
					pstmt.addBatch();
				}
				
				pstmt.executeBatch();
	            // 如果没有错误，则表示可以向下执行 手工提交
	            conn.commit();
	            //删除中间表人员基础数据
	            this.deleteZjbPersonBase(corpCode);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			check = false;
			e.printStackTrace();
			try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return check;
	}
	
	//删除人员基本信息
	public void deletePersonBase(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from tbregpersonbasicinfo where CORPCODE=? and dataSource=07";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//删除中间表人员基本信息
	public void deleteZjbPersonBase(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from ZJB_tbregpersonbasicinfo where CORPCODE=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//删除人员信息表
	public void deletePersonInfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from TBREGPERSONREGINFO where CORPCODE=? and dataSource=07";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//删除中间表人员信息表
	public void deleteZjbPersonInfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from ZJB_TBREGPERSONREGINFO where CORPCODE=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//查询企业资质中间表(证书表)
	public List<Certinfo> queryCertinfo(String corpCode)
	{
		List<Certinfo> list = new ArrayList<Certinfo>();
		//查询人员基础中间表
		String sql = "select CertID,CertTypeNum,TitleLevelNum,CorpName,CorpCode,LicenseNum,"
				+ "ProvinceNum,CityNum,CountyNum,Address,RegPrin,EconomicNum,LegalMan,"
				+ "LegalManDuty,LegaManProTitle,TechMan,TechManDuty,TechManProTitle,"
				+ "UnitMan,UnitManDuty,UnitManProTitle,OrganName,OrganDate,EndDate,IsValid,"
				+ "'1' oldornew,'07' datasource "
				+ "from ZJB_TBCorpCertinfo where corpCode=?	";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Certinfo ct = new Certinfo();
				ct.setCertID(rs.getString("certID"));
				ct.setCertTypeNum(rs.getString("certTypeNum"));
				ct.setTitleLevelNum(rs.getString("titleLevelNum"));
				ct.setCorpName(rs.getString("corpName"));
				ct.setCorpCode(rs.getString("corpCode"));
				ct.setLicenseNum(rs.getString("licenseNum"));
				ct.setProvinceNum(rs.getString("provinceNum"));
				ct.setCityNum(rs.getString("cityNum"));
				ct.setCountyNum(rs.getString("countyNum"));
				ct.setAddress(rs.getString("address"));
				ct.setRegPrin(rs.getString("regPrin"));
				ct.setEconomicNum(rs.getString("economicNum"));
				ct.setLegalMan(rs.getString("legalMan"));
				ct.setLegalManDuty(rs.getString("legalManDuty"));
				ct.setLegaManProTitle(rs.getString("legaManProTitle"));
				ct.setTechMan(rs.getString("techMan"));
				ct.setTechManDuty(rs.getString("techManDuty"));
				ct.setTechManProTitle(rs.getString("techManProTitle"));
				ct.setUnitMan(rs.getString("unitMan"));
				ct.setUnitManDuty(rs.getString("unitManDuty"));
				ct.setUnitManProTitle(rs.getString("unitManProTitle"));
				ct.setOrganName(rs.getString("organName"));
				ct.setOrganDate(rs.getDate("organDate"));
				ct.setEndDate(rs.getDate("endDate"));
				ct.setIsValid(rs.getString("isValid"));
				ct.setOldornew(rs.getString("oldornew"));
				ct.setDatasource(rs.getString("datasource"));
				list.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//查询企业资质中间表(资质表)
	public List<CertdetailInfo> queryCertdetailinfo(String corpCode)
	{
		List<CertdetailInfo> list = new ArrayList<CertdetailInfo>();
		String sql = "select CertID,CorpCode,'-1' corpname,CertTypeNum,TradeTypeNum,"
				+ "TradeBoundNum,TitleLevelNum,Mark,IsMaster,NoteNumber,"
				+ "NoteDate,'001' addtypenum,"
				+ "'1' oldornew,'07' datasource "
				+ "from zjb_TBCorpCertdetailinfo where corpCode=?	";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				CertdetailInfo ct = new CertdetailInfo();
				ct.setCertID(rs.getString("certID"));
				ct.setCorpCode(rs.getString("corpCode"));
				ct.setCorpname(rs.getString("corpname"));
				ct.setCertTypeNum(rs.getString("certTypeNum"));
				ct.setTradeTypeNum(rs.getString("tradeTypeNum"));
				ct.setTradeBoundNum(rs.getString("tradeBoundNum"));
				ct.setTitleLevelNum(rs.getString("titleLevelNum"));
				ct.setMark(rs.getString("mark"));
				ct.setIsMaster(rs.getString("isMaster"));
				ct.setNoteNumber(rs.getString("noteNumber"));
				ct.setNoteDate(rs.getDate("noteDate"));
				ct.setAddTypeNum(rs.getString("addTypeNum"));
				ct.setOldOrNew(rs.getString("oldOrNew"));
				ct.setDataSource(rs.getString("dataSource"));
				list.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//导入证书表
	public boolean importCertinfo(List<Certinfo> listCertinfo,String corpCode)
	{
		boolean check = true;
		//先删除老数据
		this.deleteCertinfo(corpCode);
		try{
				conn = ConnectionFactory.getBasicConnection();
				// 取消自动提交
	            conn.setAutoCommit(false);
				//再插入从中间表导入的新数据
				pstmt = conn.prepareStatement("insert into TBCorpCertinfo"
						+ "(CertID,CertTypeNum,TitleLevelNum,CorpName,"
						+ "CorpCode,LicenseNum,ProvinceNum,CityNum,CountyNum,"
						+ "Address,RegPrin,EconomicNum,LegalMan,LegalManDuty,LegaManProTitle,"
						+ "TechMan,TechManDuty,TechManProTitle,UnitMan,UnitManDuty,UnitManProTitle,"
						+ "OrganName,OrganDate,EndDate,IsValid,oldornew,datasource,corpCertid) "
						+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERT_SEQ.nextval)");
				
				for(int i=0;i<listCertinfo.size();i++)
	            {
					pstmt.setString(1,listCertinfo.get(i).getCertID());
					pstmt.setString(2,listCertinfo.get(i).getCertTypeNum());
					pstmt.setString(3,listCertinfo.get(i).getTitleLevelNum());
					pstmt.setString(4,listCertinfo.get(i).getCorpName());
					pstmt.setString(5,listCertinfo.get(i).getCorpCode());
					pstmt.setString(6,listCertinfo.get(i).getLicenseNum());
					pstmt.setString(7,listCertinfo.get(i).getProvinceNum());
					pstmt.setString(8,listCertinfo.get(i).getCityNum());
					pstmt.setString(9,listCertinfo.get(i).getCountyNum());
					pstmt.setString(10,listCertinfo.get(i).getAddress());
					pstmt.setString(11,listCertinfo.get(i).getRegPrin());
					pstmt.setString(12,listCertinfo.get(i).getEconomicNum());
					pstmt.setString(13,listCertinfo.get(i).getLegalMan());
					pstmt.setString(14,listCertinfo.get(i).getLegalManDuty());
					pstmt.setString(15,listCertinfo.get(i).getLegaManProTitle());
					pstmt.setString(16,listCertinfo.get(i).getTechMan());
					pstmt.setString(17,listCertinfo.get(i).getTechManDuty());
					pstmt.setString(18,listCertinfo.get(i).getTechManProTitle());
					pstmt.setString(19,listCertinfo.get(i).getUnitMan());
					pstmt.setString(20,listCertinfo.get(i).getUnitManDuty());
					pstmt.setString(21,listCertinfo.get(i).getUnitManProTitle());
					pstmt.setString(22,listCertinfo.get(i).getOrganName());
					pstmt.setDate(23,listCertinfo.get(i).getOrganDate());
					pstmt.setDate(24,listCertinfo.get(i).getEndDate());
					pstmt.setString(25,listCertinfo.get(i).getIsValid());
					pstmt.setString(26,listCertinfo.get(i).getOldornew());
					pstmt.setString(27,"07");
					pstmt.addBatch();
				}
				
				pstmt.executeBatch();
	            // 如果没有错误，则表示可以向下执行 手工提交
	            conn.commit();
	            //删除中间表证书数据
	            this.deleteZjbCertinfo(corpCode);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			check = false;
			e.printStackTrace();
			try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return check;
	}
	
	//删除证书表
	public void deleteCertinfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from TBCorpCertinfo where CORPCODE=? and dataSource=07";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//删除中间表证书表
	public void deleteZjbCertinfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from ZJB_TBCorpCertinfo where CORPCODE=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//导入资质信息表
	public boolean importCertdetailinfo(List<CertdetailInfo> listCertdetailinfo,String corpCode)
	{
		boolean check = true;
		//先删除老数据
		this.deleteCertdetailInfo(corpCode);
		try{
			conn = ConnectionFactory.getBasicConnection();
			// 取消自动提交
            conn.setAutoCommit(false);
			//再插入从中间表导入的新数据
			pstmt = conn.prepareStatement("insert into TBCorpCertdetailinfo"
					+ "(CertID,CorpCode,corpname,CertTypeNum,TradeTypeNum,TradeBoundNum,"
					+ "TitleLevelNum,Mark,IsMaster,NoteNumber,NoteDate,"
					+ "addtypenum,oldornew,datasource,certdetailid) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERT_SEQ.nextval)");
			
			for(int i=0;i<listCertdetailinfo.size();i++)
            {
				pstmt.setString(1,listCertdetailinfo.get(i).getCertID());
				pstmt.setString(2,listCertdetailinfo.get(i).getCorpCode());
				pstmt.setString(3,listCertdetailinfo.get(i).getCorpname());
				pstmt.setString(4,listCertdetailinfo.get(i).getCertTypeNum());
				pstmt.setString(5,listCertdetailinfo.get(i).getTradeTypeNum());
				pstmt.setString(6,listCertdetailinfo.get(i).getTradeBoundNum());
				pstmt.setString(7,listCertdetailinfo.get(i).getTitleLevelNum());
				pstmt.setString(8,listCertdetailinfo.get(i).getMark());
				pstmt.setString(9,listCertdetailinfo.get(i).getIsMaster());
				pstmt.setString(10,listCertdetailinfo.get(i).getNoteNumber());
				pstmt.setDate(11,listCertdetailinfo.get(i).getNoteDate());
				pstmt.setString(12,listCertdetailinfo.get(i).getAddTypeNum());
				pstmt.setString(13,listCertdetailinfo.get(i).getOldOrNew());
				pstmt.setString(14,"07");
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
            // 如果没有错误，则表示可以向下执行 手工提交
            conn.commit();
            //删除中间表数据
            this.deleteZjbCertdetailInfo(corpCode);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			check = false;
			e.printStackTrace();
			try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return check;
	}
	
	//删除资质信息表
	public void deleteCertdetailInfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from TBCorpCertdetailinfo where CORPCODE=? and dataSource=07";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//删除中间表资质信息表
	public void deleteZjbCertdetailInfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from ZJB_TBCorpCertdetailinfo where CORPCODE=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
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
	 * 添加
	 * @return
	 */
	public void add(Constructor constructor)
	{
		try{
			String personId = UUID.randomUUID().toString();
			conn = ConnectionFactory.getBasicConnection();
			// 取消自动提交
            conn.setAutoCommit(false);
            
            String sql = "insert into TBREGPERSONBASICINFO "
            		+ "(PERSONNAME,SEXNUM,IDCARDTYPENUM,IDCARD,"
					+ "BIRTHDAY,NATIONALITYNUM,EDULEVELNUM,DEGREENUM,MOBILE,"
					+ "CORPID,PERSONID,UPDATETIME,OLDORNEW,DATASOURCE,"
					+ "CORPCODE) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            String sql1 = "insert into TBREGPERSONREGINFO "
					+ "(PERSONNAME,IDCARDTYPENUM,IDCARD18,SPECIALTYTYPNUM,"
					+ "CERTNUM,AWARDDATE,AWARDDEPART,STAMPNUM,EFFECTDATE,"
					+ "CALLINGTYPENUM,CORPNAME,CORPCODE,CERTID,REGTRADETYPENUM,"
					+ "TRADETYPEAWARDDATE,TRADETYPEEFFECTDATE,QSTATE,CORPID,PERSONID,"
					+ "UPDATETIME,OLDORNEW,DATASOURCE,FTYPE,REGTRADETYPENUM1,"
					+ "REGTRADETYPENUM2,REGTRADETYPENUM3) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(sql);
            //姓名
            pstmt.setString(1,constructor.getPersonName());
            pstmt.setString(2,constructor.getSexNum()); //性别(字典表：TBSEXDIC)
            pstmt.setString(3,constructor.getIdCardTypeNum());//证件类型(字典表：TBIDCARDTYPEDIC)
            pstmt.setString(4,constructor.getIdCard());//身份证号(必须为18位)
            pstmt.setDate(5,constructor.getBirthday());//生日
            
            if(!"".equals(constructor.getNationAlityNum()))
            {
            	//民族(字典表：TBNATIONDIC)
            	pstmt.setInt(6,Integer.parseInt(constructor.getNationAlityNum()));//民族(字典表：TBNATIONDIC)
            }else
            {
            	pstmt.setInt(6,0);//民族(字典表：TBNATIONDIC)
            }
            
            if(!"".equals(constructor.getEduLevelNum()))
            {
            	//学历(字典表：TBEDULEVELDIC)
            	pstmt.setInt(7,Integer.parseInt(constructor.getEduLevelNum()));//民族(字典表：TBNATIONDIC)
            }else
            {
            	pstmt.setInt(7,0);//学历(字典表：TBEDULEVELDIC)
            }
            
            if(!"".equals(constructor.getNationAlityNum()))
            {
            	//学位(字典表：TBDEGREEDIC)
            	pstmt.setInt(8,Integer.parseInt(constructor.getDegreeNum()));//民族(字典表：TBNATIONDIC)
            }else
            {
            	//学位(字典表：TBDEGREEDIC)
            	pstmt.setInt(8,0);//民族(字典表：TBNATIONDIC)
            }
            pstmt.setString(9, constructor.getMobile());//手机号码
            pstmt.setString(10, constructor.getCorpId());//企业ID
            pstmt.setString(11, personId); //人员ID
            pstmt.setDate(12, new Date(new java.util.Date().getTime())); //操作日期
            pstmt.setString(13,"1"); //0：老数据 1：新数据
            pstmt.setString(14,"09"); //数据来源系统
            pstmt.setString(15,constructor.getCorpCode()); //所在企业组织机构代码证
            pstmt.executeUpdate();
            
			pstmt = conn.prepareStatement(sql1);
			//姓名
			pstmt.setString(1,constructor.getPersonName());
			//证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(2,constructor.getIdCardTypeNum());
			//身份证号
			pstmt.setString(3,constructor.getIdCard());
			//注册类型及等级(字典表：TBSPECIALTYTYPEDIC)
			pstmt.setString(4,constructor.getSepecialtyTypNum());
			//注册证书编号
			pstmt.setString(5,constructor.getCertNum());
			//发证日期
			pstmt.setDate(6,constructor.getAwardDate());
			//发证单位
			pstmt.setString(7,constructor.getAwardDepart());
			//执业印章号
			pstmt.setString(8,constructor.getStampNum());
			//注册有效期
			pstmt.setDate(9,constructor.getEffectDate());
			//所在企业行业类型(字典表：TBCALLINGTYPEDIC)
			pstmt.setString(10,constructor.getCallingTypeNum());
			//所在企业名称
			pstmt.setString(11,constructor.getCorpName());
			//所在企业组织机构代码
			pstmt.setString(12,constructor.getCorpCode());
			//所在企业证书编号
			pstmt.setString(13,constructor.getCertId());
			//注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
			pstmt.setInt(14,Integer.parseInt(constructor.getRegTradeTypeNum()));
			//注册开始日期(1-8)
			pstmt.setDate(15,constructor.getTradeTypeAwardDate());
			//注册截止日期(1-8)
			pstmt.setDate(16,constructor.getTradeTypeEffectDate());
			//职业资格状态(1-8)(字典表：TBQSTATEDIC)
			pstmt.setString(17,constructor.getState());
			//企业ID
			pstmt.setString(18,constructor.getCorpId());
			//人员ID(主键)
			pstmt.setString(19,personId);
			//操作日期(添加日期)
			pstmt.setDate(20,new Date(new java.util.Date().getTime())); 
			//0：老数据 1：新数据
			pstmt.setString(21,"1");
			//数据来源系统   09:外省企业手动添加
			pstmt.setString(22,"09");
			//业务类型
			pstmt.setString(23,"初始注册"); 
			
			if(!"".equals(constructor.getRegTradeTypeNum1()))
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(24,Integer.parseInt(constructor.getRegTradeTypeNum1()));
			}else
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(24,0);
			}
			if(!"".equals(constructor.getRegTradeTypeNum2()))
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(25,Integer.parseInt(constructor.getRegTradeTypeNum2()));
			}else
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(25,0);
			}
			if(!"".equals(constructor.getRegTradeTypeNum3()))
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(26,Integer.parseInt(constructor.getRegTradeTypeNum3()));
			}else
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(26,0);
			}
			pstmt.executeUpdate();
			
			conn.commit();
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public Constructor queryById(String personId)
	{
		String sql = "select * from V_CONSTRUCTOR where personId=? ";

		Constructor constructor = new Constructor();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				constructor.setPersonId(rs.getString("personId"));
				constructor.setPersonName(rs.getString("personName"));
				constructor.setSexNum(rs.getString("sexNum"));
				constructor.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				constructor.setIdCardTypeName(rs.getString("idCardTypeName"));
				constructor.setIdCard(rs.getString("idCard"));
				constructor.setBirthday(rs.getDate("birthday"));
				constructor.setNationAlityNum(Integer.toString(rs.getInt("nationAlityNum")));
				constructor.setEduLevelNum(Integer.toString(rs.getInt("eduLevelNum")));
				constructor.setDegreeNum(Integer.toString(rs.getInt("degreeNum")));
				constructor.setMobile(rs.getString("mobile"));
				
				constructor.setSepecialtyTypNum(Integer.toString(rs.getInt("SPECIALTYTYPNUM")));
				constructor.setCertNum(rs.getString("certNum"));
				constructor.setAwardDate(rs.getDate("awardDate"));
				constructor.setAwardDepart(rs.getString("awardDepart"));
				constructor.setStampNum(rs.getString("stampNum"));
				constructor.setEffectDate(rs.getDate("effectDate"));
				constructor.setCallingTypeNum(Integer.toString(rs.getInt("callingTypeNum")));
				constructor.setCorpName(rs.getString("corpName"));
				constructor.setCorpCode(rs.getString("corpCode"));
				constructor.setCertId(rs.getString("certId"));
				constructor.setRegTradeTypeNum(Integer.toString(rs.getInt("regTradeTypeNum")));
				constructor.setRegTradeTypeNum(rs.getString("REGTRADETYPENUM"));
				constructor.setTradeTypeAwardDate(rs.getDate("TRADETYPEAWARDDATE"));
				constructor.setTradeTypeEffectDate(rs.getDate("TRADETYPEEFFECTDATE"));
				constructor.setStateName(rs.getString("qStateName"));
				constructor.setState(rs.getString("qState"));
				constructor.setRegTradeTypeNum1(Integer.toString(rs.getInt("regTradeTypeNum1")));
				constructor.setRegTradeTypeNum2(Integer.toString(rs.getInt("regTradeTypeNum2")));
				constructor.setRegTradeTypeNum3(Integer.toString(rs.getInt("regTradeTypeNum3")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return constructor;
	}
	
	/**
	 * 修改
	 * @return
	 */
	public void modify(Constructor constructor)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			// 取消自动提交
            conn.setAutoCommit(false);
            
            String sql = "update TBREGPERSONBASICINFO set"
            		+ " PERSONNAME=?,SEXNUM=?,IDCARDTYPENUM=?,IDCARD=?,"
					+ "BIRTHDAY=?,NATIONALITYNUM=?,EDULEVELNUM=?,DEGREENUM=?,MOBILE=? "
					+ "where personId=? ";
            
            String sql1 = "update TBREGPERSONREGINFO set "
					+ "PERSONNAME=?,IDCARDTYPENUM=?,IDCARD18=?,SPECIALTYTYPNUM=?,"
					+ "CERTNUM=?,AWARDDATE=?,AWARDDEPART=?,STAMPNUM=?,EFFECTDATE=?,"
					+ "CALLINGTYPENUM=?,CERTID=?,REGTRADETYPENUM=?,"
					+ "TRADETYPEAWARDDATE=?,TRADETYPEEFFECTDATE=?,QSTATE=?,"
					+ "REGTRADETYPENUM1=?,REGTRADETYPENUM2=?,REGTRADETYPENUM3=? "
					+ "where personId=?";
            
            pstmt = conn.prepareStatement(sql);
            //姓名
            pstmt.setString(1,constructor.getPersonName());
            pstmt.setString(2,constructor.getSexNum()); //性别(字典表：TBSEXDIC)
            pstmt.setString(3,constructor.getIdCardTypeNum());//证件类型(字典表：TBIDCARDTYPEDIC)
            pstmt.setString(4,constructor.getIdCard());//身份证号(必须为18位)
            pstmt.setDate(5,constructor.getBirthday());//生日
            
            if(!"".equals(constructor.getNationAlityNum()))
            {
            	
            	pstmt.setInt(6,Integer.parseInt(constructor.getNationAlityNum()));
            }else
            {
            	pstmt.setInt(6,0);
            }
            
            if(!"".equals(constructor.getEduLevelNum()))
            {
            	
            	pstmt.setInt(7,Integer.parseInt(constructor.getEduLevelNum()));
            }else
            {
            	pstmt.setInt(7,0);
            }
            
            if(!"".equals(constructor.getNationAlityNum()))
            {
            	
            	pstmt.setInt(8,Integer.parseInt(constructor.getDegreeNum()));
            }else
            {
            	
            	pstmt.setInt(8,0);
            }
            pstmt.setString(9, constructor.getMobile());//手机号码
            pstmt.setString(10, constructor.getPersonId()); //人员ID
            pstmt.executeUpdate();
            
			pstmt = conn.prepareStatement(sql1);
			//姓名
			pstmt.setString(1,constructor.getPersonName());
			//证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(2,constructor.getIdCardTypeNum());
			//身份证号
			pstmt.setString(3,constructor.getIdCard());
			//注册类型及等级(字典表：TBSPECIALTYTYPEDIC)
			pstmt.setString(4,constructor.getSepecialtyTypNum());
			//注册证书编号
			pstmt.setString(5,constructor.getCertNum());
			//发证日期
			pstmt.setDate(6,constructor.getAwardDate());
			//发证单位
			pstmt.setString(7,constructor.getAwardDepart());
			//执业印章号
			pstmt.setString(8,constructor.getStampNum());
			//注册有效期
			pstmt.setDate(9,constructor.getEffectDate());
			//所在企业行业类型(字典表：TBCALLINGTYPEDIC)
			pstmt.setString(10,constructor.getCallingTypeNum());
			//所在企业证书编号
			pstmt.setString(11,constructor.getCertId());
			//注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
			pstmt.setInt(12,Integer.parseInt(constructor.getRegTradeTypeNum()));
			//注册开始日期(1-8)
			pstmt.setDate(13,constructor.getTradeTypeAwardDate());
			//注册截止日期(1-8)
			pstmt.setDate(14,constructor.getTradeTypeEffectDate());
			//职业资格状态(1-8)(字典表：TBQSTATEDIC)
			pstmt.setString(15,constructor.getState());
			
			if(!"".equals(constructor.getRegTradeTypeNum1()))
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(16,Integer.parseInt(constructor.getRegTradeTypeNum1()));
			}else
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(16,0);
			}
			
			if(!"".equals(constructor.getRegTradeTypeNum2()))
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(17,Integer.parseInt(constructor.getRegTradeTypeNum2()));
			}else
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(17,0);
			}
			
			if(!"".equals(constructor.getRegTradeTypeNum3()))
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(18,Integer.parseInt(constructor.getRegTradeTypeNum3()));
			}else
			{
				//增项注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
				pstmt.setInt(18,0);
			}
			pstmt.setString(19, constructor.getPersonId());
			pstmt.executeUpdate();
			
			conn.commit();
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * 删除
	 * @return
	 */
	public void deletePerson(String personId)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			// 取消自动提交
            conn.setAutoCommit(false);
            
            String sql = "delete from TBREGPERSONBASICINFO where personId=? ";
            
            String sql1 = "delete from TBREGPERSONREGINFO where personId=?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,personId);
            pstmt.executeUpdate();
            
            
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,personId);
			pstmt.executeUpdate();
			
			conn.commit();
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//职业资格状态(1-8)(字典表：TBQSTATEDIC)
	public List<DictionaryClass> queryStates()
	{
		String sql = "select * from TBQSTATEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("status"));
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
	
	//注册专业编号(1-8)(字典表：TBREGTRADETYPEDIC)
	public List<DictionaryClass> queryRegTradeTypeNums()
	{
		String sql = "select * from TBREGTRADETYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("discipline"));
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
	//所在企业行业类型(字典表：TBCALLINGTYPEDIC)
	public List<DictionaryClass> queryCallingTypeNums()
	{
		String sql = "select * from TBCALLINGTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("type"));
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
	//注册类型及等级(字典表：TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySepecialtyTypNums()
	{
		String sql = "select * from TBSPECIALTYTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("typelevel"));
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
		String sql = "select * from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("papertype"));
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
	
	//民族
	public List<DictionaryClass> nationAlityNums()
	{
		String sql = "select * from TBNATIONDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("NATION"));
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
