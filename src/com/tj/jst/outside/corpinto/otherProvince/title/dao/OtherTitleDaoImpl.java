package com.tj.jst.outside.corpinto.otherProvince.title.dao;

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
import com.tj.jst.outside.staffmanage.title.model.Title;

/**
 * 外省职称人员
 * @author Administrator
 *
 */
public class OtherTitleDaoImpl extends BaseDao implements IOtherTitleDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 分页查询
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					Title title = new Title();
					title.setPersonId(rs.getString("personid"));				//主键
					title.setPersonName(rs.getString("personName"));			//人名
					title.setSexName(rs.getString("sexName")); 					//性别(字典表：TBSEXDIC)
					title.setIdCardTypeName(rs.getString("idCardTypeName")); 	//证件类型(字典表：TBIDCARDTYPEDIC)
					title.setIdCard(rs.getString("idCard")); 					//身份证号(必须为18位)
					title.setMobile(rs.getString("mobile")); 					//手机号码
					title.setTitleName(rs.getString("titleName"));				//职称
					title.setTitleMajor(rs.getString("titleMajor"));			//职称专业
					title.setTitleLevel(rs.getString("titleLevel"));			//职称等级
					title.setGraduatedSchool(rs.getString("graduatedSchool"));	//毕业学校
					title.setGraduatedDate(rs.getDate("graduatedDate"));		//毕业时间
					title.setStudyMajor(rs.getString("studyMajor"));			//所学专业
				    page.getData().add(title);
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
	 * 增加职称人员信息
	 */
	@Override
	public String add(Title title) {
		String message = "";
		String sql = "insert into TBREGTITLEPERSON(personName,sexNum,idCardTypeNum,idCard,mobile,"
				+ "titleName,titleMajor,titleLevel,graduatedSchool,studyMajor,graduatedDate,personId,corpId,corpCode,corpName) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String personId = UUID.randomUUID().toString();
		try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,title.getPersonName());	
				pstmt.setString(2,title.getSexNum()); 	
				pstmt.setString(3,title.getIdCardTypeNum());
				pstmt.setString(4,title.getIdCard());
				pstmt.setString(5,title.getMobile());		
				pstmt.setString(6,title.getTitleName());	
				pstmt.setString(7,title.getTitleMajor());		
				pstmt.setString(8,title.getTitleLevel());
				pstmt.setString(9,title.getGraduatedSchool());
				pstmt.setString(10,title.getStudyMajor());
				pstmt.setDate(11,title.getGraduatedDate());
				pstmt.setString(12,personId);
				pstmt.setString(13,title.getCorpId());
				pstmt.setString(14,title.getCorpCode());
				pstmt.setString(15,title.getCorpName());
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
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * 职称人员信息修改
	 */
	@Override
	public String modify(Title title) {
		String message = "";
		String sql = "update TBREGTITLEPERSON set personName=?,sexNum=?,idCardTypeNum=?,idCard=?,mobile=?,"
				+ "titleName=?,titleMajor=?,titleLevel=?,graduatedSchool=?,studyMajor=?,graduatedDate=? "
				+ "where personId=?";
		try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,title.getPersonName());	
				pstmt.setString(2,title.getSexNum()); 	
				pstmt.setString(3,title.getIdCardTypeNum());
				pstmt.setString(4,title.getIdCard());
				pstmt.setString(5,title.getMobile());		
				pstmt.setString(6,title.getTitleName());	
				pstmt.setString(7,title.getTitleMajor());		
				pstmt.setString(8,title.getTitleLevel());
				pstmt.setString(9,title.getGraduatedSchool());
				pstmt.setString(10,title.getStudyMajor());
				pstmt.setDate(11,title.getGraduatedDate());
				pstmt.setString(12,title.getPersonId());
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

	/**
	 * 根据personId的值来寻找被删除的人员信息，进行删除
	 */
	@Override
	public String delete(String personId) {
		String message = "";
		String sql = "delete from TBREGTITLEPERSON where personId=?";
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
	 * 字典类：性别
	 */
	@Override
	public List<DictionaryClass> querySexNums() {
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
	 * 字典：证件类型
	 */
	@Override
	public List<DictionaryClass> queryIdCardTypeNums() {
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
	 * 通过perosnId来寻找要进行删除或者修改操作的人员
	 */
	@Override
	public Title queryById(String personId) {
		String message = "";
		String sql = "select * from TBREGTITLEPERSON where personId=?";
		Title title = new Title();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,personId);	
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				title.setPersonId(rs.getString("personId"));
				title.setPersonName(rs.getString("personName"));
				title.setSexNum(rs.getString("sexNum")); 			//性别(字典表：TBSEXDIC)
				title.setIdCardTypeNum(rs.getString("idCardTypeNum")); 	//证件类型(字典表：TBIDCARDTYPEDIC)
				title.setIdCard(rs.getString("idCard")); 			//身份证号(必须为18位)
				title.setMobile(rs.getString("mobile")); 			//手机号码
				//职称
				title.setTitleName(rs.getString("titleName"));
				//职称专业
				title.setTitleMajor(rs.getString("titleMajor"));
				//职称级别
				title.setTitleLevel(rs.getString("titleLevel"));
				//毕业学校
				title.setGraduatedSchool(rs.getString("graduatedSchool"));
				//所学专业
				title.setStudyMajor(rs.getString("studyMajor"));
				//毕业时间
				title.setGraduatedDate(rs.getDate("graduatedDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return title;
	}

	/**
	 * 通过查询IDcard值和personID的值来判断所输入的证件信息是否重复！
	 */
	@Override
	public String queryIdCardInfo(String idCard, String personId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBREGTITLEPERSON where idCard=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,idCard);	
			rs = pstmt.executeQuery();
			if(personId == null || personId.equals("")){
				if(rs.next()){
					message= "公司名称： " + rs.getString("corpName") + "(职称人员)";
				}else{
					message = "成功";
				}
			}else{
				if(rs.next()){
					if(personId.equals(rs.getString("personId"))){
						message = "成功";
					}else{
						message= "公司名称： " + rs.getString("corpName") + "(职称人员)";
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
	 * 查询技术人员，判断是否有重复证件号码
	 */
	@Override
	public String queryFormSkill(String idCard) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBSKILLEDWORKER where identitycard = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,idCard);	
			rs = pstmt.executeQuery();
			if(rs.next()){
				message= "公司名称： " + rs.getString("corpName") + "（技术人员）";
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
	 * 查询岗位人员是否有重复证件号码
	 */
	@Override
	public String queryFormPos(String idCard) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from Position_BaseInfo where FCardId = ?";
		try {
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,idCard);	
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
