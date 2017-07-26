package com.tj.jst.outside.corpinto.otherProvince.skilledworker.dao;

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
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;

/**
 * 外省注册技术工种人员
 * 
 * @author DarkFlameMaster
 *
 */
public class OtherSkilledworkerDaoImpl extends BaseDao implements IOtherSkilledworkerDao  {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub(!!!!!!!这里)
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					Skilledworker skilledworder = new Skilledworker();
					skilledworder.setPersonId(rs.getString("personId")); 			//主键
					skilledworder.setPersonName(rs.getString("personName"));		//人名
					skilledworder.setSexName(rs.getString("sexName")); 				//性别(字典表：TBSEXDIC)
					skilledworder.setIdentityCard(rs.getString("identityCard")); 	//身份证（必须18位）
					skilledworder.setSkilledType(rs.getString("typeName")); 		//技术人员种类（字典表：TBSKILLEDWORkERTYPE）
					skilledworder.setSkilledLevel(rs.getString("levelName")); 		//技术人员级别（字典表：TBSKILLEDWORKERLEVEL）
					skilledworder.setMobile(rs.getString("mobile"));	 			//手机号
				    skilledworder.setCertificateNum(rs.getString("certificateNum"));
					page.getData().add(skilledworder);
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
	 * 技术人员种类查询
	 */
	@Override
	public List<DictionaryClass> skilledTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBSKILLEDWORKERTYPE";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("id"));
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

	/**
	 * 技术人员级别查询
	 */
	@Override
	public List<DictionaryClass> skilledLevelNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBSKILLEDWORKERLEVEL";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("id"));
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


