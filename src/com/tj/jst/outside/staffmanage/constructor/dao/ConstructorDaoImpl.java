package com.tj.jst.outside.staffmanage.constructor.dao;

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
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

public class ConstructorDaoImpl extends BaseDao implements IConstructorDao {
	
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
					constructor.setStampNum(rs.getString("stampNum"));//执业印章号
					constructor.setCorpCode(rs.getString("corpcode"));//组织机构代码
					constructor.setIdCard(rs.getString("idcard"));//身份证号
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
	
}
