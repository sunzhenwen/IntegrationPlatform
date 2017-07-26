package com.tj.jst.outside.business.quality.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.PERSON_SLRY;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;

public class PositionAndThreePersonDaoImpl extends BaseDao implements PositionAndThreePersonDao
{

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public Page pagePositionQuery(Condition condition) {
		// TODO 自动生成的方法存根
		//Page page = super.basePagedQuery(condition);
		Page page = super.basePagedQuery(condition);//岗位人员
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
				
					ContractFiling contractfiling = new ContractFiling();
					//项目专职人员信息
					contractfiling.setConstructorNamezzry(rs.getString("FName"));//姓名
					contractfiling.setConstructorNamezzrygw(rs.getString("FCertNumber"));//专职安全人员岗位编号
					contractfiling.setConstructorNamezzrysf(rs.getString("FCardID"));//专职人员安全身份证号
					page.getData().add(contractfiling);
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

	@Override
	public boolean queryCorpBasicIndfo(String corpName, String corpCode) {
		// TODO 自动生成的方法存根
		String sql = "select provincenum from tbcorpbasicinfo "
				+ "   where corpname=? and rownum=1";
		//List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		boolean isLocal=true;
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				String provincenum=rs.getString("provincenum").trim();
				isLocal=provincenum.equals("230000");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return isLocal;
	}

	@Override
	public List<PERSON_SLRY> queryPERSON_SLRYList(String FIdCertNo,String FEntName) 
	{
		String valueId="";
		StringBuffer sb = new StringBuffer(" ");
		if(FIdCertNo!=null&&FIdCertNo.length()!=0)
		{
			valueId=FIdCertNo;
			sb.append(" where fidcertno=? "); 
		}
		if(FEntName!=null&&FEntName.length()!=0)
		{
			valueId=FEntName;
			sb.append(" where fentname=? "); 
		}
		// TODO 自动生成的方法存根
		String sql = " select fname,fidcertno,fentname,fcerttype,fentname1,fcertnumber,to_char(fregdate,'yyyy-mm-dd') fregdate,to_char(fregenddate,'yyyy-mm-dd') fregenddate,fstate "
				+ " from THREETYPE_PERSON   "
		        + " " + sb.toString();
	List<PERSON_SLRY> list = new ArrayList<PERSON_SLRY>();
	try {
		conn = ConnectionFactory.getBasicConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,valueId);	
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			PERSON_SLRY slry=new PERSON_SLRY();
			slry.setFName(rs.getString("fname"));//专业类别
			slry.setFIdCertNo(rs.getString("fidcertno"));
			slry.setFEntName(rs.getString("fentname"));
			slry.setFCertType(rs.getString("fcerttype"));
			slry.setFEntName1(rs.getString("fentname1"));
			slry.setFCertNumber(rs.getString("fcertnumber"));
			slry.setFRegDate(rs.getString("fregdate"));
			slry.setFRegEndDate(rs.getString("fregenddate"));
			slry.setFState(rs.getString("fstate"));	
			list.add(slry);
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