	/**
	 * 增加技术人员及其相关信息
	 */
	@Override
	public String addPersonInfo(Skilledworker skilledworker) {
		// TODO Auto-generated method stub
		String personId = UUID.randomUUID().toString();
		String message = "";
		String sql = "insert into TBSkilledworker(PERSONID,SEXNUM,IDENTITYCARD,SKILLEDTYPENUM,"
				+ "SKILLEDLEVELNUM,PERSONNAME,NATIONALITYNUM,DEGREENUM,MOBILE,CORPCODE,CORPID,"
				+ "EDULEVELNUM,IDCARDTYPENUM,BIRTHDAY,CORPNAME,certificateNum) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,personId);							//注册人员Id
				pstmt.setString(2,skilledworker.getSexNum());			//注册人员性别
				pstmt.setString(3,skilledworker.getIdentityCard());		//注册人员证件号码
				pstmt.setString(4,skilledworker.getSkilledType());		//注册人员工种类型
				pstmt.setString(5,skilledworker.getSkilledLevel());		//注册人员工种级别
				pstmt.setString(6,skilledworker.getPersonName());		//注册人员姓名
				pstmt.setString(7,skilledworker.getNationAlityNum());	//注册人员民族
				pstmt.setString(8,skilledworker.getDegreeNum());		//注册人员学历
				pstmt.setString(9,skilledworker.getMobile());			//注册人员手机号码
				pstmt.setString(10,skilledworker.getCorpCode());		//注册人员的企业编码	
				pstmt.setString(11,skilledworker.getUserId());			//注册人员的企业编码ID
				pstmt.setString(12,skilledworker.getEduLevelNum());		//注册人员学位
				pstmt.setString(13,skilledworker.getIdCardTypeNum());	//注册人员证件种类
				pstmt.setDate(14,skilledworker.getBirthday());			//注册人员出生日期
				pstmt.setString(15, skilledworker.getCorpName());       //企业名称
				pstmt.setString(16, skilledworker.getCertificateNum());//证书编号
				int check = pstmt.executeUpdate();
				if(check == 1)
				{
					message = "添加人员成功！";
				}else
				{
					message = "添加人员失败！";
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
	 * 修改技术人员基本信息
	 */
	@Override
	public String modifyPersonInfo(Skilledworker skilledworker) {
		// TODO Auto-generated method stub
		String message = "";

		String sql = "update TBSkilledworker set SEXNUM=? , IDENTITYCARD = ? ,"
				+ " SKILLEDTYPENUM = ? , SKILLEDLEVELNUM = ? , PERSONNAME = ? ,"
				+ " NATIONALITYNUM = ? , DEGREENUM = ? , MOBILE = ? , "
				+ "EDULEVELNUM = ? , IDCARDTYPENUM = ? , BIRTHDAY = ?,"
				+ "certificateNum=? where PERSONID = ?";
		try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,skilledworker.getSexNum());
				pstmt.setString(2,skilledworker.getIdentityCard());
				pstmt.setString(3,skilledworker.getSkilledTypeNum());
				pstmt.setString(4,skilledworker.getSkilledLevelNum());
				pstmt.setString(5,skilledworker.getPersonName());
				pstmt.setString(6,skilledworker.getNationAlityNum());
				pstmt.setString(7,skilledworker.getDegreeNum());
				pstmt.setString(8,skilledworker.getMobile());
				pstmt.setString(9,skilledworker.getEduLevelNum());
				pstmt.setString(10,skilledworker.getIdCardTypeNum());
				pstmt.setDate(11,skilledworker.getBirthday());
				pstmt.setString(12, skilledworker.getCertificateNum());
				pstmt.setString(13, skilledworker.getPersonId());
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
	 * 删除技术人员的人员信息
	 */
	@Override
	public String deletePersonInfo(String personId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "delete from TBSkilledworker where personId=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,personId);	
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "删除成功！";
			}else
			{
				message = "删除失败！";
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
	

	/**
	 * 人员性别查询
	 */
	@Override
	public List<DictionaryClass> sexNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBSEXDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("sex"));
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

	/**
	 * 人员民族查询
	 */
	@Override
	public List<DictionaryClass> nationalNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBNATIONDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("nation"));
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

	/**
	 * 人员学历查询
	 */
	@Override
	public List<DictionaryClass> eduLevelNums() {
		// TODO Auto-generated method stub
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

	/**
	 * 人员学位查询
	 */
	@Override
	public List<DictionaryClass> degreeNums() {
		// TODO Auto-generated method stub
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

	/**
	 * 人员证件类型查询
	 */
	@Override
	public List<DictionaryClass> idCardTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("papertype"));
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

	/**
	 * 根据PersonId的值来寻找索要修改的人员信息
	 */
	@Override
	public Skilledworker queryById(String personId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBSKILLEDWORKER where personId=?";
		Skilledworker skilledworker = new Skilledworker();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,personId);	
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				skilledworker.setBirthday(rs.getDate("birthday"));
				skilledworker.setDegreeNum(rs.getString("degreenum"));
				skilledworker.setEduLevelNum(rs.getString("edulevelnum"));
				skilledworker.setIdCardTypeNum(rs.getString("idcardtypenum"));
				skilledworker.setIdentityCard(rs.getString("identitycard"));
				skilledworker.setMobile(rs.getString("mobile"));
				skilledworker.setNationAlityNum(rs.getString("nationalitynum"));
				skilledworker.setPersonName(rs.getString("personname"));
				skilledworker.setSexNum(rs.getString("sexnum"));
				//skilledworker.setSkilledLevelNum(rs.getString("SKILLEDLEVELNUM").trim());
				skilledworker.setSkilledTypeNum(rs.getString("SKILLEDTYPENUM").trim());
				skilledworker.setCertificateNum(rs.getString("certificateNum"));
				skilledworker.setPersonId(personId);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return skilledworker;
	}

	/**
	 * 根据所传入的identitycard和 personId的值来判断更改的信息中的IDCARD值是否为重复数据。
	 */
	@Override
	public String queryIdCardInfo(String identitycard, String personId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBSKILLEDWORKER where identitycard = ? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,identitycard);	
			rs = pstmt.executeQuery();
			if(personId == null || personId.equals("")){
				if(rs.next()){
					message= "公司名称： " + rs.getString("corpName") + "(技术人员)";
				}else{
					message = "成功";
				}
			}else{
				if(rs.next()){
					if(personId.equals(rs.getString("personId"))){
						message = "成功";
					}else{
						message= "公司名称： " + rs.getString("corpName") + "(技术人员)";
					}
				}else{
					message= "成功";
				}
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
	 * 在职称人员中查找是否有相同的身份证号码
	 */
	@Override
	public String queryFromTitle(String identitycard) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBREGTITLEPERSON where idCard = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,identitycard);	
			rs = pstmt.executeQuery();
			if(rs.next()){
				message= "公司名称： " + rs.getString("corpName") + "(职称人员)";
			}else{
				message = "成功";
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
	 * 在岗位人员中寻找是否有相同的证件号码
	 */
	@Override
	public String queryFromPos(String identitycard) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from Position_BaseInfo where FCardId = ?";
		try {
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,identitycard);	
			rs = pstmt.executeQuery();
			if(rs.next()){
				message= "公司名称： " + rs.getString("FEnterpriseName") + "(岗位人员)";
			}else{
				message = "成功";
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
	

}
